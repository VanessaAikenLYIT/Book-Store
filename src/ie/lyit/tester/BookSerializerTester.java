package ie.lyit.tester;

import ie.lyit.book.Menu;
import ie.lyit.serialize.BookSerializer;

public class BookSerializerTester {

	public static void main(String[] args) {
		BookSerializer bs = new BookSerializer();
		bs.deserializeBooks();
		Menu menu = new Menu();
		do {
			menu.display();
			menu.readOption();
			switch (menu.getOption()) {
				case 1: bs.add();break;
				case 2: bs.list();break;
				case 3: bs.view();break;
				case 4: bs.edit();break;
				case 5: bs.delete();break;
				case 6: break;
				default: System.out.println("Not a valid option!!");
				}
		} while(menu.getOption() != 6);
		
		bs.serializeBooks();
	}
}
