package Zuul;

import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class CommandWords
{
//    // a constant array that holds all valid command words
//    private static final String[] validCommands = {
//        "go", "quit", "help"
//    };
    //Hash map for the command words and it's
    //associated command
    private HashMap<String, CommandWord> validCommands;

    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        validCommands.put("go", CommandWord.GO);
        validCommands.put("quit", CommandWord.QUIT);
        validCommands.put("help", CommandWord.HELP);
    }

    public CommandWord getCommand(String aString)
    {
        CommandWord command = validCommands.get(aString);
        if (command != null) {
            return command;
        }
        return CommandWord.UNKNOWN;
    }
    
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.size(); i++) {
            if(validCommands.equals(aString))
                return true;
        }
        return false;
    }
}
