package com.example.aitor.pruebaactividades;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class ActPeticionTexto extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_peticion_texto);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.act_peticion_texto, menu);
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
    private String getCadena(int id){
        EditText controlTexto=
                (EditText) this.findViewById(id);
        return controlTexto.getText().toString();
    }

    public void truncar(View control){
        Intent intento=new Intent(this,ActividadTruncadora.class);
        String textoEscrito=
                getCadena(R.id.txtTexto);
        String textoNumCaracteres=
                getCadena(R.id.txtNumero);
        int numCaracteres=Integer.parseInt(
                textoNumCaracteres);
        intento.putExtra(
                ActividadTruncadora.nombreCadena,
                textoEscrito);
        intento.putExtra(
                ActividadTruncadora.nombreNumCaracteres,
                numCaracteres);
        this.startActivity(intento);
    }
}
