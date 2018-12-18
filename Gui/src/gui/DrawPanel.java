package gui;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    int x;
    int y;


    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    protected void paintComponent(Graphics g) {
        int red = (int) (Math.random()*256);
        int green = (int) (Math.random()*256);
        int blue = (int) (Math.random()*256);

        g.setColor(new Color(red,green,blue));
        g.fillOval(100,100,30,30);
       // Image image = new ImageIcon("pika.png").getImage();
       // g.drawImage(image,0,0,this);
    }
}
