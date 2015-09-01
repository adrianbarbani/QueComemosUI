package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Comida;
import ar.algo.adriba.tp1.Fecha;
import ar.algo.adriba.tp1.Privada;
import ar.algo.adriba.tp1.Publica;
import ar.algo.adriba.tp1.Receta;
import ar.algo.adriba.tp1.RecetaBuilder;
import ar.algo.adriba.tp1.Rutina;
import ar.algo.adriba.tp1.Sexo;
import ar.algo.adriba.tp1.Usuario;
import ar.algo.adriba.tp1.UsuarioBuilder;

@SuppressWarnings("all")
public class RecetasObjectSet {
  private Comida carne = new Comida(0, "Carne", 1);
  
  private Comida harina = new Comida(0, "Harina", 20);
  
  private Comida huevo = new Comida(0, "Huevo", 3);
  
  private Comida panRallado = new Comida(0, "Pan Rallado", 50);
  
  private Comida verdura = new Comida(0, "Verdura", 12);
  
  private Comida queso = new Comida(0, "Muzzarella", 200);
  
  private Comida prepizza = new Comida(0, "Prepizza", 1);
  
  private Comida salsaDeTomate = new Comida(0, "Salsa de tomate", 200);
  
  private Comida sal = new Comida(18, "Sal", 0);
  
  private Comida salsaBlanca = new Comida(0, "Salsa Blanca", 400);
  
  private Comida lomo = new Comida(0, "Lomo", 200);
  
  private Comida garbanzos = new Comida(0, "Garbanzos", 500);
  
  private Comida limon = new Comida(10, "Limon", 0);
  
  private Comida ajo = new Comida(5, "Ajo", 0);
  
  private Comida jamon = new Comida(0, "Jamon", 100);
  
  private Comida oregano = new Comida(100, "Oregano", 0);
  
  private Comida azucar = new Comida(0, "azucar", 200);
  
