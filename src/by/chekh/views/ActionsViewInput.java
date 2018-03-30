package by.chekh.views;

import by.chekh.entities.books.Book;
import by.chekh.entities.books.BookLibraryCard;
import by.chekh.entities.users.User;
import by.chekh.services.util.Md5Manager;

import java.util.Scanner;

/**
 * Created by dima on 10/3/2017.
 */
public class ActionsViewInput {

    private static Scanner scanner = new Scanner(System.in);

    public static User registrationInput(){
        System.out.print("Введите имя пользователя: ");
        String userName = scanner.nextLine().trim();
        System.out.print("Введите email пользователя: ");
        String userEmail = scanner.nextLine().trim();
        System.out.print("Введите пароль пользователя: ");
        String userPassword = scanner.nextLine().trim();
        userPassword = Md5Manager.md5Generator(userPassword);
        return new User(userName, userEmail, userPassword, false);
    }

    public static String[] authorizationInput(){
        System.out.print("Введите имя пользователя: ");
        String userName = scanner.nextLine().trim();
        System.out.print("Введите пароль пользователя: ");
        String userPassword = scanner.nextLine().trim();
        userPassword = Md5Manager.md5Generator(userPassword);
        return new String[]{userName,userPassword};
    }

    public static String bookNameInput(){
        System.out.print("Введите название книги: ");
        String bookName = scanner.nextLine().trim();
        return bookName;
    }

    public static BookLibraryCard addingBookToLibraryInput(){
        boolean isEbook;
        String bookName;
        int bookCount=0;
        System.out.println("1 - электронная книга\n" +
                "2 - бумажная книга");
        System.out.print("Вариант: ");
        String choice = scanner.nextLine().trim();
        switch (choice){
            case "1" :{
                isEbook=true;
                break;
            }
            case "2":{
                isEbook=false;
                System.out.print("Введите количетсво экземпляров: ");
                String count = scanner.nextLine().trim();
                try{
                    bookCount = Integer.valueOf(count);
                }catch (Exception ex){
                    System.out.println("Некорректное данные.");
                    return null;
                }
                break;
            }
            default:{
                System.out.println("Некорректное действие.");
                return null;
            }
        }
        System.out.print("Введите название книги: ");
        bookName = scanner.nextLine().trim();
        return new BookLibraryCard(new Book(bookName,isEbook),bookCount);
    }


}
