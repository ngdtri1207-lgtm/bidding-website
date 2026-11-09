package com.example.demo;

import com.example.demo.util.SceneManager;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader =
                new FXMLLoader(HelloApplication.class.getResource("/fxml/login.fxml"));
        Scene scene = new Scene(loader.load(), 900, 600);
        SceneManager.init(scene);
        stage.setTitle("Online Auction System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
