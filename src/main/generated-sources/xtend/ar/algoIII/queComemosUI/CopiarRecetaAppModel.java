package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Receta;
import ar.algo.adriba.tp1.Usuario;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class CopiarRecetaAppModel {
  private Receta receta;
  
  private String nombreDeCopia;
  
  private Usuario usuario;
  
  public CopiarRecetaAppModel(final Receta unaReceta, final Usuario unUsuario) {
    this.receta = unaReceta;
    this.usuario = unUsuario;
  }
  
  public Object copiarReceta() {
    return null;
  }
  
  @Pure
  public Receta getReceta() {
    return this.receta;
  }
  
  public void setReceta(final Receta receta) {
    this.receta = receta;
  }
  
  @Pure
  public String getNombreDeCopia() {
    return this.nombreDeCopia;
  }
  
  public void setNombreDeCopia(final String nombreDeCopia) {
    this.nombreDeCopia = nombreDeCopia;
  }
  
  @Pure
  public Usuario getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }
}
