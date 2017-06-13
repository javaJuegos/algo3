package dab.personajes.Piccolo;
import java.util.Iterator;

import dab.ataquesEspeciales.Makankosappo;
import dab.estados.Estado;
import dab.estados.piccolo.PiccoloBase;
import dab.estados.piccolo.PiccoloFortalecido;
import dab.estados.piccolo.PiccoloProtector;
import dab.personajes.Personaje;

public class Piccolo extends Personaje{
	
	public double porcetanejVidaGohanParaTransformar = 0.20;
	
	public Piccolo(){ 
		spec = new Makankosappo (this);
		kiParaEspecial = 10;
		estado = new PiccoloBase();
		vida = estado.getVidaMaxima();
		estados.add(new PiccoloBase());
		estados.add(new PiccoloFortalecido());
		estados.add(new PiccoloProtector());
		Iterator<Estado> iter = estados.iterator();
		setIter(iter);
	}


	public boolean transformarDisponible() {
		if(super.transformarDisponible()){
			if(estado.getClass() == PiccoloFortalecido.class){
				Personaje gohan = equipo.obtenerPersonaje("Gohan");
				if(gohan.getVida() / gohan.getVidaMaxima() >= porcetanejVidaGohanParaTransformar){
					return false;
				}
			}
			return true;
		}
		return false;  //revisar la logica, son las 3 am
	}

}