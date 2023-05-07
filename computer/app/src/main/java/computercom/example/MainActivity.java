package computercom.example;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn1; // 数字1
    Button btn2; // 数字2
    Button btn3; // 数字3
    Button btn4; // 数字4
    Button btn5; // 数字5
    Button btn6; // 数字6
    Button btn7; // 数字7
    Button btn8; // 数字8
    Button btn9; // 数字9
    Button btn0; // 数字0
    Button add; // +号
    Button sub; // -号
    Button mul; // *号
    Button div; // 除号
    Button dot; // 小数点
    Button equ; // =号
    Button clear; //清除
    EditText result; // 显示文本

    double num1 = 0, num2 = 0; //计算的数字
    double Result = 0;//计算结果
    int op = 0;//判断操作符
    String opd = " ";//显示操作符

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取页面上的控件
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button)findViewById(R.id.btn_2);
        btn3 = (Button)findViewById(R.id.btn_3);
        btn4 = (Button)findViewById(R.id.btn_4);
        btn5 = (Button)findViewById(R.id.btn_5);
        btn6 = (Button)findViewById(R.id.btn_6);
        btn7 = (Button)findViewById(R.id.btn_7);
        btn8 = (Button)findViewById(R.id.btn_8);
        btn9 = (Button)findViewById(R.id.btn_9);
        btn0 = (Button)findViewById(R.id.btn_0);
        add =  (Button)findViewById(R.id.btn_add);
        sub =  (Button)findViewById(R.id.btn_sub);
        mul =  (Button)findViewById(R.id.btn_mul);
        div =  (Button)findViewById(R.id.btn_div);
        equ =  (Button)findViewById(R.id.btn_equ);
        dot =  (Button)findViewById(R.id.btn_dot);
        clear =(Button) findViewById(R.id.btn_clear);
        result =(EditText)  findViewById(R.id.et_result);

        // 按钮的单击事件
        btn1.setOnClickListener(new Click());
        btn2.setOnClickListener(new Click());
        btn3.setOnClickListener(new Click());
        btn4.setOnClickListener(new Click());
        btn5.setOnClickListener(new Click());
        btn6.setOnClickListener(new Click());
        btn7.setOnClickListener(new Click());
        btn8.setOnClickListener(new Click());
        btn9.setOnClickListener(new Click());
        btn0.setOnClickListener(new Click());
        add.setOnClickListener(new Click());
        sub.setOnClickListener(new Click());
        mul.setOnClickListener(new Click());
        div.setOnClickListener(new Click());
        equ.setOnClickListener(new Click());
        dot.setOnClickListener(new Click());
        clear.setOnClickListener(new Click());
        result.setOnClickListener(new Click());
    }

    // 设置按钮点击后的监听
    class Click implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {                //switch循环获取点击按钮后的值
                case R.id.btn_0:                //获取，0-9、小数点，并在编辑框显示
                    String myString = result.getText().toString();
                    myString += "0";
                    result.setText(myString);
                    break;
                case R.id.btn_1:
                    String myString1 = result.getText().toString();
                    myString1 += "1";
                    result.setText(myString1);
                    break;
                case R.id.btn_2:
                    String myString2 = result.getText().toString();
                    myString2 += "2";
                    result.setText(myString2);
                    break;
                case R.id.btn_3:
                    String myString3 = result.getText().toString();
                    myString3 += "3";
                    result.setText(myString3);
                    break;
                case R.id.btn_4:
                    String myString4 = result.getText().toString();
                    myString4 += "4";
                    result.setText(myString4);
                    break;
                case R.id.btn_5:
                    String myString5 = result.getText().toString();
                    myString5 += "5";
                    result.setText(myString5);
                    break;
                case R.id.btn_6:
                    String myString6 = result.getText().toString();
                    myString6 += "6";
                    result.setText(myString6);
                    break;
                case R.id.btn_7:
                    String myString7 = result.getText().toString();
                    myString7 += "7";
                    result.setText(myString7);
                    break;
                case R.id.btn_8:
                    String myString8 = result.getText().toString();
                    myString8 += "8";
                    result.setText(myString8);
                    break;
                case R.id.btn_9:
                    String myString9 = result.getText().toString();
                    myString9 += "9";
                    result.setText(myString9);
                    break;
                case R.id.btn_dot:
                    String myStringDot = result.getText().toString();
                    myStringDot += ".";
                    result.setText(myStringDot);
                    break;
                case R.id.btn_add:             //判断，使用加减乘除的操作符
                    String myStringAdd = result.getText().toString();
                    if (myStringAdd.equals(null)) {
                        return;
                    }
                    num1 = Double.valueOf(myStringAdd);
                    result.setText(null);
                    op = 1;
                    opd = "+";
                    break;
                case R.id.btn_sub:
                    String myStringSub = result.getText().toString();
                    if (myStringSub.equals(null)) {
                        return;
                    }
                    num1 = Double.valueOf(myStringSub);
                    result.setText(null);
                    op = 2;
                    opd = "-";
                    break;
                case R.id.btn_mul:
                    String myStringMul = result.getText().toString();
                    if (myStringMul.equals(null)) {
                        return;
                    }
                    num1 = Double.valueOf(myStringMul);
                    result.setText(null);
                    op = 3;
                    opd = "×";
                    break;
                case R.id.btn_div:
                    String myStringDiv = result.getText().toString();
                    if (myStringDiv.equals(null)) {
                        return;
                    }
                    num1 = Double.valueOf(myStringDiv);
                    result.setText(null);
                    op = 4;
                    opd = "÷";
                    break;
                case R.id.btn_clear:                 //清除，将编辑框文本显示为空
                    result.setText(null);
                    break;
                case R.id.btn_equ:                   //计算，以操作符为判断，选择所需的运算，并将结果输出
                    String myStringEqu = result.getText().toString();
                    if (myStringEqu.equals(null)) {
                        return;
                    }
                    num2 = Double.valueOf(myStringEqu);
                    result.setText(null);
                    switch (op) {
                        case 0:
                            Result = num2;
                            break;
                        case 1:
                            Result = num1 + num2;
                            break;
                        case 2:
                            Result = num1 - num2;
                            break;
                        case 3:
                            Result = num1 * num2;
                            break;
                        case 4:
                            if (num2 == 0)                //除法中分子与分母之分
                                Result = 0;
                            else
                                Result = num1 / num2;
                            break;
                        default:
                            Result = 0;
                            break;
                    }
                    result.setText(Double.toString(num1) + opd + Double.toString(num2) + "=" + Double.toString(Result));    //将结果完整输出
                    break;
                default:
                    break;
            }
        }
    }
}