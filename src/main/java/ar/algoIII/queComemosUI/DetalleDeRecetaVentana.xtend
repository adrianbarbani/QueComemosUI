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

@Accessors
//-Djava.system.class.loader=com.uqbar.apo.APOClassLoader
class DetalleDeRecetaVentana extends MainWindow<Receta> {
	Receta pizza
	static Comida prepizza = new Comida(200, "prepizza", 50)

	
	new(){
		super(new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Pizza de muzzarella").
			agregarIngrediente(prepizza).setearCalorias(500).
			build)
		this.pizza = this.modelObject 	
	}
	
	def static main (String []args){
		new DetalleDeRecetaVentana().startApplication
	}
	
	override createContents(Panel mainPanel) {
			this.title = "Detalle De Receta"
			new Label(mainPanel).bindValueToProperty("nombreDelPlato")
	}
	
	
}