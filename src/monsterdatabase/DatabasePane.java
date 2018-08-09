/*
 * Sheridan College
 * Course: PROG 24178
 * Instructor: Hosein Marzi
 * Date Created: 6-Aug-2018
 *
 * @author Mariel Martinez
 *  
 */

package monsterdatabase;

import java.util.NoSuchElementException;
import java.util.Optional;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;

public class DatabasePane extends BorderPane {
    
    // Instance Variables
   
    // Panes to be displayed in center of DatabasePane
    protected final ListPane listPane = new ListPane();
    protected final SearchPane searchPane = new SearchPane();
    protected final AddPane addPane = new AddPane();
    protected final DetailsPane detailsPane;
    protected final EditPane editPane = new EditPane();
    protected final NavigationPane navPane = new NavigationPane();
   
    // Variables to keep track of MonsterCollection
    protected MonsterCollection monsters;
    protected ObservableList<Monster> list;
    protected int currentIndex;
    
    public DatabasePane(MonsterCollection monsters) {
       this.detailsPane = new DetailsPane(monsters);
       
       // Set to Homepage
       setLeft(navPane);
       setCenter(listPane);
       
       // Set listeners on navPane
       navPane.getBtList().setOnAction(e -> setCenter(listPane));
       navPane.getBtAdd().setOnAction(e -> setCenter(addPane));
       navPane.getBtDetails().setOnAction(e -> setCenter(detailsPane));
       navPane.getBtSearch().setOnAction(e -> setCenter(searchPane));
       navPane.getInpMonsterId().setOnAction(e -> seeDetails());
       
       // Set listeners on detailsPane
       detailsPane.displayMonsterDetails(monsters.get(currentIndex));
       detailsPane.getBtNext().setOnAction(e -> {
          if (currentIndex < (monsters.getCount() - 1)) {
             currentIndex++;
             detailsPane.displayMonsterDetails(monsters.get(currentIndex));
          }
       });
       detailsPane.getBtPrevious().setOnAction(e -> {
          if (currentIndex > 0) {
             currentIndex--;
             detailsPane.displayMonsterDetails(monsters.get(currentIndex));
          }
       });
       detailsPane.getBtDelete().setOnAction(e -> deleteMonster());
       detailsPane.getBtEdit().setOnAction(e -> {
          editPane.displayMonsterDetails(monsters.get(currentIndex));
          setCenter(editPane);
       });
       
       // Set listeners on editPane
       editPane.getBtSave().setOnAction(e -> editMonster());
       editPane.getBtCancel().setOnAction(e -> {
          Alert cancelConfirmation = new Alert(AlertType.CONFIRMATION);
          cancelConfirmation.setTitle("Confirm");
          cancelConfirmation.setHeaderText("Leaving Edit Page");
          cancelConfirmation.setContentText("Are you sure you want to lose these changes?");
          
          Optional<ButtonType> result = cancelConfirmation.showAndWait();
          if (result.get() == ButtonType.OK){
             setCenter(detailsPane);
          }
       });
       
       // Set listeners on addPane
       addPane.getBtAdd().setOnAction(e -> addMonster());
       addPane.getBtCancel().setOnAction(e -> {
          Alert cancelConfirmation = new Alert(AlertType.CONFIRMATION);
          cancelConfirmation.setTitle("Refreshing");
          cancelConfirmation.setHeaderText("Losing all information");
          cancelConfirmation.setContentText("Are you sure you want to refresh these fields?");
          
          Optional<ButtonType> result = cancelConfirmation.showAndWait();
          if (result.get() == ButtonType.OK){
             addPane.refreshAll();
          }
       });
       
       // Set List
       this.monsters = monsters;
       this.list = monsters.getTableData();
       displayList();

    }
    
