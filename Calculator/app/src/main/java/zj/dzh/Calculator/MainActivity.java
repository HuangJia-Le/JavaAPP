package zj.dzh.Calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //显示结果
    private EditText resultText;
    //按钮0-9
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    //运算符
    private  Button plus;   // 加号+
    private  Button sub;    // 减号-
    private  Button multi;  // 乘号×
    private  Button divide; // 除号÷
    private  Button point;  // 小数点.
    private  Button equal;  // 等于=
    private  Button clean;  // 清空
    private  Button delete; // 删除

    //当该页面被调用时，会执行该函数
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //在Activity的onCreate方法中，调用布局文件，渲染界面。
        super.onCreate(savedInstanceState);
        //通过Activity的setContentView方法进行渲染之后，它才会显示到该Activity视图上
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        //绑定数字控件
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        //绑定运算符控件
        plus = findViewById(R.id.plus);
        sub = findViewById(R.id.sub);
        multi = findViewById(R.id.multi);
        divide = findViewById(R.id.divide);
        point = findViewById(R.id.point);
        equal = findViewById(R.id.equal);
        clean = findViewById(R.id.clean);
        delete = findViewById(R.id.delete);
        //绑定文本框
        resultText = findViewById(R.id.result);

        //设置点击事件的监听器
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        plus.setOnClickListener(this);
        sub.setOnClickListener(this);
        multi.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);
        point.setOnClickListener(this);
        clean.setOnClickListener(this);
        delete.setOnClickListener(this);
    }

    //获取文本内容
    @Override
    public void onClick(View view) {
        String input = resultText.getText().toString();
        switch (view.getId()){//选择按钮id
            case R.id.btn0:
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
                resultText.setText(input + ((Button)view).getText());
                break;
            case R.id.point:
                if (input.isEmpty() || input.substring(input.length() - 1).equals(" "))
                    return;//如果最后是空格，无响应
                else
                    resultText.setText(input + '.');
                break;
            //加减乘除，运算符前后都是空格
            case R.id.plus:
            case R.id.sub:
            case R.id.multi:
            case R.id.divide:
                resultText.setText(input + " " + ((Button)view).getText() + " ");
                break;
            case R.id.clean://清除输入框
                resultText.setText("");
                break;
            case R.id.delete://从后往前删除字符
                if(!input.isEmpty())
                    resultText.setText(input.substring(0, input.length() - 1));
                break;
            case R.id.equal://计算运算结果
                getResult();//回调函数
                break;
        }
    }

    //运算结果的方法
    private void getResult(){
        //获取文本框的内容
        String exp = resultText.getText().toString();
        if(exp==null||exp.equals("")){//如果内容为空
            return;
        }
        if(!exp.contains(" ")){//如果不包含运算符
            return;
        }
        double result = 0.0;//返回结果
        //运算符前的数字，从0下标到第一个空格下标前
        String s1 = exp.substring(0,exp.indexOf(" "));
        //运算符，第一个空格下标和第二个空格下标之间
        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        //运算符后的数字，从第二个空格后全是
        String s2 = exp.substring(exp.indexOf(" ")+3);

        if(!s1.equals("")&&!s2.equals("")) {//如果数字合法
            double d1 = Double.parseDouble(s1);//则数字都是double类型
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) //如果是 +
                result = d1 + d2;
            else if (op.equals("-"))
                result = d1 - d2;
            else if (op.equals("×"))
                result = d1 * d2;
            else if (op.equals("÷")) {
                if (d2 == 0) //如果被除数是0
                    Toast.makeText(this,"除数不能为0，请重新输入！",Toast.LENGTH_SHORT).show();
                else //否则执行正常是除法运算
                    result = d1 / d2;
            }

            if (!s1.contains(".") && !s2.contains(".") && !op.equals("÷")) {//如果都是整型
                int r = (int) result;
                resultText.setText(r + "");
            } else{//如果有浮点型
                resultText.setText(result + "");
            }
        } else if(!s1.equals("") && s2.equals("")){//如果是只输入运算符前的数
            return;//直接返回当前文本框的内容
        } else if(s1.equals("") && !s2.equals("")){//如果是只输入运算符后面的数
            double d2 = Double.parseDouble(s2);
            //运算符前没有输入数字
            if (op.equals("+"))
                result = 0 + d2;
            else if (op.equals("-"))
                result = 0 - d2;
            else if (op.equals("×"))
                result = 0;
            else if (op.equals("÷"))
                result = 0;

            if (!s2.contains(".")) {
                int r = (int) result;
                resultText.setText(r + "");
            } else{
                resultText.setText(result + "");
            }
        }else {
            resultText.setText("");
        }
    }
}