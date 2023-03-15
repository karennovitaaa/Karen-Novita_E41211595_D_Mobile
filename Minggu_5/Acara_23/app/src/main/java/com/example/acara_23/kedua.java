package com.example.acara_23;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class kedua extends AppCompatActivity {
    TextView nama;
    TextView nim;
    private String name;
    private String nm;
    private String KEY_NAME = "NAMA";
    private String KEY_NIM = "NIM";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);
        nama = (TextView) findViewById(R.id.txtHello);
        nim = (TextView) findViewById(R.id.txtHello2);
        Bundle extras = getIntent().getExtras();
        name = extras.getString(KEY_NAME);
        nama.setText("Hello, " + name + " !");
        nm = extras.getString(KEY_NIM);
        nim.setText(nm);
    }
}