package final_project;

import java.util.ArrayList;

import org.junit.Test;

public class Notes_UnitTesting {
	ArrayList<String> object_1 = new ArrayList<String>();

	@Test
	public void addnoteTest() {
		object_1.add("Testing Note1");
		object_1.add("Testing Note2");
		object_1.add("Testing Note2");
		Notes.addnote(object_1);
	}

	@Test
	public void displaynote() {
		Notes.displaynote();
	}

	@Test
	public void removenote() {
		Notes.removenote(1);
	}
}
