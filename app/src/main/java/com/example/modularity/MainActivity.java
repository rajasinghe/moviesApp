package com.example.modularity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout homeButton,moviesButton,tvShowsButton;

   Home home_fragment;
   Movies movie_fragment;

   TvShows tvshows_fragment;

   ImageButton userButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeButton=findViewById(R.id.homeButton);
        tvShowsButton=findViewById(R.id.tvShowsBtn);
        moviesButton=findViewById(R.id.moviesBtn);
        userButton=findViewById(R.id.user_button);
        home_fragment=new Home();
        movie_fragment=new Movies();
        tvshows_fragment=new TvShows();

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_user_activity=new Intent(getBaseContext(),userAccountActivity.class);
                startActivity(go_to_user_activity);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.main_container,home_fragment).commit();
            }
        });
        tvShowsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.main_container,tvshows_fragment).commit();
            }
        });
        moviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.main_container,movie_fragment).commit();
            }
        });
    }

}