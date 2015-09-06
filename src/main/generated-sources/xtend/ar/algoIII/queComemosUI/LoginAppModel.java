package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.RepoDeUsuariosMock;
import ar.algo.adriba.tp1.Usuario;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class LoginAppModel {
  private String nombreUsuarioABuscar;
  
  private String contrasenia;
  
  private Usuario usuarioLogin;
  
  public Usuario autorizarLogin() {
    RepoDeUsuariosMock _instance = RepoDeUsuariosMock.getInstance();
    return _instance.compararContraseña(this.nombreUsuarioABuscar, this.contrasenia);
  }
  
  public String clear() {
    String _xblockexpression = null;
    {
      this.nombreUsuarioABuscar = null;
      _xblockexpression = this.contrasenia = null;
    }
    return _xblockexpression;
  }
  
  @Pure
  public String getNombreUsuarioABuscar() {
    return this.nombreUsuarioABuscar;
  }
  
  public void setNombreUsuarioABuscar(final String nombreUsuarioABuscar) {
    this.nombreUsuarioABuscar = nombreUsuarioABuscar;
  }
  
  @Pure
  public String getContrasenia() {
    return this.contrasenia;
  }
  
  public void setContrasenia(final String contrasenia) {
    this.contrasenia = contrasenia;
  }
  
  @Pure
  public Usuario getUsuarioLogin() {
    return this.usuarioLogin;
  }
  
  public void setUsuarioLogin(final Usuario usuarioLogin) {
    this.usuarioLogin = usuarioLogin;
  }
}
