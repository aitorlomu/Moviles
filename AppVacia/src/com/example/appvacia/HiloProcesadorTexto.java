package com.example.appvacia;

import android.os.AsyncTask;
import android.widget.EditText;

public class HiloProcesadorTexto extends AsyncTask <String,Float,Integer>{
	
	EditText txtResultado;
	public HiloProcesadorTexto(EditText txtResultado){
		this.txtResultado=txtResultado;
	}
	@Override
	protected Integer doInBackground(String... lista) {
		String cadena= txtResultado.toString();
		int resultado=0;
		ProcesadorTextos pt=new ProcesadorTextos();
		resultado=pt.numVocales(cadena);
		return resultado;
	}

	public void onPostExecute(Integer resultado){
		txtResultado.setText("Total: "+resultado);
	}



}
