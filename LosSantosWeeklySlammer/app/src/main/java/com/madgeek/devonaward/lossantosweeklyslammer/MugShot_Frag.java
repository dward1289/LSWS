package com.madgeek.devonaward.lossantosweeklyslammer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by devonaward on 6/8/15.
 */
public class MugShot_Frag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.mugshot_frag,
                container, false);
        return view;

    }
}