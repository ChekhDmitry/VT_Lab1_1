package by.chekh.services;

import by.chekh.entities.users.User;

import java.util.ArrayList;

/**
 * Created by dima on 10/3/2017.
 */
public class ValidateUserActionsService {


    public static boolean registration(User user, ArrayList<User> users){

        for(User realUser : users){
            if(realUser.getUserName().equals(user.getUserName())
                    || realUser.getUserPassword().equals(user.getUserPassword())
                    || realUser.getUserEmail().equals(user.getUserEmail())){
                return false;
            }
        }
        users.add(user);
        return true;
    }

    public static User authorizatoin(String[] userInfo, ArrayList<User> users){

        for(User realUser : users ){
            if(realUser.getUserName().equals(userInfo[0]) && realUser.getUserPassword().equals(userInfo[1])){
                return realUser;
            }
        }
        return null;
    }

}
