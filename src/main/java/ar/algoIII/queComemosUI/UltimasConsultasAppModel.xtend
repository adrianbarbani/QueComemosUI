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
	List<Receta> ultimasConsultadas = new ArrayList<Receta>
	String descripcion
	String nombre
	String dificultadSeleccionada
	String temporadaSeleccionada
	
	//Harcodeo muchas recetas
	Comida carne = new Comida(0, "Carne", 1)
	Comida harina = new Comida(0, "Harina", 20)
	Comida huevo = new Comida(0, "Huevo", 3)
	Comida panRallado = new Comida(0, "Pan Rallado", 50)
	Comida verdura = new Comida(0, "Verdura", 12)
	Comida queso = new Comida(0, "Muzzarella", 200)
	Comida prepizza = new Comida(0, "Prepizza", 1)
	Comida salsaDeTomate = new Comida(0, "Salsa de tomate", 200)
	Comida sal = new Comida(18, "Sal", 0)
	Comida salsaBlanca = new Comida(0, "Salsa Blanca", 400)
	Comida lomo = new Comida(0, "Lomo", 200)
	Comida garbanzos = new Comida(0, "Garbanzos", 500)
	Comida limon = new Comida(10, "Limon", 0)
	Comida ajo = new Comida(5, "Ajo", 0)

	Comida jamon = new Comida(0, "Jamon", 100)
	Comida oregano = new Comida(100, "Oregano", 0)
	Comida azucar = new Comida(0, "azucar", 200)
	
	Receta milanesa = new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Milanesas").
		agregarIngrediente(harina).agregarIngrediente(huevo).setearTemporadas("Todo el año").agregarIngrediente(panRallado).agregarIngrediente(carne).
		setearCalorias(150).setearDificultad("Dificil").build

	Receta milanesaNapolitana = new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Milanesa napolitana").
		agregarIngrediente(harina).agregarIngrediente(huevo).agregarIngrediente(panRallado).agregarIngrediente(carne).
		agregarIngrediente(queso).agregarIngrediente(salsaDeTomate).setearCalorias(8000).setearTemporadas("Todo el año").setearDificultad("Dificil").build

	Receta sopaDeVerdura = new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Sopa de Verdura").
		agregarIngrediente(verdura).agregarIngrediente(sal).setearCalorias(200).setearTemporadas("Invierno").setearDificultad("Dificil").build

	Receta pizza = new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Pizza de muzzarella").
		agregarIngrediente(prepizza).agregarIngrediente(salsaDeTomate).agregarIngrediente(oregano).agregarIngrediente(queso).setearTemporadas("Todo el año").setearDificultad("Facil").setearCalorias(500).build

	Receta pizzaDeVerdura = new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato(
		"Pizza de verdura y salsa blanca").agregarIngrediente(prepizza).agregarIngrediente(salsaDeTomate).
		agregarIngrediente(queso).agregarIngrediente(salsaBlanca).agregarIngrediente(verdura).setearTemporadas("Todo el año").setearCalorias(560).setearDificultad("Dificil").build

	Receta lomoALaPlancha = new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Lomo a la Plancha").
		agregarIngrediente(lomo).setearCalorias(300).setearTemporadas("Otoño").setearDificultad("Media").build

	Receta hummus = (new RecetaBuilder().tipoDeReceta(new Privada(usuario)).nombreDelPlato(
		"Hummus de garbanzo").agregarIngrediente(garbanzos).agregarIngrediente(limon).agregarIngrediente(ajo).
		setearCalorias(600).build)

	
	def void todasLasRecetas() {
		resultados = new Busqueda(usuario, RepositorioRecetas.getInstance).filtrar
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
	
	def void mostrarUltimasRecetasConsultadas(){
		resultados = ultimasConsultadas
		descripcion = "Estas Fueron las ultimas recetas que mas consultaste"
	}

}

//pregunta 1: como hardcodear las recetas directamente en el repo
//pregunta 2: como restringir la coleccion para que me muestre hasta 10 resultados
//pregunta 3: initSearch no me gusta es if es horrible.
