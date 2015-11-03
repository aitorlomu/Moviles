package com.ies;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ActividadResultado extends Activity {

	public static String nombretexto="com.ies.actividadtruncadora.texto";
	public static String nombreNum1="com.ies.actividadtruncadora.num1";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.actividad_secundaria);
		
		
		Intent intento=this.getIntent();
		
		String texto=intento.getStringExtra(
				ActividadResultado.nombretexto);
		int num1=intento.getIntExtra(
				ActividadResultado.nombreNum1,0);
		Log.d("Resultad",  "Listo para truncar");
		String truncado=texto.substring(0,num1);
		
		
		
		TextView tvResultado=(TextView)findViewById(R.id.tvResultado);
		tvResultado.setText(truncado);
		
	}
	
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		
		
		return super.onCreateView(name, context, attrs);
	}
}
