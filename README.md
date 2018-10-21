# OpenKlippings

Open Source Java app for organizing Kindle clippings by book title.
# Why use OpenKlippings?
By default, on the Amazon site, you can only sort through your Kindle notes and highlights by title for Amazon-bought books. For all other documents, this information is added to a single MyClippings.txt file which can quickly become lengthy and difficult to navigate.

OpenKlippings allows you to sort through your Kindle notes and highlights by exporting each title to a separate text file, regardless of whether they were purchased from Amazon or not.

# Dependencies
- [Java Development Kit (JDK) 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 

# Screenshot
![image](Screenshot.png?raw=true "OpenKlippings Interface")

# How to use OpenKlippings

### Running OpenKlippings

##### Windows

Git clone or download and extract OpenKlippings.

Open the OpenKlippings folder and double click OpenKlippings.jar

##### Linux and OSX (from a terminal)

`git clone https://github.com/AObuchow/OpenKlippings/`

`cd OpenKlippings/`

`java -jar OpenKlippings.jar`

### Using OpenKlippings
1. Click on the ![image][Clippings File] button and browse to your `MyClippings.txt` file and select it. 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The MyClippings.txt file should be located in the documents folder of your Kindle.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;For example, on a Linux system it would be something like `/run/media/username/Kindle/documents/MyClippings.txt`
  
2. Click on the ![image][Export Folder] button and browse to the folder where you want your book quote files to be exported to.
3. Click ![image][Run] and enjoy viewing your notes and highlights. They are now organized into separate files per title, in the export path you chose.

[Clippings File]: SetClippingsPath.png?raw=true
[Export Folder]: SetExportFolder.png?raw=true
[Run]: RunButton.png?raw=true

# Contributing
Although OpenKlippings is functional,  feel free to submit a pull request if you end up improving it. All help is greatly appreciated!

If you find a bug or have a feature request, you can report it in the issues section of this repo, and I will try to address it as soon as I can.

# License
OpenKlippings is licensed under the [GNU GPLv3](https://opensource.org/licenses/gpl-3.0.html).
