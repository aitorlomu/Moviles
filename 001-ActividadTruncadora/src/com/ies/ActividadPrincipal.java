package com.ies;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


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
    
    public void truncarTexto(View control){
    	EditText txtTexto=(EditText)findViewById(R.id.txtTexto); 
    	String texto=txtTexto.getText().toString();
    	
    	EditText chars=(EditText)findViewById(R.id.txtNumChars); 	
    	String numchars=chars.getText().toString();
    	
    	Intent iTruncar=new Intent(this, ActividadResultado.class);
    	iTruncar.putExtra(ActividadResultado.nombreNum1, texto);
    	iTruncar.putExtra(ActividadResultado.nombretexto, numchars);
    	   	
    	//Se lanza el intent
    	this.startActivity(iTruncar);
    }
}
