package controllerview;

import controllerview.signup.SignUpC;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Data;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController {
    @FXML
    TextField searchTxtF = new TextField();
    @FXML
    TextField usernameTxtF = new TextField();
    @FXML
    TextField passwordTxtF = new TextField();
    @FXML
    Button searchB = new Button();
    @FXML
    Button settingsB = new Button();
    @FXML
    Button addB = new Button();
    @FXML
    private TableView<Data> data;
    @FXML
    private TableColumn<Data, String> usernameCol;
    @FXML
    private TableColumn<Data, String> passwordCol;
    @FXML
    private Label status;

    @FXML
    public void AddRecord() {
        addData();
    }
    public void addData(){
        Data d = new Data();
        d.setUsername(usernameTxtF.getText());
        d.setPassword(passwordTxtF.getText());
        data.getItems().add(d);
        usernameTxtF.clear();
        passwordTxtF.clear();
    }

    ObservableList<Data> getProductList(){
        ObservableList<Data> dataObservableList = FXCollections.observableArrayList();
        dataObservableList.add(new Data("sarah","1234"));

        return dataObservableList;
    }

    public void initialize(URL url, ResourceBundle rb){
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        data.setItems(getProductList());
    }


    private int active_user;

    public static Stage stageMenu;
    public static void show(Stage stage, int user) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SignUpC.class.getResource("/controllerview/view/mainscreen.fxml"));
            Parent root = fxmlLoader.load();
            MainController ctrl = fxmlLoader.getController();

            ctrl.active_user = user;

            stageMenu = stage;

            stageMenu.setTitle("PassWordSaver");
            stage.getIcons().add(new Image("/ressources/icon.png"));
            stageMenu.setScene(new Scene(root));
            stageMenu.show();
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

    public void AddRecord(ActionEvent event) {
    }
    /*public void AddbtnOnAction(ActionEvent event) throws IOException {

    }

    private Node node;
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    private Parent root;
    public Main main;

    public void SettingsbtnOnAction(ActionEvent event) throws IOException {
        //checkSetting();
        try {
            node = (Node) event.getSource();
            stage = (Stage) node.getScene().getWindow();
            scene = stage.getScene();
            fxmlLoader = new FXMLLoader(getClass().getResource("settings.fxml"));
            root = (Parent) fxmlLoader.load();
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void checkSetting() throws IOException{
        Main main = new Main();
        if (settingsB.isPressed()){
            main.changeSceneSettings();
        }
    }*/
}
