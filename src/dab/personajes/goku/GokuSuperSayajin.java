package dab.personajes.goku;

public class GokuSuperSayajin extends GokuKaioKen{
	/*Representa a la segunda transformacion de Goku*/
	
	
	public GokuSuperSayajin(){
		vida = 500;
		poder = 60;
		alcance = 4;
		ki = 0;
		velocidad = 5;
		nombre = "Goku Super Sayajin";
	}
	@Override
	public boolean transformarDisponible() {
		return false;
	}

}
