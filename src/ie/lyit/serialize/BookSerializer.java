package ie.lyit.serialize;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import ie.lyit.book.Book;

public class BookSerializer {

	private final String FILENAME = "books.ser";
	private ArrayList<Book> books;
	
	public BookSerializer() {
		books = new ArrayList<Book>();
	}
	
	public void add() {
		Book aBook = new Book();
		aBook.read();
		books.add(aBook);
	}
	
	public void serializeBooks() {
		ObjectOutputStream os = null;
		try {
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			os = new ObjectOutputStream(fileStream);
			os.writeObject(books);
			//os.close();
		} catch (FileNotFoundException f) {
			System.out.println("Cannot create file " + FILENAME + ".");
		} catch (IOException e) {
			System.out.println("Input Output Error" + e.getMessage());
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				System.out.println();
			}
		}	
	}
	
	public void deserializeBooks() {
		ObjectInputStream is = null;
		try {
			FileInputStream fileStream = new FileInputStream(FILENAME);
			is = new ObjectInputStream(fileStream);
			books = (ArrayList<Book>)is.readObject();
			//is.close();
		} catch (FileNotFoundException f) {
			System.out.println("Cannot create file " + FILENAME + ".");
		} catch (IOException e) {
			System.out.println("Input Output Error" + e.getMessage());
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				System.out.println();
			}
		}	
	}
	
	public void list() {
		for (Book tmpBook : books) {
			System.out.println(tmpBook);
		}
	}
	
	public Book view() {
		//GOOD FOR SOME ERROR HANDLING HERE, ENSURE USER 
		//ENTERS AN INT!!! DO WHILE/ TRY CATCH!!!
		Scanner keyboard = new Scanner(System.in);
		System.out.println("ENTER LIBRARY NUMBER OF BOOK : ");
		int bookToView = keyboard.nextInt();
		for (Book book : books) {
			if (book.getLibraryNumber() == bookToView) {
				System.out.println(book);
				return book;
			}
		}
		return null;
	}
	
	public void delete() {
		Book bookToRemove = view();
		if (bookToRemove != null) {
			books.remove(bookToRemove);
		}
	}
	
	public void edit() {
		Book bookToEdit = view();
		if (bookToEdit != null) {
			int index = books.indexOf(bookToEdit);
			bookToEdit.read();
			books.set(index, bookToEdit);
		}
	} 
}
