package application;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class canController implements Initializable {


    public Button btn;
    public Group gp;



    public void move(ActionEvent event) {
        TranslateTransition t= new TranslateTransition();
        t.setDuration(Duration.seconds(3));
        t.setToX(500);
        t.setAutoReverse(true);
        t.setCycleCount(Animation.INDEFINITE);
        t.setNode(gp);
        t.play();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}