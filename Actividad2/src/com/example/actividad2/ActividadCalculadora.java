package com.example.actividad2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class ActividadCalculadora extends Activity {

	public static String nombreNum1="com.ies.actividad2.num1";
	public static String nombreNum2="com.ies.actividad2.num2";
	public static String nombreOp="com.ies.actividad2.op";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Intent intento=this.getIntent();
		float num1=intento.getFloatExtra(
				ActividadCalculadora.nombreNum1,0.0f);
		float num2=intento.getFloatExtra(
				ActividadCalculadora.nombreNum2,0.0f);
		String op=intento.getStringExtra(
				ActividadCalculadora.nombreOp);
		float resultado=calcular(num1,op,num2);
		String cadResultado=num1+op+num2+"="+resultado;
		TextView tvResultado=(TextView)findViewById(R.id.tvResultado);
		tvResultado.setText(cadResultado);
		
	}
	
	public float calcular(float n1,String op,float n2){
		float resultado=0.0f;
		if(op.equals("+")) return n1+n2;
		if(op.equals("-")) return n1-n2;
		if(op.equals("*")) return n1*n2;
		if(op.equals("/")){
			if(n2!=0){
				return n1/n2;
			}else{
				return 0;
			}
		}
		return resultado;
	}

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		
		this.setContentView(R.layout.actividad_secundaria);
		return super.onCreateView(name, context, attrs);
	}
}
