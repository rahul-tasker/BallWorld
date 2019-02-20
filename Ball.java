/*
 Ball -- represents one ball in the Ball World application
 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ball implements ActionListener
{
   // the Ball's properties
   private int canvasWidth, canvasHeight;
   private int xpos,ypos;
   protected double xvelocity,yvelocity;
   protected int diameter;
   protected Color color;

   // the Ball constructor
   // parameters are the width and height of the canvas
   public Ball(int width, int height){
      canvasWidth = width;
      canvasHeight = height;
      
      // the diameter is a random int between 50 and 100 
      diameter = (int)(50*Math.random())+50;
      
      // the velocity components 
      xvelocity = ((int)(4*Math.random())+3)*((int)(Math.random()*2))*2-1;
      yvelocity = ((int)(4*Math.random())+3)*((int)(Math.random()*2))*2-1;
      
      // the initial (x,y) position of the ball
      xpos=(int)(canvasWidth*Math.random());
      ypos=(int)(canvasHeight*Math.random());
      
      // pick a random color
      color=new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
   }

   // how the ball moves
   public void move(){
      int xmax = canvasWidth;
      int ymax = canvasHeight;
      
      // update the x position
      xpos+=xvelocity;
      // if past the right boundary, bounce back to the left
      if(xpos+diameter > xmax){
         xpos = xpos - 2*(xpos+diameter-xmax);
         xvelocity = -xvelocity;
      }
      // if past the left boundary, bounce back to the right
      if(xpos < 0){
         xpos = -xpos;
         xvelocity = -xvelocity;
      }
      
      // update the y position      
      ypos+=yvelocity;
      // if past the bottom boundary, bounce back up
      if(ypos+diameter > ymax){
         ypos = ypos - 2*(ypos+diameter-ymax);
         yvelocity = -yvelocity;
      }
      // if past the upper boundary, bounce back down
      if(ypos < 0){
         ypos = -ypos;
         yvelocity = -yvelocity;
      }
   }

   // how to draw this ball
   public void draw(Graphics g){
      g.setColor(color);
      g.fillOval(xpos,ypos,diameter,diameter);
   }

   // how the ball responds to a timer tick
   public void actionPerformed(ActionEvent e){
      move();
   }
   
}