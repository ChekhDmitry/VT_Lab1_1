package by.chekh.views.menu;

import java.util.Scanner;

/**
 * Created by dima on 10/4/2017.
 */
public class MenuViewInput {

    private static Scanner scanner = new Scanner(System.in);

    public static String chooseMenuAction(){
        System.out.print("Ваше действие : ");
        String choice = scanner.nextLine().trim();
        System.out.println("---------------------");
        return choice;
    }
}
