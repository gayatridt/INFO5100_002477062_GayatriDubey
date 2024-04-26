package com.example.javafinalproj;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

// This class represents a processor for handling image conversion and processing tasks.
public class ImageProcessor
{
    //region properties
    private ImageConverter imageConverter;
    //endregion

    //region constructor
    public ImageProcessor(ImageConverter imageConverter)
    {
        this.imageConverter = imageConverter;
    }
    //endregion

    //region methods
    // method to process an image by converting it to the specified format and saving it to the output file.
    public void processImage(File sourceFile, File outputFile, String format) {
        try {
            // Call the conversion method in the ImageConverter class
            imageConverter.convertSaveImage(sourceFile, outputFile, format);

            // Log successful image conversion
            System.out.println("Image successfully converted and saved to " + outputFile.getAbsolutePath() + " in " + format + " format.");
        } catch (IllegalStateException e)
        {
            // Handle other exceptions (e.g., failed to write image)
            System.err.println("Failed to process image: " + e.getMessage());
        }
    }
    //endregion
}
