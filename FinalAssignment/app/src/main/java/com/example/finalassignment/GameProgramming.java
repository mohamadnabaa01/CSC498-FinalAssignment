package com.example.finalassignment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class GameProgramming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_programming);

        WebView view = (WebView) findViewById(R.id.webview);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new WebViewClient());
        SQLiteDatabase database = this.openOrCreateDatabase("my_final_exams", MODE_PRIVATE, null);
        Cursor c = database.rawQuery("Select * from finals_courses", null);//selecting all values
        int course_name = c.getColumnIndex("course_name");//get course name from select
        int study_website = c.getColumnIndex("study_website");//get the website from select
        c.moveToFirst();//start cursor from beginning
        while(c != null) {//while cursor is not empty
            String name = c.getString(course_name);
            Log.i("name", name);
            if (name.equals("Game Programming")){//if name is Game Programming
                String website = c.getString(study_website);
                Log.i("website", website);
                view.loadUrl(website);//set the url for the webview
            }
            if(!c.moveToNext())//if no more next cursor, then leave while loop
                return;
        }
    }
}