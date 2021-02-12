package com.example.it.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ViewImages extends AppCompatActivity {
    String cno;
    private EditText editTextId;
    private Button buttonGetImage;
    private ImageView imageView;

    private RequestHandler requestHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView  (R.layout.activity_view_images);
        Intent in=getIntent();
        cno=in.getStringExtra("cno");
        // editTextId = (EditText) findViewById(R.id.editTextId);
        //  buttonGetImage = (Button) findViewById(R.id.buttonGetImage);
        imageView = (ImageView) findViewById(R.id.imageViewShow);

        requestHandler = new RequestHandler();

        getImage();
    }


    private void getImage() {
        String id = cno;
        class GetImage extends AsyncTask<String,Void,Bitmap>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewImages.this, "Picture loading...", null,true,true);
            }

            @Override
            protected void onPostExecute(Bitmap b) {
                super.onPostExecute(b);
                loading.dismiss();
                imageView.setImageBitmap(b);
            }

            @Override
            protected Bitmap doInBackground(String... params) {
                String id = params[0];

                String add = "http://asr.mkce.ac.in/getImage.php?id="+id;
                URL url = null;
                Bitmap image = null;
                try {
                    url = new URL(add);
                    image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return image;
            }
        }

        GetImage gi = new GetImage();
        gi.execute(id);
    }


}