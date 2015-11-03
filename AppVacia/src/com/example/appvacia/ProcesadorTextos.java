package com.example.appvacia;
public class ProcesadorTextos {

	public int numVocales(String cadena) {
		
		int cont=0;
		char let=' ';
		for(int i=0;i<cadena.length();i++){
			let=cadena.charAt(i);
			if((int)let==65 ||(int)let==69 ||(int)let==73 
			||(int)let==79 ||(int)let== 85||(int)let==97 
			||(int)let==101 ||(int)let==105 ||(int)let==111 ||(int)let==117){
				cont++;
			}
		}
		
		return cont;
	}

}
