/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Killem;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Cesar
 */
public class Bullet{
    private Vector2f pos;
    private Vector2f finpos;
    private int speed;
    private int lived = 0;
    public Image i;
    public float startx;
    public float endx;
    public float starty;
    public float endy;
    float degrees;
    
    private boolean active = true;
    
    private static final int MAX_LIFETIME= 2000;
    
    public Bullet(Vector2f pos, Vector2f finpos)throws SlickException{
        
        this.pos=pos;
        this.finpos = finpos;
        speed=10;
        startx = pos.x;
        endx = finpos.x;
        starty = pos.y;
        endy = finpos.y;
        i = new Image("res/bullet.png");
        
        degrees = (float)Math.toDegrees(Math.atan2(endy-starty, endx-startx));
    }
    public Bullet(){
        active = false;
    }
    
     public float checkVelocityX(){
            
            return (endx-startx);
    }
    public float checkVelocityY(){
            
            return (endy-starty);
    }
    public void update(int t){
        float deltaX = (float)Math.cos(Math.toRadians(degrees)) * speed; 
        float deltaY = (float)Math.sin(Math.toRadians(degrees)) * speed;
        if(active){
            pos.x += deltaX;
            pos.y += deltaY;
            
            lived+=t;
            if(lived>MAX_LIFETIME)
                active=false;
        }
    }
    
    public void render(GameContainer gc, Graphics g)throws SlickException{
       if(active)
        g.drawImage(i,pos.getX(), pos.getY());
    }

    public boolean isActive(){
        return active;
    }
    
}
