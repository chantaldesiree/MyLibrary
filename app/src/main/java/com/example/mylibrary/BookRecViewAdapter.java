package com.example.mylibrary;

import static com.example.mylibrary.BookActivity.BOOK_ID_KEY;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * BookRecViewAdapter creates the layout and the functionality
 * for the Book Cards.
 */
public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder> {

    private ArrayList<Book> books = new ArrayList<>();
    private Context mContext;
    private String parentActivity;

    /**
     * Gives the adapter context and the activity which is calling the adapter.
     * @param mContext
     * @param parentActivity
     */
    public BookRecViewAdapter(Context mContext, String parentActivity) {
        this.mContext = mContext;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtBookName.setText(books.get(position).getName());

        Glide.with(mContext).asBitmap().load(books.get(position).getImageUrl()).into(holder.imgBook);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BookActivity.class);
                intent.putExtra(BOOK_ID_KEY, books.get(position).getId());
                mContext.startActivity(intent);
            }
        });

        /**
         * Toggles expand functionality for showing details.
         */
        if (books.get(position).isExpanded()) {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
            if (parentActivity.equals("allBooks")) {
                holder.btnDelete.setVisibility(View.GONE);
            }

            /**
             * Sets onClickListeners for the delete functionality for all except
             * the AllBooks Activity.
             */
            switch (parentActivity) {
                case "allBooks":
                    holder.btnDelete.setVisibility(View.GONE);
                    break;
                case "currentlyReading":
                    holder.btnDelete.setOnClickListener(new View.OnClickListener() {

                    String bookName = books.get(position).getName();

                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete " + bookName + "?");
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromCurrentlyReading(books.get(position))) {
                                    Toast.makeText(mContext, bookName + " was removed!", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else {
                                    Toast.makeText(mContext, "Something went wrong, please try again.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        builder.create().show();
                    }
                });
                    break;
                case "favourites": holder.btnDelete.setOnClickListener(new View.OnClickListener() {

                    String bookName = books.get(position).getName();

                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete " + bookName + "?");
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromFavourites(books.get(position))) {
                                    Toast.makeText(mContext, bookName + " was removed!", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else {
                                    Toast.makeText(mContext, "Something went wrong, please try again.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        builder.create().show();
                    }
                });
                    break;
                case "previouslyRead": holder.btnDelete.setOnClickListener(new View.OnClickListener() {

                    String bookName = books.get(position).getName();

                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete " + bookName + "?");
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromPreviouslyRead(books.get(position))) {
                                    Toast.makeText(mContext, bookName + " was removed!", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else {
                                    Toast.makeText(mContext, "Something went wrong, please try again.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        builder.create().show();
                    }
                });
                    break;
                case "wishlist": holder.btnDelete.setOnClickListener(new View.OnClickListener() {

                    String bookName = books.get(position).getName();

                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure you want to delete " + bookName + "?");
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromWishlist(books.get(position))) {
                                    Toast.makeText(mContext, bookName + " was removed!", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else {
                                    Toast.makeText(mContext, "Something went wrong, please try again.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        builder.create().show();
                    }
                });
                    break;
            }


        } else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }

        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtDescription.setText(books.get(position).getShortDescription());


    }

    @Override
    public int getItemCount() {
        if (books == null) return 0;
        else {
            return books.size();
        }
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView parent;
        private ImageView imgBook;
        private TextView txtBookName;

        private ImageView downArrow, upArrow;
        private RelativeLayout expandedRelLayout;
        private TextView txtAuthor, txtDescription, btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtBookName = itemView.findViewById(R.id.txtBookName);

            downArrow = itemView.findViewById(R.id.downArrow);
            upArrow = itemView.findViewById(R.id.upArrow);
            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            txtDescription = itemView.findViewById(R.id.txtShortDescription);

            btnDelete = itemView.findViewById(R.id.btnDelete);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });


        }
    }
}
