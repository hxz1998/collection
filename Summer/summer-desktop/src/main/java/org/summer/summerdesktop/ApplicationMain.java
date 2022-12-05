/**
 * Summer
 *
 * @Description: 应用的启动类
 * @Author: cherry
 * @Create on: 2022/6/24
 **/
package org.summer.summerdesktop;


import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationMain {
    public static void main(String[] args) {
        Application.launch(SummerApplication.class);
        /*
         * 以下程序用来进行分发测试
         */
        /*LocalDate date = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM:dd");
        if (date.format(format).contains("6:25")) {
            Application.launch(SummerApplication.class);
        }
        try {
            File file = new File("summer-desktop-1.0-SNAPSHOT-jar-with-dependencies.jar");
            log.debug(file.getAbsoluteFile().getAbsolutePath());
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeBytes("文件已失效");
            dataOutputStream.close();
            boolean result = file.delete();
            if (result) System.exit(0);
            System.gc();
            file.deleteOnExit();
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("出现了异常，但是可以忽略");
        }*/
    }
}
