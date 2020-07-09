package es.hibernate.conexion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaDetallesCliente {
	public static void main(String[] args) {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		try {		
			miSession.beginTransaction();
			
			DetallesCliente detallesDelCliente = miSession.get(DetallesCliente.class, 2);
			
			detallesDelCliente.getCliente().setDetallesCliente(null);
			
			if(detallesDelCliente != null) {
				miSession.delete(detallesDelCliente);													
			}
			
			miSession.getTransaction().commit();
			
			System.out.println("Registro borrado correctamente en la BBDD");
			
			miSession.close();
		} finally {
			miFactory.close();
		}
	}
}
