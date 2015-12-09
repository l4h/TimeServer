package com.company;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

class ClientConnection{

}

class User{
    String userName;
    HashMap<User,ClientConnection> userMap;
    ArrayList<String> roles=new ArrayList<>("admin","guest");

}

class ClientManager{

}

class LoginManager{
    private static boolean status;
    private static int admin_count;
    private static int guest_count;

    boolean login(String role, ClientConnection client){
        return true;
    }

    void logout(ClientConnection cc){

    }
}

class Log{

    static void writeToLog(ClientConnection client){

    }
}

class Configuration{
     int maxAdm;
     int maxGuest;

    public Configuration(){
        maxAdm=1;
        maxGuest=5;
    }

    public Configuration(int max_Adm,int max_Guest){
        maxAdm=max_Adm;
        maxGuest=max_Guest;
    }
}

class CommandManager{

}

class CommandClass{

}

class Acceptor implements Runnable{
    Socket clientSocket;
    ServerSocket serverSocket;
    Thread serverThread;
    int connections;

    public void run() {

    }
}


public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
