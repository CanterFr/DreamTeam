/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Killem;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Cesar
 */
public class MainMenu extends BasicGameState{
    Image background;
    Image title;
    Image survival;
    Image exit;
    public int state;
    public MainMenu(int state) throws SlickException{
      this.state = state;
    }
    @Override
    public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
      background = new Image("res/mainmenu.png");
      title = new Image("res/title.png");
      survival = new Image("res/survival.png");
      exit = new Image("res/exit.png");   
    }
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
        background.draw(0,25);
        title.draw(100,15);
        survival.draw(100, 250);
        exit.draw(100,400);

        
    }
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException{
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        if((posX>126 && posX<206) && (posY>400 && posY<425)){
            if(Mouse.isButtonDown(0)){
                sbg.enterState(1);
            }
        }
        if((posX>115 && posX<215) && (posY>258 && posY<278)){
            if(Mouse.isButtonDown(0)){
                System.exit(0);
            }
            }
    }
  
    @Override
    public int getID() {
        return state; 
    }

    
  
}
