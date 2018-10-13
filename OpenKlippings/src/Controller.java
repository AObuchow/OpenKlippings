import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Controller implements ActionListener {
	private Model model;
	private View view;

	public Controller(Model model) {
		this.model = model;
	}

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
			model.readExtractedFiles(model.getExportPath());
			model.scanFile(model.getClippingsPath());
			model.generateBookFiles();

		}

	}

	public void setView(View view) {
		this.view = view;

	}

}
