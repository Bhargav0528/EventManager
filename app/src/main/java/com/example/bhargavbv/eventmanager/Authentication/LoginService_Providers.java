package com.example.bhargavbv.eventmanager.Authentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bhargavbv.eventmanager.MainActivity;
import com.example.bhargavbv.eventmanager.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginService_Providers extends AppCompatActivity {

    private Button btLogin,btRegister;
    private TextView tvRegister;
    private TextView changepass;
    private EditText etEmail;
    private  EditText etPassword;

    private DatabaseReference ref;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressBar pb;

    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        /*if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(LoginService_Providers.this, MainActivity.class));
            finish();
        }*/
        setContentView(R.layout.activity_login_service__providers);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        btLogin = (Button) findViewById(R.id.btLogin);
        etEmail = (EditText) findViewById(R.id.etlogin);
        etPassword = (EditText) findViewById(R.id.etpassword);
        pb = (ProgressBar)findViewById(R.id.pb);
        btRegister = (Button)findViewById(R.id.tvregister);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authenticate();
            }
        });
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                register();

            }
        });
    }

    public void register(){
        final String email = etEmail.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)||TextUtils.isEmpty(password)) {
            Toast.makeText(LoginService_Providers.this, "Please Enter all the fields", Toast.LENGTH_SHORT).show();
        }
        else {

            pb.setVisibility(View.VISIBLE);

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                            pb.setVisibility(View.GONE);
                            if (!task.isSuccessful()) {
                                if (password.length() < 6) {
                                    Toast.makeText(LoginService_Providers.this, "Password is too short", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(LoginService_Providers.this, "Authentication failed, check your email and password or sign up", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                ref = FirebaseDatabase.getInstance().getReference();
                                FirebaseUser user = mAuth.getCurrentUser();



                                if(user != null) {
                                    String uid = user.getUid();
                                    ref.child("serviceProviders").child(uid).child("Email").setValue(email);

                                }
                                startActivity(new Intent(LoginService_Providers.this, ServiceProvidersInfo.class));
                                finish();

                            }
                        }
                    });
        }
    }

    public void authenticate(){

        String email = etEmail.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(LoginService_Providers.this,"Please enter your Email",Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(LoginService_Providers.this,"Please enter your Password",Toast.LENGTH_SHORT).show();
        }

        pb.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        pb.setVisibility(View.GONE);

                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                etPassword.setError("Password too short, enter minimum 6 characters!");
                            } else {
                                Toast.makeText(LoginService_Providers.this, "Authentication failed, check your email and password or sign up", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Intent intent = new Intent(LoginService_Providers.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }


                    }
                });
    }



    @Override
    public void onStart () {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop () {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    @Override
    protected void onResume () {
        super.onResume();
        pb.setVisibility(View.GONE);
    }

}
