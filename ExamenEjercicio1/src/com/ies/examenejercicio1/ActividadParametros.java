package com.ies.examenejercicio1;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ActividadParametros extends ActionBarActivity {

	public static String numAnios="com.ies.examenejercicio1.numAnios";
    public static String numEuros="com.ies.examenejercicio1.numEuros";
    private SeekBar sbAnios;
    private SeekBar sbEuros;
    TextView tvEurosSeleccionados;
    TextView tvAniosParametros;
    private int anios;
    private int euros;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actividad_parametros);
		this.setContentView(R.layout.activity_actividad_parametros);
		
		tvEurosSeleccionados=(TextView) this.findViewById(R.id.tvEurosSeleccionados);
		tvAniosParametros=(TextView) this.findViewById(R.id.tvAniosParametros);
		
		sbAnios=(SeekBar)findViewById(R.id.sbAnios);
		sbAnios.setMax(20);
		sbEuros=(SeekBar)findViewById(R.id.sbEuros);
		sbEuros.setMax(50);
		Intent intRecibido=this.getIntent();
		
        iniciarValores();
	
        sbAnios.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onProgressChanged(SeekBar seekBar,
                    int progress, boolean fromUser) {
                if (seekBar.getId() == R.id.sbAnios) {
                	anios = seekBar.getProgress();
                	tvAniosParametros.setText(anios+" años");
                }
            }
        });
        sbEuros.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onProgressChanged(SeekBar seekBar,
                    int progress, boolean fromUser) {
                if (seekBar.getId() == R.id.sbEuros) {
                	euros = seekBar.getProgress();
                	tvEurosSeleccionados.setText(euros*1000+"€");
                }
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.actividad_parametros, menu);
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
	
	private void iniciarValores(){
		
	    anios=0;
	    euros=0;
	    
	    
	    tvEurosSeleccionados.setText(euros*1000+"€");
	}
	
	public void volver(View control){
		Intent intento=new Intent(this, ActividadDeposito.class);
		intento.putExtra(ActividadDeposito.numeroAnios,anios);
		intento.putExtra(ActividadDeposito.numeroEuros,euros);
		this.startActivity(intento);
	}
}
