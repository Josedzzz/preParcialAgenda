package co.uniquindio.pr2.agenda.application;


import co.uniquindio.pr2.agenda.controllers.GestionAgendaController;
import co.uniquindio.pr2.agenda.model.Agenda;
import co.uniquindio.pr2.agenda.model.Categoria;
import co.uniquindio.pr2.agenda.model.CategoriaNota;
import co.uniquindio.pr2.agenda.model.Contacto;
import co.uniquindio.pr2.agenda.model.Grupo;
import co.uniquindio.pr2.agenda.model.Nota;
import co.uniquindio.pr2.agenda.model.Reunion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	private Stage primaryStage;
	private Agenda agenda;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.agenda = new Agenda("Uq", 20, 20, 20, 20);
		mostrarVentanaPrincipal();
	}

	private void mostrarVentanaPrincipal() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/pr2/agenda/views/GestionAgendaView.fxml"));
			AnchorPane anchorPane = (AnchorPane)loader.load();
			GestionAgendaController gestionAgendaController = loader.getController();
			gestionAgendaController.setAplicacion(this);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

//-----------------------------------------------------------------------------------------------------------------------
	/**
	 * Actualiza la info del contacto menos el nombre y el telefono
	 * @param nombre
	 * @param alias
	 * @param direccion
	 * @param telefono
	 * @param email
	 */
	public void actualizarContacto(String nombre, String alias, String direccion, String telefono, String email) {
		agenda.actualizarContacto(nombre, alias, direccion, telefono, email);
	}

	/**
	 * Me dice si se pudo crear el contacto con sus respectivos atributos
	 * @param nombre
	 * @param alias
	 * @param direccion
	 * @param telefono
	 * @param email
	 * @return
	 */
	public boolean crearContacto(String nombre, String alias, String direccion, String telefono, String email) {
		boolean fueCreado = agenda.aniadirContacto(nombre, alias, direccion, telefono, email);
		return fueCreado;
	}

	/**
	 * Me dice si pudo eliminar el contacto pasado como parametro
	 * @param contactoSeleccion
	 * @return
	 */
	public boolean eliminarContacto(Contacto contactoSeleccion) {
		boolean eliminarContacto = agenda.eliminarContacto(contactoSeleccion);
		return eliminarContacto;
	}

	/**
	 * Me da una cadena de los grupos de un contacto
	 * @param contactoSeleccion
	 * @return
	 */
	public String darListadoGruposContacto(Contacto contactoSeleccion) {
		String gruposListados = agenda.darListadoGruposContacto(contactoSeleccion);
		return gruposListados;
	}

	/**
	 * Me da una cadena de las reuniones de un contacto
	 * @param contactoSeleccion
	 * @return
	 */
	public String darListadoReunionesContacto(Contacto contactoSeleccion) {
		String reunionesListadas = agenda.darListadoReunionesContacto(contactoSeleccion);
		return reunionesListadas;
	}

	/**
	 * Me da el telefono de un contacto dado su nombre
	 * @param nombreContacto
	 * @return
	 */
	public String darTelefonoContacto(String nombreContacto) {
		String telefonoContacto = agenda.darTelefonoContacto(nombreContacto);
		return telefonoContacto;
	}

	/**
	 * Valor de los espacios disponible para contactos en la agenda
	 * @return
	 */
	public int espaciosDisponiblesContactos() {
		int espaciosDisponibles = agenda.espaciosDisponiblesContactos();
		return espaciosDisponibles;
	}

	/**
	 * Me lista los contactos de la agenda en una cadena
	 * @return
	 */
	public String listarContactos() {
		String contactosListados = agenda.listarContactos();
		return contactosListados;
	}

	/**
	 * Retorn auna cadena de los contactos que hay en un grupo
	 * @param grupoSeleccion
	 * @return
	 */
	public String mostrarContactosGrupo(Grupo grupoSeleccion) {
		String contactosGrupo = agenda.mostrarContactosGrupo(grupoSeleccion);
		return contactosGrupo;
	}

	/**
	 * Actualiza la cateogria de un grupo
	 * @param nombreGrupo
	 * @param categoriaGrupo
	 */
	public void actualizarGrupo(String nombreGrupo, Categoria categoriaGrupo) {
		agenda.actualizarGrupo(nombreGrupo, categoriaGrupo);
	}

	/**
	 * Crea un grupo con sus recpectivos atributos
	 * @param nombreGrupo
	 * @param categoriaGrupo
	 * @return
	 */
	public boolean crearGrupo(String nombreGrupo, Categoria categoriaGrupo) {
		boolean fueCreado = agenda.aniadirGrupo(nombreGrupo, categoriaGrupo);
		return fueCreado;
	}

	/**
	 * true si se pudo eliminar el grupo
	 * @param grupoSeleccion
	 * @return
	 */
	public boolean eliminarGrupo(Grupo grupoSeleccion) {
		boolean eliminarGrupo = agenda.eliminarGrupo(grupoSeleccion);
		return eliminarGrupo;
	}

	/**
	 * true si se pudo añadir el contacto a un grupo
	 * @param contactoSeleccion
	 * @param grupoSeleccion
	 * @return
	 */
	public boolean aniadirContactoGrupo(Contacto contactoSeleccion, Grupo grupoSeleccion) {
		boolean fueAgregado = agenda.aniadirContactoGrupo(contactoSeleccion, grupoSeleccion);
		return fueAgregado;
	}

	/**
	 * true si se pudo eliminar el contacto de un grupo
	 * @param contactoSeleccion
	 * @param grupoSeleccion
	 * @return
	 */
	public boolean eliminarContactoGrupo(Contacto contactoSeleccion, Grupo grupoSeleccion) {
		boolean fueEliminado = agenda.eliminarContactoGrupo(contactoSeleccion, grupoSeleccion);
		return fueEliminado;
	}

	/**
	 * true si la fecha cumple con el formato
	 * @param fecha
	 * @return
	 */
	public boolean validarFecha(String fecha) {
		boolean esValida = agenda.validarFecha(fecha);
		return esValida;
	}

	/**
	 * true si la hora cumple con el formato
	 * @param hora
	 * @return
	 */
	public boolean validarHoraReunion(String hora) {
		boolean esValida = agenda.validarHoraReunion(hora);
		return esValida;
	}

	/**
	 * Actualiza los datos de la reunion
	 * @param reunionSeleccion
	 * @param descripcion
	 * @param fecha
	 * @param hora
	 */
	public void actualizarReunion(Reunion reunionSeleccion, String descripcion, String fecha, String hora) {
		agenda.actualizarReunion(reunionSeleccion, descripcion, fecha, hora);
	}

	/**
	 * true si pudo crear la reunion
	 * @param descripcion
	 * @param fecha
	 * @param hora
	 * @return
	 */
	public boolean crearReunion(String descripcion, String fecha, String hora) {
		boolean fueCreada = agenda.crearReunion(descripcion, fecha, hora);
		return fueCreada;
	}

	/**
	 * true si pudo eliminar la reunion
	 * @param reunionSeleccion
	 * @return
	 */
	public boolean eliminarReunion(Reunion reunionSeleccion) {
		boolean fueEliminada = agenda.eliminarReunion(reunionSeleccion);
		return fueEliminada;
	}

	/**
	 * true si pudo añadir un contacto a una reunion
	 * @param contactoSeleccion
	 * @param reunionSeleccion
	 * @return
	 */
	public boolean aniadirContactoReunion(Contacto contactoSeleccion, Reunion reunionSeleccion) {
		boolean fueAgregado = agenda.aniadirContactoReunion(contactoSeleccion, reunionSeleccion);
		return fueAgregado;
	}

	/**
	 * true si pudo eliminar un contacto de una reunion
	 * @param contactoSeleccion
	 * @param reunionSeleccion
	 * @return
	 */
	public boolean eliminarContactoReunion(Contacto contactoSeleccion, Reunion reunionSeleccion) {
		boolean fueEliminado = agenda.eliminarContactoReunion(contactoSeleccion, reunionSeleccion);
		return fueEliminado;
	}

	/**
	 * Cadena de los contactos que hay en una reunion
	 * @param reunionSeleccion
	 * @return
	 */
	public String mostrarContactosReunion(Reunion reunionSeleccion) {
		String contactosReunion = agenda.mostrarContactosReunion(reunionSeleccion);
		return contactosReunion;
	}

	/**
	 * Actualiza los datos de una nota
	 * @param codigoNota
	 * @param fechaNota
	 * @param comentariosNota
	 * @param categoriaNota
	 */
	public void actualizarNota(Nota notaSeleccion, String codigoNota, String fechaNota, String comentariosNota,
			CategoriaNota categoriaNota) {
		agenda.actualizarNota(notaSeleccion, codigoNota, fechaNota, comentariosNota, categoriaNota);
	}

	/**
	 * true si pudo crear la nota
	 * @param codigoNota
	 * @param fechaNota
	 * @param comentariosNota
	 * @param categoriaNota
	 * @return
	 */
	public boolean crearNota(String codigoNota, String fechaNota, String comentariosNota, CategoriaNota categoriaNota) {
		boolean fueCreada = agenda.crearNota(codigoNota, fechaNota, comentariosNota, categoriaNota);
		return fueCreada;
	}

	/**
	 *
	 * @param notaSeleccion
	 * @return
	 */
	public boolean eliminarNota(Nota notaSeleccion) {
		boolean fueEliminada = agenda.eliminarNota(notaSeleccion);
		return fueEliminada;
	}

//----------------------Puntos del preParcial---------------------------------------------------------------
	/**
	 * numero de contactos con 5 vocales
	 */
	public int eliminarContactosCon5Vocales() {
		int contactosEliminados = agenda.eliminarContactosCon5Vocales();
		return contactosEliminados;
	}

	/**
	 * Cadena de los grupos que cimplen con la condición
	 * @return
	 */
	public String darCadenaGruposOficinaDireccion() {
		String grupos = agenda.darCadenaGruposOficinaDireccion();
		return grupos;
	}


}
