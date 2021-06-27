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



public abstract class Obstacle {
	private ArrayList<Color> Colours;
	private Game Parent;
	private int direction;
	private ArrayList<Shape> Components;
	private Pane pane;
	Obstacle(Game parent){
		this.Parent=Parent;
		direction =0;
	Colours=new ArrayList<Color>();
	Components=new ArrayList<Shape>();
		
	}
	
	public void move(double distance,double time) {
		TranslateTransition trans=new TranslateTransition(Duration.seconds(0.1),this.pane);
		double w=this.pane.getTranslateY();
		trans.setFromY(w);
		trans.setToY(w+distance);
		trans.setCycleCount(1);
		this.pane.setTranslateY(w+distance);
		trans.play();
		
	}
	
	public abstract int returnYValue() ;
	
	
	protected ArrayList<Color> getColours() {
		return Colours;
	}
	protected void setColours(ArrayList<Color> colours) {
		Colours = colours;
	}
	protected Game getParent() {
		return Parent;
	}
	protected void setParent(Game parent) {
		Parent = parent;
	}
	protected int getDirection() {
		return direction;
	}
	protected void setDirection(int direction) {
		this.direction = direction;
	}
	protected ArrayList<Shape> getComponents() {
		return Components;
	}
	protected void setComponents(ArrayList<Shape> components) {
		Components = components;
	}
	
	protected Pane getPane() {
		return pane;
	}



	protected void setPane(Pane pane) {
		this.pane = pane;
	}
	
	
	
	

}
