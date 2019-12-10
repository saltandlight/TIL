package com.example.a20190910_ws;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView tv, tv_title, tv_date, tv_content;
    Button bt_cal, bt_save, bt_list;
    DatabaseHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        String date=intent.getStringExtra("date");
        tv=findViewById(R.id.tv_id);
        bt_cal=findViewById(R.id.bt_cal);
        bt_save=findViewById(R.id.bt_save);
        bt_list=findViewById(R.id.bt_list);
        tv_title=findViewById(R.id.tv_title);
        tv_date=findViewById(R.id.tv_date);
        tv_content=findViewById(R.id.tv_cont);

        message=id;
        tv.setText(message);
        tv_date.setText(date);
        Log.d("[result]","createDatabase 호출됨.");

        String name="memo";
        dbHelper = new DatabaseHelper(this);
        sqLiteDatabase= dbHelper.getWritableDatabase();

        Log.d("[result]","데이터베이스 생성함 : " );

        if (sqLiteDatabase == null) {
            Log.d("[result]","데이터베이스를 먼저 생성하세요.");
            return;
        }
        String sql = "create table if not exists "+name+"("
                + " _id integer PRIMARY KEY autoincrement, "
                + " name string, "
                + " title string, "
                + " date string, "
                + " content string)";
        sqLiteDatabase.execSQL(sql);

        Log.d("[result]","테이블 생성함 : " + name);
    }

    //insert
    public void save(View view){
        String title=tv_title.getText().toString();
        String date=tv_date.getText().toString();
        String content=tv_content.getText().toString();

        Log.d("[result]:","insertRecord 호출됨.");
        String tableName="memo";

        if (sqLiteDatabase == null) {
            Log.d("[result]:","데이터베이스를 먼저 생성하세요.");
            return;
        }

        if (tableName == null) {
            Log.d("[result]:","테이블을 먼저 생성하세요.");
            return;
        }

        sqLiteDatabase.execSQL("insert into " + tableName
                + "(name, title, date, content) "
                + " values ('"+message+"', '"+title+"','"+date+"','"+content+"')");

        Log.d("[result]:","레코드 추가함.");
    }

    //list
    public void list(View view){
        Intent intent = new Intent(this, ListActivity.class );
        startActivity(intent);
    }

    //cal
    public void cal(View view){
        Intent intent = new Intent(this, CalendarActivity.class);
        intent.putExtra("id",message);
        startActivity(intent);
    }

}
