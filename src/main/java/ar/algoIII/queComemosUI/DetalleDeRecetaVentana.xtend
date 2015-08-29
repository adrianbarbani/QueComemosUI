package ar.algoIII.queComemosUI

import ar.algo.adriba.tp1.Comida
import ar.algo.adriba.tp1.CondicionPreexistente
import ar.algo.adriba.tp1.Cosas
import ar.algo.adriba.tp1.Fecha
import ar.algo.adriba.tp1.Publica
import ar.algo.adriba.tp1.Receta
import ar.algo.adriba.tp1.RecetaBuilder
import ar.algo.adriba.tp1.Rutina
import ar.algo.adriba.tp1.Sexo
import ar.algo.adriba.tp1.UsuarioBuilder
import java.awt.Color
import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.GroupPanel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.MainWindow

@Accessors
class DetalleDeRecetaVentana extends MainWindow<RecetaWindow> {
	RecetaWindow pizza
	java.util.List<String> comidaQueLeDisgusta = new ArrayList<String>

	Receta pizzita
	static Sexo Femenino = Sexo.FEMENINO
	static Fecha fechaValida = new Fecha(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
	static Comida prepizza = new Comida(0, "Prepizza", 1)
	static Comida queso = new Comida(0, "Muzzarella", 200)
	static Comida salsaDeTomate = new Comida(0, "Salsa de tomate", 200)
	static Comida jamon = new Comida(0, "Jamon", 100)
	static Comida oregano = new Comida(100, "Oregano", 0)
	static Comida azucar = new Comida(0, "azucar", 200)

	new() {
		super(

			new RecetaWindow(
				( new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Pizza de Jamon y Morrones").
					agregarIngrediente(prepizza).agregarIngrediente(azucar).agregarIngrediente(jamon).
					agregarIngrediente(queso).agregarIngrediente(salsaDeTomate).agregarIngrediente(oregano).
					setearCalorias(500).setearDificultad("Facil").setearTemporadas("Todo el año").
					setearPreparacion(
						"En la prepizza volcar la salsa de tomate y cocinar por 15 minutos, luego sumar el queso y volver a cocinar. Agregar el jamon y el morron; oregano a gusto.").
					build), (new UsuarioBuilder().agregarPeso(52).agregarAltura(1.64).agregarSexo(Femenino).
			agregarNombre("Esteban").agregarFechaNacimiento(fechaValida).agregarRutina(new Rutina(61, true)).
			build())))

		this.pizza = this.modelObject
	}

	def static main(String[] args) {
		new DetalleDeRecetaVentana().startApplication
	}

	override createContents(Panel mainPanel) { 
		this.title = "Detalle De Receta"

		new Label(mainPanel) => [
			bindValueToProperty("unaReceta.nombreDelPlato") 
			foreground = new Color(0, 0, 0)
			fontSize = 14
		]

		//------------------------------------------------------------------------

		addPanelCalorias(mainPanel)
		
		//Falta ver el tema del dueño (en este mismo panel)
		//------------------------------------------------------------------------
		addPanelDificultadYTemporada(mainPanel) 

		//------------------------------------------------------------------------
		val panelIngredientesYCondimentos = new Panel(mainPanel) 
		panelIngredientesYCondimentos.layout = new HorizontalLayout
		val panelIngredientes = new Panel(panelIngredientesYCondimentos)
		val panelCondimentos = new Panel(panelIngredientesYCondimentos)

		new Label(panelIngredientes).text = "Ingredientes"
		grillaIngredientes(panelIngredientes)

		new Label(panelCondimentos).text = "Condimentos"
		listaDeCondimentos(panelCondimentos)

		//------------------------------------------------------------------------
		val panelFavoritaYCondiciones = new Panel(mainPanel) 
		panelFavoritaYCondiciones.layout = new HorizontalLayout
		val panelFavorita = new Panel(panelFavoritaYCondiciones)
		panelFavorita.layout = new HorizontalLayout 
		val panelCondiciones = new Panel(panelFavoritaYCondiciones)

		new Label(panelFavorita).text = "Favorita"

		//*************
		var checkFavorita = new CheckBox(panelFavorita)
		checkFavorita.bindValueToProperty("favorita")
		
		//*************
		
		new Label(panelCondiciones).text = "Condiciones Preexistentes"
		listaCondicionesPreexistentes(panelCondiciones)

		//------------------------------------------------------------------------
		val panelProcesoDePreparacion = new GroupPanel(mainPanel) //Repito el proceso de antes
		panelProcesoDePreparacion.title = "Proceso de Preparación"
		new Label(panelProcesoDePreparacion) => [
			bindValueToProperty("unaReceta.explicacionDeLaPreparacion") //Receta.
			background = new Color(176, 176, 176)
		]

		//------------------------------------------------------------------------
		val panelBotonVolver = new Panel(mainPanel)
		new Button(panelBotonVolver) => [
			//onClick [ | ] aca hay que ver que hace cuando lo tocamos
			caption = "Volver"
		]
		
		new Label (panelBotonVolver).bindValueToProperty("unUsuario.cantidadDeFavorita") 
	}
	
	def addPanelDificultadYTemporada(Panel mainPanel) {
		val panelDificultadYTemporada = new Panel(mainPanel) //Hago un panel grande que sea horizontal
		panelDificultadYTemporada.layout = new HorizontalLayout
		
		val panelDificultad = new Panel(panelDificultadYTemporada) //Ese mismo panel lo divido en dos verticales
		new Label(panelDificultad).text = "Dificultad"
		new Label(panelDificultad).bindValueToProperty("unaReceta.dificultad")
		
		val panelTemporada = new Panel(panelDificultadYTemporada)
		new Label(panelTemporada).text = "Temporada"
		new Label(panelTemporada).bindValueToProperty("unaReceta.temporada")
	}
	
	def addPanelCalorias(Panel mainPanel) {
		val panelCaloriasYDueño = new GroupPanel(mainPanel) //Panel que tiene una sola linea
		panelCaloriasYDueño.title = ("")		
		panelCaloriasYDueño.layout = new HorizontalLayout
		new Label(panelCaloriasYDueño).bindValueToProperty("unaReceta.caloriasReceta") 
		new Label(panelCaloriasYDueño).text = "calorias"
		new Label(panelCaloriasYDueño).bindValueToProperty("propietario")
	}

	//Lista de condiciones preexistentes
	def listaCondicionesPreexistentes(Panel panelCondiciones) {
		new Panel(panelCondiciones) => [layout = new HorizontalLayout
			new List(it) => [
				var propiedadCondiciones = bindItemsToProperty("unaReceta.paraQueCondicionesSoyInadecuada") //Receta.
				propiedadCondiciones.adapter = new PropertyAdapter(typeof(CondicionPreexistente), "nombre") //no lo tengo en una propiedad lo tengo en un metodo
				width = 100
				height = 120
			]]
	}

	//Lista de condimentos	
	def listaDeCondimentos(Panel panelCondimentos) {
		new Panel(panelCondimentos) => [layout = new HorizontalLayout
			new List(it) => [
				var propiedadCondimentos = bindItemsToProperty("unaReceta.condimentos") // los condimentos junto con las subrecetas y las comidas las tenemos todas juntas en esta col.Receta.
				propiedadCondimentos.adapter = new PropertyAdapter(typeof(Cosas), "nombre")
				width = 100
				height = 200
			]]
	}

	//Grilla de ingredientes
	def grillaIngredientes(Panel panel) {
		val gridIngredientes = new Table(panel, typeof(Comida)) => [
			width = 1000
			height = 8000
			bindItemsToProperty("unaReceta.ingredientes") //.ingredientes
		]

		new Column<Comida>(gridIngredientes) => [
			title = "Dosis"
			bindContentsToProperty("cantidad") //Receta.
		]

		new Column<Comida>(gridIngredientes) => [
			title = "Ingrediente"
			bindContentsToProperty("nombre") //Receta.
		]

	}

}