    /**
     * Goes to Details Page for Monster with ID that was entered into search bar
     */
    protected void seeDetails() {
       int id;
       
       try {
          id = Integer.parseInt(navPane.getInpMonsterId().getText());
       } catch (NumberFormatException e) {
          Alert numberWarning = new Alert(AlertType.WARNING);
          numberWarning.setTitle("Invalid Entry");
          numberWarning.setHeaderText("Enter a Number");
          numberWarning.setContentText("Please enter a number for Monster ID");
          
          numberWarning.showAndWait();
          return;
       }
       
       if (id < 0 || id > monsters.getCount()) {
          Alert numberWarning = new Alert(AlertType.WARNING);
          numberWarning.setTitle("Invalid Entry");
          numberWarning.setHeaderText("Not in Database");
          numberWarning.setContentText("The ID entered is not in the database");
          
          numberWarning.showAndWait();
          return;
       }
       
       this.currentIndex = id - 1;
       detailsPane.displayMonsterDetails(monsters.get(currentIndex));
       setCenter(detailsPane);
       
       navPane.getInpMonsterId().setText("");
       
    }
    
    /**
     * Takes the values from addPane and creates a Monster with those variables
     */
    protected void addMonster() {
       
       // Ensure that at least name, Weapon, and Species are selected
       if (addPane.getInpName().getText().equals("") 
               || addPane.getCboSpecies().getValue() == null
               || addPane.getCboWeapon().getValue() == null) {
          
          // Show warning and do not add Monster
          Alert missingAlert = new Alert(AlertType.INFORMATION);
          missingAlert.setTitle("Missing Fields");
          missingAlert.setHeaderText("Missing Fields");
          missingAlert.setContentText("Name, Weapon, and Species are required to add new Monster");
          missingAlert.showAndWait();
          return;
       }
       
       Monster newMonster = new Monster();
       
       try {

          int newHitPoints = Integer.parseInt(addPane.getInpHitPoints().getText());
          int newMana = Integer.parseInt(addPane.getInpMana().getText());
          int newAttackDamage = Integer.parseInt(addPane.getInpAttackDamage().getText());
          int newDefence = Integer.parseInt(addPane.getInpDefence().getText());
          int newGold = Integer.parseInt(addPane.getInpGold().getText());
          int newExperience = Integer.parseInt(addPane.getInpExperience().getText());
          int newLevel = Integer.parseInt(addPane.getInpLevel().getText());
          
          newMonster.setHitPoints(newHitPoints);
          newMonster.setMana(newMana);
          newMonster.setAttackDamage(newAttackDamage);
          newMonster.setDefence(newDefence);
          newMonster.setGold(newGold);
          newMonster.setExperience(newExperience);
          newMonster.setLevel(newLevel);
          
       } catch (NumberFormatException e) {
          
          Alert numberWarning = new Alert(AlertType.WARNING);
          numberWarning.setTitle("Invalid Entry");
          numberWarning.setHeaderText("Enter a Number");
          numberWarning.setContentText("A String was entered where an int was expected.\n"
                  + "Changes not saved.");
          
          Optional<ButtonType> result2 = numberWarning.showAndWait();
          return;
       }
       
       // Get String values that were entered
       String newName = addPane.getInpName().getText();
       String newBattleCry = addPane.getInpBattleCry().getText();
       String newDeathCry = addPane.getInpDeathCry().getText();
       Species newSpecies = addPane.getCboSpecies().getValue();
       Weapon newWeapon = addPane.getCboWeapon().getValue();
       String newLore = addPane.getInpLore().getText();
       
       // Set new String attributes
       newMonster.setName(newName);
       newMonster.setBattleCry(newBattleCry);
       newMonster.setDeathCry(newDeathCry);
       newMonster.setSpecies(newSpecies);
       newMonster.setWeapon(newWeapon);
       newMonster.setLore(newLore);
       
       // Set boss
       if (addPane.getRbIsBoss().isSelected()) {
          newMonster.setBoss(true);
       } else {
          newMonster.setBoss(false);
       }
       
       // Add Monster
       monsters.add(newMonster);
       
       // Clear fields
       addPane.refreshAll();
       
       // Update variables and display the database with changes
       listPane.refreshTable();
       setCenter(listPane);
       
    }
    
