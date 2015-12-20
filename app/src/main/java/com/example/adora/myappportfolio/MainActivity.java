package com.example.adora.myappportfolio;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // get the root view to which buttons will be added
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);

        // Find screen density scale factor, to convert pixels to dips
        final float scale = getResources().getDisplayMetrics().density;

        // define layout params (width, height etc)
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                (int)(200 * scale),  // width: 200 dips
                LinearLayout.LayoutParams.WRAP_CONTENT  // height
        );
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.bottomMargin = (int) (10 * scale);  // 10 dips

        // i will be building these apps, yaay!! :)
        String[] appNames = {
            "Spotify Streamer",
            "Scores App",
            "Library App",
            "Build It Bigger",
            "XYZ Reader",
            "Capstone"
        };

        // default colors for buttons
        int txtColor = Color.BLACK;
        String btnColor = "#f08c35";

        // create launch button for each app
        for (int i=0; i < appNames.length; i++) {
            if (i == appNames.length-1) {
                // coz last button is special! ;)
                btnColor = "#cc3022";
                txtColor = Color.WHITE;
            }
            Button buttonView = new Button(this);
            buttonView.setText(appNames[i]);
            buttonView.setTextColor(txtColor);
            buttonView.setBackgroundColor(Color.parseColor(btnColor));  // parseColor - hex to int
            buttonView.setOnClickListener(buttonClickListener);
            layout.addView(buttonView, params);
        }
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            String btnTxt = ((Button) view).getText().toString();
            Toast.makeText(
                    view.getContext(),
                    "This button will launch '" + btnTxt + "' App!",
                    Toast.LENGTH_SHORT
            ).show();
        }
    };
}
