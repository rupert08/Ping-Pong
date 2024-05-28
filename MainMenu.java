import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the Main Menu screen.
 * It contains buttons to start the game, view help, and exit.
 * 
 @authors (Rupert & Raymond Van Niekerk)
 * @student Numbers (222894237 & 221154469)
 * @version (1)

 */
public class MainMenu extends World {
    public MainMenu() {    
        super(800, 600, 1);
        prepare();
    }

    private void prepare() {
        // Create and add the start button to the world
        Button startButton = new Button("Start");
        addObject(startButton, getWidth() / 2, getHeight() / 2 + 50);
        
        // Create and add the help button to the world
        Button helpButton = new Button("Help");
        addObject(helpButton, getWidth() / 2, getHeight() / 2 + 100);
        
        // Create and add the exit button to the world
        Button exitButton = new Button("Exit");
        addObject(exitButton, getWidth() / 2, getHeight() / 2 + 150);
    }
}
