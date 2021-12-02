package uk.epl.game;

import uk.epl.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Player> players = new ArrayList<>();


    public void add(Player newPlayer) {
        players.add(newPlayer);
    }

    public void moveUp(int choosePlayer) {
        for (Player p:players) {
            if (p.getJerseyNumber()==choosePlayer) p.moveUp();
        }
        System.out.println("");
    }

    public void moveDown(int choosePlayer) {
        for (Player p:players) {
            if (p.getJerseyNumber()==choosePlayer) p.moveDown();
        }
    }

    public void moveLeft(int choosePlayer) {
        for (Player p:players) {
            if (p.getJerseyNumber()==choosePlayer) p.moveLeft();
        }
    }

    public void moveRight(int choosePlayer) {
        for (Player p:players) {
            if (p.getJerseyNumber()==choosePlayer) p.moveRight();
        }
    }

    public void start() {
        for (Player p:players) {
            String cname = p.getClass().getSimpleName();
            switch (cname){
                case "Defender":
                    p.setPosition(34,75);
                    break;
                case "Forward":
                    p.setPosition(34,25);
                    break;
                case "Midfielder":
                    p.setPosition(34,50);
                    break;
                default: break;
            }
        }
        System.out.println("");

    }

    public void info() {
        for (Player p:players) {
            System.out.print(p);
        }
        System.out.println("");

    }

    public void stop() {
        System.out.println("");
    }
}
