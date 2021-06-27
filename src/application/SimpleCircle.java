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
import java.net.*
;public class SimpleCircle extends Obstacle{
	
	private float InnerRadius,OuterRadius;
	private final double  XVALUE=10;
	private final double YVALUE=40;
	SimpleCircle(Game Parent) throws IOException{
		super(Parent);
		
		super.setPane((Pane)FXMLLoader.load(getClass().getResource("circle.fxml")));
		Button button=(Button) ((Pane)(super.getPane())).getChildren().get(0);
		button.setVisible(false);
		button.fire();
		
		// extracting all the arcs
		Group ArcGroup=(Group)super.getPane().getChildren().get(1);
		
		for(int i=0;i<4;i++) {
			super.getComponents().add((Arc)ArcGroup.getChildren().get(i));
			((Arc)(ArcGroup.getChildren().get(i))).setCenterX(XVALUE);
			((Arc)(ArcGroup.getChildren().get(i))).setCenterY(YVALUE);
			super.getColours().add((Color) ((Arc)ArcGroup.getChildren().get(i)).getStroke());
		}
		
	}
	
	
	
	


	protected float getInnerRadius() {
		return InnerRadius;
	}
	protected void setInnerRadius(float innerRadius) {
		InnerRadius = innerRadius;
	}
	protected float getOuterRadius() {
		return OuterRadius;
	}
	protected void setOuterRadius(float outerRadius) {
		OuterRadius = outerRadius;
	}






	@Override
	public int returnYValue() {
		// TODO Auto-generated method stub
		return (int)super.getPane().getTranslateY();
	}
	
	

}
