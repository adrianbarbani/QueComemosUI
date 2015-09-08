package ar.algoIII.queComemosUI;

import ar.algoIII.queComemosUI.CopiarRecetaAppModel;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class CopiarRecetaWindow extends TransactionalDialog<CopiarRecetaAppModel> {
  public CopiarRecetaWindow(final WindowOwner owner, final CopiarRecetaAppModel model) {
    super(owner, model);
    this.setTitle("Copiar Receta");
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Panel _panel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    final Panel primerLinea = _panel.setLayout(_horizontalLayout);
    Panel _panel_1 = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
    final Panel segundaLinea = _panel_1.setLayout(_horizontalLayout_1);
    Label _label = new Label(primerLinea);
    _label.setText("Receta:");
    Label _label_1 = new Label(primerLinea);
    _label_1.<Object, ControlBuilder>bindValueToProperty("receta.nombreDelPlato");
    Label _label_2 = new Label(segundaLinea);
    _label_2.setText("Nombre de copia:");
    TextBox _textBox = new TextBox(segundaLinea);
    _textBox.<Object, ControlBuilder>bindValueToProperty("nombreDeCopia");
    this.botonCopiar(mainPanel);
  }
  
  protected Button botonCopiar(final Panel mainPanel) {
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Copiar");
        final Action _function = new Action() {
          public void execute() {
            CopiarRecetaAppModel _modelObject = CopiarRecetaWindow.this.getModelObject();
            _modelObject.copiarReceta();
            CopiarRecetaWindow.this.accept();
          }
        };
        it.onClick(_function);
        it.setAsDefault();
        it.disableOnError();
      }
    };
    return ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
}
