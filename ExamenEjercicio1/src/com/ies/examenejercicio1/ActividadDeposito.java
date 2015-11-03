package com.ies.examenejercicio1;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class ActividadDeposito extends ActionBarActivity {

	public static String numeroAnios="com.ies.examenejercicio1.numeroAnios";
    public static String numeroEuros="com.ies.examenejercicio1.numeroEuros";
    private int anios;
    private int euros;
    double deposito;
    double calculo;
    RadioButton rbStar;
    RadioButton rbConfianza;
    RadioButton rbJoven;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_deposito);
        deposito=0;
        calculo=0;
        Intent intRecibido=this.getIntent();
        anios=intRecibido.getIntExtra(ActividadDeposito.numeroAnios,0);
        euros=intRecibido.getIntExtra(ActividadDeposito.numeroEuros,0);
        rbStar=(RadioButton)this.findViewById(R.id.rbStar);
        rbConfianza=(RadioButton)this.findViewById(R.id.rbConfianza);
        rbJoven=(RadioButton)this.findViewById(R.id.rbJoven);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actividad_deposito, menu);
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
    public void calcularBeneficios(View control){
    	TextView tvBeneficios=(TextView) this.findViewById(R.id.tvBeneficios);
    	
    	if(anios!=0 && euros!=0){
    		if (rbStar.isChecked()==true) {
                deposito=2.25;
            }
    		if (rbConfianza.isChecked()==true) {
    			deposito=2.88;
            }
    		if (rbJoven.isChecked()==true) {
    			deposito=2.88;
            }
    		
    		if(deposito!=0){
    			calculo=(euros*1000)*deposito*anios;
    			tvBeneficios.setText(calculo+"€");
    		}
   
    	}
    	else{
    		tvBeneficios.setText("No hay años y/o miles de euros seleccionados");
    	}
    }
    public void seleccionarDeposito(View control){
    	Intent intento=new Intent(this, ActividadParametros.class);
    	this.startActivity(intento);
    	
    	
    }
}
