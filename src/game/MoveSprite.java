/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import static com.sun.org.apache.xalan.internal.lib.ExsltMath.random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Math.random;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author TyJo
 */
public class MoveSprite implements KeyListener{   
    private boolean up,down,right,left;
    private boolean[] keys;
    private int moveX, moveY;
    
    public void tick(JLabel j,JLabel s,JLabel o,JLabel h){
        moveX = j.getX();
        moveY = j.getY();
        int score = 0;
        boolean bool = true;
        Random x=new Random();
        
        if(right){
            moveY += 4;         
           // System.out.println(moveY);
            character.score++;
          
            
            s.setText("Score " + character.score); 
            h.setText("High Score "+score);          
          
            
             if(character.xbounds==380 && (moveY>=216 && moveY <=300 && moveX == 330) ){
                    System.out.println("right collides");                  
                    o.setVisible(true);    
                    //character.score=0;
                   // h.setVisible(true);
                }        
                      
        }
       
        // for checking if left branch collides
        if(left){
            
            moveY += 4;          
            character.score++;
            score =  character.score;
            
            s.setText("Score " + character.score);  
            h.setText("High Score "+score);
           // h.setVisible(true); 
           // System.out.println(moveY);         
                           
        }
        if(character.xbounds==70 && (moveY>=216 && moveY <=300 && moveX == 90) ){
                    System.out.println("left collides");                  
                    o.setVisible(true);    
                  //  character.score=0;                    
                                   
                }          
        if(moveY>260){      
                moveY=0;
                 moveX= (x.nextInt()% 2 == 0) ? 330 : 90;                          
            } 
        
         score= character.score;     
       
      j.setBounds(moveX, moveY, 300, 250);
    }
    
    public void tickright(JLabel q,JLabel s,JLabel o){
        moveX = q.getX();
        moveY = q.getY();
        Random x= new Random();
        
        if(right){
            moveY += 4;         
            
            if(character.xbounds==380 && (moveY>=324 && moveY <=390&& moveX == 420)){
                System.out.println("right collides");    
                o.setVisible(true);
                
            }               
        }
      
        if(left){
            moveY += 4;    
            System.out.println(moveY);
            //character.pos.equalsIgnoreCase("left")
            if(character.xbounds==70 && (moveY>=324 && moveY <=390 && moveX == 200)){
                System.out.println("left collides");
                o.setVisible(true);
             //   q.setBounds(114, moveY, 300, 250);
               // character.score=0;
            }  
        }
        //when you tap right
        if(moveY>=360){
             moveY=-10;
             moveX = (x.nextInt()% 2 == 0) ? 200 : 420; 
            // q.setBounds(moveX, moveY, 300, 250);
            }     
         q.setBounds(moveX,moveY,100,10);
    }
    
    public void tickOpposite(JLabel j){
        moveX = j.getX();
        moveY = j.getY();
        
        
        if(right){
            moveX = 380;
        character.pos="right";
        character.xbounds=380;
        } 
        if(left){
            moveX = 70;
        character.pos="left";
        character.xbounds=70;
        }
        j.setBounds(moveX, 250, 300, 250);
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode() == KeyEvent.VK_UP){
           up = true;      
       }
       if(e.getKeyCode() == KeyEvent.VK_DOWN)
           down = true;
       if(e.getKeyCode() == KeyEvent.VK_LEFT)
           left = true;
       if(e.getKeyCode() == KeyEvent.VK_RIGHT)
           right = true;
             
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP)
           up = false;
       if(e.getKeyCode() == KeyEvent.VK_DOWN)
           down = false;
       if(e.getKeyCode() == KeyEvent.VK_LEFT)
           left = false;
       if(e.getKeyCode() == KeyEvent.VK_RIGHT)
           right = false;
    }
}