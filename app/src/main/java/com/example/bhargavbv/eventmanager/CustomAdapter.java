package com.example.bhargavbv.eventmanager;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by BhargavBV on 16-11-2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    public Context c;
    private List<Services_model> models;
    private FirebaseAuth mAuth;
    private DatabaseReference dref;


    public CustomAdapter(Context c, List<Services_model> models) {
        this.c = c;
        this.models = models;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_services, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomAdapter.ViewHolder holder, int position) {

        Services_model model = models.get(position);

        mAuth = FirebaseAuth.getInstance();
        dref = FirebaseDatabase.getInstance().getReference();

        dref.child("serviceProviders").child(model.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    profileModel prof = dataSnapshot.getValue(profileModel.class);
                    holder.compname.setText(prof.getCompanyName());
                Picasso.with(c)
                        .load(prof.getPhoto())
                        .into(holder.dp);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        holder.nameTxt.setText(model.getCat());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView nameTxt;
        public TextView compname;
        public ImageView dp;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTxt = itemView.findViewById(R.id.tvname);
            compname = itemView.findViewById(R.id.compname);
            dp = itemView.findViewById(R.id.dp);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(c,"Hello",Toast.LENGTH_SHORT).show();
        }
    }
}
