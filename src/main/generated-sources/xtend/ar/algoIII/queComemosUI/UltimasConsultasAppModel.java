package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Busqueda;
import ar.algo.adriba.tp1.Filtro;
import ar.algo.adriba.tp1.MostrarLosPrimerosDiez;
import ar.algo.adriba.tp1.Receta;
import ar.algo.adriba.tp1.RepositorioRecetas;
import ar.algo.adriba.tp1.Usuario;
import java.io.Serializable;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class UltimasConsultasAppModel implements Serializable {
  private Receta recetaSeleccionada;
  
  private List<Receta> resultados = CollectionLiterals.<Receta>newArrayList();
  
  private List<Receta> ultimasConsultadas = CollectionLiterals.<Receta>newArrayList();
  
  private boolean filtrosAplicados = false;
  
  private String descripcion;
  
  private String nombre;
  
  private String dificultadSeleccionada;
  
  private String temporadaSeleccionada;
  
  private String ingredienteABuscar;
  
  private int caloriasDesde;
  
  private int caloriasHasta;
  
  private Usuario usuario;
  
  public UltimasConsultasAppModel(final Usuario usuario) {
    this.usuario = usuario;
  }
  
  public void todasLasRecetas() {
    RepositorioRecetas _instance = RepositorioRecetas.getInstance();
    MostrarLosPrimerosDiez _mostrarLosPrimerosDiez = new MostrarLosPrimerosDiez();
    Busqueda _busqueda = new Busqueda(this.usuario, _instance, _mostrarLosPrimerosDiez);
    List<Receta> _filtrar = _busqueda.filtrar();
    this.resultados = _filtrar;
    this.descripcion = "estas son las mas consultadas";
  }
  
  public void marcarComoFavorita() {
    this.usuario.marcarComoFavorita(this.recetaSeleccionada);
  }
  
  public void recetasFavoritas() {
    List<Receta> _recetasFavoritas = this.usuario.getRecetasFavoritas();
    this.resultados = _recetasFavoritas;
    this.descripcion = "Estas son tus recetas Favoritas";
  }
  
  public void initSearch() {
    this.recetasFavoritas();
    boolean _isEmpty = this.resultados.isEmpty();
    if (_isEmpty) {
      this.mostrarUltimasRecetasConsultadas();
    }
    boolean _isEmpty_1 = this.resultados.isEmpty();
    if (_isEmpty_1) {
      this.todasLasRecetas();
    }
  }
  
  public boolean agregarRecetaVista() {
    return this.ultimasConsultadas.add(this.recetaSeleccionada);
  }
  
  public void mostrarUltimasRecetasConsultadas() {
    this.resultados = this.ultimasConsultadas;
    this.descripcion = "Estas Fueron las ultimas recetas que mas consultaste";
  }
  
  public void buscar() {
    RepositorioRecetas _instance = RepositorioRecetas.getInstance();
    List<Filtro> _filtros = this.filtros();
    Busqueda _busqueda = new Busqueda(this.usuario, _instance, _filtros);
    List<Receta> _buscarReceta = _busqueda.buscarReceta(this.nombre, this.dificultadSeleccionada, this.temporadaSeleccionada, this.ingredienteABuscar, this.caloriasDesde, this.caloriasHasta);
    this.resultados = _buscarReceta;
  }
  
  public List<Filtro> filtros() {
    List<Filtro> _xifexpression = null;
    if (this.filtrosAplicados) {
      _xifexpression = this.usuario.getFiltrosPerfilUsuario();
    } else {
      _xifexpression = CollectionLiterals.<Filtro>newArrayList();
    }
    return _xifexpression;
  }
  
  public void clear() {
    this.nombre = null;
    this.dificultadSeleccionada = null;
    this.temporadaSeleccionada = null;
    this.ingredienteABuscar = null;
    this.caloriasDesde = 0;
    this.caloriasHasta = 0;
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
  public List<Receta> getUltimasConsultadas() {
    return this.ultimasConsultadas;
  }
  
  public void setUltimasConsultadas(final List<Receta> ultimasConsultadas) {
    this.ultimasConsultadas = ultimasConsultadas;
  }
  
  @Pure
  public boolean isFiltrosAplicados() {
    return this.filtrosAplicados;
  }
  
  public void setFiltrosAplicados(final boolean filtrosAplicados) {
    this.filtrosAplicados = filtrosAplicados;
  }
  
  @Pure
  public String getDescripcion() {
    return this.descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this.descripcion = descripcion;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public String getDificultadSeleccionada() {
    return this.dificultadSeleccionada;
  }
  
  public void setDificultadSeleccionada(final String dificultadSeleccionada) {
    this.dificultadSeleccionada = dificultadSeleccionada;
  }
  
  @Pure
  public String getTemporadaSeleccionada() {
    return this.temporadaSeleccionada;
  }
  
  public void setTemporadaSeleccionada(final String temporadaSeleccionada) {
    this.temporadaSeleccionada = temporadaSeleccionada;
  }
  
  @Pure
  public String getIngredienteABuscar() {
    return this.ingredienteABuscar;
  }
  
  public void setIngredienteABuscar(final String ingredienteABuscar) {
    this.ingredienteABuscar = ingredienteABuscar;
  }
  
  @Pure
  public int getCaloriasDesde() {
    return this.caloriasDesde;
  }
  
  public void setCaloriasDesde(final int caloriasDesde) {
    this.caloriasDesde = caloriasDesde;
  }
  
  @Pure
  public int getCaloriasHasta() {
    return this.caloriasHasta;
  }
  
  public void setCaloriasHasta(final int caloriasHasta) {
    this.caloriasHasta = caloriasHasta;
  }
  
  @Pure
  public Usuario getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }
}
