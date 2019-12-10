package com.example.a20190910_ws;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity  extends AppCompatActivity {
    TextView tv_id, tv_pwd;
    Button bt;
    ProgressDialog progressDialog;
    String result="";
    DatabaseHelper dbHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        bt=findViewById(R.id.button);
        tv_id=findViewById(R.id.tv_id);
        tv_pwd=findViewById(R.id.tv_pwd);
        progressDialog=new ProgressDialog(this);
    }


    public void clickBt(View view){
        String id=tv_id.getText().toString();
        String pwd=tv_pwd.getText().toString();

        String url = "http://70.12.60.96/webview/login.jsp?id="+id+"&pwd="+pwd;
        HttpTask httpTask = new HttpTask(url);
        httpTask.execute();
        Intent intent = null;

        if(result.equals("0") || result=="0"){
            intent=new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }else{
            Toast.makeText(this, result+"다시 로그인해주세요! :)", Toast.LENGTH_SHORT).show();
        }
    }

    class HttpTask extends AsyncTask<String, Void, String>{
        String url;

        @Override
        protected void onPreExecute() {
            progressDialog.setTitle("Http Connecting ..");
            progressDialog.setMessage("Please wait ..");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        public HttpTask(String url) {
            this.url = url;
        }

        @Override
        protected String doInBackground(String... strings) {
            String str= HttpHandler.getString(url);
            return str;
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            result=s;
        }
    }

}
