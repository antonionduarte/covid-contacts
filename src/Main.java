import covidContacts.CovidContacts;
import covidContacts.CovidContactsClass;
import dataStructures.Iterator;
import dataStructures.TwoWayIterator;
import enums.Command;
import enums.Output;
import covidContacts.exceptions.*;
import groups.GroupGetters;
import posts.Post;
import users.UserGetters;

import java.util.Scanner;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * This program simulates a simple social network themed around the current COVID-19 pandemic (let's hope Trump
 * isn't lying about the cure).
 * Users can add others as contacts, create/join groups, post messages (which are sent to all contacts and groups
 * with the main purpose of notifying others if they're infected), and of course, receive messages.
 */
public class Main {
	
	/**
	 * Reads and executes input commands repeatedly until the exit command is typed.
	 * @param args Arguments used for the execution of the program (not used).
	 */
	public static void main(String[] args) {
		CovidContacts covidContacts = new CovidContactsClass();
		Scanner in = new Scanner(System.in);
		Command command;
		
		do {
			System.out.print("> ");
			command = readCommand(in);
			executeCommand(command, in, covidContacts);
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
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void executeCommand(Command command, Scanner in, CovidContacts covidContacts) {
		switch (command) {
			case IU:
				registerUser(in, covidContacts);
				break;
			case DU:
				userInfo(in, covidContacts);
				break;
			case IC:
				addContact(in, covidContacts);
				break;
			case RC:
				removeContact(in, covidContacts);
				break;
			case LC:
				listUserContacts(in, covidContacts);
				break;
			case IG:
				insertGroup(in, covidContacts);
				break;
			case DG:
				groupInfo(in, covidContacts);
				break;
			case RG:
				removeGroup(in, covidContacts);
				break;
			case IP:
				insertGroupParticipant(in, covidContacts);
				break;
			case RP:
				removeGroupParticipant(in, covidContacts);
				break;
			case LP:
				listGroupParticipants(in, covidContacts);
				break;
			case IM:
				insertPost(in, covidContacts);
				break;
			case LMC:
				listUserContactPosts(in, covidContacts);
				break;
			case LMG:
				listGroupPosts(in, covidContacts);
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
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void registerUser(Scanner in, CovidContacts covidContacts) {
		String login = in.next().toUpperCase(), username = (in.next() + in.nextLine()).toUpperCase();
		int age = in.nextInt();
		String location = (in.next() + in.nextLine()).toUpperCase(), profession = (in.next() + in.nextLine()).toUpperCase();
		
		try {
			covidContacts.registerUser(login, username, age, location, profession);
			System.out.println(Output.USER_REGISTERED.getMessage());
		}
		catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Prints out a users' information.
	 * @param in Input scanner.
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void userInfo(Scanner in, CovidContacts covidContacts) {
		String login = in.next().toUpperCase();
		
		try {
			UserGetters user = covidContacts.getUserGetters(login);
			System.out.printf("%s %s %d\n%s %s\n", login, user.getUsername(), user.getAge(), user.getLocation(), user.getProfession());
		}
		catch (UserDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Creates a new contact relation between 2 users.
	 * @param in Input scanner.
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void addContact(Scanner in, CovidContacts covidContacts) {
		String login1 = in.next().toUpperCase(), login2 = in.next().toUpperCase();
		
		try {
			covidContacts.addContact(login1, login2);
			System.out.println(Output.CONTACT_MADE.getMessage());
		}
		catch (UserDoesNotExistException | ContactAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Removes a contact relation between 2 users.
	 * @param in Input scanner.
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void removeContact(Scanner in, CovidContacts covidContacts) {
		String login1 = in.next().toUpperCase(), login2 = in.next().toUpperCase();
		
		try {
			covidContacts.removeContact(login1, login2);
			System.out.println(Output.CONTACT_REMOVED.getMessage());
		}
		catch (UserDoesNotExistException | SameUserLoginException | ContactDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Lists a specified users' contacts.
	 * @param in Input scanner.
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void listUserContacts(Scanner in, CovidContacts covidContacts) {
		String login = in.next().toUpperCase();
		
		try {
			Iterator<UserGetters> contacts = covidContacts.newUserContactsIterator(login);
			
			while (contacts.hasNext()) {
				UserGetters contact = contacts.next();
				System.out.printf("%s %s\n", contact.getLogin(), contact.getUsername());
			}
		}
		catch (UserDoesNotExistException | NoContactsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Inserts a new group into the system.
	 * @param in Input scanner.
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void insertGroup(Scanner in, CovidContacts covidContacts) {
		String name = in.nextLine().trim().toUpperCase(), description = in.nextLine().trim().toUpperCase();
		
		try {
			covidContacts.insertGroup(name, description);
			System.out.println(Output.GROUP_REGISTERED.getMessage());
		}
		catch (GroupAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Prints out a specified groups' information.
	 * @param in Input scanner.
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void groupInfo(Scanner in, CovidContacts covidContacts) {
		String name = in.next().toUpperCase();
		
		try {
			GroupGetters group = covidContacts.getGroupGetters(name);
			System.out.printf("%s\n%s\n", group.getName(), group.getDescription());
		}
		catch (GroupDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Removes the specified group from the system.
	 * @param in Input scanner.
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void removeGroup(Scanner in, CovidContacts covidContacts) {
		String name = in.next().toUpperCase();
		
		try {
			covidContacts.removeGroup(name);
			System.out.println(Output.GROUP_REMOVED.getMessage());
		}
		catch (GroupDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Inserts a specified user into a certain group.
	 * @param in Input scanner.
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void insertGroupParticipant(Scanner in, CovidContacts covidContacts) {
		String login = in.next().toUpperCase(), groupName = in.next().toUpperCase();
		
		try {
			covidContacts.insertGroupParticipant(login, groupName);
			System.out.println(Output.PARTICIPANT_ADDED.getMessage());
		}
		catch (UserDoesNotExistException | GroupDoesNotExistException | UserAlreadyInGroupException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Removes a user from a group.
	 * @param in Input scanner.
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void removeGroupParticipant(Scanner in, CovidContacts covidContacts) {
		String login = in.next().toUpperCase(), groupName = in.next().toUpperCase();
		
		try {
			covidContacts.removeGroupParticipant(login, groupName);
			System.out.println(Output.PARTICIPANT_REMOVED.getMessage());
		}
		catch (UserDoesNotExistException | GroupDoesNotExistException | UserNotInGroupException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Lists a groups participants.
	 * @param in Input scanner.
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void listGroupParticipants(Scanner in, CovidContacts covidContacts) {
		String groupName = in.next().toUpperCase();
		
		try {
			Iterator<UserGetters> participants = covidContacts.newGroupParticipantsIterator(groupName);
			
			while (participants.hasNext()) {
				UserGetters participant = participants.next();
				System.out.printf("%s %s\n", participant.getLogin(), participant.getUsername());
			}
		}
		catch (GroupDoesNotExistException | NoParticipantsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Enables a user to insert a new post.
	 * @param in Input scanner.
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void insertPost(Scanner in, CovidContacts covidContacts) {
		String login = in.next().trim().toUpperCase();
		String title = (in.next() + in.nextLine()).toUpperCase();
		String text = in.nextLine().toUpperCase();
		String url = in.nextLine().toUpperCase();
		
		try {
			covidContacts.insertPost(login, title, text, url);
			System.out.println(Output.POST_INSERTED.getMessage());
		}
		catch (UserDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Lists a specified users' sent and received posts.
	 * @param in Input scanner.
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void listUserContactPosts(Scanner in, CovidContacts covidContacts) {
		String login1 = in.next().toUpperCase(), login2 = in.next().toUpperCase();
		
		try {
			listPosts(covidContacts.newUserContactPostsIterator(login1, login2));
		}
		catch (UserDoesNotExistException | ContactDoesNotExistException | ContactHasNoPostsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Lists a specified groups' posts.
	 * @param in Input scanner.
	 * @param covidContacts Covid Contacts Manager.
	 */
	private static void listGroupPosts(Scanner in, CovidContacts covidContacts) {
		String groupName = in.next().toUpperCase(), login = in.next().toUpperCase();
		
		try {
			listPosts(covidContacts.newGroupPostsIterator(groupName, login));
		}
		catch (GroupDoesNotExistException | UserDoesNotExistException | UserNotInGroupException2 | GroupHasNoPostsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Prints out the exit message.
	 */
	private static void exit() {
		System.out.println(Output.EXIT.getMessage());
	}
	
	/**
	 * Auxiliary method to list posts.
	 * @param posts Posts iterator.
	 */
	private static void listPosts(TwoWayIterator<Post> posts) {
		posts.fullForward();
		while (posts.hasPrevious()) {
			Post post = posts.previous();
			System.out.printf("%s\n%s\n%s\n\n", post.getTitle(), post.getText(), post.getUrl());
		}
	}
	
}
