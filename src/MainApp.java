
import by.chekh.controllers.StateManagerController;


/**
 * Created by dima on 9/30/2017.
 */
public class MainApp {

    public static void main(String... args){

        StateManagerController stateManagerController = new StateManagerController();
        if(stateManagerController.launchAuthorizationState()){
            stateManagerController.launchUserState();
        }

    }

}
