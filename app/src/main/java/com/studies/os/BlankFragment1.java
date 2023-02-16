package com.studies.os;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.gridlayout.widget.GridLayout;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

public class BlankFragment1 extends Fragment {

    View v;

    ArrayList<String> tarray = new ArrayList<>();
    ArrayList<Integer> earray = new ArrayList<>();
    ArrayList<Integer> aarray = new ArrayList<>();
    ArrayList<Integer> all_times = new ArrayList<>();
    ArrayList<Integer> basic = new ArrayList<>();
    ArrayList<Integer> ids = new ArrayList<>();
    ArrayList<Integer> carray = new ArrayList<>();
    ArrayList<Integer> tatarray = new ArrayList<>();
    ArrayList<Integer> wtarray = new ArrayList<>();

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


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment1() {
        // Required empty public constructor
    }

    public static BlankFragment1 newInstance(String param1, String param2) {
        BlankFragment1 fragment = new BlankFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v= inflater.inflate(R.layout.fragment_blank1, container, false);

        textViews = new TextView[120];
        time=-1;
        //thread = new mythread[30];
        t = v.findViewById(R.id.textView122);

        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.right);

        Tabbed tabbed = (Tabbed) getActivity();

        Bundle bundle = tabbed.Data();

        if(bundle==null){
            Log.i("bundle","null");
        }
        Log.i("here",bundle.getStringArrayList("PN").toString());
        Log.i("here",bundle.getIntegerArrayList("BT").toString());

        //  counter = intent.getIntExtra("counter",0);
        tarray = bundle.getStringArrayList("PN");
        earray = bundle.getIntegerArrayList("BT");
        aarray = bundle.getIntegerArrayList("AT");
        ids = bundle.getIntegerArrayList("id");
        Log.i("hers",bundle.getIntegerArrayList("AT").toString());

        Log.i("tarray in 1",tarray.toString());
        Log.i("earray",earray.toString());
        Log.i("aarray",aarray.toString());
        Log.i("iarray",ids.toString());


        textViews[0] = v.findViewById(R.id.textView1);
        textViews[1] = v.findViewById(R.id.textView2);
        textViews[2] = v.findViewById(R.id.textView3);
        textViews[3] = v.findViewById(R.id.textView4);
        textViews[4] = v.findViewById(R.id.textView5);
        textViews[5] = v.findViewById(R.id.textView6);
        textViews[6] = v.findViewById(R.id.textView7);
        textViews[7] = v.findViewById(R.id.textView8);
        textViews[8] = v.findViewById(R.id.textView9);textViews[9] = v.findViewById(R.id.textView10);textViews[10] = v.findViewById(R.id.textView11);
        textViews[11] = v.findViewById(R.id.textView12);
        textViews[12] = v.findViewById(R.id.textView13);
        textViews[13] = v.findViewById(R.id.textView14);
        textViews[14] = v.findViewById(R.id.textView15);
        textViews[15] = v.findViewById(R.id.textView16);
        textViews[16] = v.findViewById(R.id.textView17);textViews[17] = v.findViewById(R.id.textView18);
        textViews[18] = v.findViewById(R.id.textView19);
        textViews[19] = v.findViewById(R.id.textView20);
        textViews[20] = v.findViewById(R.id.textView21);
        textViews[21] = v.findViewById(R.id.textView22);
        textViews[22] = v.findViewById(R.id.textView23);
        textViews[23] = v.findViewById(R.id.textView24);
        textViews[24] = v.findViewById(R.id.textView25);
        textViews[25] = v.findViewById(R.id.textView26);
        textViews[26] = v.findViewById(R.id.textView27);textViews[27] = v.findViewById(R.id.textView28);textViews[28] = v.findViewById(R.id.textView29);
        textViews[29] = v.findViewById(R.id.textView30);
        textViews[30] = v.findViewById(R.id.textView31);
        textViews[31] = v.findViewById(R.id.textView32);
        textViews[32] = v.findViewById(R.id.textView33);
        textViews[33] = v.findViewById(R.id.textView34);
        textViews[34] = v.findViewById(R.id.textView35);textViews[35] = v.findViewById(R.id.textView36);
        textViews[36] = v.findViewById(R.id.textView37);
        textViews[37] = v.findViewById(R.id.textView38);
        textViews[38] = v.findViewById(R.id.textView39);
        textViews[39] = v.findViewById(R.id.textView40);
        textViews[40] = v.findViewById(R.id.textView41);
        textViews[41] = v.findViewById(R.id.textView42);
        textViews[42] = v.findViewById(R.id.textView43);
        textViews[43] = v.findViewById(R.id.textView44);
        textViews[44] = v.findViewById(R.id.textView45);textViews[45] = v.findViewById(R.id.textView46);textViews[46] = v.findViewById(R.id.textView47);
        textViews[47] = v.findViewById(R.id.textView48);
        textViews[48] = v.findViewById(R.id.textView49);
        textViews[49] = v.findViewById(R.id.textView50);
        textViews[50] = v.findViewById(R.id.textView51);
        textViews[51] = v.findViewById(R.id.textView52);
        textViews[52] = v.findViewById(R.id.textView53);textViews[53] = v.findViewById(R.id.textView54);
        textViews[54] = v.findViewById(R.id.textView55);
        textViews[55] = v.findViewById(R.id.textView56);
        textViews[56] = v.findViewById(R.id.textView57);
        textViews[57] = v.findViewById(R.id.textView58);
        textViews[58] = v.findViewById(R.id.textView59);textViews[59] = v.findViewById(R.id.textView60);
        textViews[60] = v.findViewById(R.id.textView61);
        textViews[61] = v.findViewById(R.id.textView62);
        textViews[62] = v.findViewById(R.id.textView63);
        textViews[63] = v.findViewById(R.id.textView64);
        textViews[64] = v.findViewById(R.id.textView65);textViews[65] = v.findViewById(R.id.textView66);textViews[66]= v.findViewById(R.id.textView67);
        textViews[67] = v.findViewById(R.id.textView68);
        textViews[68] = v.findViewById(R.id.textView69);
        textViews[69] = v.findViewById(R.id.textView70);
        textViews[70] = v.findViewById(R.id.textView71);
        textViews[71] = v.findViewById(R.id.textView72);
        textViews[72] = v.findViewById(R.id.textView73);textViews[73] = v.findViewById(R.id.textView74);
        textViews[74] = v.findViewById(R.id.textView75);
        textViews[75] = v.findViewById(R.id.textView76);
        textViews[76] = v.findViewById(R.id.textView77);
        textViews[77] = v.findViewById(R.id.textView78);
        textViews[78] = v.findViewById(R.id.textView79);textViews[79] = v.findViewById(R.id.textView80);

