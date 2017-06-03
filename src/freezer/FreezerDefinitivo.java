package freezer;

public class FreezerDefinitivo extends Freezer {
	//ultima transformacion de freezer
	
	public FreezerDefinitivo(){
		vida = 400;
		poder = 50;
		alcance = 3;
		ki = 0;
		velocidad = 6;
		nombre = "Freezer Definitivo";
		kiParaTransformar = 50;
	}
		


	
	@Override
	public boolean transformarDisponible(){
		return false;
	}
}
