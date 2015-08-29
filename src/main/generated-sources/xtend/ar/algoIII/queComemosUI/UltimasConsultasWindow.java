package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Receta;
import ar.algoIII.queComemosUI.UltimasConsultasAppModel;
import java.awt.Color;
import org.apache.commons.collections15.Transformer;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.widgets.tables.labelprovider.BackgroundProvider;
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
  }
  
  public void describeResultsGrid(final Table<Receta> table) {
    Column<Receta> _column = new Column<Receta>(table);
    final Procedure1<Column<Receta>> _function = new Procedure1<Column<Receta>>() {
      public void apply(final Column<Receta> it) {
        it.setTitle("Nombre");
        it.setFixedSize(200);
        it.bindContentsToProperty("nombre");
        BackgroundProvider<Receta, Color> _bindBackground = it.bindBackground("sosPublica");
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
        _bindBackground.setTransformer(_function);
      }
    };
    ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column, _function);
    Column<Receta> _column_1 = new Column<Receta>(table);
    final Procedure1<Column<Receta>> _function_1 = new Procedure1<Column<Receta>>() {
      public void apply(final Column<Receta> it) {
        it.setTitle("Calorias");
        it.setFixedSize(100);
        it.bindContentsToProperty("caloriasReceta");
        BackgroundProvider<Receta, Color> _bindBackground = it.bindBackground("sosPublica");
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
        _bindBackground.setTransformer(_function);
      }
    };
    ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column_1, _function_1);
    Column<Receta> _column_2 = new Column<Receta>(table);
    final Procedure1<Column<Receta>> _function_2 = new Procedure1<Column<Receta>>() {
      public void apply(final Column<Receta> it) {
        it.setTitle("Dificultad");
        it.setFixedSize(200);
        it.bindContentsToProperty("dificultad");
        BackgroundProvider<Receta, Color> _bindBackground = it.bindBackground("sosPublica");
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
        _bindBackground.setTransformer(_function);
      }
    };
    ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column_2, _function_2);
    Column<Receta> _column_3 = new Column<Receta>(table);
    final Procedure1<Column<Receta>> _function_3 = new Procedure1<Column<Receta>>() {
      public void apply(final Column<Receta> it) {
        it.setTitle("Temporada");
        it.setFixedSize(200);
        it.bindContentsToProperty("temporada");
        BackgroundProvider<Receta, Color> _bindBackground = it.bindBackground("sosPublica");
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
        _bindBackground.setTransformer(_function);
      }
    };
    ObjectExtensions.<Column<Receta>>operator_doubleArrow(_column_3, _function_3);
  }
  
  protected void addActions(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from NotNullObservable to Receta");
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
    this.describeResultsGrid(table);
  }
  
  /**
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
