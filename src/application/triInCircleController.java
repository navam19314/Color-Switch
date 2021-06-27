package application;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.fxml.Initializable;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class triInCircleController implements Initializable{
    public Group grp1;
    public Arc arc3,arc1,arc2,arc4;
    public Group grp2;
    public Line triSide1,triSide2,triSide3;

    public void play(ActionEvent event) {
        RotateTransition rt = new RotateTransition(Duration.millis(3500), grp1);
        rt.setAxis(Rotate.Z_AXIS);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setDelay(Duration.seconds(0));
        rt.play();

//        RotateTransition rt1 = new RotateTransition(Duration.millis(3500), grp2);
//        rt1.setAxis(Rotate.Z_AXIS);
//        rt1.setFromAngle(0);
//        rt1.setToAngle(360);
//        rt1.setCycleCount(Animation.INDEFINITE);
//        rt1.setDelay(Duration.seconds(0));
//        rt1.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}