package com.example.it.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UploadImages extends Activity implements OnClickListener {
    String realPath;
    TextView txtSDK;
    Button btnSelectImage;
    TextView txtUriPath,txtRealPath;
    ImageView imageView;
    String cno;
    String pstation;
    String url;
    String itype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_images);
        Intent in=getIntent();
        cno=in.getStringExtra("cno");
        pstation=in.getStringExtra("pstation");
        url=in.getStringExtra("cno");
        pstation=in.getStringExtra("pstation");
        // get reference to views
        txtSDK = (TextView) findViewById(R.id.txtSDK);
        btnSelectImage = (Button) findViewById(R.id.btnSelectImage);
        txtUriPath = (TextView) findViewById(R.id.txtUriPath);
        txtRealPath = (TextView) findViewById(R.id.txtRealPath);
        imageView = (ImageView) findViewById(R.id.imgView);

        // add click listener to button
        btnSelectImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // 1. on Upload click call ACTION_GET_CONTENT intent
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        // 2. pick image only
        intent.setType("image/*");
        // 3. start activity
        startActivityForResult(intent, 0);

        // define onActivityResult to do something with picked image
    }


    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        if(resCode == Activity.RESULT_OK && data != null){

            // SDK < API11
            if (Build.VERSION.SDK_INT < 11)
                realPath = RealPathUtil.getRealPathFromURI_BelowAPI11(this, data.getData());

                // SDK >= 11 && SDK < 19
            else if (Build.VERSION.SDK_INT < 19)
                realPath = RealPathUtil.getRealPathFromURI_API11to18(this, data.getData());

                // SDK > 19 (Android 4.4)
            else
                realPath = RealPathUtil.getRealPathFromURI_API19(this, data.getData());

            launchUploadActivity(true);
        }
    }private void launchUploadActivity(boolean isImage){
        Intent i = new Intent(UploadImages.this, UploadActivity.class);
        i.putExtra("filePath", realPath);
        i.putExtra("isImage", isImage);
        i.putExtra("cno",cno);
        i.putExtra("pstation",pstation);
        i.putExtra("url",url);
        i.putExtra("itype",itype);
        startActivity(i);
    }



}