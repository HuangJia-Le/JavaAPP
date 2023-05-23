package com.example.sqlite.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;//具体进行操作的类
import android.database.sqlite.SQLiteOpenHelper;//用来创建数据库和对数据库版本进行控制
import androidx.annotation.Nullable;

public class Student extends SQLiteOpenHelper {
    public Student(@Nullable Context context, @Nullable String name) {
        super(context, "student.db", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
