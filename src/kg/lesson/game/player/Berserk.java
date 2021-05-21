package kg.lesson.game.player;

import kg.lesson.game.logic.RPG_Game;

public class Berserk extends Hero {


    public Berserk(int health, int damage ) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbilty(Boss boss, Hero[] heroes) {
        int coeef = RPG_Game.random.nextInt(5) + 2;
        boss.setHealth(boss.getHealth() - this.getDamage() + coeef );
        System.out.println("berserk used return damage  "  + this.getDamage() );
    }
}


