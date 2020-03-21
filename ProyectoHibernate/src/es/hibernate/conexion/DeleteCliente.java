package es.hibernate.conexion;

import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteCliente {

	public static void main(String[] args) {
		// crear objeto de tipo SessionFactory
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		//crear objeto de tipo Session
		Session miSession = miFactory.openSession();
		
		try {			
			miSession.beginTransaction();
			
			miSession.createQuery("DELETE Clientes c WHERE c.apellidos = 'Urtzigale'").executeUpdate();
			
			miSession.getTransaction().commit();
			
			System.out.println("Registro eliminado correctamente en la BBDD");
			miSession.close();
		} finally {
            miFactory.close();
		}
	}

}
