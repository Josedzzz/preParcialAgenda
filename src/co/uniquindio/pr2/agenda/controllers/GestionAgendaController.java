package co.uniquindio.pr2.agenda.controllers;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import co.uniquindio.pr2.agenda.application.Aplicacion;
import co.uniquindio.pr2.agenda.model.Agenda;
import co.uniquindio.pr2.agenda.model.Categoria;
import co.uniquindio.pr2.agenda.model.CategoriaNota;
import co.uniquindio.pr2.agenda.model.Contacto;
import co.uniquindio.pr2.agenda.model.Grupo;
import co.uniquindio.pr2.agenda.model.Nota;
import co.uniquindio.pr2.agenda.model.Reunion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionAgendaController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTelefonoContacto;

    @FXML
    private TextField txtAliasContacto;

    @FXML
    private TextField txtDireccionContacto;

    @FXML
    private TableColumn<Contacto, String> columnAliasContacto;

    @FXML
    private TableColumn<Contacto, String> columnEmailContacto;

    @FXML
    private Button btnEliminarContacto;

    @FXML
    private TextField txtEmailContacto;

    @FXML
    private Button btnActualizarContacto;

    @FXML
    private Button btnAgregarContacto;

    @FXML
    private TableColumn<Contacto, String> columnTelefonoContacto;

    @FXML
    private TableColumn<Contacto, String> columnDireccionContacto;

    @FXML
    private TableColumn<Contacto, String> columnNombreContacto;

    @FXML
    private Button btnListarContactos;

    @FXML
    private Button btnBuscaarContacto;

    @FXML
    private TextField txtNombreContacto;

    @FXML
    private TextField txtBuscarContacto;

    @FXML
    private Button btnNuevoContacto;

    @FXML
    private TableView<Contacto> tableViewContactos;

    @FXML
    private Button btnEspaciosEnContactos;

    @FXML
    private TextField txtNombreGrupo;

    @FXML
    private Button btnEliminarGrupo;

    @FXML
    private Button btnListadoReunionesContacto;

    @FXML
    private Button btnAgregarGrupo;

    @FXML
    private TableView<Grupo> tableViewGrupos;

    @FXML
    private TableColumn<Grupo, Categoria> columnCategoriaGrupo;

    @FXML
    private TableColumn<Grupo, String> columnNombreGrupo;

    @FXML
    private ComboBox<Categoria> comboBoxCategoriaGrupo;

    @FXML
    private Button btnContactosGrupo;

    @FXML
    private Button btnNuevoGrupo;

    @FXML
    private Button btnActualizarGrupo;

    @FXML
    private Button btnAniadirContactoGrupo;

    @FXML
    private Button btnEliminarContactoGrupo;

    @FXML
    private Button btnListadoGruposContacto;

    @FXML
    private Button btnNuevaReunion;

    @FXML
    private TextField txtHoraReunion;

    @FXML
    private Button btnAgregarReunion;

    @FXML
    private TableColumn<Reunion, String> columnFechaReunion;

    @FXML
    private TableColumn<Reunion, String> columnHoraReunion;

    @FXML
    private TableColumn<Reunion, String> columnDescripcionReunion;

    @FXML
    private TextField txtDescripcionReunion;

    @FXML
    private TableView<Reunion> tableViewReuniones;

    @FXML
    private TextField txtFechaReunion;

    @FXML
    private Button btnActualizarReunion;

    @FXML
    private Button btnContactosReunion;

    @FXML
    private Button btnAniadirContactoReunion;

    @FXML
    private Button btnEliminarContactoReunion;

    @FXML
    private Button btnEliminarReunion;

    @FXML
    private Button btnNotaReunion;

    @FXML
    private Button btnEliminarReunionNota;

    @FXML
    private Button btnEliminarNota;

    @FXML
    private Button btnNuevaNota;

    @FXML
    private Button btnAniadirReunionNota;

    @FXML
    private TextField txtCodigoNota;

    @FXML
    private Button btnActualizarNota;

    @FXML
    private TextField txtComentariosNota;

    @FXML
    private Button btnAgregarNota;

    @FXML
    private TextField txtFechaNota;

    @FXML
    private TableView<Nota> tableViewNotas;

    @FXML
    private TableColumn<Nota, String> columnCodigoNota;

    @FXML
    private TableColumn<Nota, String> columnFechaNota;

    @FXML
    private TableColumn<Nota, CategoriaNota> columnCategoriaNota;

    @FXML
    private TableColumn<Nota, String> columnComentariosNota;

    @FXML
    private ComboBox<CategoriaNota> comboBoxCategoriaNota;

    @FXML
    private Button btnEliminarContactos5Vocales;

    @FXML
    private Button btnGruposOficinaDireccion;

    @FXML
    private Button btnMatrizReuniones;

    //Creo la aplicacion
	private Aplicacion aplicacion;

	//Creo la agenda
	private Agenda agenda;

	//Creo el listado de contactos que se van a ver
	ObservableList<Contacto> listadoContactos = FXCollections.observableArrayList();

	//Creo el contacto que el usuario puede seleccionar
	private Contacto contactoSeleccion;

	//Creo el listado de grupos que se van a ver
	ObservableList<Grupo> listadoGrupos = FXCollections.observableArrayList();

	//Creo el grupo que el usuario puede seleccionar
	private Grupo grupoSeleccion;

	//Creo el listado de reuniones que se van a ver
	ObservableList<Reunion> listadoReuniones = FXCollections.observableArrayList();

	//Creo la reunion que el usuario puede seleccionar
	private Reunion reunionSeleccion;

	//Creo el listado de notas que se van a ver
	ObservableList<Nota> listadoNotas = FXCollections.observableArrayList();

	//Creo la nota que el usuario puede selccionar
	private Nota notaSeleccion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Datos en la table view de contactos
		this.columnNombreContacto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnAliasContacto.setCellValueFactory(new PropertyValueFactory<>("alias"));
		this.columnDireccionContacto.setCellValueFactory(new PropertyValueFactory<>("direccion"));
		this.columnTelefonoContacto.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		this.columnEmailContacto.setCellValueFactory(new PropertyValueFactory<>("email"));
		//Para poder seleccionar los documentos de una tabla
		tableViewContactos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if(newSelection != null) {
				contactoSeleccion = newSelection;
				mostrarInformacionContacto();
			}
		});

		//Datos en la table view de grupos
		this.columnNombreGrupo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnCategoriaGrupo.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		//Para poder seleccionar los grupos en una tabla
		tableViewGrupos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if(newSelection != null) {
				grupoSeleccion = newSelection;
				mostrarInformacionGrupo();
			}
		});

		//Datos en la tableWiew de reuniones
		this.columnDescripcionReunion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		this.columnFechaReunion.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		this.columnHoraReunion.setCellValueFactory(new PropertyValueFactory<>("hora"));
		//Para poder seleccionar las reuniones en una tabla
		tableViewReuniones.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if(newSelection != null) {
				reunionSeleccion = newSelection;
				mostrarInfromacionReunion();
			}
		});

		//Datos en la tableView de notas
		this.columnCodigoNota.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.columnFechaNota.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		this.columnComentariosNota.setCellValueFactory(new PropertyValueFactory<>("comentarios"));
		this.columnCategoriaNota.setCellValueFactory(new PropertyValueFactory<>("categoriaNota"));
		//Para poder seleccionar las notas en una tabla
		tableViewNotas.getSelectionModel().selectedItemProperty().addListener((ons, oldSelection, newSelection) -> {
			if(newSelection != null) {
				notaSeleccion = newSelection;
				mostrarInformacionNota();
			}
		});

		//Datos del comboBox de grupos
		this.comboBoxCategoriaGrupo.getItems().addAll(Categoria.values());
		//Datos del comboBox de notas
		this.comboBoxCategoriaNota.getItems().addAll(CategoriaNota.values());
	}


	/**
	 * Set de la apliacion con los respectivos datos en los tableviews
	 * @param aplicacion
	 */
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		this.agenda = aplicacion.getAgenda();
		//Lista que se va a mostrar en contactos
		tableViewContactos.getItems().clear();
		tableViewContactos.setItems(getContactos());
		//Lista que se va a mostrar en grupos
		tableViewGrupos.getItems().clear();
		tableViewGrupos.setItems(getGrupos());
		//Lista que se va a mostrar en reuniones:
		tableViewReuniones.getItems().clear();
		tableViewReuniones.setItems(getReuniones());
		//Lista que se va a mostrar en notas:
		tableViewNotas.getItems().clear();
		tableViewNotas.setItems(getNotas());
	}

	/**
	 * Para actualizar la tabla de contactos
	 * @return
	 */
	private ObservableList<Contacto> getContactos() {
		listadoContactos.addAll(agenda.getListaContactos());
		return listadoContactos;
	}

	/**
	 * Para actualizar la tabla de grupos
	 * @return
	 */
	private ObservableList<Grupo> getGrupos() {
		listadoGrupos.addAll(agenda.getListaGrupos());
		return listadoGrupos;
	}

	/**
	 * Para actualizar la tabla de reuniones
	 * @return
	 */
	private ObservableList<Reunion> getReuniones() {
		listadoReuniones.addAll(agenda.getListaReuniones());
		return listadoReuniones;
	}

	/**
	 * Para actualizar la tabla de notas
	 * @return
	 */
	private ObservableList<Nota> getNotas() {
		listadoNotas.addAll(agenda.getListaNotas());
		return listadoNotas;
	}

	/**
	 * Muestra en los texfield la informacion del contacto seleccionado
	 */
	private void mostrarInformacionContacto() {
		if(contactoSeleccion != null) {
			txtNombreContacto.setText(contactoSeleccion.getNombre());
			txtAliasContacto.setText(contactoSeleccion.getAlias());
			txtDireccionContacto.setText(contactoSeleccion.getDireccion());
			txtTelefonoContacto.setText(contactoSeleccion.getTelefono());
			txtEmailContacto.setText(contactoSeleccion.getEmail());
			//Deshabilito los textFields necesarios
			txtNombreContacto.setDisable(true);
			txtTelefonoContacto.setDisable(true);
		}
	}

	/**
	 * Le setea en los texfields info sobre lo que el usuario debe poner
	 * @param event
	 */
    @FXML
    void nuevoContacto(ActionEvent event) {
		txtNombreContacto.setText("Ingrese el nombre del contacto");
		txtAliasContacto.setText("Ingrese el alias del contacto");
		txtDireccionContacto.setText("Ingrese la dirección del contacto");
		txtTelefonoContacto.setText("Ingrese el teléfono del contacto");
		txtEmailContacto.setText("Ingrese el email del contacto");
		//Deshabilito los textFields necesarios
		txtNombreContacto.setDisable(false);
		txtTelefonoContacto.setDisable(false);
    }

    /**
     * Si se selcciona un contacto se toman los datos de los textfields para actualizarlo
     * @param event
     */
    @FXML
    void actualizarContacto(ActionEvent event) {
    	String nombre = txtNombreContacto.getText();
    	String alias = txtAliasContacto.getText();
    	String direccion = txtDireccionContacto.getText();
    	String telefono = txtTelefonoContacto.getText();
    	String email = txtEmailContacto.getText();
    	if(contactoSeleccion != null) {
    		if(datosValidosContacto(nombre, alias, direccion, telefono, email)) {
    			aplicacion.actualizarContacto(nombre, alias, direccion, telefono, email);
    			//Actualizo los datos de la interfaz
    			contactoSeleccion.setAlias(alias);
    			contactoSeleccion.setDireccion(direccion);
    			contactoSeleccion.setEmail(email);
    			//Actualizo los datos de la tabla
    			tableViewContactos.getItems().clear(); //Limpio la lista
    			tableViewContactos.setItems(getContactos()); //Agrego los datos a la lista
    			mostrarMensaje("Notificación contacto", "Contacto actualizado", "El contacto " + nombre +
    					" ha sido actualizado", AlertType.INFORMATION);
    		}
    	} else {
    		mostrarMensaje("Contacto selección", "Contacto seleccionado", "No se ha seleccionado ningún contacto",
    				AlertType.WARNING);
    	}
    }

    /**
     * Me verifica si los datos de un contacto son validos
     * @param nombre
     * @param alias
     * @param direccion
     * @param telefono
     * @param email
     * @return
     */
    private boolean datosValidosContacto(String nombre, String alias, String direccion, String telefono, String email) {
    	String notificacion = "";
    	if(nombre == null || nombre.equals("")) {
    		notificacion += "El nombre es invalido\n";
    	}
    	if(alias == null || alias.equals("")) {
    		notificacion += "El alias es invalido\n";
    	}
    	if(direccion == null || direccion.equals("")) {
    		notificacion += "La direccion es invalida\n";
    	}
    	if(telefono == null || telefono.equals("")) {
    		notificacion += "El teléfono es invalido\n";
    	}
    	if(email == null || email.equals("")) {
    		notificacion += "El email es invalido\n";
    	}
    	//Si no hay notificacion los datos son validos
    	if(notificacion.equals("")) {
    		return true;
    	}
    	//notifica al usuario que la info es invalida
    	mostrarMensaje("Notificación contacto", "Información del contacto invalida", notificacion, AlertType.WARNING);
    	return false;


	}

    /**
     * Añade un contacto teniendo en cuenta los textFields
     * @param event
     */
	@FXML
    void agregarContacto(ActionEvent event) {
    	String nombre = txtNombreContacto.getText();
    	String alias = txtAliasContacto.getText();
    	String direccion = txtDireccionContacto.getText();
    	String telefono = txtTelefonoContacto.getText();
    	String email = txtEmailContacto.getText();

    	if(datosValidosContacto(nombre, alias, direccion, telefono, email)) {
    		crearContacto(nombre, alias, direccion, telefono, email);
    	}
    }

	/**
	 * Crea el contacto y actualiza la table view si se pudo crear
	 * @param nombre
	 * @param alias
	 * @param direccion
	 * @param telefono
	 * @param email
	 */
    private void crearContacto(String nombre, String alias, String direccion, String telefono, String email) {
    	boolean fueCreado = aplicacion.crearContacto(nombre, alias, direccion, telefono, email);
    	if(fueCreado) {
    		//Añado el contacto a el listadoDocumentos(tableView)
    		tableViewContactos.getItems().clear();
    		tableViewContactos.setItems(getContactos());
    		mostrarMensaje("Notificación contacto", "Contacto registrado", "El contacto " + nombre +
    				" ha sido registrado", AlertType.INFORMATION);
    	} else {
    		mostrarMensaje("Notificación contacto", "Contacto no registrado", "El contacto " + nombre +
    				" no ha sido registrado", AlertType.WARNING);
    	}
	}

    /**
     * Elimina el contacto seleccionado
     * @param event
     */
	@FXML
    void eliminarContacto(ActionEvent event) {
		if(contactoSeleccion != null) {
			if(aplicacion.eliminarContacto(contactoSeleccion)) {
				//Elimina el contacto del listadoContactos
				listadoContactos.remove(contactoSeleccion);
				mostrarMensaje("Contacto eliminado", "Contacto eliminado", "Se ha eliminado correctamente",
						AlertType.INFORMATION);
			} else {
				mostrarMensaje("Contacto eliminado", "Fallo en eliminar contacto", "No ha eliminado correctamente",
						AlertType.INFORMATION);
			}
		} else {
			mostrarMensaje("Contacto Selección", "Contacto Selección", "No se ha seleccionado ningún contacto",
					AlertType.WARNING);
		}
    }

	/**
	 * Da la lista de grupos del contacto selccionado
	 * @param event
	 */
    @FXML
    void darListadoGruposContacto(ActionEvent event) {
    	if(contactoSeleccion != null) {
    		String gruposListados = aplicacion.darListadoGruposContacto(contactoSeleccion);
    		mostrarMensaje("Notificación contactos", "Notificación contactos", "Los grupos a los que pertenece "
    				+ "este contacto son: " + gruposListados, AlertType.INFORMATION);
    	} else {
    		mostrarMensaje("Contacto selección", "Contacto selección", "No se ha seleccionado ningún contacto",
    				AlertType.WARNING);
    	}
    }

    /**
     * Da la lista de reuniones del contacto seleccionado
     * @param event
     */
    @FXML
    void darListadoReunionesContacto(ActionEvent event) {
    	if(contactoSeleccion != null) {
    		String reunionesListadas = aplicacion.darListadoReunionesContacto(contactoSeleccion);
    		mostrarMensaje("Notificación contactos", "Notificación contactos", "Las reuniones a las que pertence "
    				+ "este contactos son: " + reunionesListadas, AlertType.INFORMATION);
    	} else {
       		mostrarMensaje("Contacto selección", "Contacto selección", "No se ha seleccionado ningún contacto",
    				AlertType.WARNING);
    	}
    }

    /**
     * Da el telefono de un contacto
     * @param event
     */
    @FXML
    void buscarContacto(ActionEvent event) {
    	String nombreContacto = txtBuscarContacto.getText();
    	String telefonoContacto = "";
    	if(nombreContacto == null || nombreContacto.equals("")) {
    	   	//notifica al usuario que la info es invalida
        	mostrarMensaje("Notificación contacto", "Información del contacto invalida",
        			"Ingrese el nombre del contacto", AlertType.WARNING);
    	} else {
    		telefonoContacto = aplicacion.darTelefonoContacto(nombreContacto);
    		if(!telefonoContacto.equals("")) {
    			mostrarMensaje("Notificación contacto", "El teléfono del contacto es: ",
    					telefonoContacto, AlertType.INFORMATION);
    		} else {
    			mostrarMensaje("Notificación contacto", "Información del contacto invalida",
            			"No se ha encontrado ningún contacto con ese nombre", AlertType.WARNING);
    		}
    	}
    }

    /**
     * Cuantos espacios de contactos hay disponibles
     * @param event
     */
    @FXML
    void espaciosEnContactos(ActionEvent event) {
    	int espaciosDisponibles = aplicacion.espaciosDisponiblesContactos();
    	mostrarMensaje("Notificación agenda", "Espacios de contactos", "Hay " + espaciosDisponibles +
    			" para contactos", AlertType.INFORMATION);
    }

    /**
     * lista todos los contactos de la agenda
     * @param event
     */
    @FXML
    void listarContactos(ActionEvent event) {
    	String contactosListados = aplicacion.listarContactos();
    	mostrarMensaje("Notificación agenda", "Contactos en agenda: ", contactosListados, AlertType.INFORMATION);
    }


    /**
     * Muestra un mensaje dependiendo con el tipo de alerta seleccionado
     * @param title
     * @param header
     * @param content
     * @param alertType
     */
    public void mostrarMensaje(String title, String header, String content, AlertType alertType) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
    }


    /**
     * Muestra los contactos de un grupo
     * @param event
     */
    @FXML
    void mostrarContactosGrupo(ActionEvent event) {
    	if(grupoSeleccion != null) {
    		String contactosGrupo = aplicacion.mostrarContactosGrupo(grupoSeleccion);
    		mostrarMensaje("Notificación grupos", "Contactos en el grupo " + grupoSeleccion.getNombre() + ": ",
    				contactosGrupo, AlertType.INFORMATION);
    	} else {
    		mostrarMensaje("Grupo selección", "Grupo selección", "No se ha selccionado ningún grupo", AlertType.WARNING);
    	}
    }

    /**
     * Me setea los txt de el grupo seleccionado
     */
	private void mostrarInformacionGrupo() {
		if(grupoSeleccion != null) {
			txtNombreGrupo.setText(grupoSeleccion.getNombre());
			comboBoxCategoriaGrupo.setValue(grupoSeleccion.getCategoria());
			//Deshabilito este textField
			txtNombreGrupo.setDisable(true);
		}
	}

	/**
	 * Setea los textfields de grupo para que el usuario sepa que meter
	 * @param event
	 */
    @FXML
    void nuevoGrupo(ActionEvent event) {
    	txtNombreGrupo.setText("Ingrese el nombre del grupo");
    	comboBoxCategoriaGrupo.setValue(Categoria.AMIGOS);
    	//Habilito este textfield
    	txtNombreGrupo.setDisable(false);
    }

    /**
     * Actualiza la categoria de un grupo
     * @param event
     */
    @FXML
    void actualizarGrupo(ActionEvent event) {
    	String nombreGrupo = txtNombreGrupo.getText();
    	Categoria categoriaGrupo = comboBoxCategoriaGrupo.getValue();
    	if(grupoSeleccion != null) {
    		aplicacion.actualizarGrupo(nombreGrupo, categoriaGrupo);
    		//Actualizo los datos de la interfaz
    		grupoSeleccion.setCategoria(categoriaGrupo);
    		//Refresh a la tabla para que se vean los cambios
    		tableViewGrupos.getItems().clear();
    		tableViewGrupos.setItems(getGrupos());
    		mostrarMensaje("Notificaión grupo", "Grupo actualizado", "El grupo " + nombreGrupo + " ha sido actualizado",
    				AlertType.INFORMATION);
    	} else {
    		mostrarMensaje("Grupo selcción", "Grupo selección", "No ha seleccionado ningún grupo", AlertType.WARNING);
    	}
    }

    /**
     * Agrega un grupo siempre y cuando la info de este sea valida
     * @param event
     */
    @FXML
    void agregarGrupo(ActionEvent event) {
    	String nombreGrupo = txtNombreGrupo.getText();
    	Categoria categoriaGrupo = comboBoxCategoriaGrupo.getValue();
    	if(validarDatosGrupo(nombreGrupo, categoriaGrupo)) {
    		crearGrupo(nombreGrupo, categoriaGrupo);
    	}
    }

    /**
     * Valida la información de un grupo
     * @param nombreGrupo
     * @param categoriaGrupo
     * @return
     */
	private boolean validarDatosGrupo(String nombreGrupo, Categoria categoriaGrupo) {
		String notificacion = "";
		if(nombreGrupo == null || nombreGrupo.equals("")) {
			notificacion += "El nombre del grupo es invalido\n";
		}
		if(categoriaGrupo == null) {
			notificacion += "La categoria del grupo es invalida\n";
		}

		if(notificacion.equals("")) {
			return true;
		}
		mostrarMensaje("Notificación grupo", "Notificación grupo", notificacion, AlertType.WARNING);
		return false;
	}

	/**
	 * Crea el grupo después de verificar que su info es valida
	 * @param nombreGrupo
	 * @param categoriaGrupo
	 */
	private void crearGrupo(String nombreGrupo, Categoria categoriaGrupo) {
		boolean fueCreado = aplicacion.crearGrupo(nombreGrupo, categoriaGrupo);
		if(fueCreado) {
			tableViewGrupos.getItems().clear(); //Limpio la lista
			tableViewGrupos.setItems(getGrupos()); //Agrego nuevos datos a la lista
			mostrarMensaje("Notificación grupo", "Grupo registrado", "El grupo " + nombreGrupo +
					" ha sido registrado", AlertType.INFORMATION);
		} else {
			mostrarMensaje("Notificación grupo", "Grupo no registrado", "El grupo " + nombreGrupo +
					" no fue registrado, ya que este nombre esta repetido", AlertType.WARNING);
		}
	}

	/**
	 * Elimina el grupo seleccionado
	 * @param event
	 */
	@FXML
    void eliminarGrupo(ActionEvent event) {
		if(grupoSeleccion != null) {
			if(aplicacion.eliminarGrupo(grupoSeleccion)) {
				mostrarMensaje("Grupo eliminado", "Grupo eliminado", "Se ha eliminado correctamente el grupo " +
						grupoSeleccion.getNombre(), AlertType.INFORMATION);
				listadoGrupos.remove(grupoSeleccion);
			}
		} else {
			mostrarMensaje("Grupo selección", "Grupo selección", "No se ha seleccionado ningun grupo", AlertType.WARNING);
		}
    }

	/**
	 * Añade un contacto seleccionado a un grupo seleccionado
	 * @param event
	 */
    @FXML
    void aniadirContactoGrupo(ActionEvent event) {
    	if(contactoSeleccion != null && grupoSeleccion != null) {
    		if(aplicacion.aniadirContactoGrupo(contactoSeleccion, grupoSeleccion)) {
    			tableViewContactos.getItems().clear();
    			tableViewContactos.setItems(getContactos());
    			tableViewGrupos.getItems().clear(); //Limpio la lista
    			tableViewGrupos.setItems(getGrupos()); //Agrego nuevos datos a la lista
    			mostrarMensaje("Notificación grupo", "Notificación grupo", "Se ha añadido el contacto " +
    					contactoSeleccion.getNombre() + " a el grupo " + grupoSeleccion.getNombre(), AlertType.INFORMATION);
    		} else {
    			mostrarMensaje("Notificación grupo", "Notificación grupo", "No se pudo añadir el contacto."
    					+ " Esto se debe a que no hay espacios disponibles o el contacto ya existe en este grupo", AlertType.WARNING);
    		}
    	} else {
    		mostrarMensaje("Notificación grupo", "Notificación grupo", "Por favor verifique que se haya seleccionado"
    				+ " el contacto y el grupo deseado", AlertType.WARNING);
    	}
    }

    /**
     * Elimina un contacto seleccionado de un grupo seleccionado
     * @param event
     */
    @FXML
    void eliminarContactoGrupo(ActionEvent event) {
    	if(contactoSeleccion != null && grupoSeleccion != null) {
    		if(aplicacion.eliminarContactoGrupo(contactoSeleccion, grupoSeleccion)) {
    			tableViewContactos.getItems().clear();
    			tableViewContactos.setItems(getContactos());
    			tableViewGrupos.getItems().clear(); //Limpio la lista
    			tableViewGrupos.setItems(getGrupos()); //Agrego nuevos datos a la lista
    			mostrarMensaje("Notificación grupo", "Notificación grupo", "Se pudo eliminar el contacto " +
    					contactoSeleccion.getNombre() + " del grupo " + grupoSeleccion.getNombre(), AlertType.INFORMATION);
    		} else {
    			mostrarMensaje("Notificación grupo", "Notificación grupo", "No se pudo eliminar el contacto " +
    					" verifique que ese contacto si perteneciera al grupo indicado", AlertType.WARNING);
    		}
    	} else {
    		mostrarMensaje("Notificación grupo", "Notificación grupo", "Por favor verifique que se haya seleccionado"
    				+ " el contacto y el grupo deseado", AlertType.WARNING);
    	}
    }

