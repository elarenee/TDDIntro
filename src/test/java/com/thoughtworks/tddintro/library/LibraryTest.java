package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.Before;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private ArrayList<String> books;
    private PrintStream printStream;
    private DateTimeFormatter dateTimeFormatter;
    private DateTime time;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<String>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        time = new DateTime();
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        String title = "Book Title";
        books.add(title);
        Library library = new Library(books, printStream, null);
        library.listBooks();
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        Library library = new Library(books, printStream, null);
        library.listBooks();
        verify(printStream).println("");
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {
        String title1 = "Book Title";
        String title2 = "The Rapture of Canaan";
        books.add(title1);
        books.add(title2);
        Library library = new Library(books, printStream, null);
        library.listBooks();
        verify(printStream).println("Book Title, The Rapture of Canaan");
    }

    @Test
    public void shouldWelcomeUser() {
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        when(dateTimeFormatter.print(time)).thenReturn("");
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);
        verify(printStream).println("Welcome to the library! The current time is ");
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {
        when(dateTimeFormatter.print(time)).thenReturn("2013-04-08 16:33:17");
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);
        verify(printStream).println("Welcome to the library! The current time is 2013-04-08 16:33:17");
    }
}