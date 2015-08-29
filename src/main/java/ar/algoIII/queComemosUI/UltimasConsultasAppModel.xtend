package ar.algoIII.queComemosUI

import ar.algo.adriba.tp1.Busqueda
import ar.algo.adriba.tp1.Fecha
import ar.algo.adriba.tp1.Receta
import ar.algo.adriba.tp1.RepositorioExterno
import ar.algo.adriba.tp1.Rutina
import ar.algo.adriba.tp1.Sexo
import ar.algo.adriba.tp1.UsuarioBuilder
import java.io.Serializable
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable
import ar.algo.adriba.tp1.Usuario

@Accessors
@Observable
class UltimasConsultasAppModel implements Serializable {

	//Hardcodeo un usuario
	Sexo Femenino = Sexo.FEMENINO
	Fecha fechaValida = new Fecha(System.currentTimeMillis() - 24 * 60 * 60 * 1000);

	Usuario usuario = new UsuarioBuilder().agregarPeso(52).agregarAltura(1.64).agregarSexo(Femenino).
		agregarNombre("Esteban").agregarFechaNacimiento(fechaValida).agregarRutina(new Rutina(61, true)).build()
	Receta recetaSeleccionada
	List<Receta> resultados = new ArrayList<Receta>

	def void search() {
		resultados = new Busqueda(usuario, new RepositorioExterno).filtrar
	}
	
	def marcarComoFavorita(){
		usuario.marcarComoFavorita(recetaSeleccionada)
	}
	
}
