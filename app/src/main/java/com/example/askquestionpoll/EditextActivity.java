package com.example.askquestionpoll;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editext);
        TextView textView = findViewById(R.id.txt);
        EditText usernametxt = findViewById(R.id.edittxt_username);
        TextInputLayout textInputLayout = findViewById(R.id.lay2);
        TextInputLayout passInputLayout = findViewById(R.id.lay3);
        EditText password = findViewById(R.id.edittxt_password);
        EditText email = findViewById(R.id.edittxt_email);
        Button button = findViewById(R.id.btn_display);




        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        textInputLayout.setHint("    Email");

        button.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                password.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        String passwordstring = charSequence.toString();
                        if (!passwordstring.isEmpty()) {
                            passInputLayout.setErrorEnabled(false);
                        }

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                email.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        String emailstring = charSequence.toString();

                        if (usernametxt.getText().toString().isEmpty()) {
                            usernametxt.setError("Please Enter Name");
                            usernametxt.requestFocus();
                        } else if (emailstring.isEmpty()) {
                            textInputLayout.setError("Please Enter Email ID");
                            email.requestFocus();
                        } else if (!isValidEmail(emailstring)) {
                            textInputLayout.setError("Enter a valid email id");
                            email.requestFocus();
                        } else {
                            textInputLayout.setErrorEnabled(false);
                            if (password.getText().toString().isEmpty()) {
                                passInputLayout.setError("Enter Password");
                            } else {
                                passInputLayout.setErrorEnabled(false);
                                textView.setText("Name: " + usernametxt.getText().toString() + "\n" + "Email id: " + email.getText().toString() + "\n" + "Password: " + password.getText().toString());
                            }
                        }


                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                if (usernametxt.getText().toString().isEmpty()) {
                    usernametxt.setError("Please Enter Name");
                    usernametxt.requestFocus();
                } else if (email.getText().toString().isEmpty()) {
                    textInputLayout.setError("Please Enter Email ID");
                    email.requestFocus();
                } else if (!isValidEmail(email.getText().toString())) {
                    textInputLayout.setError("Enter a valid email id");
                    email.requestFocus();
                } else {
                    textInputLayout.setErrorEnabled(false);
                    if (password.getText().toString().isEmpty()) {
                        passInputLayout.setError("Enter Password");
                        password.requestFocus();
                    } else {
                        passInputLayout.setErrorEnabled(false);
                        inputMethodManager.hideSoftInputFromWindow(password.getWindowToken(), 0);
                        textView.setText("Name: " + usernametxt.getText().toString() + "\n" + "Email id: " + email.getText().toString() + "\n" + "Password: " + password.getText().toString());
                    }
                }


            }
        });
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}