package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.RepoDeTemporadas;
import ar.algo.adriba.tp1.RepoDificultades;
import ar.algoIII.queComemosUI.UltimasConsultasAppModel;
import ar.algoIII.queComemosUI.UltimasConsultasWindow;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import queComemos.entrega3.dominio.Dificultad;

@SuppressWarnings("all")
public class ConsultaDeRecetaWindow extends UltimasConsultasWindow {
  public ConsultaDeRecetaWindow(final WindowOwner parent) {
    super(parent);
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    super.createMainTemplate(mainPanel);
    this.setTitle("Consulta de Receta");
    this.setTaskDescription("");
  }
  
  public Object panelBusqueda(final Panel panel) {
    Button _xblockexpression = null;
    {
      final Panel searchFormPanel = new Panel(panel);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      searchFormPanel.setLayout(_columnLayout);
      final Panel panelIzquierdo = new Panel(searchFormPanel);
      final Panel panelDerecho = new Panel(searchFormPanel);
      this.contenidoPanelIzq(panelIzquierdo);
      this.contenidoPanelDerecho(panelDerecho);
      _xblockexpression = this.botonera(panel);
    }
    return _xblockexpression;
  }
  
  public Binding<Object, Control, ControlBuilder> contenidoPanelDerecho(final Panel panelDerecho) {
    Binding<Object, Control, ControlBuilder> _xblockexpression = null;
    {
      Label _label = new Label(panelDerecho);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText("Calorias");
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
      final Panel panelCalorias = new Panel(panelDerecho);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      panelCalorias.setLayout(_horizontalLayout);
      Label _label_1 = new Label(panelCalorias);
      _label_1.setText("Desde");
      TextBox _textBox = new TextBox(panelCalorias);
      final Procedure1<TextBox> _function_1 = new Procedure1<TextBox>() {
        public void apply(final TextBox it) {
          it.<Object, ControlBuilder>bindValueToProperty("caloriasDesde");
          it.setWidth(50);
        }
      };
      ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function_1);
      Label _label_2 = new Label(panelCalorias);
      _label_2.setText("Hasta");
      TextBox _textBox_1 = new TextBox(panelCalorias);
      final Procedure1<TextBox> _function_2 = new Procedure1<TextBox>() {
        public void apply(final TextBox it) {
          it.<Object, ControlBuilder>bindValueToProperty("caloriasHasta");
          it.setWidth(50);
        }
      };
      ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_2);
      Label _label_3 = new Label(panelDerecho);
      _label_3.setText("Temporada");
      Selector<String> _selector = new Selector<String>(panelDerecho);
      final Procedure1<Selector<String>> _function_3 = new Procedure1<Selector<String>>() {
        public void apply(final Selector<String> it) {
          it.allowNull(true);
          it.bindValueToProperty("temporadaSeleccionada");
          RepoDeTemporadas _instance = RepoDeTemporadas.getInstance();
          ObservableProperty<Object> _observableProperty = new ObservableProperty<Object>(_instance, "todasLasTemporadas");
          it.<Object>bindItems(_observableProperty);
        }
      };
      ObjectExtensions.<Selector<String>>operator_doubleArrow(_selector, _function_3);
      Label _label_4 = new Label(panelDerecho);
      _label_4.setText("Aplicar filtros del usuario");
      CheckBox checkFavorita = new CheckBox(panelDerecho);
      _xblockexpression = checkFavorita.<Object, ControlBuilder>bindValueToProperty("filtrosAplicados");
    }
    return _xblockexpression;
  }
  
  public Binding<Object, Control, ControlBuilder> contenidoPanelIzq(final Panel panelIzquierdo) {
    Binding<Object, Control, ControlBuilder> _xblockexpression = null;
    {
      Label _label = new Label(panelIzquierdo);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText("Nombre");
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
      TextBox _textBox = new TextBox(panelIzquierdo);
      _textBox.<Object, ControlBuilder>bindValueToProperty("nombre");
      Label _label_1 = new Label(panelIzquierdo);
      _label_1.setText("Dificultad");
      Selector<Dificultad> _selector = new Selector<Dificultad>(panelIzquierdo);
      final Procedure1<Selector<Dificultad>> _function_1 = new Procedure1<Selector<Dificultad>>() {
        public void apply(final Selector<Dificultad> it) {
          it.allowNull(true);
          it.bindValueToProperty("dificultadSeleccionada");
          RepoDificultades _instance = RepoDificultades.getInstance();
          ObservableProperty<Object> _observableProperty = new ObservableProperty<Object>(_instance, "todasLasDificultades");
          it.<Object>bindItems(_observableProperty);
        }
      };
      ObjectExtensions.<Selector<Dificultad>>operator_doubleArrow(_selector, _function_1);
      Label _label_2 = new Label(panelIzquierdo);
      _label_2.setText("Que contenga ingrediente");
      TextBox _textBox_1 = new TextBox(panelIzquierdo);
      _xblockexpression = _textBox_1.<Object, ControlBuilder>bindValueToProperty("ingredienteABuscar");
    }
    return _xblockexpression;
  }
  
  public Button botonera(final Panel panel) {
    Button _xblockexpression = null;
    {
      final Panel panelBotonera = new Panel(panel);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      panelBotonera.setLayout(_horizontalLayout);
      Button _button = new Button(panelBotonera);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Buscar");
          final Action _function = new Action() {
            public void execute() {
              UltimasConsultasAppModel _modelObject = ConsultaDeRecetaWindow.this.getModelObject();
              _modelObject.buscar();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Button _button_1 = new Button(panelBotonera);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Volver");
          final Action _function = new Action() {
            public void execute() {
              UltimasConsultasAppModel _modelObject = ConsultaDeRecetaWindow.this.getModelObject();
              _modelObject.clear();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
    }
    return _xblockexpression;
  }
}
