package pl.edu.wit.library;

import pl.edu.wit.library.model.Book;
import pl.edu.wit.library.model.patameters.BookParams;

import java.util.List;

public interface LibraryService {
    List<Book> libraryAdd(BookParams params, List<Book> bookList);
    List<Book> libraryDelete(BookParams params, List<Book> bookList);
    List<Book> libraryShow(List<Book> bookList);


}
