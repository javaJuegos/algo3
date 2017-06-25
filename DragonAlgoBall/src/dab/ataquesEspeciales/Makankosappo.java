package dab.ataquesEspeciales;

import dab.personajes.Personaje;

public class Makankosappo extends AtaqueEspecial {
	
	/*Representa un Makankosappo*/
	public static String nombre = "Makankosappo";
	
	public Makankosappo(Personaje lanzador){
		super(lanzador);
		multiplicador = 1.25; //Si un pj lanza un Makankosappo, da�a x1.25
	}
	
}
