
# JavaFX Hello World Lab3
  - JoyJava Lecture Note by idebtor@gmail.com
  ------------------

You already have a working version of `HellFX2.java` code from the previous lesson. Now you copy it and rename it as `HelloFX3.java`.  In this lab, we do

__JoyChallenge:__
  > Do Lab2 without using a `StackPane`.
  > You may increase the size of the scene. Why is the label shown off the scene at the beginning?

  > Count the button clicks using an inner class which implements the `EventHanlder` interface.
  > Think about how you are going to handle the label object `lbl` since it is not accessible in the inner class.

The one sample output:

![Sample Output](images/HelloFX3.png)


```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloFX extends Application{

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Hello World!");

		// add two circles and two rectangles in a GridPane, color filled
		// place the button at the center in a BorderPane
		// count the button clicks
		// display the button clicks at the bottom in the BorderPane

		Circle c1 = new Circle();
		c1.setFill(Color.rgb(255, 0, 0));
		c1.setRadius(25);

		Button btn= new Button();
		btn.setFont(new Font("Calibri", 15));
		btn.setText("Say 'Hello World'");

		StackPane root = new StackPane();
		root.getChildren().add(c1);
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 300, 200));
		primaryStage.show();
	}
}
```
-------------------
__JoyLesson:__

- The intance variables are freely accessible by inner classes, but not local variables.
