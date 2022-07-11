import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ex1App {

	public static void main(String[] args) {
		String[] alumnos = {"Juan","Clara","Marcos"};
		String[] asignaturas = {"Java","NodeJs","Spring"};
		
		Hashtable notas= calcularNotaMedia(alumnos, asignaturas);
		showNotas(notas);
	}
	
	public static Hashtable calcularNotaMedia (String[] alumnos, String[] asignaturas) {
        Scanner sc = new Scanner(System.in);
		Hashtable notas=new Hashtable();
		for (int i = 0; i < alumnos.length; i++) {
			float notaMedia = 0;
			for (int j = 0; j < asignaturas.length; j++) {
			System.out.print("Nota de "+alumnos[i]+" en "+asignaturas[j]+" : ");
			 notaMedia +=  sc.nextFloat();
			}
			notaMedia /= asignaturas.length;
			notas.put(alumnos[i], notaMedia);		
		}	
		return notas;	
	}
	
	public static void showNotas(Hashtable notas) {
		Enumeration notasAlumnos = notas.elements();
		Enumeration alumnos = notas.keys();
		
		System.out.println("\nNotas:");
		while(notasAlumnos.hasMoreElements()) {
			System.out.println("Nota media de "+alumnos.nextElement()+ " = "+notasAlumnos.nextElement());
		}
	}

}
