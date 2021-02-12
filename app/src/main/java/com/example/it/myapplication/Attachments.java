package com.example.it.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Attachments extends AppCompatActivity {
    String cno;
    String pstation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attachments);
        Intent in = getIntent();
        cno=in.getStringExtra("cno");
        pstation=in.getStringExtra("pstation");
        final Button button=(Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClass(getApplicationContext(),GetCurrentGPSLocation.class);
                startActivity(i);
            }
        });


        Button sd=(Button)findViewById(R.id.button14);
        sd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.putExtra("cno",cno);
                i.putExtra("pstation",pstation);
                i.setClass(getApplicationContext(),VideoImage.class);
                startActivity(i);
            }
        });

        Button sd1=(Button)findViewById(R.id.button15);
        sd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.putExtra("cno",cno);
                i.putExtra("pstation",pstation);
                i.setClass(getApplicationContext(),UploadFiles.class);
                startActivity(i);
            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_attachments, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
