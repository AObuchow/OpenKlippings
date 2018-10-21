# OpenKlippings

Open Source Java app for organizing Kindle clippings by book title.
# Why use OpenKlippings?
By default, on the Amazon site you can only see your Kindle notes and highlights in an organized manner for Amazon-bought books.

OpenKlippings allows you to sort through your Kindle notes and highlights by exporting them to a seperate text file, regardless of whether they were purchased from Amazon or not.

# Dependencies
- Java SE Runtime Environment 8

# Screenshot
![image](Screenshot.png?raw=true "OpenKlippings Interface")

# How to use OpenKlippings

### Running OpenKlippings

##### Windows

Git clone or download and extract OpenKlippings.

Open the OpenKlippings folder and double click OpenKlippings.jar

##### Linux and OSX (from a terminal)

`git clone https://github.com/AObuchow/OpenKlippings/`

`cd OpenKlippings`

`java -jar OpenKlippings.jar`

### Using OpenKlippings
1. Click on the `Set Clippings Path` button and browse to your `MyClippings.txt` file and select it. 

  The MyClippings.txt file should be located in the documents folder of your Kindle.
  For example, on a Linux system `/run/media/username/Kindle/documents/MyClippings.txt`⋅⋅
  
2. Click on the `Set Export Path` button and browse to the folder where you want your book quote files to be exported to.
3. Click `Run!` and enjoy viewing your notes and highlights. They are now organized into seperate files per title, in the export path you chose.

# License
OpenKlippings is licensed under the GNU GPLv3
