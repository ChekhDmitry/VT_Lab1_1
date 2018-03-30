package by.chekh.controllers;

import by.chekh.services.MainActionsService;
import by.chekh.views.menu.MenuViewInput;
import by.chekh.views.menu.MenuViewPrinter;

/**
 * Created by dima on 10/4/2017.
 */
public class StateManagerController {

    private MainActionsService mainActionsService;

    public StateManagerController(){
        mainActionsService = new MainActionsService();
    }

    public boolean launchAuthorizationState(){
        boolean isSuccessful = false;
        while (!isSuccessful){
            MenuViewPrinter.printAuthorizationMenu();
            switch (MenuViewInput.chooseMenuAction()){

                case "1":{
                    mainActionsService.registration();
                    break;
                }
                case "2":{
                    isSuccessful = mainActionsService.authorization();
                    break;
                }
                case "3":{
                    return false;
                }
                default:{
                    MenuViewPrinter.printChoiceError();
                }
            }
        }
        return isSuccessful;
    }

    public boolean launchUserState(){
        boolean isSuccessful = true;
        while (isSuccessful){
            MenuViewPrinter.printUserMenu(mainActionsService.getCurrentUser().isAdmin());
            switch (MenuViewInput.chooseMenuAction()){
                case "0":{
                    mainActionsService.searchForBook();
                    break;
                }
                case "1":{
                    mainActionsService.viewLibraryBookCards();
                    break;
                }
                case "2":{
                    mainActionsService.viewUserBooks();
                    break;
                }
                case "3":{
                    mainActionsService.addUserBook();
                    break;
                }
                case "4":{
                    mainActionsService.putBackUserBook();
                    break;
                }
                case "5":{
                    isSuccessful=false;
                    break;
                }
                case "6":{
                    if(mainActionsService.getCurrentUser().isAdmin()){
                        mainActionsService.addAdminBookToLibrary();
                        break;
                    }
                    MenuViewPrinter.printChoiceError();
                    break;
                }
                case "7":{
                    if(mainActionsService.getCurrentUser().isAdmin()){
                        mainActionsService.removeAdminBookFromLibrary();
                        break;
                    }
                }
                default:{
                    MenuViewPrinter.printChoiceError();
                    break;
                }
            }
        }
        return isSuccessful;
    }


}
