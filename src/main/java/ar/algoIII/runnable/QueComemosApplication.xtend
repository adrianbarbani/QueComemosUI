package ar.algoIII.runnable

import ar.algo.adriba.tp1.Receta
import ar.algo.adriba.tp1.RepoDificultades
import ar.algo.adriba.tp1.RepositorioExterno
import ar.algoIII.queComemosUI.ConsultaDeRecetaWindow
import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import org.uqbar.commons.utils.ApplicationContext

class QueComemosApplication extends Application {

	static def void main(String[] args) {
		new QueComemosApplication().start()
	}

	override protected Window<?> createMainWindow() {
		ApplicationContext.instance.configureSingleton(typeof(Receta), new RepoDificultades)
		ApplicationContext.instance.configureSingleton(typeof(Receta), new RepositorioExterno)// TODO: ver esto que no se que mierda estoy haciendo
		return new ConsultaDeRecetaWindow(this)
	}

}
