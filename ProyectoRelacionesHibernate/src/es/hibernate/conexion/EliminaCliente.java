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
			miSession.beginTransaction();
			
			Cliente elCliente = miSession.get(Cliente.class, 3);
			
			if(elCliente != null) {
				miSession.delete(elCliente);													
			}
			
			miSession.getTransaction().commit();
			
			if(elCliente != null) {
				System.out.println("Registro borrado correctamente en la BBDD");
			}else {
				System.out.println("Registro no encontrado");
			}
			
			miSession.close();
		} finally {
			miFactory.close();
		}
	}
}
