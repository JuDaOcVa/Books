package com.judaocva.books.Main.Dto;

public class Book {
    private String b_c;
    private String oCoverImg;

    public Book() {
    }

    public Book(String b_c, String oCoverImg) {
        this.b_c = b_c;
        this.oCoverImg = oCoverImg;
    }

    public String getB_c() {
        return b_c;
    }

    public void setB_c(String b_c) {
        this.b_c = b_c;
    }

    public String getoCoverImg() {
        return oCoverImg;
    }

    public void setoCoverImg(String oCoverImg) {
        this.oCoverImg = oCoverImg;
    }

    public String toString() {
        return "Book{" +
                "b_c='" + b_c + '\'' +
                ", oCoverImg='" + oCoverImg + '\'' +
                '}';
    }
}