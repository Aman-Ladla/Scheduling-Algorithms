package com.studies.os;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.gridlayout.widget.GridLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.studies.os.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;

public class Tabbed extends AppCompatActivity {

    SectionPageAdapter sectionPageAdapter;

    ArrayList<String> tarray = new ArrayList<>();
    ArrayList<Integer> earray = new ArrayList<>();
    ArrayList<Integer> aarray = new ArrayList<>();
    ArrayList<Integer> all_times = new ArrayList<>();
    ArrayList<Integer> basic = new ArrayList<>();
    ArrayList<Integer> ids = new ArrayList<>();
    ArrayList<Integer> carray = new ArrayList<>();
    ArrayList<Integer> tatarray = new ArrayList<>();
    ArrayList<Integer> wtarray = new ArrayList<>();
    ArrayList<Integer> taba = new ArrayList<>();
    ArrayList<Integer> tabe = new ArrayList<>();

    ArrayList<Integer> IOI = new ArrayList<>();
    ArrayList<Integer> IOF = new ArrayList<>();
    ArrayList<String> IOT = new ArrayList<>();
    ArrayList<String> text = new ArrayList<>();
    TextView[] textViews;
    GridLayout g;
    TextView t;
    static int time=-1;
    TextView t0,t1;
    int k=0;
    int size=0;
    int b=0;
    int total=0;
    int counter;
    int table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
       // SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager(viewPager);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        setTitle("Results");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        BlankFragment1 fragment1 = new BlankFragment1();

        Intent intent = getIntent();
        tarray = intent.getStringArrayListExtra("PN");
        earray = intent.getIntegerArrayListExtra("BT");
        aarray = intent.getIntegerArrayListExtra("AT");
        ids = intent.getIntegerArrayListExtra("id");
        taba = intent.getIntegerArrayListExtra("taba");
        tabe = intent.getIntegerArrayListExtra("tabe");
        Log.i("PN",intent.getStringArrayListExtra("PN").toString());

        try{
            IOI = intent.getIntegerArrayListExtra("IOI");
            IOF = intent.getIntegerArrayListExtra("IOF");
            IOT = intent.getStringArrayListExtra("IOT");
            counter = intent.getIntExtra("process",0);
            table = intent.getIntExtra("table",0);
            carray = intent.getIntegerArrayListExtra("carray");
        }catch (Exception ignored){

        }

    }

    public Bundle Data(){
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList("id", ids);
        bundle.putStringArrayList("PN", tarray);
        bundle.putIntegerArrayList("BT", earray);
        bundle.putIntegerArrayList("AT",aarray);
        bundle.putIntegerArrayList("taba",taba);
        bundle.putIntegerArrayList("tabe",tabe);


        try{
            bundle.putIntegerArrayList("IOI",IOI);
            bundle.putIntegerArrayList("IOF",IOF);
            bundle.putStringArrayList("IOT",IOT);
            bundle.putInt("process",counter);
            bundle.putInt("table",table);
            bundle.putIntegerArrayList("carray",carray);
        }catch (Exception ignored){

        }

       // fragment1.setArguments(bundle);
        return bundle;
    }

   /* public Bundle Data1(){
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList("id", ids);
        bundle.putStringArrayList("PN", tarray);
        bundle.putIntegerArrayList("BT", earray);
        bundle.putIntegerArrayList("AT",aarray);

        try{
            bundle.putIntegerArrayList("IOI",IOI);
            bundle.putIntegerArrayList("IOF",IOF);
            bundle.putStringArrayList("IOT",IOT);
            bundle.putInt("process",counter);
            bundle.putInt("table",table);
        }catch (Exception ignored){

        }

        // fragment1.setArguments(bundle);
        return bundle;
    }*/

    public void viewPager(ViewPager viewPager){
        SectionPageAdapter sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        sectionPageAdapter.addFragment(new BlankFragment1(),"Gantt chart");
        sectionPageAdapter.addFragment(new BlankFragment2(),"Summary Table");
        viewPager.setAdapter(sectionPageAdapter);
    }
}