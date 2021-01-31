package pl.edu.wit.library.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.edu.wit.library.LibraryService;
import pl.edu.wit.library.model.Book;
import pl.edu.wit.library.model.patameters.BookParams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class bookInput implements LibraryService {

    private List<Book> bookList = new ArrayList<>();

    @Override
    public List<Book> libraryAdd(final BookParams params, List<Book> bookList) {
        Book book = Book.builder()
                .bookName(params.getBookName())
                .author(params.getAuthor())
                .ISBN(params.getISBN())
                .releaseYear(params.getReleaseYear())
                .build();
        bookList.add(book);

        return bookList;
    }

    @Override
    public List<Book> libraryDelete(final BookParams params, List<Book> bookList) {

        Book book = Book.builder()
                .bookName(params.getBookName())
                .author(params.getAuthor())
                .ISBN(params.getISBN())
                .releaseYear(params.getReleaseYear())
                .build();
        bookList.remove(book);

        return bookList;
    }

    public List<Book> libraryShow(List<Book> bookList) {

        return bookList;
    }

//    @Override
//    public libraryAdd(BookParams params) {
//
//        return null;
//        return Book.builder()
//                .bookName(params.getBookName())
//                .author(params.getAuthor())
//                .ISBN(params.getISBN())
//                .releaseYear(params.getReleaseYear())
//                .build();
//    }
}
