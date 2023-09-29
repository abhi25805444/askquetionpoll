package com.example.askquestionpoll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class foodRecycleViewAdapter extends RecyclerView.Adapter {
    Context context;
    int lastPosition=1;

    ArrayList<foodModel> arrayList;
    private static int VIEW_TYPE_SEPRATOR = 1;
    private static int VIEW_TYPE_ITEM = 0;

    foodRecycleViewAdapter(Context context, ArrayList<foodModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getItemViewType(int position) {

        System.out.println("Viewtype");
        if(arrayList.get(position) == null)
        {
            return VIEW_TYPE_SEPRATOR;
        }
        else {
            return VIEW_TYPE_ITEM;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view;

        if(viewType == VIEW_TYPE_SEPRATOR)
        {
            view=layoutInflater.inflate(R.layout.recycle_layout_without_border,parent,false);
            return new viewHolderTwo(view);
        }

        view=layoutInflater.inflate(R.layout.recycleview_layout,parent,false);
        return new viewHolderone(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if(arrayList.get(position) == null)
        {
            viewHolderTwo ViewHolderTwo=(viewHolderTwo) holder;

        }
        else {
            viewHolderone ViewHolderOne=(viewHolderone) holder;
            ViewHolderOne.imgFood.setImageResource(arrayList.get(position).foodImage);
            ViewHolderOne.txtFoodName.setText(arrayList.get(position).foodName);
            ViewHolderOne.txtFoodDes.setText(arrayList.get(position).foodDes);
            ViewHolderOne.txtPosi.setText(String.valueOf((position/2)+1));

        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class viewHolderone extends RecyclerView.ViewHolder{

        TextView txtFoodName, txtFoodDes,txtPosi;
        ImageView imgFood;

        public viewHolderone(@NonNull View itemView) {
            super(itemView);

            txtFoodName = itemView.findViewById(R.id.txtfoodname);
            txtFoodDes = itemView.findViewById(R.id.txtfooddes);
            imgFood = itemView.findViewById(R.id.imgfood);
            txtPosi=itemView.findViewById(R.id.txtposiq);
        }
    }

    class viewHolderTwo extends  RecyclerView.ViewHolder{
        ;

        public viewHolderTwo(@NonNull View itemView) {
            super(itemView);
            System.out.println("ViewHoldertwo");


        }
    }

}
