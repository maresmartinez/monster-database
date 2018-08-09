/*
 * Sheridan College
 * Course: PROG 24178
 * Instructor: Hosein Marzi
 * Date Created: 6-Aug-2018
 *  
 * References:
 *    http://www.java2s.com/Tutorials/Java/JavaFX/0650__JavaFX_TableView.htm
 *
 * @author Mariel Martinez
 *  
 */

package monsterdatabase1;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DatabasePane extends BorderPane {
    
    private final Button navList = new Button(
            " List", new ImageView("images/icon_list.png"));
    private final Button navDetails = new Button(
            " Details", new ImageView("images/icon_details.png"));
    private final Button navAdd = new Button(
            " Add", new ImageView("images/icon_add.png"));
    private final Button navSearch = new Button(
            " Search", new ImageView("images/icon_search.png"));
   
    private final ListPane listPagePane = new ListPane();
    private final SearchPane searchPagePane = new SearchPane();
    private final AddPane addPagePane = new AddPane();
    private final DetailsPane detailsPagePane = new DetailsPane();
   
    private final MonsterCollection monsters;
    private final ObservableList<Monster> list;
    
    public DatabasePane(MonsterCollection monsters) {
       
       // Set to Homepage
       setLeft(getNavigation());
       goToListPage();
       
       // Set List
       this.monsters = monsters;
       this.list = monsters.getTableData();
       displayList();
       
       
    }
   
    public void displayList() {
       // Check if the listPanePage is being displayed
       if (getCenter() == listPagePane) {
          // Displays the list in a TableView object
          listPagePane.displayMonsters(this.list);
       }
    }
    
    /** Navigates to Search Page */
    private void goToSearchPage() {
       setCenter(searchPagePane);
    }
    
    /** Navigates to Add Page */
    private void goToAddPage() {
       setCenter(addPagePane);
    }
    
    /** Navigates to List Page */
    private void goToListPage() {
       setCenter(listPagePane);
    }
    
    /** Navigates to Navigate Page */
    private void goToDetailsPage() {
       setCenter(detailsPagePane);
    }
    
    /** Creates the VBox that will allow for navigation between pages */
    private VBox getNavigation() {
       
       // Create pane to hold navigation and style it
       VBox navPane = new VBox(10);
       navPane.setPadding(new Insets(20, 20, 20, 20));
       
       // Create labels and buttons
       Label lblDatabase = new Label("DATABASE");
       
       // Style fonts
       lblDatabase.setFont(Font.font("Arial", 25));
       navList.setFont(Font.font("Arial", 18));
       navAdd.setFont(Font.font("Arial", 18));
       navDetails.setFont(Font.font("Arial", 18));
       navSearch.setFont(Font.font("Arial", 18));
       
       // Style button layout
       navList.setPrefWidth(140);
       navList.setAlignment(Pos.CENTER_LEFT);
       navAdd.setPrefWidth(140);
       navAdd.setAlignment(Pos.CENTER_LEFT);
       navDetails.setPrefWidth(140);
       navDetails.setAlignment(Pos.CENTER_LEFT);
       navSearch.setPrefWidth(140);
       navSearch.setAlignment(Pos.CENTER_LEFT);
       
       // Add listeners to buttons
       navList.setOnAction(e -> {
          goToListPage();
       });
       navAdd.setOnAction(e -> {
          goToAddPage();
       });
       navDetails.setOnAction(e -> {
          goToDetailsPage();
       });
       navSearch.setOnAction(e -> {
          goToSearchPage();
       });
       
       // Add buttons to navigation
       navPane.getChildren().addAll(lblDatabase, navList, navDetails, navAdd, navSearch);
       
       return navPane;
    }
}


