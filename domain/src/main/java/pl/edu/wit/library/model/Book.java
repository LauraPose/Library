package pl.edu.wit.library.model;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Book {

    private final String bookName;
    private final String ISBN;
    private final String author;
    private final int releaseYear;
}
