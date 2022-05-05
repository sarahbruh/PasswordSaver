package controllerview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitMenuButton;

import java.io.IOException;

public class SettingsController {
    @FXML
    Slider fontSize = new Slider();
    @FXML
    SplitMenuButton backgroundcolor = new SplitMenuButton();
    @FXML
    SplitMenuButton language = new SplitMenuButton();

}
