package kg.lesson.game.player;

import kg.lesson.game.logic.RPG_Game;

public class Magic extends Hero{


    public Magic(int health, int damage   ) {
        super(health, damage, SuperAbility.Boost);
    }

    @Override
    public void applySuperAbilty(Boss boss, Hero[] heroes) {
        int cooeff = RPG_Game.random.nextInt(10) +1 ;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 &&  this != heroes[i])
                heroes[i].setDamage(heroes[i].getDamage() + cooeff);
        }
        System.out.println("Mag  Урон героев будет увелечен на: " + cooeff);
    }
}

