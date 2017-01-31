package at.fibuszene.birthdaycard;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView visitTxtView, cardText, adressLine, adressLine1, adressLine2;
    private TextView visit, fromTxtView, fromNameTxtView;
    private Typeface oldTimeyFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Could be a CustomTextView but why bother for those couple of TextViews
        oldTimeyFont = Typeface.createFromAsset(this.getAssets(), "fonts/oldtimey.ttf");

        if (Configuration.ORIENTATION_LANDSCAPE == getResources().getConfiguration().orientation) {
            visit = (TextView) findViewById(R.id.visit);
            fromTxtView = (TextView) findViewById(R.id.fromTxtView);
            fromNameTxtView = (TextView) findViewById(R.id.fromNameTxtView);

            visit.setTypeface(oldTimeyFont);
            fromTxtView.setTypeface(oldTimeyFont);
            fromNameTxtView.setTypeface(oldTimeyFont);

        } else if (Configuration.ORIENTATION_PORTRAIT == getResources().getConfiguration().orientation) {

            visitTxtView = (TextView) findViewById(R.id.visitTxtView);
            cardText = (TextView) findViewById(R.id.cardText);
            adressLine = (TextView) findViewById(R.id.adressLine);
            adressLine1 = (TextView) findViewById(R.id.adressLine1);
            adressLine2 = (TextView) findViewById(R.id.adressLine2);

            visitTxtView.setTypeface(oldTimeyFont);
            cardText.setTypeface(oldTimeyFont);
            adressLine.setTypeface(oldTimeyFont);
            adressLine1.setTypeface(oldTimeyFont);
            adressLine2.setTypeface(oldTimeyFont);

        }

        setBackgroundColor();
    }

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
}
