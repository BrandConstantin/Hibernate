package es.hibernate.conexion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaCliente {
	public static void main(String[] args) {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		try {
			// crear objeto clientes
			Cliente cliente1 = new Cliente("Lavina", "Murgina", "Bosnia");
			DetallesCliente detalle1 = new DetallesCliente("laviniamurgina.es", "767809564", "Segunda clase");
			
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
