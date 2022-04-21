package com.example.bookstore.customclasses;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

class DynamicImageView extends ImageView {
    DynamicImageView() {
        super();
    }

    DynamicImageView(String path, int Listsize, Pane parent) {
        super(path);
        super.fitWidthProperty().bind(parent.widthProperty().divide(Listsize));
        super.fitHeightProperty().bind(parent.heightProperty().divide(Listsize));
    }

}
