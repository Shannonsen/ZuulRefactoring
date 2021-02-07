/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zuul;

/**
 *
 * @author Shannon
 */
public class RoomExit {

    private Room[] roomExits;
    private String[] locations = {"north ", "east ", "south ", "west "};

    public RoomExit(Room[] roomExits) {
        this.roomExits = roomExits;
    }

    
    
    public Room[] getRoomExits() {
        return roomExits;
    }

    public void setRoomExits(Room[] roomExits) {
        this.roomExits = roomExits;
    }

    public String[] getLocations() {
        return locations;
    }

    public String getRoomExitsString() {
        String exitsString = "";
        for (int i = 0; i < roomExits.length; i++) {
            if (roomExits[i] != null) {
                exitsString += locations[i];
            }
        }
        return exitsString;
    }

}
