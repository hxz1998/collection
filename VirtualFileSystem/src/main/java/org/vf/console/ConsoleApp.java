/**
 * VirtualFileSystem
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/29
 **/
package org.vf.console;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.vf.core.File;
import org.vf.core.VDirectory;
import org.vf.engine.SimpleVirtualFileSystemEngine;
import org.vf.engine.impl.SimpleVirtualFileSystemEngineImpl;

@Slf4j
public class ConsoleApp {

    private final SimpleVirtualFileSystemEngine engine = new SimpleVirtualFileSystemEngineImpl();

    public void exec(String command, String... args) {
        if (command.equals("create")) {
            if (args[1].equals("file")) {
                createFile(args[2]);
            } else if (args[1].equals("dir")) {
                createDirectory(args[2]);
            }
        } else if (command.equals("write")) {
            writeFile(args[1], args[2]);
        } else if (command.equals("read")) {
            System.out.println("FILE CONTENT: " + readFile(args[1]));
        }
    }

    private void writeFile(String filename, String content) {
        File file = engine.getFile(filename);
        if (null == file) {
            log.info("找不到指定文件：{}", filename);
            return;
        }
        file.write(content);
        log.info("写入文件：{} 成功", filename);
    }

    private String readFile(String filename) {
        File file = engine.getFile(filename);
        if (null == file) {
            log.info("找不到指定文件：{}", filename);
            return "";
        }
        String content = file.read();
        if (null != content) {
            log.info("读取文件：{} 成功", filename);
        }
        return content;
    }

    private void createDirectory(String directoryName) {
        engine.makeDirectory(engine.getRoot(), directoryName);
        log.info("创建文件夹：{} 成功", directoryName);
    }

    private void createFile(String filename) {
        engine.getRoot().getChildren().stream().filter(f -> f.getName().equals("test")).findAny().ifPresent(
            file -> {
                engine.makeFile((VDirectory) file, filename);
                log.info("创建文件：{} 成功", filename);
            }
        );
//        engine.makeFile(, filename);
//        log.info("创建文件：{} 成功", filename);
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("robot > ");
        String input;
        while (!(input = scanner.nextLine()).equals("quit")) {
            String[] command = input.split(" ");
            exec(command[0], command);
            System.out.print("robot > ");
        }
    }
}
