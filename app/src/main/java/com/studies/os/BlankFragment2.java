package com.studies.os;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment2 extends Fragment {

    ArrayList<String> tarray = new ArrayList<>();
    ArrayList<Integer> earray = new ArrayList<>();
    ArrayList<Integer> aarray = new ArrayList<>();
    ArrayList<Integer> ids = new ArrayList<>();
    ArrayList<Integer> carray = new ArrayList<>();
    ArrayList<Integer> all_times = new ArrayList<>();
    ArrayList<Integer> basic = new ArrayList<>();
    ArrayList<Integer> taba = new ArrayList<>();
    ArrayList<Integer> tabe = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment2 newInstance(String param1, String param2) {
        BlankFragment2 fragment = new BlankFragment2();
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

        View v = inflater.inflate(R.layout.fragment_blank2, container, false);


        int total=0;

        TextView[][] textView = new TextView[10][4];


        textView[1][0] = v.findViewById(R.id.textView21);
        textView[1][1] = v.findViewById(R.id.textView22);
        textView[1][2] = v.findViewById(R.id.textView23);
        textView[1][3]= v.findViewById(R.id.textView24);

        textView[2][0] = v.findViewById(R.id.textView31);
        textView[2][1] = v.findViewById(R.id.textView32);
        textView[2][2] = v.findViewById(R.id.textView33);
        textView[2][3] = v.findViewById(R.id.textView34);

        textView[3][0] = v.findViewById(R.id.textView41);
        textView[3][1] = v.findViewById(R.id.textView42);
        textView[3][2] = v.findViewById(R.id.textView43);
        textView[3][3]= v.findViewById(R.id.textView44);

        textView[4][0] = v.findViewById(R.id.textView51);
        textView[4][1] = v.findViewById(R.id.textView52);
        textView[4][2] = v.findViewById(R.id.textView53);
        textView[4][3]= v.findViewById(R.id.textView54);

        textView[5][0] = v.findViewById(R.id.textView61);
        textView[5][1] = v.findViewById(R.id.textView62);
        textView[5][2] = v.findViewById(R.id.textView63);
        textView[5][3]= v.findViewById(R.id.textView64);

        textView[6][0] = v.findViewById(R.id.textView71);
        textView[6][1] = v.findViewById(R.id.textView72);
        textView[6][2] = v.findViewById(R.id.textView73);
        textView[6][3]= v.findViewById(R.id.textView74);

        textView[7][0] = v.findViewById(R.id.textView81);
        textView[7][1] = v.findViewById(R.id.textView82);
        textView[7][2] = v.findViewById(R.id.textView83);
        textView[7][3]= v.findViewById(R.id.textView84);

        textView[8][0] = v.findViewById(R.id.textView91);
        textView[8][1] = v.findViewById(R.id.textView92);
        textView[8][2] = v.findViewById(R.id.textView93);
        textView[8][3]= v.findViewById(R.id.textView94);

        textView[9][0] = v.findViewById(R.id.textView101);
        textView[9][1] = v.findViewById(R.id.textView102);
        textView[9][2] = v.findViewById(R.id.textView103);
        textView[9][3]= v.findViewById(R.id.textView104);



        Tabbed tabbed = (Tabbed) getActivity();

        Bundle bundle = tabbed.Data();

        int counter = bundle.getInt("process");
        int table = bundle.getInt("table");

        if(table==0){
           carray= bundle.getIntegerArrayList("carray");
        }

        taba = bundle.getIntegerArrayList("taba");
        tabe = bundle.getIntegerArrayList("tabe");

        Log.i("carray",carray.toString());
        Log.i("counter",String.valueOf(counter));

       /* textView[1][0].setVisibility(View.VISIBLE);
        textView[1][1].setVisibility(View.VISIBLE);
        textView[1][2].setVisibility(View.VISIBLE);
        textView[1][3].setVisibility(View.VISIBLE);*/


        for(int i=1;i<=counter;i++){
            for(int j=0;j<=3;j++) {
                textView[i][1].setText(String.valueOf(carray.get(i-1)));
                textView[i][2].setText(String.valueOf(carray.get(i-1)-taba.get(i-1)));
                textView[i][3].setText(String.valueOf(carray.get(i-1)-taba.get(i-1)-tabe.get(i-1)));
                if(i==counter){
                    if(j==3){
                       // textView[i][j].setBackgroundResource(0);
                        textView[i][j].setBackgroundResource(R.drawable.border3);
                    }
                    else {
                        //textView[i][j].setBackgroundResource(0);
                        textView[i][j].setBackgroundResource(R.drawable.border4);
                    }
                }
                textView[i][j].setVisibility(View.VISIBLE);
            }
        }


        return v;
    }
}