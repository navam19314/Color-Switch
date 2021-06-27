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
import java.net.MalformedURLException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Star {
	Random Randomizer=new Random();
	private Pane pane;
	int value;
	
	Star() throws IOException{
		pane=FXMLLoader.load(getClass().getResource("star.fxml"));
		
		Button btn=(Button)pane.getChildren().get(1);
		btn.fire();
		btn.setManaged(false);
		btn.setVisible(false);
		value=Randomizer.nextInt(3)+1;
	}

	protected Random getRandomizer() {
		return Randomizer;
	}

	protected void setRandomizer(Random randomizer) {
		Randomizer = randomizer;
	}

	protected Pane getPane() {
		return pane;
	}

	protected void setPane(Pane pane) {
		this.pane = pane;
	}

	protected int getValue() {
		return value;
	}

	protected void setValue(int value) {
		this.value = value;
	}
	
	

}
