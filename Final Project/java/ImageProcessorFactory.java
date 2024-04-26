package com.example.javafinalproj;

// This class represents a factory for creating ImageProcessor instances.
public class ImageProcessorFactory
{
    //region methods
    public static ImageProcessor createImageProcessor(ImageConverter imageConverter)
    {
        return new ImageProcessor(imageConverter);
    }
    //endregion
}
