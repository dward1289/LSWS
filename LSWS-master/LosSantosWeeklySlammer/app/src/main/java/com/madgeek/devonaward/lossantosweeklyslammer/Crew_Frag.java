package com.madgeek.devonaward.lossantosweeklyslammer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by devonaward on 7/1/15.
 */
public class Crew_Frag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.newsfrag_layout,
                container, false);
        return view;

    }
}