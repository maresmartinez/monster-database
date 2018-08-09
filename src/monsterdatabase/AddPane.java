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

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AddPane extends GridPane {

    public AddPane() {
       
       // Set gaps
       setPadding(new Insets(20, 20, 20, 20));
       setVgap(10);
       setHgap(20);
       
       // Set column constraints on gridpane
       ColumnConstraints col1 = new ColumnConstraints();
       col1.setPercentWidth(25);
       ColumnConstraints col2 = new ColumnConstraints();
       col2.setPercentWidth(25);
       ColumnConstraints col3 = new ColumnConstraints();
       col3.setPercentWidth(25);
       ColumnConstraints col4 = new ColumnConstraints();
       col4.setPercentWidth(25);
       getColumnConstraints().addAll(col1, col2, col3, col4);
       
       // Label Heading
       Label lblHeading = new Label("Add New Monster");
       lblHeading.setFont(Font.font("Arial", FontWeight.BOLD, 25));
       
       // Textfield inputs
       TextField inpName = new TextField();
       TextField inpBattleCry = new TextField();
       TextField inpDeathCry = new TextField();
       
       // Selection inputs
       Species[] species = Species.values();
       ComboBox<Species> cboSpecies = new ComboBox<>();
       ObservableList<Species> speciesSelection = FXCollections.observableArrayList(species);
       cboSpecies.getItems().addAll(speciesSelection);
       cboSpecies.setPrefWidth(800);
       cboSpecies.setPromptText("Select a Species");
       
       Weapon[] weapons = Weapon.values();
       ComboBox<Weapon> cboWeapon = new ComboBox<>();
       ObservableList<Weapon> weaponSelection = FXCollections.observableArrayList(weapons);
       cboWeapon.getItems().addAll(weaponSelection);
       cboWeapon.setPrefWidth(800);
       cboWeapon.setPromptText("Select a Weapon");
       
       // Number Inputs
       TextField inpHitPoints = new TextField();
       TextField inpMana = new TextField();
       TextField inpAttackDamage = new TextField();
       TextField inpDefence = new TextField();
       TextField inpGold = new TextField();
       TextField inpExperience = new TextField();
       TextField inpLevel = new TextField();
       
       // Input for isBoss
       HBox inpBoss = new HBox(20);
       RadioButton rbIsBoss = new RadioButton("Yes");
       RadioButton rbIsNotBoss = new RadioButton("No");
       inpBoss.getChildren().addAll(rbIsBoss, rbIsNotBoss);
       
       ToggleGroup bossSelection = new ToggleGroup();
       rbIsBoss.setToggleGroup(bossSelection);
       rbIsNotBoss.setToggleGroup(bossSelection);

       // Input for Lore
       TextArea inpLore = new TextArea();
       
       inpLore.setWrapText(true);
       
       // Submit Buttons
       Button btAdd = new Button("Add Entry");
       Button btCancel = new Button("Cancel");
       btAdd.setPrefWidth(300);
       
       // Add to pane
       add(lblHeading, 0, 0, 2, 1);
       
       add(new Label("Name"), 0, 2);
       add(inpName, 0, 3, 2, 1);
       
       add(new Label("Battle Cry"), 0, 5);
       add(inpBattleCry, 0, 6, 2, 1);
       add(new Label("Death Cry"), 2, 5);
       add(inpDeathCry, 2, 6, 2, 1);  

       add(new Label("Species"), 0, 8);
       add(cboSpecies, 0, 9, 2, 1);
       add(new Label("Weapon"), 2, 8);
       add(cboWeapon, 2, 9, 2, 1);

       add(new Label("Hit Points"), 0, 11);
       add(inpHitPoints, 0, 12);
       add(new Label("Mana"), 1, 11);
       add(inpMana, 1, 12);
       add(new Label("Attack Damage"), 2, 11);
       add(inpAttackDamage, 2, 12);
       add(new Label("Defence"), 3, 11);
       add(inpDefence, 3, 12);
       
       add(new Label("Gold"), 0, 14);
       add(inpGold, 0, 15);
       add(new Label("Experience"), 1, 14);
       add(inpExperience, 1, 15);
       add(new Label("Level"), 2, 14);
       add(inpLevel, 2, 15);
       
       add(new Label("Boss?"), 0, 17);
       add(inpBoss, 0, 18);
       
       add(new Label("Lore"), 0, 20);
       add(inpLore, 0, 21, 3, 1);
       
       add(btAdd, 0, 23);
       add(btCancel, 1, 23);
       
    }

}