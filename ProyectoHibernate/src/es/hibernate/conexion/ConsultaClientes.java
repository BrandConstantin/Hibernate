package es.hibernate.conexion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {
	public static void main(String[] args) {
		// crear objeto de tipo SessionFactory
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		//crear objeto de tipo Session
		Session miSession = miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			
			//consulta clientes
			List<Clientes> losClientes = miSession.createQuery("from Clientes").getResultList();
			//mostrar clientes
			recorreClientesConsultado(losClientes);
			
			// consulta especifica
			losClientes = miSession.createQuery("from Clientes c where c.direccion like 'Batas%'").getResultList();
			recorreClientesConsultado(losClientes);
			
			// commit 
			miSession.getTransaction().commit();
			// cerrar session
			miSession.close();
		} finally {
			miFactory.close();
		}
	}

	private static void recorreClientesConsultado(List<Clientes> losClientes) {
		for(Clientes unCliente:losClientes) {
			System.out.println(unCliente);
		}
	}
}
