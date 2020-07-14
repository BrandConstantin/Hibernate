package es.hibernate.conexion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.sun.javafx.scene.CssFlags;

@Entity  //para crear nuestra clase en entidades
@Table(name="cliente")
public class Cliente {
	@Column(name="id", unique = true, nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="direccion")
	private String direccion;
	
	@OneToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Pedido> pedidos;
	
	//nececita dos constructores, uno por defecto sin parámetros y otro con todos los parametros
	public Cliente() {	}

	public Cliente(String nombre, String apellido, String direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellido) {
		this.apellido = apellido;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private DetallesCliente detallesCliente;
	
	
	public DetallesCliente getDetallesCliente() {
		return detallesCliente;
	}

	public void setDetallesCliente(DetallesCliente detallesCliente) {
		this.detallesCliente = detallesCliente;
	}

	//un método toString para leer la información para devolvernos la información de forma legible
	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ "]";
	}
	
	public void agregarPedidos(Pedido elPedido) {
		if(pedidos == null) {
			pedidos = new ArrayList<>();
			
			pedidos.add(elPedido);
			elPedido.setCliente(this);
		}
	}
}
