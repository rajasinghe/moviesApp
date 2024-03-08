package com.example.modularity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegisterFragment extends Fragment {

    String TAG="register";
    Button registerButton;
    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerButton=view.findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputLayout textInputLayout=view.findViewById(R.id.full_name_field);
                String fullname =textInputLayout.getEditText().getText().toString();
                textInputLayout=view.findViewById(R.id.user_name_field);
                String username=textInputLayout.getEditText().getText().toString();
                textInputLayout=view.findViewById(R.id.password_field);
                String password=textInputLayout.getEditText().getText().toString();
                registerUser(fullname,username,password);
                Log.d("", "onClick: registerButton Clicked");
            }
        });
    }

    void registerUser(String fullName,String userName,String password){
        Users user=new Users(fullName,userName,password);
        sendData(user);
    }
    void sendData(Users object){
        FirebaseDatabase database=FirebaseDatabase.getInstance("https://movieapp-d6291-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference databaseReference= database.getReference("users").child("messages");
        String userKey=databaseReference.push().getKey();
        Map<String, Object> updates=new HashMap<>();
        updates.put(userKey,object);
        databaseReference.updateChildren(updates).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        Log.d(TAG, "sendData: "+userKey);


    }

}