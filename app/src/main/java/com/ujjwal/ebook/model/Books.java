package com.ujjwal.ebook.model;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private String bookname, authorname, booktype, bookprice;
    private int imgId;
    private static List<Books> BooksList = new ArrayList<>();

    public Books(String bookname, String authorname, String booktype, String bookprice, int imgId) {
        this.bookname = bookname;
        this.authorname = authorname;
        this.booktype = booktype;
        this.bookprice = bookprice;
        this.imgId = imgId;
    }

    public List<Books> getBooksList() {
        return BooksList;
    }

    public void setBooksList(List<Books> BooksList) {
        this.BooksList = BooksList;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public String getBookprice() {
        return bookprice;
    }

    public void setBookprice(String bookprice) {
        this.bookprice = bookprice;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

}

