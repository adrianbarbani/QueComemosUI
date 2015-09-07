package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Busqueda;
import ar.algo.adriba.tp1.Filtro;
import ar.algo.adriba.tp1.Receta;
import ar.algo.adriba.tp1.RepositorioRecetas;
import ar.algo.adriba.tp1.Usuario;
import ar.algoIII.queComemosUI.UltimasConsultasAppModel;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class ConsultaDeRecetaAppModel extends UltimasConsultasAppModel {
  private boolean filtrosAplicados = false;
  
  private Usuario usuario;
  
  private List<Receta> resultados = CollectionLiterals.<Receta>newArrayList();
  
  private String dificultadSeleccionada;
  
  private String temporadaSeleccionada;
  
  private String ingredienteABuscar;
  
  private String nombre;
  
  private int caloriasDesde;
  
  private int caloriasHasta;
  
  public List<Filtro> filtros() {
    List<Filtro> _xifexpression = null;
    if (this.filtrosAplicados) {
      _xifexpression = this.usuario.getFiltrosPerfilUsuario();
    } else {
      _xifexpression = CollectionLiterals.<Filtro>newArrayList();
    }
    return _xifexpression;
  }
  
  public void buscar() {
    RepositorioRecetas _instance = RepositorioRecetas.getInstance();
    List<Filtro> _filtros = this.filtros();
    Busqueda _busqueda = new Busqueda(this.usuario, _instance, _filtros);
    List<Receta> _buscarReceta = _busqueda.buscarReceta(this.nombre, this.dificultadSeleccionada, this.temporadaSeleccionada, this.ingredienteABuscar, this.caloriasDesde, this.caloriasHasta);
    this.resultados = _buscarReceta;
  }
  
  public void clear() {
    this.nombre = null;
    this.dificultadSeleccionada = null;
    this.temporadaSeleccionada = null;
    this.ingredienteABuscar = null;
    this.caloriasDesde = 0;
    this.caloriasHasta = 0;
  }
  
  public ConsultaDeRecetaAppModel(final Usuario usuario) {
    super(usuario);
  }
  
  @Pure
  public boolean isFiltrosAplicados() {
    return this.filtrosAplicados;
  }
  
  public void setFiltrosAplicados(final boolean filtrosAplicados) {
    this.filtrosAplicados = filtrosAplicados;
  }
  
  @Pure
  public Usuario getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }
  
  @Pure
  public List<Receta> getResultados() {
    return this.resultados;
  }
  
  public void setResultados(final List<Receta> resultados) {
    this.resultados = resultados;
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
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
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
}
