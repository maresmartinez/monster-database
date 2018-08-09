/*
 * Sheridan College
 * Course: PROG 24178
 * Instructor: Hosein Marzi
 * Date Created: 8-Aug-2018
 *  
 * @author Mariel Martinez
 *  
 */

package monsterdatabase;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class NavigationPane extends VBox {

    // Instance Variables
    protected final TextField inpMonsterId;
    protected final Button btList;
    protected final Button btDetails;
    protected final Button btAdd;
    protected final Button btSearch;
    protected final Button btSave;

    // Constructor
    public NavigationPane() {
      
       // Add Labels and ImageView to Buttons
       this.inpMonsterId = new TextField();
       this.btSearch = new Button(" Search", new ImageView("images/icon_search.png"));
       this.btAdd = new Button(" Add", new ImageView("images/icon_add.png"));
       this.btDetails = new Button(" Details", new ImageView("images/icon_details.png"));
       this.btList = new Button(" List", new ImageView("images/icon_list.png"));
       this.btSave = new Button("Save");
      
       // Style Pane
       setSpacing(10);
       setPadding(new Insets(20, 20, 20, 20));
       
       // Style fonts
       Label lblDatabase = new Label("DATABASE");
       lblDatabase.setFont(Font.font("Arial", 25));
       this.btList.setFont(Font.font("Arial", 18));
       this.btAdd.setFont(Font.font("Arial", 18));
       this.btDetails.setFont(Font.font("Arial", 18));
       this.btSearch.setFont(Font.font("Arial", 18));
       
       // Style button layout
       this.btList.setPrefWidth(140);
       this.btList.setAlignment(Pos.CENTER_LEFT);
       this.btAdd.setPrefWidth(140);
       this.btAdd.setAlignment(Pos.CENTER_LEFT);
       this.btDetails.setPrefWidth(140);
       this.btDetails.setAlignment(Pos.CENTER_LEFT);
       this.btSearch.setPrefWidth(140);
       this.btSearch.setAlignment(Pos.CENTER_LEFT);
       this.inpMonsterId.setPrefWidth(140);
       this.inpMonsterId.setAlignment(Pos.CENTER_LEFT);
       
       // Add buttons to navigation
       getChildren().addAll(
          lblDatabase, 
          new Label("Go to ID:"),
          this.inpMonsterId,
          this.btList, 
          this.btDetails, 
          this.btAdd, 
          this.btSearch,
          this.btSave
       );
    }

    // Getters for buttons
    public Button getBtList() {
       return btList;
    }

    public Button getBtDetails() {
       return btDetails;
    }

    public Button getBtAdd() {
       return btAdd;
    }

    public Button getBtSearch() {
       return btSearch;
    }

   public TextField getInpMonsterId() {
      return inpMonsterId;
   }

   public Button getBtSave() {
      return btSave;
   }
    
}
