package com.ujjwal.ebook.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ujjwal.ebook.R;
import com.ujjwal.ebook.adapter.BooksAdapter;
import com.ujjwal.ebook.model.Books;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerViewHome;
    private static List<Books> booksList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewHome = root.findViewById(R.id.recyclerView);

        Books books = new Books("Douluo Dalu", "Tang Jia San Shao", "Fantasy", "50",R.drawable.noimg);
        booksList = books.getBooksList();
        if (booksList.isEmpty()){
            booksList.add(new Books("Douluo Dalu", "Tang Jia San Shao", "Fantasy", "50", R.drawable.fantasy));
            booksList.add(new Books("Coiling Dragon", "IET", "SciFi", "20", R.drawable.scifi));
            books.setBooksList(booksList);
        }
        BooksAdapter booksAdapter = new BooksAdapter(getActivity(), booksList);
        recyclerViewHome.setAdapter(booksAdapter);
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return root;
    }
}