package com.example.cat3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etUname, etPass;
    private Button btnLog;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        etUname = findViewById(R.id.etUname);
        etPass = findViewById(R.id.etPass);
        btnLog = findViewById(R.id.btnLogin);
        pd = new ProgressDialog(this);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });


    }

    private void validate() {
        String name = etUname.getText().toString();
        String pass = etPass.getText().toString();
        if (name.isEmpty()) {
            etUname.setError("Please enter your name");
            etUname.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            etPass.setError("Please enter your password");
            etPass.requestFocus();
            return;
        } else {
            pd.setTitle("Login Account");
            pd.setMessage("Please wait,while we are checking the login credentials");
            pd.setCanceledOnTouchOutside(false);
            pd.show();
            Intent intent = new Intent(this, DashboardActivity.class);
            intent.putExtra("name", "Rohit");
            startActivity(intent);
        }

    }
}