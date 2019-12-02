package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button ADD, SUB, Multiply, DIV, left, right, sin, cos, tan,  clear,log,exit,delete;
    private Button NINE, EIGHT, SEVEN,SIX, FIVE, FOUR, THREE, TWO, ONE, zero;
    private Button percent,dot, equal, sqrt, square, exp,help;
    private Button cm,dm,m,cm3,dm3,m3;
    private Button  二进制, 八进制,十进制,十六进制;
    private EditText input = null;//显示输入的数
    boolean clear_flag;//显示器是否需要清除,false表示需要清除


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* 将指定的资源xml文件加载到对应的activity中 */
        setContentView(R.layout.activity_layout);
        //实例化对象
        ADD = findViewById(R.id.ADD);
        SUB = findViewById(R.id.SUB);
        Multiply = findViewById(R.id.Multiply);
        DIV = findViewById(R.id.DIV);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        tan = findViewById(R.id.tan);
        NINE = findViewById(R.id.NINE);
        EIGHT = findViewById(R.id.EIGHT);
        SEVEN = findViewById(R.id.SEVEN);
        SIX = findViewById(R.id.SIX);
        FIVE = findViewById(R.id.FIVE);
        FOUR = findViewById(R.id.FOUR);
        THREE = findViewById(R.id.THREE);
        TWO = findViewById(R.id.TWO);
        ONE = findViewById(R.id.ONE);
        zero = findViewById(R.id.zero);
        help = findViewById(R.id.help);
        exit=findViewById(R.id.exit);

        clear = findViewById(R.id.clear);
        delete=findViewById(R.id.delete);
        percent = findViewById(R.id.percent);

        dot = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);
        input = findViewById(R.id.input);
        sqrt = findViewById(R.id.sqrt);
        square = findViewById(R.id.square);
        exp = findViewById(R.id.exp);
        二进制 = findViewById(R.id.二进制);
        八进制 = findViewById(R.id.八进制);
        十六进制 = findViewById(R.id.十六进制);
        十进制=findViewById(R.id.十进制);
        log=findViewById(R.id.log);
        m=findViewById(R.id.m);
        cm=findViewById(R.id.cm);
        dm=findViewById(R.id.dm);
        m3=findViewById(R.id.m3);
        dm3=findViewById(R.id.dm3);
        cm3=findViewById(R.id.cm3);






