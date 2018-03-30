package by.chekh.dao;

import by.chekh.entities.books.Book;
import by.chekh.entities.books.BookLibraryCard;
import by.chekh.entities.users.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dima on 10/3/2017.
 */
public class FileDAO {

    private final String usersFileName = "usersInfo.txt";
    private final String booksFileName = "booksCatalog.txt";


    public ArrayList<User> loadUsers(){
        ArrayList<User> users = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(usersFileName))) {
            while (scanner.hasNextLine()){
                String userFullInfo = scanner.nextLine();
                String[] singelUserInfo = userFullInfo.split("\\*");
                User user = new User(singelUserInfo[0],singelUserInfo[1],singelUserInfo[2],singelUserInfo[3].equals("a"));
                if(singelUserInfo.length>4){
                    for(int i=4; i<singelUserInfo.length; i+=2){
                        int index =i;
                        Book book = new Book(singelUserInfo[index], singelUserInfo[++index].equals("e"));
                        user.addBook(book);
                    }
                }
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    public ArrayList<BookLibraryCard> loadBooksLibraryCards(){
        ArrayList<BookLibraryCard> books = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(booksFileName))) {
            while (scanner.hasNextLine()){
                String bookFullInfo = scanner.nextLine();
                String[] singelBookInfo=  bookFullInfo.split("\\*");
                Book book = new Book(singelBookInfo[0],singelBookInfo[1].equals("e"));
                BookLibraryCard bookLibraryCard = new BookLibraryCard(book, Integer.valueOf(singelBookInfo[2]));
                books.add(bookLibraryCard);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return books;

    }

    public void saveUsers(ArrayList<User> users){

        try( FileWriter fileWriter = new FileWriter(usersFileName,false)) {
            for(User user : users){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(user.getUserName()+"*");
                stringBuilder.append(user.getUserEmail()+"*");
                stringBuilder.append(user.getUserPassword()+"*");
                stringBuilder.append((user.isAdmin()? "a": "u") +"*");
                for(Book book : user.getBooks()){
                    stringBuilder.append(book.getName()+"*");
                    stringBuilder.append((book.isEbook()? "e":"p")+"*");
                }
                stringBuilder.append("\n");
                fileWriter.write(stringBuilder.toString());
            }
           fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveBooksLibraryCards(ArrayList<BookLibraryCard> books){

        try( FileWriter fileWriter = new FileWriter(booksFileName,false)) {
            for(BookLibraryCard bookLibraryCard: books){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(bookLibraryCard.getBook().getName()+"*");
                stringBuilder.append((bookLibraryCard.getBook().isEbook()? "e":"p")+"*");
                stringBuilder.append(bookLibraryCard.getCount()+"*");
                stringBuilder.append("\n");
                fileWriter.write(stringBuilder.toString());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "FileDAO{" +
                "usersFileName='" + usersFileName + '\'' +
                ", booksFileName='" + booksFileName + '\'' +
                '}';
    }
}
