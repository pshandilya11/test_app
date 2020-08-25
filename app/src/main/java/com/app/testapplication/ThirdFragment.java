package com.app.testapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Random;

import static android.content.ContentValues.TAG;
import static android.widget.Toast.LENGTH_SHORT;

public class ThirdFragment extends Fragment {
    int p = 0;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
      //  generateRandomNumber();


    }

    public void onViewCreated(@NonNull final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView points = view.findViewById(R.id.points);
        Button lb = view.findViewById(R.id.left_button);
        Button rb = view.findViewById(R.id.right_button);
        Random number = new Random();
        int l = number.nextInt(10);
        lb.setText(String.valueOf(l));
        points.setText(String.valueOf(l));
        int r = number.nextInt(10);
        rb.setText(String.valueOf(r));
        points.setText(String.valueOf("points: "+p));

        view.findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_thirdFragment_to_FirstFragment);
            }
        });
        view.findViewById(R.id.left_button).setOnClickListener(new View.OnClickListener() {
            TextView points = view.findViewById(R.id.points);
            Button lb = view.findViewById(R.id.left_button);
            Button rb = view.findViewById(R.id.right_button);

            @Override
            public void onClick(View view) {

                Random number = new Random();
                int l = number.nextInt(10);
                lb.setText(String.valueOf(l));
                points.setText(String.valueOf(l));
                int r = number.nextInt(10);
                rb.setText(String.valueOf(r));
                if (l > r) {
                    //you win
                    p++;

                } else {
                    if (p >= 0) {
                        p--;
                    } else {
                        p=0;
                    }
                    // Toast.makeText( android.app.Activity, "ohoo! you lost", LENGTH_SHORT).show();
                }
                points.setText(String.valueOf("points: "+p));
            }

        });
        view.findViewById(R.id.right_button).setOnClickListener(new View.OnClickListener() {
            TextView points = view.findViewById(R.id.points);
            Button lb = view.findViewById(R.id.left_button);
            Button rb = view.findViewById(R.id.right_button);
            @Override
            public void onClick(View view) {


               // Toast.makeText(this,"you won", LENGTH_SHORT).show();
                Random number = new Random();
                int l = number.nextInt(10);
                lb.setText(String.valueOf(l));
                int r = number.nextInt(10);
                rb.setText(String.valueOf(r));
                if (l < r) {
                    //you win
                    p++;

                } else {
                    if (p >= 0) {
                        p--;
                    } else {
                        p=0;
                    }
                 // Toast.makeText( android.app.Activity, "ohoo! you lost", LENGTH_SHORT).show();
                }
                points.setText(String.valueOf("points: "+p));

            }
        });
    }
    }


