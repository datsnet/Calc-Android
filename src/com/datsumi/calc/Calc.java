package com.datsumi.calc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.*;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class Calc extends Activity {
    public native int addValues(int val1, int val2);
    public native int subValues(int val1, int val2);
    public native int mulValues(int val1, int val2);
    public native double divValues(int val1, int val2) throws DivideByZeroException;
    
    static {
    	System.loadLibrary("calculator");
    }
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final TextView symbol = (TextView) findViewById(R.id.symbol);
        symbol.setText(" ");
        
        // 解答テキストボックス
        final EditText answer = (EditText) findViewById(R.id.answer);
        answer.setWidth(130);


        // ボタン定義
        Button add = (Button) findViewById(R.id.add);
        Button sub = (Button) findViewById(R.id.sub);
        Button mul = (Button) findViewById(R.id.mul);
        Button div = (Button) findViewById(R.id.div);
        add.setWidth(80);
        sub.setWidth(80);
        mul.setWidth(80);
        div.setWidth(80);
     
        add.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		symbol.setText("+");
        		int ans = 0;
        		ans = addValues(getValue(1), getValue(2));
        		answer.setText(String.valueOf(ans));
        	}
        });
        sub.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		symbol.setText("-");
        		int ans = 0;
        		ans = subValues(getValue(1), getValue(2));
        		answer.setText(String.valueOf(ans));
        	}
        });
        mul.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		symbol.setText("*");
        		int ans = 0;
        		ans = mulValues(getValue(1), getValue(2));
        		answer.setText(String.valueOf(ans));
        	}
        });
        	
        div.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		symbol.setText("/");
        		double ans = 0;
        		try {
        			ans = divValues(getValue(1), getValue(2));
        			answer.setText(String.valueOf(ans));
        		} catch (DivideByZeroException e) {
        			answer.setText("");
        			new AlertDialog.Builder(Calc.this).setTitle("Divide By Zero")
        			.setMessage("Divide By Zero").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
        				public void onClick(DialogInterface dialog, int id) {       					
        				}
        				
        			}).show();
        		}
        	}
        });
    }
    
    public int getValue(int num) {
        // 数
        final EditText num1 = (EditText) findViewById(R.id.num1);
        final EditText num2 = (EditText) findViewById(R.id.num2);
        num1.setWidth(90);
        num2.setWidth(90);
        
        String str1;
        String str2;
        str1 = num1.getText().toString();
        str2 = num2.getText().toString();
        final int value1 = Integer.parseInt(str1);
        final int value2 = Integer.parseInt(str2);
        
        if (num == 1) {
        	return value1;
        } else {
        	return value2;
        }
        
    }
    
}