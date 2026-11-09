package com.example.demo.controller;

import com.example.demo.util.SceneManager;
import javafx.fxml.FXML;

public class MainPageController {

    @FXML
    private void onLogout() {
        SceneManager.switchTo("login.fxml");
    }
}