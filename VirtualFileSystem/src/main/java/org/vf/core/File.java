/**
 * VirtualFileSystem
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/28
 **/
package org.vf.core;

import java.util.Set;

public interface File extends Comparable<File> {

    String UNSUPPORTED_OPERATION = "不支持的操作！";

    String getName();

    void rename(String name);

    boolean isFile();

    String getDescription();

    void setDescription(String description);

    boolean toBeDeleted();

    void delete();

    default boolean isOpen() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    default void open() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    default void close() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    /**
     * 文件操作
     */
    default String read() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    default void write(String data) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    default void append(String data) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    /**
     * 目录操作
     */
    default Set<File> getChildren() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    default void addChildren(File file) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

    default void deleteChildren(File file) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }
}
