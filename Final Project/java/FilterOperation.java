package com.example.javafinalproj;

import javafx.scene.image.Image;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;

// This class represents a filter operation that applies color adjustments and specific effects on images.
public class FilterOperation extends ImageOperation
{
    //region properties
    private double brightness;
    private double contrast;
    private double saturation;
    private String selectedFilter;
    //endregion

    //region constructor
    public FilterOperation(double brightness, double contrast, double saturation, String selectedFilter)
    {
        this.brightness = brightness;
        this.contrast = contrast;
        this.saturation = saturation;
        this.selectedFilter = selectedFilter;
    }
    //endregion

    //region methods
    //method to create filter effects
    @Override
    public Image applyOperation(Image image)
    {
        // ColorAdjust filter
        ColorAdjust filter = new ColorAdjust();
        filter.setBrightness(brightness);
        filter.setContrast(contrast);
        filter.setSaturation(saturation);

        if (selectedFilter != null && !selectedFilter.equals("None"))
        {
            switch (selectedFilter)
            {
                case "Black and White":
                    filter.setSaturation(-1);
                    break;
                case "Sepia":
                    filter.setHue(0.1);
                    filter.setSaturation(0.9);
                    filter.setBrightness(-0.1);
                    break;
            }
        }

        return applyFilter(image, filter);
    }

    // method to apply the filter on the image.
    private Image applyFilter(Image image, ColorAdjust filter)
    {
        ImageView tempImageView = new ImageView(image);
        tempImageView.setEffect(filter);
        return tempImageView.snapshot(null, null);
    }
    //endregion
}

