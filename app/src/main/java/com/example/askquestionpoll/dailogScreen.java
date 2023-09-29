package com.example.askquestionpoll;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class dailogScreen extends AppCompatActivity {
    ProgressDialog progressBar;
    public Handler progressBarHandler = new Handler();
    public int progressBarStatus = 0;
    String selectedRadio = "";
    private long fileSize = 0;
    String res = "";
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailog_screen);
        Button singaleDailog = findViewById(R.id.singledailog);
        Button multiDailog = findViewById(R.id.multichice_dailog);
        Button customDailog = findViewById(R.id.custom_dailog);
        Button optionDailog = findViewById(R.id.option_dailog);
        Button prograceDailog = findViewById(R.id.progracebar1);
        Button downloadprograceDailog2 = findViewById(R.id.progracebar3);
        downloadprograceDailog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDownloadProgressDialog2();
            }
        });
        Button downloadprograceDailog = findViewById(R.id.progracebar2);
        downloadprograceDailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDownloadProgressDialog();
            }
        });
        prograceDailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProgracebar();

            }
        });

        optionDailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionDailog();

            }
        });
        customDailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showcardDialog();
            }
        });
        multiDailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showmultichoseDialog();

            }
        });
        singaleDailog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();

            }
        });

    }

    public int doOperation() {
        long j;
        do {
            long j2 = this.fileSize;
            if (j2 > 10000) {
                return 100;
            }
            j = j2 + 1;
            this.fileSize = j;
            if (j == 1000) {
                return 10;
            }
            if (j == 2000) {
                return 20;
            }
            if (j == 3000) {
                return 30;
            }
        } while (j != 4000);
        return 40;
    }

    /* access modifiers changed from: private */

    public void showDownloadProgressDialog2() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.progressBar = progressDialog;
        progressDialog.setCancelable(true);
        this.progressBar.setMessage("File downloading ...");
        this.progressBar.setProgressStyle(1);
        this.progressBar.setProgress(0);
        this.progressBar.setMax(100);
        this.progressBarStatus = 0;
        this.fileSize = 0;
        new Thread(new Runnable() {
            public void run() {
                while (dailogScreen.this.progressBarStatus < 100) {
                    dailogScreen dialogactivity = dailogScreen.this;
                    int unused = dialogactivity.progressBarStatus = dialogactivity.doOperation();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dailogScreen.this.progressBarHandler.post(new Runnable() {
                        public void run() {
                            dailogScreen.this.progressBar.setProgress(dailogScreen.this.progressBarStatus);
                        }
                    });
                }
                if (dailogScreen.this.progressBarStatus >= 100) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    dailogScreen.this.progressBar.dismiss();
                }
            }
        }).start();
        progressBar.setProgressNumberFormat("");
        progressBar.setProgressPercentFormat(null);
        progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progrssbarcolor));
        this.progressBar.show();
    }
    public void showDownloadProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.progressBar = progressDialog;
        progressDialog.setCancelable(true);
        this.progressBar.setMessage("File downloading ...");
        this.progressBar.setProgressStyle(1);
        this.progressBar.setProgress(0);
        this.progressBar.setMax(100);
        this.progressBarStatus = 0;
        this.fileSize = 0;
        new Thread(new Runnable() {
            public void run() {
                while (dailogScreen.this.progressBarStatus < 100) {
                    dailogScreen dialogactivity = dailogScreen.this;
                    int unused = dialogactivity.progressBarStatus = dialogactivity.doOperation();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dailogScreen.this.progressBarHandler.post(new Runnable() {
                        public void run() {
                            dailogScreen.this.progressBar.setProgress(dailogScreen.this.progressBarStatus);
                        }
                    });
                }
                if (dailogScreen.this.progressBarStatus >= 100) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    dailogScreen.this.progressBar.dismiss();
                }
            }
        }).start();

        this.progressBar.show();
    }

    private void showProgracebar() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.progracebar, null);


        dialogBuilder.setView(dialogView);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        alertDialog.show();
    }

    private void showOptionDailog() {

        final String[] colorsitem = {"Red", "Blue", "Black", "White", "Pink"};
        new AlertDialog.Builder(dailogScreen.this).setTitle("Select Color").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dailog, int i) {
                Toast.makeText(dailogScreen.this, "You selected: " + res, Toast.LENGTH_SHORT).show();

            }
        }).setSingleChoiceItems(colorsitem, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getRes(colorsitem[i]);
                System.out.println(colorsitem[i]);

            }
        }).show();
    }

    public void getRes(String s) {
        res = s;
    }

    private void showcardDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.customdailog, null);


        dialogBuilder.setView(dialogView);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        alertDialog.show();
    }


    private void showmultichoseDialog() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(dailogScreen.this);

        alertDialogBuilder.setTitle("Alert Dailog Title Example").setMessage("Do You Want To Close this Dailog").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You Clicked Ok", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You Clicked Cancel", Toast.LENGTH_SHORT).show();
            }
        }).setNeutralButton("Nrutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You Clicked Neutral", Toast.LENGTH_SHORT).show();

            }
        });
        float[] cornerRadii = new float[] { 30, 30, 30, 30, 30, 30, 30, 30 };
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(cornerRadii, null, null));
        shapeDrawable.getPaint().setColor(getResources().getColor(android.R.color.holo_green_light));
        AlertDialog alertDialog = alertDialogBuilder.create();
        Button positiveButton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        if (positiveButton != null) {
            positiveButton.setBackground(new ColorDrawable(getResources().getColor(R.color.blue)));
        }


        alertDialog.getWindow().setBackgroundDrawable(shapeDrawable);
        alertDialog.show();



    }

    private void showCustomDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(dailogScreen.this);

        alertDialogBuilder.setTitle("Alert Dailog Title Example").setMessage("Do You Want To Close this Dailog").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You Clicked Ok", Toast.LENGTH_SHORT).show();
            }
        });
        float[] cornerRadii = new float[] { 30, 30, 30, 30, 30, 30, 30, 30 };
       ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(cornerRadii, null, null));
       shapeDrawable.getPaint().setColor(getResources().getColor(android.R.color.white));
        AlertDialog alertDialog = alertDialogBuilder.create();
        Button positiveButton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        if (positiveButton != null) {
            positiveButton.setBackground(new ColorDrawable(getResources().getColor(R.color.blue)));
        }


        alertDialog.getWindow().setBackgroundDrawable(shapeDrawable);
        alertDialog.show();
        /*AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dailog_layout, null);

        Button closeButton = dialogView.findViewById(R.id.closeDialogButton);

        dialogBuilder.setView(dialogView);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You Clicked Ok", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }*/
    }
}