package dab.ataquesEspeciales;

import dab.personajes.Personaje;

public class Masenko extends AtaqueEspecial {
	
	public Masenko(Personaje lanzador){
		super(lanzador);
		multiplicador = 1.25; //Si un pj lanza un Masenko, da�a x1.25
	}

}
