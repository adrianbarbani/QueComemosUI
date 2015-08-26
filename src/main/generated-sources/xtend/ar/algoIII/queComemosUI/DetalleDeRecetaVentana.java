package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Comida;
import ar.algo.adriba.tp1.CondicionPreexistente;
import ar.algo.adriba.tp1.Cosas;
import ar.algo.adriba.tp1.Fecha;
import ar.algo.adriba.tp1.Publica;
import ar.algo.adriba.tp1.RecetaBuilder;
import ar.algo.adriba.tp1.Rutina;
import ar.algo.adriba.tp1.Sexo;
import ar.algo.adriba.tp1.UsuarioBuilder;
import ar.algoIII.queComemosUI.RecetaWindow;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@Accessors
@SuppressWarnings("all")
public class DetalleDeRecetaVentana extends MainWindow<RecetaWindow> {
  private RecetaWindow pizza;
  
  private List<String> comidaQueLeDisgusta = new ArrayList<String>();
  
  private static Sexo Femenino = Sexo.FEMENINO;
  
  private static Fecha fechaValida = new Fecha((System.currentTimeMillis() - (((24 * 60) * 60) * 1000)));
  
  private static Comida prepizza = new Comida(0, "Prepizza", 1);
  
  private static Comida queso = new Comida(0, "Muzzarella", 200);
  
  private static Comida salsaDeTomate = new Comida(0, "Salsa de tomate", 200);
  
  private static Comida jamon = new Comida(0, "Jamon", 100);
  
  private static Comida oregano = new Comida(100, "Oregano", 0);
  
  private static Comida azucar = new Comida(0, "azucar", 200);
  
  public DetalleDeRecetaVentana() {
    super(
      new RecetaWindow(new RecetaBuilder().tipoDeReceta(new Publica()).nombreDelPlato("Pizza de Jamon y Morrones").agregarIngrediente(DetalleDeRecetaVentana.prepizza).agregarIngrediente(DetalleDeRecetaVentana.azucar).agregarIngrediente(DetalleDeRecetaVentana.jamon).agregarIngrediente(DetalleDeRecetaVentana.queso).agregarIngrediente(DetalleDeRecetaVentana.salsaDeTomate).agregarIngrediente(DetalleDeRecetaVentana.oregano).setearCalorias(500).setearDificultad("Facil").setearTemporadas("Todo el año").setearPreparacion(
        "En la prepizza volcar la salsa de tomate y cocinar por 15 minutos, luego sumar el queso y volver a cocinar. Agregar el jamon y el morron; oregano a gusto.").build(), new UsuarioBuilder().agregarPeso(52).agregarAltura(1.64).agregarSexo(DetalleDeRecetaVentana.Femenino).agregarNombre("Esteban").agregarFechaNacimiento(DetalleDeRecetaVentana.fechaValida).agregarRutina(new Rutina(61, true)).build()));
    RecetaWindow _modelObject = this.getModelObject();
    this.pizza = _modelObject;
  }
  
  public static void main(final String[] args) {
    DetalleDeRecetaVentana _detalleDeRecetaVentana = new DetalleDeRecetaVentana();
    _detalleDeRecetaVentana.startApplication();
  }
  
