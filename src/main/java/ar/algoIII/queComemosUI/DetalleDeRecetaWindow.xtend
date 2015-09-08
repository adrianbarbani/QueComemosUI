package ar.algoIII.queComemosUI

import ar.algo.adriba.tp1.Comida
import ar.algo.adriba.tp1.CondicionPreexistente
import ar.algo.adriba.tp1.Cosas
import java.awt.Color
import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.arena.aop.windows.TransactionalDialog
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
import org.uqbar.arena.windows.WindowOwner

@Accessors
class DetalleDeRecetaVentana extends TransactionalDialog<DetalleDeRecetaAppModel> {
	
	java.util.List<String> comidaQueLeDisgusta = new ArrayList<String>

	new(WindowOwner owner, DetalleDeRecetaAppModel model) {
		super(owner, model)
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = "Detalle De Receta"

		new Label(mainPanel) => [
			bindValueToProperty("unaReceta.nombreDelPlato")
			foreground = new Color(0, 0, 0)
			fontSize = 14
		]

		addPanelCaloriasYDuenio(mainPanel)

		addPanelDificultadYTemporada(mainPanel)

		addPanelIngredientesYCondimentos(mainPanel)

		addPanelFavoritaYCondiciones(mainPanel)

		addPanelProcesoDePreparacion(mainPanel)

		addPanelBotonVolver(mainPanel)
	}

	//------------------------------------------------------------------------------------------------------
	//Cantidad de calorias y dueño
	def addPanelCaloriasYDuenio(Panel mainPanel) {
		val panelCaloriasYDueño = new GroupPanel(mainPanel)
		panelCaloriasYDueño.title = ("")
		panelCaloriasYDueño.layout = new HorizontalLayout
		new Label(panelCaloriasYDueño).bindValueToProperty("unaReceta.caloriasReceta")
		new Label(panelCaloriasYDueño).text = "calorias"
		new Label(panelCaloriasYDueño).bindValueToProperty("propietario")
	}

	//Dificultad de la receta y temporada
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

	//Grilla de ingredientes y lista de condimentos
	def addPanelIngredientesYCondimentos(Panel mainPanel) {
		val panelIngredientesYCondimentos = new Panel(mainPanel)
		panelIngredientesYCondimentos.layout = new HorizontalLayout

		val panelIngredientes = new Panel(panelIngredientesYCondimentos)
		new Label(panelIngredientes).text = "Ingredientes"
		grillaIngredientes(panelIngredientes)

		val panelCondimentos = new Panel(panelIngredientesYCondimentos)
		new Label(panelCondimentos).text = "Condimentos"
		listaDeCondimentos(panelCondimentos)

	}

	//Checkbox de favorita y lista de condiciones preexistentes
	def addPanelFavoritaYCondiciones(Panel mainPanel) {
		val panelFavoritaYCondiciones = new Panel(mainPanel)
		panelFavoritaYCondiciones.layout = new HorizontalLayout

		val panelFavorita = new Panel(panelFavoritaYCondiciones)
		panelFavorita.layout = new HorizontalLayout
		new Label(panelFavorita).text = "Favorita"
		var checkFavorita = new CheckBox(panelFavorita)
		checkFavorita.bindValueToProperty("favorita")

		val panelCondiciones = new Panel(panelFavoritaYCondiciones)
		new Label(panelCondiciones).text = "Condiciones Preexistentes"
		listaCondicionesPreexistentes(panelCondiciones)
	}

	//Descripcion de la preparacion de la receta
	def addPanelProcesoDePreparacion(Panel mainPanel) {
		val panelProcesoDePreparacion = new GroupPanel(mainPanel)
		panelProcesoDePreparacion.title = "Proceso de Preparación"
		new Label(panelProcesoDePreparacion) => [
			bindValueToProperty("unaReceta.explicacionDeLaPreparacion")
			background = new Color(176, 176, 176)
		]
	}

	//Boton para volver
	def addPanelBotonVolver(Panel mainPanel) {
		val panelBotonVolver = new Panel(mainPanel)
		new Button(panelBotonVolver) => [
			onClick [ |this.accept ]
			caption = "Volver"
		]

		//new Label(panelBotonVolver).bindValueToProperty("unUsuario.cantidadDeFavorita")
	}

	//Lista de condiciones preexistentes
	def listaCondicionesPreexistentes(Panel panelCondiciones) {
		new Panel(panelCondiciones) => [layout = new HorizontalLayout
			new List(it) => [
				var propiedadCondiciones = bindItemsToProperty("unaReceta.paraQueCondicionesSoyInadecuada")
				propiedadCondiciones.adapter = new PropertyAdapter(typeof(CondicionPreexistente), "nombre") //No lo tenemos en una propiedad si no en un metodo
				width = 100
				height = 120
			]]
	}

	//Lista de condimentos	
	def listaDeCondimentos(Panel panelCondimentos) {
		new Panel(panelCondimentos) => [layout = new HorizontalLayout
			new List(it) => [
				var propiedadCondimentos = bindItemsToProperty("unaReceta.condimentos") // Los condimentos junto con las subrecetas y las comidas las tenemos todas juntas en esta col.Receta.
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
			bindItemsToProperty("unaReceta.ingredientes")
		]

		new Column<Comida>(gridIngredientes) => [
			title = "Dosis"
			bindContentsToProperty("cantidad")
		]

		new Column<Comida>(gridIngredientes) => [
			title = "Ingrediente"
			bindContentsToProperty("nombre")
		]

	}

}
