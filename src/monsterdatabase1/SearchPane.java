/*
 * Sheridan College
 * Course: PROG 24178
 * Instructor: Hosein Marzi
 * Date Created: 7-Aug-2018
 *  
 * @author Mariel Martinez
 *  
 */

package monsterdatabase1;

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
       
       // Inputs
       TextField inpKeyword = new TextField();
       inpKeyword.setPrefWidth(300);
       
       TextField inpId = new TextField();
       inpId.setPrefWidth(300);
       
       TextField inpName = new TextField();
       inpName.setPrefWidth(300);
       
       // Buttons
       Button btSearch = new Button("Search");
       
       // Labels
       Label lblKeyword = new Label("Keyword");
       lblKeyword.setMinWidth(50); // Stops all labels from getting too small
       
       Label lblId = new Label("ID");
       Label lblName = new Label("Name");
       Label lblWeapon= new Label("Keyword");
       Label lblSpecies = new Label("ID");
       
       // ComboBox for Weapons
       Weapon[] weapons = Weapon.values();
       ComboBox<Weapon> cboWeapon = new ComboBox<>();
       
       ObservableList<Weapon> weaponSelection = 
               FXCollections.observableArrayList(weapons);
       
       cboWeapon.getItems().addAll(weaponSelection);
       cboWeapon.setPromptText("Filter by Weapon");
       cboWeapon.setPrefWidth(300);
       
       // ComboBox for Species
       Species[] species = Species.values();
       ComboBox<Species> cboSpecies = new ComboBox<>();
       
       ObservableList<Species> speciesSelection = 
               FXCollections.observableArrayList(species);
       
       cboSpecies.getItems().addAll(speciesSelection);
       cboSpecies.setPromptText("Filter by Species");
       cboSpecies.setPrefWidth(300);
       
       // Add to grid
       add(lblHeading, 0, 0, 2, 1);
       
       add(lblSearch, 0, 2, 2, 1);
       add(lblKeyword, 0, 4);
       add(inpKeyword, 1, 4);
       add(lblId, 0, 7);
       add(inpId, 1, 7);
       add(lblName, 0, 10);
       add(inpName, 1, 10);
       
       add(lblFilter, 0, 12, 2, 1);
       add(lblWeapon, 0, 14);
       add(cboWeapon, 1, 14, 2, 1);
       add(lblSpecies, 0, 17);
       add(cboSpecies, 1, 17, 2, 1);
       
       add(btSearch, 1, 21);
       
       // Position nodes
       GridPane.setHalignment(lblKeyword, HPos.RIGHT);
       GridPane.setHalignment(lblId, HPos.RIGHT);
       GridPane.setHalignment(lblName, HPos.RIGHT);
       GridPane.setHalignment(lblWeapon, HPos.RIGHT);
       GridPane.setHalignment(lblSpecies, HPos.RIGHT);  
       
    }

}
