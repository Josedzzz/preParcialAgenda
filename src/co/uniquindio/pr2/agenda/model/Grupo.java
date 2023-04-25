package co.uniquindio.pr2.agenda.model;

import java.io.Serializable;
import java.util.Arrays;

public class Grupo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Contacto[] listaContactos;
	private Categoria categoria;


	public Grupo(String nombre, int numeroContactos, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.listaContactos = new Contacto[numeroContactos];
		this.categoria = categoria;
	}


	public Grupo() {
		super();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Contacto[] getListaContactos() {
		return listaContactos;
	}


	public void setListaContactos(Contacto[] listaContactos) {
		this.listaContactos = listaContactos;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", listaContactos=" + Arrays.toString(listaContactos) + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(listaContactos);
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (!Arrays.equals(listaContactos, other.listaContactos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


//----------------------------------------Resuelvo puntos del preParcial--------------------------------------------
	/**
	 * Me retorna true si todos los contactos de un grupo tienen de direccion: calle 2 numero 18-00
	 * @return
	 */
	public boolean verificarDireccionContactos() {
		for(Contacto contacto : listaContactos) {
			if(contacto == null || !contacto.getDireccion().equals("calle 2 numero 18-00")) {
				return false;
			}
		}
		return true;
	}


}
