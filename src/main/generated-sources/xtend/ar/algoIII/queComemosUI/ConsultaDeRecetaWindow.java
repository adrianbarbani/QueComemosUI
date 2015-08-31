package ar.algoIII.queComemosUI;

import ar.algoIII.queComemosUI.UltimasConsultasWindow;
import java.awt.Color;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ControlBuilder;
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
      Label _label = new Label(searchFormPanel);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText("Número");
          it.setForeground(Color.BLUE);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
      Label _label_1 = new Label(searchFormPanel);
      final Procedure1<Label> _function_1 = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText("Calorias");
          it.setForeground(Color.BLUE);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function_1);
      TextBox _textBox = new TextBox(searchFormPanel);
      _textBox.<Object, ControlBuilder>bindValueToProperty("nombre");
      TextBox _textBox_1 = new TextBox(searchFormPanel);
      _textBox_1.<Object, ControlBuilder>bindValueToProperty("nombre");
      Label _label_2 = new Label(searchFormPanel);
      _label_2.setText("Dificultad");
      Label _label_3 = new Label(searchFormPanel);
      _label_3.setText("Temporada");
      Selector<Dificultad> _selector = new Selector<Dificultad>(searchFormPanel);
      final Procedure1<Selector<Dificultad>> _function_2 = new Procedure1<Selector<Dificultad>>() {
        public void apply(final Selector<Dificultad> it) {
          it.allowNull(false);
          it.bindValueToProperty("dificultadSeleccionada");
        }
      };
      ObjectExtensions.<Selector<Dificultad>>operator_doubleArrow(_selector, _function_2);
      Selector<Dificultad> _selector_1 = new Selector<Dificultad>(searchFormPanel);
      final Procedure1<Selector<Dificultad>> _function_3 = new Procedure1<Selector<Dificultad>>() {
        public void apply(final Selector<Dificultad> it) {
          it.allowNull(false);
          it.bindValueToProperty("temporadaSeleccionada");
        }
      };
      ObjectExtensions.<Selector<Dificultad>>operator_doubleArrow(_selector_1, _function_3);
      Label _label_4 = new Label(searchFormPanel);
      _label_4.setText("Que contenga ingrediente");
      Label _label_5 = new Label(searchFormPanel);
      _label_5.setText("Aplicar filtros del usuario");
      TextBox _textBox_2 = new TextBox(searchFormPanel);
      _textBox_2.<Object, ControlBuilder>bindValueToProperty("nombre");
      CheckBox checkFavorita = new CheckBox(searchFormPanel);
      _xblockexpression = this.botonera(panel);
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
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Button _button_1 = new Button(panelBotonera);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Volver");
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
    }
    return _xblockexpression;
  }
}
