package ar.algoIII.queComemosUI;

import ar.algo.adriba.tp1.Fecha;
import ar.algo.adriba.tp1.Rutina;
import ar.algo.adriba.tp1.Sexo;
import ar.algo.adriba.tp1.Usuario;
import ar.algo.adriba.tp1.UsuarioBuilder;

@SuppressWarnings("all")
public class UsuariosObjectSet {
  private Fecha fechaValida = new Fecha((System.currentTimeMillis() - (((24 * 60) * 60) * 1000)));
  
  public Usuario crearUsuarios() {
    Usuario _xblockexpression = null;
    {
      UsuarioBuilder _usuarioBuilder = new UsuarioBuilder();
      UsuarioBuilder _agregarPeso = _usuarioBuilder.agregarPeso(52);
      UsuarioBuilder _agregarAltura = _agregarPeso.agregarAltura(1.64);
      UsuarioBuilder _agregarSexo = _agregarAltura.agregarSexo(Sexo.FEMENINO);
      UsuarioBuilder _agregarNombre = _agregarSexo.agregarNombre("Javier");
      UsuarioBuilder _agregarFechaNacimiento = _agregarNombre.agregarFechaNacimiento(this.fechaValida);
      Rutina _rutina = new Rutina(61, true);
      UsuarioBuilder _agregarRutina = _agregarFechaNacimiento.agregarRutina(_rutina);
      _agregarRutina.build("javi");
      UsuarioBuilder _usuarioBuilder_1 = new UsuarioBuilder();
      UsuarioBuilder _agregarPeso_1 = _usuarioBuilder_1.agregarPeso(52);
      UsuarioBuilder _agregarAltura_1 = _agregarPeso_1.agregarAltura(1.64);
      UsuarioBuilder _agregarSexo_1 = _agregarAltura_1.agregarSexo(Sexo.FEMENINO);
      UsuarioBuilder _agregarNombre_1 = _agregarSexo_1.agregarNombre("Marina");
      UsuarioBuilder _agregarFechaNacimiento_1 = _agregarNombre_1.agregarFechaNacimiento(this.fechaValida);
      Rutina _rutina_1 = new Rutina(61, true);
      UsuarioBuilder _agregarRutina_1 = _agregarFechaNacimiento_1.agregarRutina(_rutina_1);
      _agregarRutina_1.build("marina");
      UsuarioBuilder _usuarioBuilder_2 = new UsuarioBuilder();
      UsuarioBuilder _agregarPeso_2 = _usuarioBuilder_2.agregarPeso(52);
      UsuarioBuilder _agregarAltura_2 = _agregarPeso_2.agregarAltura(1.64);
      UsuarioBuilder _agregarSexo_2 = _agregarAltura_2.agregarSexo(Sexo.MASCULINO);
      UsuarioBuilder _agregarNombre_2 = _agregarSexo_2.agregarNombre("Juancho");
      UsuarioBuilder _agregarFechaNacimiento_2 = _agregarNombre_2.agregarFechaNacimiento(this.fechaValida);
      Rutina _rutina_2 = new Rutina(61, true);
      UsuarioBuilder _agregarRutina_2 = _agregarFechaNacimiento_2.agregarRutina(_rutina_2);
      _agregarRutina_2.build("boton");
      UsuarioBuilder _usuarioBuilder_3 = new UsuarioBuilder();
      UsuarioBuilder _agregarPeso_3 = _usuarioBuilder_3.agregarPeso(67);
      UsuarioBuilder _agregarAltura_3 = _agregarPeso_3.agregarAltura(1.91);
      UsuarioBuilder _agregarSexo_3 = _agregarAltura_3.agregarSexo(Sexo.MASCULINO);
      UsuarioBuilder _agregarNombre_3 = _agregarSexo_3.agregarNombre("Adrian");
      UsuarioBuilder _agregarFechaNacimiento_3 = _agregarNombre_3.agregarFechaNacimiento(this.fechaValida);
      Rutina _rutina_3 = new Rutina(74, true);
      UsuarioBuilder _agregarRutina_3 = _agregarFechaNacimiento_3.agregarRutina(_rutina_3);
      _agregarRutina_3.build("a");
      UsuarioBuilder _usuarioBuilder_4 = new UsuarioBuilder();
      UsuarioBuilder _agregarPeso_4 = _usuarioBuilder_4.agregarPeso(80);
      UsuarioBuilder _agregarAltura_4 = _agregarPeso_4.agregarAltura(1.74);
      UsuarioBuilder _agregarSexo_4 = _agregarAltura_4.agregarSexo(Sexo.MASCULINO);
      UsuarioBuilder _agregarNombre_4 = _agregarSexo_4.agregarNombre("Federico");
      UsuarioBuilder _agregarFechaNacimiento_4 = _agregarNombre_4.agregarFechaNacimiento(this.fechaValida);
      Rutina _rutina_4 = new Rutina(82, true);
      UsuarioBuilder _agregarRutina_4 = _agregarFechaNacimiento_4.agregarRutina(_rutina_4);
      _agregarRutina_4.build("messi");
      UsuarioBuilder _usuarioBuilder_5 = new UsuarioBuilder();
      UsuarioBuilder _agregarPeso_5 = _usuarioBuilder_5.agregarPeso(1500);
      UsuarioBuilder _agregarAltura_5 = _agregarPeso_5.agregarAltura(1.44);
      UsuarioBuilder _agregarSexo_5 = _agregarAltura_5.agregarSexo(Sexo.FEMENINO);
      UsuarioBuilder _agregarNombre_5 = _agregarSexo_5.agregarNombre("Ariel");
      UsuarioBuilder _agregarFechaNacimiento_5 = _agregarNombre_5.agregarFechaNacimiento(this.fechaValida);
      Rutina _rutina_5 = new Rutina(10, true);
      UsuarioBuilder _agregarRutina_5 = _agregarFechaNacimiento_5.agregarRutina(_rutina_5);
      _xblockexpression = _agregarRutina_5.build("pacman");
    }
    return _xblockexpression;
  }
  
  public final static UsuariosObjectSet INSTANCE = new UsuariosObjectSet();
}
