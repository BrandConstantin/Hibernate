package es.hibernate.conexion;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaPedidosCliente {
	public static void main(String[] args) {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		try {			
			miSession.beginTransaction();

			// obtener cliente de la tabla clientes
			Cliente elCliente = miSession.get(Cliente.class, 2);
			
			// crear pedidos de cliente
			Pedido pedido1 = new Pedido(new Date(120, 7, 8));
			Pedido pedido2 = new Pedido(new Date(120, 2, 9));
			Pedido pedido3 = new Pedido(new Date(120, 6, 8));
			
			// agregar pedidos creados al cliente creado
			elCliente.agregarPedidos(pedido3);
			elCliente.agregarPedidos(pedido2);
			elCliente.agregarPedidos(pedido1);
			
			// guardar los pedidos en la BBDD
			miSession.save(pedido3);
			miSession.save(pedido2);
			miSession.save(pedido1);

			miSession.getTransaction().commit();
			
			System.out.println("Registro insertado correctamente en la BBDD");
			
			miSession.close();
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			miSession.close();
			miFactory.close();
		}
	}
}
