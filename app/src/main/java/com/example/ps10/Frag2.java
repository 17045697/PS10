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
public class Frag2 extends Fragment {
    TextView tvFrag2;
    Button btnChange;


    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_frag2, container, false);
        tvFrag2 = view.findViewById(R.id.tvFrag2);
        btnChange = view.findViewById(R.id.btnChange);
        tvFrag2.setText("On average a hedgehog's  heart beats 300times a minute.\n" +
                "\n" +
                "More people are killed each year from bees than from snakes.\n" +
                "\n" +
                "The average lead pencil will draw a line 35miles long or write approximately 50,000 English words.\n");

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
