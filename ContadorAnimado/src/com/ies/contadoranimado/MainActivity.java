package com.ies.contadoranimado;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


@SuppressLint("NewApi") public class MainActivity extends ActionBarActivity implements AnimatorUpdateListener{
	
	EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(EditText)this.findViewById(R.id.txtNumero);
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
    
    @SuppressLint("NewApi") public void animarNumero(View control){
    	
    	Toast mensaje=Toast.makeText(this, "Boton pulsado", Toast.LENGTH_SHORT);
    	mensaje.show();
    	if(Build.VERSION.SDK_INT>=11){
    		ValueAnimator animador=
    				(ValueAnimator)AnimatorInflater.loadAnimator(this, R.animator.animador_contador);
    		animador.addUpdateListener(this);
    		animador.start();
    	}
    	
    	
    	
    }


	@Override
	public void onAnimationUpdate(ValueAnimator animador) {
		
		int ValorActual=(Integer)animador.getAnimatedValue();
		
		txt.setText(ValorActual+"");
		
	}

}
