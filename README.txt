Data Structures and Algorithms Project - G00357770

-When the program runs, the menu shows up with 4 different options for the user.
-Please do steps 1 to 4 to set the max words and the image name.
-If the user does not set the max words and the image name, the default values will be used. 
-The default values are 25 for the max words and Default.png for the image name.

1.If the user picks option 1, they will be asked to input the maximum number of words they
would like to be dislayed in the image. I did this by sending the number as a parameter to the image generator function.

2.If option 2 is chosen the user is given the option of naming the image file. I also did this by sending it as a parameter.

3.When option 3 is chosen the user has to choose either a file or url to parse. If the file option is chosen the user has to input the file name.
It will then parse that file and output its word frequency to the user. After the word frequency is read out, the image generator function
is called and the image is created. The image is stored in the same folder as the project.

If the user chooses to input a url, they will be asked for the full url e.g https://www.gmit.ie or else the url will not be parsed. After
the url is parsed using the jsoup library, the image is generated the same way as the file parser. The parser also outputs the word frequency of
the url. 

I decided to use Jsoup because the normal url reader kept giving me the html tags and it basically read in the entire page instead of just the 
words. This was kind of messy so i tried to use Jsoup and it worked better so i stuck with it.

The image being generated is given random fonts and colours when it is being printed out.