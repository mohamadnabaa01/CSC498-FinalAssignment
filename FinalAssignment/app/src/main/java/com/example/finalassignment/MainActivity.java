package com.example.finalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        Cursor c = database.rawQuery("Select * from finals_courses", null);
        c.moveToFirst();

        while(c != null){
            int course_name = c.getColumnIndex("course_name");
            String name = c.getString(course_name);
            Button mobile_computing = (Button) findViewById(R.id.mobile_computing);
            Button game_programming = (Button) findViewById(R.id.game_programming);
            Button discrete_structures_2 = (Button) findViewById(R.id.discrete_structures2);
            Button parallel_programming = (Button) findViewById(R.id.parallel_programming);
            if(mobile_computing.getText().equals(""))
                mobile_computing.setText(name);
            else if(game_programming.getText().equals(""))
                game_programming.setText(name);
            else if(discrete_structures_2.getText().equals(""))
                mobile_computing.setText(name);
            else if(parallel_programming.getText().equals(""))
                mobile_computing.setText(name);
            if(!c.moveToNext())
                return;
        }
    }

    public void OpenMobileComputing(View view){
        Intent intent = new Intent(getApplicationContext(), MobileComputing.class);
        startActivity(intent);
    }
}