package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Comida;
import ar.algo.adriba.tp1.Publica;
import ar.algo.adriba.tp1.Receta;
import ar.algo.adriba.tp1.RecetaBuilder;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.lacar.ui.model.ControlBuilder;

@Accessors
@SuppressWarnings("all")
public class DetalleDeRecetaVentana extends MainWindow<Receta> {
  private Receta pizza;
  
  private static Comida prepizza = new Comida(200, "prepizza", 50);
  
  public DetalleDeRecetaVentana() {
    super(
      new RecetaBuilder().tipoDeReceta(new Publica()).nombreDelPlato("Pizza de muzzarella").agregarIngrediente(DetalleDeRecetaVentana.prepizza).setearCalorias(500).setearDificultad("Facil").setearTemporadas("Todo el año").build());
    Receta _modelObject = this.getModelObject();
    this.pizza = _modelObject;
  }
  
  public static void main(final String[] args) {
    DetalleDeRecetaVentana _detalleDeRecetaVentana = new DetalleDeRecetaVentana();
    _detalleDeRecetaVentana.startApplication();
  }
  
  public void createContents(final Panel mainPanel) {
    this.setTitle("Detalle De Receta");
    Label _label = new Label(mainPanel);
    _label.<Object, ControlBuilder>bindValueToProperty("nombreDelPlato");
    final Panel panelCaloriasYDueño = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    panelCaloriasYDueño.setLayout(_horizontalLayout);
    Label _label_1 = new Label(panelCaloriasYDueño);
    _label_1.<Object, ControlBuilder>bindValueToProperty("caloriasReceta");
    Label _label_2 = new Label(panelCaloriasYDueño);
    _label_2.setText("calorias");
    final Panel panelDificultadYTemporada = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
    panelDificultadYTemporada.setLayout(_horizontalLayout_1);
    final Panel panelDificultad = new Panel(panelDificultadYTemporada);
    final Panel panelTemporada = new Panel(panelDificultadYTemporada);
    Label _label_3 = new Label(panelDificultad);
    _label_3.setText("Dificultad");
    Label _label_4 = new Label(panelDificultad);
    _label_4.<Object, ControlBuilder>bindValueToProperty("dificultad");
    Label _label_5 = new Label(panelTemporada);
    _label_5.setText("Temporada");
    Label _label_6 = new Label(panelTemporada);
    _label_6.<Object, ControlBuilder>bindValueToProperty("temporada");
    final Panel panelIngredientesYCondimentos = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout_2 = new HorizontalLayout();
    panelIngredientesYCondimentos.setLayout(_horizontalLayout_2);
    final Panel panelIngredientes = new Panel(panelIngredientesYCondimentos);
    final Panel panelCondimentos = new Panel(panelIngredientesYCondimentos);
    Label _label_7 = new Label(panelIngredientes);
    _label_7.setText("Ingredientes");
    Label _label_8 = new Label(panelCondimentos);
    _label_8.setText("Condimentos");
    final Panel panelFavoritaYCondiciones = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout_3 = new HorizontalLayout();
    panelFavoritaYCondiciones.setLayout(_horizontalLayout_3);
    final Panel panelFavorita = new Panel(panelFavoritaYCondiciones);
    HorizontalLayout _horizontalLayout_4 = new HorizontalLayout();
    panelFavorita.setLayout(_horizontalLayout_4);
    final Panel panelCondiciones = new Panel(panelFavoritaYCondiciones);
    Label _label_9 = new Label(panelFavorita);
    _label_9.setText("Favorita");
    Label _label_10 = new Label(panelCondiciones);
    _label_10.setText("Condiciones Preexistentes");
    final Panel panelProcesoDePreparacion = new Panel(mainPanel);
    Label _label_11 = new Label(panelProcesoDePreparacion);
    _label_11.setText("Proceso de Preparación");
    Label _label_12 = new Label(panelProcesoDePreparacion);
    _label_12.<Object, ControlBuilder>bindValueToProperty("explicacionDeLaPreparacion");
    final Panel panelBotonVolver = new Panel(mainPanel);
    Button _button = new Button(panelBotonVolver);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Volver");
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  @Pure
  public Receta getPizza() {
    return this.pizza;
  }
  
  public void setPizza(final Receta pizza) {
    this.pizza = pizza;
  }
}
