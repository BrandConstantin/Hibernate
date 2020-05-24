package es.hibernate.conexion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaCliente {
	public static void main(String[] args) {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		try {
			// crear objeto clientes
			Cliente cliente1 = new Cliente("Pablo", "Urtzigale", "Batasuna");
			DetallesCliente detalle1 = new DetallesCliente("pildorasinformaticas.es", "564576354", "Primera clase");
			
			// asociar los objetos
			cliente1.setDetallesCliente(detalle1);
			
			miSession.beginTransaction();
			
			miSession.save(cliente1);

			miSession.getTransaction().commit();
			
			System.out.println("Registro insertado correctamente en la BBDD");
			
			miSession.close();
		} finally {
			miFactory.close();
		}
	}
}
