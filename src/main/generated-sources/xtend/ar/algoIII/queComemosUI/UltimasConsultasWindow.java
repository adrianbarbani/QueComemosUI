package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Receta;
import ar.algo.adriba.tp1.Usuario;
import ar.algoIII.queComemosUI.DetalleDeRecetaAppModel;
import ar.algoIII.queComemosUI.DetalleDeRecetaVentana;
import ar.algoIII.queComemosUI.UltimasConsultasAppModel;
import java.awt.Color;
import org.apache.commons.collections15.Transformer;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.widgets.tables.labelprovider.ForegroundProvider;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class UltimasConsultasWindow extends SimpleWindow<UltimasConsultasAppModel> {
  public UltimasConsultasWindow(final WindowOwner parent) {
    super(parent, new UltimasConsultasAppModel());
    UltimasConsultasAppModel _modelObject = this.getModelObject();
    _modelObject.initSearch();
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Bienvenido a ¿Que Comemos?");
    UltimasConsultasAppModel _modelObject = this.getModelObject();
    String _descripcion = _modelObject.getDescripcion();
    this.setTaskDescription(_descripcion);
    this.panelBusqueda(mainPanel);
    super.createMainTemplate(mainPanel);
  }
  
  public Object panelBusqueda(final Panel panel) {
    return null;
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Table<Receta> _table = new Table<Receta>(mainPanel, Receta.class);
    final Procedure1<Table<Receta>> _function = new Procedure1<Table<Receta>>() {
      public void apply(final Table<Receta> it) {
        it.bindItemsToProperty("resultados");
        it.<Object, ControlBuilder>bindValueToProperty("recetaSeleccionada");
      }
    };
    final Table<Receta> table = ObjectExtensions.<Table<Receta>>operator_doubleArrow(_table, _function);
    this.grillaDeResultados(table);
  }
  
  public void grillaDeResultados(final Table<Receta> table) {
    Column<Receta> _column = new Column<Receta>(table);
    final Procedure1<Column<Receta>> _function = new Procedure1<Column<Receta>>() {
      public void apply(final Column<Receta> it) {
        it.setTitle("Nombre");
        it.setFixedSize(200);
        it.bindContentsToProperty("nombre");
        ForegroundProvider<Receta, Color> _bindForeground = it.bindForeground("sosPublica");
        final Transformer<Object, Color> _function = new Transformer<Object, Color>() {
          public Color transform(final Object receta) {
            Color _xifexpression = null;
            if ((((Boolean) receta)).booleanValue()) {
              _xifexpression = Color.BLUE;
            } else {
              _xifexpression = Color.RED;
            }
            return _xifexpression;
          }
        };
        _bindForeground.setTransformer(_function);
      }
    };
    ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column, _function);
    Column<Receta> _column_1 = new Column<Receta>(table);
    final Procedure1<Column<Receta>> _function_1 = new Procedure1<Column<Receta>>() {
      public void apply(final Column<Receta> it) {
        it.setTitle("Calorias");
        it.setFixedSize(100);
        it.bindContentsToProperty("caloriasReceta");
      }
    };
    ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column_1, _function_1);
    Column<Receta> _column_2 = new Column<Receta>(table);
    final Procedure1<Column<Receta>> _function_2 = new Procedure1<Column<Receta>>() {
      public void apply(final Column<Receta> it) {
        it.setTitle("Dificultad");
        it.setFixedSize(200);
        it.bindContentsToProperty("dificultad");
      }
    };
    ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column_2, _function_2);
    Column<Receta> _column_3 = new Column<Receta>(table);
    final Procedure1<Column<Receta>> _function_3 = new Procedure1<Column<Receta>>() {
      public void apply(final Column<Receta> it) {
        it.setTitle("Temporada");
        it.setFixedSize(200);
        it.bindContentsToProperty("temporada");
      }
    };
    ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column_3, _function_3);
  }
  
  protected void addActions(final Panel mainPanel) {
    final NotNullObservable elementSelected = new NotNullObservable("recetaSeleccionada");
    Panel _panel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    final Panel actionsPanel = _panel.setLayout(_horizontalLayout);
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Ver");
        final Action _function = new Action() {
          public void execute() {
            UltimasConsultasWindow.this.abrirDetalle();
          }
        };
        it.onClick(_function);
        it.<Object, ControlBuilder>bindEnabled(elementSelected);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actionsPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Favorita");
        final Action _function = new Action() {
          public void execute() {
            UltimasConsultasAppModel _modelObject = UltimasConsultasWindow.this.getModelObject();
            _modelObject.marcarComoFavorita();
          }
        };
        it.onClick(_function);
        it.<Object, ControlBuilder>bindEnabled(elementSelected);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  public void abrirDetalle() {
    UltimasConsultasAppModel _modelObject = this.getModelObject();
    Receta _recetaSeleccionada = _modelObject.getRecetaSeleccionada();
    UltimasConsultasAppModel _modelObject_1 = this.getModelObject();
    Usuario _usuario = _modelObject_1.getUsuario();
    DetalleDeRecetaAppModel _detalleDeRecetaAppModel = new DetalleDeRecetaAppModel(_recetaSeleccionada, _usuario);
    DetalleDeRecetaVentana _detalleDeRecetaVentana = new DetalleDeRecetaVentana(this, _detalleDeRecetaAppModel);
    this.openDialog(_detalleDeRecetaVentana);
    UltimasConsultasAppModel _modelObject_2 = this.getModelObject();
    _modelObject_2.agregarRecetaVista();
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        UltimasConsultasAppModel _modelObject = UltimasConsultasWindow.this.getModelObject();
        _modelObject.initSearch();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
}
