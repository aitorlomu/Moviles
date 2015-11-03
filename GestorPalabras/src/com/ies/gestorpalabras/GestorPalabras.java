package com.ies.gestorpalabras;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.os.Build;
import android.provider.UserDictionary;

public class GestorPalabras {

	private ContentResolver cr;
	
	public GestorPalabras(ContentResolver cr){
		this.cr=cr;
	}
	
	@SuppressLint("InlinedApi") public void anadirPalabra(String palabra, String atajo){
		ContentValues cv=new ContentValues();
		cv.put(UserDictionary.Words.WORD,palabra);
		cv.put(UserDictionary.Words.FREQUENCY, 1);
		
		if(Build.VERSION.SDK_INT>=16){
			cv.put(UserDictionary.Words.SHORTCUT,atajo);
			
		}
		
		this.cr.insert(UserDictionary.Words.CONTENT_URI, cv);
	}
	
}
