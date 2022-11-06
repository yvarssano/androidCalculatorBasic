package com.example.firstproject;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    String action = "";
    double num1 = 0;
    double res = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewResult);

    }

    public void numClick(View view) {
        if (view instanceof Button) {
            Button b = (Button) view;
            String str = b.getText().toString();
            String reStr = result.getText().toString();
            if(str.equals(".")&& reStr.contains("."))
                return;
            if(reStr.equals("+") ||reStr.equals("-") ||reStr.equals("X") ||reStr.equals("/")){
                result.setText(str);
                return;
            }
            if(res !=0){
                res=0;
                result.setText(str);
                return;
            }
            result.append(str);

        }

    }

    public void action(View view) {
        if (view instanceof Button){
            String reStr = result.getText().toString();
            if(!action.equals("")) {
                if(!reStr.equals("+") && !reStr.equals("-") && !reStr.equals("X") && !reStr.equals("/")){
                    equals(view);
                }
            }
            if(res != 0){
                num1 = res;
                res = 0;
            }
            Button b = (Button) view;
            action =b.getText().toString();
            num1 =Double.parseDouble(result.getText().toString());
            result.setText(action);
        }
    }

    public void equals(View view) {
        if (view instanceof Button){
            if(action.equals("") || result.getText().toString().equals("")){
                return;
            }
            double num2 =Double.parseDouble(result.getText().toString());
            switch(action){
                case "+":
                    res=num1+num2;
                    break;
                case "-":
                    res=num1-num2;
                    break;
                case "/":
                    res=num1/num2;
                    break;
                case "X":
                    res=num1*num2;
                    break;
            }
            result.setText(valueOf(res));
            num1=0;
            action = "";
        }
    }
}