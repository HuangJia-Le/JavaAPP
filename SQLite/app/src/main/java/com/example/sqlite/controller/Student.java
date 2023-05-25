package com.example.sqlite.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;//具体进行操作的类
import android.database.sqlite.SQLiteOpenHelper;//用来创建数据库和对数据库版本进行控制
import androidx.annotation.Nullable;
import com.example.sqlite.entity.student_tb;

import java.util.List;

public class Student extends SQLiteOpenHelper {
    public Student(@Nullable Context context, @Nullable String name) {
        super(context, "student.db", null, 1 );
    }

    private static final String TABLE_NAME="student";
    private static final String id="id";
    private static final String studentno="studentno";
    private static final String name="name";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE "+TABLE_NAME+"("+id +"INTEGER PRIMARY KEY AUTOINCREMENT,"+ studentno+" String,"+name +"String)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String add(student_tb student){
        ContentValues cv=new ContentValues();
        cv.put(studentno,student.getStudentno());
        cv.put(name,student.getName());
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        long result=sqLiteDatabase.insert(TABLE_NAME,studentno,cv);
        if (result==-1){
            return "添加失败";
        }
        sqLiteDatabase.close();
        return "添加成功";
    }

    public String delete(student_tb student_tb){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        long result=sqLiteDatabase.delete(TABLE_NAME,"id=?",new String[]{String.valueOf(student_tb.getId())});
        sqLiteDatabase.close();
        if (result==0){
            return "删除失败";
        }
        return "删除成功";
    }

    public String update(student_tb student_tb){
        ContentValues cv=new ContentValues();
        cv.put(studentno,student_tb.getStudentno());
        cv.put(name,student_tb.getName());
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        long result=sqLiteDatabase.update(TABLE_NAME,cv,"id=?",new String[]{String.valueOf(student_tb.getId())});
        sqLiteDatabase.close();
        if (result==0){
            return "修改失败";
        }
        return "修改成功";
    }

    public List<student_tb> queryAll(){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String sql="SELECT * FROM "+TABLE_NAME;
        List<student_tb> list=null;
        sqLiteDatabase.close();
        return list;
    }

}
