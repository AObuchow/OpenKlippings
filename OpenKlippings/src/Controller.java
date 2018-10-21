import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * Controller class, part of the MVC design pattern.
 * Adds logic to the view class' GUI elements by calling Model functions.
 * @author Andrew Obuchowicz
 *
 */
public class Controller implements ActionListener {
	private Model model;
	private View view;

	public Controller(Model model) {
		this.model = model;
	}
	  /**
	   * Determines which event has occurred in the View class
	   * and calls the model class accordingly. 
	   */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Clippings Path")) {
			JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt", "text");
			fc.setFileFilter(filter);
			int returnVal = fc.showOpenDialog(view);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				model.setClippingsPath(file.getPath());
			}

		} else if (command.equals("Extracted Path")) {
			

			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showOpenDialog(view);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				model.setExportPath(file.getPath());
			}
		} else if (command.equals("Run")) {
			
			if (model.getClippingsPath() != Model.UNDEFINED_PATH) {
				
				
				if (model.getExportPath() != Model.DEFAULT_EXPORT_PATH) {

					model.readExtractedFiles(model.getExportPath());
					model.scanFile(model.getClippingsPath());
					model.generateBookFiles();
					JOptionPane.showMessageDialog(null, "Success! All your clippings have been exported to seperate files, located in: " + model.getExportPath(), "Success.", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "The export folder hasn't been set. \nPress the Set Export Folder button and select the folder you want your notes and highlights to be exported to before hitting run.", "Error: Export Folder not defined.", JOptionPane.INFORMATION_MESSAGE);
				}
				

			} else {
				JOptionPane.showMessageDialog(null, "The clippings path hasn't been set. \nPress the Set Clippings Path button and select your MyClippings.txt file before hitting run.", "Error: Clippings path not defined.", JOptionPane.INFORMATION_MESSAGE);
			}


		}

	}

	public void setView(View view) {
		this.view = view;

	}

}
