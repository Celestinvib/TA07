import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
           
		Hashtable<Integer, String[]> articulos=new Hashtable<Integer,String[]>();
		//Estructura de la Hashtable => <Integer> Id,<String[]>{Nombre,Precio,Stock} 
		articulos.put(1,new String[]{"Batidora TecMec", "8.99","45"});
		articulos.put(2,new String[]{"Lavadora Samsung", "499.99","6"});
		articulos.put(3,new String[]{"Televesion Samsung 55'", "8.99","15"});
		articulos.put(4,new String[]{"Televesion Nevir 35'","259.99","30"});
		articulos.put(5,new String[]{"Televesion Telefunken 35", "8.99","20"});
		articulos.put(6,new String[]{"Ratón Mars Gaming","9.99","70"});
		articulos.put(7,new String[]{"Samsung s21","599.99","15"});
		articulos.put(8,new String[]{"Samsung s22","799.99","10"});
		articulos.put(9,new String[]{"Iphone 12","799.99","20"});
		articulos.put(10,new String[]{"Iphone 13","1109.99","10"});

		String option = "";
	
		while(!option.equals("quit")) {
			System.out.print("\n\n¿Qué quieres hacer?[(quit) para salir]\n1.Añadir un artículo\n2.Añadir cantidad a un artículo\n3.Consultar un artículo\n4.Mostrar todos los Arículos\n>");
			option= sc.nextLine();
			switch (option) {
			case "1":
				articulos = addArticulos(articulos);
				break;
			case "2":
				articulos = addStockArticulo(articulos);
				break;
			case "3":
				consultarArticulo(articulos);
				break;
			case "4":
				showArticulos(articulos);
				break;
			case "quit":
				break;
			default:
				System.out.println("Introduce una opción válida![(quit) para salir]");
				break;
			}		
		}
	}
	
	/*Método en el que se introducen los datos de un nuevo artículo y se añade */	
	public static Hashtable addArticulos(Hashtable<Integer,String[]> articulos) {
        Scanner sc = new Scanner(System.in);		
        
		System.out.print("\nIntroduce el nombre del artículo : ");
		String nombre = sc.nextLine();		
		System.out.print("\nIntroduce el precio del artículo(€) : ");
		String precio = sc.nextLine();
		System.out.print("\nIntroduce el stock del artículo : ");
		String stock = sc.nextLine();
		
		//Añado a la hastable los datos introducidos por el usuario y la id la pongo de forma automática (sumo 1 al hacerlo porque he empezado las id por el número 1)
		articulos.put(articulos.size()+1,new String[]{nombre,precio,stock});
		
		System.out.println("Artículo Añadido con éxito! (Id=>"+articulos.size()+")");
		
		return articulos;
	}
	
	/*Método en el que se añade stock a un producto de la tienda */	
	public static Hashtable addStockArticulo (Hashtable<Integer,String[]> articulos) {
        Scanner sc = new Scanner(System.in);
		System.out.print("\n¿Introduce la id del artículo al que deseas añadir stock?:");
		Integer idProducto = sc.nextInt();
		
		Enumeration<Integer> keys = articulos.keys();
		while(keys.hasMoreElements()) {
			Integer id = keys.nextElement();
			if(idProducto == id) {
				String[] data = articulos.get(id);//Obtenemos los datos de la array de la hastable (posición 0 -> Nombre , posición 1-> Precio y 2 -> Stock)
				
				//El usuario introduce cuanto stock quiere añadir del producto indicado
				System.out.print("\n¿Cúanto stock quieres añadir de "+data[0]+"?:"); 
				Integer stockAIntroducir = sc.nextInt();
				
				//Se parsea el stock actual del producto para poder sumarlo con el stock que ha introducido el usuario y se guarda como string en la array
				data[2] = Integer.toString(Integer.parseInt(data[2])+ stockAIntroducir);
	
				System.out.println("Stock Añadido con éxito! (Stock Actual ="+data[2]+")");
			}
		}		
		
		return articulos;		
	}
	
	/*Método en el que se introduce la id del producto que se quiere consultar y se muestran sus datos */
	public static void consultarArticulo(Hashtable<Integer,String[]> articulos) {
        Scanner sc = new Scanner(System.in);
		
        System.out.print("\n¿Introduce la id del artículo deseas consultar?:");
		Integer idProducto = sc.nextInt();
		
		Enumeration<Integer> keys = articulos.keys();
		while(keys.hasMoreElements()) {
			Integer id = keys.nextElement();
			if(idProducto == id) {
				String[] data = articulos.get(id);//Obtenemos los datos de la array de la hastable (posición 0 -> Nombre , posición 1-> Precio y 2 -> Stock)
				System.out.println("Producto(Id=>"+id+"): ");
				System.out.print("	Nombre:"+data[0]+" Precio:"+data[1]+"€ Stock:"+data[2]);
			}
		}		
		
	}

	/*Método en el que se muestran todos los productos y todos sus datos*/	
	public static void showArticulos(Hashtable<Integer,String[]> articulos) {
		Enumeration<Integer> keys = articulos.keys();
       
		System.out.println("\nArtículos:");
		while(keys.hasMoreElements()) {
			Integer id = keys.nextElement();
			String[] data = articulos.get(id);
			System.out.println("\n\nProducto(Id=>"+id+"): ");
			System.out.print("·Nombre:"+data[0]+" |·Precio:"+data[1]+"€ |·Stock:"+data[2]);
		}
				
	}
	
}
