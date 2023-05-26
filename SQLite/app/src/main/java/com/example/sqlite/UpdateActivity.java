package com.example.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.sqlite.controller.StudentController;
import com.example.sqlite.entity.Student;

public class UpdateActivity extends AppCompatActivity {

    TextView alter_no, alter_name;
    Button alter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);
        String studentno=intent.getStringExtra("studentno");
        String name=intent.getStringExtra("name");

        alter_no = findViewById(R.id.alterNo);
        alter_name = findViewById(R.id.alterName);
        alter = findViewById(R.id.alter);

        alter_no.setText(studentno);
        alter_name.setText(name);

        alter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Student student = new Student(id, alter_no.getText().toString(), alter_name.getText().toString());
                StudentController studentController = new StudentController(UpdateActivity.this);
                studentController.update(student);
                finish();
            }
        });
}
}
