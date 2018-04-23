package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerSignUp {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button registrationButton;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordFieldRegistration;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField privateCodeField;

    @FXML
    private TextField loginFieldRegistration;

    @FXML
    private TextField groupField;

    @FXML
    private Button returnToAuthorization;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        registrationButton.setOnAction(event -> {
            dbHandler.signUpUsers(nameField.getText(), surnameField.getText(), privateCodeField.getText(),
                    groupField.getText(), loginFieldRegistration.getText(), passwordFieldRegistration.getText());
        } );

        returnToAuthorization.setOnAction(event -> {
            returnToAuthorization.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/authorization.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}

