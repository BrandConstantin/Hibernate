package es.hibernate.conexion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerCliente {

	public static void main(String[] args) {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class).buildSessionFactory();

		Session miSession = miFactory.openSession();

		try {
			miSession.beginTransaction();

			// obtener objeto de detallesCliente
			DetallesCliente elCliente = miSession.get(DetallesCliente.class, 2);
			
			System.out.println(elCliente);
			System.out.println(elCliente.getCliente());
			
			miSession.getTransaction().commit();


			miSession.close();
		} finally {
			miFactory.close();
		}
	}

}
