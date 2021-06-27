package application;

import java.util.Scanner;
import java.util.*;
import javafx.application.*;
import javafx.fxml.*;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.fxml.*;
import java.net.*;

public class Parallellogram extends Obstacle {
	
	private float SideLengthOne,SideLengthTwo,CentreDistanceOne,CentreDistanceTwo,AngleOne,AngleTwo;
	private final double  XVALUE=140;
	private final double YVALUE=70;
	

	Parallellogram(Game parent) throws IOException {
		super(parent);
		super.setPane((Pane)FXMLLoader.load(getClass().getResource("rectangle.fxml")));
		Button button=(Button) ((Pane)(super.getPane())).getChildren().get(0);
		button.setVisible(false);
		button.fire();
		Group LineGroup=(Group)super.getPane().getChildren().get(1);

		for(int i=0;i<4;i++) {
			super.getComponents().add((Line)LineGroup.getChildren().get(i));
			((Line)(LineGroup.getChildren().get(i))).setTranslateY(YVALUE);;
			((Line)(LineGroup.getChildren().get(i))).setTranslateX(XVALUE);
			super.getColours().add((Color) ((Line)LineGroup.getChildren().get(i)).getStroke());
		}

	}


	@Override
	public int returnYValue() {
		// TODO Auto-generated method stub
		return (int)super.getPane().getTranslateY();
		//return 0;
	}
	
	

}
