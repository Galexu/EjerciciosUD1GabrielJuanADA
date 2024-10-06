package EJ10;

import java.io.Serializable;

public class Book implements Serializable {
    private String author;
    private String title;
    private String editorial;
    private String date;

    public Book(String author, String title, String editorial, String date) {
        this.author = author;
        this.title = title;
        this.editorial = editorial;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Author: '" + author + '\'' + '\n' +
                "Title: '" + title + '\'' + '\n' +
                "Editorial: '" + editorial + '\'' + '\n' +
                "Date: '" + date + '\'';
    }
}
