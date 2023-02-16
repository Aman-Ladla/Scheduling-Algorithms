package com.studies.os;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class PPriority extends AppCompatActivity {

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
    ArrayList<Integer> parray = new ArrayList<>();
    ArrayList<Integer> carray = new ArrayList<>();
    ArrayList<Integer> ids = new ArrayList<>();
    TextView[] textView1;

    public void remove(View view){
        if(row>=3) {
            textView[row - 2][0].setVisibility(View.GONE);
            editText[row - 2][0].setVisibility(View.GONE);
            editText[row - 2][1].setVisibility(View.GONE);
            editText[row - 2][2].setVisibility(View.GONE);
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
        parray.clear();
        ids.clear();
        carray.clear();
        f=0;

        TextView t0 = findViewById(R.id.textView6);
        EditText e0 = findViewById(R.id.editText23);
        EditText e1 = findViewById(R.id.editText22);
        EditText e2 = findViewById(R.id.editText24);
        e0.setTag("0");

        tarray.add(String.valueOf(t0.getText()));
        if(!String.valueOf(e0.getText()).equals("") &&  !String.valueOf(e1.getText()).equals("") && !String.valueOf(e2.getText()).equals("")) {
            c=0;
            earray.add(Integer.valueOf(String.valueOf(e0.getText())));
            aarray.add(Integer.valueOf(String.valueOf(e1.getText())));
            parray.add(Integer.valueOf(String.valueOf(e2.getText())));
            ids.add(Integer.valueOf(String.valueOf(e0.getTag())));
            carray.add(0);
            if(Integer.parseInt(String.valueOf(e0.getText()))==0){
                f=1;
                Toast.makeText(this, "Burst Time can't be 0", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            c=1;
            Toast.makeText(this, "Enter valid AT,BT and priority", Toast.LENGTH_SHORT).show();
        }

        for(int j=1;j<row-1;j++){
            if(!String.valueOf((editText[j][1]).getText()).equals("") && !String.valueOf((editText[j][0]).getText()).equals("")) {
                d=0;
                aarray.add(Integer.valueOf(String.valueOf((editText[j][0]).getText())));
                tarray.add(textView[j][0].getText().toString());
                //tarray.add(textView[2].getText().toString());
                earray.add(Integer.valueOf(String.valueOf((editText[j][1]).getText())));
                parray.add(Integer.valueOf(String.valueOf((editText[j][2]).getText())));
                ids.add(Integer.valueOf((String) textView[j][0].getTag()));
                carray.add(0);
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

            ArrayList<Integer> taba;
            ArrayList<Integer> tabe;
            taba = (ArrayList<Integer>) aarray.clone();
            tabe = (ArrayList<Integer>) earray.clone();
            intent.putIntegerArrayListExtra("taba",taba);
            intent.putIntegerArrayListExtra("tabe",tabe);

            Log.i("in 3 aarray", aarray.toString());
            intent.putIntegerArrayListExtra("tfa", aarray);
            intent.putIntegerArrayListExtra("tfee", earray);

            for (int i = 0; i < aarray.size(); i++) {
                for (int j = i + 1; j < aarray.size(); j++) {
                    if (aarray.get(i) > aarray.get(j)) {
                        int temp = aarray.get(i);
                        String temp1 = tarray.get(i);
                        int temp2 = earray.get(i);
                        int id = ids.get(i);
                        int temp3 = parray.get(i);
                        aarray.set(i, aarray.get(j));
                        tarray.set(i, tarray.get(j));
                        earray.set(i, earray.get(j));
                        ids.set(i, ids.get(j));
                        parray.set(i,parray.get(j));
                        aarray.set(j, temp);
                        tarray.set(j, temp1);
                        earray.set(j, temp2);
                        ids.set(j, id);
                        parray.set(j,temp3);
                    }
                }
            }
            Log.i("Ascended A", tarray.toString());
            Log.i("Ascended ID", ids.toString());
            /*for(int i=1;i<aarray.size();i++) {
                for (int j = i + 1; j < aarray.size(); j++) {
                    if (aarray.get(i) == aarray.get(j)) {
                        if (ids.get(i)>ids.get(j)) {
                            int temp = aarray.get(i);
                            String temp1 = tarray.get(i);
                            int temp2 = earray.get(i);
                            aarray.set(i, aarray.get(j));
                            tarray.set(i, tarray.get(j));
                            earray.set(i, earray.get(j));
                            aarray.set(j, temp);
                            tarray.set(j, temp1);
                            earray.set(j, temp2);
                        }
                    }
                }
            }*/

            /*ArrayList<String> ft = new ArrayList<>();
            ArrayList<Integer> fa = new ArrayList<>();
            ArrayList<Integer> fe = new ArrayList<>();
            ft.add(tarray.get(0));
            fa.add(aarray.get(0));
            fe.add(earray.get(0));
            Log.i("Here P",tarray.toString());
            Log.i("Here A",aarray.toString());
            Log.i("Here A",earray.toString());
            Log.i("Here man",aarray.get(0).toString());
            int k=0;
            int i=0;
            int r = row-2;
            int tr=0;
            ArrayList<String> p = new ArrayList<>();
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> burst = new ArrayList<>();
            while(k<earray.size()-1) {
                for (int j = aarray.get(k); j <= aarray.get(k) + earray.get(k); j++) {
                    for (int l = 1; l < 4; l++) {
                        Log.i("j", String.valueOf(j));
                        Log.i("simple wala",aarray.get(l).toString());
                        if (aarray.get(l) == j) {
                            Log.i("hello","hello");
                            p.add(tarray.get(l));
                            a.add(aarray.get(l));
                            burst.add(earray.get(l));
                            tr++;
                        }
                    }
                    Log.i("Temp P",p.toString());
                    for (int l = 0; l < p.size() - 1; l++) {
                        for (int m = l + 1; m < p.size() - 1; m++) {
                            if (burst.get(l) > burst.get(m)) {
                                int temp = a.get(l);
                                String temp1 = p.get(l);
                                int temp2 = burst.get(l);
                                a.set(l, a.get(m));
                                p.set(l, p.get(m));
                                burst.set(l, burst.get(m));
                                a.set(m, temp);
                                p.set(m, temp1);
                                burst.set(m, temp2);
                            }
                        }
                    }
                    try {
                        Log.i("Before adding BT is ",burst.toString());
                        Log.i("added BT",burst.get(0).toString());
                        ft.add(p.get(0));
                        fa.add(a.get(0));
                        fe.add(burst.get(0));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Log.i("BT till now",fe.toString());
                    try {
                        if (p.get(0).equals("")) {
                        }
                        int o = 0;
                        for (int l = 1; l < tr; l++) {
                            if (burst.get(0).equals(earray.get(l))) {
                                o = l;
                                break;
                            }
                        }
                        earray.remove(o);
                        tarray.remove(o);
                        aarray.remove(o);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    Log.i("After removal",tarray.toString());
                    r--;
                }
            }

            Log.i("Order", String.valueOf(ft));*/
            int counter = 0;
            ArrayList<String> ft = new ArrayList<>();
            ArrayList<Integer> fa = new ArrayList<>();
            ArrayList<Integer> fe = new ArrayList<>();
            ArrayList<Integer> fi = new ArrayList<>();
            ArrayList<Integer> idd;

            ArrayList<String> tft = new ArrayList<>();
            ArrayList<Integer> tfe = new ArrayList<>();


            /*for(int i=0;i<aarray.size();i++) {
                for (int j = i + 1; j < aarray.size(); j++) {
                    if (aarray.get(i) == aarray.get(j)) {
                        if (earray.get(i)>earray.get(j)) {
                            int temp = aarray.get(i);
                            String temp1 = tarray.get(i);
                            int temp2 = earray.get(i);
                            int temp3 = ids.get(i);
                            aarray.set(i, aarray.get(j));
                            tarray.set(i, tarray.get(j));
                            earray.set(i, earray.get(j));
                            ids.set(i,ids.get(j));
                            aarray.set(j, temp);
                            tarray.set(j, temp1);
                            earray.set(j, temp2);
                            ids.set(j,temp3);
                        }
                    }
                }
            }*/
            idd = (ArrayList<Integer>) ids.clone();

            for (int i = 0; i < aarray.size(); i++) {
                for (int j = i + 1; j < aarray.size(); j++) {
                    if (aarray.get(i) == aarray.get(j)) {
                        if (parray.get(i) > parray.get(j)) {
                            int temp = aarray.get(i);
                            String temp1 = tarray.get(i);
                            int temp2 = earray.get(i);
                            int temp3 = ids.get(i);
                            int temp4 = parray.get(i);
                            aarray.set(i, aarray.get(j));
                            tarray.set(i, tarray.get(j));
                            earray.set(i, earray.get(j));
                            idd.set(i, ids.get(j));
                            parray.set(i,parray.get(j));
                            aarray.set(j, temp);
                            tarray.set(j, temp1);
                            earray.set(j, temp2);
                            idd.set(j, temp3);
                            parray.set(j,temp4);
                        }
                    }
                }
            }

            Log.i("Before while P", tarray.toString());

            for (int i =0; i < aarray.size(); i++) {
                for (int j = i + 1; j < aarray.size(); j++) {
                    if (aarray.get(i) == aarray.get(j) && parray.get(i)== parray.get(j)) {
                        if (ids.get(i) > ids.get(j)) {
                            int temp = aarray.get(i);
                            String temp1 = tarray.get(i);
                            int temp2 = earray.get(i);
                            int temp3 = ids.get(i);
                            int temp4 = parray.get(i);
                            aarray.set(i, aarray.get(j));
                            tarray.set(i, tarray.get(j));
                            earray.set(i, earray.get(j));
                            idd.set(i, ids.get(j));
                            parray.set(i,parray.get(j));
                            aarray.set(j, temp);
                            tarray.set(j, temp1);
                            earray.set(j, temp2);
                            idd.set(j, temp3);
                            parray.set(j,temp4);
                        }
                    }
                }
            }

            Log.i("Before while P", tarray.toString());
            Log.i("Before while E", earray.toString());
            Log.i("Before while A", aarray.toString());
            Log.i("Before while ID", ids.toString());
            Log.i("Before while IDD", idd.toString());
            ArrayList<Integer> eCancel = (ArrayList<Integer>) earray.clone();
            // eCancel=earray;

            ArrayList<Integer> temparray = new ArrayList<>();
            ArrayList<Integer> ide = new ArrayList<>();
            ArrayList<Integer> e = new ArrayList<>();
            ArrayList<Integer> p = new ArrayList<>();
            ArrayList<Integer> t = new ArrayList<>();
            ids.clear();


            fa.add(aarray.get(0));
            ft.add(tarray.get(0));
            ids.add(idd.get(0));
            if(aarray.size()>1) {
                fe.add(1);
                counter=aarray.get(0)+1;
                eCancel.set(0, eCancel.get(0) - 1);
                if(eCancel.get(0) == 0){
                    carray.add(idd.get(0),counter);
                }
            }
            else{
                fe.add(earray.get(0));
                counter = earray.get(0);
                eCancel.set(0, 0);
                carray.set(0,counter);
            }
            Log.i("cancel b4 while",eCancel.toString());
            int k=2;

            while (counter < aarray.get(aarray.size() - 1)) {
                try {
                    ide.clear();
                    e.clear();
                    p.clear();
                    for (int i = aarray.get(0); i <= counter; i++) {
                        for (int j = 0; j < aarray.size(); j++) {
                            if (aarray.get(j) == i && eCancel.get(j) != 0) {
                                ide.add(j);
                                e.add(eCancel.get(j));
                                p.add(parray.get(j));
                            }
                        }
                    }
                    Log.i("ide here 0",ide.toString());
                    Log.i("p here 0",p.toString());
                    for (int i = 0; i < ide.size(); i++) {
                        for (int j = i + 1; j < ide.size(); j++) {
                            if (p.get(i) > p.get(j)) {
                                int temp = e.get(i);
                                int temp1 = ide.get(i);
                                int temp2 = p.get(i);
                                e.set(i, e.get(j));
                                ide.set(i, ide.get(j));
                                p.set(i,p.get(j));
                                e.set(j, temp);
                                ide.set(j, temp1);
                                p.set(j,temp2);
                            }
                        }
                    }
                    Log.i("p here",p.toString());
                    Log.i("ide here",ide.toString());
                    for (int i = 0; i < ide.size(); i++) {
                        for (int j = i + 1; j < ide.size(); j++) {
                            if (p.get(i).equals(p.get(j))) {
                                if (idd.get(ide.get(i)) > idd.get(ide.get(j))) {
                                    int temp = e.get(i);
                                    int temp1 = ide.get(i);
                                    int temp2 = p.get(i);
                                    e.set(i, e.get(j));
                                    ide.set(i, ide.get(j));
                                    p.set(i,p.get(j));
                                    e.set(j, temp);
                                    ide.set(j, temp1);
                                    p.set(j,temp2);
                                }
                            }
                        }
                    }

                    eCancel.set(ide.get(0), e.get(0) - 1);
                    if (ids.get(ids.size() - 1).equals(idd.get(ide.get(0)))) {
                        int temp = fe.get(fe.size() - 1);
                        int temp1 = fa.get(fa.size() - 1);
                        fe.remove(fe.size() - 1);
                        //fa.remove(fa.size()-1);
                        fe.add(temp + 1);
                        //fa.add(temp1+1);
                    } else {
                        fe.add(1);
                        ft.add(tarray.get(ide.get(0)));
                        fa.add(counter);
                        ids.add(idd.get(ide.get(0)));
                    }
                    //ids.add(idd.get(ide.get(0)));

                    counter++;

                    if(eCancel.get(ide.get(0))==0){
                        carray.set(idd.get(ide.get(0)),counter);
                    }


                    Log.i("counter", String.valueOf(counter));
                    Log.i("ide", ide.toString());
                    Log.i("fa", fa.toString());
                    Log.i("ids", ids.toString());
                    Log.i("ft", ft.toString());
                    Log.i("fe", fe.toString());
                    Log.i("cancel", eCancel.toString());
                }catch (Exception e3){
                    counter++;
                    e3.printStackTrace();
                }
            }

            ArrayList<Integer> idd1 = (ArrayList<Integer>) idd.clone();

            for(int i=0;i<eCancel.size();i++){
                for(int j=i+1;j< eCancel.size();j++){
                    if(parray.get(i)>parray.get(j)){
                        int temp = eCancel.get(i);
                        int temp1 = idd1.get(i);
                        String temp2 = tarray.get(i);
                        int temp3 = parray.get(i);
                        eCancel.set(i,eCancel.get(j));
                        idd1.set(i,idd1.get(j));
                        tarray.set(i,tarray.get(j));
                        parray.set(i,parray.get(j));
                        eCancel.set(j,temp);
                        idd1.set(j,temp1);
                        tarray.set(j,temp2);
                        parray.set(j,temp3);
                    }
                }
            }

            for(int i=0;i<eCancel.size();i++){
                for(int j=i+1;j< eCancel.size();j++){
                    if(parray.get(i).equals(parray.get(j))) {
                        if (idd1.get(i) > idd1.get(j)) {
                            int temp = eCancel.get(i);
                            int temp1 = idd1.get(i);
                            String temp2 = tarray.get(i);
                            int temp3 = parray.get(i);
                            eCancel.set(i, eCancel.get(j));
                            idd1.set(i, idd1.get(j));
                            tarray.set(i, tarray.get(j));
                            parray.set(i,parray.get(j));
                            eCancel.set(j, temp);
                            idd1.set(j, temp1);
                            tarray.set(j, temp2);
                            parray.set(j,temp3);
                        }
                    }
                }
            }

            int c=0;

            while(c==0) {
                c=1;
                for (int i = 0; i < eCancel.size(); i++) {
                    if (eCancel.get(i) == 0) {
                        eCancel.remove(i);
                        idd1.remove(i);
                        tarray.remove(i);
                        c=0;
                    }
                }
            }
            ArrayList<Integer> integers = new ArrayList<>();
            for(int i=0;i<eCancel.size();i++){
                fa.add(counter);
                counter+=eCancel.get(i);
                integers.add(counter);
            }

            fe.addAll(eCancel);
            ft.addAll(tarray);
            ids.addAll(idd1);

            for(int i=0;i<eCancel.size();i++){
                for(int j=i+1;j<eCancel.size();j++){
                    if(idd1.get(i)>idd1.get(j)){
                        int temp = idd1.get(i);
                        int temp1 = integers.get(i);
                        idd1.set(i,idd1.get(j));
                        integers.set(i,integers.get(j));
                        idd1.set(j,temp);
                        integers.set(j,temp1);
                    }
                }
            }

            for(int i=0;i<idd1.size();i++){
                if(carray.get(idd1.get(i))==0){
                    carray.set(idd1.get(i),integers.get(i));
                }
            }

            /*intent.putIntegerArrayListExtra("tfe",tfe);
            intent.putStringArrayListExtra("tft",tft);
            intent.putExtra("counter",counter);*/
            intent.putIntegerArrayListExtra("id",ids);
            intent.putStringArrayListExtra("PN", ft);
            intent.putIntegerArrayListExtra("BT", fe);
            intent.putIntegerArrayListExtra("AT",fa);
            intent.putExtra("process",row-1);
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
            editText[1][2]= findViewById(R.id.editText34);
            textView[1][0].setVisibility(View.VISIBLE);
            editText[1][0].setVisibility(View.VISIBLE);
            editText[1][1].setVisibility(View.VISIBLE);
            editText[1][2].setVisibility(View.VISIBLE);
            textView[1][0].setTag("1");
        }
        if(row==4){
            textView[2][0] = findViewById(R.id.textView41);
            editText[2][0] = findViewById(R.id.editText42);
            editText[2][1] = findViewById(R.id.editText43);
            editText[2][2]= findViewById(R.id.editText44);
            textView[2][0].setVisibility(View.VISIBLE);
            editText[2][0].setVisibility(View.VISIBLE);
            editText[2][1].setVisibility(View.VISIBLE);
            editText[2][2].setVisibility(View.VISIBLE);
            textView[2][0].setTag("2");
        }
        if(row==5){
            textView[3][0]= findViewById(R.id.textView51);
            editText[3][0] = findViewById(R.id.editText52);
            editText[3][1] = findViewById(R.id.editText53);
            editText[3][2]= findViewById(R.id.editText54);
            textView[3][0].setVisibility(View.VISIBLE);
            editText[3][0].setVisibility(View.VISIBLE);
            editText[3][1].setVisibility(View.VISIBLE);
            editText[3][2].setVisibility(View.VISIBLE);
            textView[3][0].setTag("3");
        }
        if(row==6){
            textView[4][0] = findViewById(R.id.textView61);
            editText[4][0] = findViewById(R.id.editText62);
            editText[4][1] = findViewById(R.id.editText63);
            editText[4][2]= findViewById(R.id.editText64);
            textView[4][0].setVisibility(View.VISIBLE);
            editText[4][0].setVisibility(View.VISIBLE);
            editText[4][1].setVisibility(View.VISIBLE);
            editText[4][2].setVisibility(View.VISIBLE);
            textView[4][0].setTag("4");
        }
        if(row==7){
            textView[5][0] = findViewById(R.id.textView71);
            editText[5][0] = findViewById(R.id.editText72);
            editText[5][1] = findViewById(R.id.editText73);
            editText[5][2]= findViewById(R.id.editText74);
            textView[5][0].setVisibility(View.VISIBLE);
            editText[5][0].setVisibility(View.VISIBLE);
            editText[5][1].setVisibility(View.VISIBLE);
            editText[5][2].setVisibility(View.VISIBLE);
            textView[5][0].setTag("5");
        }
        if(row==8){
            textView[6][0] = findViewById(R.id.textView81);
            editText[6][0] = findViewById(R.id.editText82);
            editText[6][1] = findViewById(R.id.editText83);
            editText[6][2]= findViewById(R.id.editText84);
            textView[6][0].setVisibility(View.VISIBLE);
            editText[6][0].setVisibility(View.VISIBLE);
            editText[6][1].setVisibility(View.VISIBLE);
            editText[6][2].setVisibility(View.VISIBLE);
            textView[6][0].setTag("6");
        }
        if(row==9){
            textView[7][0] = findViewById(R.id.textView91);
            editText[7][0] = findViewById(R.id.editText92);
            editText[7][1] = findViewById(R.id.editText93);
            editText[7][2]= findViewById(R.id.editText94);
            textView[7][0].setVisibility(View.VISIBLE);
            editText[7][0].setVisibility(View.VISIBLE);
            editText[7][1].setVisibility(View.VISIBLE);
            editText[7][2].setVisibility(View.VISIBLE);
            textView[7][0].setTag("7");
        }
        if(row==10){
            textView[8][0] = findViewById(R.id.textView101);
            editText[8][0] = findViewById(R.id.editText102);
            editText[8][1] = findViewById(R.id.editText103);
            editText[8][2]= findViewById(R.id.editText104);
            textView[8][0].setVisibility(View.VISIBLE);
            editText[8][0].setVisibility(View.VISIBLE);
            editText[8][1].setVisibility(View.VISIBLE);
            editText[8][2].setVisibility(View.VISIBLE);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority);
        t = findViewById(R.id.textView0);
        e = findViewById(R.id.editText0);
        t.setVisibility(View.GONE);
        e.setVisibility(View.GONE);
        editText = new EditText[10][3];
        textView = new TextView[10][2];
        setTitle("Preemptive Priority Sch.");
        RadioButton r1,r2,r3,r4;
        row=2;
        textView1 = new TextView[9];
        final EditText e1 = findViewById(R.id.editText23);
        editText[1][1] = findViewById(R.id.editText33);
        editText[2][1] = findViewById(R.id.editText43);
        editText[3][1] = findViewById(R.id.editText53);
        editText[4][1] = findViewById(R.id.editText63);
        editText[5][1] = findViewById(R.id.editText73);
        editText[6][1] = findViewById(R.id.editText83);
        editText[7][1] = findViewById(R.id.editText93);
        editText[8][1] = findViewById(R.id.editText103);
        editText[1][2]= findViewById(R.id.editText34);
        editText[2][2]= findViewById(R.id.editText44);
        editText[3][2]= findViewById(R.id.editText54);
        editText[4][2]= findViewById(R.id.editText64);
        editText[5][2]= findViewById(R.id.editText74);
        editText[6][2]= findViewById(R.id.editText84);
        editText[7][2]= findViewById(R.id.editText94);
        editText[8][2]= findViewById(R.id.editText104);


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
                textView[1][2].setText("3");*//*
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