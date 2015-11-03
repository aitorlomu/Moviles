package com.example.ruleta;

import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class ActividadPrincipal extends ActionBarActivity {

	private float saldo;
	private int numero;
	private int apuesta;
	private SeekBar sbApuesta;
	TextView tvsaldo;
	TextView tvapuesta;
	TextView tvNumGen;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        sbApuesta=(SeekBar)findViewById(R.id.sbApuesta);
        sbApuesta.setMax(100);
        iniciarValores();
	
        sbApuesta.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onProgressChanged(SeekBar seekBar,
                    int progress, boolean fromUser) {
                if (seekBar.getId() == R.id.sbApuesta) {
                	apuesta = seekBar.getProgress();
                	tvapuesta.setText(apuesta+"€");  
                }
            }
        });
        
    }

    
    

    
    
    private void iniciarValores() {
    	saldo=1000f;
    	numero=0;
    	apuesta=0;
    	
    	tvsaldo=(TextView)findViewById(R.id.tvSaldo);
    	tvsaldo.setText("Tu saldo es de "+saldo+"€");
    	
    	tvapuesta=(TextView)findViewById(R.id.tvEurApu);
    	tvapuesta.setText(apuesta+"");
    	
    	tvNumGen=(TextView)findViewById(R.id.tvNumAle);
    	tvNumGen.setText(numero+"");
		
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
   
    

    
    public void jugPar(View control){
    	partida(apuesta,'p');
    }
    public void jugImpar(View control){
    	partida(apuesta,'i');
    }
    public void jug1doc(View control){
    	partida(apuesta,'1');
    }
    public void jug2doc(View control){
    	partida(apuesta,'2');
    }
    public void jug3doc(View control){
    	partida(apuesta,'3');
    }
    		
    private void partida(int apostado, char jugada ){
    	if(saldo>0 && apostado<=saldo){
    		saldo=saldo-apostado;
    		Random generador=new Random();
        	int numeroAleatorio=generador.nextInt(37);
        	tvNumGen.setText(numeroAleatorio+"");
        	
        	switch(jugada){
        		case 'p':
        			if(esPar(numeroAleatorio)){
        				saldo=saldo+(apostado*1.5f);
        				tvsaldo.setText("¡GANAS! Tu saldo es de "+saldo+"€");
        			}
        			else{
        				tvsaldo.setText("¡OHH, PIERDES! Tu saldo es de "+saldo+"€");
        			}
        			break;
        		case 'i':
        			if(esPar(numeroAleatorio)==false){
        				saldo=saldo+(apostado*1.5f);
        				tvsaldo.setText("¡GANAS! Tu saldo es de "+saldo+"€");
        			}
        			else{
        				tvsaldo.setText("¡OHH, PIERDES! Tu saldo es de "+saldo+"€");
        			}
        			break;
        		case '1':
        			if(dentroDocena(numeroAleatorio,0,12)){
        				saldo=saldo+(apostado*1.66f);
        				tvsaldo.setText("¡GANAS! Tu saldo es de "+saldo+"€");
        			}
        			else{
        				tvsaldo.setText("¡OHH, PIERDES! Tu saldo es de "+saldo+"€");
        			}
        			
        			break;
        		case '2':
        			if(dentroDocena(numeroAleatorio,12,24)){
        				saldo=saldo+(apostado*1.66f);
        				tvsaldo.setText("¡GANAS! Tu saldo es de "+saldo+"€");
        			}
        			else{
        				tvsaldo.setText("¡OHH, PIERDES! Tu saldo es de "+saldo+"€");
        			}
        			break;
        		case '3':
        			if(dentroDocena(numeroAleatorio,24,36)){
        				saldo=saldo+(apostado*1.66f);
        				tvsaldo.setText("¡GANAS! Tu saldo es de "+saldo+"€");
        			}
        			else{
        				tvsaldo.setText("¡OHH, PIERDES! Tu saldo es de "+saldo+"€");
        			}
        			break;
        	}      	
    	}else{
    		tvsaldo.setText("No tienes suficiente dinero para apostar esa cantidad. Tu saldo es de "+saldo+"€");
    	}
    	
    }
    
    public void recargaSaldo(View control){
    	saldo=saldo+100;
    	tvsaldo.setText("¡Ha recargado 100€! Tu saldo es de "+saldo+"€");
    }
    
    private boolean esPar(int num){
    	boolean par=false;
    	if((num%2)==0 && num!=0){
    		par=true;
    	}
    	return par;
    }
    
    private boolean dentroDocena(int num, int min, int max){
    	boolean dentro=false;
    	if(num>min && num<=max){
    		dentro=true;
    	}
    	return dentro;
    }
}
