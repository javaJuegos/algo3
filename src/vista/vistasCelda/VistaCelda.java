package vista.vistasCelda;

import dab.juego.Celda;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import utils.FabricadorDeRepresentacionDeFicha;

public abstract class VistaCelda extends StackPane{
	
	protected Celda celda;
	protected Rectangle rectangulo;
	private int recHeight = 60;
	private int recWidth = 60;
	
	protected Color color;
	
//	private Color colorUnpressed = Color.AQUAMARINE;
//	private Color colorPressed = Color.PALEVIOLETRED;

	
	public VistaCelda(Celda celda){
		this.celda = celda;
		
	}
	
	protected void setup(){
		
		rectangulo = new Rectangle();

		rectangulo.setWidth(recHeight);
		rectangulo.setHeight(recWidth);
		rectangulo.setFill(color);
		
		darPropiedadesARectangulo();
		//Creo que se deberia crear una ficha 'vacia' para no tener que preguntar esto
		if (celda.estaOcupada()){
//		
			FabricadorDeRepresentacionDeFicha fabricador = new FabricadorDeRepresentacionDeFicha();
			String urlImagenRepresentadora = fabricador.fabricarPersonaje(celda.getFicha().getNombre());
			
			Image imagenRepresentador = new Image(urlImagenRepresentadora);
			Pane pane = new Pane();
			BackgroundImage background = new BackgroundImage(imagenRepresentador, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,  BackgroundSize.DEFAULT);
			pane.setBackground(new Background(background));

			this.getChildren().addAll(rectangulo, pane);
			

		}
		else{
			this.getChildren().addAll(rectangulo);
		}
		
	    
	}
	
	public void darPropiedadesARectangulo(){
		
		rectangulo.setStroke(Color.web("#006c00"));
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
