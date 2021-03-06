
package xatrock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


public class StudentAboutXatrockPage2Controller implements Initializable {

    Scene scene ;
    Parent parent;
    @FXML
    private Button beforeButton;
    @FXML
    private AnchorPane aboutXatrockPagePane2;
    @FXML
    private Button homePageButton;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
    private void switchToAboutXatrockPage1(ActionEvent e) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("StudentAboutXatrockPage1.fxml"));
        scene = new Scene(root);
        scene = beforeButton.getScene();
        root.translateYProperty().set(scene.getHeight());
        aboutXatrockPagePane2.getChildren().add(root);
        Timeline timeLine = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1) , kv);
        timeLine.getKeyFrames().add(kf);
        timeLine.play();
    }
    @FXML
    private void switchToHomePage(ActionEvent e) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("StudentHomePage.fxml"));
        scene = new Scene(root);
        scene = homePageButton.getScene();
        root.translateYProperty().set(scene.getHeight());
        aboutXatrockPagePane2.getChildren().add(root);
        Timeline timeLine = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1) , kv);
        timeLine.getKeyFrames().add(kf);
        timeLine.play();
        
    }
    
}
