package es.iesjandula.sample_project.models;

/**
 * This class represents the different attributes and action methods for authors
 *  
 * @author Paco Benítez
 *
 */
public class Author implements Comparable<Author>
{
	/** Attribute - First Name */
	private String firstName ;
	
	/** Attribute - Last Name */
	private String lastName ;
	
	/** Attribute - Overview */
	private String overview ;

	/**
	 * This is the constructor for authors
	 * 
	 * @param firstName with the first name
	 * @param lastName  with the last name
	 * @param overview  with the overview
	 */
	public Author(String firstName, String lastName, String overview)
	{
		this.firstName = firstName ;
		this.lastName  = lastName ;
		this.overview  = overview ;
	}

	/**
	 * @return the first name
	 */
	public String getFirstName()
	{
		return this.firstName ;
	}
	
	/**
	 * @param firstName the first name to set
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName ;
	}

	/**
	 * @return the last name
	 */
	public String getLastName()
	{
		return this.lastName ;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName ;
	}

	/**
	 * @return the overview
	 */
	public String getOverview()
	{
		return this.overview ;
	}

	/**
	 * @param overview the overview to set
	 */
	public void setOverview(String overview)
	{
		this.overview = overview ;
	}

	/**
	 * @return an object as string representation
	 */
	@Override
	public String toString()
	{
		return "Author [firstName=" + this.firstName + ", lastName=" + this.lastName + ", overview=" + this.overview + "]";
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
		
		// If the code is executing here is because the input object is instance of Author
		// So, we cannot do a casting
		Author other = (Author) object ;
		
		// Check if the 'firstName' of this class is null and the the attribute 'firstName' of the object is not null
		if (this.firstName == null && other.firstName != null)
		{
				return false ;
		}
		// Check if the values of the input class and object is not the same
		else if (!this.firstName.equals(other.firstName))
		{
			return false ;
		}
		// Check if the 'lastName' of this class is null and the attribute 'lastName' of the object is not null
		else if (this.lastName == null && other.lastName != null)
		{
			return false ;
		}
		// Check if the values of the input class and object is not the same
		else if (!this.lastName.equals(other.lastName))
		{
			return false ;
		}
		// Check if the 'overview' of this class is null and the attribute 'overview' of the object is not null
		else if (this.overview == null && other.overview != null)
		{
			return false ;
		}
		// Check if the values of the input class and object is not the same
		else if (!this.overview.equals(other.overview))
		{
			return false ;
		}
		
		// If we are here is because both instances are the same
		return true ;
	}

	/**
	 * This method belongs to Comparable interface
	 * 
	 * @param anotherAuthor with another author to be compared
	 * @return 0 if the argument is equal to this class. 
	 * 		   < 0 if this class is less than the string argument
	 * 		   > 0 if this class is greater than the string argument
	 */
	public int compareTo(Author anotherAuthor)
	{
		// Check the lastName
		int result = this.lastName.compareTo(anotherAuthor.lastName) ;

		// If both are the same, we need to compare the surname
	    if (result == 0)
	    {
	    	// Check the firstName
	        result = this.firstName.compareTo(anotherAuthor.firstName) ;
	        
	        if (result == 0)
	        {
		    	// Check the overview
		        result = this.overview.compareTo(anotherAuthor.overview) ;
	        }
	    }

	    return result ;
	}
}
