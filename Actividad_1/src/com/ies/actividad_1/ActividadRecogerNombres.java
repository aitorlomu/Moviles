package com.ies.actividad_1;

import com.ies.actividad_1.ActividadMostrarNombres;
import com.ies.actividad_1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class ActividadRecogerNombres extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    public void pasarNombre(View control){
    	EditText txtNombre;
    	txtNombre=(EditText) findViewById(R.id.txtNombre);
    	String nombre=txtNombre.getText().toString();
    	Intent iMostrarNombre;
    	//Indicamos quien es el llamador e
    	//indicamos
    	iMostrarNombre=new Intent(
    			this, ActividadMostrarNombres.class);
    	iMostrarNombre.putExtra
    	(ActividadMostrarNombres.parametroNombre
    			, nombre);
    	//Se lanza el intent
    	this.startActivity(iMostrarNombre);
    }
}
