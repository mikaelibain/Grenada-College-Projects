/*
 * Mikaeli Bain
 * 11/3/2017
 * Java Programming: Assignment1
 */
package datareach;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;

// Clock class
class Clock extends JComponent {
    
    // constants
    private static final double TWO_PI   = 2.0 * Math.PI;
    
    private static final int    UPDATE_INTERVAL = 100;  // Millisecs
    

    private final Calendar _now = Calendar.getInstance();  // Current time.
    
    private int _diameter;                 // Height and width of clock face
    private int _centerX;                  // x coord of middle of clock
    private int _centerY;                  // y coord of middle of clock
    private BufferedImage _clockImage;     // Saved image of the clock face.
    
    private final javax.swing.Timer _timer;      // Fires to update clock.
    
    //Clock constructor
    public Clock() {
        setPreferredSize(new Dimension(800,500));
        _timer = new javax.swing.Timer(UPDATE_INTERVAL, (ActionEvent e) -> {
            updateTime();
            repaint();
        });
    }
    
    /** Start the timer. */
    public void start() {
        _timer.start(); 
    }
    
    /** Stop the timer. */
    public void stop() {
        _timer.stop(); 
    }
    
    //Ensuress that the clock's time is continually updated so that the time is accurate
    private void updateTime() {
        //... Avoid creating new objects.
        _now.setTimeInMillis(System.currentTimeMillis());
    }
    
    //Where all graphical components are created: paintComponent
    @Override public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        //The panel may have been resized, get current dimensions
        int w = getWidth();
        int h = getHeight();
        _diameter = ((w < h) ? w : h);
        _centerX = _diameter / 2;
        _centerY = _diameter / 2;
        
