package ar.algoIII.queComemosUI

import ar.algo.adriba.tp1.Receta
import java.awt.Color
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Label
import ar.algo.adriba.tp1.Usuario

class UltimasConsultasWindow extends SimpleWindow<UltimasConsultasAppModel> {

	new(WindowOwner parent, Usuario usuario) {
		super(parent, new UltimasConsultasAppModel(usuario))
		modelObject.initSearch()
		
		title = "Bienvenido a ¿Que Comemos?"
	}
	
	def descripcionPrimaria(Panel mainPanel) {
		new Label(mainPanel).bindValueToProperty("descripcion")
	}
	
	def panelBusqueda(Panel panel) { // Template Method
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.panelBusqueda(mainPanel)
		
		descripcionPrimaria(mainPanel)
		
		val table = new Table<Receta>(mainPanel, typeof(Receta)) => [
			bindItemsToProperty("resultados")
			bindValueToProperty("recetaSeleccionada")
		]
		this.grillaDeResultados(table)
	}

	def void grillaDeResultados(Table<Receta> table) {
		new Column<Receta>(table) => [
			title = "Nombre"
			fixedSize = 200
			bindContentsToProperty("nombre")
			bindForeground("sosPublica").transformer = [Object receta|if(receta as Boolean) Color.BLUE else Color.RED]
		]

		new Column<Receta>(table) => [
			title = "Calorias"
			fixedSize = 100
			bindContentsToProperty("caloriasReceta")
		]

		new Column<Receta>(table) => [
			title = "Dificultad"
			fixedSize = 200
			bindContentsToProperty("dificultad")
		]

		new Column<Receta>(table) => [
			title = "Temporada"
			fixedSize = 200
			bindContentsToProperty("temporada")
		]
	}

	override protected addActions(Panel mainPanel) {

		val elementSelected = new NotNullObservable("recetaSeleccionada")

		val actionsPanel = new Panel(mainPanel).layout = new HorizontalLayout

		new Button(actionsPanel) => [
			caption = "Ver"
			onClick = [|this.abrirDetalle]
			bindEnabled(elementSelected)
		]

		new Button(actionsPanel) => [
			caption = "Favorita"
			onClick = [|modelObject.marcarComoFavorita]
			bindEnabled(elementSelected)
		]
		
		new Button(actionsPanel) => [
			caption = "Copìar Receta"
			onClick = [|this.abrirCopiaReceta]
			bindEnabled(elementSelected)
		]

	}

	//Acciones
	def void abrirDetalle() {
		this.openDialog(
			new DetalleDeRecetaVentana(this, new DetalleDeRecetaAppModel(modelObject.recetaSeleccionada, modelObject.usuario)))
		modelObject.agregarRecetaVista
	}
	
	def void abrirCopiaReceta(){
		this.openDialog(
			new CopiarRecetaWindow(this, new CopiarRecetaAppModel(modelObject.recetaSeleccionada, modelObject.usuario)))
	}

	def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|modelObject.initSearch] 
		dialog.open
	}
	
}
