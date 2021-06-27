package sample;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.fxml.Initializable;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class tripleCircleController implements Initializable {
    public Button btn;
    public Arc seconda1,seconda2,seconda3,seconda4;
    public Group gp2,gp3;
    public Group outerCircle;
    public Arc thirda1,thirda2,thirda3,thirda4;
    public Arc firsta1,firsta2,firsta3,firsta4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void play(ActionEvent event) {
        RotateTransition rt = new RotateTransition(Duration.millis(5000), outerCircle);
        rt.setAxis(Rotate.Z_AXIS);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setDelay(Duration.seconds(0));
        rt.play();

       /* RotateTransition rt1 = new RotateTransition(Duration.millis(5000), gp2);
        rt1.setAxis(Rotate.Z_AXIS);
        rt1.setFromAngle(0);
        rt1.setToAngle(180);
        rt1.setCycleCount(Animation.INDEFINITE);
        rt1.setDelay(Duration.seconds(0));
        rt1.play();

        RotateTransition rt2 = new RotateTransition(Duration.millis(5000), gp3);
        rt2.setAxis(Rotate.Z_AXIS);
        rt2.setFromAngle(0);
        rt2.setToAngle(270);
        rt2.setCycleCount(Animation.INDEFINITE);
        rt2.setDelay(Duration.seconds(0));
        rt2.play();*/
    }
}
