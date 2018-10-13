import java.util.ArrayList;

public class Library {
	private ArrayList<Book> bookList = new ArrayList<Book>();

	public void addUniqueQuote(Quote quote, Library refLibrary) {
		if (!refLibrary.contains(quote)) {
			this.addQuote(quote);
		}
	}

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

	public void generateBookFiles() {	
		for (Book book : bookList) {
			book.exportToFile();
		}

	}

}
