package vista;

import dab.equipo.Equipo;
import dab.juego.Juego;
import dab.personajes.Freezer.Freezer;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;
import dab.usuario.Usuario;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;

public class ContenedorPrincipal extends BorderPane{
	Stage stage;
	BotoneraDerecha botoneraDerecha;
	VistaCaracteristicasPersonaje caracteristicasPersonaje;

	private Juego juego;
	private VistaTablero vistaTablero;
	private int altoTablero = 10;
	private int anchoTablero = 18;
	private VistaInferiorPersonajes vistaInferiorPersonajes;
	private Ajustes ajustesMusicaDeBatalla;
	private Ajustes ajustesEfectosDePersonajes;
	private ReproductorDeSonidos reproductorMusicaDeBatalla;
	private Ajustes ajustesMusicaEnding;
	
	public ContenedorPrincipal(Stage stage, TextField campoNombreUsuarioGuerreros,
			TextField campoNombreUsuarioEnemigos, ReproductorDeSonidos reproductorMusicaDeBatalla, Ajustes ajustesMusicaDeBatalla, 
			Ajustes ajustesEfectosDePersonajes, Ajustes ajustesMusicaEnding){
		this.prepararJuego(campoNombreUsuarioGuerreros, campoNombreUsuarioEnemigos);
		this.ajustesEfectosDePersonajes = ajustesEfectosDePersonajes;
		this.ajustesMusicaDeBatalla = ajustesMusicaDeBatalla;
		this.ajustesMusicaEnding = ajustesMusicaEnding;
	
		this.reproductorMusicaDeBatalla = reproductorMusicaDeBatalla;
		this.stage = stage;
		this.setCaracteristicasPersonajeSeleccionado();
		this.setTablero();
		this.setBotoneraDerecha();
	}

	private void prepararJuego(TextField campoNombreUsuarioGuerreros, TextField campoNombreUsuarioEnemigos) {
		String nombreUsuarioGuerreros = campoNombreUsuarioGuerreros.getText();
		String nombreUsuarioEnemigos = campoNombreUsuarioEnemigos.getText();
		juego = new Juego(altoTablero, anchoTablero, 
				new Usuario(new Equipo("Guerreros Z", new Goku(), new Gohan(), new Piccolo()), nombreUsuarioGuerreros),
				new Usuario(new Equipo("Enemigos de la Tierra", new Cell(), new Freezer(), new MajinBoo()), nombreUsuarioEnemigos));
	}

	private void setBotoneraDerecha() {

		this.botoneraDerecha = new BotoneraDerecha(stage, this.juego, vistaTablero,
				reproductorMusicaDeBatalla, ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, ajustesMusicaEnding);	
		VBox hud = new VBox(10);
		hud.setAlignment(Pos.BOTTOM_CENTER);
		this.botoneraDerecha = new BotoneraDerecha(stage, this.juego, vistaTablero, reproductorMusicaDeBatalla,
				ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, ajustesMusicaEnding);
		hud.getChildren().addAll(botoneraDerecha, vistaInferiorPersonajes);
		this.setBottom(hud);
	}
	
	private void setCaracteristicasPersonajeSeleccionado(){
		this.vistaInferiorPersonajes = new VistaInferiorPersonajes(juego, ajustesEfectosDePersonajes);
	}

	
	private void setTablero(){
		this.vistaTablero = new VistaTablero(this.juego,this.vistaInferiorPersonajes, this.stage,
				reproductorMusicaDeBatalla, ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, ajustesMusicaEnding);
		this.setCenter(this.vistaTablero);
	}
	
}