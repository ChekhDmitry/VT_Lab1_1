package by.chekh.services;

import by.chekh.entities.books.BookLibraryCard;

import java.util.ArrayList;

/**
 * Created by dima on 10/4/2017.
 */
public class AdminExternalActionsService {


    public static boolean addBookToLibrary(BookLibraryCard bookLibraryCard, ArrayList<BookLibraryCard> books){

        for(BookLibraryCard realBook : books){
            if(realBook.getBook().getName().equals(bookLibraryCard.getBook().getName())){
                return false;
            }
        }
        books.add(bookLibraryCard);
        return true;
    }

    public static boolean removeBookFromLibrary(String bookName, ArrayList<BookLibraryCard> books){

        BookLibraryCard bookToRemove = null;
        for(BookLibraryCard realBook : books){
            if(realBook.getBook().getName().equals(bookName)){
                bookToRemove = realBook;
                break;
            }
        }
        if(bookToRemove==null){
            return false;
        }
        books.remove(bookToRemove);
        return true;
    }
}
