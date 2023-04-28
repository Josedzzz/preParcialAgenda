package co.uniquindio.pr2.agenda.model;

import java.io.Serializable;
import java.util.Arrays;

public class Contacto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String alias;
	private String direccion;
	private String telefono;
	private String email;

	private Grupo[] listaGrupos;
	private Reunion[] listaReuniones;

	public Contacto() {
		super();
	}

	public Contacto(String nombre, String alias, String direccion, String telefono, String email, int numeroGrupos,
			int numeroReuniones) {
		super();
		this.nombre = nombre;
		this.alias = alias;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.listaGrupos = new Grupo[numeroGrupos];
		this.listaReuniones = new Reunion[numeroReuniones];
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Grupo[] getListaGrupos() {
		return listaGrupos;
	}
	public void setListaGrupos(Grupo[] listaGrupos) {
		this.listaGrupos = listaGrupos;
	}
	public Reunion[] getListaReuniones() {
		return listaReuniones;
	}
	public void setListaReuniones(Reunion[] listaReuniones) {
		this.listaReuniones = listaReuniones;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Contacto other = (Contacto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", alias=" + alias + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", email=" + email + ", listaGrupos=" + Arrays.toString(listaGrupos) + ", listaReuniones="
				+ Arrays.toString(listaReuniones) + "]";
	}

//-----------------------Resuelvo puntos del preParcial--------------------------------------------------------------
	/**
	 * Mira si cada vocal se encuentra por el indexOf, y si no existe el intexOf da -1
	 * @return
	 */
	public boolean tiene5vocales() {
		String vocales = "aeiou";
	    for (int i = 0; i < vocales.length(); i++) {
	        if (nombre.toLowerCase().indexOf(vocales.charAt(i)) == -1) {
	            return false;
	        }
	    }
	    return true;
	}

	public boolean isTelefonoCapicua() {
		//Se obtiene el numero de telefono invertido
		StringBuilder str = new StringBuilder();
		str.append(getTelefono());
		String inverso = str.reverse().toString();

		//Se retorna si el numero de telefono del contacto es un numero capicua
		//El numero de telefono es capicua si es igual a su inverso
		return getTelefono().equals(inverso);
	}

//---------------------------------------RESUELVO PUNTOS DEL PARCIAL--------------------------------------------
	/**
	 * verifica si el contacto pertenece al grupoFiltrar
	 * @param grupoFiltrar
	 * @return
	 */
	public boolean verificarGrupo(Grupo grupoFiltrar) {
		for(Grupo grupo : listaGrupos) {
			if(grupo != null && grupo.equals(grupoFiltrar)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verifica si el telefono del contacto inicia con el prefijo
	 * @param prefijo
	 * @return
	 */
	public boolean verificarPrefijo(String prefijo) {
		String num = telefono;
		if(num.startsWith(prefijo)){
			return true;
		}
		return false;
	}



}
