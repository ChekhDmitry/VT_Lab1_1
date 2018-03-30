package by.chekh.views.menu;

/**
 * Created by dima on 10/4/2017.
 */
public class MenuViewPrinter {

    public static void printAuthorizationMenu(){
        System.out.println("________________");
        System.out.println("******Меню******");
        System.out.println("1 - Регистрация\n"+
        "2 - Авторизация\n"+
        "3 - Выход");
        System.out.println("****************");
    }

    public static void printUserMenu(boolean isAdmin){
        System.out.println("________________");
        System.out.println("******Меню******");
        System.out.println("0 - Поиск книги в каталоге\n"+
                "1 - Просмотр всего каталога\n"+
                "2 - Просмотр своего каталога\n"+
                "3 - Добавление книги\n"+
                "4 - Возврат книги\n"+
                "5 - Выход");
        if(isAdmin){
            System.out.println("***Доп. действия***");
            System.out.println("6 - Добавить книгу в бибилотеку");
            System.out.println("7 - Удалить книгу из бибилотеки");
        }
        System.out.println("****************");
    }

    public static void printChoiceError(){
        System.out.println("-------------------------");
        System.out.println("Некорректное действие.");
        System.out.println("-------------------------");
    }

}
