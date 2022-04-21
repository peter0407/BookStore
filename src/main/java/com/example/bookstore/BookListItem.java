package com.example.bookstore;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BookListItem extends VBox {
    private static final double CARD_WIDTH = 200;
    private static final double CARD_HEIGHT = CARD_WIDTH * 1.424;
    // Rectangle card=new Rectangle(0,0,CARD_WIDTH*1.1,CARD_HEIGHT*1.3);
    ImageView bookcover = new ImageView("C:\\Users\\Gira\\Desktop\\Screenshot 2021-11-17 233206.png");
    ColordLabel bookName = new ColordLabel("Unnamed", FontUlilities.heading3, ColorUtilities.BABYBLUE);
    ColordLabel cost = new ColordLabel("UnPriced", FontUlilities.heading4bold, ColorUtilities.BABYBLUE);
    ColordLabel discont=new ColordLabel("%off!", FontUlilities.heading4, Color.RED.darker());
    String FinalCost(double cost) {
        String Cost = String.valueOf(cost);
        for (int i = 0; i < Cost.length(); i++) {
            if (Cost.charAt(i) == '.' && Cost.length() > (i + 2)) {
                return Cost.substring(0, i + 3);
            } else if(Cost.charAt(i) == '.') {
                return Cost.substring(0, i + 2);
            }
        }
        return "0.00";
    }

    BookListItem() {
        super(5);
        super.setMaxWidth(CARD_WIDTH + 20);
        super.setMaxHeight(CARD_HEIGHT + 20);


        bookcover.setFitHeight(CARD_HEIGHT - (int) (CARD_HEIGHT / 20));
        bookcover.setFitWidth(CARD_WIDTH - (int) (CARD_WIDTH / 20));

        this.getChildren().add(bookcover);
        this.getChildren().add(bookName);
        this.getChildren().add(cost);


        this.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, new CornerRadii(CARD_WIDTH / 30), new BorderWidths(5, 5, 5, 5))));


    }

    BookListItem(String uri, String bookName, double Cost) {

        super(5);
        super.setMaxWidth(CARD_WIDTH);
        super.setMaxHeight(CARD_HEIGHT);


        this.bookcover.setImage(new Image(uri));
        this.bookName = new ColordLabel(bookName, FontUlilities.heading4bold, ColorUtilities.BABYBLUE);
        this.cost = new ColordLabel(FinalCost(Cost), FontUlilities.heading5bold, ColorUtilities.BABYBLUE);


        this.setLayoutX(CARD_WIDTH * 2);
        this.setWidth(CARD_WIDTH * 1.1);

        bookcover.setFitHeight(CARD_HEIGHT - (int) (CARD_HEIGHT / 17));
        bookcover.setFitWidth(CARD_WIDTH - (int) (CARD_WIDTH / 17));

        this.getChildren().add(bookcover);
        this.getChildren().add(this.bookName);
        this.getChildren().add(cost);

        this.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, new CornerRadii(CARD_WIDTH / 30), new BorderWidths(5, 5, 5, 5))));
    }

    BookListItem(String uri, String bookName, double Cost, boolean hasDiscount, double discount) {

        super(5);
        super.setMaxWidth(CARD_WIDTH);
        super.setMaxHeight(CARD_HEIGHT);
        this.setPadding(new Insets(3,3,3,3));

        this.bookcover.setImage(new Image(uri));
        this.bookName = new ColordLabel(bookName, FontUlilities.heading4bold, ColorUtilities.BABYBLUE);
        if (!hasDiscount)
            this.cost = new ColordLabel(FinalCost(Cost), FontUlilities.heading5bold, ColorUtilities.BABYBLUE);
        else
            this.cost = new ColordLabel(String.valueOf(FinalCost(((1.0 - discount / 100) * Cost))), FontUlilities.heading5bold, ColorUtilities.BABYBLUE);


        this.discont=new ColordLabel(String.valueOf(discount)+" %off!", FontUlilities.heading5bold, Color.RED.darker());

        this.setLayoutX(CARD_WIDTH * 2);
        this.setWidth(CARD_WIDTH * 1.1);

        bookcover.setFitHeight(CARD_HEIGHT - (int) (CARD_HEIGHT / 17));
        bookcover.setFitWidth(CARD_WIDTH - (int) (CARD_WIDTH / 17));

        this.getChildren().add(bookcover);
        this.getChildren().add(this.bookName);
        HBox CostwithDiscount=new HBox(20);
        CostwithDiscount.getChildren().addAll( cost,this.discont);
        this.getChildren().add(CostwithDiscount);
        this.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, new CornerRadii(CARD_WIDTH / 30), new BorderWidths(5, 5, 5, 5))));
    }

    void SetOnClickListener(){
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
    }
}
