# java-8-features

Module-01
Lambda expression: 
* To make instances of anonymous classes easier to write and read.
* Another way to write anonymous classes

```java
public interface FileFilter{
    boolean accept(File file);
}

public class JavaFileFilter implements FileFilter{
    public boolean accept(File file) {
        return file.getName().endsWith(".java");
    }
}

// use it

JavaFileFilter fileFilter = new JavaFileFilter();
File dir = new File("d:/tmp");
File[] javaFiles = dir.listFiles(fileFilter)
```

```java
//Use an anonymous class
FileFilter fileFilter = new FileFilter() {
    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(".java");
    }
};

File dir = new File("d:/tmp");
File[] javaFiles = dir.listFiles(fileFilter)
```

```java
// Lambda expression

FileFilter filter = (File file) -> file.getName().endsWith(".java");
```

The lambda syntax

Functional interfaces

Method references

Constructor references

How to process data from the Collection API
