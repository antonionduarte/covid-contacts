import covidContactsManager.*;
import enums.*;
import exceptions.*;

import users.User;
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
		} while (command != Command.FIM);
		
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
		System.out.println();
		switch (command) {
			case IU:
				registerUser(in, ccm);
				break;
			case DU:
				userInfo(in, ccm);
				break;
			case IC:
				addContact(in, ccm);
				break;
      case RC:
        removeContact(in, ccm);
				break;
			case LC:
				break;
			case IG:
				break;
			case DG:
				break;
			case RG:
				break;
			case IP:
				break;
			case RP:
				break;
			case LP:
				break;
			case IM:
				break;
			case LMC:
				break;
			case LMG:
				break;
			case FIM:
				exit();
				break;
			default:
				break;
		}
	}
	
	/**
	 * Registers a new user.
	 * @param in Input scanner.
	 * @param ccm Covid Contacts Manager.
	 */
	private static void registerUser(Scanner in, CovidContactsManager ccm) {
		String login = in.next(), username = in.next();
		int age = in.nextInt();
		String location = in.next(), profession = in.next();
		
		try {
			ccm.registerUser(login, username, age, location, profession);
			System.out.println(Output.USER_REGISTERED.getMessage());
		}
		catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Prints out a users' information.
	 * @param in Input scanner.
	 * @param ccm Covid Contacts Manager.
	 */
	private static void userInfo(Scanner in, CovidContactsManager ccm) {
		String login = in.next();
		
		try {
			User user = ccm.getUser(login);
			System.out.printf("%s %s %d\n%s %s", login, user.getUsername(), user.getAge(), user.getLocation(), user.getProfession());
		}
		catch (UserDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Creates a new contact relation between 2 users.
	 * @param in Input scanner.
	 * @param ccm Covid Contacts Manager.
	 */
	private static void addContact(Scanner in, CovidContactsManager ccm) {
		String login1 = in.next(), login2 = in.next();
		
		try {
			ccm.addContact(login1, login2);
			System.out.println(Output.CONTACT_MADE.getMessage());
		}
		catch (UserDoesNotExistException | ContactAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
		
  }
  
  /**
   * Removes a contact relation between 2 users.
   * @param in Input scanner.
   * @param ccm Covid Contacts Manager.
   */
  private static void removeContact(Scanner in, CovidContactsManager ccm) {
    String login1 = in.next(), login2 = in.next();

    try {
      ccm.removeContact(login1, login2);
      System.out.println(Output.CONTACT_REMOVED.getMessage());
    }
    catch (UserDoesNotExistException | ContactDoesNotExistException e) {
      System.out.println(e.getMessage());
    }
  }	

	/**
	 * Prints out the exit message.
	 */
	private static void exit() {
		System.out.println(Output.EXIT.getMessage());
	}
	
}
