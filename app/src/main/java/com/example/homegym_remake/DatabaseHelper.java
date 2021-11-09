package com.example.homegym_remake;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "homegymDB";
    public static final String TABLE_NAME = "login";

    public static final String COL_1 = "nickname";
    public static final String COL_2 = "id";
    public static final String COL_3 = "password";
    public static final String COL_4 = "sex";
    public static final String COL_5 = "age";
    public static final String COL_6 = "height";
    public static final String COL_7 = "weight";

    public DatabaseHelper(@Nullable Context context) { //생성자
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { // 테이블 생성
        db.execSQL("create table " + TABLE_NAME + "(nickname char, id char, password char, sex char, age number, weight numbaer, height numer, constraint login_PK Primary key(nickname, id));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { // 테이블 삭제 (해당 테이블 없어도 오류 발생 x)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insert_loginData(String nickname, String id, String password) { // 회원가입 시 로그인 관한 칼럼 데이터 삽입
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, nickname);
        contentValues.put(COL_2, id);
        contentValues.put(COL_3, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean insert_inforData(String sex, String age, String height, String weight) { // 내 정보 입력 시 infordata 관한 칼럼 데이터 삽입
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_4, sex);
        contentValues.put(COL_5, age);
        contentValues.put(COL_6, height);
        contentValues.put(COL_7, weight);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor gatAllData(){ // 로그인 테이블의 칼럼 검색
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME,null);
        return res;
    }

    public Integer deleteData(String nickname){ // 로그인 테이블의 닉네임으로 검색된 정보삭제
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "nickname = ?", new String[]{nickname});
    }

    public boolean update_loginData(String nickname, String id, String password) { // 로그인 시 입력한 정보 수정
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, nickname);
        contentValues.put(COL_2, id);
        contentValues.put(COL_3, password);
        db.update(TABLE_NAME,contentValues, "ID = ?", new String[] {id});
        return true;
    }
    public boolean update_inforData(String nickname, String sex, String age, String height, String weight) { // infordata 입력한 정보 닉네임으로 검색해 수정
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_4, sex);
        contentValues.put(COL_5, age);
        contentValues.put(COL_6, height);
        contentValues.put(COL_7, weight);
        db.update(TABLE_NAME,contentValues, "nickname = ?", new String[] {nickname});
        return true;
    }
}

