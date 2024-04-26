package com.example.javafinalproj;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Main controller for the Application.
public class MainController
{
    //region properties
    private ImageProcessor imageProcessor;
    private ImageConverter imageConverter;
    private FilterOperation filterOperation;
    @FXML
    private ListView<File> imageListView;

    @FXML
    private ImageView selectedImageView;

    @FXML
    private Slider brightnessSlider;

    @FXML
    private Slider contrastSlider;

    @FXML
    private Slider saturationSlider;

    @FXML
    private ChoiceBox<String> filterChoiceBox;

    @FXML
    private Label propertiesLabel;

    @FXML
    private Label msgLabel;

    @FXML
    private ChoiceBox<String> formatChoiceBox;

    private Map<File, FilterOperation> filterMap = new HashMap<>();

    private List<Image> selectedImages = new ArrayList<>();
    private File selectedFile;
    //endregion

    //region constructor
    public MainController()
    {
        this.imageConverter = new DefaultImageConverter();
        // Creating an ImageProcessor using the ImageProcessorFactory
        this.imageProcessor = ImageProcessorFactory.createImageProcessor(imageConverter);
    }
    //endregion

    //region methods
    @FXML
    private void initialize()
    {
        // Setting up image list view
        imageListView.setCellFactory(param -> new ListCell<File>() {
            @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName()); // Display only the file name
                }
            }
        });
        // Updating selected file and image when a new file is selected from the list view
        imageListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null)
            {
                selectedFile = newVal; // Update to selectedFile
                try {
                    Image image = new Image(newVal.toURI().toString());
                    selectedImageView.setImage(image);
                    selectedImages.clear();
                    selectedImages.add(image);
                    displayImageProperties(image);
                    msgLabel.setText("");
                    resetFilters();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    // method to upload images
    @FXML
    private void uploadImage()
    {
        // File chooser for selecting images
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload Images");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp")
        );
        // Allowing multiple files to be selected
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(null);
        if (selectedFiles != null)
        {
            for (File file : selectedFiles)
            {
                try
                {
                    Image image = new Image(file.toURI().toString());
                    selectedImages.add(image);
                    imageListView.getItems().add(file);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    // method to reset filters
    private void resetFilters() {
        brightnessSlider.setValue(0);
        contrastSlider.setValue(0);
        saturationSlider.setValue(0);
        filterChoiceBox.setValue("None");
        selectedImageView.setEffect(null);
    }

    // Method to convert image
    @FXML
    public void convertImage()
    {
        if (selectedFile != null && formatChoiceBox.getValue() != null)
        {
            String selectedFormat = formatChoiceBox.getValue().toLowerCase();
            byte[] convertedImageData = imageConverter.convert(selectedFile, selectedFormat);
            if (convertedImageData != null)
            {
                msgLabel.setText("Image converted successfully. Ready for download.");
            } else
            {
                msgLabel.setText("Failed to convert image.");
            }
        } else
        {
            msgLabel.setText("Please select an image and format to convert.");
        }
    }

    //method to download converted image
    @FXML
    public void downloadImage()
    {
        // Check if there is a selected file and a chosen format
        if (selectedFile != null && formatChoiceBox.getValue() != null)
        {
            String format = formatChoiceBox.getValue().toLowerCase();
            File saveFile = getSaveFile(format);

            if (saveFile != null)
            {
                // Process and save the image using the specified format
               imageProcessor.processImage(selectedFile, saveFile, format);

                msgLabel.setText("Converted image downloaded successfully!");
            } else
            {
                msgLabel.setText("Please select a location to save the image.");
            }
        } else {
            msgLabel.setText("Please select an image and a format to download.");
        }
    }

    // saving the file
    private File getSaveFile(String format)
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image As");

        // original image file name with a "converted_" prefix
        String originalFileName = selectedFile.getName();
        String convertedFileName = "converted_" + originalFileName;
        fileChooser.setInitialFileName(convertedFileName);

        // file extension based on selected format
        fileChooser.getExtensionFilters().add(new ExtensionFilter(format.toUpperCase() + " files", "*." + format));
        return fileChooser.showSaveDialog(null);
    }

    // method to apply filters
    @FXML
    private void applyFilters() {
        File selectedFile = imageListView.getSelectionModel().getSelectedItem();
        if (selectedFile != null) {
            // getting currently selected image
            Image selectedImage = selectedImageView.getImage();

            // FilterOperation instance with the specified parameters
            FilterOperation filterOperation = new FilterOperation(
                    brightnessSlider.getValue(),
                    contrastSlider.getValue(),
                    saturationSlider.getValue(),
                    filterChoiceBox.getValue()
            );

            Image filteredImage = filterOperation.applyOperation(selectedImage);

            // Setting the filtered image to be displayed
            selectedImageView.setImage(filteredImage);

            // Storing the filter operation for further processing or download
            filterMap.put(selectedFile, filterOperation);
        }
    }

    // Method to download filtered image
    @FXML
    private void downloadFilteredImage()
    {
        // getting selected file from the ListView
        File selectedFile = imageListView.getSelectionModel().getSelectedItem();

        if (selectedFile == null)
        {
            msgLabel.setText("Please select an image to download.");
            return;
        }

        // getting filter operation for the selected image
        FilterOperation filterOperation = filterMap.get(selectedFile);

        if (filterOperation == null)
        {
            msgLabel.setText("No filter applied to this image.");
            return;
        }

        // applying filter operation to the selected image
        Image filteredImage = filterOperation.applyOperation(selectedImageView.getImage());

        if (filteredImage == null) {
            msgLabel.setText("No filtered image to download.");
            return;
        }

        // saving the filtered image
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Filtered Image As");

        // filename with filtered prefix
        String originalFileName = selectedFile.getName();
        String filteredFileName = "filtered_" + originalFileName;
        fileChooser.setInitialFileName(filteredFileName);

        // fetching file extension from the original file
        int lastDotIndex = originalFileName.lastIndexOf('.');
        String fileExtension = (lastDotIndex > 0 && lastDotIndex < originalFileName.length() - 1)
                ? originalFileName.substring(lastDotIndex + 1).toLowerCase()
                : "png"; // default to PNG if extension not found

        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*." + fileExtension));

        // choosing a location to save the file
        File saveFile = fileChooser.showSaveDialog(null);

        // Ensure the user selected a location to save the file
        if (saveFile == null)
        {
            msgLabel.setText("Download canceled by user.");
            return;
        }

        // Save the filtered image
        try
        {
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(filteredImage, null);

            BufferedImage rgbImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = rgbImage.createGraphics();
            graphics.drawImage(bufferedImage, 0, 0, Color.WHITE, null);
            graphics.dispose();

            // write the image to the output file in the specified format
            boolean conversionSuccess = ImageIO.write(rgbImage, fileExtension, saveFile);

            if (conversionSuccess)
            {
                msgLabel.setText("Filtered image downloaded successfully.");
            } else
            {
                msgLabel.setText("Error downloading filtered image: Conversion failed.");
            }
        } catch (IOException e)
        {
            e.printStackTrace();
            msgLabel.setText("Error downloading filtered image: " + e.getMessage());
        }
    }

    // Method to display image properties
    @FXML
    private void displayImageProperties(Image image)
    {
        if (image != null) {
            double height = image.getHeight();
            double width = image.getWidth();
            String location = image.getUrl();

            propertiesLabel.setText("Height: " + height + " pixels\nWidth: " + width + " pixels\nLocation: " + location + "\nDimension: " + width + "x" + height);
        } else {
            propertiesLabel.setText("No image selected.");
        }
    }
    //endregion
}
