package vista.eventos;


import dab.equipo.Equipo;
import dab.personajes.Freezer.Freezer;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;
import dab.usuario.Usuario;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vista.ContenedorPrincipal;

public class BotonComenzarPartidaEventHandler implements EventHandler<ActionEvent>{
	Stage stage;
	Scene proximaEscena;

	private TextField campoNombreUserGuerreros;
	private TextField campoNombreUserEnemigos;
	private int pixelesAnchoHD = 1920;
    private int pixelesAltoHD = 1080;

	
	public BotonComenzarPartidaEventHandler(Stage stage, TextField campoNombreUsuarioGuerreros, TextField campoNombreUsuarioEnemigos){

		this.stage = stage;		
		this.campoNombreUserGuerreros = campoNombreUsuarioGuerreros;
		this.campoNombreUserEnemigos = campoNombreUsuarioEnemigos;
		this.stage = stage;
		

	}
	
	@Override
	public void handle(ActionEvent event) {
		
		
		Usuario userGuerrerosZ = new Usuario(new Equipo("Guerreros Z", new Goku(), new Gohan(), new Piccolo()),
				campoNombreUserGuerreros.getText());
		
		Usuario userEnemigosDeLaTierra = new Usuario(new Equipo("Enemigos de la Tierra", new Cell(), new Freezer(), new MajinBoo()),
				campoNombreUserEnemigos.getText());
		
		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, userGuerrerosZ, userEnemigosDeLaTierra);
        Scene escenaPrincipal = new Scene(contenedorPrincipal);

        
        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaPrincipal.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
        
        stage.setScene(escenaPrincipal);
		stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
	}
}