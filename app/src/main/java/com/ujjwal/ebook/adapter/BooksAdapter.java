package com.ujjwal.ebook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.ujjwal.ebook.R;
import com.ujjwal.ebook.model.Books;


import de.hdodenhof.circleimageview.CircleImageView;


public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {
    private Context context;
    private List<Books> BooksList;

    public BooksAdapter(Context context, List<Books> BooksList) {
        this.context = context;
        this.BooksList = BooksList;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_cardview,parent,false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, final int position) {
        Books Books = BooksList.get(position);
        holder.imgBook.setImageResource(Books.getImgId());
        holder.tvName.setText(Books.getBookname());
        holder.tvPrice.setText(Books.getBookprice());
        holder.tvAuthor.setText(Books.getAuthorname());
        holder.tvBookTypes.setText(Books.getBooktype());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BooksList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return BooksList.size();
    }

    public class BooksViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgBook;
        ImageButton imgDelete;
        TextView tvName, tvPrice, tvAuthor, tvBookTypes;


        public BooksViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBook = itemView.findViewById(R.id.imgBook);
            imgDelete = itemView.findViewById(R.id.imgDelete);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvBookTypes = itemView.findViewById(R.id.tvBookTypes);
        }
    }
}

