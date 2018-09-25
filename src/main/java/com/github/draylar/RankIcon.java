package com.github.draylar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


public class RankIcon extends GridPane {

    private int width;
    private int height;

    private Image iconImage;
    private ImageView imageView = new ImageView();

    public RankIcon(int width, int height) {
        this.width = width;
        this.height = height;

        configureConstraints();
        setIconImage("grandmaster");

        this.add(imageView, 10, 90);
    }


    public void setIconImage(String icon) {
        iconImage = new Image(getClass().getResource("/" + icon + ".png").toString());
        imageView.setImage(iconImage);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
    }


    private void configureConstraints(){
        for(int x = 0; x < 10; x++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(1);
            this.getColumnConstraints().add(columnConstraints);
        }

        for(int y = 0; y < 10; y++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(1);
            this.getRowConstraints().add(rowConstraints);
        }
    }


}
