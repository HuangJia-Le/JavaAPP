package com.example.sqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sqlite.controller.StudentController;
import com.example.sqlite.entity.Student;

public class MainActivity extends AppCompatActivity {

    TextView add_no, add_name;
    Button add, delete, update, query, clear;
    ListView listView;
    StudentController studentController;

    @Override
    protected void onStart() {
        super.onStart();
        ViewAll();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_no = findViewById(R.id.add_no);
        add_name = findViewById(R.id.add_name);
        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);
        query = findViewById(R.id.query);
        clear = findViewById(R.id.clear);
        listView = findViewById(R.id.listview);

        studentController=new StudentController(MainActivity.this);
        ViewAll();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Student student = new Student(-1, add_no.getText().toString(), add_name.getText().toString());
                StudentController studentController = new StudentController(MainActivity.this);
                String s = studentController.add(student);
                Toast.makeText(MainActivity.this, "ADD: "+s, Toast.LENGTH_SHORT).show();
                //添加时刷新
                ViewAll();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                add_no.setText("");
                add_name.setText("");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int i, long l){
                Student student = (Student) adapterView.getItemAtPosition(i);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("请选择操作");
                dialog.setNegativeButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String s = studentController.delete(student);
                        Toast.makeText(MainActivity.this, "DELETE: "+s, Toast.LENGTH_SHORT).show();
                        //删除时刷新
                        ViewAll();
                    }
                });
                dialog.setPositiveButton("修改", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Intent intent=new Intent(MainActivity.this,UpdateActivity.class);
                        intent.putExtra("id",student.getId());
                        intent.putExtra("studentno",student.getStudentno());
                        intent.putExtra("name",student.getName());
                        startActivity(intent);
                    }
                });
                dialog.create();
                dialog.show();
            }
        });

        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                StudentController studentController = new StudentController(MainActivity.this);
                String s = studentController.query(add_name.getText().toString());
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("该学生的学号为："+s);
                dialog.create();
                dialog.show();
            }
        });


    }

    private void ViewAll() {
        ArrayAdapter<Student> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, studentController.queryAll());
        listView.setAdapter(adapter);
    }
}
