package com.example.sefapplication;

public class LogginStatus {

    public static boolean isLoggedIn = false;

    public static boolean getStatus(){
        return isLoggedIn;
    }

    public static void changeStatus(boolean status){
        isLoggedIn = status;
    }
}
