/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseclock;

import java.awt.*;
import javax.swing.*;


public class Clocks extends JPanel{  

     private final static Color yell = new Color(229, 227, 117);
     private final static Color color1 = new Color(47, 197, 186);
     private final static Color color2 = new Color(98, 198, 201);
     private final static Color three = new Color(253, 250, 247);
     private final static Color four = new Color(235, 100, 68);
@Override
public void paintComponent( Graphics mikaeli ){
// call paintComponent to ensure the panel displays correctly
super.paintComponent( mikaeli );
Graphics2D g2D;      
g2D = (Graphics2D) mikaeli;
        g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, w, color2);
        g2D.setPaint(gp);
        g2D.fillRect(0, 0, w, h);
            g2D.setStroke(new BasicStroke(32F));
        
         mikaeli.setColor(yell);
         mikaeli.drawOval(150, 16, 420, 420);
         mikaeli.setColor(three);
         mikaeli.fillOval(166, 32, 388, 388);
        
         g2D.setStroke(new BasicStroke(4F));
        mikaeli.setColor(color1);
        mikaeli.drawLine(364,232,375,95);
        
         mikaeli.drawLine(364,232,364,45);
         mikaeli.setColor(four);
         g2D.setStroke(new BasicStroke(1F));
         mikaeli.drawLine(364,232,400,45);
         mikaeli.setColor(four);
         g2D.setStroke(new BasicStroke(4F));
         mikaeli.drawRect(358,228,10,10);
         mikaeli.setColor(Color.white);
         mikaeli.fillRect(359,229,8,8);
         Font font = new Font("Verdana", Font.BOLD, 24);
           mikaeli.setFont(font);
         
         mikaeli.setColor(Color.black);
         mikaeli.drawString("12", 348, 75);
         mikaeli.drawString("6", 348, 395);
         mikaeli.drawString("5", 421, 370);
         mikaeli.drawString("7", 268,370);
         mikaeli.drawString("8", 218,318);
         mikaeli.drawString("11", 265,105);
         
         g2D.rotate(Math.toRadians(0.523599));
         mikaeli.drawString("1", 438,100);
         g2D.rotate(Math.toRadians(1.0472));
         mikaeli.drawString("2", 498,150);
         g2D.rotate(Math.toRadians(1.5708));
         mikaeli.drawString("3", 518,210);
         g2D.rotate(Math.toRadians(2.0944));
         mikaeli.drawString("4", 512,268);
         g2D.rotate(Math.toRadians(1.22173));
         mikaeli.drawString("9", 225,215);
         g2D.rotate(Math.toRadians(1.22173));
         mikaeli.drawString("10", 230,135);
        g2D.rotate(Math.toRadians(0.523599));
        mikaeli.setColor(four);
        mikaeli.fillRoundRect(615, 20, 170, 100, 40, 40);
        mikaeli.setColor(Color.white);
        Font font2 = new Font("Colleged", Font.BOLD, 14);
           mikaeli.setFont(font2);
        mikaeli.drawString("Mikaeli Bain",630,70);
        
         
         
}
} // end class DrawPanel