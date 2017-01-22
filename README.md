<h1>Make Your Own Card</h1>

This is an exercise for the Udacity Course **Android Basics:User Interface (EU)**

In Order to complete the exercise we had to design a Card first with Pen and Paper and then via Android Layout and XML. 
[Requirement Specification](https://classroom.udacity.com/courses/ud834-eu/lessons/2bdfe89e-b44c-4789-90a6-755077aff7f8/concepts/43534185690923#)


The  ![Mockup](/screens/mockup.png) show that I wanted sort of a Postcard look and feel. 
To achive this view I used a vertical layout to stack some TextViews on top of each other. 
To seperate the text from the adress view i used a View layout with the height of 1px (-> px cause I want it to be the same height on all devices). 
The same is used as seperator for the Adress lines. 
The Stamp is an ImageView put into place with android:layout_gravity="right|end|bottom" and rotate a bit to achieve a less mechanical look. 

Since a postcard has two sides i used Androids rotate/landscape layout to display another layout (activity_main in res/layout-land) which is just a 
fullscreen ImageView with some Text. 

 ![Front](/screens/portrait_card.png)
 ![Back](/screens/landscape_card.png)
