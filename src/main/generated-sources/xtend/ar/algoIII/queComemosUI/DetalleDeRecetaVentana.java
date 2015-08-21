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
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.lacar.ui.model.ControlBuilder;

@Accessors
@SuppressWarnings("all")
public class DetalleDeRecetaVentana extends MainWindow<Receta> {
  private Receta pizza;
  
  private static Comida prepizza = new Comida(0, "prepizza", 1);
  
  private static Comida salsaDeTomate = new Comida(300, "Salsa de tomate", 0);
  
  public DetalleDeRecetaVentana() {
    super(
      new RecetaBuilder().tipoDeReceta(new Publica()).nombreDelPlato("Pizza de muzzarella").agregarIngrediente(DetalleDeRecetaVentana.prepizza).agregarIngrediente(DetalleDeRecetaVentana.salsaDeTomate).setearCalorias(500).setearDificultad("Facil").setearTemporadas("Todo el año").setearPreparacion("En la prepizza volcar la salsa de tomate y cocinar por 15 minutos").build());
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
    this.grillaIngredientes(panelIngredientes);
    Label _label_8 = new Label(panelCondimentos);
    _label_8.setText("Condimentos");
    Panel _panel = new Panel(panelCondimentos);
    final Procedure1<Panel> _function = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        HorizontalLayout _horizontalLayout = new HorizontalLayout();
        it.setLayout(_horizontalLayout);
        List<Object> _list = new List<Object>(it);
        final Procedure1<List<Object>> _function = new Procedure1<List<Object>>() {
          public void apply(final List<Object> it) {
            it.bindItemsToProperty("subRecetaseIngredientes");
            it.setWidth(100);
            it.setHeight(120);
          }
        };
        ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function);
      }
    };
    ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
    final Panel panelFavoritaYCondiciones = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout_3 = new HorizontalLayout();
    panelFavoritaYCondiciones.setLayout(_horizontalLayout_3);
    final Panel panelFavorita = new Panel(panelFavoritaYCondiciones);
    HorizontalLayout _horizontalLayout_4 = new HorizontalLayout();
    panelFavorita.setLayout(_horizontalLayout_4);
    final Panel panelCondiciones = new Panel(panelFavoritaYCondiciones);
    Label _label_9 = new Label(panelFavorita);
    _label_9.setText("Favorita");
    CheckBox checkResumen = new CheckBox(panelFavorita);
    Label _label_10 = new Label(panelCondiciones);
    _label_10.setText("Condiciones Preexistentes");
    final Panel panelProcesoDePreparacion = new Panel(mainPanel);
    Label _label_11 = new Label(panelProcesoDePreparacion);
    _label_11.setText("Proceso de Preparación");
    Label _label_12 = new Label(panelProcesoDePreparacion);
    _label_12.<Object, ControlBuilder>bindValueToProperty("explicacionDeLaPreparacion");
    final Panel panelBotonVolver = new Panel(mainPanel);
    Button _button = new Button(panelBotonVolver);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Volver");
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
  }
  
  public Column<Comida> grillaIngredientes(final Panel panel) {
    Column<Comida> _xblockexpression = null;
    {
      Table<Comida> _table = new Table<Comida>(panel, Comida.class);
      final Procedure1<Table<Comida>> _function = new Procedure1<Table<Comida>>() {
        public void apply(final Table<Comida> it) {
          it.setWidth(300);
          it.setHeight(100);
          it.bindItemsToProperty("ingredientes");
        }
      };
      final Table<Comida> gridIngredientes = ObjectExtensions.<Table<Comida>>operator_doubleArrow(_table, _function);
      Column<Comida> _column = new Column<Comida>(gridIngredientes);
      final Procedure1<Column<Comida>> _function_1 = new Procedure1<Column<Comida>>() {
        public void apply(final Column<Comida> it) {
          it.setTitle("Dosis");
          it.bindContentsToProperty("cantidad");
        }
      };
      ObjectExtensions.<Column<Comida>>operator_doubleArrow(_column, _function_1);
      Column<Comida> _column_1 = new Column<Comida>(gridIngredientes);
      final Procedure1<Column<Comida>> _function_2 = new Procedure1<Column<Comida>>() {
        public void apply(final Column<Comida> it) {
          it.setTitle("Ingrediente");
          it.bindContentsToProperty("nombre");
        }
      };
      _xblockexpression = ObjectExtensions.<Column<Comida>>operator_doubleArrow(_column_1, _function_2);
    }
    return _xblockexpression;
  }
  
  @Pure
  public Receta getPizza() {
    return this.pizza;
  }
  
  public void setPizza(final Receta pizza) {
    this.pizza = pizza;
  }
}
