package es.iesjandula.sample_project;

import java.util.Scanner;

import es.iesjandula.sample_project.models.Author;
import es.iesjandula.sample_project.models.Book;
import es.iesjandula.sample_project.utils.Constants;

/**
 * This is the launcher of the class
 * 
 * @author Paco Benítez
 *
 */
public class Launcher
{	
	/** Attribute - List of Authors */
	private Author[] authors ;
	
	/** Attribute - Current index of author */
	private int currentIndexAuthor ; // camelCase format
	
	/** Attribute - List of Books */
	private Book[] books ;
	
	/** Attribute - Current index of book */
	private int currentIndexBook ; // camelCase format
	
	/**
	 * This default constructor initializes the arrays structures
	 */
	public Launcher()
	{
		// For this example, we are going to set the max size to 1000 elements
		this.authors = new Author[Constants.ARRAY_MAX_SIZE] ;
		this.books   = new Book[Constants.ARRAY_MAX_SIZE] ;
		
		this.currentIndexAuthor = 0 ;
		this.currentIndexBook   = 0 ;
	}
	
	/**
	 * Main static method
	 * 
	 * @param arguments with the arguments
	 */
	public static void main(String[] arguments)
	{
		// Create an instance of this Launcher to avoid static methods
		Launcher launcher = new Launcher() ;
		
		launcher.startProcess() ;		
	}

	/**
	 * This method handles all the process
	 */
	private void startProcess()
	{
		// Create a unique instance of Scanner
		Scanner scanner = new Scanner(System.in) ;
		
		// Show a menu and choose an option
		int option = this.showMainMenu(scanner) ;
		
		do
		{
			// Check if the option is not "exit"
			if (option != 3)
			{
				// Validate and execute the option
				this.validateAndCheckTheOption(scanner, option) ;
				
				// Show a menu and choose an option
				option = this.showMainMenu(scanner) ;
			}
		}
		while (option != 3) ;
		
		// Close the scanner after using
		scanner.close() ;
	}

	/**
	 * This is the main menu of the application
	 * 
	 * @return the option that user chose
	 */
	private int showMainMenu(Scanner scanner)
	{
		System.out.println("1. Create an author") ;
		System.out.println("2. Create a book") ;
		System.out.println("3. Exit") ;
		
		return scanner.nextInt() ;
	}
	
	/**
	 * Validate and check the option
	 * 
	 * @param scanner with the scanner
	 * @param option  with the input option
	 */
	private void validateAndCheckTheOption(Scanner scanner, int option)
	{
		switch (option)
		{
			case 1:
				
				this.createAuthor(scanner) ;
				break ;

			case 2:
				
				this.createBook(scanner) ;
				break ;

			default:
				
				System.out.println("Invalid option!") ;
		}
	}

	/**
	 * Create a new author, getting the information from the console
	 * 
	 * @param scanner with the scanner
	 */
	private void createAuthor(Scanner scanner)
	{
		// Get the first name from the console
		System.out.print("Author first name: ") ;
		String firstName  = scanner.next() ;
		
		// Get the lastname from the console
		System.out.print("Author last name: ") ;
		String lastName = scanner.next() ;
		
		// Check the values of the console
		if (firstName.equals(Constants.EMPTY_STRING) || lastName.equals(Constants.EMPTY_STRING))
		{
			System.out.println("Invalid author values") ;
		}
		else
		{
			// Create a new instance of Author
			Author author = new Author(firstName, lastName) ;
			
			// Add to the array
			this.authors[this.currentIndexAuthor] = author ;
			
			// Print in the console
			System.out.println("New author inserted: " + author) ;
			
			// Increment the index
			this.currentIndexAuthor ++ ;
		}
	}

	/**
	 * Create a new book, getting the information from the console
	 * 
	 * @param scanner with the scanner
	 */
	private void createBook(Scanner scanner)
	{
		// Get the title from the console
		System.out.print("Book title: ") ;
		String title 	   	   = scanner.next() ;
		
		// Get the pages number from the console
		System.out.print("Book pages: ") ;
		int pagesNumber 	   = scanner.nextInt() ;
		
		// Get the name of the author and search in the array
		System.out.print("Author firstname (System will search the related author): ") ;
		String authorFirstName = scanner.next() ;

		// Check the values of the console
		if (title.equals(Constants.EMPTY_STRING) || pagesNumber == -1 || authorFirstName.equals(Constants.EMPTY_STRING))
		{
			System.out.println("Invalid books values") ;
		}
		else
		{
			// Search and get the author
			Author author = this.searchAuthor(authorFirstName) ;
			
			// Check if the author was not found
			if (author == null)
			{
				System.out.println("The author with the ");
			}
			
			// Create a new instance of Book
			Book book = new Book(title, pagesNumber, author) ;
			
			// Add to the array
			this.books[this.currentIndexBook] = book ;
			
			// Print in the console
			System.out.println("New book inserted: " + book) ;
			
			// Increment the index
			this.currentIndexBook ++ ;
		}
	}

	/**
	 * Search the author by firstname
	 * 
	 * @param firstName with the first name
	 * @return the author related to this first name
	 */
	private Author searchAuthor(String firstName)
	{
		Author authorFound = null ;
		
		int index = 0 ;
		
		// Do the loop while the index is less equal to the current index and
		// the author is not found
		while (index <= this.currentIndexAuthor && authorFound == null)
		{
			// Get the possible author
			Author possibleAuthor = this.authors[index] ;
			
			// If both have the same first name, this will be the author
			if (possibleAuthor.getFirstName().equals(firstName))
			{
				authorFound = possibleAuthor ;
			}
			
			index ++ ;
		}
		
		return authorFound ;
	}
}
