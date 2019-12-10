package com.example.a20190910_ws;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;
    ListView listView;
    ItemAdapter itemAdapter;
    ArrayList<Item> list;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        Intent intent=getIntent();
        listView=findViewById(R.id.listView);

        dbHelper = new DatabaseHelper(this);
        sqLiteDatabase = dbHelper.getWritableDatabase();


        getData();
    }

    //adapater를 listview에 붙일 것
    class ItemAdapter extends BaseAdapter {
        ArrayList<Item> alist;
        public ItemAdapter() {
        }

        public ItemAdapter(ArrayList<Item> alist) {
            this.alist = alist;
        }

        public void addItem(Item item){
            alist.add(item);
            list=alist;
        }
        @Override
        public int getCount() {
            return alist.size();
        }

        @Override
        public Object getItem(int i) {
            return alist.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View myview=null;
            LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myview=inflater.inflate(R.layout.listitem,
                    container,
                    true);

            Log.d("[result]:","에러야 어디있니");
            TextView tv_id = myview.findViewById(R.id.tv_id);
            TextView tv_title = myview.findViewById(R.id.tv_title);

            // iv.setImageResource(alist.get(alist.size()-i-1).getImgId());
            tv_id.setText(alist.get(i).getName());
            tv_title.setText(alist.get(i).getTitle());

            return myview;
        }


    }
    public void getData(){
        Log.d("[result]:","executeQuery 호출됨.");

        Cursor cursor = sqLiteDatabase.rawQuery("select _id, name, title from memo", null);
        int recordCount = cursor.getCount();
        Log.d("[result]:","레코드 개수 : " + recordCount);

        ArrayList<Item> arrayList=new ArrayList<Item>();
        for (int i = 0; i < recordCount; i++) {
            cursor.moveToNext();

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String title = cursor.getString(2);

            arrayList.add(new Item(name,title));
            Log.d("[result]:", name+" "+title);

        }
        cursor.close();
        sqLiteDatabase.close();
        dbHelper.close();
        itemAdapter=new ItemAdapter(arrayList);
        listView.setAdapter(itemAdapter);
    }

}
