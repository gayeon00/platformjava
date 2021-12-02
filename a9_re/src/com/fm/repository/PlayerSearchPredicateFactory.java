package com.fm.repository;
import com.fm.game.*;
import com.fm.unit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlayerSearchPredicateFactory {
    public static List<Predicate<Player>> makeConditions(List<SearchCondition> searchConditions){
        List<Predicate<Player>> result = new ArrayList<>();
        for (SearchCondition condition : searchConditions) {
            String field = condition.getField();
            switch (field){
                case "name":
                    result.add(p->(p.getName().contains(condition.getCondition())));
                    //result.add(p->(Objects.equals(p.getName(), condition.getCondition())));
                    break;
                case "club":
                    result.add(p->(p.getClub().contains(condition.getCondition())));
                    //result.add(p->(Objects.equals(p.getClub(), condition.getCondition())));
                    break;
                case "nationality":
                    result.add(p->(p.getNationality().contains(condition.getCondition())));
                    //result.add(p->(Objects.equals(p.getNationality(), condition.getCondition())));
                    break;
                case "position":
                    result.add(p->p.getPositions().contains(condition.getCondition()));
                    break;
                default:break;
            }
        }

        return result;
    }
}