  public void createContents(final Panel mainPanel) {
    this.setTitle("Detalle De Receta");
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.<Object, ControlBuilder>bindValueToProperty("unaReceta.nombreDelPlato");
        Color _color = new Color(0, 0, 0);
        it.setForeground(_color);
        it.setFontSize(14);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    this.addPanelCalorias(mainPanel);
    this.addPanelDificultadYTemporada(mainPanel);
    final Panel panelIngredientesYCondimentos = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    panelIngredientesYCondimentos.setLayout(_horizontalLayout);
    final Panel panelIngredientes = new Panel(panelIngredientesYCondimentos);
    final Panel panelCondimentos = new Panel(panelIngredientesYCondimentos);
    Label _label_1 = new Label(panelIngredientes);
    _label_1.setText("Ingredientes");
    this.grillaIngredientes(panelIngredientes);
    Label _label_2 = new Label(panelCondimentos);
    _label_2.setText("Condimentos");
    this.listaDeCondimentos(panelCondimentos);
    final Panel panelFavoritaYCondiciones = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
    panelFavoritaYCondiciones.setLayout(_horizontalLayout_1);
    final Panel panelFavorita = new Panel(panelFavoritaYCondiciones);
    HorizontalLayout _horizontalLayout_2 = new HorizontalLayout();
    panelFavorita.setLayout(_horizontalLayout_2);
    final Panel panelCondiciones = new Panel(panelFavoritaYCondiciones);
    Label _label_3 = new Label(panelFavorita);
    _label_3.setText("Favorita");
    CheckBox checkFavorita = new CheckBox(panelFavorita);
    checkFavorita.<Object, ControlBuilder>bindValueToProperty("favorita");
    Label _label_4 = new Label(panelCondiciones);
    _label_4.setText("Condiciones Preexistentes");
    this.listaCondicionesPreexistentes(panelCondiciones);
    final GroupPanel panelProcesoDePreparacion = new GroupPanel(mainPanel);
    panelProcesoDePreparacion.setTitle("Proceso de Preparación");
    Label _label_5 = new Label(panelProcesoDePreparacion);
    final Procedure1<Label> _function_1 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.<Object, ControlBuilder>bindValueToProperty("unaReceta.explicacionDeLaPreparacion");
        Color _color = new Color(176, 176, 176);
        it.setBackground(_color);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_5, _function_1);
    final Panel panelBotonVolver = new Panel(mainPanel);
    Button _button = new Button(panelBotonVolver);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Volver");
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
    Label _label_6 = new Label(panelBotonVolver);
    _label_6.<Object, ControlBuilder>bindValueToProperty("unUsuario.cantidadDeFavorita");
  }
  
  public Binding<Object, Control, ControlBuilder> addPanelDificultadYTemporada(final Panel mainPanel) {
    Binding<Object, Control, ControlBuilder> _xblockexpression = null;
    {
      final Panel panelDificultadYTemporada = new Panel(mainPanel);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      panelDificultadYTemporada.setLayout(_horizontalLayout);
      final Panel panelDificultad = new Panel(panelDificultadYTemporada);
      Label _label = new Label(panelDificultad);
      _label.setText("Dificultad");
      Label _label_1 = new Label(panelDificultad);
      _label_1.<Object, ControlBuilder>bindValueToProperty("unaReceta.dificultad");
      final Panel panelTemporada = new Panel(panelDificultadYTemporada);
      Label _label_2 = new Label(panelTemporada);
      _label_2.setText("Temporada");
      Label _label_3 = new Label(panelTemporada);
      _xblockexpression = _label_3.<Object, ControlBuilder>bindValueToProperty("unaReceta.temporada");
    }
    return _xblockexpression;
  }
  
  public Binding<Object, Control, ControlBuilder> addPanelCalorias(final Panel mainPanel) {
    Binding<Object, Control, ControlBuilder> _xblockexpression = null;
    {
      final GroupPanel panelCaloriasYDueño = new GroupPanel(mainPanel);
      panelCaloriasYDueño.setTitle("");
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      panelCaloriasYDueño.setLayout(_horizontalLayout);
      Label _label = new Label(panelCaloriasYDueño);
      _label.<Object, ControlBuilder>bindValueToProperty("unaReceta.caloriasReceta");
      Label _label_1 = new Label(panelCaloriasYDueño);
      _label_1.setText("calorias");
      Label _label_2 = new Label(panelCaloriasYDueño);
      _xblockexpression = _label_2.<Object, ControlBuilder>bindValueToProperty("propietario");
    }
    return _xblockexpression;
  }
  
  public Panel listaCondicionesPreexistentes(final Panel panelCondiciones) {
    Panel _panel = new Panel(panelCondiciones);
    final Procedure1<Panel> _function = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        HorizontalLayout _horizontalLayout = new HorizontalLayout();
        it.setLayout(_horizontalLayout);
        org.uqbar.arena.widgets.List<Object> _list = new org.uqbar.arena.widgets.List<Object>(it);
        final Procedure1<org.uqbar.arena.widgets.List<Object>> _function = new Procedure1<org.uqbar.arena.widgets.List<Object>>() {
          public void apply(final org.uqbar.arena.widgets.List<Object> it) {
            Binding<?, Selector<Object>, ListBuilder<Object>> propiedadCondiciones = it.bindItemsToProperty("unaReceta.paraQueCondicionesSoyInadecuada");
            PropertyAdapter _propertyAdapter = new PropertyAdapter(CondicionPreexistente.class, "nombre");
            propiedadCondiciones.setAdapter(_propertyAdapter);
            it.setWidth(100);
            it.setHeight(120);
          }
        };
        ObjectExtensions.<org.uqbar.arena.widgets.List<Object>>operator_doubleArrow(_list, _function);
      }
    };
    return ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
  }
  
  public Panel listaDeCondimentos(final Panel panelCondimentos) {
    Panel _panel = new Panel(panelCondimentos);
    final Procedure1<Panel> _function = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        HorizontalLayout _horizontalLayout = new HorizontalLayout();
        it.setLayout(_horizontalLayout);
        org.uqbar.arena.widgets.List<Object> _list = new org.uqbar.arena.widgets.List<Object>(it);
        final Procedure1<org.uqbar.arena.widgets.List<Object>> _function = new Procedure1<org.uqbar.arena.widgets.List<Object>>() {
          public void apply(final org.uqbar.arena.widgets.List<Object> it) {
            Binding<?, Selector<Object>, ListBuilder<Object>> propiedadCondimentos = it.bindItemsToProperty("unaReceta.condimentos");
            PropertyAdapter _propertyAdapter = new PropertyAdapter(Cosas.class, "nombre");
            propiedadCondimentos.setAdapter(_propertyAdapter);
            it.setWidth(100);
            it.setHeight(200);
          }
        };
        ObjectExtensions.<org.uqbar.arena.widgets.List<Object>>operator_doubleArrow(_list, _function);
      }
    };
    return ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
  }
  
  public Column<Comida> grillaIngredientes(final Panel panel) {
    Column<Comida> _xblockexpression = null;
    {
      Table<Comida> _table = new Table<Comida>(panel, Comida.class);
      final Procedure1<Table<Comida>> _function = new Procedure1<Table<Comida>>() {
        public void apply(final Table<Comida> it) {
          it.setWidth(1000);
          it.setHeight(8000);
          it.bindItemsToProperty("unaReceta.ingredientes");
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
  public RecetaWindow getPizza() {
    return this.pizza;
  }
  
  public void setPizza(final RecetaWindow pizza) {
    this.pizza = pizza;
  }
  
  @Pure
  public List<String> getComidaQueLeDisgusta() {
    return this.comidaQueLeDisgusta;
  }
  
  public void setComidaQueLeDisgusta(final List<String> comidaQueLeDisgusta) {
    this.comidaQueLeDisgusta = comidaQueLeDisgusta;
  }
}
