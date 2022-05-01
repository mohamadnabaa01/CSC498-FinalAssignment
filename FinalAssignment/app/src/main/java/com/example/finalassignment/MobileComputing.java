package com.example.finalassignment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
        Cursor c = database.rawQuery("Select * from finals_courses WHERE course_name='Mobile Computing'", null);
        String name = String.valueOf(c.getColumnIndex("study_website"));
        view.loadUrl(name);
    }
}