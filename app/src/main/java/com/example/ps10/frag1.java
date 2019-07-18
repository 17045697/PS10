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
public class frag1 extends Fragment {
    TextView tvFrag1;
    Button btnChange;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_frag1, container, false);
        tvFrag1 = view.findViewById(R.id.tvFrag1);
        btnChange = view.findViewById(R.id.btnChange);
        tvFrag1.setText("The word \"queue\"is the only word in the English language that is still pronounced thesame way when the last four letters are removed. \n" +
                "Beetles taste like apples, wasps like pine nuts,and worms  like fried bacon.\n" +
                "\n" +
                "Of all the words in the English language, theword 'set' has the most definitions!\n");

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int n = rand.nextInt(4);
                int color;
                if (n == 0) {
                    color = Color.GREEN;
                } else if (n == 1) {
                    color = Color.GRAY;
                } else if (n == 2) {
                    color = Color.RED;
                } else {
                    color = Color.BLUE;
                }
                view.setBackgroundColor(color);
            }
        });

        return view;
    }

}
