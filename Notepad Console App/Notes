package final_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Notes {
	static ArrayList<String> object_1 = new ArrayList<String>();

	public static void addnote(List<String> notesList) {
		object_1.addAll(notesList);
	}

	public static void displaynote() {
		if (!object_1.isEmpty()) {
			for (int i = 0; i < object_1.size(); i++) {
				System.out.println(i + 1 + ":" + " " + object_1.get(i));
			}
			System.out.println("");
		}

		else {
			System.out.println("Your list is empty");
			System.out.println();
		}
	}

	public static void removenote(int index) {

		Scanner input = new Scanner(System.in);

		do
			if (index > 0 && index <= object_1.size())

			{
				object_1.remove(index - 1);
				break;
			} else {
				System.out.println("Invalid Index: Enter a valid index ");
				index = input.nextInt();
			}
		while (true);
	}

	public static void main(String args[]) {
		Scanner getting_users_integer_input = new Scanner(System.in);
		int pressing_the_start_button = 0;
		int storing_users_integer_input;

		while (pressing_the_start_button <= 4) {
			System.out.println();
			System.out.println("Select 1 if you would like to add notes onto your list");
			System.out.println("Select 2 if you would like to display your list");
			System.out.println("Select 3 if you would like to remove notes from your list");
			System.out.println("Select 4 if you would like to exit this program");
			System.out.print("Please enter a number between 1-4: ");
			storing_users_integer_input = getting_users_integer_input.nextInt();

			switch (storing_users_integer_input) {
			case 1:
				ArrayList<String> object_1 = new ArrayList<String>();
				System.out.println();
				System.out.print("Enter a note to add onto your list: ");
				String entered_note = "";

				while (entered_note.isEmpty()) {
					object_1.clear();
					entered_note = getting_users_integer_input.nextLine();
					object_1.add(entered_note);
					if (object_1.size() > 1)
						break;
				}

				addnote(object_1);
				break;

			case 2:
				System.out.println();
				System.out.println("To Do List");
				System.out.println("-----------");
				displaynote();
				break;

			case 3:
				System.out.println("Enter the index number for removing a note:");
				String index = getting_users_integer_input.next();

				do {
					if (index.matches(".*\\d.*")) {
						int index1 = Integer.parseInt(index);
						removenote(index1);
						break;
					}

					else {
						System.out.println("Thats not a valid entry");
						index = getting_users_integer_input.next();
					}
				} while (true);
				break;

			case 4:
				System.out.println();
				System.out.println("Thank you for using the program");
				break;

			default:
				System.out.println();
				System.out.println("Invalid entry: Try again");
				break;

			}
		}
	}
}
