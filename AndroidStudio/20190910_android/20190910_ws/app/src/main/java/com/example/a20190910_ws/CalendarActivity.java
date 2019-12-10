package com.example.a20190910_ws;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

public class CalendarActivity extends AppCompatActivity {

    CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender);

        calendarView=findViewById(R.id.calendarView);

        Intent intent=getIntent();
        final String id=intent.getStringExtra("id");
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i+"/"+(i1+1)+"/"+i2;
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("date",date);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }


}
