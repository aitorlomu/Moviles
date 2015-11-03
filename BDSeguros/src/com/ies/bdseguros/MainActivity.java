package com.ies.bdseguros;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    public void crearBaseDeDatos(View control){
    	GestorBD bd=new GestorBD(this, "seguros.db", null, 1);
    	String name=bd.getDatabaseName();
    	Log.d("Creado",name);
    	File ruta=this.getDatabasePath("seguros.db");
    	bd.close();
    	
    	TextView tv=(TextView) findViewById(R.id.tvmsg);
    	
    	tv.setText("Creada base de datos en "+ruta.getPath());
    }
}
