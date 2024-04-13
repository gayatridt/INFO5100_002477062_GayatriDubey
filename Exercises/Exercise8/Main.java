package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        try {
            // File paths for JSON and XML files
            File jsonFile = new File("src/main/resources/books.json");
            File xmlFile = new File("src/main/resources/books.xml");

            // Parsing JSON and XML files
            List<Book> jsonBooks = parseJSON(jsonFile);
            List<Book> xmlBooks = parseXML(xmlFile);

            // Printing JSON and XML data before adding new book
            System.out.println("Parsed JSON Data Before Adding New Book:");
            for (Book book : jsonBooks) {
                System.out.println(book);
            }

            System.out.println("\nParsed XML Data Before Adding New Book:");
            for (Book book : xmlBooks) {
                System.out.println(book);
            }

            // Adding a new book
            Book newBook =  new Book("The Notebook", "1996", "Varies by edition, typically around 224 pages", new String[]{"Nicholas Sparks"});
            jsonBooks.add(newBook);
            xmlBooks.add(newBook);

            // Writing a new updated JSON and XML files with added book
            writeJSON(jsonBooks, "updated_books.json");
            writeXML(xmlBooks, "updated_books.xml");

            // Printing JSON and XML data after adding new book
            System.out.println("\nParsed JSON Data After Adding New Book:");
            for (Book book : jsonBooks) {
                System.out.println(book);
            }

            System.out.println("\nParsed XML Data After Adding New Book:");
            for (Book book : xmlBooks) {
                System.out.println(book);
            }

        }
        catch (IOException | TransformerException | ParserConfigurationException e)
        {
            e.printStackTrace();
        }
    }

    //region methods
    // Method to parse JSON file and return the list of books
    private static List<Book> parseJSON(File file) throws IOException
    {
        List<Book> lstBooks = new ArrayList<>();
        if (file.exists() && file.length() > 0)
        {
            ObjectMapper objectMapper = new ObjectMapper();  // ObjectMapper instance to read JSON data
            JsonNode rootNode = objectMapper.readTree(file).get("BookShelf");  // Reading JSON file and navigating to the "BookShelf" node

            if (rootNode != null && rootNode.has("Book") && rootNode.get("Book").isArray())
            {
                JsonNode bookArray = rootNode.get("Book"); // Navigating to the array of books
                for (JsonNode node : bookArray)
                {
                    // Getting book details from JSON node
                    JsonNode titleNode = node.get("title");
                    JsonNode publishedYearNode = node.get("publishedYear");
                    JsonNode numberOfPagesNode = node.get("numberOfPages");
                    JsonNode authorsNode = node.get("authors").get("author");

                    // All required fields are present
                    if (titleNode != null && publishedYearNode != null && numberOfPagesNode != null && authorsNode != null)
                    {
                        // Converting JSON node values to String
                        String strTitle = titleNode.asText();
                        String strPublishedYear = publishedYearNode.asText();
                        String strNumberOfPages = numberOfPagesNode.asText();
                        String[] strAuthors = authorsNode.isArray() ?
                                objectMapper.convertValue(authorsNode, String[].class) :
                                new String[]{authorsNode.asText()};

                        lstBooks.add(new Book(strTitle, strPublishedYear, strNumberOfPages, strAuthors));
                    }
                }
            }
        }
        return lstBooks;
    }

    // Method to parse XML file and return the list of books
    private static List<Book> parseXML(File file) throws IOException, ParserConfigurationException
    {
        List<Book> lstBooks = new ArrayList<>();
        try {
            // DocumentBuilder instance to parse XML data
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parsing XML file into Document object
            Document doc = builder.parse(file);
            // Getting list of "Book" elements
            NodeList nodeList = doc.getElementsByTagName("Book");

            // Extracting book details
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Element bookElement = (Element) nodeList.item(i);
                String strTitle = bookElement.getElementsByTagName("title").item(0).getTextContent();
                String strPublishedYear = bookElement.getElementsByTagName("publishedYear").item(0).getTextContent();
                String strNumberOfPages = bookElement.getElementsByTagName("numberOfPages").item(0).getTextContent();
                NodeList authorsNodeList = bookElement.getElementsByTagName("author");
                List<String> strAuthors = new ArrayList<>();
                for (int j = 0; j < authorsNodeList.getLength(); j++)
                {
                    strAuthors.add(authorsNodeList.item(j).getTextContent());
                }

                lstBooks.add(new Book(strTitle, strPublishedYear, strNumberOfPages, strAuthors.toArray(new String[0])));
            }
        } catch (SAXException e)
        {
            System.err.println("Error parsing XML: " + e.getMessage());
        }
        return lstBooks;
    }

    // Method to write list of books to a JSON file
    private static void writeJSON(List<Book> books, String filename) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();
        ArrayNode bookArray = objectMapper.createArrayNode(); // Array node for books

        // Iterating over list of books
        for (Book book : books)
        {
            ObjectNode bookNode = objectMapper.createObjectNode();
            bookNode.put("title", book.getTitle());
            bookNode.put("publishedYear", book.getPublishedYear());
            bookNode.put("numberOfPages", book.getNumberOfPages());

            ArrayNode authorsArray = objectMapper.createArrayNode();
            for (String author : book.getAuthors())
            {
                authorsArray.add(author);
            }

            bookNode.set("authors", authorsArray);
            bookArray.add(bookNode);
        }

        rootNode.set("Book", bookArray);
        ObjectNode bookShelfNode = objectMapper.createObjectNode();
        bookShelfNode.set("BookShelf", rootNode);

        // Writing JSON data to file
        objectMapper.writeValue(new File(filename), bookShelfNode);
    }

    // Method to write list of book to an XML file
    private static void writeXML(List<Book> books, String filename) throws ParserConfigurationException, TransformerException
    {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("BookShelf");
        doc.appendChild(rootElement);

        // Iterating over list of books
        for (Book book : books)
        {
            Element bookElement = doc.createElement("Book");
            rootElement.appendChild(bookElement);

            Element titleElement = doc.createElement("title");
            titleElement.appendChild(doc.createTextNode(book.getTitle()));
            bookElement.appendChild(titleElement);

            Element publishedYearElement = doc.createElement("publishedYear");
            publishedYearElement.appendChild(doc.createTextNode(book.getPublishedYear()));
            bookElement.appendChild(publishedYearElement);

            Element numberOfPagesElement = doc.createElement("numberOfPages");
            numberOfPagesElement.appendChild(doc.createTextNode(book.getNumberOfPages()));
            bookElement.appendChild(numberOfPagesElement);

            for (String author : book.getAuthors())
            {
                Element authorElement = doc.createElement("author");
                authorElement.appendChild(doc.createTextNode(author));
                bookElement.appendChild(authorElement);
            }
        }

        // Writing XML data to file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filename));
        transformer.transform(source, result);
    }
    //endregion
}
