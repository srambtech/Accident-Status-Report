package com.example.it.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Preview extends AppCompatActivity {


    String district;
    String rto;
    String cno;
    String pstation;
    String location;
    String date;
    String time;
    String sub;




    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView sdate;
    TextView stime;




    TextView accdate;
    InputStream is;
    String result;
    String line;
    int code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        Intent in = getIntent();
        district=in.getStringExtra("dis");
        rto=in.getStringExtra("rto");
        cno=in.getStringExtra("cno");
        pstation=in.getStringExtra("pstation");
        location=in.getStringExtra("loc");
        date=in.getStringExtra("dat");
        time=in.getStringExtra("time");
        sub=in.getStringExtra("sub");




        tv1=(TextView)findViewById(R.id.dis);
         tv2=(TextView)findViewById(R.id.rto);
        tv6=(TextView)findViewById(R.id.cno);
        tv5=(TextView)findViewById(R.id.pst);
        tv3=(TextView)findViewById(R.id.loc);
        sdate=(TextView)findViewById(R.id.sdate);
        stime=(TextView)findViewById(R.id.stime);
        tv4=(TextView)findViewById(R.id.sub);
//Button m=(Button)findViewById(R.id.button4);








                tv1.setText(district);
                tv2.setText(rto);
                tv6.setText(cno);
                tv5.setText(pstation);
                tv3.setText(location);
                sdate.setText(date);
                stime.setText(time);
                tv4.setText(sub);






Button s=(Button)findViewById(R.id.submit);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
                //insert1();
                //insert2();
                Intent intent=new Intent();
                intent.setClass(getApplicationContext(),Attachments.class);
                intent.putExtra("cno", cno);
                intent.putExtra("pstation",pstation);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preview, menu);
        return true;
    }
    public void insert()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {

                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://asr.mkce.ac.in/final.php");

                nameValuePairs.add(new BasicNameValuePair("district",district));
                nameValuePairs.add(new BasicNameValuePair("rto",rto));
                nameValuePairs.add(new BasicNameValuePair("cno",cno));
                nameValuePairs.add(new BasicNameValuePair("pstation",pstation));
                nameValuePairs.add(new BasicNameValuePair("location",location));
                nameValuePairs.add(new BasicNameValuePair("sdate",date));
                nameValuePairs.add(new BasicNameValuePair("subti",time));
                nameValuePairs.add(new BasicNameValuePair("sub",sub));





                try
                {

                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();
                    Log.e("pass 1", "connection success ");
                }
                catch(Exception e)
                {
                    Log.e("Fail 1", e.toString());
                    Toast.makeText(getApplicationContext(), "Invalid IP Address",
                            Toast.LENGTH_LONG).show();
                }
            }

        }).start();
        try
        {
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");

            }
            is.close();
            result = sb.toString().substring(0,sb.toString().length()-1);
            Log.e("pass 2", "connection success ");
        }
        catch(Exception e)
        {
            Log.e("Fail 2", e.toString());
        }

        try
        {
            JSONArray json_data = new JSONArray(result);
            code=(json_data.getInt(Integer.parseInt("code")));

            if(code==1)
            {
                Toast.makeText(getBaseContext(), "Inserted Successfully",
                        Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getBaseContext(), "Sorry, Try Again",
                        Toast.LENGTH_LONG).show();
            }
        }
        catch(Exception e)
        {
            Log.e("Fail 3", e.toString());
            Toast.makeText(getBaseContext(), "Inserted Successfully",
                    Toast.LENGTH_SHORT).show();
        }
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
