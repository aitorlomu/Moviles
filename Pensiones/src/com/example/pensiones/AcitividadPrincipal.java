package com.example.pensiones;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;


public class AcitividadPrincipal extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitividad_principal);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.acitividad_principal, menu);
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
    
    /*Código de gestión de eventos*/
    
    public void calcPension(View controlPulsado) {
    	EditText control=(EditText)this.findViewById(R.id.txtSueldoActual);
    	Editable cadPension=control.getText();
    	if(cadPension==null)return;
    	
    		int sueldoActual=Integer.parseInt(cadPension.toString());

    	
    		Double pensionResultado;

    		ToggleButton togMinimo=(ToggleButton)this.findViewById(R.id.togMinimo);
    		if(togMinimo.isChecked()){
    			 pensionResultado=sueldoActual*0.9;
    		}
    		else{
   			 pensionResultado=sueldoActual*0.75;
    		}
    		
    		EditText txtPensionResultado;
            txtPensionResultado=(EditText)
                            this.findViewById(R.id.txtPensionResultado);
    		txtPensionResultado.setText(pensionResultado.toString());
    }

}
