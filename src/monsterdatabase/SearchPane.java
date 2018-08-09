/*
 * Sheridan College
 * Course: PROG 24178
 * Instructor: Hosein Marzi
 * Date Created: 7-Aug-2018
 *  
 * @author Mariel Martinez
 *  
 */

package monsterdatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SearchPane extends GridPane {

    protected final TextField inpKeyword = new TextField();
    protected final TextField inpId = new TextField();
    protected final TextField inpName = new TextField();
    protected final ComboBox<Weapon> cboWeapon = new ComboBox<>();
    protected final ComboBox<Species> cboSpecies = new ComboBox<>();
    protected final Button btSearch = new Button("Search");
    protected final Button btFilter = new Button("Filter");
   
    public SearchPane() {
       
       // Set gaps
       setPadding(new Insets(20, 20, 20, 20));
       setVgap(10);
       setHgap(20);
       
       // Label Heading
       Label lblHeading = new Label("Advanced Search");
       lblHeading.setFont(Font.font("Arial", FontWeight.BOLD, 25));
       
       // Label Sub-Headings
       Label lblSearch = new Label("Search Terms");
       lblSearch.setFont(Font.font("Arial", FontWeight.BOLD, 15));
       Label lblFilter = new Label("Filters");
       lblFilter.setFont(Font.font("Arial", FontWeight.BOLD, 15));
       
       // Style Inputs
       inpKeyword.setPrefWidth(300);
       inpId.setPrefWidth(300);
       inpName.setPrefWidth(300);
       
       // Labels
       Label lblId = new Label("ID");
       Label lblName = new Label("Name");
       Label lblWeapon = new Label("Weapon");
       Label lblSpecies = new Label("Species");
       
       // ComboBox for Weapons
       Weapon[] weapons = Weapon.values();
       ObservableList<Weapon> weaponSelection = 
               FXCollections.observableArrayList(weapons);
       cboWeapon.getItems().addAll(weaponSelection);
       cboWeapon.setPromptText("Filter by Weapon");
       cboWeapon.setPrefWidth(300);
       
       // ComboBox for Species
       Species[] species = Species.values();
       ObservableList<Species> speciesSelection = 
               FXCollections.observableArrayList(species);
       cboSpecies.getItems().addAll(speciesSelection);
       cboSpecies.setPromptText("Filter by Species");
       cboSpecies.setPrefWidth(300);
       
       // Add nodes to grid
       add(lblHeading, 0, 0, 2, 1);
       add(lblSearch, 0, 2, 2, 1);
       add(lblId, 0, 4);
       add(inpId, 1, 4);
       add(lblName, 0, 7);
       add(inpName, 1, 7);
       add(btSearch, 1, 10);
       add(lblFilter, 0, 12, 2, 1);
       add(lblWeapon, 0, 14);
       add(cboWeapon, 1, 14, 2, 1);
       add(lblSpecies, 0, 17);
       add(cboSpecies, 1, 17, 2, 1);
       add(btFilter, 1, 20);
       
       // Position nodes
       GridPane.setHalignment(lblId, HPos.RIGHT);
       GridPane.setHalignment(lblName, HPos.RIGHT);
       GridPane.setHalignment(lblWeapon, HPos.RIGHT);
       GridPane.setHalignment(lblSpecies, HPos.RIGHT);  
       
    }

    // Getters
    public TextField getInpKeyword() {
       return inpKeyword;
    }

    public TextField getInpId() {
       return inpId;
    }

    public TextField getInpName() {
       return inpName;
    }

    public ComboBox<Weapon> getCboWeapon() {
       return cboWeapon;
    }

    public ComboBox<Species> getCboSpecies() {
       return cboSpecies;
    }

    public Button getBtSearch() {
       return btSearch;
    }
    
    public Button getBtFilter() {
       return btFilter;
    }
}
