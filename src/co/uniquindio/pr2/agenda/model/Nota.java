package co.uniquindio.pr2.agenda.model;

import java.io.Serializable;

public class Nota implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String fecha;
	private String comentarios;
	private CategoriaNota categoriaNota;

	public Nota() {

	}

	public Nota(String codigo, String fecha, String comentarios, CategoriaNota categoriaNota) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.comentarios = comentarios;
		this.categoriaNota = categoriaNota;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public CategoriaNota getCategoriaNota() {
		return categoriaNota;
	}

	public void setCategoriaNota(CategoriaNota categoriaNota) {
		this.categoriaNota = categoriaNota;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Nota [codigo=" + codigo + ", fecha=" + fecha + ", comentarios=" + comentarios + ", categoriaNota="
				+ categoriaNota + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Nota other = (Nota) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}



}
