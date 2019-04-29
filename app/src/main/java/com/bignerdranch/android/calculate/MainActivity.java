package com.bignerdranch.android.calculate;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.DOMStringList;

public class MainActivity extends AppCompatActivity {

    private Button bt_zero;
    private Button bt_one;
    private Button bt_two;
    private Button bt_three;
    private Button bt_four;
    private Button bt_five;
    private Button bt_six;
    private Button bt_seven;
    private Button bt_eight;
    private Button bt_nine;
    private Button bt_back;
    private Button bt_multiply;
    private Button bt_divide;
    private Button bt_sub;
    private Button bt_add;
    private Button bt_point;
    private Button bt_equal;
    private Button bt_clear;
    private EditText et_edit;


    private StringBuffer str_display = new StringBuffer();
    private boolean flag = true;
    private String str_oper = "+";
    private String str_result = "0";
    private double num1 = 0.0;
    private double num2;
    //java中boolean的默认值是false 0
    private boolean b_add;
    private boolean b_sub;
    private boolean b_mul;
    private boolean b_div;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_zero = (Button) findViewById(R.id.bt_zero);
        bt_one = (Button) findViewById(R.id.bt_one);
        bt_two = (Button) findViewById(R.id.bt_two);
        bt_three = (Button) findViewById(R.id.bt_three);
        bt_four = (Button) findViewById(R.id.bt_four);
        bt_five = (Button) findViewById(R.id.bt_five);
        bt_six = (Button) findViewById(R.id.bt_six);
        bt_seven = (Button) findViewById(R.id.bt_seven);
        bt_eight = (Button) findViewById(R.id.bt_eight);
        bt_nine = (Button) findViewById(R.id.bt_nine);
        bt_back = (Button) findViewById(R.id.bt_back);
        bt_multiply = (Button) findViewById(R.id.bt_multiply);
        bt_divide = (Button) findViewById(R.id.bt_divide);
        bt_sub = (Button) findViewById(R.id.bt_sub);
        bt_add = (Button) findViewById(R.id.bt_add);
        bt_point = (Button) findViewById(R.id.bt_point);
        bt_equal = (Button) findViewById(R.id.bt_equal);
        bt_clear = (Button) findViewById(R.id.bt_clear);
        et_edit = (EditText) findViewById(R.id.et_edit);
        et_edit.setText("0.0");

