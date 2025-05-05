package Controller;

public class LibraryManager {
    private final BookManager bm;
    private final ReaderManager rm;
    private final LendingManager lm;

    public LibraryManager() {
        bm = new BookManager();
        rm = new ReaderManager();
        lm = new LendingManager();
    }

    public BookManager getBm() {
        return bm;
    }

    public ReaderManager getRm() {
        return rm;
    }

    public LendingManager getLm() {
        return lm;
    }
}
