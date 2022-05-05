package controllerview.signin;

import controllerview.signup.SignUpC;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import controllerview.MainController;


public class SignInC {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    private Stage stage;

    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignInC.class.getResource("/controllerview/view/signIn.fxml"));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            SignInC ctrl = fxmlLoader.getController();
            ctrl.stage = stage;

            stage.getIcons().add(new Image("/ressources/icon.png"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception exception)
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

    public void compare(){

        String username = txtUsername.getText();
        String password = txtPassword.getText();
        try {
            System.out.println(SignIn.getSize());
            for (int i = 0; i < SignIn.getSize(); i++)
            {
                String correctUsername = SignIn.getNameOfUser(i);
                String correctPassword = SignIn.getPasswordOfUser(i);
                //System.out.println(correctPassword);
                //System.out.println(correctUsername);

                if (username.equals(correctUsername) && password.equals(correctPassword))
                {
                    MainController.show(new Stage(), i);

                    stage.close();
                    return;
                }
            }
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

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Falsche Anmeldedaten");
        alert.setContentText("Falscher Benutzername oder falsches Passwort!");
        alert.setResizable(true);
        alert.showAndWait();
    }

    @FXML
    private void next()
    {
        SignIn.setUser();
        compare();
    }

    @FXML
    private void signUp(){
        SignUpC.show(new Stage());
    }


}
