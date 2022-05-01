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

        database.execSQL("INSERT INTO finals_courses (course_name, study_website) VALUES ('Mobile Computing', 'https://ionicframework.com/')");
        database.execSQL("INSERT INTO finals_courses (course_name, study_website) VALUES ('Game Programming', 'https://elearn.lau.edu.lb/ultra/courses/_50275_1/cl/outline')");
        database.execSQL("INSERT INTO finals_courses (course_name, study_website) VALUES ('Discrete Structures 2', 'https://elearn.lau.edu.lb/ultra/courses/_49971_1/cl/outline')");
        database.execSQL("INSERT INTO finals_courses (course_name, study_website) VALUES ('Parallel Programming', 'https://drive.google.com/drive/folders/1LJgeH6yh8e_3nk95dDLcIKpFEfxTZGJ-')");

    }
}