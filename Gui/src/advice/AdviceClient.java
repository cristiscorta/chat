package advice;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AdviceClient {
    public static void main(String[] args) {
        new AdviceClient().run();
    }
    public void run(){
        JFrame frame = new JFrame();
        JLabel advice = new JLabel();
        frame.getContentPane().add(advice);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,100);
        frame.setVisible(true);

        try {
            Socket socket = new Socket("127.0.0.1",5000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String text = reader.readLine();
            advice.setText(text);
            System.out.println(text);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
