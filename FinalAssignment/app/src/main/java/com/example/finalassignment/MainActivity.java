package com.example.finalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase database = this.openOrCreateDatabase("my_final_exams", MODE_PRIVATE, null);
        database.execSQL("CREATE Table IF NOT EXISTS finals_courses (course_name VARCHAR, study_website VARCHAR)");
    }
}