package com.example.appvacia;

//import com.example.calculomental.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
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
	


	public void ejecutarTareaCompleja(View control) {
		// TODO Auto-generated method stub
		EditText et1=(EditText) this.findViewById(R.id.txtText);
		String text=et1.toString();
		
		HiloProcesadorTexto hpt=new HiloProcesadorTexto(et1);
		int cont=0;
		cont = hpt.doInBackground(text);
		EditText txtResultado=(EditText) this.findViewById(R.id.txtResultado);
		String res=" "+cont;
		//System.out.println(cont);
		txtResultado.setText(res);
	}
}
