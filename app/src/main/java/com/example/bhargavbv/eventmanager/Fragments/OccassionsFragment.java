package com.example.bhargavbv.eventmanager.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.bhargavbv.eventmanager.ComboProvidersActivity;
import com.example.bhargavbv.eventmanager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OccassionsFragment extends Fragment {

    private ImageView wed;
    private ImageView bday;
    private ImageView fam;
    private ImageView sem;
    private ImageView press;
    private ImageView team;

    public OccassionsFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_occasions, container, false);
        wed = (ImageView)view.findViewById(R.id.wedding);
        bday = (ImageView)view.findViewById(R.id.birthday);
        fam = (ImageView)view.findViewById(R.id.famevent);
        sem = (ImageView)view.findViewById(R.id.seminar);
        press = (ImageView)view.findViewById(R.id.presscon);
        team = (ImageView)view.findViewById(R.id.teambuild);
        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ComboProvidersActivity.class);
                i.putExtra("event", "wedding"); //Optional parameters
                startActivity(i);
            }
        });

        bday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ComboProvidersActivity.class);
                i.putExtra("event", "birthday"); //Optional parameters
                startActivity(i);
            }
        });

        fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ComboProvidersActivity.class);
                i.putExtra("event", "family"); //Optional parameters
                startActivity(i);
            }
        });

        sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ComboProvidersActivity.class);
                i.putExtra("event", "seminar"); //Optional parameters
                startActivity(i);
            }
        });

        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ComboProvidersActivity.class);
                i.putExtra("event", "press"); //Optional parameters
                startActivity(i);
            }
        });

        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ComboProvidersActivity.class);
                i.putExtra("event", "teambuild"); //Optional parameters
                startActivity(i);
            }
        });
        return view;
    }

}
