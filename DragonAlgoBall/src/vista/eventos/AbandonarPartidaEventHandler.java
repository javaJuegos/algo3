package vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;
import vista.VistaMenuPrincipal;

public class AbandonarPartidaEventHandler implements EventHandler<MouseEvent> {
	private Stage stage;
	private Ajustes ajusteMusicaDeBatalla;
	private Ajustes ajusteSonidosEspeciales;
	private ReproductorDeSonidos reproductorMusicaDeBatalla;
	private Ajustes ajustesMusicaEnding;
	
	public AbandonarPartidaEventHandler(Stage stage, ReproductorDeSonidos reproductorMusicaDeBatalla, Ajustes ajusteSonidosEspeciales, Ajustes ajusteMusicaDeBatalla,
			Ajustes ajustesMusicaEnding) {
		// TODO Auto-generated constructor stub

		this.ajustesMusicaEnding = ajustesMusicaEnding;
		this.ajusteSonidosEspeciales = ajusteSonidosEspeciales;
		this.ajusteMusicaDeBatalla = ajusteMusicaDeBatalla;
		this.reproductorMusicaDeBatalla = reproductorMusicaDeBatalla;
		this.stage = stage;
	}

	@Override
	public void handle(MouseEvent arg0) {
		
		Alert alertaAbandonarPartida = new Alert(AlertType.CONFIRMATION, "Desea volver al menu principal? Se perdera el progreso de la partida!",
				ButtonType.YES, ButtonType.NO);
		alertaAbandonarPartida.showAndWait();
		
		if (alertaAbandonarPartida.getResult().equals(ButtonType.YES)){
			VistaMenuPrincipal menuPrincipal = new VistaMenuPrincipal(stage, ajusteMusicaDeBatalla, ajusteSonidosEspeciales, ajustesMusicaEnding);
			Scene escenaMenuPrincipal = new Scene(menuPrincipal);
			stage.setScene(escenaMenuPrincipal);
			if (ajusteMusicaDeBatalla.estaActivo()){reproductorMusicaDeBatalla.stop();}
		}
	}

}
