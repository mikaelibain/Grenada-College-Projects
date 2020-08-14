/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryapp;
import static bakeryapp.Menu.createImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
   
public class MyHashtableValueSearch {
  
    public static void main(String a[]){
        Hashtable<String, String> hm = new Hashtable<String, String>();
        //add key-value pair to Hashtable
        hm.put("A special panike with chocolate sauce inside", "Mini Chocolate Panike");
        hm.put("A mufin enfused with caramel flavor", "Mini Muffin Caramelo");
        hm.put("A savory trate that is similar in looks to an egg tart", "Mini Pastel Nata");      
        hm.put("A breakfast muffin with a chocolate twist", "Mini Muffin Chocolate");
        hm.put("A savoury baked treat", "Mini Chausson Maca");
        hm.put("A delicious pao de lao topped with vanilla icing and shredded coconut","Bolo Massa Pao de lo");
        


        JFrame f = new JFrame("My First GUI");

  
        JTextField field = new JTextField(20);    
        field.setSize(100,20);
        f.add(field);
       
        
       JButton button = new  JButton ("Submit");    
        button.setBounds(50,100,60,30);  
        f.add(button, BorderLayout.EAST);
   f.setSize(400,300);
        f.setVisible(true);
    button.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
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
                
                ImageIcon muffin_cafe_caramelo = createImageIcon("mini_chocolate_panike_large.png");
                JLabel food = new JLabel(muffin_cafe_caramelo);
                JLabel foodName = new JLabel(ans,JLabel.LEFT);
                foodName.setFont(new Font("Oraqle Script", Font.PLAIN, 80));
                foodName.setForeground(Color.WHITE);
                
                foodItem.add(foodName,"North");
                String desc = ans;
                if(desc.equals("Mini Chocolate Panike")) {
                
                JLabel details = new JLabel("A delicious pao de lao topped with vanilla icing and shredded coconut",JLabel.LEFT);
                 details.setFont(new Font("Sequel", Font.PLAIN, 30));
                details.setForeground(Color.WHITE);
                 detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                }
                else if(desc.equals("Mini Muffin Caramelo")) {
                JLabel details = new JLabel("A mufin enfused with caramel flavor",JLabel.LEFT);
                 details.setFont(new Font("Sequel", Font.PLAIN, 30));
                details.setForeground(Color.WHITE);
                 detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                }
                else if(desc.equals("Mini Pastel Nata")) {
                JLabel details = new JLabel("A savory trate that is similar in looks to an egg tart",JLabel.LEFT);
                 details.setFont(new Font("Sequel", Font.PLAIN, 30));
                details.setForeground(Color.WHITE);
                 detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                }
                else if(desc.equals("Mini Muffin Chocolate")) {
                JLabel details = new JLabel("A breakfast muffin with a chocolate twist",JLabel.LEFT);
                 details.setFont(new Font("Sequel", Font.PLAIN, 30));
                details.setForeground(Color.WHITE);
                 detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                }
                else if(desc.equals("Mini Chausson Maca")) {
                JLabel details = new JLabel("A savoury baked treat",JLabel.LEFT);
                 details.setFont(new Font("Sequel", Font.PLAIN, 30));
                details.setForeground(Color.WHITE);
                 detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                }
            
                else {
                JLabel details = new JLabel("A delicious pao de lao topped with vanilla icing and shredded coconut",JLabel.LEFT);
                 details.setFont(new Font("Sequel", Font.PLAIN, 30));
                details.setForeground(Color.WHITE);
                 detailItem.add(details, BorderLayout.BEFORE_LINE_BEGINS);
                }
            
            
               

               
                
                foodItem.setBackground(color1);
                detailItem.setBackground(color1);
                newFrame.add(detailItem, BorderLayout.BEFORE_FIRST_LINE);
                newFrame.getContentPane().add( detailItem, "South");   // Paste My
                newFrame.add(foodItem);
                newFrame.getContentPane().add( foodItem, "Center");   // Paste My
                newFrame.setVisible(true);
                
            }
        }
            }  
    }); 
    
    }
    
}