        bt_zero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("0");
                et_edit.setText(str_display.toString());
            }
        });

        bt_one.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("1");
                et_edit.setText(str_display.toString());
            }
        });

        bt_two.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("2");
                et_edit.setText(str_display.toString());
            }
        });
        //TODO bt_two ~ bt_nine

        //TODO point back
        bt_three.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("3");
                et_edit.setText(str_display.toString());
            }
        });

        bt_four.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("4");
                et_edit.setText(str_display.toString());
            }
        });

        bt_five.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("5");
                et_edit.setText(str_display.toString());
            }
        });

        bt_six.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("6");
                et_edit.setText(str_display.toString());
            }
        });

        bt_seven.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("7");
                et_edit.setText(str_display.toString());
            }
        });

        bt_eight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("8");
                et_edit.setText(str_display.toString());
            }
        });

        bt_nine.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_display.append("9");
                et_edit.setText(str_display.toString());
            }
        });

        bt_point.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    str_display.append(".");
                    et_edit.setText(str_display.toString());
                    flag = false;
                }
            }
        });


    //bt_add监听，即按下add后所发生的事件
        bt_add.setOnClickListener(new OnClickListener() {
            @Override
                public void onClick(View v) {
                str_oper = "+";
                //输入不为空则str_display = null
                if(b_add == false && str_display.toString() != null) {

                    // TODO
                    num1 = Double.parseDouble(str_display.toString());
                    et_edit.setText(String.valueOf(num1));
                    b_add = true;
                    //str_display = new StringBuffer("");

                } else {

                    if (str_display.toString() != "") {
                        //此处"num1 += ..."表示连加，即不点击"="时，1+1+ 直接显示 2
                        num1 += Double.parseDouble(str_display.toString());
                        //存入operate之前的数字，重置str_display,期待下一次的输入
                        //str_result = str_display.toString();///修复原作者源代码中每次onStart一次后进行，点击add||sub||...运算时，显示为0的bug
                        //str_display = new StringBuffer("");
                    }
                    // TODO Debug 对于onStart后直接点击oper会产生故障，初步定位是下句的类型转换问题
                    et_edit.setText(String.valueOf(num1));
                }
                /*
                //暂时注释，即停止在add||sub...对str_result的使用，查看效果
                //更新str_result
                if(str_result != null) {
                    //string -> double转型
                    num1 = Double.parseDouble(str_result);
                    str_result = null;
                }
                */
                //传值 -> EditText 显示于Edit框
                str_display = new StringBuffer("");
                flag = true;
            }
        });

        bt_sub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_oper = "-";
                //if的判断，不会让onStart后第一次输入1时，显示为-1，即fixed else语句块中"num1 -= ..."的错误
                if(b_sub == false && str_display.toString() != "") {

                    num1 = Double.parseDouble(str_display.toString());
                    et_edit.setText(String.valueOf(num1));
                    //str_display = new StringBuffer("");
                    b_sub = true;

                } else {

                    if (str_display.toString() != "") {
                        num1 -= Double.parseDouble(str_display.toString());
                        //str_display = new StringBuffer("");
                    }
                    et_edit.setText(String.valueOf(num1));

                }
                str_display = new StringBuffer("");//此句为整合if(...) else (...)中的重置str_display语句，看起来更简(zhuang)洁(B)
                flag = true;
            }
        });

    //multiply
        bt_multiply.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                str_oper = "*";
                // b_mul || b_sub...作用是识别此运算是否为第一次出现(0为第一次)
                if(b_mul == false && str_display.toString() != "") {

                    num1 = Double.parseDouble(str_display.toString());
                    et_edit.setText(String.valueOf(num1));
                    //为进入运算做准备
                    b_mul = true;

                } else {

                    if(str_display.toString() != "") {
                        num1 *= Double.parseDouble(str_display.toString());
                        et_edit.setText(String.valueOf(num1));
                        //str_display = new StringBuffer("");
                    }

                }
                str_display = new StringBuffer("");
                flag = true;
            }
        });

    //div
        bt_divide.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_oper = "/";
                if(b_div == false && str_display.toString() != "") {
                    num1 = Double.parseDouble(str_display.toString());
                    et_edit.setText(String.valueOf(num1));
                    b_div = true;
                } else {
                    if(str_display.toString() != "") {
                        double numx = Double.parseDouble(str_display.toString());
                        if(numx == 0) {
                            Toast.makeText(MainActivity.this, "除数不能为零", Toast.LENGTH_SHORT).show();
                        } else {
                            num1 /= numx;
                        }
                    }
                    et_edit.setText(String.valueOf(num1));

                }
                str_display = new StringBuffer("");
                flag = true;
            }
        });


        //发现如果只是进行单加，或单减，即单oper运算，想要得到结果只需多点击一次运算按钮
        //所以equal的存在是为了进行运算栈(str_oper) 里oper 的类型识别，从而达到多运算效果
        bt_equal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str_oper.equals("+")) {
                    //存入operate之后的再次输入，存入num2，避免覆盖operate之前的num1
                    num2 = Double.parseDouble(str_display.toString());
                    //进行相关operate
                    str_result = String.valueOf(num1+num2);
                    //运算结果显示于Edit框
                    et_edit.setText(str_result);
                    //一次运算结束重置str_display
                    str_display = new StringBuffer("");
                }
                if(str_oper.equals("-")) {
                    num2 = Double.parseDouble(str_display.toString());

                    str_result = String.valueOf(num1 - num2);
                    et_edit.setText(str_result);
                    str_display = new StringBuffer("");
                }
            //TODO mul
                if(str_oper.equals("*")) {
                    num2 = Double.parseDouble(str_display.toString());

                    str_result = String.valueOf(num1 * num2);
                    et_edit.setText(str_result);
                    str_display = new StringBuffer("");
                }
                if(str_oper.equals("/")) {
                    num2 = Double.parseDouble(str_display.toString());
                    str_result = String.valueOf(num1 / num2);
                    et_edit.setText(str_result);
                    str_display = new StringBuffer("");
                }
            }
        });

        bt_clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                str_oper = "+";
                str_display = new StringBuffer("");
                str_result = null;
                num1 = 0;
                num2 = 0;
                flag = true;
                b_add = false;
                b_div = false;
                b_mul = false;
                b_sub = false;
                et_edit.setText("0.0");
            }
        });
    }
}