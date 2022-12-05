/**
 * Summer
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/7/18
 **/
package org.summer.summerdesktop;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Slf4j
public class ThreadDumpViewController {

    @FXML
    TextArea threadDumpInfo;
    @FXML
    Button printPDF;

    private String info;

    public void setThreadDumpInfo(String info) {
        this.info = info;
        threadDumpInfo.setText(info);
    }

    public void onClickPrintPDF() {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("选择保存文件");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("PDF", "*.pdf")
            );
            File file = fileChooser.showSaveDialog(SummerApplication.getSTage());
            Font courierFont = new Font(Font.FontFamily.COURIER, 10);
            Font courierFontLarge = new Font(Font.FontFamily.COURIER, 18);
            FileOutputStream fos = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter write = PdfWriter.getInstance(doc, fos);
            doc.open();
            Paragraph title = new Paragraph("Thread Dump", courierFontLarge);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setLeading(30);
            doc.add(title);
            Paragraph paragraph = new Paragraph("", courierFont);
            doc.addTitle("Thread Dump");
            doc.addAuthor("Cherry");
            doc.addSubject("Thread Dump Analysis");
            doc.addCreationDate();
            doc.addCreator("Summer");
            paragraph.setLeading(13f);
            Chunk chunk = new Chunk(info);
            paragraph.add(chunk);
            doc.add(paragraph);
            write.close();
            doc.close();
            log.debug("保存完成");
        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
