import covidContactsManager.CovidContactsManager;
import covidContactsManager.CovidContactsManagerClass;
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
		CovidContactsManager ccm = new CovidContactsManagerClass();
		Scanner in = new Scanner(System.in);
		Command command;
		
		do {
			command = readCommand(in);
			executeCommand(command, in, ccm);
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
	 * @param ccm Covid Contacts Manager.
	 */
	private static void executeCommand(Command command, Scanner in, CovidContactsManager ccm) {
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
