package vista;

import dab.juego.Juego;
import dab.usuario.Usuario;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane{
	Stage stage;
	BarraDeMenu barraDeMenu;

	BotoneraDerecha botoneraDerecha;
	

	VistaCaracteristicasPersonaje caracteristicasPersonaje;

	private Juego juego;
	private VistaTablero tablero;
	private int altoTablero = 10;
	private int anchoTablero = 11;

	
	public ContenedorPrincipal(Stage stage, Usuario usuariogz, Usuario usuarioenemigos){
		
		juego = new Juego(altoTablero, anchoTablero, usuariogz, usuarioenemigos);
		this.stage = stage;
		this.setMenu();
		this.setCaracteristicasPersonajeSeleccionado();
		this.setTablero();
		this.setBotoneraDerecha();
	}
	
	private void setBotoneraDerecha() {
		this.botoneraDerecha = new BotoneraDerecha(this.juego, this.tablero.getCeldas());
		this.setRight(this.botoneraDerecha);
	}
	
	private void setCaracteristicasPersonajeSeleccionado(){
		this.caracteristicasPersonaje = new VistaCaracteristicasPersonaje(null);
        this.setBottom(this.caracteristicasPersonaje);
	}

	private void setMenu(){
		this.barraDeMenu = new BarraDeMenu(this.stage);
        this.setTop(barraDeMenu);
	}
	
	private void setTablero(){
		this.tablero = new VistaTablero(this.juego,this.caracteristicasPersonaje);
		this.setCenter(this.tablero);
	}
	
	public BarraDeMenu getBarraDeMenu(){
		return this.barraDeMenu;
	}
}