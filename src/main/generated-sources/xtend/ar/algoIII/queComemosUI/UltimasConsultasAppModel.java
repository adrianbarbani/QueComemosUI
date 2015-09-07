package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Busqueda;
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
  
  private String descripcion;
  
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
    int _size = this.resultados.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      this.mostrarUltimasRecetasConsultadas();
    }
    int _size_1 = this.resultados.size();
    boolean _equals_1 = (_size_1 == 0);
    if (_equals_1) {
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
  public String getDescripcion() {
    return this.descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this.descripcion = descripcion;
  }
  
  @Pure
  public Usuario getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }
}
