/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package controlcircle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author usu2dam
 */
public class ControlCircle extends Application {
    
    private Circle circle = new Circle();
    
    @Override
    public void start(Stage primaryStage) {
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(5);
        Button btnEn = new Button("Enlarge");
        Button btnSh = new Button("Shrink");
        hbox.getChildren().add(btnEn);
        hbox.getChildren().add(btnSh);
        btnEn.setOnAction((ActionEvent event) -> {
            circle.setRadius(circle.getRadius() + 2);
        });
        btnSh.setOnAction((ActionEvent event) -> {
            circle.setRadius (circle.getRadius () > 2
                    ? circle.getRadius () - 2 : circle.getRadius());
        });
        BorderPane borderpane = new BorderPane();
        borderpane.setBottom(hbox);
        
        // Creando un círculo y activando sus propiedades
        circle.centerXProperty().bind(borderpane.widthProperty().divide(2));
        circle.centerYProperty().bind(borderpane.heightProperty().divide(2));
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        
        borderpane.getChildren().add(circle);
        
        Scene scene = new Scene(borderpane, 300, 200);
        
        primaryStage.setTitle("Control Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
