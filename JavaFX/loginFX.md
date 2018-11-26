
# Creating a login form in JavaFX

Creating a login form is a common activity when developing an application. This tutorial teaches you the basics of screen layout, how to add controls to a layout pane, and how to create input events.

In this lesson, you will use JavaFX to build the login form shown in Figure 1.

[Figure 1](https://github.com/idebtor/JoyJava/blob/master/JavaFX/images/loginFX.png)
Figure 1 Login form

## Create a GridPane layout

For the login form, use a GridPane layout because it enables you to create a flexible grid of rows and columns in which to lay out controls. You can place controls in any cell in the grid, and you can make controls span cells as needed.

The code to create the GridPane layout with gap and padding properties is shown below. Add the code before the line primaryStage.show();

```java
GridPane grid = new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(25, 25, 25, 25));

Scene scene = new Scene(grid, 300, 275);
primaryStage.setScene(scene);
```

This code creates a GridPane object and assigns it to the variable named grid. The alignment property changes the default position of the grid from the top left of the scene to the center. The gap properties manage the spacing between the rows and columns, while the padding property manages the space around the edges of the grid pane. The insets are in the order of top, right, bottom, and left. In this example, there are 25 pixels of padding on each side.

The scene is created with the grid pane as the root node, which is a common practice when working with layout containers. Thus, as the window is resized, the nodes within the grid pane are resized according to their layout constraints. In this example, the grid pane remains in the center when you grow or shrink the window. The padding properties ensure there is a padding around the grid pane when you make the window smaller.

This code sets the scene width and height to 300 by 275. If you do not set the scene dimensions, the scene defaults to the minimum size needed to display its contents.

## Add Text, Labels, and Text Fields
Looking at Figure 1, you can see that the form requires the title ”Welcome ”and text and password fields for gathering information from the user. The code for creating these controls is in Example 4-3. Add this code after the line that sets the grid padding property.
