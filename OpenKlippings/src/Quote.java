import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class which can be instantiated to read and contain quote data.
 * @author Andrew Obuchowicz
 *
 */
public class Quote {
	private String firstLine;
	private BufferedReader br;
	private String title = "[DEFAULT TITLE]";
	private String content = "";
	private TimeStamp timestamp = new TimeStamp("null", "null", -1, -1, "null"); // Default TimeStamp, should only
																					// appear when a quotes metadata
																					// couldn't be read properly
	private boolean isNote = false;
	private String fileName;

	public Quote(String line, BufferedReader br, String fileName) {
		this.br = br;
		this.firstLine = line;
		this.fileName = fileName;
	}

	public TimeStamp getTimeStamp() {
		return this.timestamp;
	}

	public String getTitle() {
		return this.title;
	}

	public String getContent() {
		return this.content;
	}

	/**
	 * String representation of a quote.
	 * Determines the export formatting of the quote.
	 */
	@Override
	public String toString() {
		String quoteStr = "| " + this.getTimeStamp().toString() + "\n" + this.getContent() + "\n";

		return quoteStr;
	}

	public Boolean isNote() {
		return this.isNote;
	}

	public void setContent(String contentString) {
		this.content = contentString;
	}

	/**
	 * Reads a quote from the given file which contains an extracted note, generated
	 * by OpenKlippings
	 * 
	 * @param file File to read quote from
	 *            
	 */
	public void readExtractedFile(File file) {
		this.title = file.getName().substring(0, file.getName().length() - 4); // remove .txt from filename
		String currentLine = firstLine;
		String dividerRegex = "==========";
		String metaDataRegex = "\\| Added on (Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (January|February|March|April|May|June|July|August|September|November|December) (\\d.), (\\d+) (\\d+:\\d\\d:\\d.)"; // Regex
																																																								// is
																																																								// missing
																																																								// AM/PM
		Pattern dividerPattern = Pattern.compile(dividerRegex);
		Pattern metaDataPattern = Pattern.compile(metaDataRegex);
		Matcher dividerMatcher = dividerPattern.matcher(currentLine);

		while (!dividerMatcher.matches()) {
			dividerMatcher = dividerPattern.matcher(currentLine);
			Matcher metaDataMatcher = metaDataPattern.matcher(currentLine);

			if (metaDataMatcher.matches()) {
				// quote metadata found
				String dayOfWeek = metaDataMatcher.group(1); // Day of Week
				String month = metaDataMatcher.group(2); // Month
				int dayOfMonth = Integer.valueOf((metaDataMatcher.group(3)));// Day of Month
				int year = Integer.valueOf((metaDataMatcher.group(4))); // Year
				String timeOfDay = (metaDataMatcher.group(5)); // Time of Day
				this.timestamp = new TimeStamp(dayOfWeek, month, dayOfMonth, year, timeOfDay);

			} else if (currentLine.length() != 0) {
				// quote content found
				content = currentLine;
			}

			// read next line
			try {
				currentLine = br.readLine();
				dividerMatcher = dividerPattern.matcher(currentLine);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * Reads a quote from the MyClippings file and stores its data in the quote
	 * calling the function.
	 */
	public void readKindleClippings() {
		String currentLine = firstLine;
		String dividerRegex = "==========";
		String titleRegex = "(.+)\\s(\\(.+\\))";
		String metaDataRegex = ".+ \\| Added on (Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (January|February|March|April|May|June|July|August|September|November|December) (\\d+), (\\d+) (\\d+:\\d\\d:\\d.) (AM|PM)";
		Pattern dividerPattern = Pattern.compile(dividerRegex);
		Pattern titlePattern = Pattern.compile(titleRegex);
		Pattern metaDataPattern = Pattern.compile(metaDataRegex);

		Matcher dividerMatcher = dividerPattern.matcher(currentLine);

		while (!dividerMatcher.matches()) {
			dividerMatcher = dividerPattern.matcher(currentLine);
			Matcher titleMatcher = titlePattern.matcher(currentLine);
			Matcher metaDataMatcher = metaDataPattern.matcher(currentLine);
			// match current line

			if (currentLine == firstLine) {
				title = firstLine;
				if (titleMatcher.matches()) {
					title = titleMatcher.group(1); // If the book a email in it, this removes it
				}
			} else if (metaDataMatcher.matches()) {

				if (currentLine.contains("Note")) {
					this.isNote = true;
				}
				String dayOfWeek = metaDataMatcher.group(1); // Day of Week
				String month = metaDataMatcher.group(2); // Month
				int dayOfMonth = Integer.valueOf((metaDataMatcher.group(3)));// Day of Month
				int year = Integer.valueOf((metaDataMatcher.group(4))); // Year
				String timeOfDay = (metaDataMatcher.group(5)); // Time of Day
				this.timestamp = new TimeStamp(dayOfWeek, month, dayOfMonth, year, timeOfDay);

			} else if (currentLine.length() == 0) {
			} else {

				// Actual content of highlight/note
				content = currentLine;

			}

			// read next line
			try {
				currentLine = br.readLine();
				dividerMatcher = dividerPattern.matcher(currentLine);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
