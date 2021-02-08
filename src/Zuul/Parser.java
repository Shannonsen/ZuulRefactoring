package Zuul;

import java.util.Scanner;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Parser 
{
    private CommandWords commands;
    private Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() 
    {
        System.out.print("> ");
        
        String inputLine;   
        String word1 = null;
        String word2 = null;
        inputLine = reader.nextLine();
        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
                // note: we just ignore the rest of the input line.
            }
        }
        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).

        return new Command(commands.getCommand(word1), word2);
        
    }
}