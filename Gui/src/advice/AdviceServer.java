package advice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AdviceServer {



   private String[] adviceList = {

            "A debugged program is one for which you have not yet found the conditions that make it fail.",

            "A bug in the hand is better than two as yet undetected.",

            "A complex system that works is invariably found to have evolved from a simple one that works.",

            "A computer lets you make more mistakes faster than any other invention",

            "A language that doesn't affect the way you think about programming is not worth knowing.",

            "Adding manpower to a late software project makes it later.",

            "All programmers are optimists."

    };

    public static void main(String[] args) {
        new AdviceServer().run();
    }
    public void run (){
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket clientSocket;
            while((clientSocket = serverSocket.accept()) != null){
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                int adviceNumber = (int) (Math.random() * adviceList.length);
                writer.println(adviceList[adviceNumber]);
                writer.flush();
                System.out.println(adviceList[adviceNumber]);
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

