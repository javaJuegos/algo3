package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Dragon AlgoBall Z");
        
        ContenedorNombresUsuarios contenedorNombresUsuarios = new ContenedorNombresUsuarios(stage);
        Scene escenaNombresUsuarios = new Scene(contenedorNombresUsuarios);
        
        ContenedorInicial contenedorInicial = new ContenedorInicial(stage, escenaNombresUsuarios);
        int pixelesAnchoSD = 840;
        int pixelesAltoSD = 480;
        Scene escenaInicial = new Scene(contenedorInicial, pixelesAnchoSD, pixelesAltoSD);

        stage.setScene(escenaInicial);
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }
}