//-----------------------------------------------REUNIONES-------------------------------------------------------------
   /**
    * Setea los textFields de a cuerdo a la reunion seleccionada
    */
    private void mostrarInfromacionReunion() {
	   if(reunionSeleccion != null) {
		   txtDescripcionReunion.setText(reunionSeleccion.getDescripcion());
		   txtFechaReunion.setText(reunionSeleccion.getFecha());
		   txtHoraReunion.setText(reunionSeleccion.getHora());
		   //Deshabilito la descripcion de la reunion
		   txtDescripcionReunion.setDisable(true);
	   }
   }

    /**
     * Setea los textFields con una pista de como el usuario debe ingresar los datos
     * @param event
     */
    @FXML
    void nuevaReunion(ActionEvent event) {
    	txtDescripcionReunion.setText("Ingrese una descripción para la reunion");
    	txtFechaReunion.setText("Ingrese la fecha en el formato: dd/mm/yyyy");
    	txtHoraReunion.setText("Ingrese la hora en el formato: HH:mm");
    	//Ahibilito los txt deshabilitados
    	txtDescripcionReunion.setDisable(false);
    }

    /**
     * Actualiza los datos de una reunion
     * @param event
     */
    @FXML
    void actualizarReunion(ActionEvent event) {
    	String descripcion = txtDescripcionReunion.getText();
    	String fecha = txtFechaReunion.getText();
    	String hora = txtHoraReunion.getText();
    	if(reunionSeleccion != null) {
    		if(datosValidosReunion(descripcion, fecha, hora)) {
    			aplicacion.actualizarReunion(reunionSeleccion, descripcion, fecha, hora);
    			//Actualizo los datos de la interfaz
    			reunionSeleccion.setDescripcion(descripcion);
    			reunionSeleccion.setFecha(fecha);
    			reunionSeleccion.setHora(hora);
    			//Actualizo los datos de la tabla
    			tableViewReuniones.getItems().clear();
    			tableViewReuniones.setItems(getReuniones());
    			mostrarMensaje("Notificación reunión", "Reunión actualizada", "La reunión " + descripcion +
    					" ha sido actualizada", AlertType.INFORMATION);
    		}
    	} else {
    		mostrarMensaje("Reunión selcción", "Reunión selcción", "No se ha seleccionado ninguna reunión", AlertType.WARNING);
    	}
    }

    /**
     * Verifica que los datos ingresados esten correctos, asi como la fecha y la hora en un formato especifico
     * @param descripcion
     * @param fecha
     * @param hora
     * @return
     */
    private boolean datosValidosReunion(String descripcion, String fecha, String hora) {
    	String notificacion = "";
    	boolean fechaValida = aplicacion.validarFecha(fecha);
    	boolean horaValida = aplicacion.validarHoraReunion(hora);
    	if(descripcion == null || descripcion.equals("")) {
    		notificacion += "La descripción de la reunión es invalida\n";
    	}
    	if(!fechaValida) {
    		notificacion += "La fecha de la reunión es invalida\n";
    	}
    	if(!horaValida) {
    		notificacion += "La hora de la reunión es invalida\n";
    	}
    	//Si no hay una notificación es porque los datos son validos
    	if(notificacion.equals("")) {
    		return true;
    	}
    	//Notifico al ususario la info que es invalida
    	mostrarMensaje("Notificación reunión", "Información de reunión invalida", notificacion, AlertType.WARNING);
    	return false;
	}

    /**
     * Agrega una nueva reunion a la agenda
     * @param event
     */
	@FXML
    void agregarReunion(ActionEvent event) {
	   	String descripcion = txtDescripcionReunion.getText();
    	String fecha = txtFechaReunion.getText();
    	String hora = txtHoraReunion.getText();

    	if(datosValidosReunion(descripcion, fecha, hora)) {
    		crearReunion(descripcion, fecha, hora);
    	}
    }

	/**
	 * Crear una reunion
	 * @param descripcion
	 * @param fecha
	 * @param hora
	 */
    private void crearReunion(String descripcion, String fecha, String hora) {
    	boolean fueCreada = aplicacion.crearReunion(descripcion, fecha, hora);
    	if(fueCreada) {
    		//Añado el contenido al listado de reuniones
    		tableViewReuniones.getItems().clear();
    		tableViewReuniones.setItems(getReuniones());
    		mostrarMensaje("Notificaión reunión", "Reunión registrada", "La reunión " + descripcion +
    				" fue creada correctamente", AlertType.INFORMATION);
    	} else {
    		mostrarMensaje("NOtificación reunión", "Reunión no registrada", "La reunión " + descripcion +
    				" no se pudo registrar", AlertType.WARNING);
    	}
	}

    /**
     * Elimina una reunion seleccionada
     * @param event
     */
	@FXML
    void eliminarReunion(ActionEvent event) {
		if(reunionSeleccion != null) {
			if(aplicacion.eliminarReunion(reunionSeleccion)) {
				//Elimina la reunión del listado de reuniones
				listadoReuniones.remove(reunionSeleccion);
				mostrarMensaje("Reunión eliminada", "Reunión eliminada", "Se ha eliminado correctamente", AlertType.INFORMATION);
			} else {
				mostrarMensaje("Reunión no eliminada", "Fallo al eliminar reunión", "No se ha eliminado correctamente",
						AlertType.WARNING);
			}
		} else {
			mostrarMensaje("Reunión selección", "Reunión selección", "No se ha seleccionado ninguna reunión", AlertType.WARNING);
		}
    }

	/**
	 * Muestra los contactos de una reunion seleccionada
	 * @param event
	 */
    @FXML
    void mostratContactosReunion(ActionEvent event) {
    	if(reunionSeleccion != null) {
    		String contactosReunion = aplicacion.mostrarContactosReunion(reunionSeleccion);
    		mostrarMensaje("Notificación reunión", "Contactos en reunión " + reunionSeleccion.getDescripcion() + ": ",
    				contactosReunion, AlertType.INFORMATION);
    	} else {
     		mostrarMensaje("Reunión selección", "Reunión selección", "No se ha seleccionado ninguna reunión", AlertType.WARNING);
    	}
    }

    /**
     * Añade un contacot seleccionado a una reunion seleccionada
     * @param event
     */
    @FXML
    void aniadirContactoReunion(ActionEvent event) {
    	if(contactoSeleccion != null && reunionSeleccion != null) {
    		if(aplicacion.aniadirContactoReunion(contactoSeleccion, reunionSeleccion)) {
      			tableViewContactos.getItems().clear();
    			tableViewContactos.setItems(getContactos());
    			tableViewGrupos.getItems().clear(); //Limpio la lista
    			tableViewGrupos.setItems(getGrupos()); //Agrego nuevos datos a la lista
       			mostrarMensaje("Notificación reunión", "Notificación reunión", "Se ha añadido el contacto " +
    					contactoSeleccion.getNombre() + " a la reunión " + reunionSeleccion.getDescripcion(), AlertType.INFORMATION);
    		} else {
    			mostrarMensaje("Notificación reunión", "Notificación reunión", "No se pudo añadir el contacto."
    					+ " Esto se debe a que no hay espacios disponibles o el contacto ya existe en esta reunión", AlertType.WARNING);
    		}
    	} else {
    		mostrarMensaje("Notificación reunión", "Notificación reunión", "Por favor verifique que se haya "
    				+ "selccionado la reunión y el contacto deseado", AlertType.WARNING);
    	}
    }

    /**
     * Elimina un contacto seleccionado de una reunion seleccionada
     * @param event
     */
    @FXML
    void eliminarContactoReunion(ActionEvent event) {
    	if(contactoSeleccion != null && reunionSeleccion != null) {
    		if(aplicacion.eliminarContactoReunion(contactoSeleccion, reunionSeleccion)) {
       			tableViewContactos.getItems().clear();
    			tableViewContactos.setItems(getContactos());
    			tableViewGrupos.getItems().clear(); //Limpio la lista
    			tableViewGrupos.setItems(getGrupos()); //Agrego nuevos datos a la lista
    			mostrarMensaje("Notificación reunión", "Notificación reunión", "Se pudo eliminar el contacto " +
    					contactoSeleccion.getNombre() + " de la reunión " + reunionSeleccion.getDescripcion(), AlertType.INFORMATION);
    		} else {
    			mostrarMensaje("Notificación reunión", "Notificación reunión", "No se pudo eliminar el contacto " +
    					" verifique que ese contacto si perteneciera a la reunión indicada", AlertType.WARNING);
    		}
    	} else {
    		mostrarMensaje("Notificación reunión", "Notificación reunión", "Por favor verifique que se haya seleccionado"
    				+ " el contacto y la reunión deseada", AlertType.WARNING);
    	}
    }

