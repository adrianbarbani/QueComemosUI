package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Receta;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

@SuppressWarnings("all")
public class DetalleDeRecetaVentana extends MainWindow<Receta> {
  public DetalleDeRecetaVentana() {
    super(new Receta());
  }
  
  public static void main(final String[] args) {
    DetalleDeRecetaVentana _detalleDeRecetaVentana = new DetalleDeRecetaVentana();
    _detalleDeRecetaVentana.startApplication();
  }
  
  public void createContents(final Panel mainPanel) {
    this.setTitle("Detalle De Receta");
  }
}
