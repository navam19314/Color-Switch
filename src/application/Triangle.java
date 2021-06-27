package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Triangle extends Obstacle {
	
	private float sideLength;
	private float centreDistance;
	private final double XVALUE=140;
	private final double YVALUE=40;
	
	Triangle(Game parent) throws IOException {
		super(parent);
		
		super.setPane((Pane)FXMLLoader.load(getClass().getResource("triangle.fxml")));
		Button button=(Button) ((Pane)(super.getPane())).getChildren().get(1);
		button.setVisible(false);
		button.fire();
		Group LineGroup=(Group)super.getPane().getChildren().get(0);

		for(int i=0;i<3;i++) {
			super.getComponents().add((Line)LineGroup.getChildren().get(i));
			((Line)(LineGroup.getChildren().get(i))).setTranslateY(YVALUE);;
			((Line)(LineGroup.getChildren().get(i))).setTranslateX(XVALUE);
			super.getColours().add((Color) ((Line)LineGroup.getChildren().get(i)).getStroke());
		}

	}
		// TODO Auto-generated constructor stub
	

	@Override
	public int returnYValue() {
		Group LineGroup=(Group)super.getPane().getChildren().get(0);
		((Line)LineGroup.getChildren().get(0)).getTranslateY();
		// TODO Auto-generated method stub
		return (int)super.getPane().getTranslateY();
		//return 0;
	}
	

}
