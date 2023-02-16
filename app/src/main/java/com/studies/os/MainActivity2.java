package com.studies.os;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
    GridLayout g;
    static int i=10;
    int c=0;
    int d=0;
    int f=0;

    TextView t;
    EditText e;
    static int row;
    TextView[][] textView;
    EditText[][] editText;
    ArrayList<String> tarray = new ArrayList<>();
    ArrayList<Integer> earray = new ArrayList<>();
    ArrayList<Integer> aarray = new ArrayList<>();
    ArrayList<Integer> ids = new ArrayList<>();
    TextView[] textView1;

    public void remove(View view){
        if(row>=3) {
            textView[row - 2][0].setVisibility(View.GONE);
            editText[row - 2][0].setVisibility(View.GONE);
            editText[row - 2][1].setVisibility(View.GONE);
        //    textView[row - 2][1].setVisibility(View.GONE);
            row--;
        }
        else{
            Toast.makeText(this, "At least one Process required", Toast.LENGTH_SHORT).show();
        }
    }

    public void animate(View view){

        tarray.clear();
        earray.clear();
        aarray.clear();
        ids.clear();
        f=0;

        TextView t0 = findViewById(R.id.textView6);
        EditText e0 = findViewById(R.id.editText23);
        EditText e1 = findViewById(R.id.editText22);
        e0.setTag("0");

        tarray.add(String.valueOf(t0.getText()));
        if(!String.valueOf(e0.getText()).equals("") &&  !String.valueOf(e1.getText()).equals("")) {
            c=0;
            earray.add(Integer.valueOf(String.valueOf(e0.getText())));
            aarray.add(Integer.valueOf(String.valueOf(e1.getText())));
            ids.add(Integer.valueOf(String.valueOf(e0.getTag())));
            if(Integer.parseInt(String.valueOf(e0.getText()))==0){
                f=1;
                Toast.makeText(this, "Burst Time can't be 0", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            c=1;
            Toast.makeText(this, "Enter valid AT and BT", Toast.LENGTH_SHORT).show();
        }

        for(int j=1;j<row-1;j++){
            if(!String.valueOf((editText[j][1]).getText()).equals("") && !String.valueOf((editText[j][0]).getText()).equals("")) {
                d=0;
                aarray.add(Integer.valueOf(String.valueOf((editText[j][0]).getText())));
                tarray.add(textView[j][0].getText().toString());
                //tarray.add(textView[2].getText().toString());
                earray.add(Integer.valueOf(String.valueOf((editText[j][1]).getText())));
                ids.add(Integer.valueOf((String) textView[j][0].getTag()));
                //earray.add(Integer.valueOf(String.valueOf((editText[2][1]).getText())));
                if(Integer.parseInt(String.valueOf(editText[j][1].getText()))==0){
                    f=1;
                    Toast.makeText(this, "Burst Time can't be 0", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(this, "Enter valid AT and BT", Toast.LENGTH_SHORT).show();
                d=1;
                break;
            }
        }
        if(c==0 && d==0 && f==0) {
            Intent intent = new Intent(getApplicationContext(), Tabbed.class);
            ArrayList<Integer> taba = new ArrayList<>();
            ArrayList<Integer> tabe = new ArrayList<>();
            taba = (ArrayList<Integer>) aarray.clone();
            tabe = (ArrayList<Integer>) earray.clone();
            intent.putIntegerArrayListExtra("taba",taba);
            intent.putIntegerArrayListExtra("tabe",tabe);

            //Sorting Arrival
            for(int i=0;i<aarray.size();i++){
                for(int j=i+1;j<aarray.size();j++){
                    if(aarray.get(i)>aarray.get(j)){
                        int temp = aarray.get(i);
                        String temp1 = tarray.get(i);
                        int temp2 = earray.get(i);
                        int id = ids.get(i);
                        int temp3 = ids.get(i);
                        aarray.set(i,aarray.get(j));
                        tarray.set(i,tarray.get(j));
                        earray.set(i,earray.get(j));
                        ids.set(i,ids.get(j));
                        ids.set(i,ids.get(j));
                        aarray.set(j,temp);
                        tarray.set(j,temp1);
                        earray.set(j,temp2);
                        ids.set(j,id);
                        ids.set(j,temp3);
                    }
                }
            }

            //Sorting Arrival
            for(int i=1;i<aarray.size();i++) {
                for (int j = i + 1; j < aarray.size(); j++) {
                    if (aarray.get(i).equals(aarray.get(j))) {
                        if (ids.get(i)>ids.get(j)) {
                            int temp = aarray.get(i);
                            String temp1 = tarray.get(i);
                            int temp2 = earray.get(i);
                            int temp3 = ids.get(i);
                            aarray.set(i, aarray.get(j));
                            tarray.set(i, tarray.get(j));
                            earray.set(i, earray.get(j));
                            ids.set(i, ids.get(j));
                            aarray.set(j, temp);
                            tarray.set(j, temp1);
                            earray.set(j, temp2);
                            ids.set(j,temp3);
                        }
                    }
                }
            }
            Log.i("ids",ids.toString());

            int k=0;
            int total=0;
            ArrayList<Integer> carray = new ArrayList<>();
            for(int i=0; k<earray.size();i++){
                // t.setText(String.valueOf(earray.get(0)));
                if(i == aarray.get(k) || i>aarray.get(k)) {
                    total = total + earray.get(k);
                    carray.add(total);
                    Log.i("corresponding numbers",String.valueOf(total));
                    // thread[b] = new mythread(textViews[b],earray.get(k),textViews[b+30],animation);
                    i=i+earray.get(k)-1;
                    k++;
                }
                else{
                    total = total + aarray.get(k)-i;
                    Log.i("corresponding numbers",String.valueOf(total));
                    // thread[b] = new mythread(textViews[b],aarray.get(k)-i,textViews[b+30],animation);
                    i=aarray.get(k)-1;
                }
            }

            ArrayList<Integer> idd = (ArrayList<Integer>) ids.clone();

            for (int i = 0; i < ids.size(); i++) {
                for (int j = i + 1; j < ids.size(); j++) {
                    if (idd.get(i) > idd.get(j)) {
                        //String temp = tarray.get(i);
                        int temp1 = idd.get(i);
                        int temp2 = carray.get(i);
                       // int temp3 = aarray.get(i);
                       // int temp4 = earray.get(i);
                        //tarray.set(i, tarray.get(j));
                        idd.set(i, idd.get(j));
                        carray.set(i, carray.get(j));
                        //aarray.set(i, aarray.get(j));
                       // earray.set(i, earray.get(j));
                       // tarray.set(j, temp);
                        idd.set(j, temp1);
                        carray.set(j, temp2);
                        //aarray.set(j, temp3);
                       // earray.set(j, temp4);
                    }
                }
            }

        Log.i("carray in main",carray.toString());

            /*BlankFragment2 fragment1 = new BlankFragment2();
            Bundle bundle = new Bundle();
            bundle.putIntegerArrayList("id", ids);
            bundle.putStringArrayList("PN", tarray);
            bundle.putIntegerArrayList("BT", earray);
            bundle.putIntegerArrayList("AT",aarray);
            fragment1.setArguments(bundle);*/
            intent.putIntegerArrayListExtra("id", ids);
            intent.putStringArrayListExtra("PN", tarray);
            intent.putIntegerArrayListExtra("BT", earray);
            intent.putIntegerArrayListExtra("AT",aarray);
            intent.putExtra("process",row-1);
            intent.putExtra("table",0);
            intent.putIntegerArrayListExtra("carray",carray);
            startActivity(intent);
        }
    }




    @SuppressLint("SetTextI18n")
    public void add(View view){

       /*TextView t1= findViewById(R.id.textView0);
       EditText e0 = findViewById(R.id.editText0);
        TextView t = new TextView(getApplicationContext());
        t.setGravity(Gravity.CENTER);
        t.setLayoutParams(t1.getLayoutParams());
        t.setTypeface(Typeface.DEFAULT_BOLD);
        t.setTextSize(20);
        int k = i-9;
        t.setText("P"+k);
        g.addView(t);
        i++;

        EditText e1 = new EditText(getApplicationContext());
        e1.setGravity(Gravity.CENTER);
        e1.setInputType(InputType.TYPE_CLASS_NUMBER);
        e1.setLayoutParams(e0.getLayoutParams());
        e1.setTypeface(Typeface.DEFAULT_BOLD);
        e1.setTextSize(20);
        int j = i+10;
        g.addView(e1);
        i++;
*/
       if(row<10) {
           row++;
       }
       else{
           Toast.makeText(this, "Maximum 9 processes permitted", Toast.LENGTH_SHORT).show();
       }
        if(row==3){
            textView[1][0] = findViewById(R.id.textView31);
            editText[1][0] = findViewById(R.id.editText32);
            editText[1][1] = findViewById(R.id.editText33);
           // textView[1][1]= findViewById(R.id.editText34);
            textView[1][0].setVisibility(View.VISIBLE);
            editText[1][0].setVisibility(View.VISIBLE);
            editText[1][1].setVisibility(View.VISIBLE);
            //textView[1][1].setVisibility(View.VISIBLE);
            textView[1][0].setTag("1");
        }
        if(row==4){
            textView[2][0] = findViewById(R.id.textView41);
            editText[2][0] = findViewById(R.id.editText42);
            editText[2][1] = findViewById(R.id.editText43);
            //textView[2][1]= findViewById(R.id.editText44);
            textView[2][0].setVisibility(View.VISIBLE);
            editText[2][0].setVisibility(View.VISIBLE);
            editText[2][1].setVisibility(View.VISIBLE);
           // textView[2][1].setVisibility(View.VISIBLE);
            textView[2][0].setTag("2");
        }
        if(row==5){
            textView[3][0]= findViewById(R.id.textView51);
            editText[3][0] = findViewById(R.id.editText52);
            editText[3][1] = findViewById(R.id.editText53);
           // textView[3][1]= findViewById(R.id.editText54);
            textView[3][0].setVisibility(View.VISIBLE);
            editText[3][0].setVisibility(View.VISIBLE);
            editText[3][1].setVisibility(View.VISIBLE);
          //  textView[3][1].setVisibility(View.VISIBLE);
            textView[3][0].setTag("3");
        }
        if(row==6){
            textView[4][0] = findViewById(R.id.textView61);
            editText[4][0] = findViewById(R.id.editText62);
            editText[4][1] = findViewById(R.id.editText63);
           // textView[4][1]= findViewById(R.id.editText64);
            textView[4][0].setVisibility(View.VISIBLE);
            editText[4][0].setVisibility(View.VISIBLE);
            editText[4][1].setVisibility(View.VISIBLE);
           // textView[4][1].setVisibility(View.VISIBLE);
            textView[4][0].setTag("4");
        }
        if(row==7){
            textView[5][0] = findViewById(R.id.textView71);
            editText[5][0] = findViewById(R.id.editText72);
            editText[5][1] = findViewById(R.id.editText73);
           // textView[5][1]= findViewById(R.id.editText74);
            textView[5][0].setVisibility(View.VISIBLE);
            editText[5][0].setVisibility(View.VISIBLE);
            editText[5][1].setVisibility(View.VISIBLE);
          //  textView[5][1].setVisibility(View.VISIBLE);
            textView[5][0].setTag("5");
        }
        if(row==8){
            textView[6][0] = findViewById(R.id.textView81);
            editText[6][0] = findViewById(R.id.editText82);
            editText[6][1] = findViewById(R.id.editText83);
        //    textView[6][1]= findViewById(R.id.editText84);
            textView[6][0].setVisibility(View.VISIBLE);
            editText[6][0].setVisibility(View.VISIBLE);
            editText[6][1].setVisibility(View.VISIBLE);
          //  textView[6][1].setVisibility(View.VISIBLE);
            textView[6][0].setTag("6");
        }
        if(row==9){
            textView[7][0] = findViewById(R.id.textView91);
            editText[7][0] = findViewById(R.id.editText92);
            editText[7][1] = findViewById(R.id.editText93);
           // textView[7][1]= findViewById(R.id.editText94);
            textView[7][0].setVisibility(View.VISIBLE);
            editText[7][0].setVisibility(View.VISIBLE);
            editText[7][1].setVisibility(View.VISIBLE);
          //  textView[7][1].setVisibility(View.VISIBLE);
            textView[7][0].setTag("7");
        }
        if(row==10){
            textView[8][0] = findViewById(R.id.textView101);
            editText[8][0] = findViewById(R.id.editText102);
            editText[8][1] = findViewById(R.id.editText103);
          //  textView[8][1]= findViewById(R.id.editText104);
            textView[8][0].setVisibility(View.VISIBLE);
            editText[8][0].setVisibility(View.VISIBLE);
            editText[8][1].setVisibility(View.VISIBLE);
          //  textView[8][1].setVisibility(View.VISIBLE);
            textView[8][0].setTag("8");
        }
        /*if(row==3){
            textView[1] = findViewById(R.id.textView31);
            editText[1][0] = findViewById(R.id.editText32);
            editText[1][1] = findViewById(R.id.editText33);
            editText[1][2]= findViewById(R.id.editText34);
            textView[1].setVisibility(View.VISIBLE);
            editText[1][0].setVisibility(View.VISIBLE);
            editText[1][1].setVisibility(View.VISIBLE);
            editText[1][2].setVisibility(View.VISIBLE);
        }
        if(row==3){
            textView[1] = findViewById(R.id.textView31);
            editText[1][0] = findViewById(R.id.editText32);
            editText[1][1] = findViewById(R.id.editText33);
            editText[1][2]= findViewById(R.id.editText34);
            textView[1].setVisibility(View.VISIBLE);
            editText[1][0].setVisibility(View.VISIBLE);
            editText[1][1].setVisibility(View.VISIBLE);
            editText[1][2].setVisibility(View.VISIBLE);
        }*/

    }

    /*public void change(int k,int where){
        int temp;
        if(where == 3) {
            temp = k + Integer.parseInt(String.valueOf(editText[2][1].getText()));
            textView[3][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[3][1].getText()));
            textView[4][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[4][1].getText()));
            textView[5][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[5][1].getText()));
            textView[6][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[6][1].getText()));
            textView[7][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[7][1].getText()));
            textView[8][1].setText(temp + "");
        }
        if(where == 4) {
            temp = k + Integer.parseInt(String.valueOf(editText[3][1].getText()));
            textView[4][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[4][1].getText()));
            textView[5][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[5][1].getText()));
            textView[6][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[6][1].getText()));
            textView[7][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[7][1].getText()));
            textView[8][1].setText(temp + "");
        }
        if(where == 5) {
            temp = k + Integer.parseInt(String.valueOf(editText[4][1].getText()));
            textView[5][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[5][1].getText()));
            textView[6][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[6][1].getText()));
            textView[7][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[7][1].getText()));
            textView[8][1].setText(temp + "");
        }
        if(where == 6) {
            temp = k + Integer.parseInt(String.valueOf(editText[5][1].getText()));
            textView[6][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[6][1].getText()));
            textView[7][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[7][1].getText()));
            textView[8][1].setText(temp + "");
        }
        if(where == 7) {
            temp = k + Integer.parseInt(String.valueOf(editText[6][1].getText()));
            textView[7][1].setText(temp + "");
            temp = temp + Integer.parseInt(String.valueOf(editText[7][1].getText()));
            textView[8][1].setText(temp + "");
        }
        if(where == 8) {
            temp = k + Integer.parseInt(String.valueOf(editText[7][1].getText()));
            textView[8][1].setText(temp + "");
        }
    }*/

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void hide(View view){
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            assert inputMethodManager != null;
            inputMethodManager.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(), 0);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t = findViewById(R.id.textView0);
        e = findViewById(R.id.editText0);
        t.setVisibility(View.GONE);
        e.setVisibility(View.GONE);
        editText = new EditText[10][2];
        textView = new TextView[10][2];
        RadioButton r1,r2,r3,r4;
        row=2;
        textView1 = new TextView[9];
        ScrollView s = findViewById(R.id.sv);

        setTitle("FCFS");

        final EditText e1 = findViewById(R.id.editText22);
        editText[1][1] = findViewById(R.id.editText33);
        editText[2][1] = findViewById(R.id.editText43);
        editText[3][1] = findViewById(R.id.editText53);
        editText[4][1] = findViewById(R.id.editText63);
        editText[5][1] = findViewById(R.id.editText73);
        editText[6][1] = findViewById(R.id.editText83);
        editText[7][1] = findViewById(R.id.editText93);
        editText[8][1] = findViewById(R.id.editText103);
        /*textView[1][1]= findViewById(R.id.editText34);
        textView[2][1]= findViewById(R.id.editText44);
        textView[3][1]= findViewById(R.id.editText54);
        textView[4][1]= findViewById(R.id.editText64);
        textView[5][1]= findViewById(R.id.editText74);
        textView[6][1]= findViewById(R.id.editText84);
        textView[7][1]= findViewById(R.id.editText94);
        textView[8][1]= findViewById(R.id.editText104);*/
        


        /*final int[] ints = new int[10];

        TextWatcher[] textWatchers = new TextWatcher[8];

        for(int i=1;i<=8;i++){
            final int finalI = i;
            textWatchers[i-1] =new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                   *//* if(finalI ==1){
                        textView[finalI +1][2].setText((Integer.parseInt(String.valueOf(editText[1].getText()))+Integer.parseInt(String.valueOf(editable))));
                    }*/
        /*
                   if(finalI ==1 ) {
                       int k;
                       if (!editable.toString().equals("")) {
                           try {
                               k = Integer.parseInt(String.valueOf(e1.getText())) + Integer.parseInt(editable.toString());
                               textView[2][1].setText(k + "");
                               if(row > 4){
                                   change(k,3);
                               }
                           }catch (Exception e){
                               //Toast.makeText(MainActivity2.this, "Enter previous BTS", Toast.LENGTH_SHORT).show();
                              Log.i("here",e.toString());
                           }
                       }
                   }
                    if(finalI ==2 ) {
                        int k;
                        if (!editable.toString().equals("")) {
                            try {
                                k = Integer.parseInt(String.valueOf(e1.getText())) +
                                        Integer.parseInt(String.valueOf(editText[1][1].getText())) +
                                        Integer.parseInt(editable.toString());
                                textView[3][1].setText(k + "");
                                if(row > 5){
                                    change(k,4);
                                }
                            }catch (Exception e){
                                //Toast.makeText(MainActivity2.this, "Enter previous BTS", Toast.LENGTH_SHORT).show();
                                Log.i("here",e.toString());
                            }
                        }
                    }
                    if(finalI ==3 ) {
                        int k;
                        if (!editable.toString().equals("")) {
                            try {
                                k = Integer.parseInt(String.valueOf(e1.getText())) +
                                        Integer.parseInt(String.valueOf(editText[1][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[2][1].getText())) +
                                        Integer.parseInt(editable.toString());
                                textView[4][1].setText(k + "");
                                if(row > 6){
                                    change(k,5);
                                }
                            }catch (Exception e){
                                //Toast.makeText(MainActivity2.this, "Enter previous BTS", Toast.LENGTH_SHORT).show();
                                Log.i("here",e.toString());
                            }
                        }
                    }

                    if(finalI ==4 ) {
                        int k;
                        if (!editable.toString().equals("")) {
                            try {
                                k = Integer.parseInt(String.valueOf(e1.getText())) +
                                        Integer.parseInt(String.valueOf(editText[1][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[2][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[3][1].getText())) +
                                        Integer.parseInt(editable.toString());
                                textView[5][1].setText(k + "");
                                if(row > 7){
                                    change(k,6);
                                }
                            }catch (Exception e){
                               // Toast.makeText(MainActivity2.this, "Enter previous BTS", Toast.LENGTH_SHORT).show();
                                Log.i("here",e.toString());
                            }
                        }
                    }
                    if(finalI ==5 ) {
                        int k;
                        if (!editable.toString().equals("")) {
                            try {
                                k = Integer.parseInt(String.valueOf(e1.getText())) +
                                        Integer.parseInt(String.valueOf(editText[1][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[2][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[4][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[3][1].getText())) +
                                        Integer.parseInt(editable.toString());
                                textView[6][1].setText(k + "");
                                if(row > 8){
                                    change(k,7);
                                }
                            }catch (Exception e){
                               // Toast.makeText(MainActivity2.this, "Enter previous BTS", Toast.LENGTH_SHORT).show();
                                Log.i("here",e.toString());
                            }
                        }
                    }
                    if(finalI ==6 ) {
                        int k;
                        if (!editable.toString().equals("")) {
                            try {
                                k = Integer.parseInt(String.valueOf(e1.getText())) +
                                        Integer.parseInt(String.valueOf(editText[1][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[2][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[4][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[5][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[3][1].getText())) +
                                        Integer.parseInt(editable.toString());
                                textView[7][1].setText(k + "");
                                if(row > 9){
                                    change(k,8);
                                }
                            }catch (Exception e){
                               // Toast.makeText(MainActivity2.this, "Enter previous BTS", Toast.LENGTH_SHORT).show();
                                Log.i("here",e.toString());
                            }
                        }
                    }
                    if(finalI ==7 ) {
                        int k;
                        if (!editable.toString().equals("")) {
                            try {
                                k = Integer.parseInt(String.valueOf(e1.getText())) +
                                        Integer.parseInt(String.valueOf(editText[1][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[2][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[4][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[5][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[6][1].getText())) +
                                        Integer.parseInt(String.valueOf(editText[3][1].getText())) +
                                        Integer.parseInt(editable.toString());
                                textView[8][1].setText(k + "");
                                if(row > 10){
                                    change(k,9);
                                }
                            }catch (Exception e){
                               // Toast.makeText(MainActivity2.this, "Enter previous BTS", Toast.LENGTH_SHORT).show();
                                Log.i("here",e.toString());
                            }
                        }
                    }

                }
            };
            editText[i][1].addTextChangedListener(textWatchers[i-1]);
        }


        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                *//*Log.i("here","changed");
                textView[1][2].setVisibility(View.VISIBLE);
                textView[1][2].setText("3");*/
        /*
            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(!editable.toString().equals("")){
                    Log.i("here","changed");
                    //textView[1][2].setVisibility(View.VISIBLE);
                    textView[1][1]= findViewById(R.id.editText34);
                    textView[1][1].setText(editable.toString());
                    int k = Integer.parseInt(editable.toString());

                    if(row > 3){
                        try {
                            int temp;
                            temp = k + Integer.parseInt(String.valueOf(editText[2][1].getText()));
                            textView[3][1].setText(temp + "");
                            temp = temp + Integer.parseInt(String.valueOf(editText[3][1].getText()));
                            textView[4][1].setText(temp + "");
                            temp = temp + Integer.parseInt(String.valueOf(editText[4][1].getText()));
                            textView[5][1].setText(temp + "");
                            temp = temp + Integer.parseInt(String.valueOf(editText[5][1].getText()));
                            textView[6][1].setText(temp + "");
                            temp = temp + Integer.parseInt(String.valueOf(editText[6][1].getText()));
                            textView[7][1].setText(temp + "");
                            temp = temp + Integer.parseInt(String.valueOf(editText[7][1].getText()));
                            textView[8][1].setText(temp + "");
                        }
                        catch (Exception e){
                            Log.i("here","BT wali problem");
                        }
                    }
                }
            }
        };

        try {
            e1.addTextChangedListener(textWatcher);
        }catch (NullPointerException e){
            e.printStackTrace();
        }*/
        g= findViewById(R.id.gridLayout);
    }
}