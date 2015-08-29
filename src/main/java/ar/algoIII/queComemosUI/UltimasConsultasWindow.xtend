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

class UltimasConsultasWindow extends SimpleWindow<UltimasConsultasAppModel> {
	
	new(WindowOwner parent) {
		super(parent, new UltimasConsultasAppModel)
		modelObject.search()
	}
	
	override def createMainTemplate(Panel mainPanel) {
		title = "Bienvenido a ¿Que Comemos?"
		taskDescription = "Estas fueron tus ultimas consultas"

		super.createMainTemplate(mainPanel)

		this.createResultsGrid(mainPanel)
		this.createGridActions(mainPanel)
	}
	
	def protected createResultsGrid(Panel mainPanel) {
		val table = new Table<Receta>(mainPanel, typeof(Receta)) => [
			bindItemsToProperty("resultados")
			bindValueToProperty("recetaSeleccionada")
		]
		this.describeResultsGrid(table)
	}
	
	def void describeResultsGrid(Table<Receta> table) {
		new Column<Receta>(table) => [
			title = "Nombre"
			fixedSize = 200
			bindContentsToProperty("nombre")
		]

		new Column<Receta>(table) => [
			title = "Calorias"
			fixedSize = 100
			bindContentsToProperty("caloriasReceta")
		]

		new Column<Receta>(table) => [
			title = "Temporada"
			fixedSize = 200
			bindContentsToProperty("temporada")
		]
	}
	
	def void createGridActions(Panel mainPanel) {
		// Deshabilitar los botones si no hay ningún elemento seleccionado en la grilla.
		val elementSelected = new NotNullObservable("recetaSeleccionada")
		
		val actionsPanel = new Panel(mainPanel).layout = new HorizontalLayout
		
		new Button(actionsPanel) => [
			caption = "Editar"
			//onClick = [|this.modificarCelular]
			bindEnabled(elementSelected)
		]

		new Button(actionsPanel) => [
			caption = "Borrar"
			//onClick = [|modelObject.eliminarCelularSeleccionado]
			bindEnabled(elementSelected)
		]
	}
	
	override protected addActions(Panel actionsPanel) {
		new Button(actionsPanel) => [
			caption = "Buscar"
			onClick = [|modelObject.search]
			setAsDefault
			disableOnError
		]

		new Button(actionsPanel) => [
			caption = "Limpiar"
		//	onClick = [|modelObject.clear]
		]

		new Button(actionsPanel) => [
			caption = "Nuevo Celular"
			//onClick = [|this.crearCelular]
		]
	}
	
	override protected createFormPanel(Panel mainPanel) {
		val table = new Table<Receta>(mainPanel, typeof(Receta)) => [
			bindItemsToProperty("resultados")
			bindValueToProperty("recetaSeleccionada")
		]
	}
	
	
//Acciones

	/*def void crearCelular() {
		this.openDialog(new CrearCelularWindow(this))
	}

	def void modificarCelular() {
		this.openDialog(new EditarCelularWindow(this, modelObject.celularSeleccionado))
	}*/

	def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|modelObject.search]
		dialog.open
	}
}