package ar.algoIII.queComemosUI

import ar.algo.adriba.tp1.Busqueda
import ar.algo.adriba.tp1.MostrarLosPrimerosDiez
import ar.algo.adriba.tp1.Receta
import ar.algo.adriba.tp1.RepositorioRecetas
import ar.algo.adriba.tp1.Usuario
import java.io.Serializable
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable

@Accessors
@Observable
class UltimasConsultasAppModel implements Serializable {

	//Hardcodeo un usuario
	Receta recetaSeleccionada
	List<Receta> resultados = newArrayList
	List<Receta> ultimasConsultadas = newArrayList
	String descripcion

	Usuario usuario

	new(Usuario usuario) {
		this.usuario = usuario
	}

	def void todasLasRecetas() {
		resultados = new Busqueda(usuario, RepositorioRecetas.getInstance, new MostrarLosPrimerosDiez).filtrar
		descripcion = "estas son las mas consultadas"
	}

	def marcarComoFavorita() {
		usuario.marcarComoFavorita(recetaSeleccionada)
	}

	def void recetasFavoritas() {
		resultados = usuario.recetasFavoritas
		descripcion = "Estas son tus recetas Favoritas"
	}

	def initSearch() {
		this.recetasFavoritas
		if (resultados.size == 0)
			this.mostrarUltimasRecetasConsultadas
		if (resultados.size == 0)
			this.todasLasRecetas
	}

	def agregarRecetaVista() {
		ultimasConsultadas.add(recetaSeleccionada)
	}

	def void mostrarUltimasRecetasConsultadas() {
		resultados = ultimasConsultadas
		descripcion = "Estas Fueron las ultimas recetas que mas consultaste"
	}

}
//pregunta 1: como hardcodear las recetas directamente en el repo
//pregunta 3: initSearch no me gusta es if es horrible.