//为按钮添加监听器
        ADD.setOnClickListener(this);
        SUB.setOnClickListener(this);
        Multiply.setOnClickListener(this);
        DIV.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        NINE.setOnClickListener(this);
        EIGHT.setOnClickListener(this);
        SEVEN.setOnClickListener(this);
        clear.setOnClickListener(this);
        delete.setOnClickListener(this);
        SIX.setOnClickListener(this);
        FIVE.setOnClickListener(this);
        FOUR.setOnClickListener(this);
        help.setOnClickListener(this);
        THREE.setOnClickListener(this);
        TWO.setOnClickListener(this);
        ONE.setOnClickListener(this);
        percent.setOnClickListener(this);
        zero.setOnClickListener(this);
        dot.setOnClickListener(this);
        equal.setOnClickListener(this);
        input.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        square.setOnClickListener(this);
        exp.setOnClickListener(this);
        二进制.setOnClickListener(this);
        八进制.setOnClickListener(this);
        十六进制.setOnClickListener(this);
        十进制.setOnClickListener(this);
        log.setOnClickListener(this);
        exit.setOnClickListener(this);
        m.setOnClickListener(this);
        dm.setOnClickListener(this);
        cm.setOnClickListener(this);
        cm3.setOnClickListener(this);
        dm3.setOnClickListener(this);
        m3.setOnClickListener(this);
    }

    public void onClick(View v) {
        String str = input.getText().toString();//获取视图view对象里的字符串,用str保存EditText中的内容
        switch (v.getId()) {
            case R.id.zero:
            case R.id.ONE:
            case R.id.TWO:
            case R.id.THREE:
            case R.id.FOUR:
            case R.id.FIVE:
            case R.id.SIX:
            case R.id.SEVEN:
            case R.id.EIGHT:
            case R.id.NINE:
            case R.id.dot:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";//赋值为空
                    //input.setText("");
                }
                input.setText(str + ((Button) v).getText());//获得按钮的test值
                break;
            case R.id.SUB:
            case R.id.DIV:
            case R.id.Multiply:
            case R.id.ADD:
                clear_flag = false;
                input.setText(str + " " + ((Button) v).getText() + " ");//在屏幕显示+，-，*，/，并于字符间有空格,(Button)v表示将v强制转换为Button类型
                break;
            /*定义按钮+/-的在显示屏的显示值*/

            case R.id.sqrt:
                if (Double.parseDouble(str) >= 0) {
                    double result2 = Math.sqrt(Double.parseDouble(str));
                    String r2 = Double.parseDouble(str)+"^(1/2)="+String.valueOf(result2);
                    input.setText(r2);
                } else {
                    Toast.makeText(MainActivity.this, "请输入非负数！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.percent://百分号
                double result3 = 0.01 * Double.parseDouble(str);
                String r3 = Double.parseDouble(str)+"%="+String.valueOf(result3);
                input.setText(r3);
                break;
            case R.id.square://x的平方
                double result4 = Math.pow(Double.parseDouble(str), 2);
                String r4 =Double.parseDouble(str)+"^2="+ String.valueOf(result4);
                input.setText(r4);
                break;
            case R.id.exp://e^x
                double result7 = Math.exp(Double.parseDouble(str));
                String r7 = "e^"+Double.parseDouble(str)+"="+String.valueOf(result7);
                input.setText(r7);
                break;
            case R.id.sin:
                double result5 = Math.sin(Double.parseDouble(str));
                String r5 = "sin"+Double.parseDouble(str)+"="+String.valueOf(result5);
                input.setText(r5);
                break;
            case R.id.cos:
                double result6 = Math.cos(Double.parseDouble(str));
                String r6 = "cos"+Double.parseDouble(str)+"="+String.valueOf(result6);
                input.setText(r6);
                break;
            case R.id.tan:
                double result8 = Math.tan(Double.parseDouble(str));
                String r8 ="tan"+Double.parseDouble(str)+"="+ String.valueOf(result8);
                input.setText(r8);
                break;
            case R.id.log:
                double result9 = Math.log(Double.parseDouble(str));
                String r9 = "log"+Double.parseDouble(str)+"="+String.valueOf(result9);
                input.setText(r9);
                break;
            case R.id.delete:
               if(str.length()!=0){
                   str=str.substring(0,str.length()-1);//去除最后一位字符
                   input.setText(str);
               }
               break;
            case R.id.clear:
                clear_flag = false;
                input.setText("");
                break;
            case R.id.equal:
                getResult();
                break;
            case R.id.二进制://这是一个二进制的数
                int n = Integer.parseInt(input.getText().toString(),2);//将String字符类型转换为Integer整型数据
                String a=Integer.toOctalString(n);
                String b=Integer.toHexString(n);
                str="二进制数"+Double.parseDouble(str)+"的"+"八进制为:"+a+";十进制:"+n+";十六进制:"+b;
                input.setText(str);//返回int变量的二进制表示的字符串
                break;
            case R.id.八进制:
                int n1 = Integer.parseInt(input.getText().toString(),8);//将String字符类型转换为Integer整型数据
                String a1=Integer.toBinaryString(n1);
                String b1=Integer.toHexString(n1);
                str="八进制数"+Double.parseDouble(str)+"的"+"二进制:"+a1+";十进制:"+n1+";十六进制:"+b1;
                input.setText(str);//返回int变量的ba进制表示的字符串
                break;
            case R.id.十六进制:
                int n2 = Integer.parseInt(input.getText().toString(),16);//将String字符类型转换为Integer整型数据
                String a2=Integer.toBinaryString(n2);
                String b2=Integer.toOctalString(n2);
                str="十六进制数"+Double.parseDouble(str)+"的"+"二进制:"+a2+";八进制:"+b2+";十进制:"+n2;
                input.setText(str);//返回int变量的shiliu进制表示的字符串
                break;
            case R.id.十进制:
                int n3 =Integer.parseInt(input.getText().toString(),10);
                String a3=Integer.toBinaryString(n3);
                String b3=Integer.toHexString(n3);
                String c=Integer.toOctalString(n3);
                str="十进制数"+Double.parseDouble(str)+"的"+"二进制:"+a3+";八进制:"+c+";十六进制:"+b3;
                input.setText(str);
                break;
            case R.id.help:
               /* String tem="除了加减乘除以外的运算均要先输入数字";
                input.setText(tem);*/
               Toast.makeText(MainActivity.this, "这是帮助", Toast.LENGTH_LONG).show();
                break;
            case R.id.exit:
                System.exit(0);
                break;
            case R.id.cm://输入的是cm,转换成m
                double result10=Double.valueOf(str)/100;
                double dm=Double.valueOf(str)/10;
                //String r10=String.valueOf(result10);
                str=Double.valueOf(str)+"cm="+dm+"dm"+"= "+result10+"m";
                input.setText(str);
                break;
            case R.id.dm:
                double cm=Double.valueOf(str)*10;
                double m=Double.valueOf(str)/10;
                str=Double.valueOf(str)+"dm="+cm+"cm="+m+"m";
                input.setText(str);
                break;
            case R.id.m://输入的是m,
                double result11=Double.valueOf(str)*100;
                double dm1=Double.valueOf(str)*10;
                //String r11=String.valueOf(result11);
                str=Double.valueOf(str)+"m="+result11+"cm="+dm1+"dm";
                input.setText(str);
                break;
            case R.id.cm3:
                double result12=Double.valueOf(str)/1000000;
                double dm3=Double.valueOf(str)/1000;
                str=Double.valueOf(str)+"cm^3="+dm3+"dm^3="+result12+"m^3";
                input.setText(str);
                break;
            case R.id.dm3:
                double m3=Double.valueOf(str)/1000000;
                double cm3=Double.valueOf(str)*1000;
                str=Double.valueOf(str)+"dm^3="+cm3+"cm^3="+m3+"m^3";
                input.setText(str);
                break;
            case R.id.m3:
                double result13=Double.valueOf(str)*1000000;
                double dm33=Double.valueOf(str)*1000;
                str=Double.valueOf(str)+"m^3="+result13+"cm^3="+dm33+"dm^3";
                input.setText(str);
                break;
        }
    }
       private void getResult( ) {
            String exp = input.getText().toString();
            /*如果字符串不存在空格，返回原字符串的值*/
            if (!exp.contains(" ")) {

                return;
            }
            clear_flag = true;
            double result = 0.0;
            String s1 = exp.substring(0, exp.indexOf(" ")); //获取运算符前面的字符串，获得第一个空格前的子字符串
            String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);//得到算法符号
            String s2 = exp.substring(exp.indexOf(" ") + 3);//获取运算符后面的字符串，获得第一个空格后面的第三个字符开始到末尾的字符
            if (!s1.equals(" ") && !s2.equals(" ")) {
                double d1 = Double.parseDouble(s1);
                double d2 = Double.parseDouble(s2);
                switch (op) {
                    case "+":
                        result = d1 + d2;
                        break;
                    case "-":
                        result = d1 - d2;

                        break;
                    case "*":
                        result = d1 * d2;
                        break;
                    case "/":
                        if (d2 == 0) {
                            Toast.makeText(MainActivity.this, "除数不能为0", Toast.LENGTH_SHORT).show();
                        } else {
                            result = d1 / d2;
                        }
                        break;
                }
                //判断第一个字符是否为小数点，如果是小数点自动变为0.x,如果用正负号转换，自动变为-0.x
                if (s1.charAt(0) == '.') {
                    d1 = 0 + d1;
                }
                if (s2.charAt(0) == '.') {
                    d2 = 0 + d2;
                }
                if (s1.charAt(0) != '-') {
                    d1 = 0 - d1;
                }

                input.setText(String.valueOf(result));//把运算结果输出到显示屏

            } else if (s1.charAt(0) != '-') {
                String s = exp.substring(2, exp.indexOf(" "));
                double d1 = 0 - Double.parseDouble(s);
            } else if (s2.charAt(0) != '-') {
                String s = exp.substring(exp.indexOf(" ") + 4);
                double d2 = 0 - Double.parseDouble(s);
            }

        }

    }
