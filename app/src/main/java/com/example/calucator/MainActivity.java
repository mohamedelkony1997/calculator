package com.example.calucator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView result;
TextView fin;
String LHS="";
String operation="";
String RHS="";
EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=(TextView)findViewById(R.id.input);
        fin=(TextView)findViewById(R.id.res);
    }
    public void ondigitclick(View view) {
        Button button=((Button)view);
        String rest=button.getText().toString();
        result.append(rest);
    }
    public void onclear(View view) {
        result.setText("");
        fin.setText("");
    }
    public void onopereationclick(View view) {
        Button opeartor=((Button)view);
        if(operation.isEmpty()){
            LHS=result.getText().toString();
            if (LHS.isEmpty()){
                Toast.makeText(MainActivity.this, "no input", Toast.LENGTH_LONG).show();
            }else {
                result.setText(" ");
                operation = opeartor.getText().toString();
            }
        }else {
           String RHS=result.getText().toString();
            if (LHS.isEmpty()){
                Toast.makeText(MainActivity.this, "no input", Toast.LENGTH_LONG).show();
            }else {
                LHS = calculate(LHS, operation, RHS);
                operation = opeartor.getText().toString();
                result.setText(" ");
            }
        }
    }
    public void onequalclick(View view) {
            RHS = result.getText().toString();
            if(RHS.isEmpty()){
                Toast.makeText(MainActivity.this, "no input", Toast.LENGTH_LONG).show();
            }else if(operation.equals("r^.5")){
                RHS=".5";
                String res = calculate(LHS, operation, RHS);
                LHS = res;
                operation = "";
                result.setText(res);
                fin.setText(res);
            }else if(operation.equals("r^.3")){
                RHS=".33333333333333333";
                String res = calculate(LHS, operation, RHS);
                LHS = res;
                operation = "";
                result.setText(res);
                fin.setText(res);
            }else {
                String res = calculate(LHS, operation, RHS);
                LHS = res;
                operation = "";
                result.setText(res);
                fin.setText(res);
            }
        }
    public String calculate(String LHS,String operator,String RHS){
       double txtresult=0.0;
        String viewresult;
        double DLHS=Double.parseDouble(LHS);
        double DRHS=Double.parseDouble(RHS);
        if (operation.equals("+")) {
          txtresult=DLHS+DRHS;
        }else if(operation.equals("-")){
            txtresult=DLHS-DRHS;
        }else if(operation.equals("*")){
            txtresult=DLHS*DRHS;
        }else if(operation.equals("/")) {
            if (DRHS == 0) {
                Toast.makeText(MainActivity.this, "invalid operation" , Toast.LENGTH_LONG).show();
                viewresult="invalid operation";
              return viewresult;
            } else {
                txtresult = DLHS / DRHS;
            }
        }else if (operation.equals("x^p")){
            txtresult=Math.pow(DLHS,DRHS);
        }else if(operation.equals("r^.5")){
          txtresult=Math.pow(DLHS,DRHS);
        }else if(operation.equals("r^.3")){
            txtresult=Math.pow(DLHS,DRHS);

        }
       viewresult=txtresult +" ";
        return viewresult;
    }
    public void inbacksaceclick(View view) {
        String screen = result.getText().toString();
        if (screen.isEmpty()) {
            Toast.makeText(MainActivity.this, "no input", Toast.LENGTH_LONG).show();
        } else {
            StringBuffer st = new StringBuffer(screen);
            result.setText(st.deleteCharAt(st.length() - 1));
        }
    }



}