import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents a timed effect that applies an effect for a certain duration.
 * 
*  @authors (Rupert & Raymond Van Niekerk)
 * @student Numbers (222894237 & 221154469)
 * @version (1.0)
 */
public class TimedEffect extends Actor {
    private long startTime; // The time when the effect started
    private int duration; // The duration of the effect in milliseconds
    private Runnable effect; // The effect to apply immediately
    private Runnable endEffect; // The effect to apply when the duration ends

    public TimedEffect(int duration, Runnable effect, Runnable endEffect) {
        // Constructor initializes the duration and the effects
        this.duration = duration;
        this.effect = effect;
        this.endEffect = endEffect;
    }

    protected void addedToWorld(World world) {
        // Called when the object is added to the world, start the timer and run the initial effect
        startTime = System.currentTimeMillis();
        effect.run();
    }

    public void act() {
        // Called in every cycle, check if the duration has ended to run the end effect and remove the object
        if (System.currentTimeMillis() - startTime >= duration) {
            endEffect.run();
            getWorld().removeObject(this);
        }
    }
}
