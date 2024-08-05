package com.example.nike.Fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.example.nike.R;


public class HomeFragment extends Fragment {

    private TextView tablayout1, tablayout2;
    private int selectedTabNumber = 1;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Anhxa(view);

        getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                                .replace(R.id.fragmentContainer, MenFragment.class, null)
                                        .commit();
        tablayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(1);
            }
        });
        tablayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(2);

            }
        });



        return view;
    }
    private void selectTab(int tabNumber){
        TextView selectedTextview1;
        TextView nonselectedTextview2;

        if(tabNumber == 1){
            selectedTextview1 = tablayout1;
            nonselectedTextview2 = tablayout2;

            getActivity().getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, MenFragment.class, null)
                    .commit();
        } else {
                selectedTextview1 = tablayout2;
                nonselectedTextview2 = tablayout1;

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragmentContainer, WomenFragment.class, null)
                        .commit();

        }
        float slideto = (tabNumber - selectedTabNumber) * selectedTextview1.getWidth();
        TranslateAnimation translateAnimation = new TranslateAnimation(0,slideto,0, 0);

        translateAnimation.setDuration(100);

        if(selectedTabNumber == 1){
            tablayout1.startAnimation(translateAnimation);
        }else {
            tablayout2.startAnimation(translateAnimation);
        }

        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                selectedTextview1.setBackgroundResource(R.drawable.round_back_white_100);
                selectedTextview1.setTypeface(null, Typeface.BOLD);
                selectedTextview1.setTextColor(Color.BLACK);

                nonselectedTextview2.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                nonselectedTextview2.setTextColor(Color.WHITE);
                nonselectedTextview2.setTypeface(null, Typeface.NORMAL);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        selectedTabNumber = tabNumber;

    }

    private void Anhxa(View view){

        tablayout1 = view.findViewById(R.id.tabItem1);
        tablayout2 = view.findViewById(R.id.tabItem2);

    }
}