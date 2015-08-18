package ar.algoIII.queComemosUI

import ar.algo.adriba.tp1.Receta
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.Panel

class DetalleDeRecetaVentana extends MainWindow<Receta> {
	
	new(){
		super(new Receta)
	}
	
	def static main (String []args){
		new DetalleDeRecetaVentana().startApplication
	}
	
	override createContents(Panel mainPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	
}