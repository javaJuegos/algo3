package dab.personajes.Goku;

import dab.ataquesEspeciales.Kamehameha;
import dab.equipo.Equipo;
import dab.estados.goku.GokuBase;
import dab.personajes.Personaje;
import dab.potenciadores.Furia;

public class Goku extends Personaje{
	
	public static int identificador = 4;
	
	public Goku(){ 
		ataqueEspecial = new Kamehameha(this);
		kiParaEspecial = 20;
		kiParaTransformar = 20;
		estado = new GokuBase(this);
		vida = estado.getVidaMaxima();
		this.interactuarAlContacto(new Furia(this));
	}
	
	public Goku(Equipo equipo){
		this();
		this.equipo = equipo;
	}
	
	@Override
	public Integer getIdentificador(){
		return identificador;
	}
}
