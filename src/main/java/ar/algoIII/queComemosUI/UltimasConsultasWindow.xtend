package ar.algoIII.queComemosUI

import ar.algo.adriba.tp1.Receta
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import java.awt.Color

class UltimasConsultasWindow extends SimpleWindow<UltimasConsultasAppModel> {

	new(WindowOwner parent) {
		super(parent, new UltimasConsultasAppModel)
		modelObject.initSearch()
	}

	override def createMainTemplate(Panel mainPanel) {
		title = "Bienvenido a ¿Que Comemos?"
		taskDescription = modelObject.descripcion

		super.createMainTemplate(mainPanel)

	}

	def void describeResultsGrid(Table<Receta> table) {
		new Column<Receta>(table) => [
			title = "Nombre"
			fixedSize = 200
			bindContentsToProperty("nombre")
			bindForeground("sosPublica").transformer =
				[ Object receta | if (receta as Boolean) Color.BLUE else Color.RED ]
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

	}

	override protected createFormPanel(Panel mainPanel) {
		val table = new Table<Receta>(mainPanel, typeof(Receta)) => [
			bindItemsToProperty("resultados")
			bindValueToProperty("recetaSeleccionada")
				
		]
		this.describeResultsGrid(table)
	}

//Acciones

	
	def void abrirDetalle() {
		this.openDialog(new DetalleDeRecetaVentana(this, new RecetaWindow(modelObject.recetaSeleccionada, modelObject.usuario)))
		modelObject.agregarRecetaVista
	}

	
	def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|modelObject.initSearch] // ver
		dialog.open
	}
}