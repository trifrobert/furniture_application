package com.example.sefapplication;

import java.util.HashMap;

public class IDandPasswords {

    HashMap <String,String> loginInfo = new HashMap <String,String>();

    public IDandPasswords(){
        loginInfo.put("robert_trif", "1234");
        loginInfo.put("medeeaiulius", "password");
        loginInfo.put("sorina_juncan", "12345");
    }

    protected HashMap <String, String> getLoginInfo(){
        return loginInfo;
    }
}
