package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    private static Stage stage;

    private static Scene loginScene;
    private static Scene registerScene;
    private static Scene taskScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;

        primaryStage.setTitle("4Task - Task Manager");
        Image applicationIcon = new Image(getClass().getResourceAsStream("../Models/xx.png"));
        primaryStage.getIcons().add(applicationIcon);

        Parent fxmlLoginScreen = FXMLLoader.load(getClass().getResource("../Views/loginscreen.fxml"));
        loginScene = new Scene(fxmlLoginScreen);


        Parent fxmlRegisterScreen = FXMLLoader.load(getClass().getResource("../Views/registerscreen.fxml"));
        registerScene = new Scene(fxmlRegisterScreen);

        Parent fxmlTaskScreen = FXMLLoader.load(getClass().getResource("../Views/taskscreen.fxml"));
        taskScene = new Scene(fxmlTaskScreen);
        
        primaryStage.setResizable(false);


        primaryStage.setScene(loginScene);
        primaryStage.show();
        }

        public static void changeScreen(String scr){
        switch (scr){
            case "login":
                stage.setScene(loginScene);
                break;
            case "register":
                stage.setScene(registerScene);
                break;
            case "task":
                stage.setScene(taskScene);
            }
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
