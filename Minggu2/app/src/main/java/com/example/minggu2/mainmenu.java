package com.example.minggu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mainmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
    }




    public void menu(View view){
        Intent intent = new Intent(mainmenu.this,linier.class);

        startActivity(intent);
    }
    public void menu2(View view){
        Intent intent = new Intent(mainmenu.this,relative.class);

        startActivity(intent);
    }
    public void menu3(View view){
        Intent intent = new Intent(mainmenu.this,constraint.class);

        startActivity(intent);
    }

    public void menu4(View view){
        Intent intent = new Intent(mainmenu.this,framelayout.class);

        startActivity(intent);
    }

    public void menu5(View view){
        Intent intent = new Intent(mainmenu.this,tablelayout.class);

        startActivity(intent);
    }
    public void menu6(View view){
        Intent intent = new Intent(mainmenu.this,materialdesign.class);

        startActivity(intent);
    }
    public void menu7(View view){
        Intent intent = new Intent(mainmenu.this,horizontalscrool.class);

        startActivity(intent);
    }
    public void menu8(View view){
        Intent intent = new Intent(mainmenu.this,vertikalscrool.class);

        startActivity(intent);
    }


}