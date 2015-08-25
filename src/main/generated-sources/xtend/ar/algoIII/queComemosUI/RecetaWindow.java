package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Receta;
import ar.algo.adriba.tp1.Usuario;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class RecetaWindow {
  private Receta unaReceta;
  
  private Usuario unUsuario;
  
  public RecetaWindow(final Receta receta, final Usuario usuario) {
    this.unaReceta = receta;
    this.unUsuario = usuario;
  }
  
  @Pure
  public Receta getUnaReceta() {
    return this.unaReceta;
  }
  
  public void setUnaReceta(final Receta unaReceta) {
    this.unaReceta = unaReceta;
  }
  
  @Pure
  public Usuario getUnUsuario() {
    return this.unUsuario;
  }
  
  public void setUnUsuario(final Usuario unUsuario) {
    this.unUsuario = unUsuario;
  }
}
