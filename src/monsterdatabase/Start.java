/*
 * Sheridan College
 * Course: PROG 24178
 * Instructor: Hosein Marzi
 * Date Created: 6-Aug-2018
 *  
 * @author Mariel Martinez
 *  
 */

package monsterdatabase1;

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
       Scene scene = new Scene(pane);
       primaryStage.setTitle("Monster Database");
       primaryStage.getIcons().add(new Image("images/icon_application.png"));
       primaryStage.setScene(scene);
       primaryStage.show();
       
       primaryStage.setMaximized(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);
    }

}