//---------------------------------NOTAS-----------------------------------------------------------------------

    /**
     * Muestra la información cuando se selecciona una nota en el table view
     */
    private void mostrarInformacionNota() {
		if(notaSeleccion != null) {
			txtCodigoNota.setText(notaSeleccion.getCodigo());
			txtFechaNota.setText(notaSeleccion.getFecha());
			txtComentariosNota.setText(notaSeleccion.getComentarios());
			comboBoxCategoriaNota.setValue(notaSeleccion.getCategoriaNota());
			//Deshabilito el codigo de la nota
			txtCodigoNota.setDisable(true);
		}
	}

    /**
     * Para setear los datos en los textfields y habilitar el del codigo
     * @param event
     */
    @FXML
    void nuevaNota(ActionEvent event) {
    	txtCodigoNota.setText("Ingrese el código de la nota");
    	txtFechaNota.setText("Ingrese la fecha de lan nota");
    	txtComentariosNota.setText("Ingrese los comentarios de la nota");
    	comboBoxCategoriaNota.setValue(CategoriaNota.PUBLICA);
    	//Habilito este textfield
    	txtCodigoNota.setDisable(false);
    }

    /**
     * Actualizar todos los datos de la nota excepto el código
     * @param event
     */
    @FXML
    void actualizarNota(ActionEvent event) {
    	String codigoNota = txtCodigoNota.getText();
    	String fechaNota = txtFechaNota.getText();
    	String comentariosNota = txtComentariosNota.getText();
    	CategoriaNota categoriaNota = comboBoxCategoriaNota.getValue();
    	if(notaSeleccion != null) {
    		if(datosValidosNota(codigoNota, fechaNota, comentariosNota, categoriaNota)) {
    			aplicacion.actualizarNota(notaSeleccion, codigoNota, fechaNota, comentariosNota, categoriaNota);
    			//Actualizo los daots de la interfaz
    			notaSeleccion.setFecha(fechaNota);
    			notaSeleccion.setComentarios(comentariosNota);
    			notaSeleccion.setCategoriaNota(categoriaNota);
    			//Actualizo los datos de la tabla
    			tableViewNotas.getItems().clear();
    			tableViewNotas.setItems(getNotas());
    			mostrarMensaje("Notificación nota", "Nota actualizada", "La nota " + codigoNota
    					+ " ha sido actualizada", AlertType.INFORMATION);
    		}
    	} else {
    		mostrarMensaje("Nota selección", "Nota selección", "No se ha seleccionado ninguna nota", AlertType.WARNING);
    	}
    }

    /**
     * Verifica wue los datos ingresados esten correctos, además de la fecha en un formato especifico
     * @param codigoNota
     * @param fechaNota
     * @param comentariosNota
     * @param categoriaNota
     * @return
     */
    private boolean datosValidosNota(String codigoNota, String fechaNota, String comentariosNota,
    		CategoriaNota categoriaNota) {
    	String notificacion = "";
    	boolean fechaValida = aplicacion.validarFecha(fechaNota);
    	if(codigoNota == null || codigoNota.equals("")) {
    		 notificacion += "El código de la nota es invalido\n";
    	}
    	if(!fechaValida) {
    		notificacion += "La fecha de la nota es invalida\n";
    	}
    	if(comentariosNota == null || comentariosNota.equals("")) {
    		notificacion += "El comentario de la nota es invalido\n";
    	}
    	//Si no hay contenido en la notificación es porque los datos son validos
    	if(notificacion.equals("")) {
    		return true;
    	}
    	mostrarMensaje("Notificación nota", "Información de la nota invalida", notificacion, AlertType.WARNING);
    	return false;
	}

    /**
     * Agrega una nota siempre y cuando los datos sean correctos
     * @param event
     */
	@FXML
    void agregarNota(ActionEvent event) {
    	String codigoNota = txtCodigoNota.getText();
    	String fechaNota = txtFechaNota.getText();
    	String comentariosNota = txtComentariosNota.getText();
    	CategoriaNota categoriaNota = comboBoxCategoriaNota.getValue();

    	if(datosValidosNota(codigoNota, fechaNota, comentariosNota, categoriaNota)) {
    		crearNota(codigoNota, fechaNota, comentariosNota, categoriaNota);
    	}
    }

	/**
	 * Crear una nota
	 * @param codigoNota
	 * @param fechaNota
	 * @param comentariosNota
	 * @param categoriaNota
	 */
    private void crearNota(String codigoNota, String fechaNota, String comentariosNota, CategoriaNota categoriaNota) {
		boolean fueCreada = aplicacion.crearNota(codigoNota, fechaNota, comentariosNota, categoriaNota);
		if(fueCreada) {
			//Añado el contenido a la lista de notas
			tableViewNotas.getItems().clear();
			tableViewNotas.setItems(getNotas());
			mostrarMensaje("Notificación nota", "Nota registrada", "La nota " + codigoNota + " fue creada correctamente",
					AlertType.INFORMATION);
		} else {
			mostrarMensaje("Notificación nota", "Nota no registrada", "La nota no pudo ser registrada", AlertType.WARNING);
		}
	}

    /**
     * Elimina la nota seleccionada
     * @param event
     */
	@FXML
    void eliminarNota(ActionEvent event) {
		if(notaSeleccion != null) {
			if(aplicacion.eliminarNota(notaSeleccion)) {
				//Elimina la nota del istado de notas
				listadoNotas.remove(notaSeleccion);
				mostrarMensaje("Nota eliminada", "Nota eliminada", "Se ha eliminado correctamente", AlertType.INFORMATION );
			} else {
				mostrarMensaje("Nota eliminada", "Fallo al eliminar nota", "No se pudo eliminar la nota", AlertType.WARNING);
			}
		} else {
    		mostrarMensaje("Nota selección", "Nota selección", "No se ha seleccionado ninguna nota", AlertType.WARNING);
		}
    }

	/**
	 * Muestra las notas que hay en una reunion
	 * @param event
	 */
    @FXML
    void mostrarNotaReunion(ActionEvent event) {
    	if(reunionSeleccion != null) {
     		String notasReunion = aplicacion.mostrarNotaReunion(reunionSeleccion);
    		mostrarMensaje("Notificación reunión", "Notas en reunión " + reunionSeleccion.getDescripcion() + ": ",
    				notasReunion, AlertType.INFORMATION);
    	} else {
     		mostrarMensaje("Reunión selección", "Reunión selección", "No se ha seleccionado ninguna reunión", AlertType.WARNING);
    	}
    }

    /**
     * Añade una nota a una reunion
     * @param event
     */
    @FXML
    void aniadirReunionNota(ActionEvent event) {
    	if(notaSeleccion != null && reunionSeleccion != null) {
    		if(aplicacion.aniadirReunionNota(notaSeleccion, reunionSeleccion)) {
      			tableViewReuniones.getItems().clear();
    			tableViewReuniones.setItems(getReuniones());
    			tableViewNotas.getItems().clear(); //Limpio la lista
    			tableViewNotas.setItems(getNotas()); //Agrego nuevos datos a la lista
       			mostrarMensaje("Notificación nota", "Notificación nota", "Se ha añadido la nota " +
    					notaSeleccion.getComentarios() + " a la reunión " + reunionSeleccion.getDescripcion(), AlertType.INFORMATION);
    		} else {
    			mostrarMensaje("Notificación nota", "Notificación nota", "No se pudo añadir la nota."
    					+ " Esto se debe a que no hay espacios disponibles o la nota ya existe en esta reunión", AlertType.WARNING);
    		}
    	} else {
    		mostrarMensaje("Notificación nota", "Notificación nota", "Por favor verifique que se haya "
    				+ "selccionado la reunión y la nota deseada", AlertType.WARNING);
    	}
    }

    /**
     * Elimina una nota de una reunion
     * @param event
     */
    @FXML
    void eliminarReunionNota(ActionEvent event) {
    	if(notaSeleccion != null && reunionSeleccion != null) {
    		if(aplicacion.eliminarReunionNota(notaSeleccion, reunionSeleccion)) {
       			tableViewReuniones.getItems().clear();
    			tableViewReuniones.setItems(getReuniones());
    			tableViewNotas.getItems().clear(); //Limpio la lista
    			tableViewNotas.setItems(getNotas()); //Agrego nuevos datos a la lista
    			mostrarMensaje("Notificación nota", "Notificación nota", "Se pudo eliminar la nota " +
    					notaSeleccion.getCodigo() + " de la reunión " + reunionSeleccion.getDescripcion(), AlertType.INFORMATION);
    		} else {
    			mostrarMensaje("Notificación nota", "Notificación nota", "No se pudo eliminar la nota " +
    					" verifique que esa nota si perteneciera a la reunión indicada", AlertType.WARNING);
    		}
    	} else {
    		mostrarMensaje("Notificación nota", "Notificación nota", "Por favor verifique que se haya seleccionado"
    				+ " la nota y la reunión deseada", AlertType.WARNING);
    	}
    }

