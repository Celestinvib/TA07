import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String [] articulo1 ={"Batidora TecMec", "8.99","45"};
        List<String> articulo2 = List.of("Lavadora Samsung", "499.99","6");
        List<String> articulo3 = List.of("Televesion Samsung 55'", "8.99","15");
        List<String> articulo4 = List.of("Televesion Telefunken 35", "8.99","20");
        List<String> articulo5 = List.of("Televesion Nevir 35'","259.99","30");
        List<String> articulo6 = List.of("Ratón Mars Gaming","9.99","70");
        List<String> articulo7 = List.of("Samsung s21","599.99","15");
        List<String> articulo8 = List.of("Samsung s22","799.99","10");
        List<String> articulo9 = List.of("Iphone 12","799.99","20");
        List<String> articulo10 = List.of("Iphone 13","1109.99","10");
        
        
		Hashtable articulos=new Hashtable();
		articulos.put(2,articulo2);
//		articulos.put(3, articulo3);
//		articulos.put(4, articulo4);
//		articulos.put(5, articulo5);
		
		String option = "";

		
		while(!option.equals("quit")) {
			System.out.print("\n¿Qué quieres hacer?[(quit) para salir]\n1.Añadir un artículo\n2.Añadir cantidad a un artículo\n3.Consultar un artículo\n4.Mostrar todos los Arículos\n>");
			option= sc.nextLine();
			switch (option) {
			case "1":
				articulos = addArticulos(articulos);
				break;
			case "3":
				consultarArticulo(articulos);
				break;
			case "4":
				showArticulos(articulos);
				break;
			default:
				break;
			}		
		}
//Solución que he encontrado!
//		List<String> articulo2 = List.of("2","Lavadora Samsung", "499.99","6");
//      List<String> articulo3 = List.of("3","Televesion Samsung 55'", "8.99","15");
//      List<List> a = List.of(articulo2,articulo3);
//
//      for (int i = 0; i < a.size(); i++) {
//      	System.out.println(a.get(i).get(0));
//		}
		
	}
	
	public static Hashtable addArticulos(Hashtable articulos) {
        Scanner sc = new Scanner(System.in);		
        
		System.out.print("\nIntroduce el nombre del artículo : ");
		String nombre = sc.nextLine();		
		System.out.print("\nIntroduce el precio del artículo : ");
		String precio = sc.nextLine();
		System.out.print("\nIntroduce el stock del artículo : ");
		String stock = sc.nextLine();
		
		List<String> nuevoArticulo = List.of(nombre,precio,stock);	
		articulos.put(articulos.size()+1, nuevoArticulo);
      
		return articulos;
	}
	
	public static Hashtable addStockArticulo (Hashtable articulos) {
        Scanner sc = new Scanner(System.in);
		System.out.print("\n¿Introduce la id del artículoal que deseas añadir stock?:>");
		String idProducto = sc.nextLine();
		
		return articulos;
		

	}
	
	public static void consultarArticulo(Hashtable articulos) {
        Scanner sc = new Scanner(System.in);
		System.out.print("\n¿Introduce la id del artículo deseas consultar?:>");
		String idProducto = sc.nextLine();
		
	}
	
	public static void showArticulos(Hashtable articulos) {
		Enumeration datos = articulos.elements();
		Enumeration id = articulos.keys();
       

		
		System.out.println("\nArtículos:");
		while(datos.hasMoreElements()) {
			System.out.println("Producto(Id=>"+id.nextElement()+datos.nextElement());
		}
		
		
		
	}

}
