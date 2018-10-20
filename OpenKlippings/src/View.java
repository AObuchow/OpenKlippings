import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * View class, part of the MVC design pattern
 * Responsible for defining and creating GUI elements of OpenKlippings
 * @author andrew
 *
 */
public class View extends JFrame  {
	  private Controller controller;
	  private int buttonsWidth = 220;
	  private int buttonsHeight = 30;

	public View   (Controller controller){
		    super("OpenKlippings"); //Set title
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    Container c = this.getContentPane();
		    c.setLayout(new FlowLayout());
		    c.setPreferredSize(new Dimension(250, 110));
		    this.controller = controller; //Action Listener 
		    controller.setView(this);
		    JButton button1 = new JButton("Set Clippings Path");
		    JButton button2 = new JButton("Set Export Folder");
		    JButton runButton = new JButton("Run!");
		    
		    
			button1.setPreferredSize(new Dimension(buttonsWidth, buttonsHeight));
			button2.setPreferredSize(new Dimension(buttonsWidth, buttonsHeight));
			runButton.setPreferredSize(new Dimension(buttonsWidth, buttonsHeight));
			
		    button1.addActionListener(controller);
		    button2.addActionListener(controller);
		    runButton.addActionListener(controller);
		    
		    button2.setActionCommand("Extracted Path");
		    button1.setActionCommand("Clippings Path");
		    runButton.setActionCommand("Run");
		    
		    c.add(button1);
		    c.add(button2);
		    c.add(runButton);

		    this.pack();
		    this.setVisible(true);
		  }

}
