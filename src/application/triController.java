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

public class triController implements Initializable {
    public Line ts1;
    public Line ts3;
    public Line ts2;
    public Button triBtn;
    public Group triGrp;

    public void ply(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void triplay(ActionEvent event) {


        RotateTransition rt = new RotateTransition(Duration.millis(4000), triGrp);
        rt.setAxis(Rotate.Z_AXIS);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setDelay(Duration.seconds(0));
        rt.play();
    }
}