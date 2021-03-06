/**
 *  This class is the main class of the "World of Zuul" application.
 *  "World of Zuul" is a very simple, text based adventure game.  Users
 *  can walk around some scenery. That's all. It should really be extended
 *  to make it more interesting!
 *
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 *
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
package Zuul;

public class Game {

    private Parser parser;
    private Room currentRoom;
    private String[] locations = {"north", "east", "south", "west"};

    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        Room outside, theatre, pub, lab, office;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // initialise room exits
        outside.setExits(new RoomExit(new Room[]{null, theatre, lab, pub}));
        theatre.setExits(new RoomExit(new Room[]{null, null, null, outside}));
        pub.setExits(new RoomExit(new Room[]{null, outside, null, null}));
        lab.setExits(new RoomExit(new Room[]{outside, office, null, null}));
        office.setExits(new RoomExit(new Room[]{null, null, null, lab}));

        currentRoom = outside;
    }

    public void play() {
        printWelcome();

        boolean finished = false;

        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    private boolean processCommand(Command command) {
        boolean quitting = false;
        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
                break;
            case QUIT:
                quitting = quit(command);
                break;
        }
        return quitting;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("go quit help");
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        Room nextRoom = null;
        int salidas = 4; //numero de salidas que existen para cada cuarto.
        for (int i = 0; i < salidas; i++) {
            if (direction.equals(locations[i])) {
                nextRoom = currentRoom.getSpecificExit(i);
            }
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    private void printLocationInfo() {
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        System.out.println(currentRoom.getExits());
        System.out.println();
    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
