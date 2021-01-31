package pl.edu.wit.library.model.patameters;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class BookParams {

    private final String bookName;
    private final String ISBN;
    private final String author;
    private final int releaseYear;
}
