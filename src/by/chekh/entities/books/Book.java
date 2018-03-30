package by.chekh.entities.books;

/**
 * Created by dima on 10/3/2017.
 */
public class Book {
    private String name;
    private boolean isEbook;


    public Book(String name, boolean isEbook){
        this.name = name;
        this.isEbook = isEbook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEbook() {
        return isEbook;
    }

    public void setEbook(boolean ebook) {
        isEbook = ebook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (isEbook != book.isEbook) return false;
        return name != null ? name.equals(book.name) : book.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (isEbook ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass()+"{" +
                "name='" + name + '\'' +
                ", isEbook=" + isEbook +
                '}';
    }
}
