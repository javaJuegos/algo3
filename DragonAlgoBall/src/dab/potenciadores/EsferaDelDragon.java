package dab.potenciadores;

public class EsferaDelDragon extends Potenciador {

	public EsferaDelDragon(){
		
		nombre = "Esfera del Dragon";
		multiplicadorPoderDePelea = 1.25;
		multiplicadorVelocidad = 1;
		vidaExtra = 0;
		duracion = 3; //1 mas para que pueda usarlo 2 turnos
		multiplicadorAlcance = 1;
		multiplicadorDistanciaAtaque = 1;
		kiExtra = 0;
	}
	
	@Override
	public double getMultiplicadorVelocidad() {
		return multiplicadorVelocidad;
	}

	@Override
	public double getMultiplicadorPoderDePelea() {
		return multiplicadorPoderDePelea;
	}

	@Override
	public double getVidaExtra() {
		return vidaExtra;
	}

	@Override
	public int getMultiplicadorAlcance() {
		return multiplicadorAlcance;
	}

	@Override
	public int getMultiplicadorDistanciaAtaque() {
		return multiplicadorDistanciaAtaque;
	}

	@Override
	public int getKiExtra() {
		return kiExtra;
	}
}