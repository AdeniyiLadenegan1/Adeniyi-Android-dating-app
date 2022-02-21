package com.adeniyi.swtxn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class sites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites);
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

            default:
                return super.onContextItemSelected(item);
        }
    }
}
