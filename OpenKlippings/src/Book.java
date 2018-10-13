import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Book {
	private String title;
	private String exportPath;
	private ArrayList<Quote> quoteList = new ArrayList<Quote>();

	public Book(String bookTitle) {
		this.title = bookTitle;
		exportPath = Model.getInstance().getExportPath();
	}

	public String getTitle() {
		return this.title;
	}

	public void exportToFile() {
		File file = new File(exportPath + "/" + title + ".txt");
		BufferedWriter bw = null;

		try {

			FileWriter fw = new FileWriter(file, true);
			if (!file.exists()) {
				file.createNewFile();
				fw = new FileWriter(file);
			}

			bw = new BufferedWriter(fw);

			for (Quote quote : quoteList) {
				bw.write(quote.toString());
				bw.write("==========\n");
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}
	}

	public void addQuote(Quote quote) {

		if (!this.contains(quote)){
			if (quote.isNote()) {
				if ((this.quoteList.size() - 1) >= 0) {
					//if the quote being added is a note and there is a previous quote that accompanies it, append the note to the previous quote
					Quote prevQuote = this.quoteList.get(this.quoteList.size() - 1);
					String contentWithNote = prevQuote.getContent() + "\n[Note:]\n" + quote.getContent();
					prevQuote.setContent(contentWithNote);
				} else {
					this.quoteList.add(quote);
				}

			} else {
				this.quoteList.add(quote);
			}
			}
		/*
		// add code to check if quote exists
		for (Quote existingQuote : quoteList) {

			if (quote.getContent() != null && (quote.getContent().equals(existingQuote.getContent()))) {
				// quote already exists
				return;

			}
		}
		// Quote doesn't already exist
		if (quote.getContent() != null) {
			if (quote.isNote()) {
				if ((this.quoteList.size() - 1) >= 0) {
					//if the quote being added is a note and there is a previous quote that accompanies it, append the note to the previous quote
					Quote prevQuote = this.quoteList.get(this.quoteList.size() - 1);
					String contentWithNote = prevQuote.getContent() + "\n[Note:]\n" + quote.getContent();
					prevQuote.setContent(contentWithNote);
				} else {
					this.quoteList.add(quote);
				}

			} else {
				this.quoteList.add(quote);
			}

		}
*/
	}

	public boolean contains(Quote quote) {
		for (Quote existingQuote : quoteList) {
			if (quote.getContent() != null && (quote.getContent().equals(existingQuote.getContent()))) {
				// quote already exists
				return true;

			}
		}
		return false;
	}

}
