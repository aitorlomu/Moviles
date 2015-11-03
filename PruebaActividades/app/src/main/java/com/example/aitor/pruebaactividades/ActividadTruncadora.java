package com.example.aitor.pruebaactividades;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ActividadTruncadora extends Activity {

    public static String nombreCadena=
            "com.ies.truncado.nombreCadena";
    public static String nombreNumCaracteres=
            "com.ies.truncado.nombreNumCaracteres";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.act_truncado);
        Intent intRecibido=this.getIntent();
        String cad=intRecibido.getStringExtra(
                ActividadTruncadora.nombreCadena
        );
        int numCaracteres=      intRecibido.getIntExtra(
                ActividadTruncadora.nombreNumCaracteres,
                0);

        String cadTruncada=this.truncar(cad, numCaracteres);
        TextView tvTextoTruncado=
                (TextView) this.findViewById(R.id.tvResultado);
        tvTextoTruncado.setText(cadTruncada);
    }

    /* Recorta los num primeros caracteres*/
    private String truncar (String cad, int num){
                /* Si el usuario intenta poner
                 * un valor más grande que la propia
                 * longitud de la cadena, reducimos el numero
                 */
        if (num>cad.length()){
            num=cad.length();
        }
        return cad.substring(0, num);
    }
}