//---------------Puntos preParcial 2----------------------------------------------------------------

    /**
     * Elimina los contactos con 5 vocales
     * @param event
     */
    @FXML
    void eliminarContactosCon5Vocales(ActionEvent event) {
    	int numContactosEliminados = aplicacion.eliminarContactosCon5Vocales();
		//Actualizo la info de contactos en la tableView
		tableViewContactos.getItems().clear();
		tableViewContactos.setItems(getContactos());
    	if(numContactosEliminados > 0) {
    		mostrarMensaje("Notifiación información", "Notifiación información", "Se han eliminado "
    				+ numContactosEliminados + " contactos", AlertType.INFORMATION);
    	} else {
    		mostrarMensaje("Notifiación información", "Notifiación información", "No se encontró ningun contacto "
    				+ "para eliminar", AlertType.INFORMATION);
    	}
    }

    /**
     * Me da los grupos que son de oficina y la dirección de todos sus contactos es: calle 2 numero 18-00
     * @param event
     */
    @FXML
    void darGruposOficinaDireccion(ActionEvent event) {
    	String grupos = aplicacion.darCadenaGruposOficinaDireccion();
   		mostrarMensaje("Notifiación información", "Notifiación información", grupos, AlertType.INFORMATION);
    }

    /**
     * Me da una cadena representando la matriz de reuniones organizada en 3 filas por fechas
     * @param event
     */
    @FXML
    void darMatrizReuniones(ActionEvent event) {
    	String matriz;
		try {
			matriz = aplicacion.darCadenaMatrizReuniones();
			mostrarMensaje("Notifiación información", "Notifiación información", matriz, AlertType.INFORMATION);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }




}
