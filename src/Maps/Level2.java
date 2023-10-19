package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.KeyL1;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;
import NPCs.Walrus;
import Tilesets.CommonTileset;
import Tilesets.Level2Tiles;
import Utils.Direction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


// Represents a test map to be used in a level
public class Level2 extends Map {

    public Level2() {
        super("Level2.txt", new Level2Tiles());
        this.playerStartPosition = getMapTile(2, 11).getLocation();
    }

    public void reloadMapFromFile() {
        loadMapFile();
    }
    

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        BugEnemy bugEnemy = new BugEnemy(getMapTile(16, 10).getLocation().subtractY(25), Direction.LEFT);
        enemies.add(bugEnemy);

       /*  DinosaurEnemy dinosaurEnemy = new DinosaurEnemy(getMapTile(19, 1).getLocation().addY(2), getMapTile(22, 1).getLocation().addY(2), Direction.RIGHT);
        enemies.add(dinosaurEnemy);*/

        return enemies;
    }

    // public static void replaceAllWallTilesInFile() throws IOException {
    //     // path
    //     String path = "MapFiles/only_git_map.txt";
    
    //     // Read the map file using the updated path
    //     List<String> lines = Files.readAllLines(Paths.get(path));
    
    //     // Modify the lines by replacing all 17 tiles with 7
    //     for (int i = 0; i < lines.size(); i++) {
    //         String line = lines.get(i);
    //         line = line.replaceAll(" 54 ", " 7 ");  // Replace all 54 tiles with 7
    //         lines.set(i, line);
    //     }
    
    //     // Write the modified map back to the file
    //     Files.write(Paths.get(path), lines);

        
    // }

    // public static void resetMapToFile() throws IOException {
    //     // Path to the backup map
    //     String backupPath = "MapFiles/only_git_map_backup.txt";
    //     String targetPath = "MapFiles/only_git_map.txt";
    
    //     // Read the backup map
    //     List<String> backupLines = Files.readAllLines(Paths.get(backupPath));
    
    //     // Overwrite the target map with the backup map's content
    //     Files.write(Paths.get(targetPath), backupLines);
    // }
    


    
    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        HorizontalMovingPlatform hmp = new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getMapTile(24, 6).getLocation(),
                getMapTile(27, 6).getLocation(),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        );
        enhancedMapTiles.add(hmp);

        EndLevelBox endLevelBox = new EndLevelBox(getMapTile(42, 12).getLocation());
        enhancedMapTiles.add(endLevelBox);

        KeyL1 keyL1 = new KeyL1(getMapTile(2, 5).getLocation());
        keyL1.setMapReference(this);  // Set the reference to this map
        enhancedMapTiles.add(keyL1);
        
        return enhancedMapTiles;

    }


    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Walrus walrus = new Walrus(getMapTile(20, 17).getLocation().subtractY(13));
        npcs.add(walrus);

        return npcs;
    }
}
