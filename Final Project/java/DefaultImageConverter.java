package com.example.javafinalproj;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

// This class implements the ImageConverter interface and provides default image conversion functionality using ImageIO.
public class DefaultImageConverter implements ImageConverter
{
    //region methods
    @Override
    public byte[] convert(File sourceFile, String format)
    {
        try
        {
            // Reading image using ImageIO
            BufferedImage bufferedImage = ImageIO.read(sourceFile);

            // Conversion
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, format.toLowerCase(), baos);
            baos.flush();

            return baos.toByteArray();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void convertSaveImage(File sourceFile, File outputFile, String format)
    {
        try
        {
            // Open and read the source image file
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            BufferedImage sourceImage = ImageIO.read(fileInputStream);
            fileInputStream.close();

            // Creating a new BufferedImage
            BufferedImage convertedImage = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_INT_RGB);

            // Drawing source image onto the new BufferedImage
            convertedImage.createGraphics().drawImage(sourceImage, 0, 0, Color.WHITE, null);

            // creating and writing the output file
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            boolean conversionSuccess = ImageIO.write(convertedImage, format.toLowerCase(), fileOutputStream);
            fileOutputStream.close();

            // checking if image writing was successful
            if (!conversionSuccess)
            {
                throw new IllegalStateException("Failed to write image in the specified format: " + format);
            }

            // Logging
            System.out.println("Image successfully converted and saved to " + outputFile.getAbsolutePath() + " in " + format + " format.");
        } catch (IOException e)
        {
            System.err.println("Error during image processing: " + e.getMessage());
        } catch (IllegalStateException e)
        {
            System.err.println("Failed to write image in the specified format: " + format);
        }
    }
    //endregion
}
