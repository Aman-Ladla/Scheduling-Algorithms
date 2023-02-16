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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class I_SRTF extends AppCompatActivity {

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
    ArrayList<Integer> iarray = new ArrayList<>();
    ArrayList<Integer> earray1 = new ArrayList<>();
    ArrayList<Integer> carray = new ArrayList<>();
    ArrayList<Integer> tabe = new ArrayList<>();
    ArrayList<Boolean> flag = new ArrayList<>();
    ArrayList<Boolean> end0 = new ArrayList<>();
    ArrayList<Boolean> end = new ArrayList<>();
    ArrayList<Integer> ids = new ArrayList<>();
    ArrayList<Integer> cou = new ArrayList<>();
    ArrayList<Integer> IOI = new ArrayList<>();
    ArrayList<Integer> IOF = new ArrayList<>();
    ArrayList<String> IOT = new ArrayList<>();

    public void remove(View view){
        if(row>=3) {
            textView[row - 2][0].setVisibility(View.GONE);
            editText[row - 2][0].setVisibility(View.GONE);
            editText[row - 2][1].setVisibility(View.GONE);
            editText[row - 2][2].setVisibility(View.GONE);
            editText[row - 2][3].setVisibility(View.GONE);
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
        iarray.clear();
        ids.clear();
        earray1.clear();
        carray.clear();
        tabe.clear();
        flag.clear();
        end0.clear();
        end.clear();
        cou.clear();
        IOI.clear();
        IOF.clear();
        IOT.clear();
        f=0;

        TextView t0 = findViewById(R.id.textView6);
        EditText e0 = findViewById(R.id.editText23);
        EditText e1 = findViewById(R.id.editText22);
        EditText e2 = findViewById(R.id.editText24);
        EditText e3 = findViewById(R.id.editText25);
        e0.setTag("0");
        e2.setTag("0");
        e3.setTag("0");

        tarray.add(String.valueOf(t0.getText()));
        if(!String.valueOf(e0.getText()).equals("") &&  !String.valueOf(e1.getText()).equals("") &&
                !String.valueOf(e2.getText()).equals("") && !String.valueOf(e3.getText()).equals("")) {
            c=0;
            earray.add(Integer.valueOf(String.valueOf(e0.getText())));
            aarray.add(Integer.valueOf(String.valueOf(e1.getText())));
            iarray.add(Integer.valueOf(String.valueOf(e2.getText())));
            earray1.add(Integer.valueOf(String.valueOf(e3.getText())));
            ids.add(Integer.valueOf(String.valueOf(e0.getTag())));
            tabe.add(Integer.parseInt(String.valueOf(e0.getText()))+Integer.parseInt(String.valueOf(e3.getText())));
            carray.add(0);
            flag.add(true);
            end.add(false);
            end0.add(false);
            cou.add(0);
            IOI.add(0);
            IOF.add(0);
            IOT.add("");
            if(Integer.parseInt(String.valueOf(e0.getText()))==0 || Integer.parseInt(String.valueOf(e2.getText()))==0 || Integer.parseInt(String.valueOf(e3.getText()))==0 ){
                f=1;
                Toast.makeText(this, "Burst/IO Time can't be 0", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            c=1;
            Toast.makeText(this, "Enter valid AT and BT", Toast.LENGTH_SHORT).show();
        }

        for(int j=1;j<row-1;j++){
            if(!String.valueOf((editText[j][1]).getText()).equals("") && !String.valueOf((editText[j][0]).getText()).equals("")
                    && !String.valueOf(editText[j][2].getText()).equals("") && !String.valueOf(editText[j][3].getText()).equals("")) {
                d=0;
                aarray.add(Integer.valueOf(String.valueOf((editText[j][0]).getText())));
                tarray.add(textView[j][0].getText().toString());
                //tarray.add(textView[2].getText().toString());
                earray.add(Integer.valueOf(String.valueOf((editText[j][1]).getText())));
                iarray.add(Integer.valueOf(String.valueOf((editText[j][2]).getText())));
                earray1.add(Integer.valueOf(String.valueOf((editText[j][3]).getText())));
                ids.add(Integer.valueOf((String) textView[j][0].getTag()));
                tabe.add(Integer.parseInt(String.valueOf((editText[j][1]).getText()))+Integer.parseInt(String.valueOf((editText[j][3]).getText())));
                carray.add(0);
                flag.add(true);
                end.add(false);
                end0.add(false);
                cou.add(0);
                IOI.add(0);
                IOF.add(0);
                IOT.add("");
                if(Integer.parseInt(String.valueOf(editText[j][1].getText()))==0 || Integer.parseInt(String.valueOf(editText[j][2].getText()))==0 || Integer.parseInt(String.valueOf(editText[j][3].getText()))==0){
                    f=1;
                    Toast.makeText(this, "Burst/IO Time can't be 0", Toast.LENGTH_SHORT).show();
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
            taba = (ArrayList<Integer>) aarray.clone();
            intent.putIntegerArrayListExtra("taba",taba);
            intent.putIntegerArrayListExtra("tabe",tabe);

            for(int i=0;i<aarray.size();i++){
                for(int j=i+1;j<aarray.size();j++){
                    if(aarray.get(i)>aarray.get(j)){
                        int temp = aarray.get(i);
                        String temp1 = tarray.get(i);
                        int temp2 = earray.get(i);
                        int id = ids.get(i);
                        int temp4 = iarray.get(i);
                        int temp5 = earray1.get(i);
                        aarray.set(i,aarray.get(j));
                        tarray.set(i,tarray.get(j));
                        earray.set(i,earray.get(j));
                        iarray.set(i,iarray.get(j));
                        earray1.set(i,earray1.get(j));
                        ids.set(i,ids.get(j));
                        aarray.set(j,temp);
                        tarray.set(j,temp1);
                        earray.set(j,temp2);
                        ids.set(j,id);
                        iarray.set(j,temp4);
                        earray1.set(j,temp5);
                    }
                }
            }

            for(int i=0;i<aarray.size();i++){
                for(int j=i+1;j<aarray.size();j++){
                    if(aarray.get(i).equals(aarray.get(j))){
                        if((earray1.get(i)+earray.get(i))>(earray1.get(j)+earray.get(j))) {
                            int temp = aarray.get(i);
                            String temp1 = tarray.get(i);
                            int temp2 = earray.get(i);
                            int id = ids.get(i);
                            int temp4 = iarray.get(i);
                            int temp5 = earray1.get(i);
                            aarray.set(i, aarray.get(j));
                            tarray.set(i, tarray.get(j));
                            earray.set(i, earray.get(j));
                            iarray.set(i, iarray.get(j));
                            earray1.set(i, earray1.get(j));
                            ids.set(i, ids.get(j));
                            aarray.set(j, temp);
                            tarray.set(j, temp1);
                            earray.set(j, temp2);
                            ids.set(j, id);
                            iarray.set(j, temp4);
                            earray1.set(j, temp5);
                        }
                    }
                }
            }

            for(int i=1;i<aarray.size();i++) {
                for (int j = i + 1; j < aarray.size(); j++) {
                    if (aarray.get(i).equals(aarray.get(j)) && (earray1.get(i)+earray.get(i))==(earray1.get(j)+earray.get(j))) {
                        if (ids.get(i)>ids.get(j)) {
                            int temp = aarray.get(i);
                            String temp1 = tarray.get(i);
                            int temp2 = earray.get(i);
                            int temp3 = ids.get(i);
                            int temp4 = iarray.get(i);
                            int temp5 = earray1.get(i);
                            aarray.set(i, aarray.get(j));
                            tarray.set(i, tarray.get(j));
                            earray.set(i, earray.get(j));
                            iarray.set(i,iarray.get(j));
                            earray1.set(i,earray1.get(j));
                            ids.set(i, ids.get(j));
                            aarray.set(j, temp);
                            tarray.set(j, temp1);
                            earray.set(j, temp2);
                            iarray.set(j,temp4);
                            earray1.set(j,temp5);
                            ids.set(j,temp3);
                        }
                    }
                }
            }
            Log.i("ids",ids.toString());
            Log.i("Ascended tarray",tarray.toString());
            Log.i("Ascended aarray",aarray.toString());
            Log.i("Ascended earray",earray.toString());
            Log.i("Ascneded iarray",iarray.toString());
            Log.i("Ascended eaarray1",earray1.toString());

            int counter;
            int counter0=aarray.get(0)-1;
            int previous=0;
            int g=0;

            ArrayList<String> ft = new ArrayList<>();
            ArrayList<Integer> fa = new ArrayList<>();
            ArrayList<Integer> fe = new ArrayList<>();
            ArrayList<Integer> fi = new ArrayList<>();
            ArrayList<Integer> queue = new ArrayList<>();
            ArrayList<Integer> ta = new ArrayList<>();
            ArrayList<Integer> te = new ArrayList<>();
            ArrayList<Integer> idd;

            /*ft.add(tarray.get(0));
            fa.add(aarray.get(0));
            fe.add(earray.get(0));
            fi.add(ids.get(0));*/
            counter=aarray.get(0);

            /*for(int i=aarray.get(0)+1;i<=counter;i++){
                for(int j=0;j<aarray.size();j++){
                    if(aarray.get(j)==i){
                        ta.add(aarray.get(j));
                        queue.add(ids.get(j));
                        te.add(earray.get(j));
                    }
                }
            }
            if(flag.get(0)) {
                ta.add(counter + iarray.get(0));
                queue.add(ids.get(0));
                te.add(earray1.get(0));
                flag.set(0, false);
            }

            // Arrival time sorting
            for(int i=0;i<ta.size();i++){
                for(int j=i+1;j<ta.size();j++){
                    if(ta.get(i)>ta.get(j)){
                        int temp = ta.get(i);
                        int temp1 = queue.get(i);
                        int temp2 = te.get(i);
                        ta.set(i,ta.get(j));
                        queue.set(i,queue.get(j));
                        te.set(i,te.get(j));
                        ta.set(j,temp);
                        queue.set(j,temp1);
                        te.set(j,temp2);
                    }
                }
            }

            //ID sorting
            for(int i=0;i<ta.size();i++){
                for(int j=i+1;j<ta.size();j++){
                    if(ta.get(i).equals(ta.get(j))){
                        if(queue.get(i)>queue.get(j)){
                            int temp = ta.get(i);
                            int temp1 = queue.get(i);
                            int temp2 = te.get(i);
                            ta.set(i,ta.get(j));
                            queue.set(i,queue.get(j));
                            te.set(i,te.get(j));
                            ta.set(j,temp);
                            queue.set(j,temp1);
                            te.set(j,temp2);
                        }
                    }
                }
            }

            //Adding in final
            for(int i=0;i<aarray.size();i++){
                if(ids.get(i).equals(queue.get(0))){
                    previous=i;
                    ft.add(tarray.get(i));
                    fa.add(counter);
                    fe.add(te.get(0));
                    break;
                }
            }
            counter0=counter;
            counter+=te.get(0);

            Log.i("ta",ta.toString());
            Log.i("queue",queue.toString());
            Log.i("te",te.toString());
            Log.i("ft",ft.toString());
            Log.i("fa",fa.toString());
            Log.i("fe",fe.toString());
            Log.i("counter", String.valueOf(counter));

            ta.remove(0);
            queue.remove(0);
            te.remove(0);

            Log.i("After removal","");
            Log.i("ta",ta.toString());
            Log.i("queue",queue.toString());
            Log.i("te",te.toString());*/

            //--------------------------

            int k=0;
            int m=0;
            int p=0;
            int count=0;
            while(k==0 || count<=1) {
                try {
                    k = 1;
                    for (int i = counter0 + 1; i <= counter; i++) {
                        for (int j = 0; j < aarray.size(); j++) {
                            if (aarray.get(j) == i) {
                                ta.add(aarray.get(j));
                                queue.add(ids.get(j));
                                if(j<row-1) {
                                    te.add(earray.get(j) + earray1.get(j % (row - 1)));
                                }
                                else{
                                    te.add(earray.get(j));
                                }
                            }
                        }
                    }

                    if((earray.get(previous)!=0 || earray1.get(previous)!=0) && count!=0){
                        if(earray.get(previous)!=0){
                            ta.add(aarray.get(previous));
                            queue.add(ids.get(previous));
                            te.add(earray.get(previous) + earray1.get(previous));
                        }
                        else if(earray1.get(previous)!=0 && cou.get(ids.get(previous))==1 && counter0>=IOF.get(ids.get(previous))){
                            ta.add(aarray.get(previous));
                            queue.add(ids.get(previous));
                            te.add(earray.get(previous)+ earray1.get(previous));
                        }
                    }


                    if(previous<=row-1 && cou.get(ids.get(previous))==1) {
                        if (m == 0) {
                            if (flag.get(previous)) {
                                aarray.add(counter + earray.get(previous) + iarray.get(previous));
                                ids.add(ids.get(previous));
                                earray.add(earray1.get(previous));
                                tarray.add(tarray.get(previous));
                                flag.set(previous, false);
                                end0.add(true);
                                end.add(false);
                            }
                        } else {
                            if (flag.get(previous)) {
                                aarray.add(counter + iarray.get(previous));
                                ids.add(ids.get(previous));
                                earray.add(earray1.get(previous));
                                tarray.add(tarray.get(previous));
                                flag.set(previous, false);
                                end0.add(true);
                                end.add(false);
                            }
                        }
                    }

                    Log.i("aaray",aarray.toString());

                    // Arrival time sorting
                    for (int i = 0; i < ta.size(); i++) {
                        for (int j = i + 1; j < ta.size(); j++) {
                            if (ta.get(i) > ta.get(j)) {
                                int temp = ta.get(i);
                                int temp1 = queue.get(i);
                                int temp2 = te.get(i);
                                ta.set(i, ta.get(j));
                                queue.set(i, queue.get(j));
                                te.set(i, te.get(j));
                                ta.set(j, temp);
                                queue.set(j, temp1);
                                te.set(j, temp2);
                            }
                        }
                    }

                    //BT sorting
                    for (int i = 0; i < ta.size(); i++) {
                        for (int j = i + 1; j < ta.size(); j++) {
                            if(te.get(i)>te.get(j)) {
                                int temp = ta.get(i);
                                int temp1 = queue.get(i);
                                int temp2 = te.get(i);
                                ta.set(i, ta.get(j));
                                queue.set(i, queue.get(j));
                                te.set(i, te.get(j));
                                ta.set(j, temp);
                                queue.set(j, temp1);
                                te.set(j, temp2);
                            }
                        }
                    }

                    //ID sorting
                    for (int i = 0; i < ta.size(); i++) {
                        for (int j = i + 1; j < ta.size(); j++) {
                            if (te.get(i).equals(te.get(j))) {
                                if (queue.get(i) > queue.get(j)) {
                                    int temp = ta.get(i);
                                    int temp1 = queue.get(i);
                                    int temp2 = te.get(i);
                                    ta.set(i, ta.get(j));
                                    queue.set(i, queue.get(j));
                                    te.set(i, te.get(j));
                                    ta.set(j, temp);
                                    queue.set(j, temp1);
                                    te.set(j, temp2);
                                }
                            }
                        }
                    }


                    //Adding in final
                    int l=0;
                    for (int i = 0; i < aarray.size(); i++) {
                        if (ids.get(i).equals(queue.get(0))) {

                            /*ft.add(tarray.get(i));
                            fi.add(ids.get(i));*/
                            if(count>0) {
                                if (fi.get(fi.size() - 1).equals(ids.get(i)) && IOF.get(ids.get(i))!=counter) {
                                    int h = fe.get(fe.size() - 1);
                                    fe.remove(fe.size() - 1);
                                    fe.add(h + 1);
                                } else {
                                    ft.add(tarray.get(i));
                                    fi.add(ids.get(i));
                                    fe.add(1);
                                    if (m == 0) {
                                        fa.add(counter0 + 1);
                                    }
                                    else if(p==1){
                                        fa.add(ta.get(0));
                                    }
                                    else {
                                        fa.add(counter);
                                    }
                                }
                            }
                            else{
                                ft.add(tarray.get(i));
                                fi.add(ids.get(i));
                                fe.add(1);
                                if (m == 0) {
                                    fa.add(counter0 + 1);
                                }
                                else if(p==1){
                                    fa.add(ta.get(0));
                                }
                                else {
                                    fa.add(counter);
                                }
                            }

                            if(cou.get(ids.get(i))==0){
                                earray.set(i,earray.get(i)-1);
                                if(earray.get(i)==0){
                                    cou.set(ids.get(i),cou.get(ids.get(i))+1);
                                    IOI.set(ids.get(i),counter+1);
                                    IOF.set(ids.get(i),counter+1+iarray.get(i));
                                    IOT.set(ids.get(i),tarray.get(i));
                                }
                            }
                            else if(cou.get(ids.get(i))==1){
                                earray1.set(i,earray1.get(i)-1);
                                if(earray1.get(i)==0){
                                    cou.set(ids.get(i),cou.get(ids.get(i))+1);
                                    carray.set(ids.get(i),counter+1);
                                }
                            }
                            /*if (m == 0) {
                                fa.add(counter0 + 1);
                            }
                            else if(p==1){
                                fa.add(ta.get(0));
                            }
                            else {
                                fa.add(counter);
                            }
                            fe.add(1);*/
                            l=i;
                            previous = i;
                            g++;
                            break;
                        }
                    }


                    counter0 = counter;
                    counter++;

                    Log.i("earray",earray.toString());
                    Log.i("earray1",earray1.toString());
                    Log.i("ta", ta.toString());
                    Log.i("queue", queue.toString());
                    Log.i("te", te.toString());
                    Log.i("ft", ft.toString());
                    Log.i("fa", fa.toString());
                    Log.i("fe", fe.toString());
                    Log.i("cou", cou.toString());
                    Log.i("IOI", IOI.toString());
                    Log.i("IOF", IOF.toString());
                    Log.i("IOT", IOT.toString());
                    Log.i("counter0", String.valueOf(counter0));
                    Log.i("counter", String.valueOf(counter));


                    try {
                        ta.remove(0);
                        queue.remove(0);
                        te.remove(0);
                    }catch (Exception ignored){

                    }


                    Log.i("After removal", "removed");
                    Log.i("ta", ta.toString());
                    Log.i("queue", queue.toString());
                    Log.i("te", te.toString());
                    Log.i("end","here");
                    m++;
                }catch (Exception e){
                    Log.i("Problem",e.getMessage());
                    if(counter0==20 && counter==21){
                        e.printStackTrace();
                    }
                    Log.i("In catch","counter"+counter);
                    if(row==2){
                        counter=aarray.get(1);
                    }
                    else{
                        counter++;
                    }
                    p=1;
                }
                try {
                    /*for (int i = row - 1; i < 2 * (row - 1); i++) {
                        if (!end.get(i)) {
                            k = 0;
                            break;
                        }
                    }*/
                    for(int i=0;i<row-1;i++){
                        if(cou.get(i)!=2){
                            k=0;
                            break;
                        }
                    }
                }catch (Exception e){
                    k=0;
                }
                count++;
            }
            intent.putIntegerArrayListExtra("id",fi);
            intent.putStringArrayListExtra("PN", ft);
            intent.putIntegerArrayListExtra("BT", fe);
            intent.putIntegerArrayListExtra("AT",fa);
            intent.putIntegerArrayListExtra("IOI",IOI);
            intent.putIntegerArrayListExtra("IOF",IOF);
            intent.putStringArrayListExtra("IOT",IOT);
            intent.putExtra("process",row-1);
            intent.putIntegerArrayListExtra("carray",carray);
            startActivity(intent);
        }
    }




    @SuppressLint("SetTextI18n")
    public void add(View view){

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
            editText[1][2] = findViewById(R.id.editText34);
            editText[1][3] = findViewById(R.id.editText35);
            textView[1][0].setVisibility(View.VISIBLE);
            editText[1][0].setVisibility(View.VISIBLE);
            editText[1][1].setVisibility(View.VISIBLE);
            editText[1][2].setVisibility(View.VISIBLE);
            editText[1][3].setVisibility(View.VISIBLE);
            textView[1][0].setTag("1");
        }
        if(row==4){
            textView[2][0] = findViewById(R.id.textView41);
            editText[2][0] = findViewById(R.id.editText42);
            editText[2][1] = findViewById(R.id.editText43);
            editText[2][2] = findViewById(R.id.editText44);
            editText[2][3] = findViewById(R.id.editText45);
            textView[2][0].setVisibility(View.VISIBLE);
            editText[2][0].setVisibility(View.VISIBLE);
            editText[2][1].setVisibility(View.VISIBLE);
            editText[2][2].setVisibility(View.VISIBLE);
            editText[2][3].setVisibility(View.VISIBLE);
            textView[2][0].setTag("2");
        }
        if(row==5){
            textView[3][0] = findViewById(R.id.textView51);
            editText[3][0] = findViewById(R.id.editText52);
            editText[3][1] = findViewById(R.id.editText53);
            editText[3][2] = findViewById(R.id.editText54);
            editText[3][3] = findViewById(R.id.editText55);
            textView[3][0].setVisibility(View.VISIBLE);
            editText[3][0].setVisibility(View.VISIBLE);
            editText[3][1].setVisibility(View.VISIBLE);
            editText[3][2].setVisibility(View.VISIBLE);
            editText[3][3].setVisibility(View.VISIBLE);
            textView[3][0].setTag("3");
        }
        if(row==6){
            textView[4][0] = findViewById(R.id.textView61);
            editText[4][0] = findViewById(R.id.editText62);
            editText[4][1] = findViewById(R.id.editText63);
            editText[4][2] = findViewById(R.id.editText64);
            editText[4][3] = findViewById(R.id.editText65);
            textView[4][0].setVisibility(View.VISIBLE);
            editText[4][0].setVisibility(View.VISIBLE);
            editText[4][1].setVisibility(View.VISIBLE);
            editText[4][2].setVisibility(View.VISIBLE);
            editText[4][3].setVisibility(View.VISIBLE);
            textView[4][0].setTag("4");
        }
        if(row==7){
            textView[5][0] = findViewById(R.id.textView71);
            editText[5][0] = findViewById(R.id.editText72);
            editText[5][1] = findViewById(R.id.editText73);
            editText[5][2] = findViewById(R.id.editText74);
            editText[5][3] = findViewById(R.id.editText75);
            textView[5][0].setVisibility(View.VISIBLE);
            editText[5][0].setVisibility(View.VISIBLE);
            editText[5][1].setVisibility(View.VISIBLE);
            editText[5][2].setVisibility(View.VISIBLE);
            editText[5][3].setVisibility(View.VISIBLE);
            textView[5][0].setTag("5");
        }
        if(row==8){
            textView[6][0] = findViewById(R.id.textView81);
            editText[6][0] = findViewById(R.id.editText82);
            editText[6][1] = findViewById(R.id.editText83);
            editText[6][2] = findViewById(R.id.editText84);
            editText[6][3] = findViewById(R.id.editText85);
            textView[6][0].setVisibility(View.VISIBLE);
            editText[6][0].setVisibility(View.VISIBLE);
            editText[6][1].setVisibility(View.VISIBLE);
            editText[6][2].setVisibility(View.VISIBLE);
            editText[6][3].setVisibility(View.VISIBLE);
            textView[6][0].setTag("6");
        }
        if(row==9){
            textView[7][0] = findViewById(R.id.textView91);
            editText[7][0] = findViewById(R.id.editText92);
            editText[7][1] = findViewById(R.id.editText93);
            editText[7][2] = findViewById(R.id.editText94);
            editText[7][3] = findViewById(R.id.editText95);
            textView[7][0].setVisibility(View.VISIBLE);
            editText[7][0].setVisibility(View.VISIBLE);
            editText[7][1].setVisibility(View.VISIBLE);
            editText[7][2].setVisibility(View.VISIBLE);
            editText[7][3].setVisibility(View.VISIBLE);
            textView[7][0].setTag("7");
        }
        if(row==10){
            textView[8][0] = findViewById(R.id.textView101);
            editText[8][0] = findViewById(R.id.editText102);
            editText[8][1] = findViewById(R.id.editText103);
            editText[8][2] = findViewById(R.id.editText104);
            editText[8][3] = findViewById(R.id.editText105);
            textView[8][0].setVisibility(View.VISIBLE);
            editText[8][0].setVisibility(View.VISIBLE);
            editText[8][1].setVisibility(View.VISIBLE);
            editText[8][2].setVisibility(View.VISIBLE);
            editText[8][3].setVisibility(View.VISIBLE);
            textView[8][0].setTag("8");
        }

    }

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
        setContentView(R.layout.activity_i__f_c_f_s);
        editText = new EditText[10][4];
        textView = new TextView[10][2];
        row=2;
        setTitle("SRTF");
    }
}