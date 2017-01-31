<h1>Make Your Own Card</h1>

This is an exercise for the Udacity Course **Android Basics:User Interface (EU)**

In Order to complete the exercise we had to design a Card first with Pen and Paper and then via Android Layout and XML. 
[Requirement Specification](https://classroom.udacity.com/courses/ud834-eu/lessons/2bdfe89e-b44c-4789-90a6-755077aff7f8/concepts/43534185690923#)


The  Mockup shows that I wanted sort of a Postcard look and feel. 
![Mockup](/screens/mockup.jpg)
To achive this view I used a vertical layout to stack some TextViews on top of each other. 
To seperate the text from the adress view i used a View layout with the height of 1px (-> px cause I want it to be the same height on all devices). 
The same is used as seperator for the Adress lines. 
The Stamp is an ImageView put into place with android:layout_gravity="right|end|bottom" and rotate a bit to achieve a less mechanical look. 


*Edit: 

I got the suggestion to remove the ActionBar which does look a lot better: 

![Front](/screens/p_no_action.png)

![Back](/screens/l_no_action.png)


Another thing i did was to change the color of the Actionbar to change depending on a Palette created from the background Image of the card. 
It does look a lot like the initial design but now every time the User changes rotation the Statusbar (> Lollipop) and the Actionbar 
get another Color.
Also i added the Vertical Text View which is really hard to read and frustrating cause if you flip the phone around to read it the View changes :D. 

![Front](/screens/l_color.png)

![Back](/screens/p_color.png)


The Code to change the color can be found in the MainActivity. 

```java
 public void setBackgroundColor() {
        ActionBar supportActionBar = getSupportActionBar();
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.nordkette);
        Palette pallet = Palette.generate(image);
        List<Palette.Swatch> swatches = pallet.getSwatches();
        try {//Around all of it cause there is no point in coloring one if the other fails
            int random = ((int) (Math.random() * 1000)) % swatches.size();
            Palette.Swatch randomSwatch = swatches.get(random);
            if (randomSwatch != null && supportActionBar != null) {
                int color = randomSwatch.getRgb();
                supportActionBar.setBackgroundDrawable(new ColorDrawable(color));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(color);
                }
            }
        } catch (Exception e) {
            //most likely a IndexOutOfbound
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
    }
```



Since a postcard has two sides i used Androids rotate/landscape layout to display another layout (activity_main in res/layout-land) which is just a 
fullscreen ImageView with some Text. 

![Front](/screens/portrait_card.png)
![Back](/screens/landscape_card.png)


And the whole thing in the interface builder of Android Studio...

![Back](/screens/screen_port_builder.png)
![Front](/screens/screen_land_builder.png)

