/**
 * VirtualFileSystem
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/28
 **/
package org.vf.core;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public class VDirectory extends AbstractFile {

    private final Set<File> children = new TreeSet<>(Comparator.comparing(File::getName));

    public VDirectory(String name, String description) {
        super(name, description);
    }

    @Override
    public Set<File> getChildren() {
        return new DirectoryView(children);
    }

    @Override
    public void addChildren(File file) {
        this.children.add(file);
    }

    @Override
    public void deleteChildren(File file) {
        this.children.remove(file);
    }

    @Override
    public boolean isFile() {
        return false;
    }

    static class DirectoryView extends TreeSet<File> {

        public DirectoryView(Collection<? extends File> c) {
            super(c);
        }

        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
        }

        @Override
        public File removeFirst() {
            throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
        }

        @Override
        public File removeLast() {
            throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
        }

        @Override
        public boolean removeIf(Predicate<? super File> filter) {
            throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
        }
    }
}
