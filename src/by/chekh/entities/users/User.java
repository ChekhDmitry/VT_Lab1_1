package by.chekh.entities.users;

import by.chekh.entities.books.Book;

import java.util.ArrayList;

/**
 * Created by dima on 9/30/2017.
 */
public class User {

    private String userName;
    private String userEmail;
    private String userPassword;
    private boolean admin;
    private ArrayList<Book> books;

    public User(String userName, String userEmail, String userPassword, boolean admin, ArrayList<Book> books){
        this.userName=userName;
        this.userEmail=userEmail;
        this.userPassword=userPassword;
        this.admin=admin;
        this.books=books;
    }

    public User(String userName, String userEmail, String userPassword, boolean admin){
        this.userName=userName;
        this.userEmail=userEmail;
        this.userPassword=userPassword;
        this.admin=admin;
        this.books=new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        admin = admin;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }


    public boolean addBook(Book book){
        if(!books.contains(book)) {
            books.add(book);
            return true;
        }
        return false;
    }

    public Book removeBook(String bookName){

        Book bookToRemove = null;
        for(Book realBook : books){
            if(realBook.getName().equals(bookName)){
                bookToRemove=realBook;
                break;
            }
        }

        if(bookToRemove!=null){
            books.remove(bookToRemove);
        }

        return bookToRemove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (admin != user.admin) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (userEmail != null ? !userEmail.equals(user.userEmail) : user.userEmail != null) return false;
        if (userPassword != null ? !userPassword.equals(user.userPassword) : user.userPassword != null) return false;
        return books != null ? books.equals(user.books) : user.books == null;

    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (admin ? 1 : 0);
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass()+"{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", isAdmin=" + admin +
                ", books=" + books +
                '}';
    }
}
