import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex4App {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Productos de la tienda			
		List<String> producto1 = List.of("1", "3.99","200");
		List<String> producto2 = List.of("2", "4.99","100");
		List<String> producto3 = List.of("3", "6.99","150");
        List<String> producto4 = List.of("4", "10.99","40");
        List<String> producto5 = List.of("5", "2.99","400");

        List<List> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        
		List<String> productosEscaneados = new ArrayList<>(); 
		List<List> carrito =  new ArrayList<>(); 
        
		String option = "";
		
		while(!option.equals("quit")) {
			System.out.print("\n\n¿Qué quieres hacer?[(quit) para salir]\n1.Escanear Artículos\n2.Añadir un artículo\n3.Añadir cantidad a un artículo\n4.Consultar un artículo\n5.Mostrar todos los Arículos\n>");
			option= sc.nextLine();
			switch (option) {
			case "1":
				productosEscaneados = Ex2App.escanearArticulos(productos); //Llamo al método del ejercicio 2 para escanear productos
				carrito =  Ex2App.llenarCarrito(productos, productosEscaneados); //Se llena el carrito con los productos escaneados
				
				System.out.println("1.Finalizar transaccion o 2.Cancelar transaccion:");//Se da la opción de finalizar o cancelar la operación
				String option1= sc.nextLine();
				if(option1.equals("1")) { //Si el usuario quiere adquirir los productos del carrito
					Ex2App.finalizarTransaccion(carrito, 0.21); //Se llama al método finalizar transaccion  
					productos = restarCantidad(productos,carrito); //Se actualiza la cantidad de los productos
				}else {
					System.out.println("Cancelando transaccion productos escaneados desestimados");
				}
				break;
			case "2":
				productos = addProducto(productos);
				break;
			case "3":
				productos = addCantidad(productos);
				break;
			case "4":
				consultarProducto(productos);
				break;
			case "5":
				showProductos(productos);
				break;
			case "quit":
				sc.close();
				break;
			default:
				System.out.println("Introduce una opción válida![(quit) para salir]");
				break;
			}
		}				
	}
    
	/**
     * Método en el que se introducen los datos de un nuevo artículo y se añade
     * @param productos Lista de los productos de la tienda
     * @return una lista con el producto que se acaba de crear añadido
     */
	public static List addProducto (List<List> productos ) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce el precio del producto:");
		String precio = sc.nextLine();

		System.out.print("\nIntroduce la cantidad del producto:");
		String cantidad = sc.nextLine();
		
		
        List<String> producto = List.of(Integer.toString((productos.size()+1)),precio,cantidad);

		productos.add(producto);
		
		System.out.println("Producto "+productos.size()+" implementado!");
	
		return productos;
	}
	
	/**
     * Método en el que se añade stock a un producto de la tienda
     * @param productos Lista de los productos de la tienda
     * @return una lista con el producto con la cantidad actualizada 
     */
	public static List addCantidad (List<List> productos ) {
		Scanner sc = new Scanner(System.in);
			
	    System.out.print("\nIntroduce la id del artículo:");
		String idProducto = sc.nextLine();
			
		for (int i = 0; i < productos.size(); i++) {
			if(productos.get(i).get(0).equals(idProducto)) {
				System.out.print("\nIntroduce la cantidad a ingresar:");
				Integer cantidadIngresar = sc.nextInt();
				
				String id = productos.get(i).get(0).toString();
				String precio = productos.get(i).get(1).toString();
				
				Integer cantidad = Integer.parseInt(productos.get(i).get(2).toString());	
				cantidad += cantidadIngresar;
				
				productos.remove(i);
				
				List<String> producto = List.of(id,precio,Integer.toString(cantidad));
				productos.add(producto);
				System.out.println("Stock Añadido con éxito! (Stock Actual ="+cantidad+")");
				break;
			}	
		}
		
		return productos;
	}
	
	/**
     * Método en el que se resta la cantidad de los productos comprados por el usuario
     * @param productos Lista de los productos de la tienda
     * @param carrito Lista con todos los productos del carrito que el usuario quiere adquirir
     * @return una lista con el producto con la cantidad actualizada 
     */
	public static List restarCantidad (List<List> productos , List<List> carrito ) {
		
		for (int i = 0; i < carrito.size(); i++) {
			String idArticulo = carrito.get(i).get(0).toString();
			Integer unidadesVendidas =Integer.parseInt(carrito.get(i).get(2).toString());

			for (int j = 0; j < productos.size(); j++) {
				if(productos.get(j).get(0).equals(idArticulo)) {
					String precio = productos.get(j).get(1).toString();
					
					Integer cantidad = Integer.parseInt(productos.get(j).get(2).toString());	
					cantidad -= unidadesVendidas;
					
					productos.remove(j);
					
					List<String> producto = List.of(idArticulo,precio,Integer.toString(cantidad));
					productos.add(producto);
					break;
				}
			}
		}
		
		return productos;
	}
	

	/**
     * Método en el que se introduce la id del producto que se quiere consultar y se muestran sus datos 
     * @param productos Lista de los productos de la tienda
     */
	public static void consultarProducto(List<List> productos) {
        Scanner sc = new Scanner(System.in);
		
        System.out.print("\nIntroduce la id del artículo deseas consultar:");
		String idIntroducido = sc.nextLine();
		
		for (int i = 0; i < productos.size(); i++) {
			if(productos.get(i).get(0).equals(idIntroducido)) {
				System.out.println("Id: "+productos.get(i).get(0)+" Precio: "+productos.get(i).get(1)+" Unidades: "+productos.get(i).get(2));
			}
		}
		
	}
	
	/**
     * Método en el que se muestran todos los productos y todos sus datos
     * @param productos Lista de los productos de la tienda
     */
	public static void showProductos(List<List> productos){
		
		for (int i = 0; i < productos.size(); i++) {
			System.out.print("\nId:"+productos.get(i).get(0)+" Precio:"+productos.get(i).get(1)+" Cantidad:"+productos.get(i).get(2));
		}
	}
	
	

}
