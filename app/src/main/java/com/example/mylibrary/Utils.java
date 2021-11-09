package com.example.mylibrary;

import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * A Utility class for storing the users data.
 */
public class Utils {


    private static Utils instance;
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> previouslyReadBooks;
    private static ArrayList<Book> wishlistBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favouriteBooks;

    /**
     * On the creation of the Utils class, all ArrayLists are instantiated to an empty ArrayList.
     */
    private Utils() {
        if (allBooks == null) {
            allBooks = new ArrayList<>();
            initData();
        }

        if (previouslyReadBooks == null) {
            previouslyReadBooks = new ArrayList<>();
        }

        if (wishlistBooks == null) {
            wishlistBooks = new ArrayList<>();
        }

        if (currentlyReadingBooks == null) {
            currentlyReadingBooks = new ArrayList<>();
        }

        if (favouriteBooks == null) {
            favouriteBooks = new ArrayList<>();
        }
    }

    /**
     * Initializes data into the app.
     */
    private void initData() {
        //TODO: Replace with API calls to NYT Bestseller List and Google Books API for photos.
        allBooks.add(new Book(1, "Very Nice: A Novel", "Marcy Dermansky", 250, "https://img.buzzfeed.com/buzzfeed-static/static/2019-12/19/18/asset/3a6729677dba/sub-buzz-665-1576781603-2.jpg", "An autobiography of Marcy's life growing up.", "This is a longer description of the book that would go into more details than I'm able to here without any information." ));
        allBooks.add(new Book(2, "Book Cover Design Formula", "Anita Nipane", 400, "https://m.media-amazon.com/images/I/41gr3r3FSWL.jpg", "Create book covers that capivate readers.", "Here is a longer description for the book that goes into more depth about what the book is about." ));
        allBooks.add(new Book(3, "My Book Cover", "My Name Here", 400, "https://edit.org/images/cat/book-covers-big-2019101610.jpg", "Secrets in a Silicon Valley Startup.", "This is a long description." ));
    }

    /**
     * A single instance of the Utils class will only ever be instantiated.
     * Achieved using the singleton pattern.
     */
    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static void setAllBooks(ArrayList<Book> allBooks) {
        Utils.allBooks = allBooks;
    }

    public static ArrayList<Book> getPreviouslyReadBooks() {
        return previouslyReadBooks;
    }

    public static void setPreviouslyReadBooks(ArrayList<Book> previouslyReadBooks) {
        Utils.previouslyReadBooks = previouslyReadBooks;
    }

    public static ArrayList<Book> getWishlistBooks() {
        return wishlistBooks;
    }

    public static void setWishlistBooks(ArrayList<Book> wishlistBooks) {
        Utils.wishlistBooks = wishlistBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static void setCurrentlyReadingBooks(ArrayList<Book> currentlyReadingBooks) {
        Utils.currentlyReadingBooks = currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavouriteBooks() {
        return favouriteBooks;
    }

    public static void setFavouriteBooks(ArrayList<Book> favouriteBooks) {
        Utils.favouriteBooks = favouriteBooks;
    }

    public Book getBookById(int id) {
        for (Book b : allBooks) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public boolean addToCurrentlyReading(Book book) {
        return currentlyReadingBooks.add(book);
    }

    public boolean removeFromCurrentlyReading(Book book) {
        return currentlyReadingBooks.remove(book);
    }

    public boolean addToPreviouslyRead(Book book) {
        return previouslyReadBooks.add(book);
    }

    public boolean removeFromPreviouslyRead(Book book) {
        return previouslyReadBooks.remove(book);
    }

    public boolean addToWishlist(Book book) {
        return wishlistBooks.add(book);
    }

    public boolean removeFromWishlist(Book book) {
        return wishlistBooks.remove(book);
    }

    public boolean addToFavourites(Book book) {
        return favouriteBooks.add(book);
    }

    public boolean removeFromFavourites(Book book) {
        return favouriteBooks.remove(book);
    }
}
