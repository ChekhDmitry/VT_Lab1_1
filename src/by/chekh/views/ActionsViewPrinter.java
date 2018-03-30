package by.chekh.views;

import by.chekh.entities.books.Book;
import by.chekh.entities.books.BookLibraryCard;


public class ActionsViewPrinter {


    public static void printRegistrationReport(boolean isSuccessful){
        printLine();
        if(isSuccessful){
            System.out.println("Регистрация прошла успешно!");
        } else {
            System.out.println("Ошибка регистрации! Измените данные ввода!");
        }
        printLine();
    }

    public static void printAuthorizationReport(boolean isSuccessful){
        printLine();
        if(isSuccessful){
            System.out.println("Авторизация прошла успешно!");
        } else {
            System.out.println("Ошибка авторизации! Проверьте данные ввода!");
        }
        printLine();
    }

    public static void printBookAddingReport(boolean isSuccessful){
        printLine();
        if(isSuccessful){
            System.out.println("Книга успешно добавлена!");
        } else {
            System.out.println("Ошибка добавления! Проверьте данные ввода!");
        }
        printLine();
    }

    public static void printBookPuttingBackReport(boolean isSuccessful){
        printLine();
        if(isSuccessful){
            System.out.println("Книга успешно возвращена!");
        } else {
            System.out.println("Ошибка возврата! Проверьте данные ввода!");
        }
        printLine();
    }

    public static void printUserBookInformation(Book book){
        System.out.println(book.getName()+" "+(book.isEbook()? "(Ebook)":"(Paper)"));
    }

    public static void printLibraryBookCardInformation(BookLibraryCard bookLibraryCard){
        System.out.println(bookLibraryCard.getBook().getName()+" "
                +(bookLibraryCard.getBook().isEbook()? "(Ebook)":"(Paper)-"+bookLibraryCard.getCount()));
    }

    public static void printLibraryBookCardInformation(BookLibraryCard bookLibraryCard, boolean isSuccessful){
        printLine();
        if(isSuccessful) {
            System.out.println("Книга успешно найдена:");
            System.out.println(bookLibraryCard.getBook().getName() + " "
                    + (bookLibraryCard.getBook().isEbook() ? "(Ebook)" : "(Paper)-" + bookLibraryCard.getCount()));
        }else {
            System.out.println("Данной книги нету!");
        }
        printLine();
    }

    public static void printLibraryBookCardInformationError(){
        printLine();
        System.out.println("Данной книги нету!");
        printLine();
    }

    public static void printAdminAddingBookReport(boolean isSuccessful){
        printLine();
        if(isSuccessful){
            System.out.println("Книга успешно добавлена!");
        } else {
            System.out.println("Ошибка добавления! Проверьте данные ввода!");
        }
        printLine();
    }

    public static void printAdminRemovingBookReport(boolean isSuccessful){
        printLine();
        if(isSuccessful){
            System.out.println("Книга успешно удалена!");
        } else {
            System.out.println("Ошибка добавления! Проверьте данные ввода!");
        }
        printLine();
    }

    private static void printLine(){
        System.out.println("-------------------------");
    }

}
