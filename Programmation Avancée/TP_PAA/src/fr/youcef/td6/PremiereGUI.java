package fr.youcef.td6;

import fr.youcef.td6.exo5.PanelJeu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PremiereGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Devine le nombre");
        Pane myPane = new PanelJeu();

        Scene scene =  new Scene(myPane);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
