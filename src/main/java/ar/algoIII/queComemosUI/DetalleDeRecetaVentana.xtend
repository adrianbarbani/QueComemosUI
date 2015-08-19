package ar.algoIII.queComemosUI

import ar.algo.adriba.tp1.Receta
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import ar.algo.adriba.tp1.RecetaBuilder
import ar.algo.adriba.tp1.Publica
import ar.algo.adriba.tp1.Comida
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button

@Accessors
//-Djava.system.class.loader=com.uqbar.apo.APOClassLoader
class DetalleDeRecetaVentana extends MainWindow<Receta> {
	Receta pizza
	static Comida prepizza = new Comida(200, "prepizza", 50)

	new() {
		super(
			new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Pizza de muzzarella").
				agregarIngrediente(prepizza).setearCalorias(500).setearDificultad("Facil").setearTemporadas("Todo el año").build)
		this.pizza = this.modelObject
	}

	def static main(String[] args) {
		new DetalleDeRecetaVentana().startApplication
	}

	override createContents(Panel mainPanel) { //Panel principal
		this.title = "Detalle De Receta"
		new Label(mainPanel).bindValueToProperty("nombreDelPlato")
		
		//------------------------------------------------------------------------
		
		val panelCaloriasYDueño = new Panel (mainPanel) //Panel que tiene una sola linea
		panelCaloriasYDueño.layout = new HorizontalLayout
		new Label(panelCaloriasYDueño).bindValueToProperty("caloriasReceta")
		new Label(panelCaloriasYDueño).text = "calorias"
		
		//Falta ver el tema del dueño (en este mismo panel)
		
		//------------------------------------------------------------------------
		
		val panelDificultadYTemporada = new Panel (mainPanel) //Hago un panel grande que sea horizontal
		panelDificultadYTemporada.layout = new HorizontalLayout
		
		val panelDificultad = new Panel (panelDificultadYTemporada) //Ese mismo panel lo divido en dos verticales
		val panelTemporada = new Panel (panelDificultadYTemporada)
		
		new Label(panelDificultad).text = "Dificultad"
		new Label(panelDificultad).bindValueToProperty("dificultad")
		new Label(panelTemporada).text = "Temporada"
		new Label(panelTemporada).bindValueToProperty("temporada")
		
		//------------------------------------------------------------------------
		
		val panelIngredientesYCondimentos = new Panel (mainPanel) //Repito el proceso de antes
		panelIngredientesYCondimentos.layout = new HorizontalLayout
		val panelIngredientes = new Panel (panelIngredientesYCondimentos)
		val panelCondimentos = new Panel (panelIngredientesYCondimentos)
		
		new Label(panelIngredientes).text = "Ingredientes"
		//aca hay que hacer la tabla
		new Label(panelCondimentos).text = "Condimentos"
		//aca hay que hacer la lista
		
		//------------------------------------------------------------------------
		
		val panelFavoritaYCondiciones = new Panel (mainPanel)	//Repito el proceso de antes
		panelFavoritaYCondiciones.layout = new HorizontalLayout
		val panelFavorita = new Panel (panelFavoritaYCondiciones)
		panelFavorita.layout = new HorizontalLayout //Lo hago horizontal asi el cosito para marcar y la palabra favorita quedan juntos
		val panelCondiciones = new Panel (panelFavoritaYCondiciones)
		
		new Label(panelFavorita).text = "Favorita"
		//aca hay que hacer el cosito para marcar
		new Label(panelCondiciones).text = "Condiciones Preexistentes"
		//aca hay que hacer la lista
		
		//------------------------------------------------------------------------
		
		val panelProcesoDePreparacion = new Panel (mainPanel)	//Repito el proceso de antes
		new Label(panelProcesoDePreparacion).bindValueToProperty("explicacionDeLaPreparacion") //agregar en el builder	
		
		//------------------------------------------------------------------------
		
		val panelBotonVolver = new Panel (mainPanel)
		new Button(panelBotonVolver) =>
			[
				//onClick [ | ] aca hay que ver que hace cuando lo tocamos
				caption = "Volver"
			] 
	}


	}
