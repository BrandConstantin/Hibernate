package es.hibernate.conexion;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ActualizaCliente {

	public static void main(String[] args) {
		// crear objeto de tipo SessionFactory
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		//crear objeto de tipo Session
		Session miSession = miFactory.openSession();
		
		try {
			int idCliente = 1;
			
			miSession.beginTransaction();
			
			Clientes miCliente = miSession.get(Clientes.class, idCliente);
			miCliente.setNombre("Juan Jesús");

			miSession.getTransaction().commit();
			
			System.out.println("Registro actualizado correctamente en la BBDD");
			miSession.close();
		} finally {
            miFactory.close();
		}
	}

}
