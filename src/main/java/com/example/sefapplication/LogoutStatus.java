package com.example.sefapplication;

public class LogoutStatus {
    public static boolean isLoggedOut = false;

    public static boolean getStatus(){
        return isLoggedOut;
    }

    public static void changeStatus(boolean status){
        isLoggedOut = status;
    }
}
