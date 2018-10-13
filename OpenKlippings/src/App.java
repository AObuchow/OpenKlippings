import java.nio.file.Path;

public class App {
	public static void main(String[] args) {
		Model modelInstance = Model.getInstance();
		 Controller controller = new Controller(modelInstance);
		 View view = new View(controller);


		//If user provides arguments
		if (args.length == 1) {
			modelInstance.setClippingsPath(args[0]);
		} else if (args.length == 2){
			//user  provided clippings Path and export path
			modelInstance.setExportPath(args[1]);
			modelInstance.setClippingsPath(args[0]);
		}

		
	}
}
