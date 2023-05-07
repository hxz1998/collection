/**
 * CommandToolBox
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/5/7
 **/
package org.example.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SumatraPDFReader implements PDFReader {
    private String sumatra = "D:\\Apps\\SumatraPDF\\SumatraPDF-3.4.6-64.exe";

    @Override
    public boolean read(String filename) {
        try {
            // 构建命令行参数
            List<String> commandList = new ArrayList<>();
            commandList.add(sumatra);
            // commandList.add("-reuse-instance"); // 复用已有的 SumatraPDF 进程
            commandList.add(filename);

            // 使用 ProcessBuilder 启动 SumatraPDF 进程
            ProcessBuilder processBuilder = new ProcessBuilder(commandList);
            Process process = processBuilder.start();

            // 等待 SumatraPDF 进程执行完毕
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("SumatraPDF execution failed with exit code " + exitCode);
                InputStream error = process.getErrorStream();
                byte[] msg = error.readAllBytes();
                System.out.println(new String(msg));
                InputStream info = process.getInputStream();
                msg = info.readAllBytes();
                System.out.println(new String(msg));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
