package com.example.calculomental;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ActividadPrincipal extends Activity {

	int num1;
	int num2;
	String operacion;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        generarOperacion();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actividad_principal, menu);
        return true;
    }

    private void generarOperacion(){
    	Random generador=new Random();
    	num1=generador.nextInt(100);
    	num2=generador.nextInt(100);
    	
    	TextView tv1=(TextView) this.findViewById(R.id.tvOperando1);
    	tv1.setText(""+num1);
    	TextView tv2=(TextView) this.findViewById(R.id.tvOperando2);
    	tv2.setText(""+num2);
    	
    	TextView tv3=(TextView) this.findViewById(R.id.tvOperador);
    	int op=generador.nextInt(2);
    	String[] operaciones={"+","-"};  	
    	operacion=operaciones[op];
    	tv3.setText(operaciones[op]);   	    	
    }
    
    
    public void comprobar(View Control){
    	EditText et1=(EditText) this.findViewById(R.id.txtResultado);
    	TextView tvmensaje=(TextView) this.findViewById(R.id.tvMensaje);
    	int resultado=0;
    	if(et1.equals("")){
    		
    		tvmensaje.setText("Resultado Incorrecto");
    		generarOperacion();
    		return;
    		
    	}
    	else{
    		switch(operacion.charAt(0)){
    		case '+':
    			resultado=num1+num2;
    			break;
    		case '-':
    			resultado=num1-num2;
    		}
    	}
    	int res=Integer.parseInt(et1.toString());
    	if(res==resultado){
    		tvmensaje.setText("Resultado Correcto");
    		//tvmensaje.setBackgroundColor(RESULT_OK);
    	}
    	else{
    		tvmensaje.setText("Resultado Incorrecto");
    		//tvmensaje.setBackgroundColor(RESULT_CANCELED);
    	}
    	
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
