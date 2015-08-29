package ar.algoIII.queComemosUI

import ar.algo.adriba.tp1.Busqueda
import ar.algo.adriba.tp1.Comida
import ar.algo.adriba.tp1.Fecha
import ar.algo.adriba.tp1.Privada
import ar.algo.adriba.tp1.Publica
import ar.algo.adriba.tp1.Receta
import ar.algo.adriba.tp1.RecetaBuilder
import ar.algo.adriba.tp1.RepositorioRecetas
import ar.algo.adriba.tp1.Rutina
import ar.algo.adriba.tp1.Sexo
import ar.algo.adriba.tp1.Usuario
import ar.algo.adriba.tp1.UsuarioBuilder
import java.io.Serializable
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable

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



	//Harcodeo muchas recetas
	Comida carne = new Comida(99, "carne", 1)
	Comida harina = new Comida(25, "harina", 20)
	Comida huevo = new Comida(10, "huevo", 3)
	Comida panRallado = new Comida(12, "pan rallado", 50)
	Comida verdura = new Comida(6, "verdura", 12)
	Comida queso = new Comida(250, "queso", 800)
	Comida prepizza = new Comida(200, "prepizza", 50)
	Comida salsaDeTomate = new Comida(20, "salsa de tomate", 50)
	Comida sal = new Comida(0, "sal", 0)
	Comida salsaBlanca = new Comida(50, "salsa blanca", 400)
	Comida lomo = new Comida(30, "lomo", 200)
	Comida garbanzos = new Comida(30, "garbanzos", 500)
	Comida limon = new Comida(1, "limon", 10)
	Comida ajo = new Comida(1, "ajo", 10)

	Receta milanesa = new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Milanesas").
		agregarIngrediente(harina).agregarIngrediente(huevo).agregarIngrediente(panRallado).agregarIngrediente(carne).
		setearCalorias(150).setearDificultad("Dificil").build

	Receta milanesaNapolitana = new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Milanesa napolitana").
		agregarIngrediente(harina).agregarIngrediente(huevo).agregarIngrediente(panRallado).agregarIngrediente(carne).
		agregarIngrediente(queso).agregarIngrediente(salsaDeTomate).setearCalorias(8000).build

	Receta sopaDeVerdura = new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Sopa de Verdura").
		agregarIngrediente(verdura).agregarIngrediente(sal).setearCalorias(200).setearDificultad("Dificil").build

	Receta pizza = new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Pizza de muzzarella").
		agregarIngrediente(prepizza).agregarIngrediente(salsaDeTomate).agregarIngrediente(queso).setearCalorias(500).
		build

	Receta pizzaDeVerdura = new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato(
		"Pizza de verdura y salsa blanca").agregarIngrediente(prepizza).agregarIngrediente(salsaDeTomate).
		agregarIngrediente(queso).agregarIngrediente(salsaBlanca).agregarIngrediente(verdura).setearCalorias(560).build

	Receta lomoALaPlancha = new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Lomo a la Plancha").
		agregarIngrediente(lomo).setearCalorias(300).build

	/*Receta hummus = new RecetaBuilder().tipoDeReceta(new Privada(usuario, hummus)).nombreDelPlato(
		"Hummus de garbanzo").agregarIngrediente(garbanzos).agregarIngrediente(limon).agregarIngrediente(ajo).
		setearCalorias(600).build*/

	def void search() {
		resultados = new Busqueda(usuario, RepositorioRecetas.getInstance).filtrar
	}

	def marcarComoFavorita() {
		usuario.marcarComoFavorita(recetaSeleccionada)
	}

}
