package co.uniquindio.pr2.agenda.model;

import java.io.Serializable;
import java.util.Arrays;

public class Reunion implements Serializable{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String descripcion;
	private String fecha;
	private String hora;
	private Contacto[] listaContactos;
	private Nota[] listaNotas;


	public Reunion() {
		super();
	}


	public Reunion(String descripcion, String fecha, String hora, int numeroContactos, int numeroNotas) {
		super();
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.hora = hora;
		this.listaContactos = new Contacto[numeroContactos];
		this.listaNotas = new Nota[numeroNotas];
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public Contacto[] getListaContactos() {
		return listaContactos;
	}


	public void setListaContactos(Contacto[] listaContactos) {
		this.listaContactos = listaContactos;
	}


	public Nota[] getListaNotas() {
		return listaNotas;
	}


	public void setListaNotas(Nota[] listaNotas) {
		this.listaNotas = listaNotas;
	}


	@Override
	public String toString() {
		return "Reunion [descripcion=" + descripcion + ", fecha=" + fecha + ", hora=" + hora + ", listaContactos="
				+ Arrays.toString(listaContactos) + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
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
		Reunion other = (Reunion) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		return true;
	}


}
