/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circletest;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
 
/**
 *
  
 */
public class Line_Rotation  extends JFrame{
     
    /** Creates a new instance of Translation */
  
    private int width=400;
    private int height=400;
    private int x1=100;
    private int y1=100;
    private int x2;
    private int y2;
    private float theta=15;
     
    public Line_Rotation() {
         setTitle("Line Translation");
         setSize(width,height);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
    }
      public void paint(Graphics g) {
       g.fillRect(0,0,400,400);
        g.setColor(Color.RED);
 
g.drawLine(200,200,x1+200,200-y1);
             g.setColor(Color.GREEN);
             x2=((int)(x1*Math.cos(theta*Math.PI/180)))-((int)(y1* Math.sin(theta*Math.PI/180)));
             y2=((int)(x1*Math.sin(theta*Math.PI/180)))+((int)(y1* Math.cos(theta*Math.PI/180)));
             x2=((int)(x1*Math.cos(theta*Math.PI/180)))-((int)(y1* Math.sin(theta*Math.PI/180)));
             y2=((int)(x1*Math.sin(theta*Math.PI/180)))+((int)(y1* Math.cos(theta*Math.PI/180)));
                g.drawLine(200,200,x2+200,200-y2);
      
    }
      public static void main(String[] args) {
        // TODO code application logic here
    new Line_Rotation();
    }
 
}