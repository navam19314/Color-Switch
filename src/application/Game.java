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


public class Game implements Serializable{
	
	private final int XVALUE=850;
	private final int YVALUE=850;
	private ArrayList<Obstacle> AllObstacles;
	private Obstacle CurrentObstacle;
	private Pane ObstaclePane;
	private int TimeElapsed;
	private int Points;
	private String Player;
	private MainApplication Parent;
	private int Status;
	private Scene PlayingScreen;
	private Ball ball;
	private String ScreenType;
	private AnimationTimer timer;
	private Label TimerLabel;
	private LongValue CounterValue;
	private LongValue UpTracker;
	private LongValue startTime ;
	private LongValue elapsedTime;
	private LongValue previousTime;
	private Pane pane;
	private Button KeyboardInput;
	private Random RandomGenerator=new Random();
	private Scene GameOverScene;
	private Label PausedLabel;
	private boolean dropStar=false;
	private Label StarLabel;
	private boolean paused;
	private Star star;
	private int StarValue;
	private colorChanger colorChanger;
	private boolean dropChanger=false;
	private boolean dropCan=false;
	private Scene CrashedScreen;
	private Button GameOverButton=new Button();
	private LongValue cantime=new LongValue(0);
	private can Can=null;
	Game(String Player,MainApplication Parent) throws IOException{
		this.TimeElapsed=0;
		this.Points=0;
		this.Player=Player;
		this.Parent=Parent;
		this.Status=1;
		pane=new BorderPane();
		this.PlayingScreen=new Scene(pane,XVALUE,YVALUE);
		this.ball=new Ball();
		this.KeyboardInput=new Button("ball move");
		this.previousTime=new LongValue(0);
		this.UpTracker=new LongValue(0);
		this.CounterValue=new LongValue(0);
		this.AllObstacles=new ArrayList<Obstacle>();
		this.CurrentObstacle=null;
		this.ObstaclePane=null;
		this.paused=false;
		this.colorChanger=null;
		this.StarValue=0;
		this.ScreenType="Playing";
		//initializeStar();
		initializeKeys();
		initializeCrashedScreen();
		initializecan();
		
		// setting black background for pane
		pane.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
		
		// adding ball in pane
		pane.getChildren().add(ball.getBall());
		
		// adding keyboardinput in pane
		this.KeyboardInput.setManaged(false);
		pane.getChildren().add(this.KeyboardInput);
		
		// adding timer
		TimerLabel=new Label();
		TimerLabel.setText("Points 0");
		TimerLabel.setFont(new Font("Arial",24));
		TimerLabel.setTextFill(Color.GOLD);;
		Group TimerGroup=new Group();
		TimerGroup.getChildren().add(TimerLabel);
		pane.getChildren().add(TimerGroup);	
		
		
		
		//initializing obstacle
		initializeObstacle();
		initializePausedLabel();
		initializeStarLabel();
		setCollision();
		initializeGameOver();
		
	}
	
	public void initializeCrashedScreen() {
		Label label=new Label();
		label.setText("YOU CRASHED");
		Pane p=new Pane();
		Button b=new Button();
		
		CrashedScreen=new Scene(p,XVALUE,YVALUE);
		
		
	}
	
	public void initializecan() {
		if(this.Can!=null) {
			this.pane.getChildren().remove(this.Can);
		}
		
		this.Can=new can();
		this.pane.getChildren().add(this.Can.getPane());	
		Can.getPane().setTranslateX(0);
		Can.getPane().setTranslateY(300);
		
	}
	
