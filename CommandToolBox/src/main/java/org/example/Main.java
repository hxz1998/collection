package org.example;

import org.example.app.PDFReader;
import org.example.app.SumatraPDFReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PDFReader reader = new SumatraPDFReader();
        reader.read("D:\\master\\main.pdf");
    }
}