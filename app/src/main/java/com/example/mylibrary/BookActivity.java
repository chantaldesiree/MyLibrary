package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * BookActivity shows the expanded information for a single Book.
 */
public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private TextView txtBookName, txtAuthor, txtPages, txtDescription;
    private Button btnAddWishlist, btnAddPreviouslyRead, btnAddToCurrentlyReading, btnAddToFavourites;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        Intent intent = getIntent();
        if (intent != null) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1) {
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if (incomingBook != null) {
                    setData(incomingBook);

                    handlePreviouslyRead(incomingBook);
                    handleWishlistBooks(incomingBook);
                    handleFavouriteBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                }
            }
        }
    }

    /**
     * Enable and Disable favourites button,
     * Add the book to the Favourites Book ArrayList.
     * @param book
     */
    private void handleCurrentlyReadingBooks(Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getCurrentlyReadingBooks();

        boolean existsInCurrentlyReading = false;

        for (Book b: currentlyReadingBooks) {
            if (b.getId() == book.getId()) {
                existsInCurrentlyReading = true;
            }
        }

        if (existsInCurrentlyReading) {
            btnAddToCurrentlyReading.setEnabled(false);
        } else {
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToCurrentlyReading(book)) {
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(BookActivity.this, "Something happened, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /**
     * Enable and Disable favourites button,
     * Add the book to the Favourites Book ArrayList.
     * @param book
     */
    private void handleFavouriteBooks(Book book) {
        ArrayList<Book> favouriteBooks = Utils.getInstance().getFavouriteBooks();

        boolean existsInFavouriteBooks = false;

        for (Book b: favouriteBooks) {
            if (b.getId() == book.getId()) {
                existsInFavouriteBooks = true;
            }
        }

        if (existsInFavouriteBooks) {
            btnAddToFavourites.setEnabled(false);
        } else {
            btnAddToFavourites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToFavourites(book)) {
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, FavouritesActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(BookActivity.this, "Something happened, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /**
     * Enable and Disable wishlist button,
     * Add the book to the Wishlist Book ArrayList.
     * @param book
     */
    private void handleWishlistBooks(final Book book) {
        ArrayList<Book> wishlistBooks = Utils.getInstance().getWishlistBooks();

        boolean existsInWishlistBooks = false;

        for (Book b: wishlistBooks) {
            if (b.getId() == book.getId()) {
                existsInWishlistBooks = true;
            }
        }

        if (existsInWishlistBooks) {
            btnAddWishlist.setEnabled(false);
        } else {
            btnAddWishlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToWishlist(book)) {
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, WishlistActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(BookActivity.this, "Something happened, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /**
     * Enable and Disable previously read button,
     * Add the book to the Previously Read Book ArrayList.
     * @param book
     */
    private void handlePreviouslyRead(Book book) {
        ArrayList<Book> previouslyReadBooks = Utils.getInstance().getPreviouslyReadBooks();

        boolean existsInPreviouslyReadBooks = false;

        for (Book b: previouslyReadBooks) {
            if (b.getId() == book.getId()) {
                existsInPreviouslyReadBooks = true;
            }
        }

        if (existsInPreviouslyReadBooks) {
            btnAddPreviouslyRead.setEnabled(false);
        } else {
            btnAddPreviouslyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToPreviouslyRead(book)) {
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, PreviouslyReadBookActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(BookActivity.this, "Something happened, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /**
     * Initializes the Views on the page.
     */
    private void initViews() {
        txtAuthor = findViewById(R.id.txtAuthorNameSingle);
        txtBookName = findViewById(R.id.txtBookNameSingle);
        txtDescription = findViewById(R.id.txtLongDescriptionSingle);
        txtPages = findViewById(R.id.txtPagesSingle);

        btnAddPreviouslyRead = findViewById(R.id.btnAddPreviouslyRead);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddCurrentlyReading);
        btnAddToFavourites = findViewById(R.id.btnAddFavourites);
        btnAddWishlist = findViewById(R.id.btnAddWishlist);

        bookImage = findViewById(R.id.imgBookSingle);
    }

    /**
     * Sets the data of the specific Book.
     * @param book
     */
    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDescription());

        Glide.with(this).asBitmap().load(book.getImageUrl()).into(bookImage);
    }
}