	public void initializeStar() {
		try {
			if(this.star!=null) {
				this.pane.getChildren().remove(this.star);
			}
			this.star=new Star();
			this.pane.getChildren().add(star.getPane());	
			star.getPane().setTranslateX(0);
			star.getPane().setTranslateY(300);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void initializecolorChanger() throws IOException {
		this.colorChanger=new colorChanger();
		this.pane.getChildren().add(colorChanger.getPane());
		colorChanger.getPane().setTranslateX(160);
		colorChanger.getPane().setTranslateY(300);
		
	}
	
	public void initializePausedLabel() {
		PausedLabel=new Label();
		PausedLabel.setText("Press Spacebar to pause game ");
		PausedLabel.setFont(new Font("Arial",24));
		PausedLabel.setTextFill(Color.GOLD);
		Group group=new Group(PausedLabel);
		group.setTranslateX(250);
		pane.getChildren().add(group);
	}
	
	public void initializeStarLabel() {
		if(StarLabel!=null) {
			StarLabel.setTranslateY(1000);
		}
		StarLabel=new Label();
		StarLabel.setText("Stars "+StarValue);
		StarLabel.setFont(new Font("Arial",24));
		StarLabel.setTextFill(Color.GOLD);
		Group group=new Group(StarLabel);
		group.setTranslateX(750);
		pane.getChildren().add(group);
		
		
	}
	
	public void changePausedLabel() {
		PausedLabel.setText("PAUSED \n Press Spacebar to resume game \n Press q to exit \n Press s to save game");
		PausedLabel.setFont(new Font("Arial",34));
		//PausedLabel.setTextFill(Color.GOLD);
		
		
		PausedLabel.setTranslateY(250);
	}
	
	public void changeResumeLabel() {
		PausedLabel.setText("Press Spacebar to pause game ");
		PausedLabel.setFont(new Font("Arial",24));
		PausedLabel.setTextFill(Color.GOLD);
		PausedLabel.setTranslateY(10);
		
	}
	public void initializeKeys() {
		
	
		
		KeyboardInput.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent k) {
				
				
				if(k.getCode()==KeyCode.Q) {
					try {
						Parent.loadGame();
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				// help screen
				if(k.getCode()==KeyCode.H && Parent.CurrentState.equals("MainMenu")) {
					Parent.CurrentState="HelpScreen";
					Parent.primaryStage.setScene(Parent.HelpScreen);
				}
				
				
				
				if(k.getCode()==KeyCode.ENTER) {
					if(!paused) {
					UpTracker.setValue(0);
					ball.move(-25f, 0.1);
					}
					
				}
				
				if(k.getCode()==KeyCode.Q && paused) {
					Parent.primaryStage.setScene(Parent.MainMenu);
					
				}
				
				if(k.getCode()==KeyCode.SPACE) {
					
					
					if(!paused) {
						paused=true;
						changePausedLabel();
						timer.stop();
						
						
					}
					else {
						paused=false;
						changeResumeLabel();
						timer.start();
					}
				}
				
			}
		});
		
	}
	
	public void setCollision() {
ball.getBall().boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
			
	
	
			
	
	
	
	
			
			@Override
			public void changed(ObservableValue<? extends Bounds> observable,Bounds oldValue,Bounds newValue) {
				
				
				
				
				if(Can!=null) {
					Group group=(Group)Can.getPane().getChildren().get(0);
					Circle circle=(Circle)group.getChildren().get(0);
					 if(((Path)Shape.intersect(ball.getBall(), circle)).getElements().size()>0) {

				 			cantime.setValue(10);
				 	
				 			pane.getChildren().remove(star.getPane());
				 			Can=null;
				 			

                 }
					
				}
				
				
				// collision for star
				if(star!=null) {
					Group group=(Group)star.getPane().getChildren().get(0);
					Circle c=(Circle)group.getChildren().get(0);
					
					 if(((Path)Shape.intersect(ball.getBall(), c)).getElements().size()>0) {

						 			StarValue+=star.getValue();
						 			initializeStarLabel();
						 			pane.getChildren().remove(star.getPane());
						 			star=null;
						 			

	                        }
					
					
				}
				
				// collision for color changer
				if(colorChanger!=null) {				
				Group ColorChanger=(Group)colorChanger.getPane().getChildren().get(1);
				for(Node a:ColorChanger.getChildren()){
					
				if(((Path)Shape.intersect(ball.getBall(), (Arc)(a))).getElements().size()>0) {
					ball.getBall().setFill((((Triangle)(AllObstacles.get(2))).getColours()).get(RandomGenerator.nextInt(3)));	
					colorChanger.getPane().setTranslateY(1000);
				}
				}
				}
				
				// collisioon for obstacle
				Shape current=new Line();
				
				if(cantime.getValue()<=0) {
				for(Shape object:CurrentObstacle.getComponents()) {
					
					 if(((Path)Shape.intersect(ball.getBall(), object)).getElements().size()>0) {



	                        if( !current.equals(object)) {
	                            //System.out.println(object.get);
	                            current=object;
	                            if(!(ball.getBall().getFill().equals(object.getStroke())))

	                            {
	                            	paused=true;
	                            	timer.stop();
	                            	initializeGameOver();
	                                Parent.primaryStage.setScene(GameOverScene);
	                            }


	                        }}
					
					
				}
			}}
			
		});
	}
	public void addObstacle() {
		
		// making the game harder 
		
		int random=RandomGenerator.nextInt(this.AllObstacles.size());
		if(this.Points<=4 && random>3) {
			random=random-2;
		}
		else if(this.Points<=8 && random >=3) {
			random=random-1;
		}
		else if(this.Points>=9 && random<=3 ) {
			random=random+1;
		}
		//System.out.println(random);
		if(this.CurrentObstacle==null ) {
			
			// selecting a random obstacle
			this.CurrentObstacle=this.AllObstacles.get(random);
			this.CurrentObstacle.getPane().setTranslateY(-30);
			this.ObstaclePane=CurrentObstacle.getPane();	
			this.pane.getChildren().add(this.ObstaclePane);
		}
		
		else if(this.CurrentObstacle.getPane().getTranslateY()>700) {
			this.Points=this.Points+1;
			this.TimerLabel.setText("Points "+this.Points);
			this.pane.getChildren().remove(this.ObstaclePane);
			this.CurrentObstacle=this.AllObstacles.get(random);
			this.CurrentObstacle.getPane().setTranslateY(-30);
			this.ObstaclePane=CurrentObstacle.getPane();	
		    this.pane.getChildren().add(this.ObstaclePane);
			
		}
		setCollision();
		
	}
	
	public void initializeGameOver() {
		Pane p=new Pane();
		p.getChildren().add(GameOverButton);
		this.GameOverScene=new Scene(p,XVALUE,YVALUE);
		
		Label over=new Label();
		over.setText("YOU CRASHED \n To continue press u if you have atleast 10 stars or press q to exit");
		over.setFont(new Font("Arial",24));
		over.setTextFill(Color.GOLD);;
		Group TimerGroup=new Group();
		TimerGroup.getChildren().add(over);
		p.getChildren().add(over);	
		
		over.setTranslateX(100); over.setTranslateY(300);
		
		Label second=new Label();
		second.setText("Your points "+Points);
		second.setFont(new Font("Arial",24));
		second.setTextFill(Color.GOLD);;
		Group Timer=new Group();
		Timer.getChildren().add(second);
		p.getChildren().add(Timer);	
		second.setTranslateX(100); second.setTranslateY(400);
		
		
		Label Third=new Label();
		Third.setText("Your stars "+StarValue);
		Third.setFont(new Font("Arial",24));
		Third.setTextFill(Color.GOLD);
		Timer=new Group();
		Timer.getChildren().add(Third);
		p.getChildren().add(Timer);	
		Third.setTranslateX(100); Third.setTranslateY(500);
		
		
		
		
		GameOverButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent k) {
				
				
				// help screen
				if(k.getCode()==KeyCode.U) {
					if(StarValue>=10) {
						StarValue=StarValue-10;
						
						Parent.primaryStage.setScene(PlayingScreen);
						paused=false;
						timer.start();
						initializeStar();
						
						
					}
					
				}
				
				if(k.getCode()==KeyCode.Q) {
					MainApplication mp=Parent;
					mp.primaryStage.setScene(mp.MainMenu);
					mp.CurrentGame=null;
				}
				
				
				
			}
		});
		
		
		p.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
		
	}
	
	public void initializeObstacle() throws IOException {
		
		Obstacle SimpleCircle=new SimpleCircle(this);
		//this.pane.getChildren().add(SimpleCircle.getPane());
		AllObstacles.add(SimpleCircle);
		
		
		Obstacle Rectangle=new Parallellogram(this);
		//this.pane.getChildren().add(Rectangle.getPane());
		AllObstacles.add(Rectangle);
		
		Obstacle Triangle=new Triangle(this);
		AllObstacles.add(Triangle);
		ball.getBall().setFill(Triangle.getColours().get(0));
		
		Obstacle DoubleCircle=new DoubleCircle(this);
		AllObstacles.add(DoubleCircle);
		
		Obstacle TriInCircle=new TriInCircle(this);
		AllObstacles.add(TriInCircle);		
		
	}
	
	
	
	// main body of game
	public void startGame() {
		startTime =new LongValue(System.nanoTime());
		
		
		 timer=new AnimationTimer() {
			;
			@Override
			public void handle(long now) {
				
				if( ObstaclePane==null || ObstaclePane.getTranslateY()>700) {
				addObstacle();
				}
				// making ball jump
				
				
				
				
				// checking for collisions
				
				
			
				elapsedTime=new LongValue((now-startTime.getValue())/10000000);
				// checking if a second has passed
				if(elapsedTime.getValue()>previousTime.getValue()) {
					
					// code for timer
					if(((long)elapsedTime.getValue()/100)>CounterValue.getValue()) {
						
						if(cantime.getValue()>0) {
							cantime.setValue(cantime.getValue()-1);
						}
						
						
						
						
						
						CounterValue.setValue(CounterValue.getValue()+1);
						
						
						
						if(Points%2==0 &&  Points%3!=0 &&Points!=0 && !dropChanger) {
							dropChanger=!dropChanger;
						}
						
						if(Points%3==0 && dropChanger) {
							try {
								dropChanger=!dropChanger;
								initializecolorChanger();
								
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					//TimerLabel.setText("Time Elapsed "+CounterValue.getValue());
					
					}
					
					if(Points%2==0 && Points%5!=0 && Points!=0 && !dropStar) {
						dropStar=!dropStar;
						
					}
					
					if(Points%5==0 && dropStar) {
						dropStar=!dropStar;
						initializeStar();
						
					}
					
					if(Points%2==0 && Points%5!=0 && Points!=0 && !dropCan) {
						dropCan=!dropCan;
						
					}
					
					if(Points%5==0 && dropCan) {
						dropCan=!dropCan;
						initializecan();
						
					}
					
					
					
					
					
					if(ball.getBall().getCenterY()-CurrentObstacle.returnYValue()<=15 || CurrentObstacle.returnYValue()<0) {
						
						CurrentObstacle.move(3, 0.1);
						CurrentObstacle.move(2, 0.1);
						
						
					}
					
					// making the ball fall 
					// uptracker checks when was the last time the ball flew up
					UpTracker.setValue(UpTracker.getValue()+1);
					if(ball.getBall().getCenterY()<400 && UpTracker.getValue()>=15) {
						ball.move(1.8f, 0.1);
					}
				}
				
				
				
				
			}

			
		};
		
		timer.start();
		
		
		
	}
	
	
	
	
	protected int getTimeElapsed() {
		return TimeElapsed;
	}
	protected void setTimeElapsed(int timeElapsed) {
		TimeElapsed = timeElapsed;
	}
	protected int getPoints() {
		return Points;
	}
	protected void setPoints(int points) {
		Points = points;
	}
	protected String getPlayer() {
		return Player;
	}
	protected void setPlayer(String player) {
		Player = player;
	}
	protected MainApplication getParent() {
		return Parent;
	}
	protected void setParent(MainApplication parent) {
		Parent = parent;
	}
	protected int getStatus() {
		return Status;
	}
	protected void setStatus(int status) {
		Status = status;
	}
	protected Scene getPlayingScreen() {
		return PlayingScreen;
	}
	protected void setPlayingScreen(Scene playingScreen) {
		PlayingScreen = playingScreen;
	}
	protected Ball getBall() {
		return ball;
	}
	protected void setBall(Ball ball) {
		this.ball = ball;
	}
	protected int getXVALUE() {
		return XVALUE;
	}
	protected int getYVALUE() {
		return YVALUE;
	}
	
	protected LongValue getStartTime() {
		return startTime;
	}


	protected void setStartTime(LongValue startTime) {
		this.startTime = startTime;
	}


	protected LongValue getElapsedTime() {
		return elapsedTime;
	}


	protected void setElapsedTime(LongValue elapsedTime) {
		this.elapsedTime = elapsedTime;
	}


	protected Button getKeyboardInput() {
		return KeyboardInput;
	}


	protected void setKeyboardInput(Button keyboardInput) {
		KeyboardInput = keyboardInput;
	}
	
	protected AnimationTimer getTimer() {
		return timer;
	}


	protected void setTimer(AnimationTimer timer) {
		this.timer = timer;
	}


	protected Label getTimerLabel() {
		return TimerLabel;
	}


	protected void setTimerLabel(Label timerLabel) {
		TimerLabel = timerLabel;
	}


	protected LongValue getPreviousTime() {
		return previousTime;
	}


	protected void setPreviousTime(LongValue previousTime) {
		this.previousTime = previousTime;
	}

	protected ArrayList<Obstacle> getAllObstacles() {
		return AllObstacles;
	}

	protected void setAllObstacles(ArrayList<Obstacle> allObstacles) {
		AllObstacles = allObstacles;
	}

	protected Obstacle getCurrentObstacle() {
		return CurrentObstacle;
	}

	protected void setCurrentObstacle(Obstacle currentObstacle) {
		CurrentObstacle = currentObstacle;
	}

	protected LongValue getCounterValue() {
		return CounterValue;
	}

	protected void setCounterValue(LongValue counterValue) {
		CounterValue = counterValue;
	}

	protected LongValue getUpTracker() {
		return UpTracker;
	}

	protected void setUpTracker(LongValue upTracker) {
		UpTracker = upTracker;
	}

	public  class LongValue{
        long value;
        LongValue(long v){
            value=v;
        }
        protected long getValue() {
            return value;
        }
        protected void setValue(long value) {
            this.value = value;
        }
    }
	
	
	
	
	

}
