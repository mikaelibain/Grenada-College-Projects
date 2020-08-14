/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryapp;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.stream.IntStream;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Menu extends JFrame {
	JLabel title;
        JLabel label1;
        JFrame newFrame;
        
       
	public Menu()
	{
		
	JLabel title;
        JLabel label1;	
	JFrame f = new JFrame("Panike");
    
   	 // -------------------------------------------------------
   	 // Make Panel with 5 button
   	 // -------------------------------------------------------
         
         Color color1 = new Color(238,127,121);
   	 JPanel MyPanel1 = new JPanel();
   	 MyPanel1.setLayout( new BorderLayout() );
        
             
             
    
   	 JLabel x1 = new JLabel("Panike",JLabel.NORTH_EAST);
         x1.setFont(new Font("Oraqle Script", Font.PLAIN, 80));
         x1.setForeground(Color.WHITE);

       JLabel x3;
        ImageIcon mimi_chocolate_panike = createImageIcon("mimi_chocolate_panike.png");
        x3 = new JLabel(mimi_chocolate_panike);	 
        x3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        x3.setText("Mimi Chocolate Panike");
        x3.setHorizontalTextPosition(JLabel.CENTER);
        x3.setVerticalTextPosition(JLabel.BOTTOM);
    
        x3.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
          {  
      newFrame = new JFrame(x3.getText());
       newFrame.setVisible(true);
       newFrame.setSize(1400, 1000);
       newFrame.setLocationRelativeTo(null);
       JPanel foodItem = new JPanel();
       foodItem.setLayout( new BorderLayout() );
       
       JPanel detailItem = new JPanel();
       detailItem.setLayout( new BorderLayout() );
       
       ImageIcon muffin_cafe_caramelo = createImageIcon("mini_chocolate_panike_large.png");
       JLabel food = new JLabel(muffin_cafe_caramelo);	 
       JLabel foodName = new JLabel(x3.getText(),JLabel.LEFT);	
       foodName.setFont(new Font("Oraqle Script", Font.PLAIN, 80));
       foodName.setForeground(Color.WHITE);
       
       foodItem.add(foodName,"North");
       JLabel details = new JLabel("A special panike with chocolate sauce inside",JLabel.LEFT);	
       details.setFont(new Font("Sequel", Font.PLAIN, 30));
       details.setForeground(Color.WHITE);
       
       
       JButton addToCart = new JButton("Add to Cart");
      
         foodItem.add(food);
       detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
       detailItem.add(addToCart, BorderLayout.EAST);
       foodItem.setBackground(color1);
       detailItem.setBackground(color1);
       newFrame.add(detailItem, BorderLayout.BEFORE_FIRST_LINE);
       newFrame.getContentPane().add( detailItem, "South");   // Paste My
       newFrame.add(foodItem);
       newFrame.getContentPane().add( foodItem, "Center");   // Paste My
       newFrame.setVisible(true);

    }  
});
                    
		// set panel colors
   	
   	 JLabel x4;
   	 JLabel x5;
    
         
       
             ImageIcon mini_muffin_caramelo = createImageIcon("mini_muffin_caramelo.png");
            x4 = new JLabel(mini_muffin_caramelo);
             x4.setText("Mini Muffin Caramelo"); 
             x4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        x4.setHorizontalTextPosition(JLabel.CENTER);
        x4.setVerticalTextPosition(JLabel.BOTTOM);
            
         x4.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
          {  
      newFrame = new JFrame(x4.getText());
       newFrame.setVisible(true);
       newFrame.setSize(1400, 1000);
       newFrame.setLocationRelativeTo(null);
       JPanel foodItem = new JPanel();
       foodItem.setLayout( new BorderLayout() );
       
       JPanel detailItem = new JPanel();
       detailItem.setLayout( new BorderLayout() );
       
       ImageIcon muffin_cafe_caramelo = createImageIcon("mini_muffin_caramelo_large.png");
       JLabel food = new JLabel(muffin_cafe_caramelo);	 
       JLabel foodName = new JLabel(x4.getText(),JLabel.LEFT);	
       foodName.setFont(new Font("Oraqle Script", Font.PLAIN, 80));
       foodName.setForeground(Color.WHITE);
       
       foodItem.add(foodName,"North");
       JLabel details = new JLabel("A mufin enfused with caramel flavor",JLabel.LEFT);	
       details.setFont(new Font("Sequel", Font.PLAIN, 30));
       details.setForeground(Color.WHITE);
       
      JButton addToCart = new JButton("Add to Cart!");
       addToCart.setSize(50, 50);
       foodItem.add(food);
       detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
       detailItem.add(addToCart, BorderLayout.EAST);
       foodItem.setBackground(color1);
       detailItem.setBackground(color1);
       newFrame.add(detailItem, BorderLayout.BEFORE_FIRST_LINE);
       newFrame.getContentPane().add( detailItem, "South");   // Paste My
       newFrame.add(foodItem);
       newFrame.getContentPane().add( foodItem, "Center");   // Paste My
       newFrame.setVisible(true);
    }  
    }  
});       
        
             ImageIcon mini_pastel_nata = createImageIcon("mini_pastel_nata.png");
            x5 = new JLabel(mini_pastel_nata);	 
            x5.setText("Mini Pastel Nata");
             x5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            x5.setHorizontalTextPosition(JLabel.CENTER);
            x5.setVerticalTextPosition(JLabel.BOTTOM);
               
        x5.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
      newFrame = new JFrame(x5.getText());
       newFrame.setVisible(true);
       newFrame.setSize(1400, 1000);
       newFrame.setLocationRelativeTo(null);
       JPanel foodItem = new JPanel();
       foodItem.setLayout( new BorderLayout() );
       
       JPanel detailItem = new JPanel();
       detailItem.setLayout( new BorderLayout() );
       
       ImageIcon muffin_cafe_caramelo = createImageIcon("mini_pastel_nata_large.png");
       JLabel food = new JLabel(muffin_cafe_caramelo);	 
       JLabel foodName = new JLabel(x5.getText(),JLabel.LEFT);	
       foodName.setFont(new Font("Oraqle Script", Font.PLAIN, 80));
       foodName.setForeground(Color.WHITE);
       
       foodItem.add(foodName,"North");
       JLabel details = new JLabel("A savory trate that is similar in looks to an egg tart",JLabel.LEFT);	
       details.setFont(new Font("Sequel", Font.PLAIN, 30));
       details.setForeground(Color.WHITE);
       
         
       JButton addToCart = new JButton("Add to Cart!");
         foodItem.add(food);
       detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
       detailItem.add(addToCart, BorderLayout.EAST);
       foodItem.setBackground(color1);
       detailItem.setBackground(color1);
       newFrame.add(detailItem, BorderLayout.BEFORE_FIRST_LINE);
       newFrame.getContentPane().add( detailItem, "South");   // Paste My
       newFrame.add(foodItem);
       newFrame.getContentPane().add( foodItem, "Center");   // Paste My
       newFrame.setVisible(true);
    }  
});
         


    

        JTextField field = new JTextField(100);    
        field.setSize(10,20);
       JButton button = new  JButton ("Submit");    
        button.setBounds(50,100,60,30);
             MyPanel1.add(x1,"North");
                          JPanel topRow = new JPanel();
         
        topRow.add( field , BorderLayout.SOUTH);
         topRow.add(x1);
         topRow.setBackground(color1);
         topRow.add(field, BorderLayout.SOUTH);
         topRow.add(button, BorderLayout.SOUTH);
         MyPanel1.add(topRow, BorderLayout.BEFORE_FIRST_LINE);
   	 MyPanel1.add(x3, "East");
   	 MyPanel1.add(x4, "West");
   	 MyPanel1.add(x5, "Center");
         
         MyPanel1.setBackground(color1);
   	 f.getContentPane().add( MyPanel1, "North");   // Add MyPanel1 to North
         
         JPanel MyPanel2 = new JPanel();
    
   	 MyPanel2.setLayout( new BorderLayout() );
       
         button.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
              Hashtable<String, String> hm = new Hashtable<String, String>();
        //add key-value pair to Hashtable
        hm.put("A special panike with chocolate sauce inside", "Mini Chocolate Panike");
        hm.put("A mufin enfused with caramel flavor", "Mini Muffin Caramelo");
        hm.put("A savory trate that is similar in looks to an egg tart", "Mini Pastel Nata");      
        hm.put("A breakfast muffin with a chocolate twist", "Mini Muffin Chocolate");
        hm.put("A savoury baked treat", "Mini Chausson Maca");
        hm.put("A delicious pao de lao topped with vanilla icing and shredded coconut","Bolo Massa Pao de lo");
        
        {  
          String ans = field.getText();
        if(hm.contains(ans)){
            {
                Color color1 = new Color(238,127,121);
                JFrame newFrame = new JFrame(ans);
                newFrame.setVisible(true);
                newFrame.setSize(1400, 1000);
                newFrame.setLocationRelativeTo(null);
                JPanel foodItem = new JPanel();
                foodItem.setLayout( new BorderLayout() );
                
                JPanel detailItem = new JPanel();
                detailItem.setLayout( new BorderLayout() );
                
                 JPanel explainItem = new JPanel();
                explainItem.setLayout( new BorderLayout() );
                
                JTextField field = new JTextField("Quantity"); 
                field.setPreferredSize( new Dimension( 10, 2 ) );
                
                    JLabel foodName = new JLabel(ans,JLabel.LEFT);	
                    foodName.setFont(new Font("Oraqle Script", Font.PLAIN, 80));
                    foodName.setForeground(Color.WHITE);
                      JLabel foodPrice = new JLabel("9",JLabel.RIGHT);	
                   foodPrice .setFont(new Font("Oraqle Script", Font.PLAIN, 80));
                   foodPrice .setForeground(Color.WHITE);
               
                           
                 
                String desc = ans;
                if(desc.equals("Mini Chocolate Panike")) {
                
                JLabel details = new JLabel("A special panike with chocolate sauce inside",JLabel.LEFT);
                 details.setFont(new Font("Sequel", Font.PLAIN, 30));
                details.setForeground(Color.WHITE);
                 detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                 ImageIcon muffin_cafe_caramelo = createImageIcon("mini_chocolate_panike_large.png");
                         JLabel food = new JLabel(muffin_cafe_caramelo);
                          foodItem.add(food);
                          JButton addToCart = new JButton("Add to Cart!");
                            addToCart.setSize(50, 50);
                            foodItem.add(food);
                            detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                            detailItem.add(addToCart, BorderLayout.EAST);
                            addToCart.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    
        JFrame f = new JFrame("Cart");
        JPanel viewOrder = new JPanel();
         Color color1 = new Color(238,127,121);
         viewOrder.setBackground(color1); 
       
        f.add(viewOrder);
        f.setSize(800,800);
   
        JLabel productName,quantity, total;
        productName = new JLabel("Product: " +desc);
         String x = foodPrice.getText();
         
         quantity = new JLabel("Quantity:" + field.getText());
         String quan = field.getText();
         int result = Integer.parseInt(quan);			
         
         int pricing = Integer.parseInt(x);	
         
         int answer = result * pricing;
         String totalPrice = Integer.toString(answer);
         total = new JLabel("Total" + totalPrice);
         viewOrder.add(productName);
         viewOrder.add(quantity);
        viewOrder.add(total);
       JButton button = new  JButton ("Submit Order");    
        button.setBounds(50,100,60,30);  
  
    button.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
         String data1 = productName.getText();
         String data2 = quantity.getText();
         String data3 = total.getText();
         
      
  JFrame f = new JFrame("Receipt");
  f.setSize(800,800);
        JPanel viewOrder = new JPanel();
         Color color1 = new Color(238,127,121);
         viewOrder.setBackground(color1); 
          String[] tblHead={"Item Name","Price","Quantity","Total"};
DefaultTableModel dtm=new DefaultTableModel(tblHead,0);
JTable tbl=new JTable(dtm);
String[] item={productName.getText(),x,quan,total.getText()};
dtm.addRow(tblHead);
dtm.addRow(item);
f.add(viewOrder);
viewOrder.add(tbl);
f.setVisible(true);
   
   
    }  
    });  
       
        f.getContentPane().add( button, BorderLayout.SOUTH);

        f.setVisible(true);
                }


            });
                }
     
                else if(desc.equals("Mini Muffin Caramelo")) {
                JLabel details = new JLabel("A mufin enfused with caramel flavor",JLabel.LEFT);
                 details.setFont(new Font("Sequel", Font.PLAIN, 30));
                details.setForeground(Color.WHITE);
                 detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                 ImageIcon muffin_cafe_caramelo = createImageIcon("mini_muffin_caramelo_large.png");
                        JLabel food = new JLabel(muffin_cafe_caramelo);
                          foodItem.add(food);
                          JButton addToCart = new JButton("Add to Cart!");
                            addToCart.setSize(50, 50);
                            foodItem.add(food);
                            detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                            detailItem.add(addToCart, BorderLayout.EAST);
                            addToCart.addMouseListener(new MouseAdapter() {
                                   @Override
                public void mousePressed(MouseEvent e) {
                    
        JFrame f = new JFrame("Cart");
        JPanel viewOrder = new JPanel();
         Color color1 = new Color(238,127,121);
         viewOrder.setBackground(color1); 
       
        f.add(viewOrder);
        f.setSize(800,800);
   
        JLabel productName,quantity, total;
        productName = new JLabel("Product: " +desc);
         String x = foodPrice.getText();
         
         quantity = new JLabel("Quantity:" + field.getText());
         String quan = field.getText();
         int result = Integer.parseInt(quan);			
         
         int pricing = Integer.parseInt(x);	
         
         int answer = result * pricing;
         String totalPrice = Integer.toString(answer);
         total = new JLabel("Total" + totalPrice);
         viewOrder.add(productName);
         viewOrder.add(quantity);
        viewOrder.add(total);
       JButton button = new  JButton ("Submit Order");    
        button.setBounds(50,100,60,30);  
  
    button.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
         String data1 = productName.getText();
         String data2 = quantity.getText();
         String data3 = total.getText();
         
      
  JFrame f = new JFrame("Receipt");
  f.setSize(800,800);
        JPanel viewOrder = new JPanel();
         Color color1 = new Color(238,127,121);
         viewOrder.setBackground(color1); 
          String[] tblHead={"Item Name","Price","Quantity","Total"};
DefaultTableModel dtm=new DefaultTableModel(tblHead,0);
JTable tbl=new JTable(dtm);
String[] item={productName.getText(),x,quan,total.getText()};
dtm.addRow(tblHead);
dtm.addRow(item);
f.add(viewOrder);
viewOrder.add(tbl);
f.setVisible(true);
   
   
    }  
    });  
       
        f.getContentPane().add( button, BorderLayout.SOUTH);

        f.setVisible(true);
                }


            });         
                }
                else if(desc.equals("Mini Pastel Nata")) {
                JLabel details = new JLabel("A savory trate that is similar in looks to an egg tart",JLabel.LEFT);
                 details.setFont(new Font("Sequel", Font.PLAIN, 30));
                details.setForeground(Color.WHITE);
                 detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                 ImageIcon muffin_cafe_caramelo = createImageIcon("mini_pastel_nata_large.png");
                         JLabel food = new JLabel(muffin_cafe_caramelo);
                          foodItem.add(food);
                          JButton addToCart = new JButton("Add to Cart!");
                            addToCart.setSize(50, 50);
                            foodItem.add(food);
                            detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                            detailItem.add(addToCart, BorderLayout.EAST);
                            addToCart.addMouseListener(new MouseAdapter() {
                                   @Override
                public void mousePressed(MouseEvent e) {
                    
        JFrame f = new JFrame("Cart");
        JPanel viewOrder = new JPanel();
         Color color1 = new Color(238,127,121);
         viewOrder.setBackground(color1); 
       
        f.add(viewOrder);
        f.setSize(800,800);
   
        JLabel productName,quantity, total;
        productName = new JLabel("Product: " +desc);
         String x = foodPrice.getText();
         
         quantity = new JLabel("Quantity:" + field.getText());
         String quan = field.getText();
         int result = Integer.parseInt(quan);			
         
         int pricing = Integer.parseInt(x);	
         
         int answer = result * pricing;
         String totalPrice = Integer.toString(answer);
         total = new JLabel("Total" + totalPrice);
         viewOrder.add(productName);
         viewOrder.add(quantity);
        viewOrder.add(total);
       JButton button = new  JButton ("Submit Order");    
        button.setBounds(50,100,60,30);  
  
    button.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
         String data1 = productName.getText();
         String data2 = quantity.getText();
         String data3 = total.getText();
         
      
  JFrame f = new JFrame("Receipt");
  f.setSize(800,800);
        JPanel viewOrder = new JPanel();
         Color color1 = new Color(238,127,121);
         viewOrder.setBackground(color1); 
          String[] tblHead={"Item Name","Price","Quantity","Total"};
DefaultTableModel dtm=new DefaultTableModel(tblHead,0);
JTable tbl=new JTable(dtm);
String[] item={productName.getText(),x,quan,totalPrice};
dtm.addRow(tblHead);
dtm.addRow(item);
f.add(viewOrder);
viewOrder.add(tbl);
f.setVisible(true);
   
   
    }  
    });  
       
        f.getContentPane().add( button, BorderLayout.SOUTH);

        f.setVisible(true);
                }


            });       
                }
                else if(desc.equals("Mini Muffin Chocolate")) {
                JLabel details = new JLabel("A breakfast muffin with a chocolate twist",JLabel.LEFT);
                 details.setFont(new Font("Sequel", Font.PLAIN, 30));
                details.setForeground(Color.WHITE);
                 detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                 ImageIcon muffin_cafe_caramelo = createImageIcon("mini_muffin_chocolate_large.png");
                          JLabel food = new JLabel(muffin_cafe_caramelo);
                          foodItem.add(food);
                          JButton addToCart = new JButton("Add to Cart!");
                            addToCart.setSize(50, 50);
                            foodItem.add(food);
                            detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                            detailItem.add(addToCart, BorderLayout.EAST);
                            addToCart.addMouseListener(new MouseAdapter() {
                                   @Override
                public void mousePressed(MouseEvent e) {
                    
        JFrame f = new JFrame("Cart");
        JPanel viewOrder = new JPanel();
         Color color1 = new Color(238,127,121);
         viewOrder.setBackground(color1); 
       
        f.add(viewOrder);
        f.setSize(800,800);
   
        JLabel productName,quantity, total;
        productName = new JLabel("Product: " +desc);
         String x = foodPrice.getText();
         
         quantity = new JLabel("Quantity:" + field.getText());
         String quan = field.getText();
         int result = Integer.parseInt(quan);			
         
         int pricing = Integer.parseInt(x);	
         
         int answer = result * pricing;
         String totalPrice = Integer.toString(answer);
         total = new JLabel("Total" + totalPrice);
         viewOrder.add(productName);
         viewOrder.add(quantity);
        viewOrder.add(total);
       JButton button = new  JButton ("Submit Order");    
        button.setBounds(50,100,60,30);  
        String[] chill={productName.getText(),x,quan,total.getText()};
  
    button.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
         String data1 = productName.getText();
         String data2 = quantity.getText();
         String data3 = total.getText();
         
      
  JFrame f = new JFrame("Receipt");
  f.setSize(800,800);
        JPanel viewOrder = new JPanel();
         Color color1 = new Color(238,127,121);
         viewOrder.setBackground(color1); 
          String[] tblHead={"Item Name","Price","Quantity","Total"};
DefaultTableModel dtm=new DefaultTableModel(tblHead,0);
JTable tbl=new JTable(dtm);
String[] item={productName.getText(),x,quan,total.getText()};
dtm.addRow(tblHead);
dtm.addRow(item);
f.add(viewOrder);
viewOrder.add(tbl);
f.setVisible(true);
   
   
    }  
    });  
       
        f.getContentPane().add( button, BorderLayout.SOUTH);

        f.setVisible(true);
                }


            });       
                }
                else if(desc.equals("Mini Chausson Maca")) {
                JLabel details = new JLabel("A savoury baked treat",JLabel.LEFT);
                 details.setFont(new Font("Sequel", Font.PLAIN, 30));
                details.setForeground(Color.WHITE);
                 detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                 ImageIcon muffin_cafe_caramelo = createImageIcon("mini_chausson_maca_large.png");
                        JLabel food = new JLabel(muffin_cafe_caramelo);
                          foodItem.add(food);
                          JButton addToCart = new JButton("Add to Cart!");
                            addToCart.setSize(50, 50);
                            foodItem.add(food);
                            detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                            detailItem.add(addToCart, BorderLayout.EAST);
                            addToCart.addMouseListener(new MouseAdapter() {
                                   @Override
                public void mousePressed(MouseEvent e) {
                    
        JFrame f = new JFrame("Cart");
        JPanel viewOrder = new JPanel();
         Color color1 = new Color(238,127,121);
         viewOrder.setBackground(color1); 
       
        f.add(viewOrder);
        f.setSize(800,800);
   
        JLabel productName,quantity, total;
        productName = new JLabel("Product: " +desc);
         String x = foodPrice.getText();
         
         quantity = new JLabel("Quantity:" + field.getText());
         String quan = field.getText();
         int result = Integer.parseInt(quan);			
         
         int pricing = Integer.parseInt(x);	
         
         int answer = result * pricing;
         String totalPrice = Integer.toString(answer);
         total = new JLabel("Total" + totalPrice);
         viewOrder.add(productName);
         viewOrder.add(quantity);
        viewOrder.add(total);
       JButton button = new  JButton ("Submit Order");    
        button.setBounds(50,100,60,30);  
  
    button.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
         String data1 = productName.getText();
         String data2 = quantity.getText();
         String data3 = total.getText();
         
      
  JFrame f = new JFrame("Receipt");
  f.setSize(800,800);
        JPanel viewOrder = new JPanel();
         Color color1 = new Color(238,127,121);
         viewOrder.setBackground(color1); 
          String[] tblHead={"Item Name","Price","Quantity","Total"};
DefaultTableModel dtm=new DefaultTableModel(tblHead,0);
JTable tbl=new JTable(dtm);
String[] item={productName.getText(),x,quan,totalPrice};
dtm.addRow(tblHead);

dtm.addRow(item);
f.add(viewOrder);
viewOrder.add(tbl);
f.setVisible(true);
   
   
    }  
    });  
       
        f.getContentPane().add( button, BorderLayout.SOUTH);

        f.setVisible(true);
                }


            });       
                }
            
                else {
                JLabel details = new JLabel("A delicious pao de lao topped with vanilla icing and shredded coconut",JLabel.LEFT);
                 details.setFont(new Font("Sequel", Font.PLAIN, 30));
                details.setForeground(Color.WHITE);
                 detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                 ImageIcon muffin_cafe_caramelo = createImageIcon("bolo_massa_pao_de_lo_large.png");
                         JLabel food = new JLabel(muffin_cafe_caramelo);
                          foodItem.add(food);
                           JButton addToCart = new JButton("Add to Cart!");
                            addToCart.setSize(50, 50);
                            foodItem.add(food);
                            detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                            detailItem.add(addToCart, BorderLayout.EAST);
                            
                }
            
            
               

               
                
                foodItem.setBackground(color1);
                explainItem.setBackground(color1);
                detailItem.setBackground(color1);        
                detailItem.add(field, BorderLayout.CENTER );
                newFrame.add(detailItem, BorderLayout.BEFORE_FIRST_LINE);
                newFrame.getContentPane().add( detailItem, "South");   // Paste My
                newFrame.add(foodItem);
                 explainItem.add(foodName, BorderLayout.BEFORE_LINE_BEGINS);
                             explainItem.add(foodPrice, BorderLayout.EAST);
                            newFrame.getContentPane().add(  explainItem, "North");
                newFrame.getContentPane().add( foodItem, "Center");   // Paste My
                newFrame.setVisible(true);
                
            } 
            
        }
        else {
            JOptionPane.showMessageDialog(null, "The product does not exist");
                    }
        
            }  
    }  
});
         
         
         
   
         
       JLabel x7;
        ImageIcon mini_chausson_maca = createImageIcon("mini_muffin_chocolate.png");
        x7 = new JLabel(mini_chausson_maca);
        x7.setText("Mini Muffin Chocolate");
        x7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        x7.setHorizontalTextPosition(JLabel.CENTER);
        x7.setVerticalTextPosition(JLabel.BOTTOM);
                    
		// set panel colors
                
         x7.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
             // i have assumed you have declared "frame" as instance variable
       newFrame = new JFrame(x7.getText());
       newFrame.setVisible(true);
       newFrame.setSize(1400, 1000);
       newFrame.setLocationRelativeTo(null);
       JPanel foodItem = new JPanel();
       foodItem.setLayout( new BorderLayout() );
       
       JPanel detailItem = new JPanel();
       detailItem.setLayout( new BorderLayout() );
       
       ImageIcon muffin_cafe_caramelo = createImageIcon("mini_muffin_chocolate_large.png");
       JLabel food = new JLabel(muffin_cafe_caramelo);	 
       JLabel foodName = new JLabel(x7.getText(),JLabel.LEFT);	
       foodName.setFont(new Font("Oraqle Script", Font.PLAIN, 80));
       foodName.setForeground(Color.WHITE);
       
       foodItem.add(foodName,"North");
       JLabel details = new JLabel("A breakfast muffin with a chocolate twist",JLabel.LEFT);	
       details.setFont(new Font("Sequel", Font.PLAIN, 30));
       details.setForeground(Color.WHITE);
       
         
              JButton addToCart = new JButton("Add to Cart!");
         foodItem.add(food);
       detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
       detailItem.add(addToCart, BorderLayout.EAST);
       foodItem.setBackground(color1);
       detailItem.setBackground(color1);
       newFrame.add(detailItem, BorderLayout.BEFORE_FIRST_LINE);
       newFrame.getContentPane().add( detailItem, "South");   // Paste My
       newFrame.add(foodItem);
       newFrame.getContentPane().add( foodItem, "Center");   // Paste My
       newFrame.setVisible(true);
    }  
});
   	
   	 JLabel x8;
   	 JLabel x9;
    
         
       
             ImageIcon mini_muffin_limao = createImageIcon("mini_chausson_maca.png");
            x8 = new JLabel(mini_muffin_limao);	 
             x8.setText("Mini Chausson Maca");
             x8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        x8.setHorizontalTextPosition(JLabel.CENTER);
        x8.setVerticalTextPosition(JLabel.BOTTOM);
        
         x8.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
           // i have assumed you have declared "frame" as instance variable
       newFrame = new JFrame(x8.getText());
       newFrame.setVisible(true);
       newFrame.setSize(1400, 1000);
       newFrame.setLocationRelativeTo(null);
       JPanel foodItem = new JPanel();
       foodItem.setLayout( new BorderLayout() );
       
       JPanel detailItem = new JPanel();
       detailItem.setLayout( new BorderLayout() );
       
       ImageIcon muffin_cafe_caramelo = createImageIcon("mini_chausson_maca_large.png");
       JLabel food = new JLabel(muffin_cafe_caramelo);	 
       JLabel foodName = new JLabel(x8.getText(),JLabel.LEFT);	
       foodName.setFont(new Font("Oraqle Script", Font.PLAIN, 80));
       foodName.setForeground(Color.WHITE);
       
       foodItem.add(foodName,"North");
       JLabel details = new JLabel("A savoury baked treat",JLabel.LEFT);	
       details.setFont(new Font("Sequel", Font.PLAIN, 30));
       details.setForeground(Color.WHITE);
       
         
       JButton addToCart = new JButton("Add to Cart!");
         foodItem.add(food);
       detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
       detailItem.add(addToCart, BorderLayout.EAST);
       foodItem.setBackground(color1);
       detailItem.setBackground(color1);
       newFrame.add(detailItem, BorderLayout.BEFORE_FIRST_LINE);
       newFrame.getContentPane().add( detailItem, "South");   // Paste My
       newFrame.add(foodItem);
       newFrame.getContentPane().add( foodItem, "Center");   // Paste My
       newFrame.setVisible(true);
    }  
});
               
             ImageIcon bolo_massa_pao_de_lo = createImageIcon("bolo_massa_pao_de_lo.png");
            x9 = new JLabel(bolo_massa_pao_de_lo);	 
        x9.setText("Bolo Massa Pao de lo");
         x9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        x9.setHorizontalTextPosition(JLabel.CENTER);
        x9.setVerticalTextPosition(JLabel.BOTTOM);  
       
         x9.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
              // you can open a new frame here as
       // i have assumed you have declared "frame" as instance variable
       newFrame = new JFrame(x9.getText());
       newFrame.setVisible(true);
       newFrame.setSize(1400, 1000);
       newFrame.setLocationRelativeTo(null);
       JPanel foodItem = new JPanel();
       foodItem.setLayout( new BorderLayout() );
       
       JPanel detailItem = new JPanel();
       detailItem.setLayout( new BorderLayout() );
       
       ImageIcon muffin_cafe_caramelo = createImageIcon("bolo_massa_pao_de_lo_large.png");
       JLabel food = new JLabel(muffin_cafe_caramelo);	 
       JLabel foodName = new JLabel(x9.getText(),JLabel.LEFT);	
       foodName.setFont(new Font("Oraqle Script", Font.PLAIN, 80));
       foodName.setForeground(Color.WHITE);
       
       foodItem.add(foodName,"North");
       JLabel details = new JLabel("A delicious pao de lao topped with vanilla icing and shredded coconut",JLabel.LEFT);	
       details.setFont(new Font("Sequel", Font.PLAIN, 30));
       details.setForeground(Color.WHITE);
       
      JButton addToCart = new JButton("Add to Cart!");
         foodItem.add(food);
       detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
       detailItem.add(addToCart, BorderLayout.EAST);
       foodItem.setBackground(color1);
       detailItem.setBackground(color1);
       newFrame.add(detailItem, BorderLayout.BEFORE_FIRST_LINE);
       newFrame.getContentPane().add( detailItem, "South");   // Paste My
       newFrame.add(foodItem);
       newFrame.getContentPane().add( foodItem, "Center");   // Paste My
       newFrame.setVisible(true);
    }  
});
         
   	 MyPanel2.add(x7, "East");
   	 MyPanel2.add(x8, "West");
   	 MyPanel2.add(x9, "Center");
         
         MyPanel2.setBackground(color1);
    
         
         
   	// f.getContentPane().add( MyPanel2, "South");   // Paste MyPanel2 to South
      f.getContentPane().add(MyPanel2, "Center");  // Paste MyPanel2 to Center     
 
         JPanel MyPanel3 = new JPanel();
    
   	MyPanel3.setLayout( new BorderLayout() );
       
   
         
       JLabel x10;
        ImageIcon glazy_doonys = createImageIcon("glazy_doonys.png");
        x10 = new JLabel(glazy_doonys);	 
        x10.setText("Glazy Doonys");
        x10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        x10.setHorizontalTextPosition(JLabel.CENTER);
        x10.setVerticalTextPosition(JLabel.BOTTOM);            
		// set panel colors
        
         x10.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
        // you can open a new frame here as
       // i have assumed you have declared "frame" as instance variable
       newFrame = new JFrame(x10.getText());
       newFrame.setVisible(true);
       newFrame.setSize(1400, 1000);
       newFrame.setLocationRelativeTo(null);
       JPanel foodItem = new JPanel();
       foodItem.setLayout( new BorderLayout() );
       
       JPanel detailItem = new JPanel();
       detailItem.setLayout( new BorderLayout() );
       
       ImageIcon muffin_cafe_caramelo = createImageIcon("glazy_doonys_large.png");
       JLabel food = new JLabel(muffin_cafe_caramelo);	 
       JLabel foodName = new JLabel("Glazy Doonys",JLabel.LEFT);	
       foodName.setFont(new Font("Oraqle Script", Font.PLAIN, 80));
       foodName.setForeground(Color.WHITE);
       
       foodItem.add(foodName,"North");
       JLabel details = new JLabel("A sinple but delicious glazed donut",JLabel.LEFT);	
       details.setFont(new Font("Sequel", Font.PLAIN, 30));
       details.setForeground(Color.WHITE);
       
            JButton addToCart = new JButton("Add to Cart!");
         foodItem.add(food);
       detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
       detailItem.add(addToCart, BorderLayout.EAST);
       foodItem.setBackground(color1);
       detailItem.setBackground(color1);
       newFrame.add(detailItem, BorderLayout.BEFORE_FIRST_LINE);
       newFrame.getContentPane().add( detailItem, "South");   // Paste My
       newFrame.add(foodItem);
       newFrame.getContentPane().add( foodItem, "Center");   // Paste My
       newFrame.setVisible(true);
    }  
});
   	
   	 JLabel x11;
   	 JLabel x12;
    
         
       
             ImageIcon queijada_feijao = createImageIcon("queijada_feijao.png");
            x11 = new JLabel(queijada_feijao);	 
            x11.setText("Queijada Feijao");
            x11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            x11.setHorizontalTextPosition(JLabel.CENTER);
            x11.setVerticalTextPosition(JLabel.BOTTOM);
               
             x11.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
