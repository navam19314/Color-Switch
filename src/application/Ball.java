package application;



import java.util.Scanner;
import java.util.*;
import javafx.application.*;
import javafx.fxml.*;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;


import java.io.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;



public class Ball {
	private final float Distance=25f;
	private Circle ball;
	private float XCoordinate;
	private float YCoordinate;
	
	
	Ball(){
		
			ball=new Circle(425,400,10);
			ball.setFill(Color.YELLOW);
			
			
	}
	
	public void move(double distance,double time) {
		TranslateTransition trans=new TranslateTransition(Duration.seconds(0.1),this.ball);
		double w=this.ball.getCenterY();
		trans.setFromY(w);
		trans.setToY(w+distance);
		trans.setCycleCount(1);
		this.ball.setCenterY(w+distance);
		trans.play();
	}

		
	protected Circle getBall() {
		return ball;
	}

	protected void setBall(Circle ball) {
		this.ball = ball;
	}
	

}
