/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Killem;


import org.newdawn.slick.*;
import static org.newdawn.slick.Input.MOUSE_LEFT_BUTTON;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

        
   public class Engine extends BasicGameState implements KeyListener {
    //players
    Player player1;
    
  
    private Bullet[] shots;
    private static final int FIRE_RATE = 250;
    private int currentshot=0;
    private int time=0;
    Sound bullet;
    public int state;
    public static int deltaTime;
    public int lastFrameTime=0; 
    private Goblin bob;
    
    
    static boolean drawBullet;
    private TiledMap grassMap;
    
    public Engine(int state) throws SlickException {
        this.state =state;
        
    }
    public int deltaTime(){       

		long time=System.nanoTime()/1000000;
		int delta = (int)(time-lastFrameTime);
		lastFrameTime = (int)time;
		return delta;
	}
     	
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException  {
       //calculate time since last frame has run
        
		deltaTime= deltaTime();
                time +=delta;
                
        //bullets when pressed
                int dx = gc.getInput().getMouseX();
                int dy = gc.getInput().getMouseY();
                if(time>=FIRE_RATE && gc.getInput().isMousePressed(MOUSE_LEFT_BUTTON)){
                    bullet.play();
                    shots[currentshot] = new Bullet( new Vector2f(player1.x1,player1.y1), 
                            new Vector2f(dx,dy));
                    
                    currentshot++;
                    if(currentshot>=shots.length){
                        currentshot =0;
                        time=0;
                    }
                }
                 for(Bullet b: shots){
                        b.update(delta);
                }

                 
       //move functions
		if(gc.getInput().isKeyDown(Input.KEY_D) && player1.x1 <= 690)
		{       


			player1.x1++;
		}
		if(gc.getInput().isKeyDown(Input.KEY_A) && player1.x1 >= 1)
		{       

                        
			player1.x1--;
		}
		if(gc.getInput().isKeyDown(Input.KEY_S) && player1.y1 <= 690)
		{       

                       
			player1.y1++;
		}
		if(gc.getInput().isKeyDown(Input.KEY_W) && player1.y1 >=1)
                {
                        
			player1.y1--;
		}

                 
    }
    @Override
    public void init(GameContainer gc,StateBasedGame sbg) throws SlickException {
        deltaTime= deltaTime();
        player1=new Player();
        bullet = new Sound("res/pistal.ogg");
       grassMap = new TiledMap("res/map.tmx");
       shots = new Bullet[8];
       
       for(int i=0; i<shots.length; i++){          
           shots[i] = new Bullet();     
       }
       
    }

 
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
       
       grassMap.render(0,0);

       player1.i.draw(player1.x1,player1.y1);
       
       g.drawString(""+player1.x1, 370, 5);
       g.drawString(""+player1.y1, 400, 5);
       g.drawString(""+gc.getInput().getMouseX(), 370, 20);
       g.drawString(""+gc.getInput().getMouseY(), 400, 20);
       g.drawString("Health: "+ player1.getHealth(), 200, 5);
       
       for(Bullet b: shots){
          
           b.render(gc, g);
       }
       
       
    }
   
    @Override
    public int getID() {
        return state;
    }

}