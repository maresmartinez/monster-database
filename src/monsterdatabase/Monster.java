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

import java.io.Serializable;

public class Monster implements Serializable {
   
   // Instance Variables
   private int monsterId;
   private String name;
   private String battleCry;
   private String deathCry;
   private Weapon weapon;
   private Species species;
   private int hitPoints;
   private int mana;
   private int defence;
   private int attackDamage;
   private int gold;
   private int experience;
   private int level;
   private String lore;
   private boolean boss;

   // Constructors
   public Monster() {
      
   }

   public Monster(String name, Weapon weapon, Species species, int level) {
      this.name = name;
      this.weapon = weapon;
      this.species = species;
      this.level = level;
   }
   
   public Monster(int monsterId) {
      this.monsterId = monsterId;
   }

   /** This returns a brief String representation of the Monster 
    * @return brief String describing Monster
    */
   @Override
   public String toString() {
      String desc = String.format("ID: %d, Monster: %s, Weapon: %s, Species: %s, Level: %d", 
              getMonsterId(), getName(), getWeapon(), getSpecies(), getLevel());
      return desc;
   }
   
   /**
    * Returns a copy of Monster with the same instance variables
    *    except, monsterId
    * @return copy of this Monster
    */
   public Monster copyMonster() {
      Monster copy = new Monster();
      
      copy.setAttackDamage(this.attackDamage);
      copy.setBattleCry(this.battleCry);
      copy.setBoss(this.boss);
      copy.setDeathCry(this.deathCry);
      copy.setDefence(this.defence);
      copy.setExperience(this.experience);
      copy.setGold(this.gold);
      copy.setHitPoints(this.hitPoints);
      copy.setLevel(this.level);
      copy.setLore(this.lore);
      copy.setMana(this.mana);
      copy.setName(this.name);
      copy.setSpecies(this.species);
      copy.setWeapon(this.weapon);
      
      return copy;
   }
   
   // Getters and Setters
   public int getMonsterId() {
      return monsterId;
   }
   
   public void setMonsterId(int monsterId) {
      this.monsterId = monsterId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getBattleCry() {
      return battleCry;
   }

   public void setBattleCry(String battleCry) {
      this.battleCry = battleCry;
   }

   public String getDeathCry() {
      return deathCry;
   }

   public void setDeathCry(String deathCry) {
      this.deathCry = deathCry;
   }

   public Weapon getWeapon() {
      return weapon;
   }

   public void setWeapon(Weapon weapon) {
      this.weapon = weapon;
   }

   public Species getSpecies() {
      return species;
   }

   public void setSpecies(Species species) {
      this.species = species;
   }

   public int getHitPoints() {
      return hitPoints;
   }

   public void setHitPoints(int hitPoints) {
      this.hitPoints = hitPoints;
   }

   public int getMana() {
      return mana;
   }

   public void setMana(int mana) {
      this.mana = mana;
   }

   public int getDefence() {
      return defence;
   }

   public void setDefence(int defence) {
      this.defence = defence;
   }

   public int getAttackDamage() {
      return attackDamage;
   }

   public void setAttackDamage(int attackDamage) {
      this.attackDamage = attackDamage;
   }

   public int getGold() {
      return gold;
   }

   public void setGold(int gold) {
      this.gold = gold;
   }

   public int getExperience() {
      return experience;
   }

   public void setExperience(int experience) {
      this.experience = experience;
   }

   public int getLevel() {
      return level;
   }

   public void setLevel(int level) {
      this.level = level;
   }

   public String getLore() {
      return lore;
   }

   public void setLore(String lore) {
      this.lore = lore;
   }

   public boolean isBoss() {
      return boss;
   }

   public void setBoss(boolean boss) {
      this.boss = boss;
   }
   
}