        // Create the clock face background image if this is the first time,or if the size of the panel has changed
        if (_clockImage == null
                || _clockImage.getWidth() != w
                || _clockImage.getHeight() != h) {
            _clockImage = (BufferedImage)(this.createImage(w, h));
            
            //Get a graphics context from this image
            Graphics2D g2a = _clockImage.createGraphics();
            g2a.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                 RenderingHints.VALUE_ANTIALIAS_ON);
            drawClockFace(g2a);
        }
        
        //Draw the clock face from the precomputed image
        g2.drawImage(_clockImage, null, 0, 0);
        
        //Draw the clock hands dynamically each time.
        drawClockHands(g2);
    }
    //four undefined colors
     private static final Color yell = new Color(229, 227, 117);
     private final static Color inside = new Color(246, 238, 232);
     private final static Color teal_ish = new Color(47, 197, 186);
     private final static Color cool = new Color(0, 106, 193);
     
    private void drawClockHands(Graphics2D g2) {
        //Get the current time from the Calendar object.
        int hours   = _now.get(Calendar.HOUR);
        int minutes = _now.get(Calendar.MINUTE);
        int seconds = _now.get(Calendar.SECOND);
        int millis  = _now.get(Calendar.MILLISECOND);
        
        //draw the second hand
        int handMin = _diameter / 8;    // Second hand doesn't start in middle.
        int handMax = _diameter / 2;    // Second hand extends to outer rim.
        double fseconds = (seconds + (double)millis/1000) / 60.0;
         g2.setColor(cool);
        drawRadius(g2, fseconds, 0, handMax);
        
        //draw the minute hand
        handMin = 0;                    // Minute hand starts in middle.
        handMax = _diameter / 3; 
        
        double fminutes = (minutes + fseconds) / 60.0;
         g2.setColor(teal_ish);
        drawRadius(g2, fminutes, 0, handMax);
        
        //draw the hour hand
        handMin = 0;
        handMax = _diameter / 4;
        //first pre-defined color
        g2.setColor(Color.red);
        drawRadius(g2, (hours + fminutes) / 12.0, 0, handMax);
    }
    
    
    private void drawClockFace(Graphics2D g2) {
        // Draw the clock face.
         g2.rotate(Math.toRadians(0.523599));
        int [] x1 = {460,460,500,500,560,500,500};
    int [] y = {55,85,85,110,70,30,55};
    g2.drawPolygon(x1, y, 7);
       
        g2.setColor(inside);
        g2.fillOval(0, 0, _diameter, _diameter);
        g2.setColor(yell);
        g2.setStroke(new BasicStroke(4F));
        g2.drawOval(0, 0, _diameter, _diameter);
        g2.drawOval(0, 0, _diameter, _diameter);
        
        int radius = _diameter / 2;
        //Draw the tick marks around the circumference.
        for (int sec = 0; sec < 60; sec++) {
            g2.setStroke(new BasicStroke(1F));
            //second pre-defined color
            g2.setColor(Color.gray);
            int tickStart;
            if (sec%5 == 0) {
                 g2.setStroke(new BasicStroke(2F));
                tickStart = radius - 15;  // Draw long tick mark every 5
            } else {
                tickStart = radius - 5;   // Short tick mark.
            }
            drawRadius(g2, sec / 60.0, tickStart , radius);
        }
        
        //third pre-defined color
        g2.setColor(Color.black);
        Font font4 = new Font("Calibri", Font.BOLD, 14);
          
        g2.setFont(font4);
        g2.drawString("Mikaeli Bain",205, 185);
         Font font3 = new Font("Ailerons", Font.BOLD, 20);
          
        g2.setFont(font3);
        g2.drawString("It shows the"
                + " real time.",525,235);
        g2.drawString("Go ahead, check.",525,255);
        Font font1= new Font("Verdana", Font.BOLD, 20);
          
        g2.setFont(font1);
        //Place the numbers along the circumference of the circle
        g2.setColor(Color.black);
        g2.drawString("12", 248, 65);
        g2.drawString("6", 248, 455);
        g2.drawString("5", 338, 412);
        g2.drawString("7", 158,412);
        g2.drawString("8", 98,345);
        g2.drawString("11", 158,90);
        g2.drawString("10", 100,160);
         
         g2.rotate(Math.toRadians(0.523599));
         g2.drawString("1", 338,80);
         g2.rotate(Math.toRadians(1.0472));
         g2.drawString("2", 418,150);
         g2.rotate(Math.toRadians(1.5708));
         g2.drawString("3", 448,230);
         g2.rotate(Math.toRadians(2.0944));
         g2.drawString("4", 438,315);
         g2.rotate(Math.toRadians(1.22173));
         g2.drawString("9", 95,245);
         //Draw a rounded rectangle that has some text
         //fourth pre-defined color
         g2.setColor(Color.pink);
        g2.fillRoundRect(580, -30, 150, 100, 40, 40);
        //fifth predefined color
         g2.setColor(Color.white);
        Font font2 = new Font("Colleged", Font.BOLD, 14);
        g2.setFont(font2);
        g2.drawString("Analog clock",585,25);
        int teller;
        //Set the amount of flowers you want to have in the pic. I chose three.
    int amount = 3;
    int x = 1;
    for (teller=1; teller <= amount ;teller++) { 

        //Draw the stems of the flowers
    g2.setColor(Color.GREEN);  //stem
    g2.fillRect(540 + x, 350, 10, 100);

    //Draw the petals and the inside
    g2.setColor(Color.PINK); //petals
    g2.fillOval(524 + x, 290, 25, 25);
    g2.fillOval(550 + x, 310, 25, 25);
    g2.fillOval(540 + x, 340, 25, 25);
    g2.fillOval(510 + x, 340, 25, 25);
    g2.fillOval(500 + x, 310, 25, 25);

    g2.setColor(Color.YELLOW);  //pistil
    g2.fillOval(524 + x, 315, 30, 30);

     x = teller * 80;  
    }
    }
    /* This draw lines along a radius from the clock face center.
    By changing the parameters, it can be used to draw tick marks, as well as the hands.*/
    private void drawRadius(Graphics2D g2, double percent,
                            int minRadius, int maxRadius) {
        /* percent parameter is the fraction (0.0 - 1.0) of the way, clockwise from 12.   
        Because the Graphics2D methods use radians ,counterclockwise from 3, 
        a little conversion is necessary.*/
        double radians = (0.5 - percent) * TWO_PI;
        double sine   = Math.sin(radians);
        double cosine = Math.cos(radians);
        
        int dxmin = _centerX + (int)(minRadius * sine);
        int dymin = _centerY + (int)(minRadius * cosine);
        
        int dxmax = _centerX + (int)(maxRadius * sine);
        int dymax = _centerY + (int)(maxRadius * cosine);
        
        g2.drawLine(dxmin, dymin, dxmax, dymax);
    }
}