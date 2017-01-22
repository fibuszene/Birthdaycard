package at.fibuszene.birthdaycard;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.TextView;

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

    }
}
