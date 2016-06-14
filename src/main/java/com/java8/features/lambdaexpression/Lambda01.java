package com.java8.features.lambdaexpression;

import java.io.File;
import java.io.FileFilter;

public class Lambda01 {

    static FileFilter fileFilter = new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.getName().endsWith(".pdf");
        }
    };

    static FileFilter fileFilterLambda = (File file) -> file.getName().endsWith(".pdf");

    public static void main(String[] args) {
      printFilteredFiles(fileFilter);
      printFilteredFiles(fileFilterLambda);
    }

    public static void printFilteredFiles(FileFilter fileFilter) {
        File dir = new File("C:/Users/Shubo/Desktop/temp");
        File[] javaFiles = dir.listFiles(fileFilter);

        for (File file : javaFiles) {
            System.out.println(file);
        }
    }
}
