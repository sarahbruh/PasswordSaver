package controllerview.signup;

import controllerview.signin.SignIn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class SignUpC {
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtReenter;

    public static Stage stageOne;
    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignUpC.class.getResource("/controllerview/view/signUp.fxml"));
            Parent root = fxmlLoader.load();

            stageOne = stage;

            stageOne.setTitle("Sign Up");
            stage.getIcons().add(new Image("/ressources/icon.png"));
            stageOne.setScene(new Scene(root));
            stageOne.show();
        }
        catch(Exception exception)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Internal Error");
            alert.setContentText(String.format("An internal Error occurred. Please restart the program%nor contact the developer on GitHub%n%nError message: %s", exception.getMessage()));
            alert.setResizable(true);
            alert.showAndWait();
            System.err.println(exception.getMessage());
            exception.printStackTrace(System.err);
        }
    }

    public void newUser()
    {
        String name = txtUsername.getText();
        String password = txtPassword.getText();
        String reenter = txtReenter.getText();

        if(password.equals(reenter)){
            SignIn.addUser(name, password);
            SignIn.setUser();
            stageOne.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erfolgreich!");
            alert.setContentText("Dein Account wurde erfolgreich erstellt!");
            alert.setResizable(true);
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Passwörter ungleich!");
            alert.setContentText("Deine Passwörter stimmen nicht überein! Versuch's nochmal!");
            alert.setResizable(true);
            alert.showAndWait();
        }
    }

    @FXML
    private void next()
    {
        newUser();
    }
}
