package vista.vistasCelda;

import dab.juego.Celda;
import javafx.scene.paint.Color;

public class VistaCeldaALaCualSePuedeMover extends VistaCelda {

	public VistaCeldaALaCualSePuedeMover(Celda celda) {
		super(celda);
		color = Color.web("#0abf12");
		super.setup();
	}

}
