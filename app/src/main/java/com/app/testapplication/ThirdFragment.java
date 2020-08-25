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

        view.findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_thirdFragment_to_FirstFragment);
            }
        });
        view.findViewById(R.id.left_button);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextView points = view.findViewById(R.id.points);
                Button lb = view.findViewById(R.id.left_button);
                Button rb = view.findViewById(R.id.right_button);

                Random number = new Random();
                int l = number.nextInt(10);
                lb.setText(String.valueOf(l));
                int r = number.nextInt(10);
                rb.setText(String.valueOf(r));
                if (l > r) {
                    //you win
                    p++;
                    points.setText(String.valueOf(p));
                  //  Toast.makeText(R.id.left_button,"you won", LENGTH_SHORT).show();
                } else {
                    if (p >= 0) {
                        p--;
                    } else {
                        points.setText(String.valueOf(0));
                    }
                //    Toast.makeText(this, "ohoo! you lost", LENGTH_SHORT).show();
                }
            }
        });
        view.findViewById(R.id.right_button).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextView points = view.findViewById(R.id.points);
                Button lb = view.findViewById(R.id.left_button);
                Button rb = view.findViewById(R.id.right_button);

               // Toast.makeText(this,"you won", LENGTH_SHORT).show();
                Random number = new Random();
                int l = number.nextInt(10);
                lb.setText(String.valueOf(l));
                int r = number.nextInt(10);
                rb.setText(String.valueOf(r));
                if (l < r) {
                    //you win
                    p++;
                    points.setText(String.valueOf(p));

                } else {
                    if (p >= 0) {
                        p--;
                    } else {
                        points.setText(String.valueOf(0));
                    }
                  //  Toast.makeText(this, "ohoo! you lost", LENGTH_SHORT).show();
                }

            }
        });


}

    }


