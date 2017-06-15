package dab.potenciadores;

public class NubeVoladora extends Potenciador {
	
	public NubeVoladora(){
		nombre = "Nube Voladora";
		duracionTurnos = 3;
		duracionAtaques = Double.POSITIVE_INFINITY;
		multiplicadorVelocidad = 2;
		multiplicadorPoderDePelea = 1;
		vidaExtra = 0;
		multiplicadorDistanciaAtaque = 1;
		multiplicadorAlcance = 1;
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

	@Override
	public boolean estaActivo() {
		return duracionTurnos > 0;
	}

}