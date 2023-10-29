/**
 * VirtualFileSystem
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/28
 **/
package org.vf.core;

import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VFile extends AbstractFile {

    private byte[] data;
    private boolean isOpen;
    private int cursor; // 下一个可以插入的位置
    private static final int INCREMENT_SIZE = 1024;

    public VFile(String name, String description) {
        super(name, description);
        isOpen = false;
        this.data = new byte[1024];
        this.cursor = 0;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public boolean isOpen() {
        return this.isOpen;
    }

    @Override
    public void open() {
        this.isOpen = true;
    }

    @Override
    public void close() {
        this.isOpen = false;
    }

    @Override
    public String read() {
        byte[] content = new byte[cursor];
        System.arraycopy(this.data, 0, content, 0, cursor);
        return new String(content, StandardCharsets.UTF_8);
    }

    @Override
    public void write(String data) {
        byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
        int length = dataBytes.length;
        if (length > this.data.length) {
            this.data = data.getBytes(StandardCharsets.UTF_8);
            cursor = this.data.length;
        } else {
            System.arraycopy(dataBytes, 0, this.data, 0, dataBytes.length);
            cursor += dataBytes.length;
        }
    }

    @Override
    public void append(String content) {
        int dataLength = this.data.length;
        byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
        // 目前支持支 int 大小的块
        if (dataLength - cursor < contentBytes.length) {
            byte[] buffer = new byte[dataLength + INCREMENT_SIZE];
            log.info("当前大小：{}，新内容大小：{}， 扩容后大小：{}", dataLength, contentBytes.length, buffer.length);
            // 先把之前的数据复制过来
            System.arraycopy(this.data, 0, buffer, 0, this.data.length);
            // 然后把新内容复制进去
            System.arraycopy(contentBytes, 0, buffer, cursor, contentBytes.length);
            this.data = buffer;
        } else {
            System.arraycopy(contentBytes, 0, this.data, cursor, contentBytes.length);
        }
        cursor += contentBytes.length;
    }
}
