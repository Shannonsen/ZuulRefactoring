package Zuul;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via exits. The exits are labelled north, east, south, west.
 * For each direction, the room stores a reference to the neighboring room, or
 * null if there is no exit in that direction.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Room {

    public String description;
    //private Room[] roomExits;
    //private String[] locations = {"north ", "east ", "south ", "west "};
    private RoomExit roomExit;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     */
    public Room(String description) {
        this.description = description;
    }

    /**
     * Define the exits of this room. Every direction either leads to another
     * room or is null (no exit there).
     */
    public void setExits(RoomExit exits) {
        this.roomExit = exits;
    }

    public RoomExit getRoomExits() {
        return roomExit;
    }

    public Room getSpecificExit(int position){
       return roomExit.getRoomExits()[position];
    }
    
    public String getDescription() {
        return description;
    }

    public String getExits() {
        return roomExit.getRoomExitsString();
    }

}
