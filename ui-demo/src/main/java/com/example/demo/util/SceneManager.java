package com.example.demo.util;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public final class SceneManager {

    private static Scene scene;

    private SceneManager() {
    }

    public static void init(Scene mainScene) {
        scene = mainScene;
    }

    public static void switchTo(String fxmlName) {
        try {
            Parent root = FXMLLoader.load(SceneManager.class.getResource("/fxml/" + fxmlName));
            scene.setRoot(root);
        } catch (IOException e) {
            throw new IllegalStateException("Không tải được màn hình: " + fxmlName, e);
        }
    }
}