package ar.algoIII.runnable

import ar.algoIII.queComemosUI.LoginWindow
import ar.algoIII.queComemosUI.RecetasObjectSet
import ar.algoIII.queComemosUI.UsuariosObjectSet
import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window

class QueComemosApplication extends Application {

	static def void main(String[] args) {
		new QueComemosApplication().start()
	}

	override protected Window<?> createMainWindow() {
		val usuario = RecetasObjectSet.INSTANCE.crearUsuario
		UsuariosObjectSet.INSTANCE.crearUsuarios()
		RecetasObjectSet.INSTANCE.crearRecetas(usuario) 
		//return new ConsultaDeRecetaWindow(this, usuario)
		return new LoginWindow(this)
	}

}
