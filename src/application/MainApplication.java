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
import java.net.MalformedURLException;

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
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;


public class MainApplication extends Application {
	
	private static int TotalGames;
	Game CurrentGame;
	Stage primaryStage;
	Scene MainMenu,HelpScreen;
	Pane pane;
	Label MainMenuLabel,StartNewGame,Help,LoadGame, Instructions;
	String CurrentState="MainMenu";
	Button KeyBoardInput=new Button();
	Button HButton=new Button();
	String game1="Game1.txt",game2="Game2.txt";
	
	public void saveGame() {
		File file1=new File(game1);
		try {
			file1.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file1));
			out.writeObject(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void loadGame() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream (new FileInputStream(game1));
				 CurrentGame=(Game)in.readObject();
	}
	public void initializeMainMenu() throws IOException {
		
		
		
		pane=new Pane();
		Image image=new Image(new FileInputStream("Source/ColorSwitch.png"));
		
		ImageView img=new ImageView(image);
		img.setFitHeight(200);
		img.setFitWidth(300);
		img.setTranslateY(100); img.setTranslateX(300);
		pane.getChildren().add(img);
		
		MainMenuLabel=new Label("Main Menu");
		MainMenuLabel.setFont(new Font("Arial",44));
		MainMenuLabel.setTranslateX(330);MainMenuLabel.setTranslateY(300);
		MainMenuLabel.setTextFill(Color.GOLD);;
		Group TimerGroup=new Group();
		TimerGroup.getChildren().add(MainMenuLabel);
		pane.getChildren().add(TimerGroup);	
		
		StartNewGame=new Label("Start New Game");
		StartNewGame.setFont(new Font("Arial",34));
		StartNewGame.setTranslateX(330); StartNewGame.setTranslateY(400);
		StartNewGame.setTextFill(Color.GOLD);
		TimerGroup.getChildren().add(StartNewGame);
		
		LoadGame=new Label("Load Game");
		LoadGame.setFont(new Font("Arial",34));
		LoadGame.setTranslateX(330); LoadGame.setTranslateY(450);
		LoadGame.setTextFill(Color.GOLD);
		TimerGroup.getChildren().add(LoadGame);
		
		Help=new Label("Help");
		Help.setFont(new Font("Arial",34));
		Help.setTranslateX(330); Help.setTranslateY(500);
		Help.setTextFill(Color.GOLD);
		TimerGroup.getChildren().add(Help);
	
		Instructions=new Label("Press n to start new game\n Press l to load a previously saved game \n press h for help");
		Instructions.setFont(new Font("Arial",20));
		Instructions.setTranslateX(330); Instructions.setTranslateY(650);
		Instructions.setTextFill(Color.GOLD);
		TimerGroup.getChildren().add(Instructions);
		
		
		initializeKeys();
		pane.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
		
		SimpleCircle circle=new SimpleCircle(CurrentGame);
		Triangle triangle=new Triangle(CurrentGame);
		circle.getPane().setTranslateX(-300);
		triangle.getPane().setTranslateX(200);
		pane.getChildren().addAll(circle.getPane(),triangle.getPane(),KeyBoardInput);
		
		
		// help screen
		Pane HPane=(Pane)FXMLLoader.load(getClass().getResource("HelpScreen.fxml"));
		
		
		HelpScreen=new Scene(HPane,850,850);
		HPane.getChildren().add(HButton);		
		
		MainMenu=new Scene(pane,850,850);
		
		primaryStage.setScene(MainMenu);
		this.primaryStage.show();
		
	}
	
	public void initializeKeys() {
HButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent k) {
				
				
				// help screen
				
				
			if(k.getCode()==KeyCode.Q && CurrentState.equals("HelpScreen")) {
				CurrentState="MainMenu";
				primaryStage.setScene(MainMenu);
			}	
				
				
			}});

			
		
	
			
	
	
KeyBoardInput.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent k) {
				
				
				// help screen
				if(k.getCode()==KeyCode.H) {
					CurrentState="HelpScreen";
				primaryStage.setScene(HelpScreen);
				
			}
				
				if(k.getCode()==KeyCode.L) {
					try {
						loadGame();
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
				if(k.getCode()==KeyCode.N ) {
					CurrentState="Playing";
					try {
						newGame();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(k.getCode()==KeyCode.L) {
					
				}
				
				
				
				
			}});

			
		
	
			
	}

	void newGame() throws IOException {
		CurrentState="Playing";
		CurrentGame=new Game("Prerak",this);
		this.primaryStage.setScene(this.CurrentGame.getPlayingScreen());
		
		//CurrentGame.initializeObstacle();
	
		CurrentGame.startGame();
		
		
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
	this.primaryStage=primaryStage;
		initializeMainMenu();
		
			
			
			
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
