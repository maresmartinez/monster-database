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

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ListPane extends VBox {

    // Instance Variables
    private final TableView table = new TableView();
   
    // Constructor
    public ListPane() {
       
       // Style Pane
       setPadding(new Insets(20, 20, 20, 20));
       
       // Label Heading
       Label lblHeading = new Label("Monsters");
       lblHeading.setFont(Font.font("Arial", FontWeight.BOLD, 25));
       getChildren().add(lblHeading);
       
       // Set table properties
       table.setEditable(false);
       table.setPrefWidth(450);
       table.setPrefHeight(800);
       
       // Names that will be displayed in table column heading
       String[] colHeadings = {
          "ID", "Name", "Weapon",
          "Species", "Hit Points", "Mana",
          "Defence", "Attack", "Gold",
          "Experience", "Level"
       };
       
       // Names of instance variables in Monster object
       String[] monsterVariables = {
          "monsterId", "name", "weapon",
          "species", "hitPoints", "mana",
          "defence", "attackDamage", "gold",
          "experience", "level"
       };
       
       // Create Table Columns
       for (int i = 0; i < colHeadings.length; i++) {
          TableColumn col = new TableColumn(colHeadings[i]);
          col.setMinWidth(80);
          col.setCellValueFactory(new PropertyValueFactory<>(monsterVariables[i]));
          table.getColumns().add(col);
       }
       
       // Add table to Pane
       getChildren().add(table);

    }
    
    /**
     * This will display a List on the TableView
     * 
     * @param list to be displayed
     */
    public void displayMonsters(ObservableList<Monster> list) {
       table.setItems(list);
    }
    
    /**
     * Refreshes table to reflect any changes to database
     */
    public void refreshTable() {
       table.refresh();
    }
   
}
