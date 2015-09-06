package ar.algoIII.runnable

import ar.algo.adriba.tp1.Receta
import ar.algo.adriba.tp1.RepoDificultades
import ar.algoIII.queComemosUI.ConsultaDeRecetaWindow
import ar.algoIII.queComemosUI.RecetasObjectSet
import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import org.uqbar.commons.utils.ApplicationContext
import ar.algoIII.queComemosUI.LoginWindow

class QueComemosApplication extends Application {

	static def void main(String[] args) {
		new QueComemosApplication().start()
	}

	override protected Window<?> createMainWindow() {
		val usuario = RecetasObjectSet.INSTANCE.crearUsuario
		RecetasObjectSet.INSTANCE.crearRecetas(usuario)
		return new ConsultaDeRecetaWindow(this, usuario)
		//return new LoginWindow(this)
	}

}
