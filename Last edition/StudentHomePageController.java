
package xatrock;

import java.awt.Font;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class StudentHomePageController implements Initializable {
    Stage stage ;
    Scene scene;
    @FXML
    private Label nameLabel;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Button messengertButton;
    @FXML
    private ImageView logoutLabel;
    @FXML
    private Button mathematicButton;
    @FXML
    private Button physicButton;
    @FXML
    private Button logicalCircuitButton;
    @FXML
    private Button programmingButton;
    @FXML
    private ImageView clock;
    @FXML
    private Menu examMenue;
    private AnchorPane pane;
    @FXML
    private MenuItem editeProfileMenu;
    @FXML
    private MenuItem logoutMenu;
    @FXML
    private MenuItem physicMenu;
    @FXML
    private MenuItem mathematicMenu;
    @FXML
    private MenuItem programmingMenu;
    @FXML
    private MenuItem logicalcircuitMenu;
    @FXML
    private MenuItem physicExamMenu;
    @FXML
    private MenuItem logicalcircuitExamMenu;
    @FXML
    private MenuItem mathematicExamMenu;
    @FXML
    private MenuItem programmingExamMenu;
    @FXML
    private MenuItem aboutMenu;
    @FXML
    private Menu themMenu;
    @FXML
    private AnchorPane homePane;
    @FXML
    private CheckMenuItem darkThemeCheckMenu;
    @FXML
    private Label timeLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label lessonSeparator;
    @FXML
    private Label title;
    @FXML
    private Label eventSeparator;
    @FXML
    private Label calenderSeparetor;
    @FXML
    private Label dateSeparator;
    @FXML
    private Button logoutButton;
    @FXML
    private Label idLabel;

    LoginPageController lgc = new LoginPageController();
    //TODO String find_name (lgc.input_email){
    // String*first_name  = first name of input_email in db ;
    // String*last_name  = last name of input_email in db ;
   //  return first_name+" "+last_name; }
    String result1 = null ; //find_name (lgc.input_email)
    //TODO String find_id (lgc.input_email){
    // int*id  = id of input_email in db ;
   //  id ; }
    String result2 = null ; //find_id (lgc.input_email)
    //TODO []Object get_information(input_email){
    //return array of information of student;}

    Member member = new Member();
    
    // TODO void set_information(){
    // set all of the attribute of member object in setter methods ;
    // for ex ample : member.setFirstname(get_information[0]);
    
    // TODO int check_has_physic(idLabel.gettext()){
    // if this member has physic lesson retrun 1 ; 
    // else return 0 ; 
    
    // TODO int check_has_programming(idLabel.gettext()){
    // if this member has programming lesson retrun 1 ; 
    // else return 0 ; 
    
    // TODO int check_has_mathematic(idLabel.gettext()){
    // if this member has mathematic lesson retrun 1 ; 
    // else return 0 ; 
    
    // TODO int check_has_logicalCircuit(idLabel.gettext()){
    // if this member has ogicalCircuit lesson retrun 1 ; 
    // else return 0 ; 
    int physicResult = 0 ; // TODO =  check_has_physic(idLabel.gettext())
    int programmingResult = 0 ;// TODO= check_has_programming(idLabel.gettext())
    int mathematicResult = 0  ; //TODO = check_has_mathematic(idLabel.gettext())
    int logicalCircuitResult = 0 ;//TODO = check_has_logicalCircuit(idLabel.gettext())
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    AnimationTimer timer = new AnimationTimer() {
    @Override
    public void handle(long now) {
    timeLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    dateLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

      }
    };
    
      timer.start();
      nameLabel.setText(result1);
      idLabel.setText(result2);      
      
    }    

  
    
     
    @FXML
    private void logoutMenuHandler(ActionEvent e) throws IOException{
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("LoginPage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
    
    }
    @FXML
    private void editeprofileMenuHandler(ActionEvent e) throws IOException{
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentEditeProfilePage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
    
    }
    @FXML
    private void mathematicMenuHandler(ActionEvent e) throws IOException{
       if(mathematicResult!=1){
                  UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 22));
            JOptionPane.showMessageDialog(null , " this lesson is empty ");
       }
       else{
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentMathematicPage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
    
       }
    }
    @FXML
    private void physicMenuHandler(ActionEvent e) throws IOException{
        if(physicResult!=1){
                  UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 22));
            JOptionPane.showMessageDialog(null , " this lesson is empty ");
       }
        else{
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentPhysicPage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
    
        }
    }
    @FXML
    private void programmingMenuHandler(ActionEvent e) throws IOException{
        if(programmingResult!=1){
            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 22));
            JOptionPane.showMessageDialog(null , " this lesson is empty ");
       }
        else{
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentProgrammingPage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
       
        }
    
    }
    @FXML
    private void logicalCircuitMenuHandler(ActionEvent e) throws IOException{
        if(logicalCircuitResult!=1){
            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 22));
            JOptionPane.showMessageDialog(null , " this lesson is empty ");
       }
        else{
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentLogicalCircuitPage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
        }
    
    }
    @FXML
    private void mathematicExamMenuHandler(ActionEvent e) throws IOException{
         FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentMathematicExamPage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
       
    
    }
    @FXML
    private void physicExamMenuHandler(ActionEvent e) throws IOException{
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentPhysicExamPage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
    
    }
    @FXML
    private void programmingExamMenuHandler(ActionEvent e) throws IOException{
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentProgrammingExamPage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
    
    }
    @FXML
    private void logicalCircuitExamMenuHandler(ActionEvent e) throws IOException{
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentLogicalCircuitExamPage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
    }
    @FXML
    private void mathematicButtonHandler(ActionEvent e) throws IOException{
        if(mathematicResult==1){
                  mathematicButton.setDisable(false);
       }
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentMathematicPage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
    
    }
     @FXML
    private void logicalCircuitButtonHandler(ActionEvent e) throws IOException{
        if(logicalCircuitResult==1){
            logicalCircuitButton.setDisable(false);
        }
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentLogicalCircuitPage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
    
    }
     @FXML
    private void programmingButtonHandler(ActionEvent e) throws IOException{
        if(programmingResult==1){
            programmingButton.setDisable(false);
        }
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentProgrammingPage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
    
    }
     @FXML
    private void physicButtonHandler(ActionEvent e) throws IOException{
        if(physicResult==1){
            physicButton.setDisable(false);
        }
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentPhysicPage.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();
    
    }
    
    @FXML
    private void logoutButtonHandler (ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        scene = new Scene(root);
        scene = logoutButton.getScene();
        root.translateYProperty().set(scene.getHeight());
        homePane.getChildren().add(root);
        Timeline timeLine = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1) , kv);
        timeLine.getKeyFrames().add(kf);
        timeLine.play();
        
        

    }

    
    @FXML
    private void themeManager(ActionEvent e){
        if(darkThemeCheckMenu.isSelected()){
     homePane.setStyle("-fx-background-image:url('/xatrock/backgroundDark.png');");
     timeLabel.setStyle("-fx-text-fill:white;");
     dateSeparator.setStyle("-fx-text-fill:white;");
     eventSeparator.setStyle("-fx-text-fill:white;");
     dateLabel.setStyle("-fx-text-fill:white;");
     nameLabel.setStyle("-fx-text-fill:white;");
     idLabel.setStyle("-fx-text-fill:white;");
     calenderSeparetor.setStyle("-fx-text-fill:white;");
     lessonSeparator.setStyle("-fx-text-fill:white;");
     title.setStyle("-fx-text-fill:white;");
     nameLabel.setStyle("-fx-text-fill:white;");
     clock.setImage(new Image("/xatrock/lightClock.png"));
     logoutLabel.setImage(new Image("/xatrock/lightLogout.png"));
     
        }
      else if(darkThemeCheckMenu.isSelected() == false){
     homePane.setStyle("-fx-background-image:url('/xatrock/background.png');");
     
     timeLabel.setStyle("-fx-text-fill:black;");
     dateSeparator.setStyle("-fx-text-fill:black;");
     eventSeparator.setStyle("-fx-text-fill:black;");
     dateLabel.setStyle("-fx-text-fill:black;");
     nameLabel.setStyle("-fx-text-fill:black;");
     idLabel.setStyle("-fx-text-fill:black;");
     calenderSeparetor.setStyle("-fx-text-fill:black;");
     lessonSeparator.setStyle("-fx-text-fill:black;");
     title.setStyle("-fx-text-fill:black;");
     nameLabel.setStyle("-fx-text-fill:black;");
     clock.setImage(new Image("/xatrock/clock.png"));
     logoutLabel.setImage(new Image("/xatrock/logout.png"));
     
      }
        
      
    }
      @FXML
       private void aboutXatrockHandler(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("StudentAboutXatrockPage1.fxml"));
       Parent ReportManager = loader.load();
       Scene ReportManagerScene = new Scene(ReportManager);
       Stage window = (Stage)homePane.getScene().getWindow();
       window.setScene(ReportManagerScene); 
       window.show();

        
    }
    
    
    
}
