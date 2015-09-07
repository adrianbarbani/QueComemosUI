package ar.algoIII.runnable;

import ar.algo.adriba.tp1.Usuario;
import ar.algoIII.queComemosUI.LoginWindow;
import ar.algoIII.queComemosUI.RecetasObjectSet;
import ar.algoIII.queComemosUI.UsuariosObjectSet;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

@SuppressWarnings("all")
public class QueComemosApplication extends Application {
  public static void main(final String[] args) {
    QueComemosApplication _queComemosApplication = new QueComemosApplication();
    _queComemosApplication.start();
  }
  
  protected Window<?> createMainWindow() {
    final Usuario usuario = RecetasObjectSet.INSTANCE.crearUsuario();
    UsuariosObjectSet.INSTANCE.crearUsuarios();
    RecetasObjectSet.INSTANCE.crearRecetas(usuario);
    return new LoginWindow(this);
  }
}
