package com.example.xi.watermeloncalculator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "create table Book ("
            + "id integer primary key autoincrement, "
            + "data0 text, "
            + "data1 text, "
            + "data2 text, "
            + "data3 text, "
            + "data4 text, "
            + "data5 text, "
            + "data6 text, "
            + "data7 text, "
            + "data8 text, "
            + "data9 text, "
            + "data10 text, "
            + "sum_number integer, "
            + "sum_left integer, "
            + "sum_right integer)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BOOK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
