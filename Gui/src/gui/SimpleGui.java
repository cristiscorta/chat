package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui {
    private JButton circleButton;
    private JButton labelButton;
    private JFrame window;
    private DrawPanel panel;
    private JLabel label;

    class CircleButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            changeColor();
        }
    }
    class LabelButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            changeLabel();
        }
    }

    public static void main(String[] args) {
        new SimpleGui().run();
    }

    private void run() {
        window = new JFrame();
        circleButton = new JButton("Change color");
        labelButton = new JButton("Change label");
        label = new JLabel("Not clicked");
        panel = new DrawPanel();
        labelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLabel();
            }
        });
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeColor();
            }
        });

        window.getContentPane().add(BorderLayout.SOUTH, circleButton);
        window.getContentPane().add(BorderLayout.CENTER,panel);
        window.getContentPane().add(BorderLayout.EAST,labelButton);
        window.getContentPane().add(BorderLayout.WEST,label);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500,500);
        window.setVisible(true);

       // moveCircle();
    }

    public void changeText(){

        circleButton.setText("You clicked me");
    }



    private void moveCircle() {
        for(int x = 0; x <= panel.getWidth(); x++){
            panel.setXY(x,x);
            window.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void changeColor() {
        window.repaint();
    }

    private void changeLabel(){
        label.setText("Clicked");
    }
}
