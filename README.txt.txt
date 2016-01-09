This program will create a wordcloud image from either a file or a URL. It is limited to 200 words in order to ensure
that there is space on the screen for each word.

INSTRUCTIONS:
In order to run you must enter in the file/url to parse, the stopwords list and finally "true" or "false".
Entering "false" implies the that what you have entered is URL and thus will be treated as so.

e.g(URL):

java –cp ./wordcloud.jar ie.gmit.sw.Runner "http://www.gmit.ie/" "stopwordswithtags.txt" "false"

e.g(file):

java –cp ./wordcloud.jar ie.gmit.sw.Runner "./tolstoy.txt" "stopwordswithtags.txt" "true"

OTHER NOTES:
When using a URL it is advised to use the stopwrodswithtags.txt that is provided as it has additional words that are
common on html pages. However, the program will function with any stopwords file. The program will ignore tags such
as "<>:;{]"etc. 
The UML diagram was generated using the ObjectAid plugin for Eclipse.
The docs folder holds all the JavaDocs generated for the project.