package hello; 
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("ABOUT TO LOAD FXML"); 
        Parent root = FXMLLoader.load(getClass().getResource("JFX.fxml"));
        System.out.println("LOADED FXML");
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
