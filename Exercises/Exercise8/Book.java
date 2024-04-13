package org.example;

public class Book
{
    //region properties
    private String title;
    private String publishedYear;
    private String numberOfPages;
    private String[] authors;
    //endregion

    //region constructor
    public Book(String title, String publishedYear, String numberOfPages, String[] authors)
    {
        this.title = title;
        this.publishedYear = publishedYear;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }
    //endregion

    //region methods
    public String getTitle() {
        return title;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public String[] getAuthors() {
        return authors;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "title='" + title + '\'' +
                ", publishedYear='" + publishedYear + '\'' +
                ", numberOfPages='" + numberOfPages + '\'' +
                ", authors=" + String.join(", ", authors) +
                '}';
    }
    //endregion
}