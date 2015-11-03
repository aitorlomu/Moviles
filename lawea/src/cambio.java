import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class cambio
{
	private static boolean t = false;
	private static boolean h = false;
	private static String fichero_entrada = null;
	private static String fichero_salida = null;
	private static String fichero_solucion;
	private int[][] matrizCambio;
	private int[] vectorMonedas;
	private int cantidad;
	private int[] vectorSeleccion;
	public cambio(int i, int[] js) {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
		//Argumentos de prueba - Borrar
		//args = new String [] {"-t","-h", "fichero_entrada","fichero_salida"};
		if(args.length<=1){
			for(int i=0;i<args.length;i++){
				if(args[i].equals("-h")){
					h = true;
				}
				else if(args[i].equals("-t")){
					t = true;
				}
				else if(fichero_entrada == null){
					fichero_entrada = args[i];
				}
				else{
					fichero_salida = args[i];
				}
			}
			if(h){
				System.out.println("----------------------------- AYUDA --------------------------------");
				System.out.println("cambio [-t][-h] [<fichero_entrada>][<fichero_salida>]");
				System.out.println("   -t: Traza cada paso del algoritmo y describe utilización del algoritmo");
				System.out.println("   -h: Muestra una ayuda y la sintaxis del comando");
				System.out.println("   fichero_entrada: Se leen los datos del S.M No. de tipo de monedas y la cantidad que se desea devolver");
				System.out.println("   fichero_salida: Almacena la salida, si el fichero ya existe el comando dara un error");
				System.out.println("----------------------------------------------------------------------------------------------------------");
			}
			if(fichero_entrada != null){
				ArrayList<String> lista=leerFichero(fichero_entrada);
				// if(tieneSolucion(lista)){
				String resultado = calcularCambio(lista);
				if(fichero_salida !=null){
					guardarSolucion(fichero_salida, resultado);
				}
				System.out.println("Resultado: "  + resultado);
				//  }
				//  else{
				//  System.ot.println("No tiene solucion");
				//
				//    }
			} else{
				System.out.println("Faltan argumentos");
			}
		}
	}
	private static String calcularCambio(ArrayList<String> lista) {
		// TODO Auto-generated method stub
		return fichero_solucion;
	}
	private static ArrayList<String> leerFichero(String rutaFichero){
		ArrayList<String>lista=new ArrayList<String>();	
		try {
			Scanner s=new Scanner(new File(rutaFichero));            
			while (s.hasNext()){
				lista.add(s.next());
			}
			s.close();
		}catch (FileNotFoundException e) {
			System.out.println(e);
		}
		return lista;
	}
	/**
	 * Metodo con el que guardamos la solucion en el fichero de salida
	 * 
	 * @param String filename, con el que indicamos el nombre del nuevo sifhero de salida.
	 * @param ArrayList<Integer> lista, con los valores que vamos a guardar en el fichero.
	 * */
	private static void guardarSolucion(String filename, String resultado) {
		BufferedWriter bufferedWriter = null;
		//Crea un nuevo bufferedWritter y comprueba si hay excepciones
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(filename));
			bufferedWriter.write("resultado: "+ resultado); 
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			//Cierra el bufferedWritter
			try {
				if (bufferedWriter != null) {
					bufferedWriter.flush();
					bufferedWriter.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	void Cambio(int cantidad, int[]  monedas){
		this.cantidad = cantidad;
		this.vectorMonedas = monedas;
		matrizCambio = calcularMonedas(cantidad, monedas);
		vectorSeleccion = seleccionarMonedas(cantidad, monedas, matrizCambio);
	}
	public int[] getVectorSeleccion(){
		return this.vectorSeleccion;
	}
	private int[][] calcularMonedas(int cantidad, int[]  monedas){
		int[][] matrizCambio = new int[monedas.length + 1][cantidad + 1];
		for (int i = 0; i < monedas.length; i++)
			matrizCambio[i][0] = 0;
		for (int j = 1; j <= cantidad; j++)
			matrizCambio[0][j] = 99;
		for (int i = 1; i <= monedas.length; i++)
			for (int j = 1; j <= cantidad; j++) {
				if (j < monedas[i - 1]) {
					matrizCambio[i][j] = matrizCambio[i - 1][j];
				} else {
					int minimo = 0;
					minimo = min(matrizCambio[i - 1][j] , matrizCambio[i][j- monedas[i - 1]] + 1);
					matrizCambio[i][j] = minimo;
				}
				cambio c = new cambio(24, new int[]{1,6,10});
				c.getVectorSeleccion();
			}
		return matrizCambio;
	}
	private int[] seleccionarMonedas(int c, int[] monedas, int[][]tabla ){
		int i,j;
		int[] seleccion = new int[monedas.length];
		for(i = 0; i< monedas.length; i++){             seleccion[i]=0;         }         i= monedas.length;         j= c;         while(j>0){
			if(i>1 && tabla[i][j]==tabla[i-1][j]){
				i--;
			}
			else{
				seleccion[i-1]++;
				j = j - monedas[i-1];
			}
		}
		return seleccion;
	}
	private int min(int a, int b){
		if(a<b)
			return a;
		else 
			return b;
	}
}