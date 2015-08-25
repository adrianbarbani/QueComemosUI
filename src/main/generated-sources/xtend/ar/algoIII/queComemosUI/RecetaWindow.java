package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Persona;
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
  
  private Persona unUsuario;
  
  public RecetaWindow(final Receta receta, final Usuario usuario) {
    this.unaReceta = receta;
    this.unUsuario = usuario;
  }
  
  public void setFavorita(final boolean recetaFavorita) {
    if (recetaFavorita) {
      this.unUsuario.marcarComoFavorita(this.unaReceta);
    } else {
      this.unUsuario.desmarcarComoFavorita(this.unaReceta);
    }
  }
  
  public boolean getFavorita() {
    return this.unUsuario.esRecetaFavorita(this.unaReceta);
  }
  
  @Pure
  public Receta getUnaReceta() {
    return this.unaReceta;
  }
  
  public void setUnaReceta(final Receta unaReceta) {
    this.unaReceta = unaReceta;
  }
  
  @Pure
  public Persona getUnUsuario() {
    return this.unUsuario;
  }
  
  public void setUnUsuario(final Persona unUsuario) {
    this.unUsuario = unUsuario;
  }
}
