package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;

public class TriInCircle extends Obstacle{
	private SimpleCircle one;
	private Triangle two;
	private final double  XVALUE=140;
	private final double YVALUE=10;
	
	TriInCircle(Game parent) throws IOException {
		super(parent);
		super.setPane((Pane)FXMLLoader.load(getClass().getResource("triInCircle.fxml")));
		Button button=(Button) ((Pane)(super.getPane())).getChildren().get(1);
		button.setVisible(false);
		button.fire();
		
		Group ArcGroup=(Group)super.getPane().getChildren().get(0);
		Group LineGroup=(Group)ArcGroup.getChildren().get(4);
		for(int i=0;i<4;i++) {
			super.getComponents().add((Arc)ArcGroup.getChildren().get(i));
			((Arc)(ArcGroup.getChildren().get(i))).setCenterX(XVALUE);
			((Arc)(ArcGroup.getChildren().get(i))).setCenterY(YVALUE);
			super.getColours().add((Color) ((Arc)ArcGroup.getChildren().get(i)).getStroke());
		}
		
		for(int i=0;i<3;i++) {
			super.getComponents().add((Line)LineGroup.getChildren().get(i));
			((Line)(LineGroup.getChildren().get(i))).setTranslateY(YVALUE);;
			((Line)(LineGroup.getChildren().get(i))).setTranslateX(XVALUE);
			//super.getColours().add((Color) ((Line)LineGroup.getChildren().get(i)).getStroke());
		}
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public int returnYValue() {
		// TODO Auto-generated method stub
		return (int)super.getPane().getTranslateY();
		
	}

}
