/**
 * VirtualFileSystem
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/28
 **/
package org.vf.core;

public abstract class AbstractFile implements File {

    private String name;
    private boolean toBeDeleted;
    private String description;

    public AbstractFile(String name, String description) {
        this.name = name;
        this.description = description;
        toBeDeleted = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void rename(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean toBeDeleted() {
        return toBeDeleted;
    }

    @Override
    public void delete() {
        this.toBeDeleted = true;
    }

    @Override
    public int compareTo(File o) {
        return this.getName().compareTo(o.getName());
    }
}
