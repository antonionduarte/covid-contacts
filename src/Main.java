import enums.Command;
import enums.Output;

import java.util.Scanner;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * <<<Description>>>
 */

public class Main {
	
	public static void main(String[] args) {
		//Manager class
		Scanner in = new Scanner(System.in);
		Command command;
		
		do {
			command = readCommand(in);
			executeCommand(command, in, manager);
		} while (command != Command.EXIT);
		
		in.close();
	}
	
	/**
	 * Interprets an inserted command.
	 * @param in Input scanner.
	 * @return The desired command || Unknown command.
	 */
	private static Command readCommand(Scanner in) {
		try {
			return Command.valueOf(in.next().toUpperCase());
		}
		catch (IllegalArgumentException e) {
			return Command.UNKNOWN;
		}
	}
	
	/**
	 * Executes a given command.
	 * @param command Command to execute.
	 * @param in Input scanner.
	 * @param manager Covid thing manager.
	 */
	private static void executeCommand(Command command, Scanner in, Manager manager) {
		switch (command) {
			case EXIT:
				exit();
				break;
			default:
				unknownCommand(in);
				break;
		}
	}
	
	/**
	 * Prints out the unknown command message.
	 */
	private static void unknownCommand(Scanner in) {
		System.out.println(Output.UNKNOWN_COMMAND.getMessage());
		in.nextLine();
	}
	
	/**
	 * Prints out the exit message.
	 */
	private static void exit() {
		System.out.println(Output.EXIT.getMessage());
	}
	
}
