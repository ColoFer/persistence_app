package com.example.demo;

import com.example.demo.entidades.*;
import com.example.demo.repositorio.ClienteRepository;
import com.example.demo.repositorio.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ColoApplication {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	RubroRepository rubroRepository;

	public static void main(String[] args) {
		SpringApplication.run(ColoApplication.class, args);
		System.out.println("Estoy Funcionando");
	}
	@Bean
	public CommandLineRunner init(){
	return args -> {
		System.out.println("------------Estoy Funcionando------------");

		Cliente cliente = new Cliente();

		cliente.setNombre("Emma");
		cliente.setApellido("Gonzalez");
		cliente.setTelefono("123456789");
		cliente.setEmail("emmagonzalez@gmail.com");

		DetallePedido detallePedido = new DetallePedido();

		detallePedido.setCantidad(5);
		detallePedido.setSubTotal(100);

		Domicilio domicilio = new Domicilio();

		domicilio.setCalle("Av. España");
		domicilio.setNumero("2550");
		domicilio.setLocalidad("Mendoza");

		Factura factura = new Factura();

		factura.setNumero(25);
		//factura.setFecha();
		factura.setDescuento(0);
		factura.setFormaPago("Efectivo");
		factura.setTotal(1250);

		Pedido pedido = new Pedido();
		//pedido.setFecha();
		pedido.setEstado("En Proceso");
		pedido.setTipoEnvio("Delivery");
		pedido.setTotal(2150);

		Producto producto = new Producto();
		producto.setTipo("Papa");
		producto.setTiempoEstimadoCocina(45);
		producto.setDenominacion("Pure");
		producto.setPrecioVenta(350);
		producto.setPrecioCompra(200);
		producto.setStockActual(50);
		producto.setStockMinimo(5);
		producto.setUnidadMedida("kg");
		producto.setReceta("1.Pelar y picar papas" + "2.Colocar agua en olla y dejar que hierva" + "3.Colocar las papas en la olla con sal" + "4.Cuando esten blandas retirar" + "5.Pisar sin dejar grumos, agregar condimento a gusto" + "6.Servir en el plato" );

		Rubro rubro = new Rubro();
		rubro.setDenominacion("Verdura");

		// Guardar el objeto Cliente en la base de datos

		cliente.addDomicilio(domicilio);
		cliente.addPedido(pedido);

		pedido.addDetallePedido(detallePedido);
		pedido.setFactura(factura);

		detallePedido.setProducto(producto);

		rubro.addProducto(producto);

		clienteRepository.save(cliente);
		rubroRepository.save(rubro);

		// Recuperar el objeto Cliente desde la base de datos

//		Cliente clienteRecuperado = clienteRepository.findById(cliente.getId()).orElse(null);
//		if(clienteRecuperado != null){
//			System.out.println("Nombre: " + clienteRecuperado.getNombre());
//			System.out.println("Apellido: " + clienteRecuperado.getApellido());
//			System.out.println("Telefono: " + clienteRecuperado.getTelefono());
//			System.out.println("Email: " + clienteRecuperado.getEmail());
//
//		}
	};

	}

}

