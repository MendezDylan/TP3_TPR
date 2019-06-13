/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

import java.io.Serializable;

/**
 *
 * @author Dylan
 */

/*-	Especie (ejemplo: Pikachu).
-	Nombre (ejemplo: “ratita con hepatitis”).
-	Ataque.
-	Defensa.
-	Velocidad.
-	Ataque especial.
-	Defensa especial,
-	Preevolución.
-	Posible evolución.
-	Padre.
-	Hijos.
*/
public class Pokemon implements Serializable{
    //personal atributes
    private String species;
    private String name;
    //battle atributes
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    //evolutions and family tree
    private String preEvolution;
    private String evolution;
    private Pokemon parent;
    private Pokemon child;

    public Pokemon(String species, String name, int attack, int defense, int specialAttack, int specialDefense, int speed) {
        this.species = species;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.preEvolution = null;
        this.evolution = null;
        this.parent = null;
        this.child = null;
    }
    
    

    //Set & get
    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public String getPreEvolution() {
        return preEvolution;
    }

    public String getEvolution() {
        return evolution;
    }

    public Pokemon getParent() {
        return parent;
    }

    public Pokemon getChild() {
        return child;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setPreEvolution(String preEvolution) {
        this.preEvolution = preEvolution;
    }

    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    public void setParent(Pokemon parent) {
        this.parent = parent;
    }

    public void setChild(Pokemon child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "species=" + species + ", name=" + name + ", attack=" + attack + ", defense=" + defense + ", specialAttack=" + specialAttack + ", specialDefense=" + specialDefense + ", speed=" + speed + '}';
    }
    
}
