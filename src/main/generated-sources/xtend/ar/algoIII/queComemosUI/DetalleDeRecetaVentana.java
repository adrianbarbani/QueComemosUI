package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Comida;
import ar.algo.adriba.tp1.CondicionPreexistente;
import ar.algo.adriba.tp1.Cosas;
import ar.algoIII.queComemosUI.DetalleDeRecetaAppModel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.arena.aop.windows.TransactionalDialog;
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
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@Accessors
@SuppressWarnings("all")
public class DetalleDeRecetaVentana extends TransactionalDialog<DetalleDeRecetaAppModel> {
  private List<String> comidaQueLeDisgusta = new ArrayList<String>();
  
  public DetalleDeRecetaVentana(final WindowOwner owner, final DetalleDeRecetaAppModel model) {
    super(owner, model);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
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
    this.addPanelCaloriasYDuenio(mainPanel);
    this.addPanelDificultadYTemporada(mainPanel);
    this.addPanelIngredientesYCondimentos(mainPanel);
    this.addPanelFavoritaYCondiciones(mainPanel);
    this.addPanelProcesoDePreparacion(mainPanel);
    this.addPanelBotonVolver(mainPanel);
  }
  
  public Binding<Object, Control, ControlBuilder> addPanelCaloriasYDuenio(final Panel mainPanel) {
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
  
  public Panel addPanelIngredientesYCondimentos(final Panel mainPanel) {
    Panel _xblockexpression = null;
    {
      final Panel panelIngredientesYCondimentos = new Panel(mainPanel);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      panelIngredientesYCondimentos.setLayout(_horizontalLayout);
      final Panel panelIngredientes = new Panel(panelIngredientesYCondimentos);
      Label _label = new Label(panelIngredientes);
      _label.setText("Ingredientes");
      this.grillaIngredientes(panelIngredientes);
      final Panel panelCondimentos = new Panel(panelIngredientesYCondimentos);
      Label _label_1 = new Label(panelCondimentos);
      _label_1.setText("Condimentos");
      _xblockexpression = this.listaDeCondimentos(panelCondimentos);
    }
    return _xblockexpression;
  }
  
  public Panel addPanelFavoritaYCondiciones(final Panel mainPanel) {
    Panel _xblockexpression = null;
    {
      final Panel panelFavoritaYCondiciones = new Panel(mainPanel);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      panelFavoritaYCondiciones.setLayout(_horizontalLayout);
      final Panel panelFavorita = new Panel(panelFavoritaYCondiciones);
      HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
      panelFavorita.setLayout(_horizontalLayout_1);
      Label _label = new Label(panelFavorita);
      _label.setText("Favorita");
      CheckBox checkFavorita = new CheckBox(panelFavorita);
      checkFavorita.<Object, ControlBuilder>bindValueToProperty("favorita");
      final Panel panelCondiciones = new Panel(panelFavoritaYCondiciones);
      Label _label_1 = new Label(panelCondiciones);
      _label_1.setText("Condiciones Preexistentes");
      _xblockexpression = this.listaCondicionesPreexistentes(panelCondiciones);
    }
    return _xblockexpression;
  }
  
  public Label addPanelProcesoDePreparacion(final Panel mainPanel) {
    Label _xblockexpression = null;
    {
      final GroupPanel panelProcesoDePreparacion = new GroupPanel(mainPanel);
      panelProcesoDePreparacion.setTitle("Proceso de Preparación");
      Label _label = new Label(panelProcesoDePreparacion);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.<Object, ControlBuilder>bindValueToProperty("unaReceta.explicacionDeLaPreparacion");
          Color _color = new Color(176, 176, 176);
          it.setBackground(_color);
        }
      };
      _xblockexpression = ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    }
    return _xblockexpression;
  }
  
  public Binding<Object, Control, ControlBuilder> addPanelBotonVolver(final Panel mainPanel) {
    Binding<Object, Control, ControlBuilder> _xblockexpression = null;
    {
      final Panel panelBotonVolver = new Panel(mainPanel);
      Button _button = new Button(panelBotonVolver);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Volver");
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Label _label = new Label(panelBotonVolver);
      _xblockexpression = _label.<Object, ControlBuilder>bindValueToProperty("unUsuario.cantidadDeFavorita");
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
  public List<String> getComidaQueLeDisgusta() {
    return this.comidaQueLeDisgusta;
  }
  
  public void setComidaQueLeDisgusta(final List<String> comidaQueLeDisgusta) {
    this.comidaQueLeDisgusta = comidaQueLeDisgusta;
  }
}