        textViews[80] = v.findViewById(R.id.textView81);
        textViews[81] = v.findViewById(R.id.textView82);
        textViews[82] = v.findViewById(R.id.textView83);
        textViews[83] = v.findViewById(R.id.textView84);
        textViews[84] = v.findViewById(R.id.textView85);textViews[85] = v.findViewById(R.id.textView86);textViews[86] = v.findViewById(R.id.textView87);
        textViews[87] = v.findViewById(R.id.textView88);
        textViews[88] = v.findViewById(R.id.textView89);
        textViews[89] = v.findViewById(R.id.textView90);
        textViews[90] = v.findViewById(R.id.textView91);
        textViews[91] = v.findViewById(R.id.textView92);
        textViews[92] = v.findViewById(R.id.textView93);textViews[93] = v.findViewById(R.id.textView94);
        textViews[94] = v.findViewById(R.id.textView95);
        textViews[95] = v.findViewById(R.id.textView96);
        textViews[96] = v.findViewById(R.id.textView97);
        textViews[97] = v.findViewById(R.id.textView98);
        textViews[98] = v.findViewById(R.id.textView99);textViews[99] = v.findViewById(R.id.textView100);
        textViews[100] = v.findViewById(R.id.textView101);
        textViews[101] = v.findViewById(R.id.textView102);
        textViews[102] = v.findViewById(R.id.textView103);
        textViews[103] = v.findViewById(R.id.textView104);
        textViews[104] = v.findViewById(R.id.textView105);textViews[105] = v.findViewById(R.id.textView106);textViews[106]= v.findViewById(R.id.textView107);
        textViews[107] = v.findViewById(R.id.textView108);
        textViews[108] = v.findViewById(R.id.textView109);
        textViews[109] = v.findViewById(R.id.textView110);
        textViews[110] = v.findViewById(R.id.textView111);
        textViews[111] = v.findViewById(R.id.textView112);
        textViews[112] = v.findViewById(R.id.textView113);textViews[113] = v.findViewById(R.id.textView114);
        textViews[114] = v.findViewById(R.id.textView115);
        textViews[115] = v.findViewById(R.id.textView116);
        textViews[116] = v.findViewById(R.id.textView117);
        textViews[117] = v.findViewById(R.id.textView118);
        textViews[118] = v.findViewById(R.id.textView119);textViews[119] = v.findViewById(R.id.textView120);


