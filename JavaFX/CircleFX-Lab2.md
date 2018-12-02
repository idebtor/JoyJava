
# CircleFX Lab2
  - JoyJava Lecture Note by idebtor@gmail.com
  ------------------
In this lab, we want to make a button work as a user clicks it.

In order for an object to be a handler:
- It must implement (be an instance of) the appropriate event handler interface for the kind of event it handles
    - `EventHandler<ActionEvent>` must be implemented by `Button` event handlers, because `Button`s will fire `ActionEvent`s.  The `EventHandler<ActionEvent>` interface forces us to provide `handle(ActionEvent e)`
- It (the handler) must be __registered__ to the source object (the method to do the registration depends on the kind of event it’s registering; for an `ActionEvent`, it’s `setOnAction`; for a keypress, it’s `setOnKeyPressed`)
- When an event occurs, the source notifies (sends a message or “places a phone call” to) every listener registered by invoking its handler method


## Method 1 - Using a class that implements the EventHandler interface.

We know that the Buttons will need a class they can fire their events to. Firstly, we create the `EnlargeHandler` class to handle the `ActionEvent`s that will come from the “Enlarge” Button. The `EnlargeHandler` class implments `EventHandler<ActionEvent>` interface. Then it must override a `handle` method, which will only have to call the CirclePane’s enlarge method.

## Method 2 - Using an anonymous inner class
#### Inner classes
- The inner class can reference fields and methods of the outer class directly, so you don’t need to pass references from the outer class to the inner class
    - Avoiding this potentially cumbersome reference issue can make your programs more simple and concise.
- “A listener class is designed specifically to create a handler object for a GUI component (e.g., a button). The handler class will not be shared by other applications and therefore is appropriate to be defined inside the main class as an inner class.”
- An anonymous inner class combines a class’s definition and instantiation in one step.

#### Anonymous Inner classes
- Since an anonymous inner class is a special kind of inner class, it is treated like an inner class with the following four features:
1. An anonymous inner class must always extend a superclass or implement an interface, but it cannot have an explicit extends or implements clause.
2. An anonymous inner class must implement all the abstract methods in the superclass or in the interface (it must “go concrete”).
3. An anonymous inner class always uses the no-arg constructor from its superclass to create an instance. If an anonymous inner class implements an interface, the constructor is Object().
4. An anonymous inner class is compiled into a class named OuterClassName$n.class. For example, if the outer class Test has two anonymous inner classes, they are compiled into Test$1.class and Test$2.class.

## Method 3 - Using a lambda expression
- Lambda Expressions (new to Java 8) can be considered an anonymous inner class with an abbreviated syntax.
- The compiler treats lambda expressions like an object created from an anonymous inner class

Follow the instructions in the code.

```java
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleFX1 extends Application {
  private CirclePane circlePane = new CirclePane();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Hold two buttons in an HBox
    HBox hBox = new HBox();
    hBox.setSpacing(10);
    hBox.setAlignment(Pos.CENTER);
    Button btEnlarge = new Button("Enlarge");
    Button btShrink = new Button("Shrink");
    hBox.getChildren().add(btEnlarge);
    hBox.getChildren().add(btShrink);

    // Create and register the handler
    // Your code here
    // 1. Using a class that implements the interface EventHandler<ActionEvent>
    // 2. Using an anonymous inner class
    // 3. Using a lambda expression

    /** Using a class **/

    /** Using an anonymous inner class **/

    /** Using a lambda expression **/

    // Create a BorderPane object, borderPane
    // Place circlePane at the center of borderPane object
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(circlePane);
    // Place hBox at the bottom of borderPane object
    // Set alignment such that hBox is located at the center.
    borderPane.setBottom(hBox);
    BorderPane.setAlignment(hBox, Pos.CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 200, 150);
    primaryStage.setTitle("ControlCircle"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * Define a class called EnlargeHandler that implements the
   * interface EventHandler<ActionEvent>.
   * Then this class must override handle(ActionEvent e).
   */
  class EnlargeHandler implements EventHandler<ActionEvent> {
    @Override // Override the handle method
    public void handle(ActionEvent e) {
      circlePane.enlarge();
    }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
```
