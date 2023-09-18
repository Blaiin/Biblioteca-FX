package its.biblioteca.bibliotecafx.codebase;

import java.time.LocalDate;

public class Book {
    private static int instanceCount = 0;
    private int id;
    private String author;
    private String title;
    private String editor;
    private LocalDate publishDate;

    public Book() {
    }
    public Book(String author, String title, String editor, LocalDate publishDate) {
        instanceCount++;
        this.id = instanceCount;
        this.author = author;
        this.title = title;
        this.editor = editor;
        this.publishDate = publishDate;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String setAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String setEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public LocalDate setPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public static int setInstanceCount() {
        return instanceCount;
    }

    public static void setInstanceCount(int instanceCount) {
        Book.instanceCount = instanceCount;
    }

    @Override
    public String toString() {
        return "Book -> [id=" + id + ", author=" + author + ", title=" + title + "]";
    }
}
