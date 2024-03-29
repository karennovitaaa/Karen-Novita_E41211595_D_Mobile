package com.example.sqlite;
import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
String[] daftar;
ListView ListView2;
Menu menu;
protected Cursor cursor;
DataHelper dbcenter;
public static MainActivity ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener(){
    @Override
            public void onClick(View arg0) {
        Intent intent = new Intent(MainActivity.this, BuatBiodata.class);
        startActivity(intent);
    }
        });
        ma = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }
    public void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor= db.rawQuery("SELECT * FROM biodata", null);
        daftar = new String[cursor.getCount()];
            cursor.moveToFirst();
            for (int cc=0; cc < cursor.getCount(); cc++){
                cursor.moveToPosition(cc);
                daftar[cc] = cursor.getString(1).toString();
        }
            ListView2 = (ListView) findViewById(R.id.listView1);
            ListView2.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
            ListView2.setSelected(true);
            ListView2.setOnItemClickListener((arg0, arg1, arg2, arg3) -> {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"Lihat Biodata", "Update Biodata", "Hapus Biodata"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item) {
                            case 0 :
                                Intent i = new Intent (getApplicationContext(), LihatBiodata.class);
                                i.putExtra("nama", selection);
                                startActivity(i);
                                break;
                            case 1 :
                                Intent in = new Intent (getApplicationContext(), UpdateBiodata.class);
                                in.putExtra("nama", selection);
                                startActivity(in);
                                break;
                            case 2 :
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from biodata where nama = '"+selection+"'");
                                RefreshList();
                                break;

                        }
                    }
                });
                builder.create().show();
            });
        ((ArrayAdapter)ListView2.getAdapter()).notifyDataSetInvalidated();

    }
}