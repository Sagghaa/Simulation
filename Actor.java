import java.util.List;

/**
 * A class representing shared characteristics of Actors.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
public abstract class Actor
{
    // Whether the Actor is alive or not.
    private boolean alive;
    // The Actor's field.
    private Field field;
    // The Actor's position in the field.
    private Location location;
    
    /**
     * Create a new Actor at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Actor(Field field, Location location)
    {
        alive = true;
        this.field = field;
        setLocation(location);
    }
    
    /**
     * Make this Actor act - that is: make it do
     * whatever it wants/needs to do.
     * @param newActors A list to receive newly born Actors.
     */
    abstract public void act(List<Actor> newActors);

    /**
     * Check whether the Actor is alive or not.
     * @return true if the Actor is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }

    /**
     * Indicate that the Actor is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the Actor's location.
     * @return The Actor's location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the Actor at the new location in the given field.
     * @param newLocation The Actor's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    /**
     * Return the Actor's field.
     * @return The Actor's field.
     */
    protected Field getField()
    {
        return field;
    }
}
