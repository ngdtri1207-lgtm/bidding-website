package com.example.demo.controller;

import com.example.demo.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    // Tài khoản giả, sau này thay bằng gọi server.
    private static final String FAKE_USER = "admin";
    private static final String FAKE_PASS = "123";

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    @FXML
    private void initialize() {
        hideError();
    }

    @FXML
    private void onLoginClick() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showError("Vui lòng nhập đầy đủ thông tin");
            return;
        }
        if (!FAKE_USER.equals(username) || !FAKE_PASS.equals(password)) {
            showError("Sai tài khoản hoặc mật khẩu");
            return;
        }
        hideError();
        SceneManager.switchTo("main-page.fxml");
    }

    @FXML
    private void onGoToRegister() {
        SceneManager.switchTo("register.fxml");
    }

    private void showError(String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
        errorLabel.setManaged(true);
    }

    private void hideError() {
        errorLabel.setVisible(false);
        errorLabel.setManaged(false);
    }
}
