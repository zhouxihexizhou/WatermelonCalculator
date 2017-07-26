package com.example.xi.watermeloncalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected String history="历史：";

    protected String[] data={history, "", "", "", "", "", "", "", "", "", ""};

    protected int i=1;

    protected TextView textView;

    private Button button_0;

    private Button button_1;

    private Button button_2;

    private Button button_3;

    private Button button_4;

    private Button button_5;

    private Button button_6;

    private Button button_7;

    private Button button_8;

    private Button button_9;

    private Button button_dot;

    private Button button_reset;

    private Button button_delete;

    private Button button_mul;

    private Button button_left;

    private Button button_right;

    private Button button_evolution;

    private Button button_plus;

    private Button button_minus;

    private Button button_multiply;

    private Button button_divide;

    private Button button_equal;

    protected int zero_num=1;                 //0对数字的限制

    protected int num_left=1;                 //数字对左括号的限制

    protected int dot_dot=1;                 //小数点对小数点的限制

    protected int dot_left=1;               //小数点左括号的限制

    protected int sign_sign=1;                //运算符对运算符的限制

    protected int sign_right=1;             //运算符对右括号的限制

    protected int left_sign=1;              //左括号对运算符的限制

    protected int right_num=1;                //右括号对数字的限制

    protected int evolution_right=1;               //根号对右括号的限制

    protected int evolution_sign=1;                   //根号对运算符的限制

    protected int evolution_mul=1;                //根号对乘方的限制

    protected int sign_mul=1;               //运算符对乘方的限制

    protected int left_mul=1;                 //左括号对乘方的限制

    protected int right_left=1;            //右括号对左括号限制

    protected int left_right=1;             //左括号对右括号

    protected int to_munus=1;              //括号，根号对负号的限制

    protected int mul_num=1;                 //乘方对数字的限制

    protected int to_change=1;                  //变号的限制

    protected int after_equal=1;              //等于后的限制

    protected String after;

    protected int double_sign=0;

    protected int sum_number=0;                  //存数据库

    protected int sum_left=0;                 //存数据库

    protected int sum_right=0;                    //存数据库


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.text_view);

        button_0 = (Button) findViewById(R.id.button_0);

        button_1 = (Button) findViewById(R.id.button_1);

        button_2 = (Button) findViewById(R.id.button_2);

        button_3 = (Button) findViewById(R.id.button_3);

        button_4 = (Button) findViewById(R.id.button_4);

        button_5 = (Button) findViewById(R.id.button_5);

        button_6 = (Button) findViewById(R.id.button_6);

        button_7 = (Button) findViewById(R.id.button_7);

        button_8 = (Button) findViewById(R.id.button_8);

        button_9 = (Button) findViewById(R.id.button_9);

        button_dot = (Button) findViewById(R.id.button_dot);

        button_reset = (Button) findViewById(R.id.button_reset);

        button_delete = (Button) findViewById(R.id.button_delete);

        button_mul = (Button) findViewById(R.id.button_mul);

        button_left = (Button) findViewById(R.id.button_left);

        button_right = (Button) findViewById(R.id.button_right);

        button_evolution = (Button) findViewById(R.id.button_evolution);

        button_plus = (Button) findViewById(R.id.button_plus);

        button_minus = (Button) findViewById(R.id.button_minus);

        button_multiply = (Button) findViewById(R.id.button_multiply);

        button_divide = (Button) findViewById(R.id.button_divide);

        button_equal = (Button) findViewById(R.id.button_equal);


        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_0 = textView.getText().toString();
                if(after_equal==0){
                    str_0="";
                    after_equal=1;
                    sum_number=0;
                }
                if(sum_number<15){
                    if(zero_num==1 && right_num==1 && mul_num==1){
                        str_0 = str_0 + "0";
                        textView.setText(str_0);
                        sum_number++;
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
                    }else{

                    }
                }else{
                    Toast.makeText(MainActivity.this, "Maximum digit reached", Toast.LENGTH_SHORT).show();
                }
            }
        });


        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_1 = textView.getText().toString();
                if(after_equal==0){
                    str_1="";
                    after_equal=1;
                    sum_number=0;
                }
                if(right_num==1 && mul_num==1){
                    if(sum_number<15){
                        if(sum_number>0){
                            String s = str_1.substring(str_1.length()-1);
                            if(s.equals("0") && sum_number==1){
                                str_1 = str_1.substring(0,str_1.length()-1);
                                str_1 = str_1 + "1";
                                textView.setText(str_1);
                                sum_number++;
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
                            }else{
                                str_1 = str_1 + "1";
                                textView.setText(str_1);
                                sum_number++;
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
                            }
                        }else{
                            str_1 = str_1 + "1";
                            textView.setText(str_1);
                            sum_number++;
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
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Maximum digit reached", Toast.LENGTH_SHORT).show();
                    }
                }else{

                }
            }
        });


        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_2 = textView.getText().toString();
                if(after_equal==0){
                    str_2="";
                    after_equal=1;
                    sum_number=0;
                }
                if(right_num==1 && mul_num==1){
                    if(sum_number<15){
                        if(sum_number>0){
                            String s = str_2.substring(str_2.length()-1);
                            if(s.equals("0") && sum_number==1){
                                str_2 = str_2.substring(0,str_2.length()-1);
                                str_2 = str_2 + "2";
                                textView.setText(str_2);
                                sum_number++;
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
                            }else{
                                str_2 = str_2 + "2";
                                textView.setText(str_2);
                                sum_number++;
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
                            }
                        }else{
                            str_2 = str_2 + "2";
                            textView.setText(str_2);
                            sum_number++;
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
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Maximum digit reached", Toast.LENGTH_SHORT).show();
                    }
                }else{

                }

            }
        });


        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_3 = textView.getText().toString();
                if(after_equal==0){
                    str_3="";
                    after_equal=1;
                    sum_number=0;
                }
                if(right_num==1 && mul_num==1){
                    if(sum_number<15){
                        if(sum_number>0){
                            String s = str_3.substring(str_3.length()-1);
                            if(s.equals("0") && sum_number==1){
                                str_3 = str_3.substring(0,str_3.length()-1);
                                str_3 = str_3 + "3";
                                textView.setText(str_3);
                                sum_number++;
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
                            }else{
                                str_3 = str_3 + "3";
                                textView.setText(str_3);
                                sum_number++;
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
                            }
                        }else{
                            str_3 = str_3 + "3";
                            textView.setText(str_3);
                            sum_number++;
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
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Maximum digit reached", Toast.LENGTH_SHORT).show();
                    }
                }else{

                }
            }
        });


        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_4 = textView.getText().toString();
                if(after_equal==0){
                    str_4="";
                    after_equal=1;
                    sum_number=0;
                }
                if(right_num==1 && mul_num==1){
                    if(sum_number<15){
                        if(sum_number>0){
                            String s = str_4.substring(str_4.length()-1);
                            if(s.equals("0") && sum_number==1){
                                str_4 = str_4.substring(0,str_4.length()-1);
                                str_4 = str_4 + "4";
                                textView.setText(str_4);
                                sum_number++;
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
                            }else{
                                str_4 = str_4 + "4";
                                textView.setText(str_4);
                                sum_number++;
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
                            }
                        }else{
                            str_4 = str_4 + "4";
                            textView.setText(str_4);
                            sum_number++;
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
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Maximum digit reached", Toast.LENGTH_SHORT).show();
                    }
                }else{

                }
            }
        });


        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_5 = textView.getText().toString();
                if(after_equal==0){
                    str_5="";
                    after_equal=1;
                    sum_number=0;
                }
                if(right_num==1 && mul_num==1){
                    if(sum_number<15){
                        if(sum_number>0){
                            String s = str_5.substring(str_5.length()-1);
                            if(s.equals("0") && sum_number==1){
                                str_5 = str_5.substring(0,str_5.length()-1);
                                str_5 = str_5 + "5";
                                textView.setText(str_5);
                                sum_number++;
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
                            }else{
                                str_5 = str_5 + "5";
                                textView.setText(str_5);
                                sum_number++;
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
                            }
                        }else{
                            str_5 = str_5 + "5";
                            textView.setText(str_5);
                            sum_number++;
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
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Maximum digit reached", Toast.LENGTH_SHORT).show();
                    }
                }else{

                }
            }
        });


        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_6 = textView.getText().toString();
                if(after_equal==0){
                    str_6="";
                    after_equal=1;
                    sum_number=0;
                }
                if(right_num==1 && mul_num==1){
                    if(sum_number<15){
                        if(sum_number>0){
                            String s = str_6.substring(str_6.length()-1);
                            if(s.equals("0") && sum_number==1){
                                str_6 = str_6.substring(0,str_6.length()-1);
                                str_6 = str_6 + "6";
                                textView.setText(str_6);
                                sum_number++;
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
                            }else{
                                str_6 = str_6 + "6";
                                textView.setText(str_6);
                                sum_number++;
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
                            }
                        }else{
                            str_6 = str_6 + "6";
                            textView.setText(str_6);
                            sum_number++;
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
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Maximum digit reached", Toast.LENGTH_SHORT).show();
                    }
                }else{

                }
            }
        });


        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_7 = textView.getText().toString();
                if(after_equal==0){
                    str_7="";
                    after_equal=1;
                    sum_number=0;
                }
                if(right_num==1 && mul_num==1){
                    if(sum_number<15){
                        if(sum_number>0){
                            String s = str_7.substring(str_7.length()-1);
                            if(s.equals("0") && sum_number==1){
                                str_7 = str_7.substring(0,str_7.length()-1);
                                str_7 = str_7 + "7";
                                textView.setText(str_7);
                                sum_number++;
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
                            }else{
                                str_7 = str_7 + "7";
                                textView.setText(str_7);
                                sum_number++;
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
                            }
                        }else{
                            str_7 = str_7 + "7";
                            textView.setText(str_7);
                            sum_number++;
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
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Maximum digit reached", Toast.LENGTH_SHORT).show();
                    }
                }else{

                }
            }
        });


        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_8 = textView.getText().toString();
                if(after_equal==0){
                    str_8="";
                    after_equal=1;
                    sum_number=0;
                }
                if(right_num==1 && mul_num==1){
                    if(sum_number<15){
                        if(sum_number>0){
                            String s = str_8.substring(str_8.length()-1);
                            if(s.equals("0") && sum_number==1){
                                str_8 = str_8.substring(0,str_8.length()-1);
                                str_8 = str_8 + "8";
                                textView.setText(str_8);
                                sum_number++;
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
                            }else{
                                str_8 = str_8 + "8";
                                textView.setText(str_8);
                                sum_number++;
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
                            }
                        }else{
                            str_8 = str_8 + "8";
                            textView.setText(str_8);
                            sum_number++;
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
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Maximum digit reached", Toast.LENGTH_SHORT).show();
                    }
                }else{

                }
            }
        });


        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_9 = textView.getText().toString();
                if(after_equal==0){
                    str_9="";
                    after_equal=1;
                    sum_number=0;
                }
                if(right_num==1 && mul_num==1){
                    if(sum_number<15){
                        if(sum_number>0){
                            String s = str_9.substring(str_9.length()-1);
                            if(s.equals("0") && sum_number==1){
                                str_9 = str_9.substring(0,str_9.length()-1);
                                str_9 = str_9 + "9";
                                textView.setText(str_9);
                                sum_number++;
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
                            }else{
                                str_9 = str_9 + "9";
                                textView.setText(str_9);
                                sum_number++;
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
                            }
                        }else{
                            str_9 = str_9 + "9";
                            textView.setText(str_9);
                            sum_number++;
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
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Maximum digit reached", Toast.LENGTH_SHORT).show();
                    }
                }else{

                }
            }
        });


        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_dot = textView.getText().toString();
                if(after_equal==0){
                    str_dot="";
                    after_equal=1;
                    sum_number=1;
                }
                if(sum_number<15){
                    if(dot_dot==1 && right_num==1 && mul_num==1){
                        if(sum_number==0){
                            str_dot = str_dot + "0.";
                            textView.setText(str_dot);
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
                            sum_number++;
                        }else{
                            String s = str_dot.substring(str_dot.length()-1);
                            if(s.equals("√")){
                                str_dot = str_dot + "0.";
                                textView.setText(str_dot);
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
                            }else{
                                str_dot = str_dot + ".";
                                textView.setText(str_dot);
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
                            }
                        }
                    }else{

                    }
                }else{
                    Toast.makeText(MainActivity.this, "Maximum digit reached", Toast.LENGTH_SHORT).show();
                }

            }
        });


        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(null);
                zero_num=1;
                num_left=1;
                dot_dot=1;
                dot_left=1;
                sign_sign=1;
                sign_right=1;
                left_sign=1;
                right_num=1;
                evolution_right=1;
                evolution_sign=1;
                evolution_mul=1;
                sign_mul=1;
                left_mul=1;
                right_left=1;
                left_right=1;
                to_munus=1;
                mul_num=1;
                double_sign=0;
                sum_number=0;
                sum_left=0;
                sum_right=0;
            }
        });


        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_delete = textView.getText().toString();
                if(after_equal==0){
                    str_delete="";
                    after_equal=1;
                    sum_number=0;
                }
                if(str_delete.length()>1){
                    str_delete = str_delete.substring(0, str_delete.length()-1);
                if(str_delete.length()>0){
                    String re = str_delete.substring(str_delete.length()-1);
                    switch (re){
                        case "^":
                            str_delete = str_delete.substring(0, str_delete.length()-1);
                            re = str_delete.substring(str_delete.length()-1);
                            break;
                    }
                    switch (re){
                        case "0":
                            sum_number--;
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
                            sum_number--;
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
                            sum_number--;
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
                            sum_number--;
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
                            sum_number--;
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
                            sum_number--;
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
                            sum_number--;
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
                            sum_number--;
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
                            sum_number--;
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
                            sum_number--;
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
                            sum_left--;
                            left_sign=0;
                            left_mul=0;
                            left_right=0;
                            to_munus=1;
                            break;
                        case ")":
                            sum_right--;
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
                }else{
                    str_delete="";
                    zero_num=1;
                    num_left=1;
                    dot_dot=1;
                    dot_left=1;
                    sign_sign=1;
                    sign_right=1;
                    left_sign=1;
                    right_num=1;
                    evolution_right=1;
                    evolution_sign=1;
                    evolution_mul=1;
                    sign_mul=1;
                    left_mul=1;
                    right_left=1;
                    left_right=1;
                    to_munus=1;
                    mul_num=1;
                    double_sign=0;
                    sum_number=0;
                    sum_left=0;
                    sum_right=0;
                }
                textView.setText(str_delete);
            }
        });


        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_mul = textView.getText().toString();
                if(after_equal==0){
                    str_mul=after;
                    after_equal=1;
                }
                if(sum_number>0){
                    if(sum_number<15){
                        String s = str_mul.substring(str_mul.length()-1);
                        if(s.equals(".") && evolution_mul==1 && sign_mul==1 && left_mul==1){
                            str_mul = str_mul.substring(0, str_mul.length()-1);
                            str_mul = str_mul + "^2";
                            textView.setText(str_mul);
                            num_left=0;
                            mul_num=0;
                            sum_number++;
                        }else if(evolution_mul==1 && sign_mul==1 && left_mul==1){
                            str_mul = str_mul + "^2";
                            textView.setText(str_mul);
                            num_left=0;
                            mul_num=0;
                            sum_number++;
                        }else{

                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Maximum digit reached", Toast.LENGTH_SHORT).show();
                    }
                }else{

                }
            }
        });


        button_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_left = textView.getText().toString();
                if(after_equal==0){
                    str_left="";
                    after_equal=1;
                    sum_number=0;
                }
                if(num_left==1 && dot_left==1 && right_left==1){
                    str_left = str_left + "(";
                    textView.setText(str_left);
                    left_sign=0;
                    left_mul=0;
                    left_right=0;
                    to_munus=1;
                    sum_left++;
                }else{

                }
            }
        });


        button_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_right = textView.getText().toString();
                if(after_equal==0){
                    str_right=after;
                    after_equal=1;
                }
                if(str_right.length()>0){
                    String s = str_right.substring(str_right.length()-1);
                    if(s.equals(".") && sign_right==1 && evolution_right==1 && left_right==1){
                        str_right = str_right.substring(0, str_right.length()-1);
                        str_right = str_right + ")";
                        textView.setText(str_right);
                        right_num=0;
                        right_left=0;
                        sum_right++;
                    }else if(sign_right==1 && evolution_right==1 && left_right==1){
                        str_right = str_right + ")";
                        textView.setText(str_right);
                        right_num=0;
                        right_left=0;
                        sum_right++;
                    }else{

                    }
                }else{

                }
            }
        });


        button_evolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_evolution = textView.getText().toString();
                if(after_equal==0){
                    str_evolution="";
                    after_equal=1;
                    sum_number=0;
                }
                if(sum_number<15){
                    if(sum_number>0){
                        String s = str_evolution.substring(str_evolution.length()-1);
                        if(s.equals(".") && right_num==1){
                            str_evolution = str_evolution.substring(0, str_evolution.length()-1);
                            str_evolution = str_evolution + "√";
                            textView.setText(str_evolution);
                            zero_num=1;
                            num_left=1;
                            dot_dot=1;
                            dot_left=1;
                            evolution_right=0;
                            evolution_sign=0;
                            evolution_mul=0;
                            to_munus=1;
                            mul_num=1;
                            sum_number=0;
                        }else if(right_num==1){
                            str_evolution = str_evolution + "√";
                            textView.setText(str_evolution);
                            zero_num=1;
                            num_left=1;
                            dot_dot=1;
                            dot_left=1;
                            evolution_right=0;
                            evolution_sign=0;
                            evolution_mul=0;
                            to_munus=1;
                            mul_num=1;
                            sum_number=0;
                        }else{

                        }
                    }else{
                        if(right_num==1){
                            str_evolution = str_evolution + "√";
                            textView.setText(str_evolution);
                            zero_num=1;
                            num_left=1;
                            dot_dot=1;
                            dot_left=1;
                            evolution_right=0;
                            evolution_sign=0;
                            evolution_mul=0;
                            to_munus=1;
                            mul_num=1;
                            sum_number=0;
                        }else{

                        }
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Maximum digit reached", Toast.LENGTH_SHORT).show();
                }
            }
        });


        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_plus = textView.getText().toString();
                if(after_equal==0){
                    str_plus=after;
                    after_equal=1;
                }
                if(str_plus.length()>0){
                    String s =str_plus.substring(str_plus.length()-1);
                    if(s.equals("-") || s.equals("×") || s.equals("÷")){
                        if(double_sign==1 && to_change==1){
                            str_plus = str_plus.substring(0, str_plus.length()-3);
                            str_plus = str_plus + "+";
                            textView.setText(str_plus);
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
                        }else if(to_change==1){
                            str_plus = str_plus.substring(0, str_plus.length()-1);
                            str_plus = str_plus + "+";
                            textView.setText(str_plus);
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
                            mul_num=1;
                            to_change=1;
                        }else{

                        }
                    }else if(s.equals(".") && sign_sign==1 && left_sign==1 && evolution_sign==1 && to_change==1){
                        str_plus = str_plus.substring(0, str_plus.length()-1);
                        str_plus = str_plus + "+";
                        textView.setText(str_plus);
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
                        mul_num=1;
                        to_change=1;
                    } else if(sign_sign==1 && left_sign==1 && evolution_sign==1){
                        str_plus = str_plus + "+";
                        textView.setText(str_plus);
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
                        mul_num=1;
                        to_change=1;
                    }else{

                    }
                }else{

                }
            }
        });


        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_minus = textView.getText().toString();
                if(after_equal==0){
                    str_minus=after;
                    after_equal=1;
                }
                if(str_minus.length()>0){
                    String s =str_minus.substring(str_minus.length()-1);
                    if(s.equals("+") && to_change==1){
                        str_minus = str_minus.substring(0, str_minus.length()-1);
                        str_minus = str_minus + "-";
                        textView.setText(str_minus);
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
                    }else if(s.equals("×") || s.equals("÷")){
                        str_minus = str_minus + "(-";
                        textView.setText(str_minus);
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
                        left_mul=0;
                        left_sign=0;
                        left_right=0;
                        double_sign=1;
                        mul_num=1;
                        to_change=1;
                        sum_left++;
                    }else if(s.equals("√")){
                        str_minus = str_minus + "(-";
                        textView.setText(str_minus);
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
                        left_mul=0;
                        left_sign=0;
                        left_right=0;
                        double_sign=0;
                        mul_num=1;
                        to_change=0;
                        sum_left++;
                    } else if(s.equals(".") && to_munus==1 && to_change==1){
                        str_minus = str_minus.substring(0, str_minus.length()-1);
                        str_minus = str_minus + "-";
                        textView.setText(str_minus);
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
                    } else if(to_munus==1){
                        str_minus = str_minus + "-";
                        textView.setText(str_minus);
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
                        mul_num=1;
                        to_change=1;
                    }else{

                    }
                }else{
                    if(to_munus==1){
                        str_minus = str_minus + "-";
                        textView.setText(str_minus);
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
                        mul_num=1;
                        to_change=0;
                    }else{

                    }
                }
            }
        });


        button_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_multiply = textView.getText().toString();
                if(after_equal==0){
                    str_multiply=after;
                    after_equal=1;
                }
                if(str_multiply.length()>0){
                    String s =str_multiply.substring(str_multiply.length()-1);
                    if(s.equals("-") || s.equals("+") || s.equals("÷")){
                        if(double_sign==1 && to_change==1){
                            str_multiply = str_multiply.substring(0, str_multiply.length()-3);
                            str_multiply = str_multiply + "×";
                            textView.setText(str_multiply);
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
                        }else if(to_change==1){
                            str_multiply = str_multiply.substring(0, str_multiply.length()-1);
                            str_multiply = str_multiply + "×";
                            textView.setText(str_multiply);
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
                            mul_num=1;
                            to_change=1;
                        }else{

                        }
                    }else if(s.equals(".") && sign_sign==1 && left_sign==1 && evolution_sign==1 && to_change==1){
                        str_multiply = str_multiply.substring(0, str_multiply.length()-1);
                        str_multiply = str_multiply + "×";
                        textView.setText(str_multiply);
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
                        mul_num=1;
                        to_change=1;
                    } else if(sign_sign==1 && left_sign==1 && evolution_sign==1){
                        str_multiply = str_multiply + "×";
                        textView.setText(str_multiply);
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
                        mul_num=1;
                        to_change=1;
                    }else{

                    }
                }else{

                }
            }
        });


        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_divide = textView.getText().toString();
                if(after_equal==0){
                    str_divide=after;
                    after_equal=1;
                }
                if(str_divide.length()>0){
                    String s =str_divide.substring(str_divide.length()-1);
                    if(s.equals("-") || s.equals("×") || s.equals("+")){
                        if(double_sign==1 && to_change==1){
                            str_divide = str_divide.substring(0, str_divide.length()-3);
                            str_divide = str_divide + "÷";
                            textView.setText(str_divide);
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
                        }else if(to_change==1){
                            str_divide = str_divide.substring(0, str_divide.length()-1);
                            str_divide = str_divide + "÷";
                            textView.setText(str_divide);
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
                            mul_num=1;
                            to_change=1;
                        }else{

                        }
                    }else if(s.equals(".") && sign_sign==1 && left_sign==1 && evolution_sign==1 && to_change==1){
                        str_divide = str_divide.substring(0, str_divide.length()-1);
                        str_divide = str_divide + "÷";
                        textView.setText(str_divide);
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
                        mul_num=1;
                        to_change=1;
                    }
                    else if(sign_sign==1 && left_sign==1 && evolution_sign==1){
                        str_divide = str_divide + "÷";
                        textView.setText(str_divide);
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
                        mul_num=1;
                        to_change=1;
                    }else{

                    }
                }else{

                }
            }
        });


        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_equal = textView.getText().toString();

                if(after_equal==0){
                    str_equal = after;
                }

                if(sum_left>sum_right){
                    for(int i=0;i<sum_left-sum_right;i++)
                        str_equal = str_equal + ")";
                }else{
                    for(int i=0;i<sum_right-sum_left;i++)
                        str_equal = "(" + str_equal;
                }

                while(str_equal.length()>0){
                    String s = str_equal.substring(str_equal.length()-1);
                    if(s.equals("(") || s.equals("√") || s.equals("+") || s.equals("-") || s.equals("×") || s.equals("÷")){
                        str_equal = str_equal.substring(0, str_equal.length()-1);
                    }else{
                        break;
                    }
                }

                if(str_equal.length()>0){
                    Calculate calculator = new Calculate(str_equal);
                    String consequence = calculator.calculate();
                    if(consequence!=null){
                        if(consequence.substring(0, 1).equals("#")){
                            consequence=consequence.substring(1);
                            consequence="-"+consequence;
                        }
                        textView.setText(str_equal+"="+consequence);
                    }else{
                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                }

                if(i<11){
                    data[i]=textView.getText().toString();
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            MainActivity.this, android.R.layout.simple_list_item_1, data);
                    ListView listView = (ListView) findViewById(R.id.list_view);
                    listView.setAdapter(adapter);
                    i++;
                }
                else{
                    data[i]=textView.getText().toString();
                    data[1]=data[2];
                    data[2]=data[3];
                    data[3]=data[4];
                    data[4]=data[5];
                    data[5]=data[6];
                    data[6]=data[7];
                    data[7]=data[8];
                    data[8]=data[9];
                    data[9]=data[10];
                    data[10]=data[i];
                    data[i]="";
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            MainActivity.this, android.R.layout.simple_list_item_1, data);
                    ListView listView = (ListView) findViewById(R.id.list_view);
                    listView.setAdapter(adapter);
                }

                int m = textView.getText().toString().lastIndexOf("=");
                if(m>=0){
                    after = textView.getText().toString().substring(m+1);
                    sum_number=after.length();
                    after_equal=0;
                    zero_num=1;
                    num_left=1;
                    dot_dot=1;
                    dot_left=1;
                    sign_sign=1;
                    sign_right=1;
                    left_sign=1;
                    right_num=1;
                    evolution_right=1;
                    evolution_sign=1;
                    evolution_mul=1;
                    sign_mul=1;
                    left_mul=1;
                    right_left=1;
                    left_right=1;
                    to_munus=1;
                    mul_num=1;
                    double_sign=0;
                    sum_left=0;
                    sum_right=0;
                }else{
                    after="";
                }
            }
        });
    }
}
