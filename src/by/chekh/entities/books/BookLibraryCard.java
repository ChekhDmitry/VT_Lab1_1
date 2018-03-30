package by.chekh.entities.books;

/**
 * Created by dima on 10/3/2017.
 */
public class BookLibraryCard {

    private Book book;
    private int count;

    public BookLibraryCard(Book book, int count){
        this.book = book;
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookLibraryCard that = (BookLibraryCard) o;

        if (count != that.count) return false;
        return book != null ? book.equals(that.book) : that.book == null;

    }

    @Override
    public int hashCode() {
        int result = book != null ? book.hashCode() : 0;
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "BookLibraryCard{" +
                "book=" + book +
                ", count=" + count +
                '}';
    }
}
