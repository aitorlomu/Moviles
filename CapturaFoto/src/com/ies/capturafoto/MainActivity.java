package com.ies.capturafoto;

import java.io.File;
import java.io.IOException;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	Uri uriFicheroFoto;
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
    
    public void tomarFoto(View control){
    	Toast mensaje=Toast.makeText(this, "Bot�n pulsado", Toast.LENGTH_SHORT);
    	mensaje.show();
    	
    	try {
			File temp=this.crearFichero();
			Intent lanzadorCamara=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			
			this.uriFicheroFoto=Uri.fromFile(temp);
			lanzadorCamara.putExtra(MediaStore.EXTRA_OUTPUT,uriFicheroFoto);
			
			this.startActivityForResult(lanzadorCamara, 10);
			
			
		} catch (IOException e) {
			Toast error=Toast.makeText(this, "No hay tarjeta/permisos", Toast.LENGTH_SHORT);
			error.show();
			return;
		}
    	
    }
    
    @Override
	protected void onActivityResult(int codigo, int resultado, Intent intento) {
		if(codigo==10){
			if(resultado==RESULT_OK){
				Toast mensaje=Toast.makeText(this, "Foto tomada", Toast.LENGTH_SHORT);
				mensaje.show();
				
				String rutaFoto=this.uriFicheroFoto.getEncodedPath();
				ImageView controlImagen=(ImageView)this.findViewById(R.id.imageView1);
				Bitmap imagen=BitmapFactory.decodeFile(rutaFoto);
				controlImagen.setImageBitmap(imagen);
			}
		}
	}


	public File crearFichero() throws IOException{
    	
    	File dir=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    	String nombre="Foto";
    	File ficheroFoto=File.createTempFile(nombre,".jpg",dir);
    	return ficheroFoto;
    }
}
