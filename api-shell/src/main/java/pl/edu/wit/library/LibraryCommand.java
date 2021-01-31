package pl.edu.wit.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.table.*;
import pl.edu.wit.library.model.Book;
import pl.edu.wit.library.model.patameters.BookParams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@ShellComponent
public class LibraryCommand {

    private List<Book> libraryList = new ArrayList<>();

    @Autowired
    private final LibraryService libraryService;

    public LibraryCommand(final LibraryService libraryService, List<Book> libraryList) {
        this.libraryService = libraryService;
    }

    @ShellMethod("List library")
    public Table listLibrary()
    {
        /**Komenda:
         * list-library
         *
         * pokazanie listy zostawiłam po każdej komendzie dla łatwiejszej analizy, mogę usunąć.
         */

        LinkedHashMap<String, Object> headers = new LinkedHashMap<>();
        headers.put("author", "Autor");
        headers.put("ISBN", "ISBN");
        headers.put("bookName", "Tytuł");
        headers.put("releaseYear", "Rok wydania");

        final TableModel model = new BeanListTableModel<>(libraryList, headers);
        TableBuilder tableBuilder = new TableBuilder(model);
        tableBuilder.addFullBorder(BorderStyle.fancy_light);
        return tableBuilder.build();
    }








    @ShellMethod("Add book to library")
    public Table addToLibrary(
            @ShellOption({"-a", "--author"}) final String author,
            @ShellOption({"-I", "--ISBN"}) final String ISBN,
            @ShellOption({"-b", "--bookName"}) final String bookName,
            @ShellOption({"-r", "--releaseYear"}) final int releaseYear
    ) {

        /**Przykładowe rekordy do dodania
         * add-to-library -a Jan_Kowalski -I 4234234 -r 1992 -b Tytuł1
         * add-to-library -a Jan_Nowak -I 4288234 -r 1998 -b Tytuł4
         * add-to-library -a Jan_Kowal -I 4222234 -r 1991 -b Tytuł3
         * add-to-library -a Jan_Dąbrowski -I 4277234 -r 1972 -b Tytuł2
         *
         *
         */

        final BookParams params = BookParams.builder()
                .author(author)
                .releaseYear(releaseYear)
                .ISBN(ISBN)
                .bookName(bookName)
                .build();

        LinkedHashMap<String, Object> headers = new LinkedHashMap<>();
        headers.put("author", "Autor");
        headers.put("ISBN", "ISBN");
        headers.put("bookName", "Tytuł");
        headers.put("releaseYear", "Rok wydania");

        libraryList = libraryService.libraryAdd(params, libraryList);
        final TableModel model = new BeanListTableModel<>(libraryList, headers);
        TableBuilder tableBuilder = new TableBuilder(model);
        tableBuilder.addFullBorder(BorderStyle.fancy_light);
        return tableBuilder.build();
    }

    @ShellMethod("Remove book from library")
    public Table removeFromLibrary(
            @ShellOption({"-a", "--author"}) final String author,
            @ShellOption({"-I", "--ISBN"}) final String ISBN,
            @ShellOption({"-b", "--bookName"}) final String bookName,
            @ShellOption({"-r", "--releaseYear"}) final int releaseYear
    ) {

        /**Przykładowe rekordy do usunięcia (po ich dodaniu)
         * remove-from-library -a Jan_Kowalski -I 4234234 -r 1992 -b Tytuł1
         * remove-from-library -a Jan_Nowak -I 4288234 -r 1998 -b Tytuł4
         * remove-from-library -a Jan_Kowal -I 4222234 -r 1991 -b Tytuł3
         * remove-from-library -a Jan_Dąbrowski -I 4277234 -r 1972 -b Tytuł2
         */

        final BookParams params = BookParams.builder()
                .author(author)
                .releaseYear(releaseYear)
                .ISBN(ISBN)
                .bookName(bookName)
                .build();

        LinkedHashMap<String, Object> headers = new LinkedHashMap<>();
        headers.put("author", "Autor");
        headers.put("ISBN", "ISBN");
        headers.put("bookName", "Tytuł");
        headers.put("releaseYear", "Rok wydania");

        libraryList = libraryService.libraryDelete(params, libraryList);
        final TableModel model = new BeanListTableModel<>(libraryList, headers);
        TableBuilder tableBuilder = new TableBuilder(model);
        tableBuilder.addFullBorder(BorderStyle.fancy_light);
        return tableBuilder.build();
    }

}
