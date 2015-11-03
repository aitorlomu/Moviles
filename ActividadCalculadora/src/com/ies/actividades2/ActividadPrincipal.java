package com.ies.actividades2;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    
    
    
    /* Dado un id de recurso este método nos
     * devuelve el texto que hay dentro
     */
    public float getNumero(int id){
    	EditText control;
    	control=(EditText) findViewById(id);
    	String cadena=control.getText().toString();
    	float f=Float.parseFloat(cadena);
    	return f;
    }
    public void lanzarActCalculadora(
    		float f1, float f2, String op
    		){
    	Intent intento=new Intent(this, ActividadCalculadora.class);
    	intento.putExtra(
    			ActividadCalculadora.nombreNum1,
    			f1);
    	intento.putExtra(
    			ActividadCalculadora.nombreNum2,
    			f2);
    	intento.putExtra(
    			ActividadCalculadora.nombreOp,
    			op);
    	Log.d("Calc", "Lanzando");
    	this.startActivity(intento);
    }
    public void calcular(View control){
    	RadioButton rbSuma;
    	Log.d("Calc", "Arrancando");
        rbSuma=(RadioButton) findViewById(R.id.radSuma);
        if (rbSuma.isChecked()){
        	float f1=this.getNumero(R.id.txtNum1);
        	float f2=this.getNumero(R.id.txtNum2);
        	
        	lanzarActCalculadora(f1,f2,"+");
        }
    }   
}
