package com.company;

import java.io.*;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

class CommandManager {
    enum guestCommands {time, exit}
    enum adminCommands{time, status, exit, stop , }

}

class LoginManager{
    private static int maxGuest=30;
    private int guestSessions=0;
    private static boolean adminLogon=false;
    private boolean adminRelogin=true;
    private String login;
    private Socket clientSocket;


    //login function
    public boolean login (Socket s) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        switch((login=br.readLine())){
            case "admin":
                if(adminLogon==true){
                    bw.write("user admin is already login , do you want to reopen session with this connection? (y/n, no - default):");
                    bw.flush();
                    switch(br.readLine().toLowerCase()){
                        case "y":
                            //some operation to replace admin session
                            return true;
                        default:
                            bw.write("Glad to see you! bye!");
                            bw.flush();
                            return false;
                    }
                } else {
                    adminLogon = true;
                    return true;
                }
            case "guest":
                if(maxGuest<30) {
                    guestSessions++;
                    return true;
                }
            default:
                bw.write("Only guest or admin can login\n");
                bw.flush();
                return false;
        }
    }

    //Logoff function
    public void logoff(ClientConnection cc){
        //not implemented yet
    }

    //Return number of active sessions
    public int getSessionsCount(){
        if(adminLogon)return guestSessions+1;
        return guestSessions;
    }

    public static int getMaxSessions(){
        return maxGuest+1;
    }
}


class Log{
    File log=new File("timeserverconnection.log");
    public synchronized  void writeLog(String action, Date d, String role, int sessionID, Inet4Address ip, int existingConnections) throws IOException {
        if(!log.exists())log.createNewFile();
                else throw new IOException();
        BufferedWriter fbw=new BufferedWriter(new FileWriter(log));
        fbw.write("Client " +action +"\t" + d + "\t" + role + "\t" + sessionID + "\t" + ip + "\t" + existingConnections+"\n");
        fbw.
    }

}

class ClientManager{
    static private Map<Integer, ClientConnection> mClConnection;

    public ClientManager(){
        mClConnection=new HashMap<>();
    }
    public boolean NewCl(ClientConnection y){

    }

}

class ClientConnection implements Runnable {
    private UUID uuid;
    private Random r;
    private Socket clSocket;
    private Inet4Address clIPV4;
    private static int sessionId;
    private Thread clThread;

    public ClientConnection(Socket s){
        clSocket=s;
        r=new Random();
        clIPV4= (Inet4Address) clSocket.getInetAddress();
        uuid=new UUID(r.nextLong(),r.nextLong());
        sessionId=uuid.variant();
        clThread=new Thread(this,"clConnection");
    }

    public void run(){

    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        int portNumber = 3366;
        int backlog = 3;
        Date serverStartedAt;
        String hello = "Please login: ";


        ServerSocket ss = new ServerSocket(portNumber, backlog);
        serverStartedAt = new Date();
        while (true) {
            ss.accept();





           /* for (int i = 0; i < hello.length; i++) {
                //outputStrearite(hello.charAt(i));
                bufferedOutputStream.write(hello[i]);
                bufferedOutputStream.flush();
            }*/
            /*while(!exit) {
                bw.write(login+">");
                bw.flush();
                command = br.readLine();

                switch (command.toString()) {
                    case "exit":
                        bw.write("Good bye!\n");
                        bw.flush();
                        exit=true;
                        break;
                    case "time":
                        bw.write(new Date(System.currentTimeMillis()).toString() + "\n");
                        bw.flush();
                        break;
                    default:
                        break;

                }

            }
            s.close();
*/

        }

    }
}
