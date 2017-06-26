package vista;

import dab.juego.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;
import vista.eventos.AbandonarJuegoEventHandler;
import vista.eventos.AbandonarPartidaEventHandler;
import vista.eventos.BotonPasarTurnoEventHandler;
import vista.eventos.ControlMusicaDeBatallaEventHandler;
import vista.eventos.ControlSonidosEspecialesEventHandler;

public class Botonera extends HBox{
	
	private Juego juego;
	private Stage stage;
	
	public Botonera(Juego juego, VistaTablero vistaTablero, ReproductorDeSonidos reproductorMusicaDeBatalla, Ajustes ajusteMusicaDeBatalla,
			Ajustes ajusteSonidosEspeciales, Stage stage){
		
		this.stage = stage;
		this.juego = juego;
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setPadding(new Insets(30));
		this.setBotonCederTurno(vistaTablero);
		this.setBotonControlMusicaDeBatalla( reproductorMusicaDeBatalla,  ajusteMusicaDeBatalla);
		this.setBotonControlSonidosEspeciales(ajusteSonidosEspeciales);
		this.setBotonVolverAlMenuPrincipal(ajusteSonidosEspeciales, ajusteMusicaDeBatalla, reproductorMusicaDeBatalla);
		this.setBotonSalirDelJuego();
	}

	

	private void setBotonCederTurno(VistaTablero vistaTablero){
		Button botonPasarTurno = new Button();
		BotonPasarTurnoEventHandler pasarTurnoEventHandler = new BotonPasarTurnoEventHandler(juego, vistaTablero);
	    botonPasarTurno.setOnAction(pasarTurnoEventHandler);
	    botonPasarTurno.getStyleClass().addAll("boton","botonPasar");
	    this.getChildren().add(botonPasarTurno);
	}
	private void setBotonControlMusicaDeBatalla(ReproductorDeSonidos reproductorMusicaDeBatalla,
			Ajustes ajusteMusicaDeBatalla) {
		ToggleButton botonPararMusicaDeBatalla = new ToggleButton();
		botonPararMusicaDeBatalla.getStyleClass().addAll("boton","muteMusic");
		botonPararMusicaDeBatalla.setOnMousePressed(new ControlMusicaDeBatallaEventHandler(reproductorMusicaDeBatalla));
		if (!ajusteMusicaDeBatalla.estaActivo()){
			botonPararMusicaDeBatalla.setDisable(true);
		}
		this.getChildren().add(botonPararMusicaDeBatalla);
	}
	
	private void setBotonControlSonidosEspeciales(Ajustes ajusteSonidosEspeciales){
		ToggleButton botonSilenciarSonidosDeBatalla = new ToggleButton();
		botonSilenciarSonidosDeBatalla.getStyleClass().addAll("boton","muteSound");
		botonSilenciarSonidosDeBatalla.setOnMousePressed(new ControlSonidosEspecialesEventHandler(ajusteSonidosEspeciales));
		this.getChildren().add(botonSilenciarSonidosDeBatalla);
	}
	

	private void setBotonVolverAlMenuPrincipal(Ajustes ajusteSonidosEspeciales, Ajustes ajusteMusicaDeBatalla, ReproductorDeSonidos reproductorMusicaDeBatalla) {
		// TODO Auto-generated method stub
		Button botonAbandonarPartida = new Button();
		botonAbandonarPartida.setOnMousePressed(new AbandonarPartidaEventHandler(ajusteSonidosEspeciales, ajusteMusicaDeBatalla, stage,
				reproductorMusicaDeBatalla));
		botonAbandonarPartida.getStyleClass().addAll("boton","home");
		this.getChildren().add(botonAbandonarPartida);
	}
	
	private void setBotonSalirDelJuego() {
		Button botonSalirDelJuego = new Button();
		botonSalirDelJuego.setOnMousePressed(new AbandonarJuegoEventHandler());
		botonSalirDelJuego.getStyleClass().addAll("boton","exit");
		this.getChildren().add(botonSalirDelJuego);
		
	}
}