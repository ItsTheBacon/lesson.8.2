package kg.lesson.game.player;

import kg.lesson.game.logic.RPG_Game;

public class Warrior extends Hero {


    public Warrior(int health, int damage ) {
        super(health,  damage,  SuperAbility.Critical_Damage);
    }


    @Override
    public void applySuperAbilty(Boss boss, Hero[] heroes) {
        int cooeff = RPG_Game.random.nextInt(10) + 2;
        boss.setHealth(boss.getHealth() - this.getDamage() * cooeff);
        System.out.println("Warrior hits Critically " + this.getDamage() * cooeff);
    }
}
