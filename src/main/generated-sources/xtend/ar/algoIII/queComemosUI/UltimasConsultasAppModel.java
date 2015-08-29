package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Busqueda;
import ar.algo.adriba.tp1.Fecha;
import ar.algo.adriba.tp1.Receta;
import ar.algo.adriba.tp1.RepositorioExterno;
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
  
  public void search() {
    RepositorioExterno _repositorioExterno = new RepositorioExterno();
    Busqueda _busqueda = new Busqueda(this.usuario, _repositorioExterno);
    List<Receta> _filtrar = _busqueda.filtrar();
    this.resultados = _filtrar;
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
}
