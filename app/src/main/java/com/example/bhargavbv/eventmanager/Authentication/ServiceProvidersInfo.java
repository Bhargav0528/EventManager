package com.example.bhargavbv.eventmanager.Authentication;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bhargavbv.eventmanager.MainActivity;
import com.example.bhargavbv.eventmanager.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class ServiceProvidersInfo extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private StorageReference sref;
    private DatabaseReference dref;
    private static final int PICK_IMAGE = 100;
    ImageView imageView;
    boolean selected =  false;
    Uri imageUri;

    Button submit;

    EditText compname,descp,services,location,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_providers_info);

        mAuth = FirebaseAuth.getInstance();

        imageView = (ImageView) findViewById(R.id.imgview);
        sref = FirebaseStorage.getInstance().getReference();
        dref = FirebaseDatabase.getInstance().getReference();
        submit = (Button)findViewById(R.id.submit);

        compname = (EditText)findViewById(R.id.compname);
        descp = (EditText)findViewById(R.id.compdescp);
        services = (EditText)findViewById(R.id.servc);
        location = (EditText)findViewById(R.id.loc);
        contact = (EditText)findViewById(R.id.contact);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
                uploadphoto();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailsupdate();
                startActivity(new Intent(ServiceProvidersInfo.this, MainActivity.class));
            }
        });

    }







    public String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }


    public void uploadphoto(){
        if(selected)
        {

            Log.i("Hello",imageUri.toString());
            sref.child("dp").child(System.currentTimeMillis() + "." + getFileExtension(imageUri)).putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    FirebaseUser user = mAuth.getCurrentUser();
                    assert user!=null;
                    String uid = user.getUid();
                    dref.child("serviceProviders").child(uid).child("photo").setValue(taskSnapshot.getDownloadUrl().toString());
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                            //show progress
                            double progress = (100 * taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();


                        }
                    });
        }
    }

    public void detailsupdate(){
        FirebaseUser user = mAuth.getCurrentUser();
        assert user!=null;
        String uid = user.getUid();
        dref.child("serviceProviders").child(uid).child("photo").setValue(imageUri);
        dref.child("serviceProviders").child(uid).child("companyName").setValue(compname.getText().toString());
        dref.child("serviceProviders").child(uid).child("description").setValue(descp.getText().toString());
        dref.child("serviceProviders").child(uid).child("services").setValue(services.getText().toString());
        dref.child("serviceProviders").child(uid).child("location").setValue(location.getText().toString());
        dref.child("serviceProviders").child(uid).child("contact").setValue(contact.getText().toString());
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        gallery.setType("image/*");
        startActivityForResult(gallery,PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            imageView.setImageURI(null);
            imageView.setImageURI(imageUri);
            selected = true;
        }
    }
}
