package ar.algoIII.queComemosUI

import java.awt.Color
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.WindowOwner
import queComemos.entrega3.dominio.Dificultad

class ConsultaDeRecetaWindow extends UltimasConsultasWindow {
	
	new(WindowOwner parent) {
		super(parent)
	}
	
	override createMainTemplate(Panel mainPanel){
		
		super.createMainTemplate(mainPanel)
		title = "Consulta de Receta"
		taskDescription = ""// no se como sacar el taskDescription de la ventana anterior
		
	}
	
	override panelBusqueda (Panel panel) {
		val searchFormPanel = new Panel(panel)
		searchFormPanel.setLayout(new ColumnLayout(2))
		
		new Label(searchFormPanel) => [
			text = "Número"
			foreground = Color.BLUE
		]


		new Label(searchFormPanel) => [
			text = "Calorias"
			foreground = Color.BLUE
		]

		new TextBox(searchFormPanel).bindValueToProperty("nombre")
		new TextBox(searchFormPanel).bindValueToProperty("nombre")//calorias
		
		new Label(searchFormPanel).text = "Dificultad"
		new Label(searchFormPanel).text = "Temporada"
		
		new Selector<Dificultad>(searchFormPanel) => [
			allowNull = false
			bindValueToProperty = "dificultadSeleccionada"
			//bindItems(new ObservableProperty(repoDificultades, "dificultades"))
			
		]
		
		new Selector<Dificultad>(searchFormPanel) => [
			allowNull = false
			bindValueToProperty = "temporadaSeleccionada"
			//bindItems(new ObservableProperty(repoDificultades, "dificultades"))
			
		]
		
		new Label(searchFormPanel).text = "Que contenga ingrediente"
		new Label(searchFormPanel).text = "Aplicar filtros del usuario"
		
		
		new TextBox(searchFormPanel).bindValueToProperty("nombre")// ingrediente
		var checkFavorita = new CheckBox(searchFormPanel)
		//checkFavorita.bindValueToProperty("favorita") aca va aplicar filtros
		
		
		botonera(panel)
		
		
	}
	
	def botonera(Panel panel) {
		val panelBotonera = new Panel(panel)
		panelBotonera.layout = new HorizontalLayout
		
		new Button(panelBotonera) => [
			caption = "Buscar"
			//onClick = [|this.abrirDetalle]
		]
		
		new Button(panelBotonera) => [
			caption = "Volver"
			//onClick = [|this.abrirDetalle]
		]
	}
	

	
	
	
}