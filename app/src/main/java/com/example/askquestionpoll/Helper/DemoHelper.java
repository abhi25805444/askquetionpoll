package com.example.askquestionpoll.Helper;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import static com.example.askquestionpoll.R.color.navyblue;

import android.content.Context;
import android.util.Log;
import android.widget.RelativeLayout;

import com.example.askquestionpoll.R;

public class DemoHelper extends RelativeLayout {
    RelativeLayout relativeLayout;

    public DemoHelper(Context context,RelativeLayout relativeLayout) {
        super(context);
        this.relativeLayout=relativeLayout;
        ini();
    }

    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1000, 500);
    public void ini()
    {
        relativeLayout.setBackgroundColor(getContext().getColor(navyblue));
        relativeLayout.setLayoutParams(layoutParams);
        Log.d(TAG, "ini laoded");
    }
}
