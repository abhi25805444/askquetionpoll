package com.example.askquestionpoll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RadiobuttonsActivity extends AppCompatActivity {
    private RadioGroup radioGroupstate1, radioGroupstate2, radioGroupstate3, radioGroup4to6;
    private RadioButton radioButton1,radioButton2,radioButton3;

    String Res4to6="";
    String Resstate="";
    String rb1="";
    String rb2="";
    String rb3="";


    private  TextView textView;
    private  TextView textView1;
    private  TextView textView2;
    private  TextView textView3;
    private  TextView textView4;



    String [] output=new String[4];

    private Button btn_display;
    ArrayList <String> arrayList=new ArrayList<String>();
    String display="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobuttons);
        ArrayList<String> arrayList=new <String>ArrayList();
        textView=findViewById(R.id.displaytxt);
        textView1=findViewById(R.id.displaytxt1);
        textView2=findViewById(R.id.displaytxt2);
        textView3=findViewById(R.id.displaytxt3);
        textView4=findViewById(R.id.displaytxt4);


        radioGroupstate1 = findViewById(R.id.radiogroupstate1);
        radioGroupstate2 = findViewById(R.id.radiogroupstate2);
        radioGroupstate3 = findViewById(R.id.radiogroupstate3);
        radioGroup4to6=findViewById(R.id.rdiougroup4to6);
        btn_display=findViewById(R.id.btn_display);

        radioButton1=findViewById(R.id.radio1);
        radioButton2=findViewById(R.id.radio2);
        radioButton3=findViewById(R.id.radio3);




        radioGroupstate1.setOnCheckedChangeListener(createCheckedChangeListener());
        radioGroupstate2.setOnCheckedChangeListener(createCheckedChangeListener());
        radioGroupstate3.setOnCheckedChangeListener(createCheckedChangeListener());

        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                textView1.setText(radioButton1.getText());
                rb1=radioButton1.getText().toString();
            }
        });

            radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    textView2.setText(radioButton2.getText());
                    rb2=radioButton2.getText().toString();
                }
            });
        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                textView4.setText(radioButton3.getText());
                rb3=radioButton1.getText().toString();
            }
        });


        radioGroup4to6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioGroup4to6.getCheckedRadioButtonId() != -1)
                {
                    RadioButton radioButton1=findViewById(radioGroup4to6.getCheckedRadioButtonId());
                    resultof4to6(radioButton1.getText().toString());
                    textView3.setText(radioButton1.getText());


                }
            }
        });


        btn_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setVisibility(View.VISIBLE);
                String finalres="";
                if(!rb1.equals(""))
                {
                    finalres=finalres+rb1+"\n";
                }
                if(!rb2.equals(""))
                {
                    finalres=finalres+rb2+"\n";
                }
                if(!rb3.equals(""))
                {
                    finalres=finalres+rb3+"\n";
                }
                if(!Res4to6.equals(""))
                {
                    finalres=finalres+Res4to6+"\n";
                }
                if(!Resstate.equals(""))
                {
                    finalres=finalres+Resstate+"\n";
                }

                textView1.setText(finalres);


                System.out.println(finalres);

            }
        });
    }

    private RadioGroup.OnCheckedChangeListener createCheckedChangeListener() {
        return new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup1, int checkedId) {
                if (checkedId != -1) {

                    uncheckOtherRadioGroups(radioGroup1);
                }
            }
        };
    }

  public void resultof4to6(String r)
  {
      Res4to6=r;
  }

    public void resultofstate(String r)
    {
        Resstate=r;
    }

    private void uncheckOtherRadioGroups(RadioGroup currentGroup) {
        if (currentGroup != radioGroupstate1) {
            radioGroupstate1.setOnCheckedChangeListener(null);
            radioGroupstate1.clearCheck();
            radioGroupstate1.setOnCheckedChangeListener(createCheckedChangeListener());
        }
        if (currentGroup != radioGroupstate2) {
            radioGroupstate2.setOnCheckedChangeListener(null);
            radioGroupstate2.clearCheck();
            radioGroupstate2.setOnCheckedChangeListener(createCheckedChangeListener());
        }
        if (currentGroup != radioGroupstate3) {
            radioGroupstate3.setOnCheckedChangeListener(null);
            radioGroupstate3.clearCheck();
            radioGroupstate3.setOnCheckedChangeListener(createCheckedChangeListener());
        }
        RadioButton radioButton=findViewById(currentGroup.getCheckedRadioButtonId());
        resultofstate(radioButton.getText().toString());
        textView.setText(radioButton.getText().toString());
    }
}
