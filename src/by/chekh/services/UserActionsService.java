package by.chekh.services;

import by.chekh.entities.books.Book;
import by.chekh.entities.books.BookLibraryCard;
import by.chekh.entities.users.User;

import java.util.ArrayList;

/**
 * Created by dima on 10/3/2017.
 */
public class UserActionsService {

    public static boolean addUserBook(User user, String bookName, ArrayList<BookLibraryCard> books){

        BookLibraryCard bookToRemove = null;
        for(BookLibraryCard realBook : books){

            if(realBook.getBook().getName().equals(bookName)){

                if(!user.addBook(realBook.getBook())){
                    return true;
                }

                if(realBook.getBook().isEbook()){
                    //user.addBook(realBook.getBook());
                    return true;
                }else if(realBook.getCount()>1){
                    //user.addBook(realBook.getBook());
                    realBook.setCount(realBook.getCount()-1);
                    return true;
                }else if(realBook.getCount()==1){
                    //user.addBook(realBook.getBook());
                    bookToRemove=realBook;
                    break;
                }
            }
        }


        if(bookToRemove != null) {
            books.remove(bookToRemove);
            return true;
        }
        return false;
    }

    public static boolean putBookBack(User user, String bookName, ArrayList<BookLibraryCard> books){

        Book book = user.removeBook(bookName);
        if(book==null){
            return false;
        }

        for(BookLibraryCard realBook : books){
            if(realBook.getBook().equals(book)){
                if(!book.isEbook()){
                    realBook.setCount(realBook.getCount()+1);
                    return true;
                }
                return true;
            }
        }

        BookLibraryCard bookLibraryCard = new BookLibraryCard(book,1);
        books.add(bookLibraryCard);
        return true;
    }

    public static BookLibraryCard searchBook(String bookName, ArrayList<BookLibraryCard> books ){
        for (BookLibraryCard bookLibraryCard : books){
            if(bookLibraryCard.getBook().getName().equals(bookName)){
                return bookLibraryCard;
            }
        }
        return null;
    }

}
