package com.java8.features.chap01.lambdaexpression;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.stream.Stream;

public class Lambda01 {

    static FileFilter fileFilter = new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.getName().endsWith(".txt");
        }
    };

    static FileFilter fileFilterLambda = (File file) -> file.getName().endsWith(".txt");

    public static void main(String[] args) {
        System.out.println("Using anonymous function");
        printFilteredFiles(fileFilter);

        System.out.println("Using lambda function");
        printFilteredFiles(fileFilterLambda);
    }

    public static void printFilteredFiles(FileFilter fileFilter) {
        File dir = new File(Lambda01.class.getResource("/testDir").getFile());
        File[] txtFiles = dir.listFiles(fileFilter);

        // 1st way to print out file names
        Stream<File> stream = Arrays.stream(txtFiles);
        stream.forEach(p -> System.out.println(p.getName()));

        // 2nd way to print out file names
        //stream.forEach(System.out::println);

        // 3rd way to print out file names
        /* for (File file : txtFiles) {
            System.out.println(file.getName());
        }*/
    }
}
