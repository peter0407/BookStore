package com.example.bookstore;


import com.example.bookstore.customclasses.ColordLabel;
import com.example.bookstore.customclasses.FancyButton;
import com.example.bookstore.customclasses.LabledInput;
import com.example.bookstore.customclasses.ScrollVeiw;
import com.example.bookstore.listitems.BookListItem;
import com.example.bookstore.utilities.ColorUtilities;
import com.example.bookstore.utilities.FontUlilities;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        Scene dynamicscene = new Scene(LoadLoginPane(), 350, 600);
        stage.setTitle("aa");
        stage.setScene(dynamicscene);
        stage.show();

    }

    GridPane LoadLoginPane() {

        //Login Pane
        GridPane LoggingPane = new GridPane();
        LoggingPane.setVgap(10);

        ColordLabel Signin = new ColordLabel("Sign in", FontUlilities.heading1bold, ColorUtilities.BABYBLUE);
        LabledInput Username = new LabledInput("Username or E-mail", Color.GRAY, FontUlilities.heading3bold);
        LabledInput Password = new LabledInput("Password", Color.GRAY, FontUlilities.heading3bold);
        GridPane.setMargin(Username, new Insets(0, 0, 0, 20));
        GridPane.setMargin(Password, new Insets(0, 0, 0, 20));
        Button signinbutton = new FancyButton("Sign in", FontUlilities.heading4);
        ColordLabel signupLabel = new ColordLabel("Don't Have an account? Signup", FontUlilities.heading5, ColorUtilities.BABYBLUE, true);
        LoggingPane.add(Signin, 0, 0);
        LoggingPane.add(Username, 0, 1);
        LoggingPane.add(Password, 0, 2);
        LoggingPane.add(signinbutton, 0, 3);
        LoggingPane.add(signupLabel, 0, 4);
        LoggingPane.setAlignment(Pos.CENTER);


        signinbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //(verifyfunc)

                Screen screen = Screen.getPrimary();

                Rectangle2D bounds = screen.getVisualBounds();

                signinbutton.getScene().getWindow().setX(bounds.getMinX());
                signinbutton.getScene().getWindow().setY(bounds.getMinY());
                signinbutton.getScene().getWindow().setWidth(bounds.getWidth());
                signinbutton.getScene().getWindow().setHeight(bounds.getHeight());

                signinbutton.getScene().setRoot(LoadMainPane(LoadHomeScreen()));

            }
        });

        GridPane.setHalignment(signinbutton, HPos.RIGHT);
        GridPane.setHalignment(signupLabel, HPos.RIGHT);


        return LoggingPane;
    }

    // Main pane = upper bar +(Book screen ,cart screen, Home screen)
    VBox LoadMainPane(Pane Tab) {

        VBox MainContaier = new VBox(5);

        //upper Bar
        HBox upperbar = new HBox(10);

        upperbar.setStyle("-fx-background-color:" + ColorUtilities.getColorhex(ColorUtilities.BABYBLUE));
        Button UserButton = new FancyButton("User", ColorUtilities.BABYBLUE, Color.WHITE, FontUlilities.heading4bold, 5);
        Button CartButton = new FancyButton("Cart", ColorUtilities.BABYBLUE, Color.WHITE, FontUlilities.heading4bold, 5);
        Button LogoutButton = new FancyButton("Logout", ColorUtilities.BABYBLUE, Color.WHITE, FontUlilities.heading4bold, 5);
        Button HomeButton = new FancyButton("Home", ColorUtilities.BABYBLUE, Color.WHITE, FontUlilities.heading4bold, 5);

        upperbar.getChildren().addAll(HomeButton, UserButton, CartButton, LogoutButton);

        upperbar.setAlignment(Pos.TOP_RIGHT);

        MainContaier.getChildren().add(upperbar);
        MainContaier.getChildren().add(Tab);

        HomeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               HomeButton.getScene().setRoot(LoadMainPane(LoadHomeScreen()));
            }
        });

        LogoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                LogoutButton.getScene().getWindow().setHeight(600);
                LogoutButton.getScene().getWindow().setWidth(350);
                LogoutButton.getScene().getWindow().centerOnScreen();
                LogoutButton.getScene().setRoot(LoadLoginPane());
            }
        });
        CartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
        if (Tab.getChildren().get(0) instanceof ScrollVeiw) {
            StackPane containsScroll = (StackPane) (MainContaier.getChildren().get(1));
            ScrollVeiw containsbookscene = (ScrollVeiw) (containsScroll.getChildren().get(0));
            BorderPane containsBorders = (BorderPane) (containsbookscene.getContent());
            VBox containsinfo = (VBox) (containsBorders.getCenter());
            Text description = (Text) (containsinfo.getChildren().get(1));
            description.wrappingWidthProperty().bind(MainContaier.widthProperty().divide(2.3));
        }
        return MainContaier;
    }

    //Home Screen Loader
    BorderPane LoadHomeScreen() {
        //Home Tab
        BorderPane homeTab = new BorderPane();
        //maincontaner with home

        final int menusize = 300;


        // getting top pane (Home TEXT) ready
        StackPane homePane = new StackPane();
        ColordLabel Homelabel = new ColordLabel("Home", FontUlilities.heading1bold, ColorUtilities.BABYBLUE);
        homePane.getChildren().add(Homelabel);
        StackPane.setAlignment(Homelabel, Pos.CENTER_LEFT);
        Homelabel.setPadding(new Insets(30, 0, 30, menusize));
        //setting it to Border pane Top
        homeTab.setTop(homePane);



        //getting menu pane ready
        StackPane menuPane = new StackPane();
        ColordLabel Menulabel = new ColordLabel("Menu", FontUlilities.heading1bold, ColorUtilities.BABYBLUE);
        menuPane.getChildren().add(Menulabel);
        StackPane.setAlignment(Menulabel, Pos.TOP_CENTER);
        StackPane.setMargin(Menulabel, new Insets(30, (int) (menusize / 3), 30, 50));
        //setting menu pane to Border left
        homeTab.setLeft(menuPane);




        //getting center pane ready
        FlowPane f = new FlowPane(20, 20);
        f.setMinWidth(homeTab.getWidth() - menusize);

        ScrollVeiw HomeScrollPane = new ScrollVeiw(f, 3);


        HomeScrollPane.setFitToWidth(true);
        HomeScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);


        for (int i = 0; i < 30; i++) {
            if (i % 3 == 0)
                f.getChildren().add(new BookListItem("C:\\Users\\Gira\\Desktop\\Screenshot 2021-11-17 233206.png", "How to be Happy", i, 19.99, true, 10));
            else
                f.getChildren().add(new BookListItem("C:\\Users\\Gira\\Desktop\\Screenshot 2021-11-17 233206.png", "How to be Happy", i, 19.99));


            int finalI = i;
            f.getChildren().get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    final int j = finalI;
                    f.getScene().setRoot(LoadMainPane(LoadBookScreen((BookListItem) (f.getChildren().get(finalI)))));
                }
            });
        }
        homeTab.setCenter(HomeScrollPane);
        BorderPane.setAlignment(f, Pos.TOP_LEFT);


     /*   //Main Container Composition +scene
        MainContaier.getChildren().addAll(upperbar,homeTab);
        Scene HomeScene = new Scene(MainContaier,1280,720);
*/
        return homeTab;
    }

    //Book screen Loader
    StackPane LoadBookScreen(BookListItem book) {


        //Book tab

        final int BOOKWIDTH = 300;
        BorderPane bookTabBorderPane = new BorderPane();
        ScrollVeiw bookTabScrollView = new ScrollVeiw(bookTabBorderPane, 2);
        StackPane ALL = new StackPane(bookTabScrollView);


        //Center pane,Book info
        VBox centerPane = new VBox(10);
        centerPane.setMaxWidth(500);
        ColordLabel bookName = (book.getBookName());
        bookName.setFont(FontUlilities.heading1bold);
        Text bookDescription = new Text("This is Description.This is DescriptionThis is Description.This is DescriptionThis is Description.This is Description" +
                "This is Description.This is DescriptionThis is Description.This is DescriptionThis is Description.This is Description" +
                "This is Description.This is DescriptionThis is Description.This is DescriptionThis is Description.This is Description" +
                "This is Description.This is DescriptionThis is Description.This is DescriptionThis is Description.This is Description");

        bookDescription.wrappingWidthProperty().bind(centerPane.widthProperty());
        ColordLabel commentslabel = new ColordLabel("Reviews", FontUlilities.heading1bold, ColorUtilities.BABYBLUE);

        //Comments vbox->will be scrollview soon
        VBox Reviews = new VBox(10);
        ScrollVeiw reviewssScrollView = new ScrollVeiw(Reviews, 2);
        reviewssScrollView.setMaxHeight(300);
        reviewssScrollView.setFitToWidth(true);
        reviewssScrollView.setFitToHeight(true);
        Reviews.setPadding(new Insets(0, 0, 20, 20));
        for (int i = 0; i < 30; i++) {
            Reviews.getChildren().add(new Text("Very Good"));
        }

        centerPane.getChildren().addAll(bookName, bookDescription, commentslabel, reviewssScrollView);
        VBox.setMargin(bookDescription, new Insets(0, 0, 20, 20));
        centerPane.setPadding(new Insets(10, 0, 20, 30));

        //Assigning info to PaneCenter
        bookTabBorderPane.setCenter(centerPane);


        //Leftpane pane,Book cover

        StackPane leftPane = new StackPane();
        leftPane.setPadding(new Insets(20, 20, 20, 10));
        ImageView bookcover = book.getBookcover();
        bookcover.setFitWidth(BOOKWIDTH);
        bookcover.setFitHeight(BOOKWIDTH * 1.414);

        leftPane.getChildren().add(bookcover);
        leftPane.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID,
                new CornerRadii(5), new BorderWidths(0, 5, 0, 0))));
        StackPane.setAlignment(bookcover, Pos.TOP_LEFT);

        bookTabBorderPane.setLeft(leftPane);
        leftPane.setPrefWidth(BOOKWIDTH + 20);
        BorderPane.setMargin(leftPane, new Insets(10, 0, 0, 20));

        //Right  pane,ِAdd to Cart Button :)+ cost and discount if exists

        VBox rightPane = new VBox(20);

        if (book.isHasDiscount()) {
            HBox CostwithDiscount = new HBox(10);
            ColordLabel cost = new ColordLabel(book.getCost());
            ColordLabel dicount = new ColordLabel(book.getDiscont());
            CostwithDiscount.getChildren().addAll(cost, dicount);
            cost.setFont(FontUlilities.heading3bold);
            dicount.setFont(FontUlilities.heading3bold);
            rightPane.getChildren().add(CostwithDiscount);
        } else {
            ColordLabel cost = new ColordLabel(book.getCost());
            cost.setFont(FontUlilities.heading2bold);
            rightPane.getChildren().add(cost);

        }
        Button addToCartbutton = new FancyButton("Add To Cart", ColorUtilities.BABYBLUE, Color.WHITE, FontUlilities.heading3bold, (int) (FontUlilities.heading3bold.getSize()));
        rightPane.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID,
                new CornerRadii(5), new BorderWidths(0, 0, 0, 5))));
        rightPane.setPadding(new Insets(20, 20, 20, 20));
        ;
        rightPane.getChildren().add(addToCartbutton);
        StackPane.setAlignment(addToCartbutton, Pos.TOP_CENTER);

        //Assigning Pane to rightpane
        bookTabBorderPane.setRight(rightPane);
        BorderPane.setMargin(rightPane, new Insets(10, 20, 0, 0));

        //leftPane.setMaxHeight(leftPane.getHeight());

        //Bottom pane: add Comment

        LabledInput BottomPane = new LabledInput("Add Comment", ColorUtilities.BABYBLUE, FontUlilities.heading1bold, true);
        StackPane stackPane = new StackPane(BottomPane);
        stackPane.setPadding(new Insets(30, 30, 30, 30));
        StackPane.setAlignment(BottomPane, Pos.TOP_LEFT);

        //Assigning addcoment pant to booktabbottom

        bookTabBorderPane.setBottom(stackPane);



     /*   //Main Container Composition +scene
        MainContaier.getChildren().addAll(upperbar, bookTab);
        Scene BookTabScene = new Scene(MainContaier, 1280, 720);
*/
        return ALL;
    }

    public static void main(String[] args) {
        launch();
    }
}
