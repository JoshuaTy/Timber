/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import static java.lang.Math.random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author TyJo
 */

class character{
   public static String pos;
   public static int xbounds=0; 
   public static int score=0;
  // public static int highscore=0;
}

public class Game extends JPanel {
    private static MoveSprite moveSprite;
    private static boolean running = false;
  
    public Game(){
       // KeyListener listener = new MyKeyListener();
      
        running = true;
        moveSprite = new MoveSprite();
      
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        JFrame menu = new JFrame();
        menu.setLayout(null);
        JLabel menubackground = new JLabel(new ImageIcon("Images/finalbackground.jpg"));
        menubackground.setLayout(null);
        menubackground.setBounds(0, 0, 800, 500);
        JLabel title = new JLabel("Lumberjack");
        JButton play = new JButton(new ImageIcon("Images/playbutton.png"));
        play.setBounds(300, 360, 120, 75);
        play.setLayout(null);
                  
        
        JLabel objective =  new JLabel("<html>Objective:<br> Just avoid <br> the branches</html>");
        objective.setFont(new Font("ArcadeClassic",Font.BOLD,30));
        objective.setForeground(Color.black);
        objective.setLayout(null);
        objective.setBounds(0,100,1000,100);
        JLabel mane = new JLabel("Tap left or right to play");
        mane.setFont(new Font("ArcadeClassic",Font.BOLD,30));
        mane.setForeground(Color.black);
        mane.setLayout(null);
        mane.setBounds(170,200,1000,100);
        
        
       
        
        //In game frame
        
        JFrame j = new JFrame("LumberJack");
        JLabel background = new JLabel(new ImageIcon("Images/background.jpg"));
        background.setLayout(null);
        background.setBounds(0, 10, 800, 500);
         
        JLabel score = new JLabel("Score 0");
        score.setFont(new Font("ArcadeClassic",Font.PLAIN,30));
        score.setLayout(null);
        score.setBounds(0,20,200,30);
        
        JLabel over = new JLabel();
        over.setText("Game Over!");
        over.setFont(new Font("ArcadeClassic",Font.BOLD,50));
        over.setForeground(Color.YELLOW);
        over.setBounds(230,100,300,150);
        over.setVisible(false);
         
        JLabel highscore = new JLabel("High Score "+character.score);
        highscore.setFont(new Font("ArcadeClassic",Font.BOLD,30));
        highscore.setForeground(Color.YELLOW);
        highscore.setBounds(0,60,300,150);   
       
        
        JLabel p = new JLabel(new ImageIcon("Images/left.jpg"));
        p.setLayout(null);
        p.setBounds(330, 20, 300, 250);
        JLabel q = new JLabel(new ImageIcon("Images/right.jpg"));    
        q.setBounds(420,20,100,50);
        q.setLayout(null);
        
        JLabel man = new JLabel(new ImageIcon("Images/clear.png"));
        man.setLayout(null);
        man.setBounds(70,10,100,30);
        
        
       
        Game keyboardExample = new Game(); 
        
        //Title Frame
        title.setFont(new Font("ArcadeClassic",Font.PLAIN,60));
        title.setForeground(Color.YELLOW);
        title.setLayout(null);
        title.setBounds(230, 0,500,100);
       // menu.add(title);
        menu.add(menubackground);
        menubackground.add(title);
        menubackground.add(play);
        menubackground.add(mane);      
        menubackground.add(objective);       
        menubackground.add(highscore);
        menu.setSize(800,540);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        
        //Game frame
        background.add(p);
        background.add(q);
        background.add(over);
        background.add(highscore);
        highscore.setVisible(false);
        j.add(background);       
        background.add(man);   
        background.add(score);
      
        j.add(keyboardExample);
        j.setSize(800,540);
      
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        j.addKeyListener(moveSprite);
        j.setFocusable(true);
        
         play.addActionListener(new ActionListener(){               
           public void actionPerformed(ActionEvent e){                                                                  
              j.setVisible(true);
           }
        });
     
        while(running){
   
            moveSprite.tick(p,score,over,highscore);
            moveSprite.tickright(q,score,over);
            moveSprite.tickOpposite(man);
            
            try{
            Thread.sleep(8);         
            }catch(Exception e){
                
            }
        }
    }
}
