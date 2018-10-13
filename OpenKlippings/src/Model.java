import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {

	private ArrayList<Quote> quoteList;
	private Library library;
	private Library exportLibrary;
	private String exportPath = "/home/andrew/Documents/KindleTest/";
	private String clippingsPath = "/home/andrew/Documents/My Clippings_new.txt";
	private static Model modelInstance = null; // Singleton Instance
	// Singleton - Private constructor

	private Model() {
		library = new Library();
		exportLibrary = new Library();
		quoteList = new ArrayList<Quote>(); // Obsolete
	}

	// Part of Singleton Pattern
	public static Model getInstance() {
		if (modelInstance == null) {
			modelInstance = new Model();
		}
		return modelInstance;
	}

	public void printAllYears() {
		for (Quote quote : quoteList) {
			System.out.println(quote.getTimeStamp().getYear());
		}
	}

	// master filepath is "/home/andrew/Documents/My Clippings.txt"
	public void scanFile(String filePath) {

		// decide here based on the input file whether to run on extracted notes mode or
		// master file / clippings mode

		File inputfile = new File(filePath);
		try (BufferedReader br = new BufferedReader(new FileReader(inputfile))) {
			String line; // should be named "titleLine"
			int iter = 0;
			while (1 == 1) {
				// this could be changed to the factory design pattern, making two quote
				// subclasses classes, one for master file and one for extracted files
				if ((line = br.readLine()) != null) {
					Quote quote = new Quote(line, br, inputfile.getName());
					if (filePath == clippingsPath) {
						quote.read();
						exportLibrary.addUniqueQuote(quote, library);

					} else {
						quote.readExtractedFile(inputfile);
						library.addQuote(quote);
					}


				} else {
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readExtractedFiles(String extractedDirPath) {
		File extractedDir = new File(extractedDirPath);
		if (extractedDir.isDirectory()) {
			if (extractedDir.list().length > 0) {
				// there are files to read
				for (String bookName : extractedDir.list()) {

					scanFile(exportPath + bookName);
				}
			}

		} else {
			System.out.println("ERROR - Extracted clippings directory doesn't exist");
			// ERROR - "Extracted Clippings" directory doesn't exist
		}
	}

	public void generateBookFiles() {
		exportLibrary.generateBookFiles();
	}

	public String getClippingsPath() {
		return clippingsPath;
	}

	public void setClippingsPath(String path) {
		this.clippingsPath = path;
	}

	public String getExportPath() {
		return exportPath;
	}

	public void setExportPath(String exportPath) {
		this.exportPath = exportPath;
		
	}
}