// you can open a new frame here as
       // i have assumed you have declared "frame" as instance variable
       newFrame = new JFrame(x11.getText());
       newFrame.setVisible(true);
       newFrame.setSize(1400, 1000);
       newFrame.setLocationRelativeTo(null);
       JPanel foodItem = new JPanel();
       foodItem.setLayout( new BorderLayout() );
       
       JPanel detailItem = new JPanel();
       detailItem.setLayout( new BorderLayout() );
       
       ImageIcon muffin_cafe_caramelo = createImageIcon("queijada_feijao_large.png");
       JLabel food = new JLabel(muffin_cafe_caramelo);	 
       JLabel foodName = new JLabel("Queijada Feijao",JLabel.LEFT);	
       foodName.setFont(new Font("Oraqle Script", Font.PLAIN, 80));
       foodName.setForeground(Color.WHITE);
       
       foodItem.add(foodName,"North");
       JLabel details = new JLabel("A nice tasty thing",JLabel.LEFT);	
       details.setFont(new Font("Sequel", Font.PLAIN, 30));
       details.setForeground(Color.WHITE);
       
         
            JButton addToCart = new JButton("Add to Cart!");
       foodItem.add(food);
       detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
       detailItem.add(addToCart, BorderLayout.EAST);
       foodItem.setBackground(color1);
       detailItem.setBackground(color1);
       newFrame.add(detailItem, BorderLayout.BEFORE_FIRST_LINE);
       newFrame.getContentPane().add( detailItem, "South");   // Paste My
       newFrame.add(foodItem);
       newFrame.getContentPane().add( foodItem, "Center");   // Paste My
       newFrame.setVisible(true);
    }  
});
            
             ImageIcon muffin_cafe_caramelo = createImageIcon("muffin_cafe_caramelo.png");
            x12 = new JLabel(muffin_cafe_caramelo);	 
            x12.setText("Muffin Cafe Caramelo");
            x12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            x12.setHorizontalTextPosition(JLabel.CENTER);
            x12.setVerticalTextPosition(JLabel.BOTTOM);   
       
             x12.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
       // you can open a new frame here as
       // i have assumed you have declared "frame" as instance variable
       newFrame = new JFrame(x12.getText());
       newFrame.setVisible(true);
       newFrame.setSize(1400, 1000);
       newFrame.setLocationRelativeTo(null);
       JPanel foodItem = new JPanel();
       foodItem.setLayout( new BorderLayout() );
       
       JPanel detailItem = new JPanel();
       detailItem.setLayout( new BorderLayout() );
       
       ImageIcon muffin_cafe_caramelo = createImageIcon("muffin_carmelo_large.png");
       JLabel food = new JLabel(muffin_cafe_caramelo);	 
       JLabel foodName = new JLabel("Muffin Cafe Caramelo",JLabel.LEFT);	
       foodName.setFont(new Font("Oraqle Script", Font.PLAIN, 80));
       foodName.setForeground(Color.WHITE);
       
       
       foodItem.add(foodName,"North");
       JLabel details = new JLabel("A Coffe muffin drenched in Caramel Sauce",JLabel.LEFT);	
       details.setFont(new Font("Sequel", Font.PLAIN, 30));
       details.setForeground(Color.WHITE);
       
         
       JButton addToCart = new JButton("Add to Cart!");
        foodItem.add(food);
       detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
       detailItem.add(addToCart, BorderLayout.EAST);
       foodItem.setBackground(color1);
       detailItem.setBackground(color1);
       newFrame.add(detailItem, BorderLayout.BEFORE_FIRST_LINE);
       newFrame.getContentPane().add( detailItem, "South");   // Paste My
       newFrame.add(foodItem);
       newFrame.getContentPane().add( foodItem, "Center");   // Paste My
       newFrame.setVisible(true);
       
      
       
    }  
});
            
   	 MyPanel3.add(x10, "East");
   	 MyPanel3.add(x11, "West");
   	 MyPanel3.add(x12, "Center");
         
         MyPanel3.setBackground(color1);
    
         
         
   	f.getContentPane().add( MyPanel3, "South");   // Paste MyPanel3 to South
         
   	 f.setSize(1400, 1000);
         f.setLocationRelativeTo(null);
   	 f.setVisible(true);
		
           
	}// end constructor

        

        
	public static void main(String[] args)
	{
		new Menu();

  
	}// end of main 
  protected static ImageIcon createImageIcon(String path) {
            java.net.URL imgURL = Menu.class.getResource(path);  if (imgURL != null) {
            return new ImageIcon(imgURL);
            } else {
//if the file cannot be found, print out "couldn't find file" to the console and return a null value
            System.err.println("Couldn't find file: " + path);  return null;
            }
        }// end createAndShowGUI

 
}// end of class