package com.example.actividad2;

import com.example.actividad2.ActividadCalculadora;
import com.example.actividad2.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;


public class ActividadPrincipal extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actividad_principal, menu);
        return true;
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
    
    public float getNumero(int id){
    	EditText control=(EditText)findViewById(id);
    	String cadena=control.getText().toString();
    	float f=Float.parseFloat(cadena);
    	return f;
    }
    
    public void lanzarActCalculadora(float n1,float n2, String op){
    	Intent iCalculadora=new Intent(this, ActividadCalculadora.class);
    	iCalculadora.putExtra(ActividadCalculadora.nombreNum1, n1);
    	iCalculadora.putExtra(ActividadCalculadora.nombreNum2, n2);
    	iCalculadora.putExtra(ActividadCalculadora.nombreOp, op);
    	
    	//Se lanza el intent
    	this.startActivity(iCalculadora);
    }
    public void calcularNumeros(View control){
    	EditText txtNum1=(EditText) findViewById(R.id.txtNum1);
    	String n1=txtNum1.getText().toString();
    	  	
    	EditText txtNum2=(EditText) findViewById(R.id.txtNum2);
    	String n2=txtNum2.getText().toString();
    	
    	RadioButton rbSuma=(RadioButton)findViewById(R.id.radSuma);
    	if(rbSuma.isChecked()){
    		float f1=this.getNumero(R.id.txtNum1);
    		float f2=this.getNumero(R.id.txtNum2);
    		lanzarActCalculadora(f1,f2,"+");
    	}
    	RadioButton rbResta=(RadioButton)findViewById(R.id.radResta);
    	if(rbResta.isChecked()){
    		float f1=this.getNumero(R.id.txtNum1);
    		float f2=this.getNumero(R.id.txtNum2);
    		lanzarActCalculadora(f1,f2,"-");
    	}
    	RadioButton rbMult=(RadioButton)findViewById(R.id.radMult);
    	if(rbMult.isChecked()){
    		float f1=this.getNumero(R.id.txtNum1);
    		float f2=this.getNumero(R.id.txtNum2);
    		lanzarActCalculadora(f1,f2,"*");
    	}
    	RadioButton rbDiv=(RadioButton)findViewById(R.id.radDiv);
    	if(rbDiv.isChecked()){
    		float f1=this.getNumero(R.id.txtNum1);
    		float f2=this.getNumero(R.id.txtNum2);
    		lanzarActCalculadora(f1,f2,"/");
    	}
    	
 

    }
}
