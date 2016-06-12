/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Killem;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Cesar
 */
public class Game extends StateBasedGame{
    public static final String gamename = "Goblin Escape! v1.3";
    public static final int mainmenu = 0;
    public static final int Engine = 1;

    public Game(String name) throws SlickException {
        super(name);
        this.addState(new MainMenu(mainmenu));
        this.addState(new Engine(Engine));
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(mainmenu).init(gc, this);
        this.getState(Engine).init(gc,this);
        this.enterState(mainmenu); 
        
    }
    
    public static void main(String[] args) throws SlickException {
        AppGameContainer app;
        try
		{
			
			app = new AppGameContainer(new Game(gamename));
			app.setDisplayMode(720, 720, false);
                        app.setSmoothDeltas(true);
                        app.setTargetFrameRate(120);
                        app.setShowFPS(true);
			app.start();
			
		
		}
	catch (SlickException ex)
		{
		}
        
        
    }

    
}
