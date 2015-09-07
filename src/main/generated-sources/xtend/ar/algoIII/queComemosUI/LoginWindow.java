package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Usuario;
import ar.algoIII.queComemosUI.ConsultaDeRecetaWindow;
import ar.algoIII.queComemosUI.LoginAppModel;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class LoginWindow extends SimpleWindow<LoginAppModel> {
  public LoginWindow(final WindowOwner parent) {
    super(parent, new LoginAppModel());
    this.setTitle("Login");
  }
  
  protected void addActions(final Panel actionsPanel) {
    Panel _panel = new Panel(actionsPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    final Panel panel = _panel.setLayout(_horizontalLayout);
    Button _button = new Button(panel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Ok");
        final Action _function = new Action() {
          public void execute() {
            LoginAppModel _modelObject = LoginWindow.this.getModelObject();
            _modelObject.autorizarLogin();
            LoginWindow.this.entrar();
          }
        };
        it.onClick(_function);
        it.setAsDefault();
        it.disableOnError();
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(panel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Cancelar");
        final Action _function = new Action() {
          public void execute() {
            LoginAppModel _modelObject = LoginWindow.this.getModelObject();
            _modelObject.clear();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    final Panel panelTexto = new Panel(mainPanel);
    Label _label = new Label(panelTexto);
    _label.setText("Usuario");
    TextBox _textBox = new TextBox(panelTexto);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("nombreUsuarioABuscar");
        it.setWidth(150);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    Label _label_1 = new Label(panelTexto);
    _label_1.setText("Contraseña");
    TextBox _textBox_1 = new TextBox(panelTexto);
    final Procedure1<TextBox> _function_1 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("contrasenia");
        it.setWidth(150);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_1);
  }
  
  public void entrar() {
    LoginAppModel _modelObject = this.getModelObject();
    Usuario _usuarioLogin = _modelObject.getUsuarioLogin();
    ConsultaDeRecetaWindow _consultaDeRecetaWindow = new ConsultaDeRecetaWindow(this, _usuarioLogin);
    this.openDialog(_consultaDeRecetaWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    dialog.open();
  }
}
