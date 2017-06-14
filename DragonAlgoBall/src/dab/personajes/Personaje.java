package dab.personajes;

import java.util.List;
import java.util.LinkedList;
import dab.ataquesEspeciales.AtaqueEspecial;
import dab.equipo.Equipo;
import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;
import dab.interfaces.IContenedorDeFicha;
import dab.interfaces.IFichaMovible;
import dab.potenciadores.Potenciador;

public abstract class Personaje implements IProveedorDeKi, IFichaMovible{
	
	protected Equipo equipo; //falta agregar el equipo en todos los constructores. 
	protected IContenedorDeFicha coordenadas;
	protected List <Potenciador> potenciadores = new LinkedList<Potenciador>(); 
	protected int kiParaEspecial;   //puede estar aca porque no cambia con los estados.
	protected AtaqueEspecial spec;
	protected Estado estado;
	protected double vida;
	protected int ki = 0;
	protected int kiParaTransformar;

	/**********************************************************
							ATAQUE
	 **********************************************************/
	
	public boolean puedeAtacar(Personaje personaje) {
		int maxFila = coordenadas.getFila() + this.getAlcance();
		int maxColumna = coordenadas.getColumna() + this.getAlcance();
		IContenedorDeFicha coordenadasEnemigo = personaje.getPosicion();
		if(coordenadasEnemigo.getColumna() > maxColumna  ||  coordenadasEnemigo.getFila() > maxFila){
			return false;
		}
		//Ver si esto se puede chequear en otro lado como juego
		if(((Personaje) coordenadasEnemigo.getFicha()).getEquipo() == this.getEquipo()){
			return false;
		}
		return true;
	}
	
	public void atacarA(Personaje personaje){
		personaje.recibirAtaque(this.getPoder());
	}
	public boolean ataqueEspecialDisponible() {
		return this.getKi() >= kiParaEspecial;
	}
	
	public void ataqueEspecial(Personaje enemigo) {
		spec.lanzar(enemigo);
		this.modificarKi(-1*(kiParaEspecial));
	}

	/********************************************************
							MOVIMIENTO
	 ********************************************************/
		
	public boolean movimientoPosible(IContenedorDeFicha coordenadasDestino){
		//verifica que el movimiento se pueda hacer.
	
		int maxFila = coordenadas.getFila() + this.getVelocidad();
		int maxColumna = coordenadas.getColumna() + this.getVelocidad();
		//verifica que el movimiento se pueda hacer.
		if(coordenadasDestino.getColumna() > maxColumna  ||  coordenadasDestino.getFila() > maxFila){
			return false;
		}
		return true;
	}
		
	
	/**********************************************************
 						AGREGAR KI Y VIDA
	 **********************************************************/
	
	
	public void modificarKi(int aumento) {
		ki = ki + aumento;
	}

	public void agregarVida(double cantidad) {
		if(vida + cantidad > this.getVidaMaxima()){
			vida = this.getVidaMaxima();
		}else{
			vida += cantidad;
		}
	}
	
	/**********************************************************
	    				TRANSFORMAR Y TURNO
	***********************************************************/
	public void transformar(){
		this.estado = estado.transformar();
	}

	public boolean transformarDisponible(){
		return estado.transformarDisponible();
	}
	
	public void nuevoTurno() {
		for (Potenciador c: potenciadores){
			c.pasoUnTurno();
			this.modificarKi(c.getKiExtra());
			if (!c.estaActivo()){
				potenciadores.remove(c);
			}
		}
		// TODO Auto-generated method stub
		//aca hacer l
		
	}	
	
	/**********************************************************
						GETERS Y SETERS
	 **********************************************************/
	
	public double getVidaMaxima(){
		return estado.getVidaMaxima();
	}
	
	public double getPorcentajeDeVida(){
		//Devuelve el porcentaje de vida respecto del total
		return (this.getVida() / this.getVidaMaxima()) * 100;
	}

	public double getPoder() {
		
		double multiplicador = 1;
		for (Potenciador c: potenciadores){
			multiplicador *= c.getMultiplicadorPoderDePelea();
		}
		double poderActual = estado.getPoder(); 
		return poderActual *= multiplicador;
	}

	public int getAlcance() {
		
		double multiplicador = 1;
		for (Potenciador c: potenciadores){
			multiplicador *= c.getMultiplicadorAlcance();
		}
		int alcanceActual = estado.getAlcance();
		return (int) (alcanceActual*multiplicador);
		
	}

	public double getVida() {
		return vida;
	}
	
	public int getKi() {
		return ki;
	}
	

	public int getVelocidad() {
		int multiplicador = 1;
		for (Potenciador c: potenciadores){
			multiplicador *= c.getMultiplicadorVelocidad();
		}
		int velocidadActual = estado.getVelocidad(); //cambiarlo a double?
		return velocidadActual *= multiplicador; // *=;
	}

	public String getNombre() {
		return estado.getNombre();
	}

	public IContenedorDeFicha getPosicion(){
		return coordenadas;
	}
	
	public void setPosicion(IContenedorDeFicha coordenadas){
		this.coordenadas = coordenadas;
	}
	
	public Equipo getEquipo(){
		return equipo;
	}
	
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	private void recibirAtaque(double poderEnemigo) {
		if(poderEnemigo < this.getPoder()){
			poderEnemigo = (int)(poderEnemigo * 0.8);		
		}
		this.agregarVida(-poderEnemigo);	
	}
	
	public void agarrarPotenciador(Potenciador c){
		potenciadores.add(c);
		this.agregarVida(c.getVidaExtra());
	}
}
