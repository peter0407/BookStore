package com.example.bookstore.customclasses;

import com.example.bookstore.utilities.ColorUtilities;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ColordLabel extends javafx.scene.control.Label {
    String Label;
    Font font;
    Color color;
    boolean isunderlined;

    public void setLabel(String label) {
        Label = label;
    }


    public void setColor(Color color) {
        this.color = color;
    }

    public void setIsunderlined(boolean isunderlined) {
        this.isunderlined = isunderlined;
    }

    public String getLabel() {
        return Label;
    }

    public Font getfont() {
        return font;
    }

    public Color getColor() {
        return color;
    }

    public boolean isIsunderlined() {
        return isunderlined;
    }

    ColordLabel() {
        super();
    }

    ColordLabel(String Label, Font f) {
        this.Label = Label;
        this.font = f;
        this.setText(Label);
        super.setFont(f);
    }


    public ColordLabel(String Label, Font f, Color color) {
        this(Label, f);
        this.color = color;
        this.setStyle("-fx-text-fill:" + ColorUtilities.getColorhex(color) + ";");
    }

    public ColordLabel(String Label, Font f, Color color, boolean isunderlined) {
        this(Label, f, color);
        super.setStyle("-fx-text-fill:" + ColorUtilities.getColorhex(color) + ";-fx-underline:" + isunderlined + ";");
    }

    public ColordLabel(ColordLabel a) {

        this(a.getLabel(), a.getfont(), a.getColor(), a.isIsunderlined());
        this.Label = a.getLabel();
        this.font = a.getFont();
        this.color = a.getColor();
        this.isunderlined = a.isIsunderlined();

    }
}
