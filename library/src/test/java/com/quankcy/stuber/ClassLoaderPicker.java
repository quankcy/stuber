package com.quankcy.stuber;

import lombok.Getter;

public class ClassLoaderPicker {
    @Getter
    private final String packageName;

    @Getter
    private final String packageRelativeDirectory;

    public ClassLoaderPicker() {
        this.packageName = ClassLoaderPicker.class.getPackageName();
        this.packageRelativeDirectory = this.packageName.replaceAll("[.]", "/");
//        Thread.currentThread().getStackTrace()
//        ClassLoaderPicker.class
//        ClassLoader.getSystemClassLoader()
    }
}
