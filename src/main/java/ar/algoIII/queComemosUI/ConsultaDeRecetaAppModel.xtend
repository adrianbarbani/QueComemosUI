package ar.algoIII.queComemosUI

import ar.algo.adriba.tp1.Busqueda
import ar.algo.adriba.tp1.Receta
import ar.algo.adriba.tp1.RepositorioRecetas
import ar.algo.adriba.tp1.Usuario
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable
import java.util.List

@Accessors
@Observable 
class ConsultaDeRecetaAppModel extends UltimasConsultasAppModel {
	
	boolean filtrosAplicados = false
	Usuario usuario
	List<Receta> resultados = newArrayList
	String dificultadSeleccionada
	String temporadaSeleccionada
	String ingredienteABuscar
	String nombre
	int caloriasDesde
	int caloriasHasta
	
		
	def filtros() {
		if(filtrosAplicados) usuario.filtrosPerfilUsuario else newArrayList
	}
	
	def void buscar() {
		resultados= new Busqueda(usuario, RepositorioRecetas.getInstance,filtros).buscarReceta(nombre, dificultadSeleccionada, temporadaSeleccionada, ingredienteABuscar, caloriasDesde, caloriasHasta)
	}
	
	def void clear(){
		nombre=null
		dificultadSeleccionada= null
		temporadaSeleccionada= null
		ingredienteABuscar=null
		caloriasDesde=0
		caloriasHasta=0
	}

}