        int k=0;
        for(int i=0; k<earray.size();i++){
            textViews[b].setVisibility(View.VISIBLE);
            textViews[b+40].setVisibility(View.VISIBLE);
            textViews[b+80].setVisibility(View.VISIBLE);
            textViews[b].setAlpha(0);
            textViews[b+40].setAlpha(0);
            textViews[b+80].setAlpha(0);
            // t.setText(String.valueOf(earray.get(0)));
            if(i == aarray.get(k) || i>aarray.get(k)) {
                textViews[b].setText(tarray.get(k));
                textViews[b + 40].setText(String.valueOf(earray.get(k)));
                all_times.add(earray.get(k));
                total = total + earray.get(k);
                carray.add(total);
                textViews[b+80].setText(String.valueOf(total));
                basic.add(total);
                Log.i("corresponding numbers",String.valueOf(total));
                // thread[b] = new mythread(textViews[b],earray.get(k),textViews[b+30],animation);
                i=i+earray.get(k)-1;
                k++;
            }
            else{
                textViews[b].setText("-");
                textViews[b + 40].setText(String.valueOf(aarray.get(k)-i));
                all_times.add(aarray.get(k)-i);
                total = total + aarray.get(k)-i;
                textViews[b+80].setText(String.valueOf(total));
                basic.add(total);
                Log.i("corresponding numbers",String.valueOf(total));
                // thread[b] = new mythread(textViews[b],aarray.get(k)-i,textViews[b+30],animation);
                i=aarray.get(k)-1;
            }
            b++;
            Log.i("boxes",String.valueOf(b));
            size=i;
        }
       /* AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f,1.0f);
        alphaAnimation.setDuration(3000);
        g.startAnimation(alphaAnimation);*/

       /*for(int i=0;i<size;i++){
           thread[i] = new mythread(textViews[i],Integer.valueOf(String.valueOf(textViews[i+30])),textViews[i+30]);
       }*/

       /*thread[0] = new mythread(textViews[0],earray.get(0),textViews[9]);
       thread[1] = new mythread(textViews[1],earray.get(1),textViews[10]);*/
        try{
            ArrayList<String> tft = bundle.getStringArrayList("tft");
            ArrayList<Integer> tfe = bundle.getIntegerArrayList("tfe");
            ArrayList<Integer> tfa = bundle.getIntegerArrayList("tfa");
            ArrayList<Integer> tfee = bundle.getIntegerArrayList("tfee");

            for(int i=0; i<ids.size();i++){
                for(int j=i+1; j<ids.size();j++) {
                    if (ids.get(i) > ids.get(j)) {
                        String temp = tft.get(i);
                        int temp1 = ids.get(i);
                        int temp2 = tfe.get(i);
                        // int temp3 = tfa.get(i);
                        //  int temp4 = tfee.get(i);
                        tft.set(i,tft.get(j));
                        ids.set(i,ids.get(j));
                        tfe.set(i,tfe.get(j));
                        // tfa.set(i, tfa.get(j));
                        //  tfee.set(i,tfee.get(j));
                        tft.set(j,temp);
                        ids.set(j,temp1);
                        tfe.set(j,temp2);
                        //tfa.set(j,temp3);
                        //  tfee.set(j,temp4);
                    }
                }
            }

            for(int i=0;i<ids.size();i++){
                tatarray.add(tfe.get(i)-tfa.get(i));
                wtarray.add(tatarray.get(i)-tfee.get(i));
            }



            Log.i("process names", tft.toString());
            Log.i("arrival time", tfa.toString());
            Log.i("completion time", tfe.toString());
            Log.i("TAT time", tatarray.toString());
            Log.i("WT time", wtarray.toString());

        }
        catch (Exception e) {

            for (int i = 0; i < ids.size(); i++) {
                for (int j = i + 1; j < ids.size(); j++) {
                    if (ids.get(i) > ids.get(j)) {
                        String temp = tarray.get(i);
                        int temp1 = ids.get(i);
                        int temp2 = carray.get(i);
                        int temp3 = aarray.get(i);
                        int temp4 = earray.get(i);
                        tarray.set(i, tarray.get(j));
                        ids.set(i, ids.get(j));
                        carray.set(i, carray.get(j));
                        aarray.set(i, aarray.get(j));
                        earray.set(i, earray.get(j));
                        tarray.set(j, temp);
                        ids.set(j, temp1);
                        carray.set(j, temp2);
                        aarray.set(j, temp3);
                        earray.set(j, temp4);
                    }
                }
            }

            for (int i = 0; i < aarray.size(); i++) {
                tatarray.add(carray.get(i) - aarray.get(i));
                wtarray.add(tatarray.get(i) - earray.get(i));
            }

            /*BlankFragment2 blankFragment2 = new BlankFragment2();
            Bundle bundle1 = new Bundle();
            bundle1.putIntegerArrayList("carray",carray);
            blankFragment2.setArguments(bundle1);
            getParentFragmentManager().beginTransaction().replace(R.id.lay,blankFragment2).commit();*/

            Log.i("process names", tarray.toString());
            Log.i("completion time", carray.toString());
            Log.i("TAT time", tatarray.toString());
            Log.i("WT time", wtarray.toString());
        }

