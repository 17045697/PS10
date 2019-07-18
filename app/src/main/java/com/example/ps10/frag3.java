package com.example.ps10;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class frag3 extends Fragment {

    TextView tvFrag3;
    Button btnChange;


    public frag3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_frag3, container, false);
        tvFrag3 = view.findViewById(R.id.tvFrag3);
        btnChange = view.findViewById(R.id.btnChange);
        tvFrag3.setText("Earth is the only planet not named after a god.\n" +
                "\n" +
                "It's against the law to burp, or sneeze in a church in Nebraska, USA.\n" +
                "\n" +
                "You're born with 300 bones, but by the time you become an adult, youonly have 206.");

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int n = rand.nextInt(4);
                int color;
                if (n == 0) {
                    color = Color.RED;
                } else if (n == 1) {
                    color = Color.BLACK;
                } else if (n == 2) {
                    color = Color.YELLOW;
                } else {
                    color = Color.BLUE;
                }
                view.setBackgroundColor(color);
            }
        });

        return view;
    }

}
