package com.example.demo.controller;

import com.example.demo.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    private static final int MIN_PASSWORD_LENGTH = 6;

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmField;
    @FXML private ComboBox<String> roleBox;
    @FXML private Label errorLabel;

    @FXML
    private void initialize() {
        roleBox.getItems().addAll("Bidder", "Seller");
        hideError();
    }

    @FXML
    private void onRegisterClick() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        String confirm = confirmField.getText();
        String role = roleBox.getValue();

        if (username.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            showError("Vui lòng nhập đầy đủ thông tin");
            return;
        }
        if (password.length() < MIN_PASSWORD_LENGTH) {
            showError("Mật khẩu phải có ít nhất " + MIN_PASSWORD_LENGTH + " ký tự");
            return;
        }
        if (!password.equals(confirm)) {
            showError("Mật khẩu nhập lại không khớp");
            return;
        }
        if (role == null) {
            showError("Vui lòng chọn vai trò");
            return;
        }

        hideError();
        // Sau này: gọi server để tạo tài khoản. Hiện tại chỉ thông báo rồi quay lại đăng nhập.
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Đăng ký thành công với vai trò " + role);
        alert.setHeaderText(null);
        alert.showAndWait();
        SceneManager.switchTo("login.fxml");
    }

    @FXML
    private void onBackToLogin() {
        SceneManager.switchTo("login.fxml");
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
