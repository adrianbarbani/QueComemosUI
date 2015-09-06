package ar.algoIII.queComemosUI

import org.uqbar.arena.aop.windows.TransactionalDialog
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.WindowOwner

class CopiarRecetaWindow extends TransactionalDialog<CopiarRecetaAppModel> {
	
	new(WindowOwner owner, CopiarRecetaAppModel model) {
		super(owner, model)
		title= "Copiar Receta"
	}
	
	override protected createFormPanel(Panel mainPanel) {
		val primerLinea = new Panel(mainPanel).layout = new HorizontalLayout
		val segundaLinea = new Panel(mainPanel).layout = new HorizontalLayout
		
		new Label(primerLinea).text = "Receta:"
		new Label(primerLinea).bindValueToProperty("receta.nombreDelPlato")
		
		new Label(segundaLinea).text = "Nombre de copia:"
		new TextBox(segundaLinea).bindValueToProperty("nombreDeCopia")		
		botonCopiar(mainPanel)
	}
	
	
	
	protected def botonCopiar(Panel mainPanel) {
		new Button(mainPanel) => [
			caption = "Copiar"
			onClick = [|
				modelObject.copiarReceta
			]
			setAsDefault
			disableOnError
		]
	}
	
}