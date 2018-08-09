/*
 * Sheridan College
 * Course: PROG 24178
 * Instructor: Hosein Marzi
 * Date Created: 8-Aug-2018
 *  
 * @author Mariel Martinez
 *  
 */

package monsterdatabase1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestMonsterCollection {
   public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
      
      // Object to hold database
       MonsterCollection monsters;
       
       try ( // Open the file test.dat
          ObjectInputStream input = new ObjectInputStream(
                  new FileInputStream("test.dat"));
       ) {
          // Save MonsterCollection that is stored in test.dat into a variable
          monsters = (MonsterCollection) input.readObject();
          
          System.out.println("ALL MONSTERS");
          monsters.printToConsole();
          
          System.out.println("\nFILTERED");
          MonsterCollection filtered = monsters.filter(Weapon.FISTS);
          filtered.printToConsole();
          
       } // try-with-resources automatically closes input
   }
}
