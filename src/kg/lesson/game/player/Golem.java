package kg.lesson.game.player;

import kg.lesson.game.logic.RPG_Game;

public class Golem extends Hero {
    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.ACQUISITIONS);
    }

    @Override
    public void applySuperAbilty(Boss boss, Hero[] heroes) {
        int temp = boss.getDamage() / 5;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && boss.getDamage() > 0) {
                if (this.getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() + temp);
                    System.out.println(this.getClass().getSimpleName() + "  Поглатиль  1/5 часть урона исходящего от босса   ");
                    break;
                }
            }

        }

    }
}
