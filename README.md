# CS441-Project-4-android
This project is the 4th project of cs441


Objective:
This app is meant to learn RecyclerView and surface view with drawing activities as well as talk to the Web using JOSO.

This app is divided into two parts. First, I created the main activity page as the main menu to hold this two-part. The first part is a food table implemented by Recycle view. I create another activity as the recycle adapter which holds an image and a name for the image. I group all my image into an array and display them into a grid with two columns.I can extend this list by adding more images if I want. Second, I created another activity  for the surface layout and two seek bars with a class called myCanvas which has the functionalities to draw a line on the surface view base on Canvas draw line function.  By control this two seek bars,  users could control the M and B of the line which is base on the line function y=mx+b.  I also put a reset button and a get web button on this activity. The reset button would reset the starXY and stop XY of the drawing line. The get Web button has the functionality of talking to the PHP file running in the CS department which read the Value of M and double the value. The draw function is called immediately after finish reading the result. 

Time line: 
7/2: project first initial
7/3: added main activity control and base recycleview
7/4: Create recycleview adapter, add images into the food table
7/6: Create surfaceholder and Canvas class
7/7: Create draw line funiction in Canvas class, create two seekbars that control m and b
7/8: Added web response(did not work)
7/9: Web service is now working on my laptop but not desktop(Don't know why, IO exception on my desktop), edit README file.
7/10: 

