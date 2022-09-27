package com.example.cat3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    private TextView tvInfo;
    private Button btnClass, btnLogout;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option1:
                Toast.makeText(this, "Search is clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.option2:
                Intent intent = new Intent(getApplicationContext(), NotifyActivity.class);
                startActivity(intent);
                return true;

            case R.id.option3:
                Toast.makeText(this, "Your Attendance is over 90%", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.option4:
                Toast.makeText(this, "This feature will be available soon", Toast.LENGTH_SHORT).show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        setContentView(R.layout.activity_dashboard);
        tvInfo = findViewById(R.id.tvInfo);
        btnClass = findViewById(R.id.btnClass);
        btnLogout = findViewById(R.id.btnLog);
        tvInfo.setText("Hello " + name);

        btnClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), BotActivity.class);
                startActivity(intent1);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
            }
        });


    }
}