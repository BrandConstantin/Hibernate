package es.hibernate.conexion;

import javax.persistence.*;

@Entity  //para crear nuestra clase en entidades
@Table(name="detalles_cliente")
public class DetallesCliente {
	@Column(name="id", unique = true, nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="web")
	private String web;
	
	@Column(name="tfno")
	private String tfno;
	
	@Column(name="comentarios")
	private String comentarios;

	public DetallesCliente() {
	}

	public DetallesCliente(String web, String tfno, String comentarios) {
		this.web = web;
		this.tfno = tfno;
		this.comentarios = comentarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTfno() {
		return tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
}