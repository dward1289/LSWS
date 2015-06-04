package com.madgeek.devonaward.lossantosweeklyslammer;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by devonaward on 6/2/15.
 */
public class BG_Frag extends Fragment {
    TextView titleTxt;
    Typeface typeface;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.title_frag,
                container, false);

        //Custom font: Florence Outline
        titleTxt = (TextView) view.findViewById(R.id.titleTxt);
        typeface = Typeface.createFromAsset(getActivity().getAssets(), "florenceoutline.ttf");
        titleTxt.setTypeface(typeface);

        return view;
    }

}
