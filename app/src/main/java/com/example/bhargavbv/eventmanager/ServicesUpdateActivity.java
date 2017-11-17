package com.example.bhargavbv.eventmanager;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

public class ServicesUpdateActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private StorageReference sref;
    private DatabaseReference dref;
    ImageView img1,img2,img3;
    CheckBox wed,bir,fam,press,team,sem;
    RadioButton cat,dec,vid,eve,par,mus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_update);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("|  MrManager");
        toolbar.setTitleTextAppearance(this,R.style.MyTitleTextApperance);
        toolbar.setTitleMarginStart(350);
        toolbar.setTitleTextColor(Color.parseColor("#FFD740"));
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();


        dec = (RadioButton) findViewById(R.id.decorator);
        cat = (RadioButton)findViewById(R.id.caterer);
        vid = (RadioButton)findViewById(R.id.videographer);
        mus = (RadioButton)findViewById(R.id.musicians);
        par = (RadioButton)findViewById(R.id.party);
        eve = (RadioButton)findViewById(R.id.eveplanner);

        wed = (CheckBox) findViewById(R.id.wedding);
        bir = (CheckBox)findViewById(R.id.birthday);
        fam = (CheckBox)findViewById(R.id.family);
        press = (CheckBox)findViewById(R.id.press);
        team = (CheckBox)findViewById(R.id.team);
        sem = (CheckBox)findViewById(R.id.seminar);



        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailsupdate();
                startActivity(new Intent(ServicesUpdateActivity.this,MainActivity.class));
            }
        });
    }

    void detailsupdate()
    {
        dref = FirebaseDatabase.getInstance().getReference();
        String ref = dref.push().getKey();
        FirebaseUser user = mAuth.getCurrentUser();
        assert user!=null;
        String uid = user.getUid();
        if(wed.isChecked())
        {
            if(cat.isChecked()) {
                dref.child("events").child("wedding").child(ref).child("uid").setValue(uid);
                dref.child("events").child("wedding").child(ref).child("cat").setValue("caterer");
            }
            if(dec.isChecked())
            {
                dref.child("events").child("wedding").child(ref).child("uid").setValue(uid);
                dref.child("events").child("wedding").child(ref).child("cat").setValue("decorator");
            }
            if(vid.isChecked())
            {
                dref.child("events").child("wedding").child(ref).child("uid").setValue(uid);
                dref.child("events").child("wedding").child(ref).child("cat").setValue("videographer");
            }
            if(par.isChecked())
            {
                dref.child("events").child("wedding").child(ref).child("uid").setValue(uid);
                dref.child("events").child("wedding").child(ref).child("cat").setValue("party");
            }
            if(eve.isChecked())
            {
                dref.child("events").child("wedding").child(ref).child("uid").setValue(uid);
                dref.child("events").child("wedding").child(ref).child("cat").setValue("eventplanner");
            }
            if(mus.isChecked())
            {
                dref.child("events").child("wedding").child(ref).child("uid").setValue(uid);
                dref.child("events").child("wedding").child(ref).child("cat").setValue("musicians");
            }
        }
        if(bir.isChecked())
        {
            if(cat.isChecked()) {
                dref.child("events").child("birthday").child(ref).child("uid").setValue(uid);
                dref.child("events").child("birthday").child(ref).child("cat").setValue("caterer");
            }
            if(dec.isChecked())
            {
                dref.child("events").child("birthday").child(ref).child("uid").setValue(uid);
                dref.child("events").child("birthday").child(ref).child("cat").setValue("decorator");
            }
            if(vid.isChecked())
            {
                dref.child("events").child("birthday").child(ref).child("uid").setValue(uid);
                dref.child("events").child("birthday").child(ref).child("cat").setValue("videographer");
            }
            if(par.isChecked())
            {
                dref.child("events").child("birthday").child(ref).child("uid").setValue(uid);
                dref.child("events").child("birthday").child(ref).child("cat").setValue("party");
            }
            if(eve.isChecked())
            {
                dref.child("events").child("birthday").child(ref).child("uid").setValue(uid);
                dref.child("events").child("birthday").child(ref).child("cat").setValue("eventplanner");
            }
            if(mus.isChecked())
            {
                dref.child("events").child("birthday").child(ref).child("uid").setValue(uid);
                dref.child("events").child("birthday").child(ref).child("cat").setValue("musicians");
            }
        }
        if(fam.isChecked())
        {
            if(cat.isChecked()) {
                dref.child("events").child("family").child(ref).child("uid").setValue(uid);
                dref.child("events").child("family").child(ref).child("cat").setValue("caterer");
            }
            if(dec.isChecked())
            {
                dref.child("events").child("family").child(ref).child("uid").setValue(uid);
                dref.child("events").child("family").child(ref).child("cat").setValue("decorator");
            }
            if(vid.isChecked())
            {
                dref.child("events").child("family").child(ref).child("uid").setValue(uid);
                dref.child("events").child("family").child(ref).child("cat").setValue("videographer");
            }
            if(par.isChecked())
            {
                dref.child("events").child("family").child(ref).child("uid").setValue(uid);
                dref.child("events").child("family").child(ref).child("cat").setValue("party");
            }
            if(eve.isChecked())
            {
                dref.child("events").child("family").child(ref).child("uid").setValue(uid);
                dref.child("events").child("family").child(ref).child("cat").setValue("eventplanner");
            }
            if(mus.isChecked())
            {
                dref.child("events").child("family").child(ref).child("uid").setValue(uid);
                dref.child("events").child("family").child(ref).child("cat").setValue("musicians");
            }
        }
        if(press.isChecked())
        {
            if(cat.isChecked()) {
                dref.child("events").child("press").child(ref).child("uid").setValue(uid);
                dref.child("events").child("press").child(ref).child("cat").setValue("caterer");
            }
            if(dec.isChecked())
            {
                dref.child("events").child("press").child(ref).child("uid").setValue(uid);
                dref.child("events").child("press").child(ref).child("cat").setValue("decorator");
            }
            if(vid.isChecked())
            {
                dref.child("events").child("press").child(ref).child("uid").setValue(uid);
                dref.child("events").child("press").child(ref).child("cat").setValue("videographer");
            }
            if(par.isChecked())
            {
                dref.child("events").child("press").child(ref).child("uid").setValue(uid);
                dref.child("events").child("press").child(ref).child("cat").setValue("party");
            }
            if(eve.isChecked())
            {
                dref.child("events").child("press").child(ref).child("uid").setValue(uid);
                dref.child("events").child("press").child(ref).child("cat").setValue("eventplanner");
            }
            if(mus.isChecked())
            {
                dref.child("events").child("press").child(ref).child("uid").setValue(uid);
                dref.child("events").child("press").child(ref).child("cat").setValue("musicians");
            }
        }
        if(sem.isChecked())
        {
            if(cat.isChecked()) {
                dref.child("events").child("seminar").child(ref).child("uid").setValue(uid);
                dref.child("events").child("seminar").child(ref).child("cat").setValue("caterer");
            }
            if(dec.isChecked())
            {
                dref.child("events").child("seminar").child(ref).child("uid").setValue(uid);
                dref.child("events").child("seminar").child(ref).child("cat").setValue("decorator");
            }
            if(vid.isChecked())
            {
                dref.child("events").child("seminar").child(ref).child("uid").setValue(uid);
                dref.child("events").child("seminar").child(ref).child("cat").setValue("videographer");
            }
            if(par.isChecked())
            {
                dref.child("events").child("seminar").child(ref).child("uid").setValue(uid);
                dref.child("events").child("seminar").child(ref).child("cat").setValue("party");
            }
            if(eve.isChecked())
            {
                dref.child("events").child("seminar").child(ref).child("uid").setValue(uid);
                dref.child("events").child("seminar").child(ref).child("cat").setValue("eventplanner");
            }
            if(mus.isChecked())
            {
                dref.child("events").child("seminar").child(ref).child("uid").setValue(uid);
                dref.child("events").child("seminar").child(ref).child("cat").setValue("musicians");
            }
        }
        if(team.isChecked())
        {
            if(cat.isChecked()) {
                dref.child("events").child("teambuild").child(ref).child("uid").setValue(uid);
                dref.child("events").child("teambuild").child(ref).child("cat").setValue("caterer");
            }
            if(dec.isChecked())
            {
                dref.child("events").child("teambuild").child(ref).child("uid").setValue(uid);
                dref.child("events").child("teambuild").child(ref).child("cat").setValue("decorator");
            }
            if(vid.isChecked())
            {
                dref.child("events").child("teambuild").child(ref).child("uid").setValue(uid);
                dref.child("events").child("teambuild").child(ref).child("cat").setValue("videographer");
            }
            if(par.isChecked())
            {
                dref.child("events").child("teambuild").child(ref).child("uid").setValue(uid);
                dref.child("events").child("teambuild").child(ref).child("cat").setValue("party");
            }
            if(eve.isChecked())
            {
                dref.child("events").child("teambuild").child(ref).child("uid").setValue(uid);
                dref.child("events").child("teambuild").child(ref).child("cat").setValue("eventplanner");
            }
            if(mus.isChecked())
            {
                dref.child("events").child("teambuild").child(ref).child("uid").setValue(uid);
                dref.child("events").child("teambuild").child(ref).child("cat").setValue("musicians");
            }
        }
    }
}
