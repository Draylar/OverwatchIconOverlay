package com.github.draylar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    private static int iconHeight = 55;
    private static int iconWidth = 55;

    private static RankIcon rankIcon = new RankIcon(iconWidth, iconHeight);
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        setupStageSettings();
        setupDragControls();
        setupSystemTray();

        Scene scene = new Scene(rankIcon, 100, 100, Color.TRANSPARENT);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.U) {
                rankIcon.setVisible(!rankIcon.isVisible());
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void setCurrentRankIcon(String icon) {
        rankIcon.setIconImage(icon);
    }


    private void setupSystemTray() {
        SystemTrayInitializer initializer = new SystemTrayInitializer();
        initializer.initIcon();
    }


    private void setupStageSettings() {
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setAlwaysOnTop(true);
    }


    private void setupDragControls() {
        stage.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
            stage.setX(e.getScreenX() - (iconWidth / 2));
            stage.setY(e.getScreenY() - (iconHeight / 2));
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
