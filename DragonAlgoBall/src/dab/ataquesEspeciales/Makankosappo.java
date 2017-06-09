package dab.ataquesEspeciales;

import dab.personaje.Personaje;

public class Makankosappo extends AtaqueEspecial {
	
	/*Representa un Makankosappo*/
	
	private double multiplicador = 1.5; //Si un pj lanza un Makankosappo, da�a x1.25

	@Override
	public void lanzar(int poderPelea, Personaje enemigo){
		enemigo.agregarHp((int)(-multiplicador*poderPelea));
	}
}
