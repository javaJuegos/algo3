package vista;

import dab.juego.Celda;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
//import javafx.scene.text.TextAlignment;

public class VistaCelda {
	
	private Celda celda;
	private Rectangle rectangulo;
	private int recHeight = 70;
	private int recWidth = 70;
	private boolean disponible;
	Text text;
	
	private Color colorLiberada = Color.AQUAMARINE;
	private Color colorDisponible = Color.PALEVIOLETRED;
	private Color colorSeleccionada = Color.BLUE;

	
	public VistaCelda(Celda celda){
		this.celda = celda;
		rectangulo = new Rectangle();
		rectangulo.setFill(colorLiberada);
		disponible = false;
		text = new Text("");
	}
	
	public StackPane dibujar(){
		
		//Creo que se deberia crear una ficha 'vacia' para no tener que preguntar esto
		actualizarPersonaje();
		
		rectangulo.setWidth(recHeight);
		rectangulo.setHeight(recWidth);
		rectangulo.setFill(Color.AQUAMARINE);
		rectangulo.setStroke(Color.BLACK);
	    StackPane layout = new StackPane();
	    layout.getChildren().addAll(
	                rectangulo,
	                text
	        );
		return layout;
	}
	
	public void liberada(){
		rectangulo.setFill(colorLiberada);
		disponible = false;
	}
	
	public void disponible(){
		
		rectangulo.setFill(colorDisponible);
		disponible = true;
	}
	
	public void seleccionada(){
		rectangulo.setFill(colorSeleccionada);
		
	}
	
	public void actualizarPersonaje(){
		if (celda.estaOcupada()){
			text.setText(celda.getFicha().getNombre());
		}
		else{
			text.setText("");
		}
	}
	
	public boolean estaDisponible(){
		return disponible;
	}
	
	
	public boolean estaOcupada(){
		return celda.estaOcupada();
	}

	public int getColumna() {
		return celda.getColumna();
	}
	
	public int getFila() {
		return celda.getFila();
	}

	public Celda getCelda() {
		return celda;
	}
	
	
	
}
