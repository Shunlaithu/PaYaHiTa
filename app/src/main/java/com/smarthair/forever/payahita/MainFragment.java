package com.smarthair.forever.payahita;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;



public class MainFragment extends Fragment {

    ViewFlipper fp ;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        fp = (ViewFlipper)view.findViewById(R.id.flip);
        fp.startFlipping();
        fp.setAutoStart(true);
        fp.setFlipInterval(3000);
        fp.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        fp.setOutAnimation(getActivity(),android.R.anim.slide_out_right);

        return view;
    }

}
