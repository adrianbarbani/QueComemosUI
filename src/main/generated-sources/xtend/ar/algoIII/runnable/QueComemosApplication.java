package ar.algoIII.runnable;

import ar.algo.adriba.tp1.Receta;
import ar.algo.adriba.tp1.RepoDificultades;
import ar.algo.adriba.tp1.RepositorioExterno;
import ar.algoIII.queComemosUI.ConsultaDeRecetaWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.ApplicationContext;

@SuppressWarnings("all")
public class QueComemosApplication extends Application {
  public static void main(final String[] args) {
    QueComemosApplication _queComemosApplication = new QueComemosApplication();
    _queComemosApplication.start();
  }
  
  protected Window<?> createMainWindow() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    RepoDificultades _repoDificultades = new RepoDificultades();
    _instance.<RepoDificultades>configureSingleton(Receta.class, _repoDificultades);
    ApplicationContext _instance_1 = ApplicationContext.getInstance();
    RepositorioExterno _repositorioExterno = new RepositorioExterno();
    _instance_1.<RepositorioExterno>configureSingleton(Receta.class, _repositorioExterno);
    return new ConsultaDeRecetaWindow(this);
  }
}
