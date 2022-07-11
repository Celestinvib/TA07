import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ex1App {

	public static void main(String[] args) {
		//Introducción de los alumnos y asignaturas (Métodos utilizados antes de empezar el curso)
		ArrayList<String> alumnos  = addAlumnos();	
		ArrayList<String> asignaturas = addAsignaturas();
		
		Hashtable notas= calcularNotaMedia(alumnos, asignaturas);
		showNotas(notas);
	}
	
	public static ArrayList addAlumnos() {
        Scanner sc = new Scanner(System.in);
		ArrayList<String> alumnos = new ArrayList<String>();

		String nombre = "";
		
		System.out.println("Introduce el nombre de los alumnos del curso:(quit para salir)");
		while (!nombre.equals("quit")) {
			nombre =  sc.nextLine();
			
			if(!nombre.equals("") && !nombre.equals("quit") ) {
				alumnos.add(nombre);
			}
		}
		return alumnos;
	}
	
	public static ArrayList addAsignaturas() {
		ArrayList<String> asignaturas = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

		String asignatura = "";
		
		System.out.println("Introduce el nombre de las asignaturas del curso:(quit para salir)");
		while (!asignatura.equals("quit")) {
			asignatura =  sc.nextLine();
			
			if(!asignatura.equals("") && !asignatura.equals("quit") ) {
				asignaturas.add(asignatura);
			}
		}
		
		return asignaturas;
	}
	/* Se introducen las notas de los alumnos en las asignaturas y se calula su nota media del curso */
	public static Hashtable calcularNotaMedia (ArrayList alumnos, ArrayList asignaturas) {
        Scanner sc = new Scanner(System.in);
		Hashtable notas=new Hashtable();
		
		for (int i = 0; i < alumnos.size(); i++) {
			float notaMedia = 0;
			for (int j = 0; j < asignaturas.size(); j++) {
			System.out.print("Nota de "+alumnos.get(i)+" en "+asignaturas.get(j)+" : ");
			 notaMedia +=  sc.nextFloat();
			}
			notaMedia /= asignaturas.size();
			notas.put(alumnos.get(i), notaMedia);		
		}	
		return notas;	
	}
	
	/*Muestra los alumnos y sus notas medias */
	public static void showNotas(Hashtable notas) {
		Enumeration notasAlumnos = notas.elements();
		Enumeration alumnos = notas.keys();
		
		System.out.println("\nNotas:");
		while(notasAlumnos.hasMoreElements()) {
			System.out.println("Nota media de "+alumnos.nextElement()+ " = "+notasAlumnos.nextElement());
		}
	}

}
