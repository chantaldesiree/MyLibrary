package com.example.mylibrary;

/**
 * Book class contains all of the properties and methods of a Book.
 */
public class Book {
    private int id;
    private String name;
    private String author;
    private int pages;
    private String imageUrl;
    private String shortDescription;
    private String longDescription;
    private boolean isExpanded;

    /**
     * Book constructor:
     * @param id The books ID.
     * @param name The name of the book.
     * @param author The author of the book.
     * @param pages The number of pages in the book.
     * @param imageUrl The URL to the book's cover.
     * @param shortDescription The short description of the book.
     * @param longDescription The long description of the book.
     */
    public Book(int id, String name, String author, int pages, String imageUrl, String shortDescription, String longDescription) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.imageUrl = imageUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.isExpanded = false;
    }

    /**
     * The formatted book's toString.
     * @return Returns a formatted version of the books properties.
     */
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", imageUrl='" + imageUrl + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                '}';
    }

    /**
     * The state of the books menu.
     * @return Returns if the menu is expanded.
     */
    public boolean isExpanded() {
        return isExpanded;
    }

    /**
     * Changes the state of the books menu.
     * @param expanded Sets the state of the menu to the boolean passed.
     */
    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    /**
     * Gets the ID of the book.
     * @return Returns the ID of the book.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the book.
     * @param id The new id of the book to be set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the book.
     * @return Returns the name of the book.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the book.
     * @param name The new name of the book to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the author of the book.
     * @return Returns the author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     * @param author The new author of the book to be set.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the number of pages in the book.
     * @return Returns the number of pages in the book.
     */
    public int getPages() {
        return pages;
    }

    /**
     * Sets the number of pages in the book.
     * @param pages The new number of pages in the book to be set.
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * Gets the URL for the books cover.
     * @return Returns the URL for the books cover.
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the URL for the books cover.
     * @param imageUrl The new URL for the books cover to be set.
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Gets the short description of the book.
     * @return Returns the short description of the book.
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Set the short description of the book.
     * @param shortDescription The new short description of the book to be set.
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Gets the long description of the book.
     * @return Returns the long description of the book.
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * Sets the long description of the book.
     * @param longDescription The new long description of the book to be set.
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}

