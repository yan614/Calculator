package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button ADD,SUB,Multiply,DIV,left,right,sin,cos,length,volume,scale,NINE,EIGHT,SEVEN,clear;
    private Button SIX,FIVE,FOUR,help,THREE,TWO,ONE,transform,percent,zero,dot,equal,sqrt;
    private EditText input=null;//显示输入的数
    boolean clear_flag;//显示器是否需要清除

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* 将指定的资源xml文件加载到对应的activity中 */
        setContentView(R.layout.activity_layout);
        //实例化对象
        ADD = (Button) findViewById(R.id.ADD);
        SUB = (Button) findViewById(R.id.SUB);
        Multiply = (Button) findViewById(R.id.Multiply);
        DIV = (Button) findViewById(R.id.DIV);
        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);
        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        length = (Button) findViewById(R.id.length);
        volume = (Button) findViewById(R.id.volume);
        scale = (Button) findViewById(R.id.scale);
        NINE = (Button) findViewById(R.id.NINE);
        EIGHT = (Button) findViewById(R.id.EIGHT);
        SEVEN = (Button) findViewById(R.id.SEVEN);
        SIX = (Button) findViewById(R.id.SIX);
        FIVE = (Button) findViewById(R.id.FIVE);
        FOUR= (Button) findViewById(R.id.FOUR);
        help= (Button) findViewById(R.id.help);
        THREE = (Button) findViewById(R.id.THREE);
        TWO = (Button) findViewById(R.id.TWO);
        ONE = (Button) findViewById(R.id.ONE);
        clear = (Button) findViewById(R.id.clear);
        transform = (Button) findViewById(R.id.transform);
        percent = (Button) findViewById(R.id.percent);
        zero = (Button) findViewById(R.id.zero);
        dot = (Button) findViewById(R.id.dot);
        equal = (Button) findViewById(R.id.equal);
        input=(EditText) findViewById(R.id.input);
        sqrt=(Button) findViewById(R.id.sqrt);

//为按钮添加监听器
        ADD.setOnClickListener(this);
        SUB.setOnClickListener(this);
        Multiply.setOnClickListener(this);
        DIV.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        length.setOnClickListener(this);
        volume.setOnClickListener(this);
        scale.setOnClickListener(this);
        NINE.setOnClickListener(this);
        EIGHT.setOnClickListener(this);
        SEVEN.setOnClickListener(this);
        clear.setOnClickListener(this);
        SIX.setOnClickListener(this);
        FIVE.setOnClickListener(this);
        FOUR.setOnClickListener(this);
        help.setOnClickListener(this);
        THREE.setOnClickListener(this);
        TWO.setOnClickListener(this);
        ONE.setOnClickListener(this);
        transform.setOnClickListener(this);
        percent.setOnClickListener(this);
        zero.setOnClickListener(this);
        dot.setOnClickListener(this);
        equal.setOnClickListener(this);
        input.setOnClickListener(this);
        sqrt.setOnClickListener(this);

    }
    public void onClick(View v){
        String str = input.getText().toString();//获取视图view对象里的字符串
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
                    str="";
                    //input.setText("");
                }
                input.setText(str + ((Button) v).getText());//获得按钮的test值
                break;
            case R.id.SUB:
            case R.id.DIV:
            case R.id.Multiply:
            case R.id.ADD:
                clear_flag=false;
                input.setText(str + " " + ((Button) v).getText() + " ");//在屏幕显示+，-，*，/，并于字符间有空格,(Button)v表示将v强制转换为Button类型
                break;
            /*定义按钮+/-的在显示屏的显示值*/

            case R.id.sqrt:
                if(Double.parseDouble(str)>=0){
                    double result2 =Math.sqrt(Double.parseDouble(str));
                    String r2=String.valueOf(result2);
                    input.setText(r2);
                }else{
                    Toast.makeText(MainActivity.this,"请输入非负数！",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.percent://百分号
                double result3 =0.01* Double.parseDouble(str);
                String r3=String.valueOf(result3);
                input.setText(r3);
                break;
            case R.id.square://x的2次幂
                double result4 =Math.pow(Double.parseDouble(str),2);
                String r4=String.valueOf(result4);
                input.setText(r4);
                break;
            case R.id.sin:
                double result5 =Math.sin(Double.parseDouble(str));
                String r5=String.valueOf(result5);
                input.setText(r5);
                break;
            case R.id.cos:
                double result6 =Math.cos(Double.parseDouble(str));
                String r6=String.valueOf(result6);
                input.setText(r6);
                break;
            case R.id.delete:
                input.setText(str.substring(0, str.length() - 1));//从字符串的0位置开始，索引到字符串的倒数第二个字符串
                break;
            case R.id.clear:
                clear_flag = false;
                input.setText("");
                break;
            case R.id.equal:
                getResult();
                break;
        }
    }
    private void getResult() {
        String exp = input.getText().toString();
        /*如果字符串不存在空格，返回原字符串的值*/
        if (!exp.contains(" ")) {
            return;
        }
      /*  if (clear_flag) {
            clear_flag = false;
            return;
        }*/
        clear_flag = true;
        double result = 0.0;
        String s1 = exp.substring(0, exp.indexOf(" ")); //获取运算符前面的字符串，获得第一个空格前的子字符串
        String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);//获得第一个空格后面的第一个字符
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
            if (s1.charAt(0)=='.') {
                d1=0+d1;
            }
            if(s2.charAt(0)=='.'){
                d2=0+d2;
            }
            if(s1.charAt(0)!='-'){
                d1=0-d1;
            }

            input.setText(String.valueOf(result));//把运算结果输出到显示屏

        } else if(s1.charAt(0)!='-'){
            String s = exp.substring(2, exp.indexOf(" "));
            double d1 =0- Double.parseDouble(s);
        }else if(s2.charAt(0)!='-'){
            String s = exp.substring(exp.indexOf(" ") + 4);
            double d2 =0- Double.parseDouble(s);
        }else
            return;

    }
}
