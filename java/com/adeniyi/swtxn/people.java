package com.adeniyi.swtxn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class people extends AppCompatActivity {
    ImageButton sdmail, usdmail, shopip, picgo;
    TextView mailstxt, fwtxt;
    ImageView hk1, hk2, hk3, hk4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        sdmail = findViewById(R.id.sendmail);
        usdmail = findViewById(R.id.unsndmail);
        mailstxt = findViewById(R.id.mailtext);
        fwtxt = findViewById(R.id.textView4);
        shopip = findViewById(R.id.hookups);
        picgo = findViewById(R.id.hkgon);
        hk1 = findViewById(R.id.hkp1);
        hk2 = findViewById(R.id.hkp2);
        hk3 = findViewById(R.id.hkp3);
        hk4 = findViewById(R.id.hkp4);

    }

    public void mails(View v) {
        mailstxt.setVisibility(View.VISIBLE);
        sdmail.setVisibility(View.INVISIBLE);
        usdmail.setVisibility(View.VISIBLE);

        hk1.setVisibility(View.INVISIBLE);
        hk2.setVisibility(View.INVISIBLE);
        hk3.setVisibility(View.INVISIBLE);
        hk4.setVisibility(View.INVISIBLE);

        fwtxt.setVisibility(View.VISIBLE);
    }

    public void rmvtxt1(View v) {
        mailstxt.setVisibility(View.INVISIBLE);
        sdmail.setVisibility(View.VISIBLE);
        usdmail.setVisibility(View.INVISIBLE);

        hk1.setVisibility(View.INVISIBLE);
        hk2.setVisibility(View.INVISIBLE);
        hk3.setVisibility(View.INVISIBLE);
        hk4.setVisibility(View.INVISIBLE);

        fwtxt.setVisibility(View.INVISIBLE);

    }


    public void pipsho(View v) {
        hk1.setVisibility(View.VISIBLE);
        hk2.setVisibility(View.VISIBLE);
        hk3.setVisibility(View.VISIBLE);
        hk4.setVisibility(View.VISIBLE);
        shopip.setVisibility(View.INVISIBLE);
        picgo.setVisibility(View.VISIBLE);
        mailstxt.setVisibility(View.INVISIBLE);

        fwtxt.setVisibility(View.INVISIBLE);
    }

    public void rmvhks(View v) {
        hk1.setVisibility(View.INVISIBLE);
        hk2.setVisibility(View.INVISIBLE);
        hk3.setVisibility(View.INVISIBLE);
        hk4.setVisibility(View.INVISIBLE);
        shopip.setVisibility(View.VISIBLE);
        picgo.setVisibility(View.INVISIBLE);

        fwtxt.setVisibility(View.INVISIBLE);
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
    public void firstP (View v){
        Intent next = new Intent(this, profile.class);
        startActivity(next);
    }
}




