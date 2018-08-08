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

    private final TableView table = new TableView();
   
    public ListPane() {
       setPadding(new Insets(20, 20, 20, 20));
       
       // Label Heading
       Label lblHeading = new Label("Monsters");
       lblHeading.setFont(Font.font("Arial", FontWeight.BOLD, 25));
       getChildren().add(lblHeading);
       
       // Set table properties
       table.setEditable(false);
       table.setPrefWidth(450);
       table.setPrefHeight(800);
       
       String[] colHeadings = {
          "ID", "Name", "Weapon",
          "Species", "Hit Points", "Mana",
          "Defence", "Attack", "Gold",
          "Experience", "Level"
       };
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
       
       getChildren().add(table);

    }
    
    public void displayMonsters(ObservableList<Monster> list) {
       table.setItems(list);
    }
   
}
