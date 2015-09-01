package ar.algoIII.queComemosUI

import ar.algo.adriba.tp1.RepoDeTemporadas
import ar.algo.adriba.tp1.RepoDificultades
import org.uqbar.arena.bindings.ObservableProperty
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
		val panelIzquierdo = new Panel(searchFormPanel)
		val panelDerecho = new Panel (searchFormPanel)
		
		contenidoPanelIzq(panelIzquierdo)// ingrediente

		contenidoPanelDerecho(panelDerecho)
		
		botonera(panel)
		
		
	}
	
	def contenidoPanelDerecho(Panel panelDerecho) {
		new Label(panelDerecho) => [
			text = "Calorias"
		]
		val panelCalorias = new Panel(panelDerecho)
		panelCalorias.layout = new HorizontalLayout
		
		new Label(panelCalorias).text = "Desde"
		new TextBox(panelCalorias) =>[
			bindValueToProperty("caloriasDesde")
			width = 50
			]
		new Label(panelCalorias).text = "Hasta"
		new TextBox(panelCalorias)=>[
			bindValueToProperty("caloriasHasta")
			width = 50
		
		]
		new Label(panelDerecho).text = "Temporada"
		
		
		new Selector<String>(panelDerecho) => [
			allowNull = true
			bindValueToProperty = "temporadaSeleccionada"
			bindItems(new ObservableProperty(RepoDeTemporadas.getInstance, "todasLasTemporadas"))
			
		]
		
		new Label(panelDerecho).text = "Aplicar filtros del usuario"
		
		
		var checkFavorita = new CheckBox(panelDerecho)// ver el check
		checkFavorita.bindValueToProperty("filtrosAplicados") 
	}
	
	
	def contenidoPanelIzq(Panel panelIzquierdo) {
		new Label(panelIzquierdo) => [
			text = "Nombre"
		]
		new TextBox(panelIzquierdo).bindValueToProperty("nombre")
				
		new Label(panelIzquierdo).text = "Dificultad"
		new Selector<Dificultad>(panelIzquierdo) => [
			allowNull = true
			bindValueToProperty = "dificultadSeleccionada"
			bindItems(new ObservableProperty(RepoDificultades.getInstance, "todasLasDificultades"))
			
		]
		new Label(panelIzquierdo).text = "Que contenga ingrediente"
		new TextBox(panelIzquierdo).bindValueToProperty("ingredienteABuscar")
	}
	
	
	def botonera(Panel panel) {
		val panelBotonera = new Panel(panel)
		panelBotonera.layout = new HorizontalLayout
		
		new Button(panelBotonera) => [
			caption = "Buscar"
			onClick = [|modelObject.buscar]
		]
		
		new Button(panelBotonera) => [
			caption = "Volver"
			onClick = [|modelObject.clear]
		]
	}
	

	
	
	
}
