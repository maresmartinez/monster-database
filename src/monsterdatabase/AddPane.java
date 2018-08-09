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

    // Instance Variables
    
    // Input boxes
    protected final TextField inpName = new TextField();
    protected final TextField inpBattleCry = new TextField();
    protected final TextField inpDeathCry = new TextField();
    protected final ComboBox<Species> cboSpecies = new ComboBox<>();
    protected final ComboBox<Weapon> cboWeapon = new ComboBox<>();
    protected final TextField inpHitPoints = new TextField();
    protected final TextField inpMana = new TextField();
    protected final TextField inpAttackDamage = new TextField();
    protected final TextField inpDefence = new TextField();
    protected final TextField inpGold = new TextField();
    protected final TextField inpExperience = new TextField();
    protected final TextField inpLevel = new TextField();
    protected final RadioButton rbIsBoss = new RadioButton("Yes");
    protected final RadioButton rbIsNotBoss = new RadioButton("No");
    protected final TextArea inpLore = new TextArea();
   
    // Buttons
    protected final Button btAdd = new Button("Add Entry");
    protected final Button btCancel = new Button("Reset");
   
    // Constructor
    public AddPane() {
       
       // Set gaps
       setPadding(new Insets(20, 20, 20, 20));
       setVgap(10);
       setHgap(20);
       
       // Set column constraints on gridpane
       for (int i = 0; i < 4; i++) {
          ColumnConstraints col = new ColumnConstraints();
          col.setPercentWidth(25);
          getColumnConstraints().add(col);
       }
       
       // Label Heading
       Label lblHeading = new Label("Add New Monster");
       lblHeading.setFont(Font.font("Arial", FontWeight.BOLD, 25));
       
       // Selection inputs
       Species[] species = Species.values();
       ObservableList<Species> speciesSelection = FXCollections.observableArrayList(species);
       cboSpecies.getItems().addAll(speciesSelection);
       cboSpecies.setPrefWidth(800);
       cboSpecies.setPromptText("Select a Species");
       
       Weapon[] weapons = Weapon.values();
       ObservableList<Weapon> weaponSelection = FXCollections.observableArrayList(weapons);
       cboWeapon.getItems().addAll(weaponSelection);
       cboWeapon.setPrefWidth(800);
       cboWeapon.setPromptText("Select a Weapon");
       
       // Input for isBoss
       HBox inpBoss = new HBox(20);
       inpBoss.getChildren().addAll(rbIsBoss, rbIsNotBoss);
       ToggleGroup bossSelection = new ToggleGroup();
       rbIsBoss.setToggleGroup(bossSelection);
       rbIsNotBoss.setToggleGroup(bossSelection);
       
       // Lore
       inpLore.setWrapText(true);
       
       // Buttons
       btAdd.setPrefWidth(300);
       HBox paneForButtons = new HBox(20);
       paneForButtons.getChildren().addAll(btAdd, btCancel);
       
       // Set default values
       clearFields();
       
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
       add(paneForButtons, 0, 23, 2, 1);
    }
    
    private void clearFields() {
       // Set Default values
       inpName.setText("");
       rbIsNotBoss.setSelected(true);
       inpHitPoints.setText("0");
       inpMana.setText("0");
       inpAttackDamage.setText("0");
       inpDefence.setText("0");
       inpGold.setText("0");
       inpExperience.setText("0");
       inpLevel.setText("0");
    }
    
    /**
     * Sets all input fields to empty values
     */
    public void refreshAll() {
       
       // Set TextFields to empty String
       inpName.setText("");
       inpBattleCry.setText("");
       inpDeathCry.setText("");
       inpHitPoints.setText("");
       inpMana.setText("");
       inpAttackDamage.setText("");
       inpDefence.setText("");
       inpGold.setText("");
       inpExperience.setText("");
       inpLevel.setText("");
       inpLore.setText("");
       
       // Set ComboBoxes to nothing
       cboSpecies.setValue(null);
       cboWeapon.setValue(null);

       // Set boss to false
       rbIsNotBoss.setSelected(true);
       
       clearFields();
    }
    
    // Getters
    public TextField getInpName() {
       return inpName;
    }

    public TextField getInpBattleCry() {
       return inpBattleCry;
    }

    public TextField getInpDeathCry() {
       return inpDeathCry;
    }

    public ComboBox<Species> getCboSpecies() {
       return cboSpecies;
    }

    public ComboBox<Weapon> getCboWeapon() {
       return cboWeapon;
    }

    public TextField getInpHitPoints() {
       return inpHitPoints;
    }

    public TextField getInpMana() {
       return inpMana;
    }

    public TextField getInpAttackDamage() {
       return inpAttackDamage;
    }

    public TextField getInpDefence() {
       return inpDefence;
    }

    public TextField getInpGold() {
       return inpGold;
    }

    public TextField getInpExperience() {
       return inpExperience;
    }

    public TextField getInpLevel() {
       return inpLevel;
    }

    public RadioButton getRbIsBoss() {
       return rbIsBoss;
    }

    public RadioButton getRbIsNotBoss() {
       return rbIsNotBoss;
    }

    public TextArea getInpLore() {
       return inpLore;
    }

    public Button getBtAdd() {
       return btAdd;
    }

    public Button getBtCancel() {
       return btCancel;
    }
}
