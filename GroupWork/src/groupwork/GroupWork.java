/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupwork;
import java.io.File;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Alice bain
 */
public class GroupWork {
    //Arrays that hold the values for the age ranges and the compliments
    static Object[] ages = {"1-8", "9-14", "15-20","21 and up"};
    static String[] positive = {"Good Job", "Excellent", "Amazing","Wow!","Incredible 👏", "Cool"};
    
        Random pos = new Random();
 public static final int check  = new Random().nextInt(positive.length);
 
 //Random values for the first integer
 public static final Random RANDOMFORNUMBER1 =new Random();
 public static int max1 = 10;
 public static int max2 = 30;
 public static int max3 = 50;
 public static int max4 = 100;
 public static int min1 = 1;

 //Random values for the second integer
    public static final Random RANDOMFORNUMBER2 =new Random();
        public static int max = 10;
         public static int maxSEC = 30;
        public static int maxTHR = 50;
         public static int maxFOURTH = 100;
        public static int min = 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ImageIcon welcome, age1, questions, wait, correct, wrong, score, quitPic;
        
        //set variable type to string
        
        
        //set variable values to the image
        welcome = new ImageIcon("Mikaeli Bain Pics" + File.separator + "welcome.gif");
        age1 = new ImageIcon("Mikaeli Bain Pics" + File.separator + "age.gif");
        questions = new ImageIcon("Mikaeli Bain Pics" + File.separator + "wait.gif");
        correct = new ImageIcon("Mikaeli Bain Pics" + File.separator + "correct.gif");
        wait = new ImageIcon("Mikaeli Bain Pics" + File.separator + "questions.gif");
        wrong = new ImageIcon("Mikaeli Bain Pics" + File.separator + "wrong.gif");
        score = new ImageIcon("Mikaeli Bain Pics" + File.separator + "score.gif");
        quitPic = new ImageIcon("Mikaeli Bain Pics" + File.separator + "quit.gif");
        String userName = (String)JOptionPane.showInputDialog(null, "Welcome to our math game. What is your name?" , "Welcome to our math game.", JOptionPane.INFORMATION_MESSAGE, welcome, null, null);
        String age = (String)JOptionPane.showInputDialog(null, "What is your age?" , "How old are you " + userName + "?", JOptionPane.INFORMATION_MESSAGE, age1, ages, ages[0]);
        JOptionPane.showMessageDialog(null, "Here are the rules of the game: \n You must answer all questions \n If you want to quit at anytime, type QUIT." , "Rules of the game", JOptionPane.INFORMATION_MESSAGE);    
            //if age is in the range 1-8, then this happens
            if(ages[0] == age) {
                int total = 0;
                int ct = 0;
                 int track = 0;
                //an infinite loop
                while(ct < 1) {
                    
                //saves the length of the array         
                int check  = new Random().nextInt(positive.length);
                Random myGen = new Random();
                Random myGen2 = new Random();
                   //makes two random values to operate on between 1 and 10
                    int saveInt = (int)(Math.random() * (max1-min1) + min1);
                    int saveInt2 = (int)(Math.random() * (max-min) + min1);
                    Random r = new Random();

                    //randomise math operations; in this case it is addition and substraction
                            char operator ='?';
                            int value = 0;

                            switch (r.nextInt(2)){
                              case 0: operator = '+';
                                      value = saveInt + saveInt2;
                                      break;
                              case 1: operator = '-';
                                      value = saveInt - saveInt2;
                                      break;
                              default: operator = '-';
                            }
                           //Asks the math question
                           track = track + 1;
                    String quest = (String)JOptionPane.showInputDialog(null, "What is " + saveInt + operator + saveInt2 + "?" , "Question " + track, JOptionPane.INFORMATION_MESSAGE, questions, null, null);
                    //If user inputs nothing, the question is repeated until the user answers
                    while (quest.isEmpty()) {
                        quest = (String)JOptionPane.showInputDialog(null, "What is " + saveInt + operator + saveInt2 + "?" , "Question " + track, JOptionPane.INFORMATION_MESSAGE, wait, null, null);
                            }
                    //changes the data type from string to integer
                  int quest1 = Integer.parseInt(quest);
                    
                    //if answer is correct, give the user 1 point and display that they were correct using a random array
                   if(quest1 == (value)) {
                       total = total + 1;
                        JOptionPane.showMessageDialog(null, positive[check] , "That is correct!", JOptionPane.INFORMATION_MESSAGE,correct);
                        //Ask user if they want to quit, if they do, let them quit and show them their final score
                       String quit = (String)JOptionPane.showInputDialog(null, "Do you want to quit? If so, type QUIT" , "Do you wish to quit?", JOptionPane.INFORMATION_MESSAGE, quitPic,null,null);
                        if(quit.equals("QUIT")) {
                            JOptionPane.showMessageDialog(null, "Your score is " + total , "Goodbye", JOptionPane.INFORMATION_MESSAGE,score);
                            break;
                        }
                    // if user answers incorrectly, minus 1 point from their total score, and use a switch statement to randomise the comments that tell them that they are wrong
                   }else {
                       total = total - 1;
                       int which = (int)(Math.random() * 3);  //  Result is 0, 1, or 2.

                switch (which) {
                    case 0:  JOptionPane.showMessageDialog(null, "You were wrong!", "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                             break;
                    case 1:  JOptionPane.showMessageDialog(null, "Incorrect!" , "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                             break;
                    case 2:  JOptionPane.showMessageDialog(null, "Better luck next time!" , "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                             break;
                    default: JOptionPane.showMessageDialog(null, "Wrong!" , "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                    break;
                }
                    //Ask user if they want to quit, if they do, let them quit and show them their final score
                     String quit = (String)JOptionPane.showInputDialog(null, "Do you want to quit? If so, type QUIT" , "Do you wish to quit?", JOptionPane.INFORMATION_MESSAGE, quitPic,null,null);
                        if(quit.equals("QUIT")) {
                            JOptionPane.showMessageDialog(null, "Your score is " + total , "Goodbye!", JOptionPane.INFORMATION_MESSAGE,score);
                            break;
                        }
                   }
                    }
                }else if (ages[1] == age) {
                int total = 0;
                int ct = 0;
                 int track = 0;
                //an infinite loop
                while(ct < 1) {
                    
                //saves the length of the array         
                int check1  = new Random().nextInt(positive.length);
                Random myGen = new Random();
                Random myGen2 = new Random();
                   //makes two random values to operate on between 1 and 10
                    int saveInt = (int)(Math.random() * (max2-min1) + min1);
                    int saveInt2 = (int)(Math.random() * (maxSEC-min) + min1);
                    Random r = new Random();

                    //randomise math operations; in this case it is addition and substraction
                            char operator ='?';
                            int value = 0;

                            switch (r.nextInt(2)){
                              case 0: operator = '+';
                                      value = saveInt + saveInt2;
                                      break;
                              case 1: operator = '-';
                                      value = saveInt - saveInt2;
                                      break;
                              default: operator = '-';
                            }
                           //Asks the math question
                           track = track + 1;
                    String quest = (String)JOptionPane.showInputDialog(null, "What is " + saveInt + operator + saveInt2 + "?" , "Question " + track, JOptionPane.INFORMATION_MESSAGE, questions, null, null);
                    //If user inputs nothing, the question is repeated until the user answers
                    while (quest.isEmpty()) {
                        quest = (String)JOptionPane.showInputDialog(null, "What is " + saveInt + operator + saveInt2 + "?" , "Question " + track, JOptionPane.INFORMATION_MESSAGE, wait, null, null);
                            }
                    //changes the data type from string to integer
                  int quest1 = Integer.parseInt(quest);
                    
                    //if answer is correct, give the user 1 point and display that they were correct using a random array
                   if(quest1 == (value)) {
                       total = total + 1;
                        JOptionPane.showMessageDialog(null, positive[check1] , "That is correct!", JOptionPane.INFORMATION_MESSAGE,correct);
                        //Ask user if they want to quit, if they do, let them quit and show them their final score
                       String quit = (String)JOptionPane.showInputDialog(null, "Do you want to quit? If so, type QUIT" , "Do you wish to quit?", JOptionPane.INFORMATION_MESSAGE, quitPic,null,null);
                        if(quit.equals("QUIT")) {
                            JOptionPane.showMessageDialog(null, "Your score is " + total , "Goodbye", JOptionPane.INFORMATION_MESSAGE,score);
                            break;
                        }
                    // if user answers incorrectly, minus 1 point from their total score, and use a switch statement to randomise the comments that tell them that they are wrong
                   }else {
                       total = total - 1;
                       int which = (int)(Math.random() * 3);  //  Result is 0, 1, or 2.

                switch (which) {
                    case 0:  JOptionPane.showMessageDialog(null, "You were wrong!", "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                             break;
                    case 1:  JOptionPane.showMessageDialog(null, "Incorrect!" , "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                             break;
                    case 2:  JOptionPane.showMessageDialog(null, "Better luck next time!" , "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                             break;
                    default: JOptionPane.showMessageDialog(null, "Wrong!" , "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                    break;
                }
                    //Ask user if they want to quit, if they do, let them quit and show them their final score
                     String quit = (String)JOptionPane.showInputDialog(null, "Do you want to quit? If so, type QUIT" , "Do you wish to quit?", JOptionPane.INFORMATION_MESSAGE, quitPic,null,null);
                        if(quit.equals("QUIT")) {
                            JOptionPane.showMessageDialog(null, "Your score is " + total , "Goodbye!", JOptionPane.INFORMATION_MESSAGE,score);
                            break;
                        }
                   }
                }
                }else if (ages[2] == age)  {
                int total = 0;
                int ct = 0;
                 int track = 0;
                //an infinite loop
                while(ct < 1) {
                    
                //saves the length of the array         
                int check2  = new Random().nextInt(positive.length);
                Random myGen = new Random();
                Random myGen2 = new Random();
                   //makes two random values to operate on between 1 and 10
                    int saveInt = (int)(Math.random() * (max3-min1) + min1);
                    int saveInt2 = (int)(Math.random() * (maxTHR-min) + min1);
                    Random r = new Random();

                    //randomise math operations; in this case it is addition and substraction, multiplication and division
                            
                            char operator ='?';
                             int value = 0;
                             
                            switch (r.nextInt(4)){
                              case 0: operator = '+';
                                      value = saveInt + saveInt2;
                                      break;
                              case 1: operator = '-';
                                      value = saveInt - saveInt2;
                                      break;
                               case 2: operator = '*';
                                      value = saveInt * saveInt2;
                                      break;
                              case 3: operator = '/';
                                      value = saveInt / saveInt2;
                                      break;
                              default: operator = '*';
                            }
                           //Asks the math question
                           track = track + 1;
                    String quest = (String)JOptionPane.showInputDialog(null, "What is " + saveInt + operator + saveInt2 + "?" , "Question " + track, JOptionPane.INFORMATION_MESSAGE, questions, null, null);
                    //If user inputs nothing, the question is repeated until the user answers
                    while (quest.isEmpty()) {
                        quest = (String)JOptionPane.showInputDialog(null, "What is " + saveInt + operator + saveInt2 + "?" , "Question " + track, JOptionPane.INFORMATION_MESSAGE, wait, null, null);
                            }
                    //changes the data type from string to integer
                  int quest1 = Integer.parseInt(quest);
                    
                    //if answer is correct, give the user 1 point and display that they were correct using a random array
                   if(quest1 == (value)) {
                       total = total + 1;
                        JOptionPane.showMessageDialog(null, positive[check2] , "That is correct!", JOptionPane.INFORMATION_MESSAGE,correct);
                        //Ask user if they want to quit, if they do, let them quit and show them their final score
                       String quit = (String)JOptionPane.showInputDialog(null, "Do you want to quit? If so, type QUIT" , "Do you wish to quit?", JOptionPane.INFORMATION_MESSAGE, quitPic,null,null);
                        if(quit.equals("QUIT")) {
                            JOptionPane.showMessageDialog(null, "Your score is " + total , "Goodbye", JOptionPane.INFORMATION_MESSAGE,score);
                            break;
                        }
                    // if user answers incorrectly, minus 1 point from their total score, and use a switch statement to randomise the comments that tell them that they are wrong
                   }else {
                       total = total - 1;
                       int which = (int)(Math.random() * 3);  //  Result is 0, 1, or 2.

                switch (which) {
                    case 0:  JOptionPane.showMessageDialog(null, "You were wrong!", "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                             break;
                    case 1:  JOptionPane.showMessageDialog(null, "Incorrect!" , "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                             break;
                    case 2:  JOptionPane.showMessageDialog(null, "Better luck next time!" , "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                             break;
                    default: JOptionPane.showMessageDialog(null, "Wrong!" , "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                    break;
                }
                    //Ask user if they want to quit, if they do, let them quit and show them their final score
                     String quit = (String)JOptionPane.showInputDialog(null, "Do you want to quit? If so, type QUIT" , "Do you wish to quit?", JOptionPane.INFORMATION_MESSAGE, quitPic,null,null);
                        if(quit.equals("QUIT")) {
                            JOptionPane.showMessageDialog(null, "Your score is " + total , "Goodbye!", JOptionPane.INFORMATION_MESSAGE,score);
                            break;
                        }
                   }
                }
                }else if (ages[3] == age) {
                   int total = 0;
                   int track = 0;
                int ct = 0;
                //an infinite loop
                while(ct < 1) {
                    
                //saves the length of the array         
                int check3  = new Random().nextInt(positive.length);
                Random myGen = new Random();
                Random myGen2 = new Random();
                   //makes two random values to operate on between 1 and 10
                    int saveInt = (int)(Math.random() * (max4-min1) + min1);
                    int saveInt2 = (int)(Math.random() * (maxFOURTH-min) + min1);
                    Random r = new Random();

                    //randomise math operations; in this case it is addition, substraction, multiplication and division
                            
                            char operator ='?';
                            int value = 0;
                                    
                            switch (r.nextInt(4)){
                              case 0: operator = '+';
                                      value = saveInt + saveInt2;
                                      break;
                              case 1: operator = '-';
                                      value = saveInt - saveInt2;
                                      break;
                               case 2: operator = '*';
                                      value = saveInt * saveInt2;
                                      break;
                              case 3: operator = '/';
                                      value = saveInt / saveInt2;
                                      break;
                              default: operator = '/';
                            }
                           //Asks the math question
                           track = track + 1;
                    String quest = (String)JOptionPane.showInputDialog(null, "What is " + saveInt + operator + saveInt2 + "?" , "Question " + track, JOptionPane.INFORMATION_MESSAGE, questions, null, null);
                    
                    //If user inputs nothing, the question is repeated until the user answers
                    while (quest.isEmpty()) {
                        quest = (String)JOptionPane.showInputDialog(null, "What is " + saveInt + operator + saveInt2 + "?" , "Question " + track, JOptionPane.INFORMATION_MESSAGE, wait, null, null);
                            }
                    //changes the data type from string to integer
                  int quest1 = Integer.parseInt(quest);
                    
                    //if answer is correct, give the user 1 point and display that they were correct using a random array
                   if(quest1 == (value)) {
                       total = total + 1;
                        JOptionPane.showMessageDialog(null, positive[check3] , "That is correct!", JOptionPane.INFORMATION_MESSAGE,correct);
                        //Ask user if they want to quit, if they do, let them quit and show them their final score
                       String quit = (String)JOptionPane.showInputDialog(null, "Do you want to quit? If so, type QUIT" , "Do you wish to quit?", JOptionPane.INFORMATION_MESSAGE, quitPic,null,null);
                        if(quit.equals("QUIT")) {
                            JOptionPane.showMessageDialog(null, "Your score is " + total , "Goodbye", JOptionPane.INFORMATION_MESSAGE,score);
                            break;
                        }
                    // if user answers incorrectly, minus 1 point from their total score, and use a switch statement to randomise the comments that tell them that they are wrong
                   }else {
                       total = total - 1;
                       int which = (int)(Math.random() * 3);  //  Result is 0, 1, or 2.

                switch (which) {
                    case 0:  JOptionPane.showMessageDialog(null, "You were wrong!", "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                             break;
                    case 1:  JOptionPane.showMessageDialog(null, "Incorrect!" , "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                             break;
                    case 2:  JOptionPane.showMessageDialog(null, "Better luck next time!" , "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                             break;
                    default: JOptionPane.showMessageDialog(null, "Wrong!" , "That's incorrect", JOptionPane.INFORMATION_MESSAGE,wrong);
                    break;
                }
                    //Ask user if they want to quit, if they do, let them quit and show them their final score
                     String quit = (String)JOptionPane.showInputDialog(null, "Do you want to quit? If so, type QUIT" , "Do you wish to quit?", JOptionPane.INFORMATION_MESSAGE, quitPic,null,null);
                        if(quit.equals("QUIT")) {
                            JOptionPane.showMessageDialog(null, "Your score is " + total , "Goodbye!", JOptionPane.INFORMATION_MESSAGE,score);
                            break;
                        }
                   }
                    }
                }    
                }    
            }                   
       
   