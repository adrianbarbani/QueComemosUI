package ar.algoIII.queComemosUI

import ar.algo.adriba.tp1.Receta
import ar.algo.adriba.tp1.Usuario
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable

@Accessors
@Observable
class RecetaWindow {
	Receta unaReceta
	Usuario unUsuario

	new(Receta receta, Usuario usuario) {
		unaReceta = receta
		unUsuario = usuario
		
	}

	
}
