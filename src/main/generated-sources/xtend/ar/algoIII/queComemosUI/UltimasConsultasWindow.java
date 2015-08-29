package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Receta;
import ar.algoIII.queComemosUI.UltimasConsultasAppModel;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
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
    _modelObject.search();
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Bienvenido a ¿Que Comemos?");
    this.setTaskDescription("Estas fueron tus ultimas consultas");
    super.createMainTemplate(mainPanel);
    this.createResultsGrid(mainPanel);
    this.createGridActions(mainPanel);
  }
  
  protected void createResultsGrid(final Panel mainPanel) {
    Table<Receta> _table = new Table<Receta>(mainPanel, Receta.class);
    final Procedure1<Table<Receta>> _function = new Procedure1<Table<Receta>>() {
      public void apply(final Table<Receta> it) {
        it.bindItemsToProperty("resultados");
        it.<Object, ControlBuilder>bindValueToProperty("recetaSeleccionada");
      }
    };
    final Table<Receta> table = ObjectExtensions.<Table<Receta>>operator_doubleArrow(_table, _function);
    this.describeResultsGrid(table);
  }
  
  public void describeResultsGrid(final Table<Receta> table) {
    Column<Receta> _column = new Column<Receta>(table);
    final Procedure1<Column<Receta>> _function = new Procedure1<Column<Receta>>() {
      public void apply(final Column<Receta> it) {
        it.setTitle("Nombre");
        it.setFixedSize(200);
        it.bindContentsToProperty("nombre");
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
        it.setTitle("Temporada");
        it.setFixedSize(200);
        it.bindContentsToProperty("temporada");
      }
    };
    ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column_2, _function_2);
  }
  
  public void createGridActions(final Panel mainPanel) {
    final NotNullObservable elementSelected = new NotNullObservable("recetaSeleccionada");
    Panel _panel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    final Panel actionsPanel = _panel.setLayout(_horizontalLayout);
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Editar");
        it.<Object, ControlBuilder>bindEnabled(elementSelected);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actionsPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Borrar");
        it.<Object, ControlBuilder>bindEnabled(elementSelected);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Buscar");
        final Action _function = new Action() {
          public void execute() {
            UltimasConsultasAppModel _modelObject = UltimasConsultasWindow.this.getModelObject();
            _modelObject.search();
          }
        };
        it.onClick(_function);
        it.setAsDefault();
        it.disableOnError();
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actionsPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Limpiar");
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
    Button _button_2 = new Button(actionsPanel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Nuevo Celular");
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
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
  }
  
  /**
   * def void crearCelular() {
   * this.openDialog(new CrearCelularWindow(this))
   * }
   * 
   * def void modificarCelular() {
   * this.openDialog(new EditarCelularWindow(this, modelObject.celularSeleccionado))
   * }
   */
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        UltimasConsultasAppModel _modelObject = UltimasConsultasWindow.this.getModelObject();
        _modelObject.search();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
}