  public Receta crearRecetas(final Usuario usuario) {
    Receta _xblockexpression = null;
    {
      RecetaBuilder _recetaBuilder = new RecetaBuilder();
      Publica _publica = new Publica();
      RecetaBuilder _tipoDeReceta = _recetaBuilder.tipoDeReceta(_publica);
      RecetaBuilder _nombreDelPlato = _tipoDeReceta.nombreDelPlato("Milanesas");
      RecetaBuilder _agregarIngrediente = _nombreDelPlato.agregarIngrediente(this.harina);
      RecetaBuilder _agregarIngrediente_1 = _agregarIngrediente.agregarIngrediente(this.huevo);
      RecetaBuilder _setearTemporadas = _agregarIngrediente_1.setearTemporadas("Todo el año");
      RecetaBuilder _agregarIngrediente_2 = _setearTemporadas.agregarIngrediente(this.panRallado);
      RecetaBuilder _agregarIngrediente_3 = _agregarIngrediente_2.agregarIngrediente(this.carne);
      RecetaBuilder _setearCalorias = _agregarIngrediente_3.setearCalorias(150);
      RecetaBuilder _setearDificultad = _setearCalorias.setearDificultad("Dificil");
      _setearDificultad.build();
      RecetaBuilder _recetaBuilder_1 = new RecetaBuilder();
      Publica _publica_1 = new Publica();
      RecetaBuilder _tipoDeReceta_1 = _recetaBuilder_1.tipoDeReceta(_publica_1);
      RecetaBuilder _nombreDelPlato_1 = _tipoDeReceta_1.nombreDelPlato("Milanesa napolitana");
      RecetaBuilder _agregarIngrediente_4 = _nombreDelPlato_1.agregarIngrediente(this.harina);
      RecetaBuilder _agregarIngrediente_5 = _agregarIngrediente_4.agregarIngrediente(this.huevo);
      RecetaBuilder _agregarIngrediente_6 = _agregarIngrediente_5.agregarIngrediente(this.panRallado);
      RecetaBuilder _agregarIngrediente_7 = _agregarIngrediente_6.agregarIngrediente(this.carne);
      RecetaBuilder _agregarIngrediente_8 = _agregarIngrediente_7.agregarIngrediente(this.queso);
      RecetaBuilder _agregarIngrediente_9 = _agregarIngrediente_8.agregarIngrediente(this.salsaDeTomate);
      RecetaBuilder _setearCalorias_1 = _agregarIngrediente_9.setearCalorias(8000);
      RecetaBuilder _setearTemporadas_1 = _setearCalorias_1.setearTemporadas("Todo el año");
      RecetaBuilder _setearDificultad_1 = _setearTemporadas_1.setearDificultad("Dificil");
      _setearDificultad_1.build();
      RecetaBuilder _recetaBuilder_2 = new RecetaBuilder();
      Publica _publica_2 = new Publica();
      RecetaBuilder _tipoDeReceta_2 = _recetaBuilder_2.tipoDeReceta(_publica_2);
      RecetaBuilder _nombreDelPlato_2 = _tipoDeReceta_2.nombreDelPlato("Sopa de Verdura");
      RecetaBuilder _agregarIngrediente_10 = _nombreDelPlato_2.agregarIngrediente(this.verdura);
      RecetaBuilder _agregarIngrediente_11 = _agregarIngrediente_10.agregarIngrediente(this.sal);
      RecetaBuilder _setearCalorias_2 = _agregarIngrediente_11.setearCalorias(200);
      RecetaBuilder _setearTemporadas_2 = _setearCalorias_2.setearTemporadas("Invierno");
      RecetaBuilder _setearDificultad_2 = _setearTemporadas_2.setearDificultad("Dificil");
      _setearDificultad_2.build();
      RecetaBuilder _recetaBuilder_3 = new RecetaBuilder();
      Publica _publica_3 = new Publica();
      RecetaBuilder _tipoDeReceta_3 = _recetaBuilder_3.tipoDeReceta(_publica_3);
      RecetaBuilder _nombreDelPlato_3 = _tipoDeReceta_3.nombreDelPlato("Pizza de muzzarella");
      RecetaBuilder _agregarIngrediente_12 = _nombreDelPlato_3.agregarIngrediente(this.prepizza);
      RecetaBuilder _agregarIngrediente_13 = _agregarIngrediente_12.agregarIngrediente(this.salsaDeTomate);
      RecetaBuilder _agregarIngrediente_14 = _agregarIngrediente_13.agregarIngrediente(this.oregano);
      RecetaBuilder _agregarIngrediente_15 = _agregarIngrediente_14.agregarIngrediente(this.queso);
      RecetaBuilder _setearTemporadas_3 = _agregarIngrediente_15.setearTemporadas("Todo el año");
      RecetaBuilder _setearDificultad_3 = _setearTemporadas_3.setearDificultad("Facil");
      RecetaBuilder _setearCalorias_3 = _setearDificultad_3.setearCalorias(500);
      _setearCalorias_3.build();
      RecetaBuilder _recetaBuilder_4 = new RecetaBuilder();
      Publica _publica_4 = new Publica();
      RecetaBuilder _tipoDeReceta_4 = _recetaBuilder_4.tipoDeReceta(_publica_4);
      RecetaBuilder _nombreDelPlato_4 = _tipoDeReceta_4.nombreDelPlato(
        "Pizza de verdura y salsa blanca");
      RecetaBuilder _agregarIngrediente_16 = _nombreDelPlato_4.agregarIngrediente(this.prepizza);
      RecetaBuilder _agregarIngrediente_17 = _agregarIngrediente_16.agregarIngrediente(this.salsaDeTomate);
      RecetaBuilder _agregarIngrediente_18 = _agregarIngrediente_17.agregarIngrediente(this.queso);
      RecetaBuilder _agregarIngrediente_19 = _agregarIngrediente_18.agregarIngrediente(this.salsaBlanca);
      RecetaBuilder _agregarIngrediente_20 = _agregarIngrediente_19.agregarIngrediente(this.verdura);
      RecetaBuilder _setearTemporadas_4 = _agregarIngrediente_20.setearTemporadas("Todo el año");
      RecetaBuilder _setearCalorias_4 = _setearTemporadas_4.setearCalorias(560);
      RecetaBuilder _setearDificultad_4 = _setearCalorias_4.setearDificultad("Dificil");
      _setearDificultad_4.build();
      RecetaBuilder _recetaBuilder_5 = new RecetaBuilder();
      Publica _publica_5 = new Publica();
      RecetaBuilder _tipoDeReceta_5 = _recetaBuilder_5.tipoDeReceta(_publica_5);
      RecetaBuilder _nombreDelPlato_5 = _tipoDeReceta_5.nombreDelPlato("Lomo a la Plancha");
      RecetaBuilder _agregarIngrediente_21 = _nombreDelPlato_5.agregarIngrediente(this.lomo);
      RecetaBuilder _setearCalorias_5 = _agregarIngrediente_21.setearCalorias(300);
      RecetaBuilder _setearTemporadas_5 = _setearCalorias_5.setearTemporadas("Otoño");
      RecetaBuilder _setearDificultad_5 = _setearTemporadas_5.setearDificultad("Media");
      _setearDificultad_5.build();
      RecetaBuilder _recetaBuilder_6 = new RecetaBuilder();
      Privada _privada = new Privada(usuario);
      RecetaBuilder _tipoDeReceta_6 = _recetaBuilder_6.tipoDeReceta(_privada);
      RecetaBuilder _nombreDelPlato_6 = _tipoDeReceta_6.nombreDelPlato(
        "Hummus de garbanzo");
      RecetaBuilder _agregarIngrediente_22 = _nombreDelPlato_6.agregarIngrediente(this.garbanzos);
      RecetaBuilder _agregarIngrediente_23 = _agregarIngrediente_22.agregarIngrediente(this.limon);
      RecetaBuilder _agregarIngrediente_24 = _agregarIngrediente_23.agregarIngrediente(this.ajo);
      RecetaBuilder _setearCalorias_6 = _agregarIngrediente_24.setearCalorias(600);
      _xblockexpression = _setearCalorias_6.build();
    }
    return _xblockexpression;
  }
  
  private Fecha fechaValida = new Fecha((System.currentTimeMillis() - (((24 * 60) * 60) * 1000)));
  
  public Usuario crearUsuario() {
    UsuarioBuilder _usuarioBuilder = new UsuarioBuilder();
    UsuarioBuilder _agregarPeso = _usuarioBuilder.agregarPeso(52);
    UsuarioBuilder _agregarAltura = _agregarPeso.agregarAltura(1.64);
    UsuarioBuilder _agregarSexo = _agregarAltura.agregarSexo(Sexo.FEMENINO);
    UsuarioBuilder _agregarNombre = _agregarSexo.agregarNombre("Esteban");
    UsuarioBuilder _agregarFechaNacimiento = _agregarNombre.agregarFechaNacimiento(this.fechaValida);
    Rutina _rutina = new Rutina(61, true);
    UsuarioBuilder _agregarRutina = _agregarFechaNacimiento.agregarRutina(_rutina);
    return _agregarRutina.build();
  }
  
  public final static RecetasObjectSet INSTANCE = new RecetasObjectSet();
}
