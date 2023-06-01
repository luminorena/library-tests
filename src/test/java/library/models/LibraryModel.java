package library.models;

import lombok.Data;
import lombok.Getter;

@Getter
public class LibraryModel {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int year;
    private int pages;

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public String setTitle(String title) {
        this.title = title;
        return title;
    }

    public String setAuthor(String author) {
        this.author = author;
        return author;
    }

    public String setGenre(String genre) {
        this.genre = genre;
        return genre;
    }

    public int setYear(int year) {
        this.year = year;
        return year;
    }

    public int setPages(int pages) {
        this.pages = pages;
        return pages;
    }
}
