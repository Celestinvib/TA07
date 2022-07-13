import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex2App {

	public static void main(String[] args) {
		
		//Productos de la tienda
        List<String> producto1 = List.of("1", "3.99");
        List<String> producto2 = List.of("2", "4.99");
        List<String> producto3 = List.of("3", "6.99");
        List<String> producto4 = List.of("4", "10.99");

        List<List> productos = new ArrayList<>(Arrays.asList(producto1,producto2,producto3,producto4));

        List<List> carrito = escanearArticulos(productos);
		
        showCarrito(carrito,0.21);
               
	}
    
	/**
     * Método que escanea las id recibidas por teclado , comprueba que es un producto existe y si así es lo añade a una lista
     * @param productos Lista de los productos de la tienda
     * @return El carrito de los productos escaneados
     */
	public static List escanearArticulos (List<List> productos) {
        Scanner sc = new Scanner(System.in);
		
        System.out.println("\n[MODO DE ESCANEO DE PRODUCTOS]");
		boolean escaneando = true;
		List<String> cantidadesCarrito = new ArrayList<>(Arrays.asList()); //lista de productos
		List<List> carrito = new ArrayList<>(Arrays.asList());

		
		while(escaneando) {
			System.out.print("\n·Introduce la id del producto:((quit) para finalizar el escaneado)\n>");
			String id = sc.nextLine();
			
			if(id.equals("quit")) {
				escaneando = false;
			}else {
				boolean existe = false;
				for (int i = 0; i < productos.size(); i++) { 
					if( productos.get(i).get(0).equals(id)) { //Si la id introducida pertenece a la de algún producto
						cantidadesCarrito.add(id); //Se añade a la lista de productos
						existe = true;
					}
				}		
				if(!existe) {
					System.out.println("Error: Id de producto no encontrada!");					
				}
			}
		}
		
		carrito = llenarCarrito(productos, carrito, cantidadesCarrito);
		
		return carrito;	
	}
	
	/**
     * Método que llena el carrito con los productos escaneados , indicando la cantidad de cada uno
     * @param productos Lista de los productos de la tienda
     * @param carrito Lista de los productos comprados su id , cantidades y precio.
     * @param cantidadesCarrito Lista de ids de todos los productos escaneados
     * @return El carrito de los productos escaneados
     */
	public static List llenarCarrito (List<List> productos ,List<List> carrito , List<String> cantidadesCarrito) {
		
		boolean InCarrito = false;
		
		for (int i = 0; i < cantidadesCarrito.size(); i++) {
			InCarrito = false;
			for (int j = 0; j < carrito.size(); j++) {
				if(carrito.get(j).get(0).equals(cantidadesCarrito.get(i))) { //Si la id actual es igual a alguna de un producto del carrito
					InCarrito = true;
					Integer cantidad  = Integer.parseInt(carrito.get(j).get(2).toString()) + 1;//Se parsea la cantidad del producto y se le añade 1 de cantidad

					//No he podido actualizar el producto debido a que me daba errores y he tenido que usar remove
					//carrito.get(j).set(2,cantidad.toString()); 
					
					//Almacenamos los datos del producto actual
					String id = carrito.get(j).get(0).toString();
					String precio = carrito.get(j).get(1).toString();
					
					carrito.remove(j);
			        //Creamos un nuevo producto con los mismos datos pero la cantidad actualizada y lo añadimos la carrito
					List<String> producto = List.of(id,precio, Integer.toString(cantidad));
					carrito.add(producto);			
				}
				
			}
			
			if(!InCarrito) { //Si no esta en el carrito Añadimos el producto con esta id al carrito con 1 de cantidad actualizada

				Integer idProducto = Integer.parseInt(cantidadesCarrito.get(i)) -1;
				
				String id = productos.get(idProducto).get(0).toString();
				String precio = productos.get(idProducto).get(1).toString();
				
		        List<String> producto = List.of(id,precio, "1");
		        
				carrito.add(producto);	
				
			}
		}
		
		return carrito;
	}
	
	/**
     * Método en el que se paga el carro y muestra sus detalles una vez hecho
     * @param carrito Lista de los productos comprados su id , cantidades y precio.
     * @param IVA el tipo de IVA que se le aplicara al precio final de la compra 
     */
	public static void showCarrito (List<List> carrito , double IVA) {	
		
		double precioBruto = 0;
		int articulosComprados=0;
		
		System.out.println("Artículos de la cesta:");
		double precioArticulo = 0; 
		int cantidadArticulo = 0;
		
		for (int i = 0; i < carrito.size(); i++) {
			precioArticulo = 0; 
			cantidadArticulo = 0;
			System.out.print("\nId:"+carrito.get(i).get(0)+" Precio:"+carrito.get(i).get(1)+" Cantidad:"+carrito.get(i).get(2));
			cantidadArticulo =Integer.parseInt(carrito.get(i).get(2).toString());
			
			precioArticulo = Double.parseDouble(carrito.get(i).get(1).toString());
			precioArticulo *= cantidadArticulo;
			
			articulosComprados +=  cantidadArticulo;
			precioBruto += precioArticulo;
			
		}
		
		double precioIVA = precioBruto + (precioBruto*IVA);
		
        Scanner sc = new Scanner(System.in);
        double dineroUsuario = 0;
        
        while (dineroUsuario < precioIVA) {
	        System.out.println("\n\nAbona el importe de "+precioIVA+" €:[Dinero Pagado:"+dineroUsuario+"]\n>");
	        dineroUsuario += sc.nextDouble();
        }
        
        double dineroADevolver = 0; 
        if(dineroUsuario>precioIVA) {
        	dineroADevolver = dineroUsuario - precioIVA;
        }
        
        System.out.println("\n\nIVA Aplicado del "+(IVA*100)+"%");
		System.out.println("Precio total bruto: "+precioBruto+" €");
		System.out.println("Precio total +IVA: "+precioIVA+" €");
		System.out.println("Numero de artícuos Comprados: "+articulosComprados);
        System.out.println("Cantidad pagada: "+dineroUsuario+"€");
        System.out.println("Cambio a devolver: "+dineroADevolver+"€");
	}	
	
}
