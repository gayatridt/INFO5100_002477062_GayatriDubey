package com.example.javafinalproj;

import java.io.File;
import java.io.IOException;

// This interface defines a contract for classes that can convert images.
public interface ImageConverter
{
    //region methods
    // Method to convert an image file to a byte array in the specified format.
    byte[] convert(File sourceFile, String format);

    // Method to convert and save an image file
    void convertSaveImage(File sourceFile, File outputFile, String format);
        //endregion
}
