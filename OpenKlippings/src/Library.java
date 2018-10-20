import java.util.ArrayList;
/**
 * This class contains a list of books which have been scanned
 * and functions to operate on them
 * @author Andrew Obuchowicz
 *
 */
public class Library {
	private ArrayList<Book> bookList = new ArrayList<Book>();

	  /**
	   * Adds a quote into the library it is called on, ensuring the quote is not already contained in the refLibrary
	   * @param quote Quote to add into the library 
	   * @param refLibrary Library which must not already contain the quote in order for it to be added
	   */
	public void addUniqueQuote(Quote quote, Library refLibrary) {
		if (!refLibrary.contains(quote)) {
			this.addQuote(quote);
		}
	}

	  /**
	   * Determine if the give quote is already contained in the library
	   * @param quote Quote to check
	   * @return Boolean True if the library contains the quote, false otherwise
	   */
	private boolean contains(Quote quote) {
		for (Book book : bookList) {
			if (book.getTitle().equals(quote.getTitle())) {
				// book exists in collection
				if (book.contains(quote)) {
					return true;
				} else {
					return false;
				}

			}
		}
		return false;
	}

	  /**
	   * Adds the given quote to the library if it is unique.
	   * @param quote Quote to add
	   */
	public void addQuote(Quote quote) {
		for (Book book : bookList) {
			if (book.getTitle().equals(quote.getTitle())) {
				// book exists in collection
				book.addQuote(quote);
				return;
			}
		}

		// book doesn't exist in collection
		Book book = new Book(quote.getTitle());
		book.addQuote(quote);
		bookList.add(book);
	}
	
	/**
	 * Appends to or creates files for each book in the library, containing quote data.
	 */
	public void generateBookFiles() {	
		for (Book book : bookList) {
			book.exportToFile();
		}

	}

}
