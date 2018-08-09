/*
 * Sheridan College
 * Course: PROG 24178
 * Instructor: Hosein Marzi
 * Date Created: 6-Aug-2018
 *  
 * References (From entire assignment):
 *    http://www.java2s.com/Tutorials/Java/JavaFX/0650__JavaFX_TableView.htm
 *    http://code.makery.ch/blog/javafx-dialogs-official/
 *    https://stackoverflow.com/questions/11065140/javafx-2-1-tableview-refresh-items
 *
 * @author Mariel Martinez
 *  
 */

package monsterdatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application {

    @Override
    public void start(Stage primaryStage) 
            throws FileNotFoundException, IOException, ClassNotFoundException {
       
       // Object to hold database 
       MonsterCollection monsters;
       
       try ( // Open the file test.dat
          ObjectInputStream input = new ObjectInputStream(
                  new FileInputStream("test.dat"));
       ) {
          // Save MonsterCollection that is stored in test.dat into a variable
          monsters = (MonsterCollection) input.readObject();
       } // try-with-resources automatically closes input
       
       // Create a pane to display the file
       DatabasePane pane = new DatabasePane(monsters);
       
       // Create a scene and set it on the primaryStage
       Scene scene = new Scene(pane, 1100, 650);
       primaryStage.setTitle("Monster Database");
       primaryStage.getIcons().add(new Image("images/icon_application.png"));
       primaryStage.setMaximized(true);
       primaryStage.setScene(scene);
       primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);
    }

}
