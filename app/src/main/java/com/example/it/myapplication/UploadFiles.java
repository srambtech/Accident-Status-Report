package com.example.it.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class UploadFiles extends AppCompatActivity {
    String cno;
    String pstation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_files);



        Intent in=getIntent();
        cno=in.getStringExtra("cno");
        pstation=in.getStringExtra("pstation");
        Button s=(Button)findViewById(R.id.button16);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClass(getApplicationContext(),UploadImages.class);
                i.putExtra("cno", cno);
                i.putExtra("pstation",pstation);
                startActivity(i);
            }
        });
        Button g=(Button)findViewById(R.id.button10);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(getApplicationContext(), UploadGPS.class);
                i.putExtra("cno", cno);
                i.putExtra("pstation",pstation);
                startActivity(i);
            }
        });
        Button a=(Button)findViewById(R.id.button17);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(getApplicationContext(), UploadVideo.class);
                i.putExtra("cno", cno);
                i.putExtra("pstation",pstation);
                startActivity(i);
            }
        });

        Button l=(Button)findViewById(R.id.button11);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setClass(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_upload_files, menu);
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
