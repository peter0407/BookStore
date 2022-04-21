package com.example.bookstore.customclasses;

import com.example.bookstore.utilities.ColorUtilities;
import com.example.bookstore.utilities.FontUlilities;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LabledInput extends VBox {
    Label label;
    TextField textField = new TextField("");
    TextArea textArea;

    LabledInput() {
        super();
    }

    LabledInput(String FieldName) {
        super(10);
        label = new Label(FieldName);
        label.setFont(FontUlilities.heading2bold);
        textField.setPrefColumnCount(25);
        super.getChildren().addAll(label, textField);
    }

    LabledInput(String FieldName, Color color) {
        super(5);
        label = new Label(FieldName);
        label.setFont(FontUlilities.heading2bold);
        label.setStyle("-fx-text-fill:" + ColorUtilities.getColorhex(color) + ";");
        textField.setPrefColumnCount(25);
        super.getChildren().addAll(label, textField);
    }

    public LabledInput(String FieldName, Color color, Font f) {
        super(5);
        label = new Label(FieldName);
        label.setFont(f);
        label.setStyle("-fx-text-fill:" + ColorUtilities.getColorhex(color) + ";");
        textField.setPrefColumnCount(25);
        super.getChildren().addAll(label, textField);
    }

    public LabledInput(String FieldName, Color color, Font f, boolean isComment) {
        super(5);
        label = new Label(FieldName);
        label.setFont(f);
        label.setStyle("-fx-text-fill:" + ColorUtilities.getColorhex(color) + ";");
        textField.setPrefColumnCount(25);
        if (isComment) {
            textArea = new TextArea();
            textArea.setPrefColumnCount(50);
            textArea.setPrefRowCount(10);
            super.getChildren().addAll(label, textArea);
        } else
            super.getChildren().addAll(label, textField);
    }
}
