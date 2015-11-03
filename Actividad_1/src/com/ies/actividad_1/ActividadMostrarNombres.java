package com.ies.actividad_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class ActividadMostrarNombres extends ActionBarActivity {

	public static String parametroNombre=
			"com.ies.actividades1.nombrePersona";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.actividad_mostrar_nombre);
		Intent intentPasado=this.getIntent();
		String nombrePasado=
				intentPasado.getStringExtra(
						ActividadMostrarNombres.parametroNombre
						);
		TextView txtNombreAMostrar;
		txtNombreAMostrar=
				(TextView) this.findViewById(R.id.tvNombreRecibido);
		txtNombreAMostrar.setText(nombrePasado);
	}

}
