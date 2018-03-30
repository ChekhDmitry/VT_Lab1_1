package by.chekh.services;

import by.chekh.entities.books.Book;
import by.chekh.entities.books.BookLibraryCard;
import by.chekh.dao.FileDAO;
import by.chekh.entities.users.User;
import by.chekh.views.ActionsViewInput;
import by.chekh.views.ActionsViewPrinter;

import java.util.ArrayList;

/**
 * Created by dima on 10/3/2017.
 */
public class MainActionsService {

    private ArrayList<User> users;
    private ArrayList<BookLibraryCard> bookLibraryCards;
    private FileDAO fileDAO;
    private User currentUser;

    public MainActionsService(){
        fileDAO = new FileDAO();
        users = fileDAO.loadUsers();
        bookLibraryCards = fileDAO.loadBooksLibraryCards();
    }

    public boolean registration(){
        User user = ActionsViewInput.registrationInput();
        boolean isSuccessful = ValidateUserActionsService.registration(user,users);
        if(isSuccessful){
            fileDAO.saveUsers(users);
        }
        ActionsViewPrinter.printRegistrationReport(isSuccessful);
        return isSuccessful;
    }

    public boolean authorization(){
        String[] userInfo = ActionsViewInput.authorizationInput();
        User user = ValidateUserActionsService.authorizatoin(userInfo,users);
        if(user==null){
            ActionsViewPrinter.printAuthorizationReport(false);
            return false;
        }
        currentUser=user;
        ActionsViewPrinter.printAuthorizationReport(true);
        return true;
    }

    public void viewLibraryBookCards(){
        System.out.println("Книги: ");
        for(BookLibraryCard bookLibraryCard : bookLibraryCards){
            ActionsViewPrinter.printLibraryBookCardInformation(bookLibraryCard);
        }
    }

    public void viewUserBooks(){
        System.out.println("Книги: ");
        if(currentUser!=null) {
            for (Book book : currentUser.getBooks()) {
                ActionsViewPrinter.printUserBookInformation(book);
            }
        }
    }

    public boolean addUserBook(){
        if (currentUser != null) {
            String bookName = ActionsViewInput.bookNameInput();
            if (UserActionsService.addUserBook(currentUser, bookName, bookLibraryCards)) {
                fileDAO.saveUsers(users);
                fileDAO.saveBooksLibraryCards(bookLibraryCards);
                ActionsViewPrinter.printBookAddingReport(true);
                return true;
            } else {
                ActionsViewPrinter.printBookAddingReport(false);
            }
        }
        return false;
    }

    public boolean putBackUserBook(){
        if(currentUser!=null){
            String bookName = ActionsViewInput.bookNameInput();
            if(UserActionsService.putBookBack(currentUser,bookName,bookLibraryCards)){
                fileDAO.saveUsers(users);
                fileDAO.saveBooksLibraryCards(bookLibraryCards);
                ActionsViewPrinter.printBookPuttingBackReport(true);
                return true;
            }else {
                ActionsViewPrinter.printBookPuttingBackReport(false);
            }
        }
        return false;
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public boolean addAdminBookToLibrary(){
        if (currentUser != null && currentUser.isAdmin()) {
            BookLibraryCard bookLibraryCard = ActionsViewInput.addingBookToLibraryInput();
            if(bookLibraryCard == null){
                return false;
            }
            if(AdminExternalActionsService.addBookToLibrary(bookLibraryCard,bookLibraryCards)){
                fileDAO.saveBooksLibraryCards(bookLibraryCards);
                ActionsViewPrinter.printAdminAddingBookReport(true);
                return true;
            }else{
                ActionsViewPrinter.printAdminAddingBookReport(false);
            }
        }
        return false;
    }

    public boolean removeAdminBookFromLibrary(){
        if (currentUser != null && currentUser.isAdmin()) {
            String bookName = ActionsViewInput.bookNameInput();
            if(AdminExternalActionsService.removeBookFromLibrary(bookName,bookLibraryCards)){
                fileDAO.saveBooksLibraryCards(bookLibraryCards);
                ActionsViewPrinter.printAdminRemovingBookReport(true);
                return true;
            }else{
                ActionsViewPrinter.printAdminRemovingBookReport(false);
            }

        }
        return false;
    }

    public boolean searchForBook(){

        String bookName = ActionsViewInput.bookNameInput();
        BookLibraryCard bookLibraryCard = UserActionsService.searchBook(bookName, bookLibraryCards);
        if(bookLibraryCard != null){
            ActionsViewPrinter.printLibraryBookCardInformation(bookLibraryCard, true);
        }else {
            ActionsViewPrinter.printLibraryBookCardInformationError();
        }

        return true;
    }

}
