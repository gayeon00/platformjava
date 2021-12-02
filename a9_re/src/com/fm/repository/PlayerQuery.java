package com.fm.repository;
import com.fm.unit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlayerQuery {
    public static List<Player> query(List<Player> players, List<Predicate<Player>> conditions){
//        Predicate<Player> fin = conditions.get(0);
//        List<Player> result = new ArrayList<>();
//        for (int i = 1; i < conditions.size(); i++) {
//            fin = fin.and(conditions.get(i));
//        }
//        //return players.stream().filter(fin).collect(Collectors.toList());
//        for (Player player: players) {
//            if(fin.test(player)) result.add(player);
//        }
//        return result;
        return players.stream().filter(conditions.stream().reduce(x->true,Predicate::and)).collect(Collectors.toList());
    }
}