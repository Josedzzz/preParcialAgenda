package co.uniquindio.pr2.agenda.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Agenda implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Contacto[] listaContactos;
	private Grupo[] listaGrupos;
	private Reunion[] listaReuniones;
	private Nota[] listaNotas;


	public Agenda(String nombre, int numeroContactos,int numeroGrupos,int numeroReuniones, int numeroNotas) {
		super();
		this.nombre = nombre;
		this.listaContactos = new Contacto[numeroContactos];
		this.listaGrupos = new Grupo[numeroGrupos];
		this.listaReuniones = new Reunion[numeroReuniones];
		this.listaNotas = new Nota[numeroNotas];

		//Inicializo valores para probarlos en la tabla
		Contacto contacto1 = new Contacto("Jose", "Balin", "calle 2 numero 18-00", "000000999", "joseda@algo.com", 10, 10);
		Contacto contacto2 = new Contacto("Nico", "Perro", "calle 2 numero 18-00", "999000000", "nicoda@algo.com", 10, 10);
		listaContactos[0] = contacto1;
		listaContactos[1] = contacto2;

		//Inicalizo valores de grupos para probarlos en la tabla
		Grupo grupo1 = new Grupo("Amigos", 10, Categoria.AMIGOS);
		Grupo grupo2 = new Grupo("Work", 10, Categoria.OFICINA);
		listaGrupos[0] = grupo1;
		listaGrupos[1] = grupo2;

		//Inicializo valores para las reuniones en la tabla
		Reunion reunion1 = new Reunion("Aspectos legales", "12/05/2023", "14:05", 10, 10);
		Reunion reunion2 = new Reunion("Aspectos de infraestructura", "10/05/2023", "10:05", 10, 10);
		listaReuniones[0] = reunion1;
		listaReuniones[1] = reunion2;

		//Inicializo valores para las notas en la tabla
		Nota nota1 = new Nota("123", "12/05/2023", "Políticas de privacidad", CategoriaNota.PUBLICA);
		Nota nota2 = new Nota("321", "10/05/2023", "Políticas de jerarquías", CategoriaNota.PRIVADA);
		listaNotas[0] = nota1;
		listaNotas[1] = nota2;
	}


	public Agenda() {
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

	public Nota[] getListaNotas() {
		return listaNotas;
	}


	public void setListaNotas(Nota[] listaNotas) {
		this.listaNotas = listaNotas;
	}

	@Override
	public String toString() {
		return "Agenda [nombre=" + nombre + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Agenda other = (Agenda) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
//----------------------------------------------------------------------------------------------------------------------
	/**
	 *
	 * @param nombre
	 * @param telefono
	 * @return
	 */
	public Contacto obtenerContacto(String nombre, String telefono) {
		Contacto contactoEncontrado = null;
		for(Contacto contacto : listaContactos) {
			//Tengo que ponerle el que sea diferente a null porque o sino causo un nullPointerException
			if(contacto != null && contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)) {
				contactoEncontrado = contacto;
			}
		}
		return contactoEncontrado;
	}

	public void actualizarContacto(String nombre, String alias, String direccion, String telefono, String email) {
		Contacto contactoEncontrado = obtenerContacto(nombre, telefono);
		contactoEncontrado.setAlias(alias);
		contactoEncontrado.setDireccion(direccion);
		contactoEncontrado.setEmail(email);
	}

	/**
	 * Añade un contacto siempre y cuanto este no exista y la agenda tenga espacio
	 * @param newContacto
	 * @throws ContactoException
	 */
	/*public void aniadirContacto(Contacto newContacto) throws ContactoException {
		Contacto contacto = buscarContacto(newContacto);
		int posDisponible = obtenerPosicionLibre();

		if(contacto != null){
			throw new ContactoException("El contacto ya existe");
		}
		if(posDisponible == -1){
			throw new ContactoException("Agenda llena");
		}

		listaContactos[posDisponible] = newContacto;
	}*/

	/**
	 * Dado los atributos de un contacto este me dice si pudo ser creado o no
	 * @param nombre
	 * @param alias
	 * @param direccion
	 * @param telefono
	 * @param email
	 * @return
	 */
	public boolean aniadirContacto(String nombre, String alias, String direccion, String telefono, String email) {
		Contacto contacto = obtenerContacto(nombre, telefono);
		int posDisponible = obtenerPosicionLibre();

		if(contacto == null && posDisponible != -1) {
			contacto = new Contacto(nombre, alias, direccion, telefono, email, 10, 10);
			listaContactos[posDisponible] = contacto;
			return true;
		}
		return false;
	}

	/**
	 * Me dice cual es la posición libre de la lista de contactos, si no existe me retorna -1
	 * @return
	 */
	private int obtenerPosicionLibre() {
	    for (int i = 0; i < listaContactos.length; i++) {
	        if(listaContactos[i] == null) {
	            return i;
	        }
	    }
	    return -1;
	}

	/**
	 * Dado un contacto retorna ese contacto si tiene su nombre y telefono igual, si no existe retorna null
	 * @param newContacto
	 * @return
	 */
	/*private Contacto buscarContacto(Contacto newContacto) {
		List<Contacto> asList = Arrays.asList(listaContactos);
		Optional<Contacto> findFirst = asList.stream().filter(c -> c.equals(newContacto)).findFirst();
		return findFirst.get();
	}*/

	/**
	 * Dado un contacto retorna true si existe un contacto en la lista de contactos con un nombre y telefono igual
	 * @param newContacto
	 * @return
	 */
	public boolean existeContacto(Contacto newContacto) {
		List<Contacto> asList = Arrays.asList(listaContactos);
		return asList.stream().filter(c -> c.equals(newContacto)).findFirst().isPresent();
	}

	/**
	 * Dado un contacto me dice a cuales grupos este pertenece
	 * @param contactoSeleccion
	 * @return
	 */
	public String darListadoGruposContacto(Contacto contactoSeleccion) {
		String gruposListados = "";
		for(Grupo grupo : contactoSeleccion.getListaGrupos()) {
			if(grupo != null) {
				gruposListados = gruposListados + grupo.getNombre() + "\n";
			}
		}
		return gruposListados;
	}

	/**
	 * Dado un contacto me dice a cuales reuniones este pertenece
	 * @param contactoSeleccion
	 * @return
	 */
	public String darListadoReunionesContacto(Contacto contactoSeleccion) {
		String reunionesListadas = "";
		for(Reunion reunion : contactoSeleccion.getListaReuniones()) {
			if(reunion != null) {
				reunionesListadas = reunionesListadas + reunion.getDescripcion() + "\n";
			}
		}
		return reunionesListadas;
	}

	/**
	 * Me devuelve el String de la lista de contactos
	 * @return
	 */
	public String listarContactos() {
		String contactos = "";
		for(Contacto contacto : listaContactos) {
			if(contacto != null) {
				contactos = contactos + contacto.getNombre() + " : " + contacto.getTelefono() + "\n";
			}
		}
		return contactos;
	}

	/**
	 * Retorna el telefono dado el nombre de un contacto
	 * @param nombre
	 * @return
	 */
	public String darTelefonoContacto(String nombre) {
		String telefono = "";
		for(Contacto contacto : listaContactos) {
			if(contacto != null && contacto.getNombre().equalsIgnoreCase(nombre)) {
				telefono = contacto.getTelefono();
			}
		}
		return telefono;
	}

	/**
	 * Dado un contacto como parametro lo elimina de la lista de contactos
	 * y aparte el contacto es eliminado de las reuniones y grupos en los que este
	 * @param contactoEliminar
	 */
	public boolean eliminarContacto(Contacto contactoEliminar) {
		boolean fueEliminado = false;
	    for(int i = 0; i < listaContactos.length; i++) {
	        Contacto contacto = listaContactos[i];
	        if(contacto != null && contacto.equals(contactoEliminar)) {
	            listaContactos[i] = null;
	            fueEliminado = true;
	            break;
	        }
	    }

	    if(fueEliminado) {
	    	borrarContactoEnGrupos(contactoEliminar);
	    	borrarContactoEnReuniones(contactoEliminar);
	    }
	    return fueEliminado;
	}

	/**
	 * Dado un contacto que se vaya a eliminar, se borra en todas las reuniones en la que este
	 * @param contactoEliminar
	 */
	private void borrarContactoEnReuniones(Contacto contactoEliminar) {
		for(int i = 0; i < listaReuniones.length; i++) {
			Reunion reunion = listaReuniones[i];
			if(reunion != null) {
				for(int j = 0; j < reunion.getListaContactos().length; j++) {
					Contacto contacto = reunion.getListaContactos()[j];
					if(contacto != null && contacto.equals(contactoEliminar)) {
						reunion.getListaContactos()[j] = null;
					}
				}
			}
		}
	}

	/**
	 * Dado un contacto a eliminar, se borra en todos los grupos en los que este
	 * @param contactoEliminar
	 */
	private void borrarContactoEnGrupos(Contacto contactoEliminar) {
		for(int i = 0; i < listaGrupos.length; i++) {
			Grupo grupo = listaGrupos[i];
			if(grupo != null) {
				for(int j = 0; j < grupo.getListaContactos().length; j++) {
					Contacto contacto = grupo.getListaContactos()[j];
					if(contacto != null && contacto.equals(contactoEliminar)) {
						grupo.getListaContactos()[j] = null;
					}
				}
			}
		}
	}


	/**
	 * Me dice si la lista de contactos esta llena o no
	 * @return
	 */
	public boolean estaLlenaAgendaContactos() {
	    for(Contacto contacto : listaContactos) {
	        if(contacto == null) {
	            return false;
	        }
	    }
	    return true;
	}

	/**
	 * Retorna cuantos espacios disponibles hay en la lista de contactos
	 * @return
	 */
	public int espaciosDisponiblesContactos() {
	    int contador = 0;
	    for (Contacto contacto : listaContactos) {
	        if (contacto == null) {
	            contador++;
	        }
	    }
	    return contador;
	}

//------------------------ GRUPOS ---------------------------------

	/**
	 * Dado un nombre me devuelve el grupo al que le corresponde el nombre
	 * @param nombre
	 * @return
	 */
	public Grupo obtenerGrupo(String nombre) {
		Grupo grupoEncontrado = null;
		for(Grupo grupo : listaGrupos) {
			//Tengo que ponerle el que sea diferente a null porque o sino causo un nullPointerException
			if(grupo != null && grupo.getNombre().equals(nombre)) {
				grupoEncontrado = grupo;
			}
		}
		return grupoEncontrado;
	}

	/**
	 * Dado un grupo me muestra los contactos que pertencen al grupo
	 * @param grupo
	 * @return
	 */
	public String mostrarContactosGrupo(Grupo grupo) {
		String contactosGrupo = "";
		for(Contacto contacto : grupo.getListaContactos()) {
			if(contacto != null) {
				contactosGrupo = contactosGrupo + contacto.getNombre() + " : " + contacto.getTelefono() + "\n";
			}
		}
		return contactosGrupo;
	}

	/**
	 * Actualiza la categoria de un grupo
	 * @param nombreGrupo
	 * @param categoriaGrupo
	 */
	public void actualizarGrupo(String nombreGrupo, Categoria categoriaGrupo) {
		Grupo grupoEncontrado = obtenerGrupo(nombreGrupo);
		grupoEncontrado.setCategoria(categoriaGrupo);
	}

	/**
	 * Añade un grupo dado sus atributos (se verifica que no esté repetido y que haya espacio)
	 * @param nombreGrupo
	 * @param categoriaGrupo
	 * @return
	 */
	public boolean aniadirGrupo(String nombreGrupo, Categoria categoriaGrupo) {
		Grupo grupo = obtenerGrupo(nombreGrupo);
		int posDisponibleGrupo = obtenerPosicionLibreGrupo();

		if(grupo == null && posDisponibleGrupo != -1) {
			grupo = new Grupo(nombreGrupo, 10, categoriaGrupo);
			listaGrupos[posDisponibleGrupo] = grupo;
			return true;
		}
		return false;
	}

	/**
	 * Me dice cual es la posición libre en el arreglo de grupos
	 * @return
	 */
	private int obtenerPosicionLibreGrupo() {
	    for (int i = 0; i < listaGrupos.length; i++) {
	        if(listaGrupos[i] == null) {
	            return i;
	        }
	    }
	    return -1;
	}

	/**
	 * Dado un grupo lo elimina de la lista de grupos y elimina de los contactos el grupo
	 * @param grupoEliminar
	 * @return
	 */
	public boolean eliminarGrupo(Grupo grupoEliminar) {
		boolean fueEliminado = false;
	    for(int i = 0; i < listaGrupos.length; i++) {
	        Grupo grupo = listaGrupos[i];
	        if(grupo != null && grupo.equals(grupoEliminar)) {
	            listaGrupos[i] = null;
	            fueEliminado = true;
	            break;
	        }
	    }

	    if(fueEliminado) {
	    	eliminarGrupoContactos(grupoEliminar); //Es para eliminar este grupo de todos los contactos
	    }
	    return fueEliminado;
	}

	/**
	 * Dado un grupo a eliminar, elimina de los contactos (listado de grupos) este grupo
	 * @param grupoEliminar
	 */
	private void eliminarGrupoContactos(Grupo grupoEliminar) {
		for(int i = 0; i < listaContactos.length; i++) {
			Contacto contacto = listaContactos[i];
			if(contacto != null) {
				for(int j = 0; j < contacto.getListaGrupos().length; j++) {
					Grupo grupo = contacto.getListaGrupos()[j];
					if(grupo != null && grupo.equals(grupoEliminar)) {
						contacto.getListaGrupos()[j] = null;
					}
				}
			}
		}
	}

	/**
	 * Añade un contacto a un grupo, siempre y cuando cada uno de ellos tenga espacio
	 * @param contactoSeleccion
	 * @param grupoSeleccion
	 * @return
	 */
	public boolean aniadirContactoGrupo(Contacto contactoSeleccion, Grupo grupoSeleccion) {
		boolean fueAgregado = false;

		Contacto[] listaContactosAux = grupoSeleccion.getListaContactos();
		int posDisponibleContacto = obtenerPosicionLibreContactoGrupo(listaContactosAux);

		Grupo[] listaGruposAux = contactoSeleccion.getListaGrupos();
		int posDiosponibleGrupo = obtenerPosicionLibreGrupoContacto(listaGruposAux);

		if(!existeContactoGrupo(contactoSeleccion, listaContactosAux) && posDisponibleContacto != -1) {
			if(!existeGrupoContacto(grupoSeleccion, listaGruposAux) && posDiosponibleGrupo != -1) {
				listaContactosAux[posDisponibleContacto] = contactoSeleccion;
				grupoSeleccion.setListaContactos(listaContactosAux);
				listaGruposAux[posDiosponibleGrupo] = grupoSeleccion;
				contactoSeleccion.setListaGrupos(listaGruposAux);
				fueAgregado = true;
			}
		}
		return fueAgregado;
	}

	/**
	 * Me obtiene la posicion libre para la lista de contactos del grupo
	 * @param listaContactosAux
	 * @return
	 */
	private int obtenerPosicionLibreContactoGrupo(Contacto[] listaContactosAux) {
	    for (int i = 0; i < listaContactosAux.length; i++) {
	        if(listaContactosAux[i] == null) {
	            return i;
	        }
	    }
	    return -1;
	}

	/**
	 * Me obtiene la posicion libre para la lista de grupos del contacto
	 * @param listaGruposAux
	 * @return
	 */
	private int obtenerPosicionLibreGrupoContacto(Grupo[] listaGruposAux) {
		for (int i = 0; i < listaGruposAux.length; i++) {
			if(listaGruposAux[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Me dice si el contacto ya existe en un grupo
	 * @param contactoSeleccion
	 * @param listaContactosAux
	 * @return
	 */
	private boolean existeContactoGrupo(Contacto contactoSeleccion, Contacto[] listaContactosAux) {
		boolean existe = false;
		for(Contacto contacto : listaContactosAux) {
			if(contacto != null && contacto.equals(contactoSeleccion)) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	/**
	 * Me dice si el grupo ya existe en un contacto
	 * @param grupoSeleccion
	 * @param listaGruposAux
	 * @return
	 */
	private boolean existeGrupoContacto(Grupo grupoSeleccion, Grupo[] listaGruposAux) {
		boolean existe = false;
		for(Grupo grupo : listaGruposAux) {
			if(grupo != null && grupo.equals(grupoSeleccion)) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	/**
	 * Dado un grupo y un contacto, se elimina cada uno del arreglo del otro
	 * @param contactoSeleccion
	 * @param grupoSeleccion
	 * @return
	 */
	public boolean eliminarContactoGrupo(Contacto contactoSeleccion, Grupo grupoSeleccion) {
		boolean fueEliminado = false;
		//Tengo que eliminar a cada uno de su respectiva lista
		Contacto[] listaContactosAux = grupoSeleccion.getListaContactos();
		Grupo[] listaGruposAux = contactoSeleccion.getListaGrupos();

	    for(int i = 0; i < listaContactosAux.length; i++) {
	        Contacto contacto = listaContactosAux[i];
	        if(contacto != null && contacto.equals(contactoSeleccion)) {
	            listaContactosAux[i] = null;
	            grupoSeleccion.setListaContactos(listaContactosAux);
	            fueEliminado = true;
	            break;
	        }
	    }

	    for(int i = 0; i < listaGruposAux.length; i++) {
	        Grupo grupo = listaGruposAux[i];
	        if(grupo != null && grupo.equals(grupoSeleccion)) {
	            listaGruposAux[i] = null;
	            contactoSeleccion.setListaGrupos(listaGruposAux);
	            fueEliminado = true;
	            break;
	        }
	    }
		return fueEliminado;
	}

	/**
	 * Valida un string que este en el formato: dd/MM/yyyy
	 * @param fecha
	 * @return
	 */
	public boolean validarFecha(String fecha) {
	    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	    formatoFecha.setLenient(false);
	    try {
	        formatoFecha.parse(fecha);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}

	/**
	 * Valida un string que este en el formato: HH:mm
	 * @param hora
	 * @return
	 */
	public boolean validarHoraReunion(String hora) {
	    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
	    formatoHora.setLenient(false);
	    try {
	        formatoHora.parse(hora);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}

	/**
	 * Actualiza los atributos de la reunion
	 * @param reunionSeleccion
	 * @param descripcion
	 * @param fecha
	 * @param hora
	 */
	public void actualizarReunion(Reunion reunionSeleccion, String descripcion, String fecha, String hora) {
		Reunion reunion = obtenerReunion(reunionSeleccion);
		reunion.setDescripcion(descripcion);
		reunion.setFecha(fecha);
		reunion.setHora(hora);
	}

	/**
	 * Dado una instancia de reunion como parametro, me dice si esta se encuentra
	 * @param reunionSeleccion
	 * @return
	 */
	private Reunion obtenerReunion(Reunion reunionSeleccion) {
		Reunion reunionEcontrada = null;
		for(Reunion reunion : listaReuniones) {
			if(reunion != null && reunion.equals(reunionSeleccion)) {
				reunionEcontrada = reunion;
			}
		}
		return reunionEcontrada;
	}

	/**
	 * Crea la reunion siempre y cuando no este repetida y el arreglo tenga espacio
	 * @param descripcion
	 * @param fecha
	 * @param hora
	 * @return
	 */
	public boolean crearReunion(String descripcion, String fecha, String hora) {
		Reunion reunionNueva = new Reunion(descripcion, fecha, hora, 10, 10);
		Reunion reunionEncotrada = obtenerReunion(reunionNueva);
		int posDisponible = obtenerPosicicionDisponibleReunion();

		if(reunionEncotrada == null && posDisponible != -1) {
			listaReuniones[posDisponible] = reunionNueva;
			return true;
		}
		return false;
	}

	/**
	 * Me dice la posicion libre de la lista de reuniones
	 */
	private int obtenerPosicicionDisponibleReunion() {
		for(int i = 0; i < listaReuniones.length; i++) {
			if(listaReuniones[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Elimina una reunion de la lista de reuniones y elimina la reunion de los contactos
	 * @param reunionSeleccion
	 * @return
	 */
	public boolean eliminarReunion(Reunion reunionSeleccion) {
		boolean fueEliminada = false;
		for(int i = 0; i < listaReuniones.length; i++) {
			Reunion reunion = listaReuniones[i];
			if(reunion != null && reunion.equals(reunionSeleccion)) {
				listaReuniones[i] = null;
				fueEliminada = true;
				break;
			}
		}

		if(fueEliminada) {
			eliminarReunionContactos(reunionSeleccion); //Es para eliminar la reunión de todos los contactos
		}
		return fueEliminada;
	}

	/**
	 * Dado una reunion a eliminar, esta es eliminada de la lista de reuniones de cada contacto
	 * @param reunionSeleccion
	 */
	private void eliminarReunionContactos(Reunion reunionSeleccion) {
		for(int i = 0; i < listaContactos.length; i++) {
			Contacto contacto = listaContactos[i];
			if(contacto != null) {
				for(int j = 0; j < contacto.getListaReuniones().length; j++) {
					Reunion reunion = contacto.getListaReuniones()[j];
					if(reunion != null && reunion.equals(reunionSeleccion)) {
						contacto.getListaReuniones()[j] = null;
					}
				}
			}
		}
	}

	/**
	 * Añade un contacto a la lista de reuniones siempre y cuando se tenga el espacio en cada arreglo y no esté repetido
	 * @param contactoSeleccion
	 * @param reunionSeleccion
	 * @return
	 */
	public boolean aniadirContactoReunion(Contacto contactoSeleccion, Reunion reunionSeleccion) {
		boolean fueAgregado = false;

		Contacto[] listaContactosAux = reunionSeleccion.getListaContactos();
		int posDisponibleContacto = obtenerPosicionLibreContactoReunion(listaContactosAux);

		Reunion[] listaReunionesAux = contactoSeleccion.getListaReuniones();
		int posDisponibleReunion = obtenerPosicionLibreReunionContacto(listaReunionesAux);

		if(!existeContactoReunion(contactoSeleccion, listaContactosAux) && posDisponibleContacto != -1) {
			if(!existeReunionContacto(reunionSeleccion, listaReunionesAux) && posDisponibleReunion != -1) {
				listaContactosAux[posDisponibleContacto] = contactoSeleccion;
				reunionSeleccion.setListaContactos(listaContactosAux);
				listaReunionesAux[posDisponibleReunion] = reunionSeleccion;
				contactoSeleccion.setListaReuniones(listaReunionesAux);
				fueAgregado = true;
			}
		}
		return fueAgregado;
	}

	/**
	 * Me da la posicion libre para la lista de contactos de una reunion
	 * @param listaContactosAux
	 * @return
	 */
	private int obtenerPosicionLibreContactoReunion(Contacto[] listaContactosAux) {
		for(int i = 0; i < listaContactosAux.length; i++) {
			if(listaContactosAux[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Me da la posicion libre para la lista de reuniones en un contacto
	 * @param listaReunionesAux
	 * @return
	 */
	private int obtenerPosicionLibreReunionContacto(Reunion[] listaReunionesAux) {
		for(int i = 0; i < listaReunionesAux.length; i++) {
			if(listaReunionesAux[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Me dice si un contacto ya existe en la lista de contactos de una reunion
	 * @param contactoSeleccion
	 * @param listaContactosAux
	 * @return
	 */
	private boolean existeContactoReunion(Contacto contactoSeleccion, Contacto[] listaContactosAux) {
		boolean existe = false;
		for(Contacto contacto : listaContactosAux) {
			if(contacto != null && contacto.equals(contactoSeleccion)) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	/**
	 * Me dice si una reunion ya existe en la lista de reuniones de un contacto
	 * @param reunionSeleccion
	 * @param listaReunionesAux
	 * @return
	 */
	private boolean existeReunionContacto(Reunion reunionSeleccion, Reunion[] listaReunionesAux) {
		boolean existe = false;
		for(Reunion reunion : listaReunionesAux) {
			if(reunion != null && reunion.equals(reunionSeleccion)) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	/**
	 * Elimina los contactos de una reunion, asi como los contactos eliminan esa reunion de su lista de reuniones
	 * @param contactoSeleccion
	 * @param reunionSeleccion
	 * @return
	 */
	public boolean eliminarContactoReunion(Contacto contactoSeleccion, Reunion reunionSeleccion) {
		boolean fueEliminado = false;
		//Tengo que eliminar a cada uno de su respectiva lista
		Contacto[] listaContactosAux = reunionSeleccion.getListaContactos();
		Reunion[] listaReunionesAux = contactoSeleccion.getListaReuniones();

	    for(int i = 0; i < listaContactosAux.length; i++) {
	        Contacto contacto = listaContactosAux[i];
	        if(contacto != null && contacto.equals(contactoSeleccion)) {
	            listaContactosAux[i] = null;
	            reunionSeleccion.setListaContactos(listaContactosAux);
	            fueEliminado = true;
	            break;
	        }
	    }

	    for(int i = 0; i < listaReunionesAux.length; i++) {
	        Reunion reunion = listaReunionesAux[i];
	        if(reunion != null && reunion.equals(reunionSeleccion)) {
	            listaReunionesAux[i] = null;
	            contactoSeleccion.setListaReuniones(listaReunionesAux);
	            fueEliminado = true;
	            break;
	        }
	    }
		return fueEliminado;
	}

	/**
	 * Me muestra los contactos que tiene una reunion
	 * @param reunionSeleccion
	 * @return
	 */
	public String mostrarContactosReunion(Reunion reunionSeleccion) {
		String contactosReunion = "";
		for(Contacto contacto : reunionSeleccion.getListaContactos()) {
			if(contacto != null) {
				contactosReunion = contactosReunion + contacto.getNombre() + " : " + contacto.getTelefono() + "\n";
			}
		}
		return contactosReunion;
	}

	/**
	 * Actualiza los atri
	 * @param codigoNota
	 * @param fechaNota
	 * @param comentariosNota
	 * @param categoriaNota
	 */
	public void actualizarNota(Nota notaSeleccion, String codigoNota, String fechaNota, String comentariosNota,
			CategoriaNota categoriaNota) {
		Nota nota = obtenerNota(notaSeleccion);
		nota.setFecha(fechaNota);
		nota.setComentarios(comentariosNota);
		nota.setCategoriaNota(categoriaNota);
	}

	/**
	 * Me obtiene la nota que sea igual a la nota seleccion
	 * @param notaSeleccion
	 * @return
	 */
	private Nota obtenerNota(Nota notaSeleccion) {
		Nota notaEncontrada = null;
		for(Nota nota : listaNotas) {
			if(nota != null && nota.equals(notaSeleccion)) {
				notaEncontrada = nota;
			}
		}
		return notaEncontrada;
	}

	/**
	 * Crea una nota y la guarda en la lista de notas siempre y cuando el codigo no este repetido
	 * @param codigoNota
	 * @param fechaNota
	 * @param comentariosNota
	 * @param categoriaNota
	 * @return
	 */
	public boolean crearNota(String codigoNota, String fechaNota, String comentariosNota, CategoriaNota categoriaNota) {
		Nota nuevaNota = new Nota(codigoNota, fechaNota, comentariosNota, categoriaNota);
		Nota notaEncontrada = obtenerNota(nuevaNota);
		int posDisponible = obtenerPosicionDisponibleNota();
		if(notaEncontrada == null && posDisponible != -1) {
			listaNotas[posDisponible] = nuevaNota;
			return true;
		}
		return false;
	}

	/**
	 * Me dice la posicion libre en la lista de notas
	 * @return
	 */
	private int obtenerPosicionDisponibleNota() {
		for(int i = 0; i < listaNotas.length; i++) {
			if(listaNotas[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Elimina una nota de la lista de notas, ademas se elimina de las listaNotas de una reunion
	 * @param notaSeleccion
	 * @return
	 */
	public boolean eliminarNota(Nota notaSeleccion) {
		boolean fueEliminada = false;
		for(int i = 0; i < listaNotas.length; i++) {
			Nota nota = listaNotas[i];
			if(nota != null && nota.equals(notaSeleccion)) {
				listaNotas[i] = null;
				fueEliminada = true;
			}
		}
		//Elimino la nota de todas las reuniones
		if(fueEliminada) {
			eliminarNotaReunion(notaSeleccion);
		}
		return fueEliminada;
	}

	/**
	 * Dado una nota, la elimina de las reuniones que tengan esta nota
	 * @param notaSeleccion
	 */
	private void eliminarNotaReunion(Nota notaSeleccion) {
		for(int i = 0; i < listaReuniones.length; i++) {
			Reunion reunion = listaReuniones[i];
			if(reunion != null) {
				for(int j = 0; j < reunion.getListaNotas().length; j++) {
					Nota nota = reunion.getListaNotas()[j];
					if(nota != null && nota.equals(notaSeleccion)) {
						reunion.getListaNotas()[j] = null;
					}
				}
			}
		}
	}

//------------------------Puntos del preParcial--------------------------------------------------------------------------

	/**
	 * Elimina los contactos de la lista de contactos que tengan las 5 vocales
	 */
	public int eliminarContactosCon5Vocales() {
		int numContactosEliminados = 0;
		for(Contacto contacto : listaContactos) {
			if(contacto != null && contacto.tiene5vocales()) {
				boolean fueEliminado = eliminarContacto(contacto);
				if(fueEliminado) {
					numContactosEliminados += 1;
				}
			}
		}
		return numContactosEliminados;
	}

	/**
	 * Da un listado de los grupos que son de oficina y la dirección de todos sus contactos es: calle 2 numero 18-00
	 * @return
	 */
	public ArrayList<Grupo> darGruposOficionaDireccion() {
		ArrayList<Grupo> grupos = new ArrayList<>();
		for(Grupo grupo : listaGrupos) {
			if(grupo != null && grupo.getCategoria().equals(Categoria.OFICINA) && grupo.verificarDireccionContactos()) {
				grupos.add(grupo);
			}
		}
		return grupos;
	}

	/**
	 * Me da la cadena de los grupos que cumplen las condiciones
	 * @return
	 */
	public String darCadenaGruposOficinaDireccion() {
		ArrayList<Grupo> grupos = darGruposOficionaDireccion();
		return grupos.toString();
	}







}
