package com.example.askquestionpoll;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleView_Screen extends AppCompatActivity {

    ArrayList<foodModel> foodList = new ArrayList<>();
    ArrayList<Integer> imagelist = new ArrayList<>();
    int counter = 0;
    Button btnAdd;
    Button btnDelete;
    foodRecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_screen);
        RecyclerView recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.btnAdd = findViewById(R.id.btn_add);
        this.btnDelete = findViewById(R.id.btn_delet);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteInfoDialog();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInfoDialog();
            }
        });
        imagelist.add(R.drawable.burger);
        imagelist.add(R.drawable.pizza);
        imagelist.add(R.drawable.salad);


        foodList.add(new foodModel("Burger", "Fast Food", R.drawable.burger));
        foodList.add(null);
        foodList.add(new foodModel("Salad", "Healthy Food", R.drawable.salad));
        foodList.add(null);
        foodList.add(new foodModel("Pizza", "Fast Food", R.drawable.pizza));
        foodList.add(null);
        foodList.add(new foodModel("Burger", "Fast Food", R.drawable.burger));
        foodList.add(null);
        foodList.add(new foodModel("Salad", "Healthy Food", R.drawable.salad));
        foodList.add(null);
        foodList.add(new foodModel("Pizza", "Fast Food", R.drawable.pizza));
        foodList.add(null);
        foodList.add(new foodModel("Burger", "Fast Food", R.drawable.burger));
        foodList.add(null);
        foodList.add(new foodModel("Salad", "Healthy Food", R.drawable.salad));
        foodList.add(null);
        foodList.add(new foodModel("Pizza", "Fast Food", R.drawable.pizza));

        adapter = new foodRecycleViewAdapter(this, foodList);
        recyclerView.setAdapter(adapter);


    }

    private void addInfoDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.recycleview_input_dailog, null);
        dialogBuilder.setView(dialogView);
        EditText posiedittxt = dialogView.findViewById(R.id.editxt_posi);
        EditText editText1 = dialogView.findViewById(R.id.edittxt1);
        EditText editText2 = dialogView.findViewById(R.id.edittxt2);
        Button btn_Submit = dialogView.findViewById(R.id.btn_submit);

        final AlertDialog alertDialog = dialogBuilder.create();
        btn_Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (counter == 2) {
                    counter = 0;
                }
                if(editText1.getText().toString().isEmpty()||editText2.getText().toString().isEmpty()|| posiedittxt.getText().toString().isEmpty())
                {
                    Toast.makeText(RecycleView_Screen.this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int index=Integer.parseInt(posiedittxt.getText().toString());
                    int check=index*2-2;
                    if(check>foodList.size())
                    {
                        Toast.makeText(RecycleView_Screen.this, "Enter Valid Postion", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if(index < 0)
                        {
                            foodList.add(0,new foodModel(editText1.getText().toString(), editText2.getText().toString(), imagelist.get(counter)));
                            adapter.notifyItemInserted(0);
                            adapter.notifyItemRangeChanged(0,foodList.size());
                            foodList.add(1,null);
                            adapter.notifyItemInserted(1);
                            adapter.notifyItemRangeChanged(1,foodList.size());

                            counter++;
                        }
                        else
                        {
                            index=index*2-2;
                            foodList.add(index,null);
                            adapter.notifyItemInserted(index);
                            adapter.notifyItemRangeChanged(index,foodList.size());
                            foodList.add(index,new foodModel(editText1.getText().toString(), editText2.getText().toString(), imagelist.get(counter)));
                            adapter.notifyItemInserted(index);
                            adapter.notifyItemRangeChanged(index,foodList.size());
                            counter++;
                        }
                    }

                }



                alertDialog.dismiss();
            }
        });
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        alertDialog.show();
    }

    private void deleteInfoDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.recycleview_delet_dailog, null);
        dialogBuilder.setView(dialogView);
        EditText editText1 = dialogView.findViewById(R.id.edittxt1);
        Button btn_Submit = dialogView.findViewById(R.id.btn_submit);

        final AlertDialog alertDialog = dialogBuilder.create();
        btn_Submit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                int index = (Integer.valueOf(editText1.getText().toString()) * 2) - 2;

                if(index<0)
                {
                    Toast.makeText(RecycleView_Screen.this, "less than zero", Toast.LENGTH_SHORT).show();
                    foodList.remove(0);
                    adapter.notifyItemRemoved(0);
                    adapter.notifyItemRangeChanged(0,foodList.size());
                    foodList.remove(0);
                    adapter.notifyItemRemoved(0);
                    adapter.notifyItemRangeChanged(0,foodList.size());

                }
                else {

                    if (index >= foodList.size()) {
                        Toast.makeText(getApplicationContext(), "Enter VAlid Position", Toast.LENGTH_SHORT).show();
                    } else {

                        if (foodList.size() - 1 == (index)) {
                            foodList.remove(index);
                            adapter.notifyItemRemoved(index);
                            adapter.notifyItemRangeRemoved(index, adapter.getItemCount());
                            foodList.remove(index - 1);
                            adapter.notifyItemRemoved(index - 1);
                            adapter.notifyItemRangeRemoved(index, adapter.getItemCount());


                        } else {
                            if (foodList.get(index) == null && foodList.size() - 1 != (index)) {
                                foodList.remove(index + 1);
                                adapter.notifyItemRemoved(index + 1);
                                adapter.notifyItemRangeChanged(index + 1, foodList.size() - index + 1);
                                if (foodList.get(index + 1) == null && foodList.size() != (index + 1)) {

                                    foodList.remove(index + 1);
                                    adapter.notifyItemRemoved(index + 1);
                                    adapter.notifyItemRangeChanged(index + 1, foodList.size() - index + 1);

                                }
                            } else {
                                if (foodList.size() - 1 != (index)) {
                                    foodList.remove(index);
                                    adapter.notifyItemRemoved(index);
                                    adapter.notifyItemRangeChanged(index, foodList.size() - index);

                                }
                                if (foodList.get(index) == null && foodList.size() - 1 != (index)) {
                                    foodList.remove(index);
                                    adapter.notifyItemRemoved(index);
                                    adapter.notifyItemRangeChanged(index, foodList.size() - index);

                                }
                            }
                        }


                    }

                }




                System.out.println(foodList.size());

                alertDialog.dismiss();
            }
        });
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        alertDialog.show();
    }
}