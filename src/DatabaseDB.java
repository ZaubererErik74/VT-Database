import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseDB {
    String SourceFileDir;
    List<InventoryItem> inventory;
    DatabaseDB(String SourceFileDir){
        this.SourceFileDir = SourceFileDir;
        this.inventory = importSourceFile();
    }

    List<InventoryItem> importSourceFile(){
        List<InventoryItem> list = new ArrayList<>();
        File sourceFile = new File(this.SourceFileDir);

        try (Scanner reader = new Scanner(sourceFile)){
            while (reader.hasNextLine()){
                String data = reader.nextLine();
                String[] parts = data.split(";");
                InventoryItem part = new InventoryItem(
                        parts[0], parts[1], parts[2], parts[3], parts[4]
                );
                list.add(part);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}

class InventoryItem{
    String id;
    String name;
    String location;
    String condition;
    String comment;

    InventoryItem(String id, String name, String location, String condition, String comment){
        this.id = id;
        this.name = name;
        this.location = location;
        this.condition = condition;
        this.comment = comment;
    }
    String[] getDataTable(){
        return new String[]{id, name, location, condition, comment};
    }
}