package ar.algoIII.queComemosUI

import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner

class LoginWindow extends SimpleWindow<LoginAppModel> {

	new(WindowOwner parent) {
		super(parent, new LoginAppModel)
		title = "Login"
	}
	


	override protected addActions(Panel actionsPanel) {
		val panel = new Panel(actionsPanel).layout = new HorizontalLayout

		new Button(panel) => [
			caption = "Ok"
			onClick = [|
				modelObject.autorizarLogin
				//this.entrar
			]
			setAsDefault
			disableOnError
		]

		new Button(panel) => [
			caption = "Cancelar"
			onClick = [|modelObject.clear]
		]
	}

	override protected createFormPanel(Panel mainPanel) {
		val panelTexto = new Panel(mainPanel)
		
		new Label(panelTexto).text="Usuario"
		new TextBox(panelTexto) =>[
			bindValueToProperty("nombreUsuarioABuscar")
			width = 150
			]
		
		new Label(panelTexto).text="Contraseña"
		new TextBox(panelTexto) =>[
			bindValueToProperty("contrasenia")
			width = 150
			
			]	
	}

	/*def void entrar() {
		this.openDialog(
			new UltimasConsultasWindow(this, modelObject.usuarioLogin))
	}*/
}
