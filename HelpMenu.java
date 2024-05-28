import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the Help Menu screen.
 * It displays instructions for the players.
 * 
   @authors (Rupert & Raymond Van Niekerk)
 * @student Numbers (222894237 & 221154469)
 * @version (1)
 */
public class HelpMenu extends World {
    public HelpMenu() {    
        super(800, 600, 1);
        
        GreenfootImage image = new GreenfootImage("->Player 1: W/S to move up and down.\n->Player 2: Up/Down to move up and down\n->Press Space to release the ball\n ->If Mushroom collected- Player Paddle Grow.\n->If Red Pill collected - Player paddle will Schrink.\n->Effects last only 6 seconds.", 
        28, Color.BLACK, null);
        getBackground().drawImage(image, getWidth()/2 -235, getHeight()/2 + 50);

        // Add a back button to the world
        Button backButton = new Button("Back");
        addObject(backButton, getWidth() / 2, getHeight() - 50);
    }
}
