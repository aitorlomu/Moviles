package com.ies.bdcoches2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

	GestorDB gestorDB=new GestorDB(this,"seguros.db",null,1);
	static SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=gestorDB.getReadableDatabase();
        setContentView(R.layout.activity_main);
        this.construirListaModelos();
    }


    public void construirListaModelos(){
    	
    	String[] modelos;
    	Cursor c=this.getCursor("select nombre from modelos");
    	int numModelos=c.getCount();
    	modelos = new String[numModelos];
    	c.moveToFirst();
    	int pos=0;
    	while(!c.isAfterLast()){
    		modelos[pos]=c.getString(0);
    		pos++;
    		c.moveToNext();
    	}
    	
    	ArrayAdapter<String> a=new ArrayAdapter(this,R.layout.modelo_coche,R.id.tvNombreModelo,modelos);
    	ListView lvModelos=(ListView)this.findViewById(R.id.lvModelos);
    	lvModelos.setAdapter(a);
    }
    public static Cursor getCursor(String select){
    	Cursor c=db.rawQuery(select, null);
    	return c;
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
