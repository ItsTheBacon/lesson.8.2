package kg.lesson.game.player;

import kg.lesson.game.logic.RPG_Game;

public class Thor extends Hero {


    public Thor(int health, int damage) {
        super( health, damage, SuperAbility.STUN);
    }

    @Override
    public void applySuperAbilty(Boss boss, Hero[] heroes) {
        int cooeff = RPG_Game.random.nextInt(3);

        if (cooeff == 1 && this.getHealth() > 0 && boss.getHealth() > 0) {
            boss.setDamage(0);
            System.out.println("Босс оглушон на один раунд");
        }else {
            boss.setDamage(70);
        }
    }

}
