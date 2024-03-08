package com.example.modularity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class userAccountActivity extends AppCompatActivity {

    ImageButton backButton;
    NormalLoginFragment normalLoginFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        backButton=findViewById(R.id.user_panel_back_button);
        normalLoginFragment=new NormalLoginFragment();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_mainActivity=new Intent(getBaseContext(),MainActivity.class);
                startActivity(go_to_mainActivity);

            }
        });
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.user_panel_fragment_container,normalLoginFragment).commit();
    }

}