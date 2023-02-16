package com.studies.os;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.fonts.FontStyle;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridLayout g;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    Switch s;

    public void fcfs(View view){
        if(!s.isChecked()){
            Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(),I_FCFS.class);
            startActivity(intent);
        }
    }

    public void sjf(View view){
        if(!s.isChecked()) {
            Intent intent = new Intent(getApplicationContext(), SJF.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(),I_SJF.class);
            startActivity(intent);
        }
    }
    public void rr(View view){
        if(!s.isChecked()) {
            Intent intent = new Intent(getApplicationContext(), RR.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(),I_RR.class);
            startActivity(intent);
        }
    }
    public void ps(View view){
        if(!s.isChecked()) {
            Intent intent = new Intent(getApplicationContext(), Priority.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(),I_Priority.class);
            startActivity(intent);
        }
    }
    public void ljf(View view){
        if(!s.isChecked()) {
            Intent intent = new Intent(getApplicationContext(), LJF.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(),I_LJF.class);
            startActivity(intent);
        }
    }
    public void srtf(View view){
        if(!s.isChecked()) {
            Intent intent = new Intent(getApplicationContext(), SRTF.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(),I_SRTF.class);
            startActivity(intent);
        }
    }
    public void pps(View view){
        if(!s.isChecked()) {
            Intent intent = new Intent(getApplicationContext(), PPriority.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(),I_PPriority.class);
            startActivity(intent);
        }
    }
    public void lrtf(View view){
        if(!s.isChecked()) {
            Intent intent = new Intent(getApplicationContext(), LRTF.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(),I_LRTF.class);
            startActivity(intent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);
        t5 = findViewById(R.id.textView5);
        t6 = findViewById(R.id.textView6);
        t7 = findViewById(R.id.textView7);
        t8 = findViewById(R.id.textView8);
        s = findViewById(R.id.switch1);

        g= findViewById(R.id.gridLayout);





    }
}