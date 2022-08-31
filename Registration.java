

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
 
public class Registration {
    private String username;
    private String password;
    private String[][] accounts = {{"admin", "admin1"},{"Cashier", "abc123"}};
    
    public Registration(String user, String pass){
        username = user;
        password = pass;
    }
    
    public boolean auth(){
        if((username == accounts[0][0]) && (password == accounts[0][1]))
            return true;
        else
            return false;
    }
    
    }