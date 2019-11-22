package com.ujjwal.ebook.ui.book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.ujjwal.ebook.R;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import com.ujjwal.ebook.model.Books;

import java.util.ArrayList;
import java.util.List;

public class BookFragment extends Fragment {
    private RecyclerView recyclerViewhome;
    private EditText etBook, etPrice, etAuthor;
    private RadioGroup rgTypes;
    private RadioButton rdoSciFi, rdoFantasy, rdoOthers;
    private Button btnSave;
    private String addBookName, addBookPrice, addAuthorName, addBookTypes;
    private int profilePic;
    private static List<Books> booksList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, final Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_books, container, false);
        etBook = root.findViewById(R.id.etBook);
        etPrice = root.findViewById(R.id.etPrice);
        etAuthor = root.findViewById(R.id.etAuthor);
        rgTypes = root.findViewById(R.id.rgTypes);
        rdoSciFi = root.findViewById(R.id.rdoSciFi);
        rdoFantasy = root.findViewById(R.id.rdoFantasy);
        rdoOthers = root.findViewById(R.id.rdoOthers);
        btnSave = root.findViewById(R.id.btnSave);
        recyclerViewhome = root.findViewById(R.id.recyclerView);

        final int[] img = {R.drawable.scifi, R.drawable.fantasy, R.drawable.noimg};


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etBook.getText().toString().isEmpty()) {
                    addBookName = etBook.getText().toString();
                    if (!etPrice.getText().toString().isEmpty()) {
                        addBookPrice = (etPrice.getText().toString());
                        if (!etAuthor.getText().toString().isEmpty()) {
                            addAuthorName = (etAuthor.getText().toString());
                            try {
                                int selectTypes = rgTypes.getCheckedRadioButtonId();
                                RadioButton radioButton = root.findViewById(selectTypes);
                                addBookTypes = radioButton.getText().toString();
                                if (addBookTypes.equals("SciFi")) {
                                    profilePic = img[0];
                                } else if (addBookTypes.equals("Fantasy")) {
                                    profilePic = img[1];
                                } else {
                                    profilePic = img[2];
                                }

                                Books books = new Books(addBookName, addAuthorName, addBookTypes, addBookPrice, profilePic);
                                booksList = books.getBooksList();
                                booksList.add(books);
                                books.getBooksList();
                                Toast.makeText(getActivity(), "Book Added", Toast.LENGTH_LONG).show();
                                etBook.getText().clear();
                                etPrice.getText().clear();
                                etAuthor.getText().clear();
                                rgTypes.clearCheck();
//                                for testing
//                                Toast.makeText(getActivity(), " "+addStudentName+" "+ addStudentAge+" "+addStudentGender+" "+addStudentAddress+" "+profilePic, Toast.LENGTH_LONG).show();
                            } catch (Exception e) {
                                Toast.makeText(getActivity(), "Please select book types", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            etAuthor.setError("Author name required");
                        }
                    } else {
                        etPrice.setError("BookPrice required");
                    }
                } else {
                    etBook.setError("Name required");
                }
            }
        });
        return root;
    }
}

