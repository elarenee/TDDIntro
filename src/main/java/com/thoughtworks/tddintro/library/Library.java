package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private final DateTimeFormatter dateTimeFormatter;
    private List<String> books;
    private PrintStream printStream;

    public Library(List<String> books, PrintStream printStream, DateTimeFormatter dateTimeFormatter) {
        this.books = books;
        this.printStream = printStream;
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public void listBooks() {
        if (books.isEmpty()) {
            printStream.println("");
        }
        else {
            String s = "";
            for (String book : books) {
                s += book;
                if(books.size() > 1 && books.indexOf(book) != (books.size()-1)) {
                    s += ", ";
                }
            }
            printStream.println(s);
        }
    }

    public void welcome(DateTime date) {
        String timeString = dateTimeFormatter.print(date);
        printStream.println("Welcome to the library! The current time is " + timeString);
    }
}
