package application;

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

public class doubleCircleController implements Initializable {
    public Group outerCircle;
    public Arc oa1,oa2,oa3,oa4,ia1,ia2,ia3,ia4;
    public Button btn;

    public void play(ActionEvent event) {
//        RotateTransition rt = new RotateTransition(Duration.millis(5500), innerCircle);
//        rt.setAxis(Rotate.Z_AXIS);
//        rt.setFromAngle(0);
//        rt.setToAngle(360);
//        rt.setCycleCount(Animation.INDEFINITE);
       
       

        RotateTransition rt1 = new RotateTransition(Duration.millis(3500), outerCircle);
        rt1.setAxis(Rotate.Z_AXIS);
        rt1.setFromAngle(0);
        rt1.setToAngle(360);
        rt1.setCycleCount(Animation.INDEFINITE);
      
        rt1.play(); //rt.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}