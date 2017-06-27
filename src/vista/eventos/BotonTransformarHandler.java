package vista.eventos;

import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorSonidosEspeciales;
import vista.VistaCaracteristicasPersonaje;
import vista.VistaTablero;

public class BotonTransformarHandler implements EventHandler<MouseEvent>{
	
	private Personaje personaje;
	private VistaCaracteristicasPersonaje vista;
	private Ajustes ajustesSonidosEspeciales;
	private VistaTablero vistaTablero;
	
	public BotonTransformarHandler(Personaje personaje, VistaCaracteristicasPersonaje vista, Ajustes ajustesSonidosEspeciales,
			VistaTablero vistaTablero){
		this.personaje = personaje;
		this.vista = vista;
		this.ajustesSonidosEspeciales = ajustesSonidosEspeciales;
		this.vistaTablero = vistaTablero;
	}
	
	
	@Override
	public void handle(MouseEvent event) {
		
		personaje.transformar();
		vista.dibujar(null, vistaTablero);
		vista.dibujar(personaje, vistaTablero);
		vistaTablero.dibujarTableroSinNingunaSeleccion();
		if (ajustesSonidosEspeciales.estaActivo()){
			ReproductorSonidosEspeciales.reproducir("transformar");
		}
		
	}

}
