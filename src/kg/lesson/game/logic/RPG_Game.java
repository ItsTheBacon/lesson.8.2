package kg.lesson.game.logic;

import kg.lesson.game.player.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(1100, 60);
        Warrior warrior = new Warrior(220, 15);
        Magic magic = new Magic(20, 20);
        Medic doc = new Medic(190, 5, 15);
        Thor thor = new Thor(170, 16);
        Golem golem = new Golem(410, 5);
        Antman antman = new Antman(200, 20);
        Berserk berserk = new Berserk(260, 30);
        Medic assistent = new Medic(230, 10, 5);

        Hero[] heroes = {warrior, magic, doc, berserk, assistent, thor, antman, golem};
        printStatistics(boss, heroes);

        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);

        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            Bosshits(boss, heroes);
        }
        heroushit(boss, heroes);
        System.out.println("_______________________________");
        applySuperPower(boss, heroes);

        printStatistics(boss, heroes);

    }

    private static void Bosshits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {

                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {

                heroes[i].applySuperAbilty(boss, heroes);
            }
        }
    }

    private static void heroushit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("_______________________________");
        System.out.println("Boss Health: " + boss.getHealth() + " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() +
                    " Health: " + heroes[i].getHealth() +
                    " [" + heroes[i].getDamage() + "]");

        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won !!!");
            return true;
        }
        boolean allheroDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allheroDead = false;
                break;
            }
        }
        if (allheroDead) {
            System.out.println("boss won!!!");
        }
        return allheroDead;
    }
}

