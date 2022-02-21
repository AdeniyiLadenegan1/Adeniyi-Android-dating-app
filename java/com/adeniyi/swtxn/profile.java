package com.adeniyi.swtxn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.UUID;

public class profile extends AppCompatActivity {


    ImageView profilePic;
    TextView FullName;
    public Uri imageUri;
    FirebaseStorage storage;
    StorageReference storageReference;
    ActivityResultLauncher<Intent> activityResultLauncher;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        profilePic = findViewById(R.id.profilePic);
//        FullName = findViewById(R.id.FullName);
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData()!= null) {
                                imageUri = result.getData().getData();
                                profilePic.setImageURI(imageUri);
                                uploadPicture();
                            }

                });


        profilePic.setOnClickListener(view -> choosePicture());
    }

    public void choosePicture() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        activityResultLauncher.launch(intent);

    }

//                    @Override
//                    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//
//                        super.onActivityResult(requestCode, resultCode, data);
//                        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {

//                            imageUri = data.getData();
//                            profilePic.setImageURI(imageUri);
//                            uploadPicture();
//                        }
//                    }

                    private void uploadPicture() {

                        final ProgressDialog pb = new ProgressDialog(this);
                        pb.setTitle("Uploading in progress...");

                        pb.show();

                        final String randomKey = UUID.randomUUID().toString();
                        StorageReference riversRef = storageReference.child("images/" + randomKey);

                        riversRef.putFile(imageUri)
                                .addOnSuccessListener(taskSnapshot -> {
                                    // Get a URL to the uploaded content
//                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                                    pb.dismiss();
                                    Snackbar.make(findViewById(android.R.id.content), "Image Uploaded Successfully.", Snackbar.LENGTH_LONG).show();
                                })
                                .addOnFailureListener(exception -> {
                                    // Handle unsuccessful uploads
                                    pb.dismiss();
                                    Toast.makeText(getApplicationContext(), "Failed to upload image, try again.", Toast.LENGTH_LONG).show();
                                }).addOnProgressListener(snapshot -> {
                                    double progressPercent = (100.00 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());

                                    pb.setMessage("Percentage: " + (int) progressPercent + "%");
                                });
                    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MainActivity:
                Intent mainActivity = new Intent(this, MainActivity.class);
                startActivity(mainActivity);
                return true;


            case R.id.welcome:
                Intent welcome = new Intent(this, welcome.class);
                startActivity(welcome);
                return true;

            case R.id.people:
                Intent people = new Intent(this, people.class);
                startActivity(people);
                return true;


            case R.id.lovezone:
                Intent lovezone = new Intent(this,  lovezone.class);
                startActivity(lovezone);
                return true;

            case R.id.sites:
                Intent sites = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/na_Mr2h50Ws"));
                startActivity(sites);
                return true;

            case R.id.profile:
                Intent profile = new Intent(this, profile.class);
                startActivity(profile);
                return true;


            default:
                return super.onContextItemSelected(item);
        }

    }

    public void toLove (View v){
        Intent next = new Intent(this, lovezone.class);
        startActivity(next);
    }

    public void toWelcome (View v){
        Intent next = new Intent(this, welcome.class);
        startActivity(next);
    }


}







