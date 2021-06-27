package application;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class clcController {
    public Group clcGrp;
    public Arc arc2;
    public Arc arc1;
    public Arc arc4;
    public Arc arc3;
    public Button clcBtn;


    public void circleplay(ActionEvent event) {
        RotateTransition rt = new RotateTransition(Duration.millis(2500), clcGrp);
        rt.setAxis(Rotate.Z_AXIS);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setDelay(Duration.seconds(0));
        rt.play();
    }
}
