package com.example.examenejercicio2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class ActividadRotacion extends ActionBarActivity {
	private SeekBar sbRotaciones;
	TextView palabraSeleccionada;
	TextView nroRotaciones;
	TextView palabraRotada;
	EditText txtPalabra;
	String palabra;
	String palRotada;
	int nroRot;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_rotacion);
        
        nroRot=0;
        sbRotaciones=(SeekBar)this.findViewById(R.id.sbRotaciones);
        sbRotaciones.setMax(20);
        
        txtPalabra=(EditText)this.findViewById(R.id.txtPalabra);
        
        palabraSeleccionada=(TextView)this.findViewById(R.id.tvPalabra);
    	final TextView nroRotaciones=(TextView)this.findViewById(R.id.tvNroRotaciones);
    	TextView palabraRotada=(TextView)this.findViewById(R.id.tvPalabraRotada);
        
    	sbRotaciones.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onProgressChanged(SeekBar seekBar,
                    int progress, boolean fromUser) {
                if (seekBar.getId() == R.id.sbRotaciones) {
                	nroRot = seekBar.getProgress();
                	nroRotaciones.setText(nroRot+" rotaciones");
                }
            }
        });
        
        
    }

    public void seleccionarPalabra(View control){
    	palabra=txtPalabra.getText().toString();
    	palabraSeleccionada.setText(palabra);
    	int letraspalabra=palabra.length();
    	if(letraspalabra>20){
    		sbRotaciones.setMax(20);
    	}
    	else{
    		sbRotaciones.setMax(letraspalabra);
    	}
    	nroRot=0;
    }
    
    public void rotar(View control){
    	if(palabra!=null && palabra.length()>0){
    		char[] arrayletras=palabra.toCharArray();
    		char[] arrayaux=palabra.toCharArray();
    		int resto=0;
    		int pos=0;
    		Log.d("preparando",palabra);
    		for(int i=0;i<arrayletras.length;i++){
    			if(i+nroRot<arrayletras.length){
    				arrayaux[i+nroRot]=arrayletras[i];
    				Log.d("rotando","valor de i "+i+ "valor del array[i] "+ arrayletras[i]);
    			}
    			else{
    				resto=arrayletras.length-i;
    				pos=nroRot-resto;
    				Log.d("rotando","valor de resto "+resto+" valor de pos "+pos+" valor de i "+i+ "valor del array[i] "+ arrayletras[i]);   			
    				arrayaux[pos]=arrayletras[i];
    			}
    		}
    		Log.d("Se va a rotar la palabra",palabra+" tamaño array "+arrayaux.length);
    		palabra="";
    		for(int i=0;i<arrayaux.length;i++){
    			Log.d("añadiendo",arrayaux[i]+"");
    			palabra+=arrayaux[i];
    		}
    		Log.d("Se ha rotado la palabra",palabra);
    		TextView palabraRotada=(TextView)this.findViewById(R.id.tvPalabraRotada);         
    		palabraRotada.setText(palabra);
    		//palabraRotada.setText(palabra);
    		
    	}
    	else{
    		palabraSeleccionada.setText("Escriba una palabra");
    		TextView palabraRotada=(TextView)this.findViewById(R.id.tvPalabraRotada);         
    		palabraRotada.setText("Escriba una palabra");
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actividad_rotacion, menu);
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
}
