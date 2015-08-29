package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Busqueda;
import ar.algo.adriba.tp1.Comida;
import ar.algo.adriba.tp1.Fecha;
import ar.algo.adriba.tp1.Publica;
import ar.algo.adriba.tp1.Receta;
import ar.algo.adriba.tp1.RecetaBuilder;
import ar.algo.adriba.tp1.RepositorioRecetas;
import ar.algo.adriba.tp1.Rutina;
import ar.algo.adriba.tp1.Sexo;
import ar.algo.adriba.tp1.Usuario;
import ar.algo.adriba.tp1.UsuarioBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class UltimasConsultasAppModel implements Serializable {
  private Sexo Femenino = Sexo.FEMENINO;
  
  private Fecha fechaValida = new Fecha((System.currentTimeMillis() - (((24 * 60) * 60) * 1000)));
  
  private Usuario usuario = new UsuarioBuilder().agregarPeso(52).agregarAltura(1.64).agregarSexo(this.Femenino).agregarNombre("Esteban").agregarFechaNacimiento(this.fechaValida).agregarRutina(new Rutina(61, true)).build();
  
  private Receta recetaSeleccionada;
  
  private List<Receta> resultados = new ArrayList<Receta>();
  
  private Comida carne = new Comida(0, "Carne", 1);
  
  private Comida harina = new Comida(0, "Harina", 20);
  
  private Comida huevo = new Comida(0, "Huevo", 3);
  
  private Comida panRallado = new Comida(0, "Pan Rallado", 50);
  
  private Comida verdura = new Comida(0, "Verdura", 12);
  
  private Comida queso = new Comida(0, "Muzzarella", 200);
  
  private Comida prepizza = new Comida(0, "Prepizza", 1);
  
  private Comida salsaDeTomate = new Comida(0, "Salsa de tomate", 200);
  
  private Comida sal = new Comida(18, "Sal", 0);
  
  private Comida salsaBlanca = new Comida(0, "Salsa Blanca", 400);
  
  private Comida lomo = new Comida(0, "Lomo", 200);
  
  private Comida garbanzos = new Comida(0, "Garbanzos", 500);
  
  private Comida limon = new Comida(10, "Limon", 0);
  
  private Comida ajo = new Comida(5, "Ajo", 0);
  
  private Comida jamon = new Comida(0, "Jamon", 100);
  
  private Comida oregano = new Comida(100, "Oregano", 0);
  
  private Comida azucar = new Comida(0, "azucar", 200);
  
  private Receta milanesa = new RecetaBuilder().tipoDeReceta(new Publica()).nombreDelPlato("Milanesas").agregarIngrediente(this.harina).agregarIngrediente(this.huevo).setearTemporadas("Todo el año").agregarIngrediente(this.panRallado).agregarIngrediente(this.carne).setearCalorias(150).setearDificultad("Dificil").build();
  
  private Receta milanesaNapolitana = new RecetaBuilder().tipoDeReceta(new Publica()).nombreDelPlato("Milanesa napolitana").agregarIngrediente(this.harina).agregarIngrediente(this.huevo).agregarIngrediente(this.panRallado).agregarIngrediente(this.carne).agregarIngrediente(this.queso).agregarIngrediente(this.salsaDeTomate).setearCalorias(8000).setearTemporadas("Todo el año").setearDificultad("Dificil").build();
  
  private Receta sopaDeVerdura = new RecetaBuilder().tipoDeReceta(new Publica()).nombreDelPlato("Sopa de Verdura").agregarIngrediente(this.verdura).agregarIngrediente(this.sal).setearCalorias(200).setearTemporadas("Invierno").setearDificultad("Dificil").build();
  
  private Receta pizza = new RecetaBuilder().tipoDeReceta(new Publica()).nombreDelPlato("Pizza de muzzarella").agregarIngrediente(this.prepizza).agregarIngrediente(this.salsaDeTomate).agregarIngrediente(this.oregano).agregarIngrediente(this.queso).setearTemporadas("Todo el año").setearDificultad("Facil").setearCalorias(500).build();
  
  private Receta pizzaDeVerdura = new RecetaBuilder().tipoDeReceta(new Publica()).nombreDelPlato(
    "Pizza de verdura y salsa blanca").agregarIngrediente(this.prepizza).agregarIngrediente(this.salsaDeTomate).agregarIngrediente(this.queso).agregarIngrediente(this.salsaBlanca).agregarIngrediente(this.verdura).setearTemporadas("Todo el año").setearCalorias(560).setearDificultad("Dificil").build();
  
  private Receta lomoALaPlancha = new RecetaBuilder().tipoDeReceta(new Publica()).nombreDelPlato("Lomo a la Plancha").agregarIngrediente(this.lomo).setearCalorias(300).setearTemporadas("Otoño").setearDificultad("Media").build();
  
  /**
   * Receta hummus = new RecetaBuilder().tipoDeReceta(new Privada(usuario, hummus)).nombreDelPlato(
   * "Hummus de garbanzo").agregarIngrediente(garbanzos).agregarIngrediente(limon).agregarIngrediente(ajo).
   * setearCalorias(600).build
   */
  public void search() {
    RepositorioRecetas _instance = RepositorioRecetas.getInstance();
    Busqueda _busqueda = new Busqueda(this.usuario, _instance);
    List<Receta> _filtrar = _busqueda.filtrar();
    this.resultados = _filtrar;
  }
  
  public void marcarComoFavorita() {
    this.usuario.marcarComoFavorita(this.recetaSeleccionada);
  }
  
  @Pure
  public Sexo getFemenino() {
    return this.Femenino;
  }
  
  public void setFemenino(final Sexo Femenino) {
    this.Femenino = Femenino;
  }
  
  @Pure
  public Fecha getFechaValida() {
    return this.fechaValida;
  }
  
  public void setFechaValida(final Fecha fechaValida) {
    this.fechaValida = fechaValida;
  }
  
  @Pure
  public Usuario getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }
  
  @Pure
  public Receta getRecetaSeleccionada() {
    return this.recetaSeleccionada;
  }
  
  public void setRecetaSeleccionada(final Receta recetaSeleccionada) {
    this.recetaSeleccionada = recetaSeleccionada;
  }
  
  @Pure
  public List<Receta> getResultados() {
    return this.resultados;
  }
  
  public void setResultados(final List<Receta> resultados) {
    this.resultados = resultados;
  }
  
  @Pure
  public Comida getCarne() {
    return this.carne;
  }
  
  public void setCarne(final Comida carne) {
    this.carne = carne;
  }
  
  @Pure
  public Comida getHarina() {
    return this.harina;
  }
  
  public void setHarina(final Comida harina) {
    this.harina = harina;
  }
  
  @Pure
  public Comida getHuevo() {
    return this.huevo;
  }
  
  public void setHuevo(final Comida huevo) {
    this.huevo = huevo;
  }
  
  @Pure
  public Comida getPanRallado() {
    return this.panRallado;
  }
  
  public void setPanRallado(final Comida panRallado) {
    this.panRallado = panRallado;
  }
  
  @Pure
  public Comida getVerdura() {
    return this.verdura;
  }
  
  public void setVerdura(final Comida verdura) {
    this.verdura = verdura;
  }
  
  @Pure
  public Comida getQueso() {
    return this.queso;
  }
  
  public void setQueso(final Comida queso) {
    this.queso = queso;
  }
  
  @Pure
  public Comida getPrepizza() {
    return this.prepizza;
  }
  
  public void setPrepizza(final Comida prepizza) {
    this.prepizza = prepizza;
  }
  
  @Pure
  public Comida getSalsaDeTomate() {
    return this.salsaDeTomate;
  }
  
  public void setSalsaDeTomate(final Comida salsaDeTomate) {
    this.salsaDeTomate = salsaDeTomate;
  }
  
  @Pure
  public Comida getSal() {
    return this.sal;
  }
  
  public void setSal(final Comida sal) {
    this.sal = sal;
  }
  
  @Pure
  public Comida getSalsaBlanca() {
    return this.salsaBlanca;
  }
  
  public void setSalsaBlanca(final Comida salsaBlanca) {
    this.salsaBlanca = salsaBlanca;
  }
  
  @Pure
  public Comida getLomo() {
    return this.lomo;
  }
  
  public void setLomo(final Comida lomo) {
    this.lomo = lomo;
  }
  
  @Pure
  public Comida getGarbanzos() {
    return this.garbanzos;
  }
  
  public void setGarbanzos(final Comida garbanzos) {
    this.garbanzos = garbanzos;
  }
  
  @Pure
  public Comida getLimon() {
    return this.limon;
  }
  
  public void setLimon(final Comida limon) {
    this.limon = limon;
  }
  
  @Pure
  public Comida getAjo() {
    return this.ajo;
  }
  
  public void setAjo(final Comida ajo) {
    this.ajo = ajo;
  }
  
  @Pure
  public Comida getJamon() {
    return this.jamon;
  }
  
  public void setJamon(final Comida jamon) {
    this.jamon = jamon;
  }
  
  @Pure
  public Comida getOregano() {
    return this.oregano;
  }
  
  public void setOregano(final Comida oregano) {
    this.oregano = oregano;
  }
  
  @Pure
  public Comida getAzucar() {
    return this.azucar;
  }
  
  public void setAzucar(final Comida azucar) {
    this.azucar = azucar;
  }
  
  @Pure
  public Receta getMilanesa() {
    return this.milanesa;
  }
  
  public void setMilanesa(final Receta milanesa) {
    this.milanesa = milanesa;
  }
  
  @Pure
  public Receta getMilanesaNapolitana() {
    return this.milanesaNapolitana;
  }
  
  public void setMilanesaNapolitana(final Receta milanesaNapolitana) {
    this.milanesaNapolitana = milanesaNapolitana;
  }
  
  @Pure
  public Receta getSopaDeVerdura() {
    return this.sopaDeVerdura;
  }
  
  public void setSopaDeVerdura(final Receta sopaDeVerdura) {
    this.sopaDeVerdura = sopaDeVerdura;
  }
  
  @Pure
  public Receta getPizza() {
    return this.pizza;
  }
  
  public void setPizza(final Receta pizza) {
    this.pizza = pizza;
  }
  
  @Pure
  public Receta getPizzaDeVerdura() {
    return this.pizzaDeVerdura;
  }
  
  public void setPizzaDeVerdura(final Receta pizzaDeVerdura) {
    this.pizzaDeVerdura = pizzaDeVerdura;
  }
  
  @Pure
  public Receta getLomoALaPlancha() {
    return this.lomoALaPlancha;
  }
  
  public void setLomoALaPlancha(final Receta lomoALaPlancha) {
    this.lomoALaPlancha = lomoALaPlancha;
  }
}
