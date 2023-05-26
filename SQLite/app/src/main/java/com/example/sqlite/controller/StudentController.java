package com.example.sqlite.controller;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;//具体进行操作的类
import android.database.sqlite.SQLiteOpenHelper;//用来创建数据库和对数据库版本进行控制
import androidx.annotation.Nullable;
import com.example.sqlite.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentController extends SQLiteOpenHelper {
    public StudentController(@Nullable Context context) {
        super(context, "student.db", null, 1 );
    }

    private static final String TABLE_NAME="Student";
    private static final String id="id";
    private static final String studentno="studentno";
    private static final String name="name";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE "+TABLE_NAME+"("+id +" INTEGER PRIMARY KEY AUTOINCREMENT,"+ studentno+" String,"+name+" String)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String add(Student student){
        ContentValues cv=new ContentValues();
        cv.put(studentno,student.getStudentno());
        cv.put(name,student.getName());
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        long result=sqLiteDatabase.insert(TABLE_NAME,studentno,cv);
        if (result==-1){
            return "添加失败";
        }
        sqLiteDatabase.close();
        return "添加成功";
    }

    public String delete(Student student){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        long result=sqLiteDatabase.delete(TABLE_NAME,"id=?",new String[]{String.valueOf(student.getId())});
        sqLiteDatabase.close();
        if (result==0){
            return "删除失败";
        }
        return "删除成功";
    }

    public String update(Student student){
        ContentValues cv=new ContentValues();
        cv.put(studentno,student.getStudentno());
        cv.put(name,student.getName());
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        long result=sqLiteDatabase.update(TABLE_NAME,cv,"id=?",new String[]{String.valueOf(student.getId())});
        sqLiteDatabase.close();
        if (result==0){
            return "修改失败";
        }
        return "修改成功";
    }

    public List<Student> queryAll(){
        Student student;
        List<Student> list=new ArrayList<>();

        String sql="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);

        int idIndex=cursor.getColumnIndex(id);
        int studentnoIndex=cursor.getColumnIndex(studentno);
        int nameIndex=cursor.getColumnIndex(name);
        while(cursor.moveToNext()){
            student=new Student(cursor.getInt(idIndex),cursor.getString(studentnoIndex),cursor.getString(nameIndex));
            list.add(student);
        }
        sqLiteDatabase.close();
        return list;
    }

    @SuppressLint("Range")
    public String query(String username){
        String sql="SELECT * FROM "+TABLE_NAME+" WHERE "+name+" = "+username;
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.query(TABLE_NAME, new String[]{studentno}, name+"=?", new String[]{username}, null, null, null);
        if (cursor.moveToFirst()==false){
            return "学生不存在";
        }
        String result=cursor.getString(cursor.getColumnIndex(studentno));
        return result;
    }

}

