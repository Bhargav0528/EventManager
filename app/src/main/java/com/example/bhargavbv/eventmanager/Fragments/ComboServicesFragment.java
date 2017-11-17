package com.example.bhargavbv.eventmanager.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bhargavbv.eventmanager.CustomAdapter;
import com.example.bhargavbv.eventmanager.R;
import com.example.bhargavbv.eventmanager.Services_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComboServicesFragment extends Fragment {

    private RecyclerView recview;
    private RecyclerView.Adapter recadapter;

    private FirebaseAuth mAuth;
    private DatabaseReference dref;

    private List<Services_model> models;

    private static final String TAG = "Comboservice";

    public ComboServicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String event = getActivity().getIntent().getStringExtra("event");
        mAuth = FirebaseAuth.getInstance();

        View view =  inflater.inflate(R.layout.fragment_combo_services, container, false);
        recview = (RecyclerView)view.findViewById(R.id.recview);
        recview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recview.setLayoutManager(layoutManager);

        models = new ArrayList<>();
        dref = FirebaseDatabase.getInstance().getReference();

        dref.child("events").child("wedding").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postsnap : dataSnapshot.getChildren())
                {
                    Services_model model = postsnap.getValue(Services_model.class);
                    models.add(model);
                    Log.i(TAG,models.toString());
                    recadapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        recadapter = new CustomAdapter(getActivity(),models);
        recview.setAdapter(recadapter);
        return view;
    }

}
