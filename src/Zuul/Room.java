package Zuul;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Room 
{
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     */
    public Room(String description) 
    {
        this.description = description;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     */
    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            setNorthExit(north);
        if(east != null)
            setEastExit(east);
        if(south != null)
            setSouthExit(south);
        if(west != null)
            setWestExit(west);
    }

    public String getDescription()
    {
        return description;
    }

    public Room getNorthExit() {
        return northExit;
    }

    public Room getSouthExit() {
        return southExit;
    }

    public Room getEastExit() {
        return eastExit;
    }

    public Room getWestExit() {
        return westExit;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNorthExit(Room northExit) {
        this.northExit = northExit;
    }

    public void setSouthExit(Room southExit) {
        this.southExit = southExit;
    }

    public void setEastExit(Room eastExit) {
        this.eastExit = eastExit;
    }

    public void setWestExit(Room westExit) {
        this.westExit = westExit;
    }
    
    
    

}
