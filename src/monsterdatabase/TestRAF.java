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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestRAF {
   public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
      
       MonsterCollection monsters = new MonsterCollection();
       monsters.add(new Monster("Witch", Weapon.MAGIC, Species.HUMAN, 8));
       monsters.add(new Monster("Werewolf", Weapon.FISTS, Species.SUPERNATURAL, 10));
       monsters.add(new Monster("Knight", Weapon.SWORD, Species.HUMAN, 11));
       monsters.add(new Monster("Yeti", Weapon.FISTS, Species.ANIMAL, 18));
       monsters.add(new Monster("Zombie", Weapon.MAGIC, Species.HUMAN, 12));
       monsters.add(new Monster("Rogue", Weapon.BOW, Species.HUMAN, 5));
       monsters.add(new Monster("Bandit", Weapon.AXE, Species.HUMAN, 3));
       monsters.add(new Monster("Bear", Weapon.FISTS, Species.ANIMAL, 4));
       monsters.add(new Monster("Pirate", Weapon.SWORD, Species.HUMAN, 11));
       monsters.add(new Monster("Paladin", Weapon.SPEAR, Species.HUMAN, 20));
       monsters.add(new Monster("Thief", Weapon.KNIFE, Species.HUMAN, 15));
       monsters.add(new Monster("Ghost", Weapon.MAGIC, Species.SUPERNATURAL, 16));
       monsters.add(new Monster("Ice Wolf", Weapon.MAGIC, Species.ANIMAL, 8));
       monsters.add(new Monster("Fire Wolf", Weapon.MAGIC, Species.ANIMAL, 10));
       monsters.add(new Monster("Wizard", Weapon.MAGIC, Species.HUMAN, 12));
       monsters.add(new Monster("Warlock", Weapon.MAGIC, Species.HUMAN, 18));
       monsters.add(new Monster("Warrior", Weapon.SPEAR, Species.HUMAN, 9));
       monsters.add(new Monster("Vampire", Weapon.MAGIC, Species.HUMAN, 19));
       monsters.add(new Monster("Pyromancer", Weapon.MAGIC, Species.HUMAN, 25));
       monsters.add(new Monster("Sailor", Weapon.HAMMER, Species.HUMAN, 7));
       monsters.add(new Monster("Skeleton", Weapon.MAGIC, Species.SUPERNATURAL, 14));
       monsters.add(new Monster("Captain", Weapon.SWORD, Species.HUMAN, 12));
       monsters.add(new Monster("Demon", Weapon.MAGIC, Species.SUPERNATURAL, 24));
       monsters.add(new Monster("Butcher", Weapon.HAMMER, Species.HUMAN, 13));
       monsters.add(new Monster("Mage", Weapon.MAGIC, Species.HUMAN, 14));
       monsters.add(new Monster("Giant", Weapon.FISTS, Species.SUPERNATURAL, 9));
       monsters.add(new Monster("Thug", Weapon.FISTS, Species.HUMAN, 3));
       monsters.add(new Monster("Hag", Weapon.MAGIC, Species.SUPERNATURAL, 8));
       monsters.add(new Monster("Soldier", Weapon.SWORD, Species.HUMAN, 13));
       monsters.add(new Monster("General", Weapon.SPEAR, Species.HUMAN, 15));
    
       File file = new File("test.dat");
       monsters.writeToFile(file);
       
       //       Monster witch2 = monsters.get(0);
//       System.out.println(witch2);
//      try (
//         ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("test.dat"))
//      ) {
//         output.writeObject(monsters);
//      }

//       File file = new File("test.dat");
//       monsters.printToFile(file);
       
//       MonsterCollection monsters2;
//       try ( 
//          ObjectInputStream input = new ObjectInputStream(new FileInputStream("test.dat"));
//       ) {
//          monsters2 = (MonsterCollection) input.readObject();
//       }
//       
//       Monster witch2 = monsters2.get(0);
//       System.out.println(witch2);

//      File file = new File("test.dat");
//      System.out.println(file.exists());
//      System.out.println(file.getAbsolutePath());
      
       
   }
}
