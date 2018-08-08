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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.NoSuchElementException;

public class MonsterCollection implements Serializable {
   
   // Instance Variables
   protected List<Monster> monsters = new ArrayList<>();
   protected int count;

   /**
    * This returns an ObservableList representation of the MonsterCollection
    *    which allows MonsterCollection to be displayed in TableView
    * 
    * @return MonsterCollection as ObservableList
    */
   public ObservableList getTableData() {
      ObservableList list = FXCollections.observableList(monsters);
      return list;
   }
   
   /**
    * Returns Monster from specific index
    * 
    * @param index of the monster wanted
    * @return Monster wanted
    */
   public Monster get(int index) {
      return (Monster) monsters.get(index);
   }
   
   /**
    * @return count of MonsterCollection
    */
   public int getCount() {
      return count;
   }
   
   /**
    * Adds a Monster to the monsters
    * 
    * @param monster to be added to the List
    */
   public void add(Monster monster) {
      monsters.add(monster);
      count++;
      monster.setMonsterId(count);
   }
   
   /**
    * Removes a Monster from monsters
    * 
    * @param monsterId of Monster to be removed
    * @return true if successful, false otherwise
    */
   public boolean delete(int monsterId) {
      this.count--;
      return monsters.remove(this.search(monsterId));
   }
   
   /**
    * This method will return a Monster based on monsterID
    * 
    * @param monsterId of Monster that program is searching for
    * @return Monster if found
    * @throws NoSuchElementException if Monster is not found
    */  
   public Monster search(int monsterId) throws NoSuchElementException {
      
      Monster returnMonster = null;
      
      for (int i = 0; i < monsters.size(); i++) {
         Monster currentMonster = monsters.get(i);
         int currentMonsterId = currentMonster.getMonsterId();
         
         if (currentMonsterId == monsterId) {
            returnMonster = monsters.get(i);
            break;
         }
      }
      
      if (returnMonster == null) {
         throw new NoSuchElementException("That id does not exist in this database.");
      } else {
         return returnMonster;
      }
   }
   
   /**
    * This method will return a Monster based on String
    * 
    * @param name of Monster that program is searching for
    * @return Monster if found
    * @throws NoSuchElementException if Monster is not found
    */
   public Monster search(String name) throws NoSuchElementException {
      
      Monster returnMonster = null;
      name = name.toLowerCase();
      
      for (int i = 0; i < monsters.size(); i++) {
         Monster currentMonster = monsters.get(i);
         String currentMonsterName = currentMonster.getName();
         currentMonsterName = currentMonsterName.toLowerCase();
         
         if (currentMonsterName.equals(name)) {
            returnMonster = monsters.get(i);
            break;
         }
      }
      
      if (returnMonster == null) {
         throw new NoSuchElementException("That name does not exist in this database.");
      } else {
         return returnMonster;
      }
   }
   
   /**
    * Filters Monsters in monsters and returns only those
    *    that have the specified Weapon
    * 
    * @param weapon of filter
    * @return filteredMonsters with that Weapon
    */
   public MonsterCollection filter(Weapon weapon) {
      MonsterCollection filteredMonsters = new MonsterCollection();
      
      for (int i = 0; i < monsters.size(); i++) {
         Monster currentMonster = monsters.get(i);
         Weapon currentMonsterWeapon = currentMonster.getWeapon();
         
         if (currentMonsterWeapon == weapon) {
            Monster copyCurrent = currentMonster.copyMonster();
            filteredMonsters.add(copyCurrent);
            copyCurrent.setMonsterId(currentMonster.getMonsterId());
         }
      }
      
      if (filteredMonsters.getCount() == 0) {
         throw new NoSuchElementException("There were no monsters with that filter");
      } else {
         return filteredMonsters;
      }
   }
   
   /**
    * Filters Monsters in monsters and returns only those
    *    that are the specified Species
    * 
    * @param species of filter
    * @return filteredMonsters with that Species
    */
   public MonsterCollection filter(Species species) {
      MonsterCollection filteredMonsters = new MonsterCollection();
      
      for (int i = 0; i < monsters.size(); i++) {
         Monster currentMonster = monsters.get(i);
         Species currentMonsterSpecies = currentMonster.getSpecies();
         
         if (currentMonsterSpecies == species) {
            Monster copyCurrent = currentMonster.copyMonster();
            filteredMonsters.add(copyCurrent);
            copyCurrent.setMonsterId(currentMonster.getMonsterId());
         }
      }
      
      if (filteredMonsters.getCount() == 0) {
         throw new NoSuchElementException("There were no monsters with that filter");
      } else {
         return filteredMonsters;
      }
   }
   
   /**
    * Filters Monsters in monsters and returns only those
    *    that have the same boss boolean value
    * 
    * @param isBoss of filter
    * @return filteredMonsters of that boss type
    */
   public MonsterCollection filter(boolean isBoss) {
      MonsterCollection filteredMonsters = new MonsterCollection();
      
      for (int i = 0; i < monsters.size(); i++) {
         Monster currentMonster = monsters.get(i);
         boolean currentIsBoss = currentMonster.isBoss();
         
         if (currentIsBoss == isBoss) {
            Monster copyCurrent = currentMonster.copyMonster();
            filteredMonsters.add(copyCurrent);
            copyCurrent.setMonsterId(currentMonster.getMonsterId());
         }
      }
      
      if (filteredMonsters.getCount() == 0) {
         throw new NoSuchElementException("There were no monsters with that filter");
      } else {
         return filteredMonsters;
      }
   }
   
   /**
    * Will print the toString() for each Monster in monsters to console
    */
   public void printToConsole() {
      for (int i = 0; i < monsters.size(); i++) {
         System.out.println(monsters.get(i));
      }
   }
   
   /**
    * This will write the MonsterCollection as an object to a file
    * 
    * @param file to write this data on (it will overwrite)
    * @throws IOException if writing was not successful
    */
   public void writeToFile(File file) throws IOException {
      try (
         ObjectOutputStream output = new ObjectOutputStream(
                 new FileOutputStream(file));
      ) {
         output.writeObject(this);
      }
   }
   
}
