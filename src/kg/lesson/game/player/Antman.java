package kg.lesson.game.player;

import kg.lesson.game.logic.RPG_Game;

public class Antman  extends Hero{
    public Antman( int health, int damage   ) {
        super(health,  damage, SuperAbility.INCREMENT_AND_CONTRACTION);
    }

    @Override
    public void applySuperAbilty(Boss boss, Hero[] heroes) {
     int cooef = RPG_Game.random.nextInt(3);
     switch (cooef){
         case 0:
         this.setHealth(this.getHealth()/  2);
         boss.setHealth(boss.getHealth()- (this.getDamage()/2));
             System.out.println(this.getClass().getSimpleName() +" Уменшилься в два раза");
             break;

         case 1:

             break;
         case 2:
             this.setHealth(this.getHealth()*2);
             boss.setHealth(boss.getHealth() -(this.getDamage()*2));
             System.out.println(this.getClass().getSimpleName() + "  Увеличелся в два раза");
             break;
         default:
             this.setHealth(0);
             break;
     }

    }
}
