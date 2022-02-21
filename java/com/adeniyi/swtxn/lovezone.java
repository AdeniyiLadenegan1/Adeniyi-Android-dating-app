package com.adeniyi.swtxn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class lovezone extends AppCompatActivity {
TextView myText;
Button buzzer;
EditText edit;
    private DatabaseReference myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovezone);

        myDatabase = FirebaseDatabase.getInstance().getReference("Message");

       myText = findViewById(R.id.msgBox);
        myDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                myText.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                myText.setText("DELETED");
            }
        });
    }
    public void send(View view) {
        edit = findViewById(R.id.editor);

        myDatabase.setValue(edit.getText().toString());
        edit.setText("");


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
                Intent lovezone = new Intent(this, lovezone.class);
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

    public void toProfile (View v){
        Intent next = new Intent(this, profile.class);
        startActivity(next);
    }
}
