package ar.algoIII.queComemosUI

import ar.algo.adriba.tp1.Fecha
import ar.algo.adriba.tp1.Rutina
import ar.algo.adriba.tp1.Sexo
import ar.algo.adriba.tp1.UsuarioBuilder

class UsuariosObjectSet {
	
		Fecha fechaValida = new Fecha(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
		
		def crearUsuarios(){
	
		new UsuarioBuilder().agregarPeso(52).agregarAltura(1.64).agregarSexo(Sexo.FEMENINO).
			agregarNombre("Esteban").agregarFechaNacimiento(fechaValida).agregarRutina(new Rutina(61, true))
			.build("homero")

		new UsuarioBuilder().agregarPeso(52).agregarAltura(1.64).agregarSexo(Sexo.FEMENINO).
			agregarNombre("Marina").agregarFechaNacimiento(fechaValida).agregarRutina(new Rutina(61, true))
			.build("marina")

		new UsuarioBuilder().agregarPeso(52).agregarAltura(1.64).agregarSexo(Sexo.MASCULINO).
			agregarNombre("Carlos").agregarFechaNacimiento(fechaValida).agregarRutina(new Rutina(61, true))
			.build("boton")

		new UsuarioBuilder().agregarPeso(67).agregarAltura(1.91).
			agregarSexo(Sexo.MASCULINO).agregarNombre("Adrian").agregarFechaNacimiento(fechaValida).
			agregarRutina(new Rutina(74, true))
			.build("pacquiao")

		new UsuarioBuilder().agregarPeso(80).agregarAltura(1.74).
			agregarSexo(Sexo.MASCULINO).agregarNombre("Federico").agregarFechaNacimiento(fechaValida).
			agregarRutina(new Rutina(82, true))			
			.build("bob")

		new UsuarioBuilder().agregarPeso(1500).agregarAltura(1.44).
			agregarSexo(Sexo.FEMENINO).agregarNombre("Esteban").agregarFechaNacimiento(fechaValida).
			agregarRutina(new Rutina(10, true))		
			.build("barovero")
		
}

	public static val INSTANCE = new UsuariosObjectSet

}