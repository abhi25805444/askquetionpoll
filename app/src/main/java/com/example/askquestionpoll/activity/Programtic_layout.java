package com.example.askquestionpoll.activity;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.askquestionpoll.R;

public class Programtic_layout extends AppCompatActivity {
    EditText editText;
    ImageView imageView;

    EditText editTextHeight;
    EditText editTextWidth;
    EditText editTextX;


    EditText editTextY;

    EditText editTextPadding;
    EditText editTextMargin;
    ScrollView scrollView;
    EditText editRotation;
    Button btnDone;

    RelativeLayout relativeLayoutMain;
    RelativeLayout realtivelayotSpace;
    int prevline=1;
    int line=1;

    int CurrentHeight;
    int CurrebtWidth;

    int CurrentHeightofImage;
    int CurrentHeightofEditdtext;
    TextView txtLeft;
    TextView txtRight;
    TextView txtTop;
    TextView txtBottom;
    TextView txtCenterVertical;
    TextView txtHorizontal;
    RelativeLayout.LayoutParams imageParams;
    RelativeLayout.LayoutParams editTextParams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup rootView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.activity_programtic_layout, null);
        setContentView(rootView);

        realtivelayotSpace = new RelativeLayout(this);
        txtLeft=findViewById(R.id.txtleft);
        txtRight=findViewById(R.id.txtright);
        txtTop=findViewById(R.id.txttop);
        txtBottom=findViewById(R.id.txtbottom);
        txtHorizontal=findViewById(R.id.txtcenterhorizotal);
        txtCenterVertical=findViewById(R.id.txtcentervertical);


        editTextHeight = rootView.findViewById(R.id.editHeight);
        editTextWidth = rootView.findViewById(R.id.editWidth);
        editTextX = rootView.findViewById(R.id.editX);

        btnDone = rootView.findViewById(R.id.btnDone);
        scrollView = findViewById(R.id.scrollview);
        editTextY = rootView.findViewById(R.id.editY);
        editTextPadding = rootView.findViewById(R.id.editPadding);
        editTextMargin = rootView.findViewById(R.id.editMargin);
        editRotation = rootView.findViewById(R.id.editRotation);
        editText = new EditText(this);
        imageView = new ImageView(this);
        this.relativeLayoutMain = findViewById(R.id.mainrev);
        RelativeLayout relativeLayout = new RelativeLayout(this);

        relativeLayout.setBackgroundColor(getColor(R.color.navyblue));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1000, 500);
        CurrebtWidth=1000;
        CurrentHeight=1000;
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        relativeLayout.setLayoutParams(layoutParams);



        editTextParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        CurrentHeightofEditdtext=200;


        imageParams = new RelativeLayout.LayoutParams(300,300);
        CurrentHeightofImage=300;




        imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        imageView.setLayoutParams(imageParams);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageResource(R.drawable.ask_question_logo);
        imageView.setId(View.generateViewId());
        Log.d(TAG, "Height of image"+imageView.getHeight());

        relativeLayout.setId(View.generateViewId());
        Log.d(TAG, "ID of Rev" + relativeLayout.getId());

        editText.setBackgroundColor(getColor(R.color.white));
        editText.setLayoutParams(editTextParams);
        editTextParams.addRule(RelativeLayout.BELOW, imageView.getId());
        editTextParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        editTextParams.setMargins(0,0,0,10);
        editText.setGravity(Gravity.CENTER);
        editText.setId(View.generateViewId());






        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int totalTextHeight = editText.getLayout().getHeight();
                int visibleHeight = editText.getHeight();
                Log.d(TAG, "onTextChanged: "+totalTextHeight+"visble : Z"+visibleHeight);
                prevline=line;
                line=editText.getLineCount();

                if (isTextHidden(editText)) {
                    editText.setTextSize((float) (editText.getTextSize() * 0.2));


                }
                if(prevline!=line)
                {
                    if(line>prevline)
                    {
                        int height=imageParams.height;
                        imageParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int) (imageView.getHeight()/2));
                        imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                        imageView.setLayoutParams(imageParams);
                    }
                    else {
                        if(imageView.getHeight()<CurrentHeightofImage)
                        {
                            int height=imageParams.height;
                            imageParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int) (imageView.getHeight()*2));
                            imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                            imageView.setLayoutParams(imageParams);
                        }


                    }
                }

                if (imageView.getHeight()<40) {
                    editText.setTextSize((float) (editText.getTextSize()*0.3));
                    imageParams = new RelativeLayout.LayoutParams(CurrentHeightofImage, CurrentHeightofImage);
                    imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    line=editText.getLineCount();
                    prevline=editText.getLineCount();

                    imageView.setLayoutParams(imageParams);
                    editTextParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, CurrentHeightofEditdtext);
                    editTextParams.addRule(RelativeLayout.BELOW, imageView.getId());
                    editTextParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    editTextParams.setMargins(0,0,0,10);
                    editText.setGravity(Gravity.CENTER);
                    editText.setLayoutParams(editTextParams);


                }



            }


            @Override
            public void afterTextChanged(Editable editable) {

            }

        });


        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int Height;
                int Width;
                int x;
                int y;
                int padding;
                int margin;
                int Rotation;
                if (!editTextHeight.getText().toString().isEmpty()) {

                    Height = Integer.parseInt(editTextHeight.getText().toString());
                    RelativeLayout.LayoutParams updatedlayoutParams = new RelativeLayout.LayoutParams(CurrebtWidth, Height);


                    CurrentHeight = Height;
                    editTextParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
                    imageParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int) (Height*0.6));
                    CurrentHeightofImage= (int) (Height*0.6);
                    imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    imageView.setLayoutParams(imageParams);
                    imageView.setAdjustViewBounds(true);
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setImageResource(R.drawable.ask_question_logo);
                    imageView.setId(View.generateViewId());

                    relativeLayout.setId(View.generateViewId());
                    Log.d(TAG, "ID of Rev" + relativeLayout.getId());

                    editText.setBackgroundColor(getColor(R.color.white));
                    editText.setLayoutParams(editTextParams);
                    editTextParams.addRule(RelativeLayout.BELOW, imageView.getId());
                    editTextParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    editTextParams.setMargins(0, 0, 0, 10);
                    editText.setGravity(Gravity.CENTER);





                    if(!editText.getText().toString().isEmpty())
                        Log.d(TAG, "edittexth "+editText.getHeight()+"edittext lauoyt "+Height);
                    {
                        if(editText.getHeight()>Height)
                        {
                            editText.setTextSize((float) (imageView.getHeight()*0.04));

                        }
                        else {


                        }

                    }

                   /* RelativeLayout.LayoutParams editTextParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, CurrentHeight);
                    RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
*/

                  /*  layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);


                    imageView.setImageResource(R.drawable.ask_question_logo);
                    imageParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);

                    imageView.setLayoutParams(imageParams);
                    imageView.setId(View.generateViewId());


                    editTextParams.addRule(RelativeLayout.BELOW, imageView.getId());
                    editTextParams.setMargins(0, 0, 0, 30);
                    editText.setLayoutParams(editTextParams);*/
                    relativeLayout.setLayoutParams(updatedlayoutParams);



                }
                if (!editTextWidth.getText().toString().isEmpty()) {
                    Width = Integer.parseInt(editTextWidth.getText().toString());
                    RelativeLayout.LayoutParams updatedlayoutParams = new RelativeLayout.LayoutParams(Width, CurrentHeight);
                    CurrebtWidth = Width;
                    editTextParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    imageParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, Width / 5);
                    imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    imageView.setLayoutParams(imageParams);
                    imageView.setAdjustViewBounds(true);
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setImageResource(R.drawable.ask_question_logo);
                    imageView.setId(View.generateViewId());

                    relativeLayout.setId(View.generateViewId());
                    Log.d(TAG, "ID of Rev" + relativeLayout.getId());

                    editText.setBackgroundColor(getColor(R.color.white));
                    editText.setLayoutParams(editTextParams);
                    editTextParams.addRule(RelativeLayout.BELOW, imageView.getId());
                    editTextParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    editTextParams.setMargins(0, 0, 0, 10);
                    editText.setGravity(Gravity.CENTER);
                    if(!editText.getText().toString().isEmpty())
                        Log.d(TAG, "edittexth "+editText.getHeight()+"edittext lauoyt "+CurrentHeight);
                    {
                        if(editText.getHeight()>CurrentHeight)
                        {
                            editText.setTextSize((float) (imageView.getHeight()*0.04));
                        }

                    }


                    relativeLayout.setLayoutParams(updatedlayoutParams);


                }
                if (!editTextX.getText().toString().isEmpty()) {
                    x = Integer.parseInt(editTextX.getText().toString());
                    relativeLayout.setX(x);
                }
                if (!editTextY.getText().toString().isEmpty()) {
                    y = Integer.parseInt(editTextY.getText().toString());
                    relativeLayout.setY(y);
                }
                if (!editTextPadding.getText().toString().isEmpty()) {
                    padding = Integer.parseInt(editTextPadding.getText().toString());

                    relativeLayout.setPadding(padding, padding, padding, padding);
                }
                if (!editTextMargin.getText().toString().isEmpty()) {
                    margin = Integer.parseInt(editTextMargin.getText().toString());
                    RelativeLayout.LayoutParams updatedlayoutParams = new RelativeLayout.LayoutParams(CurrebtWidth, CurrentHeight);
                    updatedlayoutParams.setMargins(margin, margin, margin, margin);

                    relativeLayout.setLayoutParams(updatedlayoutParams);

                }

                if (!editRotation.getText().toString().isEmpty()) {
                    Rotation = Integer.parseInt(editRotation.getText().toString());
                    relativeLayout.setRotation(Rotation);

                }


            }
        });


        Log.d(TAG, "Image id" + imageView.getId());
        Log.d(TAG, "Image id" + editText.getId());
        relativeLayout.addView(editText);
        relativeLayout.addView(imageView);

        txtLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                relativeLayout.setX(0);
            }
        });
        txtRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                relativeLayout.setX((float) (((RelativeLayout) relativeLayout.getParent()).getWidth())-relativeLayout.getWidth());
            }
        });
        txtTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayout.setY(0);
            }
        });
        txtBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                relativeLayout.setY((float) (((RelativeLayout) relativeLayout.getParent()).getHeight())-relativeLayout.getHeight());
            }
        });
        txtHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                relativeLayout.setX(((float) (((RelativeLayout) relativeLayout.getParent()).getWidth())-relativeLayout.getWidth())/2);
            }
        });
        txtCenterVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                relativeLayout.setY((float) ((((RelativeLayout) relativeLayout.getParent()).getHeight())-relativeLayout.getHeight())/2);
            }
        });

        relativeLayout.setLayoutParams(layoutParams);
        Log.d(TAG, relativeLayout.toString());
        relativeLayoutMain.addView(relativeLayout);


    }

    private boolean isTextHidden(EditText editText) {
        int scrollY = editText.getScrollY() - 1;
        int totalTextHeight = editText.getLayout().getHeight() + 50;
        int visibleHeight = editText.getHeight();

        return scrollY >= 0 && totalTextHeight > visibleHeight;
    }

    private boolean isTextAdjustable(EditText editText) {
        int scrollY = editText.getScrollY() - 1;
        int totalTextHeight = editText.getLayout().getHeight() + 50;
        int visibleHeight = editText.getHeight();

        return  totalTextHeight > visibleHeight;
    }


}