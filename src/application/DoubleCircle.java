package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;

public class DoubleCircle extends Obstacle{
	
	private SimpleCircle one,two;
	private float x,y;
	private final double  XVALUE=130;
	private final double YVALUE=40;
	DoubleCircle(Game parent) throws IOException{
		super(parent);
		
		super.setPane((Pane)FXMLLoader.load(getClass().getResource("DoubleCircle.fxml")));
		Button button=(Button) ((Pane)(super.getPane())).getChildren().get(1);
		button.setVisible(false);
		button.fire();
		
		Group ArcGroup=(Group)super.getPane().getChildren().get(0);
		Group ArcGrouptwo=(Group)((Group)super.getPane().getChildren().get(0)).getChildren().get(4);
		
		for(int i=0;i<4;i++) {
			super.getComponents().add((Arc)ArcGroup.getChildren().get(i));
			((Arc)(ArcGroup.getChildren().get(i))).setCenterX(XVALUE);
			((Arc)(ArcGroup.getChildren().get(i))).setCenterY(YVALUE);
			super.getColours().add((Color) ((Arc)ArcGroup.getChildren().get(i)).getStroke());
		}
		
		for(int i=0;i<4;i++) {
			super.getComponents().add((Arc)ArcGrouptwo.getChildren().get(i));
			((Arc)(ArcGrouptwo.getChildren().get(i))).setCenterX(XVALUE);
			((Arc)(ArcGrouptwo.getChildren().get(i))).setCenterY(YVALUE);
			//super.getColours().add((Color) ((Arc)ArcGroup.getChildren().get(i)).getStroke());
		}
	}

	@Override
	public int returnYValue() {
		
		// TODO Auto-generated method stub
		return (int)super.getPane().getTranslateY();
	}

}
