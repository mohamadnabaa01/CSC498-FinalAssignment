package com.example.finalassignment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MobileComputing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_computing);

        WebView view = (WebView) findViewById(R.id.webview);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new WebViewClient());
        SQLiteDatabase database = this.openOrCreateDatabase("my_final_exams", MODE_PRIVATE, null);
        Cursor c = database.rawQuery("Select * from finals_courses", null);
        int course_name = c.getColumnIndex("course_name");
        int study_website = c.getColumnIndex("study_website");
        c.moveToFirst();
        while(c != null) {
            String name = c.getString(course_name);
            Log.i("name", name);
            if (name.equals("Mobile Computing")){
                String website = c.getString(study_website);
                Log.i("website", website);
                view.loadUrl(website);
            }
            if(!c.moveToNext())
                return;
        }
    }
}