/**
 * VirtualFileSystem
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/28
 **/
package org.vf.engine;

import org.vf.core.File;
import org.vf.core.VDirectory;
import org.vf.core.VFile;

public interface SimpleVirtualFileSystemEngine {

    void add(VDirectory directory, File file);

    void delete(VDirectory directory, File file);

    VDirectory makeDirectory(VDirectory directory, String directoryName);

    File makeFile(VDirectory directory, String filename);

    VDirectory getRoot();

    File getDirectory(String pathString);

    File getFile(String pathString);
}
