package application;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import javafx.fxml.Initializable;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class rectController implements Initializable{
    public Line rectS1;
    public Line rectS4;
    public Line rectS3;
    public Line rectS2;
    public Button rectbtn;
    public Group rectGP;

    public void rectplay(ActionEvent event) {
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setDuration(Duration.millis(4000));
        rotate.setNode(rectGP);
        rotate.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}