package com.ies.bdcoches2.test;

import android.database.Cursor;
import android.test.ActivityInstrumentationTestCase2;

import com.ies.bdcoches2.MainActivity;

public class BDTest extends ActivityInstrumentationTestCase2<MainActivity> {

	
	public BDTest(){
		super(MainActivity.class);
		
	}
	
	public void testBDNoVacia(){
		String select_marcas="select id, nombre from marcas";
				
		MainActivity a=this.getActivity();
		Cursor c=a.getCursor(select_marcas);
		
		int num_filas=c.getCount();
		boolean con_cosas;
		if(num_filas>0){
			con_cosas=false;
		}
		else{
			con_cosas=true;
		}
		assertEquals("Marcas no vacia",con_cosas,true);
		
	}
	
	public void testCompruebaMarca(){
		String select_marca_ford="Select id, nombre from marcas where nombre='Ford'";
		MainActivity a=this.getActivity();
		Cursor c=a.getCursor(select_marca_ford);		
		int num_filas=c.getCount();
		boolean hay_ford;
		
		if(num_filas>0){
			hay_ford=false;
		}
		else{
			hay_ford=true;
		}
		assertEquals("Existe la marca Ford",hay_ford,true);
	}
}
