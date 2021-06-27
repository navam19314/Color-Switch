package sample;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class sqController implements Initializable{
    public Line sqS1;
    public Line sqS3;
    public Line sqS2;
    public Line sqS4;
    public Group sqGp;
    public Button sqBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void sqplay(ActionEvent event) {
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setDuration(Duration.millis(5000));
        rotate.setDelay(Duration.seconds(0));
        rotate.setNode(sqGp);
        rotate.play();
    }
}