    /**
     * Takes the values that the user enters and changes the Monster's variables
     */
    protected void editMonster() {
       
       Alert editConfirmation = new Alert(AlertType.CONFIRMATION);
       editConfirmation.setTitle("Confirm");
       editConfirmation.setHeaderText("Overwriting Monster");
       editConfirmation.setContentText("Are you sure you want to save these changes?");

       Optional<ButtonType> result = editConfirmation.showAndWait();
       if (result.get() == ButtonType.CANCEL){
          return;
       }
       
       // Get monster to be edited
       Monster monster = monsters.get(currentIndex);
       
       try {

          int newHitPoints = Integer.parseInt(editPane.getInpHitPoints().getText());
          int newMana = Integer.parseInt(editPane.getInpMana().getText());
          int newAttackDamage = Integer.parseInt(editPane.getInpAttackDamage().getText());
          int newDefence = Integer.parseInt(editPane.getInpDefence().getText());
          int newGold = Integer.parseInt(editPane.getInpGold().getText());
          int newExperience = Integer.parseInt(editPane.getInpExperience().getText());
          int newLevel = Integer.parseInt(editPane.getInpLevel().getText());
          
          monster.setHitPoints(newHitPoints);
          monster.setMana(newMana);
          monster.setAttackDamage(newAttackDamage);
          monster.setDefence(newDefence);
          monster.setGold(newGold);
          monster.setExperience(newExperience);
          monster.setLevel(newLevel);
          
       } catch (NumberFormatException e) {
          
          Alert numberWarning = new Alert(AlertType.WARNING);
          numberWarning.setTitle("Invalid Entry");
          numberWarning.setHeaderText("Enter a Number");
          numberWarning.setContentText("A String was entered where an int was expected.\n"
                  + "Changes not saved.");
          
          Optional<ButtonType> result2 = numberWarning.showAndWait();
          if (result2.get() == ButtonType.OK){
             return;
          }
       }
       
       // Get String values that were entered
       String newName = editPane.getInpName().getText();
       String newBattleCry = editPane.getInpBattleCry().getText();
       String newDeathCry = editPane.getInpDeathCry().getText();
       Species newSpecies = editPane.getCboSpecies().getValue();
       Weapon newWeapon = editPane.getCboWeapon().getValue();
       String newLore = editPane.getInpLore().getText();
       
       // Set new String attributes
       monster.setName(newName);
       monster.setBattleCry(newBattleCry);
       monster.setDeathCry(newDeathCry);
       monster.setSpecies(newSpecies);
       monster.setWeapon(newWeapon);
       monster.setLore(newLore);
       
       // Set boss
       if (editPane.getRbIsBoss().isSelected()) {
          monster.setBoss(true);
       } else {
          monster.setBoss(false);
       }
       
       // Update variables and display the database with changes
       detailsPane.displayMonsterDetails(monsters.get(currentIndex));
       listPane.refreshTable();
       setCenter(detailsPane);
    }
   
    /**
     * Deletes a Monster from the database
     */
    protected void deleteMonster() {
       
       // Give user warning before deleting
       Alert deleteConfirmation = new Alert(AlertType.CONFIRMATION);
       deleteConfirmation.setTitle("Confirm");
       deleteConfirmation.setHeaderText("Delete Monster");
       deleteConfirmation.setContentText("Are you sure you want to delete this Monster?");

       Optional<ButtonType> result = deleteConfirmation.showAndWait();
       if (result.get() == ButtonType.OK){
          // Delete Monster at current index
          monsters.delete(currentIndex + 1);

          // If the last monster was deleted, currentIndex must decrement
          //     Otherwise an ArrayIndexOutOfBounds will occur
          if (currentIndex >= (monsters.getCount() - 1)) {
             currentIndex--;
          }

          // Update variables and display the database without deleted Monster
          detailsPane.displayMonsterDetails(monsters.get(currentIndex));
          this.list = monsters.getTableData();
          displayList();
      }
    }
    
    /**
     * Displays MonsterCollection to ListPane
     */
    protected void displayList() {
       listPane.displayMonsters(this.list);
    }

}


