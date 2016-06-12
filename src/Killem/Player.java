/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Killem;

import org.newdawn.slick.*;

/**
 *
 * @author Cesar
 */
public class Player  {
       int x1;
       int y1;
       Image i;
       int health; 
       
       public Player() throws SlickException{
           i = new Image("res/stickman.png");
           x1=10;
          health = 50;
       }
        public int getx(){
            return x1;
        }
        public int gety(){
            return y1;
        }
        public int getHealth(){
            return health;
        }

}
