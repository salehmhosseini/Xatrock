package xat.Chat;

import xat.DataBase.DBNT;
import xat.DataBase.Lesson_Page;
import xat.DataBase.Lesson_source;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private final ServerSocket serverSocket;
    public static ArrayList sessions;
    public static List<String> messages=new ArrayList<String>();
    private static Server theserver=new Server();
    private Server() {

        try {
            sessions=new ArrayList<Integer>();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    messages.addAll(Lesson_source.chat_lesson_load("Ap"));

                }
            }).start();
            this.serverSocket =new ServerSocket(9090);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //theserver.startServer();

    }

    public static Server getInstance() {
        return theserver;
    }

    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                // Will be closed in the Client Handler.
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");
                ClientHandler clientHandler = new ClientHandler(socket,Client.Clientkey);
                sessions.add(Client.Clientkey);

                Thread thread = new Thread(clientHandler);
                System.out.println("State 4");
                thread.start();
                System.out.println("State 3");

            }
        } catch (IOException e) {
            closeServerSocket();
        }
    }

    // Close the server socket gracefully.
    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Run the program.
    public static void main(String[] args) throws IOException {
        //ServerSocket serverSocket = new ServerSocket(1234);
        //Server server = new Server(serverSocket);
        //server.startServer();
        Server.getInstance().startServer();
        System.out.println("State 1");


    }
    public void writemsg(String msg) { //importatnt
        // if(!msg.isBlank() && !msg.isEmpty() && msg.equals("\n"))


        System.out.println(msg);
        messages.add(msg);
        Lesson_source.chat_lesson_save("Ap", msg);
        //System.out.println("2");
        if (messages.size() % 5 == 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    DBNT.get_chat_pdf(messages,"Ap");
                }
            }).start();

        }
    }
}