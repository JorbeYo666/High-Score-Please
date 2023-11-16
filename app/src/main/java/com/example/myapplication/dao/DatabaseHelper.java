package com.example.myapplication.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import com.example.myapplication.entity.User;

import java.util.ArrayList;


    public class DatabaseHelper extends SQLiteOpenHelper {
        //创建一个数据库
        private SQLiteDatabase db;

        public DatabaseHelper(@Nullable Context context) {
            super(context, "db_test", null, 1);
            db = getReadableDatabase();
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            //在第一次创建数据库的时候，创建一些字段
            String sql = "create table user(_id integer, name varchar(50), password varchar(40))";
            db.execSQL(sql);//sql语句的执行函数
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //如果这个表中存在user,我们可以先把他去掉,然后重新创建
            String sql = "DROP TABLE IF EXISTS user";
            db.execSQL(sql);
            onCreate(db);
        }
        //为使项目结构更加紧凑，我们在此类中编写增删改查的函数,因为只有登录和注册界面,因此只涉及到写入数据库insert和query的操作
        public void insert(String idnum,String password ){
            db.execSQL("insert into user(idnum,password)VALUES(?,?)",new Object[]{idnum,password});
        }

        public ArrayList<User> getAllDATA(){//查询数据库
            ArrayList<User> list = new ArrayList<User>();

            Cursor cursor = db.query("user",null,null,null,null,null,"name DESC");
            while(cursor.moveToNext()){
                int index_name = cursor.getColumnIndex("name");
                int index_password = cursor.getColumnIndex("password");
                String idnum = cursor.getString(index_name);
                String password = cursor.getString(index_password);
                list.add(new User(idnum,password));
            }
            return list;
        }
    }



