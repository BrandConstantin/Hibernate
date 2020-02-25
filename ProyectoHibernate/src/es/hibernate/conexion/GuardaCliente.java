package es.hibernate.conexion;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GuardaCliente {

	public static void main(String[] args) {
		// crear objeto de tipo SessionFactory
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		//crear objeto de tipo Session
		Session miSession = miFactory.openSession();
		
		try {
			// crear objeto clientes
			Clientes cliente1 = new Clientes("Pablo", "Urtzigale", "Batasuna");
			
			// ejecutar transacción sql
			// comenzar transacción
			miSession.beginTransaction();
			// guardar en la BBDD
			miSession.save(cliente1);
			// hacer commit
			miSession.getTransaction().commit();
			
			System.out.println("Registro insertado correctamente en la BBDD");
			
			// leer registro
			miSession.beginTransaction();
			System.out.println("Lectura del registro con Id " + cliente1.getId());
			
			Clientes clienteInsertado = miSession.get(Clientes.class, cliente1.getId());
			System.out.println("Registro : " + clienteInsertado);
			
			miSession.getTransaction().commit();
			
			miSession.close();
		} finally {
			miFactory.close();
		}
	}

}