        try{

            IOI = bundle.getIntegerArrayList("IOI");
            IOF = bundle.getIntegerArrayList("IOF");
            IOT = bundle.getStringArrayList("IOT");
            counter = bundle.getInt("process",0);

        }
        catch (Exception e){
            Log.i("Hello","Moto");
        }
        Log.i("times",String.valueOf(all_times));
        time(all_times.get(0));
        /*for(int i=0; i<1;i++){
            textViews[i].animate().alpha(1).setDuration(earray.get(i)*800);
            textViews[i+30].animate().alpha(1).setDuration(earray.get(i)*800);
        }

        textViews[1].animate().alpha(1).setDuration(earray.get(1)*800);
        textViews[1+30].animate().alpha(1).setDuration(earray.get(1)*800);*/

        /*Handler handler = new Handler();
        long countdownInterval=790;
        Runnable runnable = new Runnable() {
            long millisInFuture = total * 790;
            @Override
            public void run() {
                if(millisInFuture >=0){
                    int x= (int) (millisInFuture /790);
                    t1.setText("Timer:"+(total-x));
                    millisInFuture -=countdownInterval;
                    handler.postDelayed(this, countdownInterval);
                }
            }
        };
        handler.postDelayed(runnable,countdownInterval);*/

        /*CountDownTimer countDownTimer = new CountDownTimer(counter*800,800) {
            int t=0;
            @Override
            public void onTick(long l) {
                t1.setText("Timer:"+t);
                t++;
            }

            @Override
            public void onFinish() {
                t1.setText("Timer:"+t);
            }
        };
        countDownTimer.start();*/

        return v;

    }

   /* public Bundle Datas(){
        Bundle bundle1 = new Bundle();

        return bundle1;
    }*/


    public void time(int ft){
        //thread[k].start();
        final float scale = this.getResources().getDisplayMetrics().density;
        int p = (int) (100*ft*scale+0.5f);
        textViews[k].setAlpha(1);
        textViews[k+40].setAlpha(1);
        textViews[k].setMinWidth(p);
        Animation animation =AnimationUtils.loadAnimation(getContext(),R.anim.right);
        animation.setDuration(ft*800);
        textViews[k].startAnimation(animation);
        textViews[k+40].startAnimation(animation);
        /*YoYo.with(Techniques.SlideInLeft)
                .duration(ft*800)
                .playOn(textViews[k]);*/
       /* YoYo.with(Techniques.SlideInLeft)
                .duration(ft*800)
                .playOn(textViews[k+30]);*/
        final CountDownTimer countDownTimer = new CountDownTimer(ft*800,800) {
            @Override
            public void onTick(long l) {
                //  t1.setText("Timer:"+time);
                time++;
                Log.i("time", String.valueOf(time));
                text.clear();
                for(int i=0;i<counter;i++){
                    try {
                        if (time >= IOI.get(i) && time < IOF.get(i)) {
                            text.add(IOT.get(i));
                        }
                    }catch (Exception ignored){

                    }
                    if(!text.isEmpty()) {
                        t.setText("Processes in IO :" + text.toString());
                    }else{
                        t.setText("Processes in IO :");
                    }
                }
                Log.i("IN IO",text.toString());
            }

            @Override
            public void onFinish() {
                Log.i("here","Finish");
                //    t1.setText("Timer:"+time);
                Log.i("time", String.valueOf(time));
                text.clear();
                for(int i=0;i<counter;i++){
                    try {
                        if (time >= IOI.get(i) && time < IOF.get(i)) {
                            text.add(IOT.get(i));
                        }
                    }catch (Exception ignored){

                    }
                    if(!text.isEmpty()) {
                        t.setText("Processes in IO :" + text.toString());
                    }else{
                        t.setText("Processes in IO :");
                    }
                }
                Log.i("IN IO",text.toString());
                textViews[k+80].setAlpha(1);
                k++;
                if(k<b) {
                    try {
                        time(all_times.get(k));
                    }catch (Exception ignored){

                    }
                }
            }
        };
        countDownTimer.start();
    }
}