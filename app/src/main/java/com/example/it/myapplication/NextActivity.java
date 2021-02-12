package com.example.it.myapplication;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class NextActivity extends Activity implements AdapterView.OnItemSelectedListener,SimpleGestureFilter.SimpleGestureListener{
    Spinner spinner, spinner2;
    String district;
    String rto;
    String location;
    String pstation;
    String cno;


    String date;
    String fatal;

    private SimpleGestureFilter detector;
    private EditText mDateDisplay;
    private Button mPickDate;
    EditText loc;
    String time;
    EditText sub;
    EditText e;
    EditText c_no;

    private int mYear;
    private int mMonth;
    private int mDay;

    private EditText mTimeDisplay;
    private Button mPickTime;

    private int mHour;
    private int mMinute;

    static final int DATE_DIALOG_ID = 0;

    static final int TIME_DIALOG_ID = 2;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.optionsmenu, menu);
        return true;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        // capture our View elements
        detector = new SimpleGestureFilter(this,this);
        mDateDisplay = (EditText) findViewById(R.id.dateDisplay);
        mPickDate = (Button) findViewById(R.id.pickDate);
        e=(EditText)findViewById(R.id.editText9);
        c_no=(EditText)findViewById(R.id.editText10);

        mTimeDisplay = (EditText) findViewById(R.id.timeDisplay);
        mPickTime = (Button) findViewById(R.id.pickTime);
        loc=(EditText)findViewById(R.id.loc);
        sub = (EditText) findViewById(R.id.sub);
        spinner = (Spinner) findViewById(R.id.spinner2);
        spinner2=(Spinner)  findViewById(R.id.spinner3);
        spinner2.setOnItemSelectedListener(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                district=spinner.getItemAtPosition(position).toString();
                parent.getItemAtPosition(position);
                if(position==0)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.ari,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }

                else if(position==1)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.cbe,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==2)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.krr,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==3)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.mri,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==4)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.slm,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==5)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.ty,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==6)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.pera,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==7)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.than,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==8)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.thir,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==9)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.naga,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==10)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.pudu,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==11)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.tuti,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==12)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.tiru,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==13)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.kany,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==14)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.virud,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==15)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.siva,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==16)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.rama,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
                else if(position==17)
                {
                    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getBaseContext(),R.array.vill,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rto = spinner2.getItemAtPosition(position).toString();
                parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // add a click listener to the select a date button
        mPickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        // add a click listener to the select a calendar date button





        // add a click listener to the button
        mPickTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });




        // get the current date and time
        final Calendar c = Calendar.getInstance();
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mMonth = c.get(Calendar.MONTH);
        mYear = c.get(Calendar.YEAR);
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // display the current date
        displayDate();


        // display the current time
        displayTime();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent me){
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }

    // updates the date in the EditText
    private void displayDate() {
        mDateDisplay.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mYear).append("-")
                        .append(mMonth + 1).append("-")

                        .append(mDay).append(" "));
    }

    // updates the date in the EditText


    // updates the time we display in the EditText
    private void displayTime() {
        mTimeDisplay.setText(
                new StringBuilder()
                        .append(pad(mHour)).append(":")
                        .append(pad(mMinute)));
    }

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    // the callback received when the user "sets" the date in the dialog
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    displayDate();
                }
            };

    // the callback received when the user "sets" the time in the dialog
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    mHour = hourOfDay;
                    mMinute = minute;
                    displayTime();
                }
            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this,
                        mTimeSetListener, mHour, mMinute, false);

        }
        return null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }






    @Override
    public void onSwipe(int direction) {
        String str = "";

        switch (direction) {


            case SimpleGestureFilter.SWIPE_LEFT :
                location=loc.getText().toString();
                time=mTimeDisplay.getText().toString();
                fatal=sub.getText().toString();
                pstation=e.getText().toString();
                cno=c_no.getText().toString();
                date=mDateDisplay.getText().toString();
                Intent in=new Intent();
                in.setClass(getApplicationContext(),Preview.class);
                in.putExtra("loc", location);
                in.putExtra("rto",rto);
                in.putExtra("dis",district);
                in.putExtra("pstation",pstation);
                in.putExtra("dat",date);
                in.putExtra("sub",fatal);
                in.putExtra("cno",cno);
                in.putExtra("time",time);
                startActivity(in);
                break;


        }


    }


    @Override
    public void onDoubleTap() {

    }
}