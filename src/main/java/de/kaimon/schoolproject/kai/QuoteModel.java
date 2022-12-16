package de.kaimon.schoolproject.kai;


import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

public class QuoteModel {

    LinkedList<String> quote = new LinkedList<String>();
    String author;

    int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setQuote(String quote) {
        this.quote.add(quote);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public LinkedList<String> getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }
}
