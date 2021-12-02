package com.fm.repository;

import com.fm.unit.Player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FileRepository implements IRepository {
    public static final String[] FILE_HEADER =
            { "sofifa_id", "short_name", "height_cm", "nationality", "club", "overall", "player_positions", "\n" };
    private static FileRepository instance = new FileRepository();
    public final String FILENAME =
            Thread.currentThread().getContextClassLoader().getResource("players_20_short.csv").getFile();
    private boolean loaded = false;
    private List<Player> players;

    public boolean isLoaded() {
        return loaded;
    }

    private FileRepository(){
        load();
    }

    public static FileRepository getInstance() {return instance;}

    private Player create(String[] fields) {
        return PlayerFactory.createPlayers(fields);
    }

    private void load(){//파일에서 데이터 불러와서 players에 저장하기 같은데?
        //.replaceAll("/C:","")
        if (!isLoaded()){
            Path src = Paths.get(FILENAME);
            try{
                players = new ArrayList<>();
                BufferedReader reader = Files.newBufferedReader(src);
                reader.readLine(); // 첫줄 빼주기
                String line;
                while ((line=reader.readLine())!=null){
                    Player p = create(line.split(","));
                    players.add(p);
                }
                reader.close();
                loaded=true;
            }catch (IOException e){
                System.err.println(e.toString());
            }
        }

    }
    ////////////////////////////////////////////
    @Override
    public int count() { //ok
        return players.size();
    }

    @Override
    public void save(Player t) {//players에도 업데이트, 파일에도 업데이트
        players.add(t);
        Path src = Paths.get(FILENAME);
        try {
            BufferedWriter writer = Files.newBufferedWriter(src);
            writer.write("sofifa_id,short_name,height_cm,nationality,club,overall,player_positions\n");
            for (Player p:players) {
                writer.write(p.toString()+"\n");
            }
            writer.close();
        }catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public void delete(Player t) {
        players.remove(t);
        Path src = Paths.get(FILENAME);
        try {
            BufferedWriter writer = Files.newBufferedWriter(src);
            writer.write("sofifa_id,short_name,height_cm,nationality,club,overall,player_positions\n");
            for (Player p:players) {
                writer.write(p.toString()+"\n");
            }
            writer.close();
        }catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteById(int id) {//players에도 지우기, 파일에도 지우기
        delete(findById(id).get());
    }

    @Override
    public boolean existsById(int id) {//ok
        return (!findById(id).isPresent());
    }

    @Override
    public Iterable<Player> findAll() {
        return null;
    }

    @Override
    public Optional<Player> findById(int id) {//ok
        return players.stream().filter(p->p.getId()==id).findAny();
    }

    @Override
    public List<Player> findByConditions(List<Predicate<Player>> conditions) {//ok
        return PlayerQuery.query(players,conditions);
    }
}
