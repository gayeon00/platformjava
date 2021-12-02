package com.fm.repository;

import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {//ok
    public static Player createPlayersWithoutID(String[] fields){
        return new Player(getName(fields,1), getHeight(fields,1),
                getNationality(fields,1), getClub(fields,1), getOverall(fields,1), getPosition(fields,1));
    }

    public static Player createPlayers(String[] fields){
        return new Player(getId(fields,0), getName(fields,0), getHeight(fields,0),
                getNationality(fields,0), getClub(fields,0), getOverall(fields,0), getPosition(fields,0));
    }

    private static List<String> getPosition(String[] fields,int flag) {
        List<String> positions = new ArrayList<>();
        if (fields[Player.POSITION-flag].startsWith("\"")) {
            for (int i = Player.POSITION-flag; i < fields.length; i++)
                positions.add(fields[i].replace("\"", "").trim());
        } else {
            positions.add(fields[Player.POSITION-flag]);
        }
        return positions;
    }

    private static int getOverall(String[] arr,int flag) {
        return Integer.parseInt(arr[Player.OVERALL-flag]);
    }

    private static String getClub(String[] fields,int flag) {
        return fields[Player.CLUB-flag];
    }

    private static String getNationality(String[] fields,int flag) {
        return fields[Player.NATIONALITY-flag];
    }

    private static int getHeight(String[] fields,int flag) {
        return Integer.parseInt(fields[Player.HEIGHT-flag]);
    }

    private static String getName(String[] fields,int flag) {
        return fields[Player.NAME-flag];
    }

    private static int getId(String[] fields,int flag) {
        return Integer.parseInt(fields[Player.ID-flag]);
    }
}
