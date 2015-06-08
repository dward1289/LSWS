package com.madgeek.devonaward.lossantosweeklyslammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by devonaward on 6/8/15.
 */
public class Slammer extends Activity {

    TextView titleTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slammer_layout);

        titleTxt = (TextView)findViewById(R.id.titleTxt);
        titleTxt.setText("Slammer");


    }

}
