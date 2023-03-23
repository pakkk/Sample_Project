package es.iesjandula.sample_project.models;

/**
 * This class represents the different attributes and action methods for books
 * 
 * @author Paco Benítez
 *
 */
public class Book implements Comparable<Book>
{
	/** Attribute - Title */
	private String title ;
	
	/** Attribute - Pages number */
	private Integer pagesNumber ; // camelCase format
	
	/** Attribute - Author of the book */
	private Author author ;

	/**
	 * This is the constructor for books
	 * 
	 * @param title		  with the title
	 * @param pagesNumber with the pages number
	 * @param author	  with the author
	 */
	public Book(String title, Integer pagesNumber, Author author)
	{
		this.title 		 = title ;
		this.pagesNumber = pagesNumber ;
		this.author 	 = author ;
	}

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return this.title ;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title ;
	}

	/**
	 * @return the pagesNumber
	 */
	public Integer getPagesNumber()
	{
		return this.pagesNumber ;
	}

	/**
	 * @param pagesNumber the pagesNumber to set
	 */
	public void setPagesNumber(Integer pagesNumber)
	{
		this.pagesNumber = pagesNumber ;
	}

	/**
	 * @return the author
	 */
	public Author getAuthor()
	{
		return this.author ;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author)
	{
		this.author = author ;
	}

	/**
	 * @return an object as string representation
	 */
	@Override
	public String toString()
	{
		return "Book [title=" + this.title + ", pagesNumber=" + this.pagesNumber + ", author=" + this.author + "]";
	}
	
	/**
	 * Check if the input object is the same than the instance of this class
	 * 
	 * @param object with an object to be compared to
	 * @return true if the input object is the same than the instance of this class
	 */
	@Override
	public boolean equals(Object object)
	{
		// Check if the instance of this class is the same than the input object
		if (this == object)
		{
			return true ;
		}
		// Check if the input object is null
		else if (object == null)
		{
			return false ;
		}
		// Check if the type of this class is the same than the class of the input object
		if (this.getClass() != object.getClass())
		{
			return false;
		}
		
		// If the code is executing here is because the input object is instance of Book
		// So, we cannot do a casting
		Book other = (Book) object ;
		
		// Check if the title of this class is null and the attribute title of the object is not null
		if (this.title == null && other.title != null)
		{
			return false ;
		}
		// Check if the values of the input class and object is not the same
		else if (!this.title.equals(other.title))
		{
			return false ;
		}
		// Check if the 'pages number' of this class is null and the attribute 'pages number' of the object is not null
		else if (this.pagesNumber == null && other.pagesNumber != null)
		{
				return false ;
		}
		// Check if the values of the input class and object is not the same
		else if (!this.pagesNumber.equals(other.pagesNumber))
		{
			return false ;
		}
		// Check if the 'author' of this class is null and the attribute 'author' of the object is not null
		else if (this.author == null && other.author != null)
		{
				return false ;
		}
		// Check if the values of the input class and object is not the same
		else if (!this.author.equals(other.author))
		{
			return false ;
		}
		
		// If we are here is because both instances are the same
		return true ;
	}
	
	/**
	 * This method belongs to Comparable interface
	 * 
	 * @param anotherBook with another book to be compared
	 * @return 0 if the argument is equal to this class. 
	 * 		   < 0 if this class is less than the string argument
	 * 		   > 0 if this class is greater than the string argument
	 */
	public int compareTo(Book anotherBook)
	{
		// Check the title
		int result = this.title.compareTo(anotherBook.title) ;

		// If both are the same, we need to compare the pages number
	    if (result == 0)
	    {
	        result = this.pagesNumber.compareTo(anotherBook.pagesNumber) ;
	    }
	    
		// If both are the same, we need to compare the author
	    if (result == 0)
	    {
	        result = this.author.compareTo(anotherBook.author) ;
	    }

	    return result ;
	}
}
