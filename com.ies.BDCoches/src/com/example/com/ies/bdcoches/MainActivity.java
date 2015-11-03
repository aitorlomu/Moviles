package com.example.com.ies.bdcoches;

import android.support.v7.app.ActionBarActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    
    private GestorBD gestorBD;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        gestorBD=new GestorBD(this,"coches.db",null,1);
        setContentView(R.layout.activity_main);
        
        String consulta="select "+MarcasContrato.NOMBRE_COL_ID+", "+ MarcasContrato.NOMBRE_COL_NOMBRE
        		+" from "+MarcasContrato.NOMBRE_TABLA;
        Log.d("BD",consulta);
        
        SQLiteDatabase sqliteDB=gestorBD.getReadableDatabase();
        Cursor cursor=sqliteDB.rawQuery(consulta, null);
        cursor.moveToFirst();
        String resultado="";
        EditText txt=(EditText)this.findViewById(R.id.txtMulti);
        while(!cursor.isAfterLast()){
        	
        	String nombreActual=cursor.getString(1);
        	resultado+=nombreActual+"\n";
        	
        	cursor.moveToNext();
        }
        txt.append(resultado);
        cursor.close();
        
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
}
