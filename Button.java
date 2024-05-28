import greenfoot.*; 

/**
 * This class represents a Button in the game.
 * It changes the world or stops the game when clicked.
*
 @authors (Rupert & Raymond Van Niekerk)
 * @student Numbers (222894237 & 221154469)
 * @version (1)
 */
public class Button extends Actor {
    private String label; // The text label of the button

    public Button(String label) {
        // Constructor sets the label and creates the image
        this.label = label;
        getImage();
        setImage(new GreenfootImage(label, 32, Color.YELLOW, Color.BLACK));
    }

    public void act() {
        // Check if the button is clicked and perform the corresponding action
        if (Greenfoot.mouseClicked(this)) {
            if (label.equals("Start")) {
                Greenfoot.setWorld(new PingPongWorld());
                Greenfoot.playSound("click-for-game-menu-131903.mp3");
            } else if (label.equals("Help")) {
                Greenfoot.setWorld(new HelpMenu());
                Greenfoot.playSound("click-for-game-menu-131903.mp3");
            } else if (label.equals("Exit")) {
                Greenfoot.stop();
                Greenfoot.playSound("mixkit-arcade-retro-game-over-213.wav");
            } else if (label.equals("Back")) {
                Greenfoot.setWorld(new MainMenu());
                Greenfoot.playSound("select-sound-121244.mp3");
            }
        }
    }
}
