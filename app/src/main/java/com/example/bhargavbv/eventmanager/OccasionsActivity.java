package com.example.bhargavbv.eventmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OccasionsActivity extends AppCompatActivity {

    private ImageView wed;
    private ImageView bday;
    private ImageView fam;
    private ImageView sem;
    private ImageView press;
    private ImageView team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occasions);

        wed = (ImageView)findViewById(R.id.wedding);
        bday = (ImageView)findViewById(R.id.birthday);
        fam = (ImageView)findViewById(R.id.famevent);
        sem = (ImageView)findViewById(R.id.seminar);
        press = (ImageView)findViewById(R.id.presscon);
        team = (ImageView)findViewById(R.id.teambuild);

        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OccasionsActivity.this, ComboProvidersActivity.class);
                i.putExtra("key", 1); //Optional parameters
                startActivity(i);
            }
        });

        bday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OccasionsActivity.this, ComboProvidersActivity.class);
                i.putExtra("key", 2); //Optional parameters
                startActivity(i);
            }
        });

        fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OccasionsActivity.this, ComboProvidersActivity.class);
                i.putExtra("key", 3); //Optional parameters
                startActivity(i);
            }
        });

        sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OccasionsActivity.this, ComboProvidersActivity.class);
                i.putExtra("key", 4); //Optional parameters
                startActivity(i);
            }
        });

        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OccasionsActivity.this, ComboProvidersActivity.class);
                i.putExtra("key", 5); //Optional parameters
                startActivity(i);
            }
        });

        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OccasionsActivity.this, ComboProvidersActivity.class);
                i.putExtra("key", 6); //Optional parameters
                startActivity(i);
            }
        });

        /*custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OccasionsActivity.this, ComboProvidersActivity.class);
                i.putExtra("key", 7); //Optional parameters
                startActivity(i);
            }
        });*/
    }
}
