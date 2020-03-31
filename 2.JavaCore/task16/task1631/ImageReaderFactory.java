package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes){
        ImageReader result;
        if (imageTypes == null) throw new IllegalArgumentException();
        switch (imageTypes){
            case JPG:
                result = new JpgReader();
                break;
            case BMP:
                result = new BmpReader();
                break;
            case PNG:
                result = new PngReader();
                break;
            default: throw new IllegalArgumentException();
        }
        return result;
    }
}
