package com.example.modularity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NormalLoginFragment extends Fragment {

    public NormalLoginFragment() {
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
        return inflater.inflate(R.layout.fragment_normal_login, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.go_to_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               RegisterFragment registerFragment=new RegisterFragment();
               requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.user_panel_fragment_container,registerFragment).commit();
            }
        });
    }
}