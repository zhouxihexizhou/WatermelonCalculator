package com.example.xi.watermeloncalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Remember extends MainActivity {

    private MyDatabaseHelper dbHelper;

    private Button button_delete_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new MyDatabaseHelper(this, "CalculatorBook.db", null, 1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Book", null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                data[0]=cursor.getString(cursor.getColumnIndex("data0"));
                data[1]=cursor.getString(cursor.getColumnIndex("data1"));
                data[2]=cursor.getString(cursor.getColumnIndex("data2"));
                data[3]=cursor.getString(cursor.getColumnIndex("data3"));
                data[4]=cursor.getString(cursor.getColumnIndex("data4"));
                data[5]=cursor.getString(cursor.getColumnIndex("data5"));
                data[6]=cursor.getString(cursor.getColumnIndex("data6"));
                data[7]=cursor.getString(cursor.getColumnIndex("data7"));
                data[8]=cursor.getString(cursor.getColumnIndex("data8"));
                data[9]=cursor.getString(cursor.getColumnIndex("data9"));
                data[10]=cursor.getString(cursor.getColumnIndex("data10"));
                sum_number=cursor.getInt(cursor.getColumnIndex("sum_number"));
                sum_left=cursor.getInt(cursor.getColumnIndex("sum_left"));
                sum_right=cursor.getInt(cursor.getColumnIndex("sum_right"));
            }while(cursor.moveToNext());
        }
        int x;
        for(x=0;!data[x].equals("");){
            x++;
        }
        i=x;

        String inputText = load();
        if(!TextUtils.isEmpty(inputText)){
            textView.setText(inputText);

            String recover = inputText.substring(inputText.length()-1);
            switch (recover){
                case "0":
                    if(sum_number==1)
                        zero_num=0;
                    num_left=0;
                    sign_sign=1;
                    sign_right=1;
                    sign_mul=1;
                    left_sign=1;
                    left_mul=1;
                    left_right=1;
                    evolution_right=1;
                    evolution_sign=1;
                    evolution_mul=1;
                    to_munus=1;
                    break;
                case "1":
                    zero_num=1;
                    num_left=0;
                    sign_sign=1;
                    sign_right=1;
                    sign_mul=1;
                    left_sign=1;
                    left_mul=1;
                    left_right=1;
                    evolution_right=1;
                    evolution_sign=1;
                    evolution_mul=1;
                    to_munus=1;
                    break;
                case "2":
                    zero_num=1;
                    num_left=0;
                    sign_sign=1;
                    sign_right=1;
                    sign_mul=1;
                    left_sign=1;
                    left_mul=1;
                    left_right=1;
                    evolution_right=1;
                    evolution_sign=1;
                    evolution_mul=1;
                    to_munus=1;
                    break;
                case "3":
                    zero_num=1;
                    num_left=0;
                    sign_sign=1;
                    sign_right=1;
                    sign_mul=1;
                    left_sign=1;
                    left_mul=1;
                    left_right=1;
                    evolution_right=1;
                    evolution_sign=1;
                    evolution_mul=1;
                    to_munus=1;
                    break;
                case "4":
                    zero_num=1;
                    num_left=0;
                    sign_sign=1;
                    sign_right=1;
                    sign_mul=1;
                    left_sign=1;
                    left_mul=1;
                    left_right=1;
                    evolution_right=1;
                    evolution_sign=1;
                    evolution_mul=1;
                    to_munus=1;
                    break;
                case "5":
                    zero_num=1;
                    num_left=0;
                    sign_sign=1;
                    sign_right=1;
                    sign_mul=1;
                    left_sign=1;
                    left_mul=1;
                    left_right=1;
                    evolution_right=1;
                    evolution_sign=1;
                    evolution_mul=1;
                    to_munus=1;
                    break;
                case "6":
                    zero_num=1;
                    num_left=0;
                    sign_sign=1;
                    sign_right=1;
                    sign_mul=1;
                    left_sign=1;
                    left_mul=1;
                    left_right=1;
                    evolution_right=1;
                    evolution_sign=1;
                    evolution_mul=1;
                    to_munus=1;
                    break;
                case "7":
                    zero_num=1;
                    num_left=0;
                    sign_sign=1;
                    sign_right=1;
                    sign_mul=1;
                    left_sign=1;
                    left_mul=1;
                    left_right=1;
                    evolution_right=1;
                    evolution_sign=1;
                    evolution_mul=1;
                    to_munus=1;
                    break;
                case "8":
                    zero_num=1;
                    num_left=0;
                    sign_sign=1;
                    sign_right=1;
                    sign_mul=1;
                    left_sign=1;
                    left_mul=1;
                    left_right=1;
                    evolution_right=1;
                    evolution_sign=1;
                    evolution_mul=1;
                    to_munus=1;
                    break;
                case "9":
                    zero_num=1;
                    num_left=0;
                    sign_sign=1;
                    sign_right=1;
                    sign_mul=1;
                    left_sign=1;
                    left_mul=1;
                    left_right=1;
                    evolution_right=1;
                    evolution_sign=1;
                    evolution_mul=1;
                    to_munus=1;
                    break;
                case ".":
                    dot_dot=0;
                    zero_num=1;
                    dot_left=0;
                    sign_sign=1;
                    sign_right=1;
                    sign_mul=1;
                    left_sign=1;
                    left_mul=1;
                    left_right=1;
                    evolution_right=1;
                    evolution_sign=1;
                    evolution_mul=1;
                    to_munus=1;
                    break;
                case "^":
                    num_left=0;
                    mul_num=0;
                    break;
                case "(":
                    left_sign=0;
                    left_mul=0;
                    left_right=0;
                    to_munus=1;
                    break;
                case ")":
                    right_num=0;
                    right_left=0;
                    break;
                case "√":
                    zero_num=1;
                    num_left=1;
                    dot_dot=1;
                    dot_left=1;
                    evolution_right=0;
                    evolution_sign=0;
                    evolution_mul=0;
                    to_munus=1;
                    mul_num=1;
                    break;
                case "+":
                    zero_num=1;
                    sum_number=0;
                    num_left=1;
                    dot_dot=1;
                    dot_left=1;
                    sign_sign=0;
                    sign_right=0;
                    sign_mul=0;
                    right_num=1;
                    right_left=1;
                    to_munus=0;
                    double_sign=0;
                    mul_num=1;
                    to_change=1;
                    break;
                case "-":
                    zero_num=1;
                    sum_number=0;
                    num_left=1;
                    dot_dot=1;
                    dot_left=1;
                    sign_sign=0;
                    sign_right=0;
                    sign_mul=0;
                    right_num=1;
                    right_left=1;
                    to_munus=0;
                    double_sign=0;
                    mul_num=1;
                    to_change=1;
                    break;
                case "×":
                    zero_num=1;
                    sum_number=0;
                    num_left=1;
                    dot_dot=1;
                    dot_left=1;
                    sign_sign=0;
                    sign_right=0;
                    sign_mul=0;
                    right_num=1;
                    right_left=1;
                    to_munus=0;
                    double_sign=0;
                    mul_num=1;
                    to_change=1;
                    break;
                case "÷":
                    zero_num=1;
                    sum_number=0;
                    num_left=1;
                    dot_dot=1;
                    dot_left=1;
                    sign_sign=0;
                    sign_right=0;
                    sign_mul=0;
                    right_num=1;
                    right_left=1;
                    to_munus=0;
                    double_sign=0;
                    mul_num=1;
                    to_change=1;
                    break;
            }

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                Remember.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);


        button_delete_history = (Button) findViewById(R.id.delete_history);
        button_delete_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=1;
                data[0]=history;
                data[1]="";
                data[2]="";
                data[3]="";
                data[4]="";
                data[5]="";
                data[6]="";
                data[7]="";
                data[8]="";
                data[9]="";
                data[10]="";

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        Remember.this, android.R.layout.simple_list_item_1, data);
                ListView listView = (ListView) findViewById(R.id.list_view);
                listView.setAdapter(adapter);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String inputText = textView.getText().toString();
        save(inputText);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("data0", data[0]);
        values.put("data1", data[1]);
        values.put("data2", data[2]);
        values.put("data3", data[3]);
        values.put("data4", data[4]);
        values.put("data5", data[5]);
        values.put("data6", data[6]);
        values.put("data7", data[7]);
        values.put("data8", data[8]);
        values.put("data9", data[9]);
        values.put("data10", data[10]);
        values.put("sum_number", sum_number);
        values.put("sum_left", sum_left);
        values.put("sum_right", sum_right);
        db.insert("Book", null, values);
        values.clear();
    }

    public void save(String inputText){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try{
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(writer!=null){
                    writer.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public String load(){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try{
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while((line = reader.readLine())!=null){
                content.append(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader!=null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
}
