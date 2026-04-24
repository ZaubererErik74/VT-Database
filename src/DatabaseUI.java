import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;

public class DatabaseUI extends JFrame {


    CardLayout layout;
    JPanel mainPanel;

    InventoryUI inventoryUI;
    AssetsUI assetsUI;

    DatabaseDB databaseDB;
    DatabaseUI(){
        this.layout = new CardLayout();
        mainPanel = new JPanel(layout);

        this.setTitle("Database");
        this.setSize(1920, 1080);

        JMenu menuFile = new JMenu("file");
        JMenuItem menuFileOpen = new JMenuItem("open");menuFile.add(menuFileOpen);
        JMenuItem menuFileSave = new JMenuItem("save");menuFile.add(menuFileSave);
        JMenuItem menuFileSaveAs = new JMenuItem("save as");menuFile.add(menuFileSaveAs);
        menuFile.addSeparator();
        JMenuItem menuFileImport = new JMenuItem("Import");menuFile.add(menuFileImport);
        JMenuItem menuFileExport = new JMenuItem("Export");menuFile.add(menuFileExport);

        JMenu menuEdit = new JMenu("edit");
        JMenuItem menuEditUndo = new JMenuItem("undo");menuEdit.add(menuEditUndo);
        JMenuItem menuEditRedo = new JMenuItem("redo");menuEdit.add(menuEditRedo);
        menuEdit.addSeparator();
        JMenuItem menuEditSettings = new JMenuItem("settings");menuEdit.add(menuEditSettings);

        JMenu menuMode = new JMenu("mode");
        JMenuItem menuModeInventory = new JMenuItem("inventory");menuMode.add(menuModeInventory);
        menuModeInventory.addActionListener(l -> openInventory());
        JMenuItem menuModeAssets = new JMenuItem("assets");menuMode.add(menuModeAssets);
        menuModeAssets.addActionListener(l -> openAssets());
        JMenuItem menuModeSearch = new JMenuItem("search");menuMode.add(menuModeSearch);

        JMenuBar mainMenu = new JMenuBar();
        mainMenu.add(menuFile);
        mainMenu.add(menuEdit);
        mainMenu.add(menuMode);

        this.setJMenuBar(mainMenu);

        this.databaseDB = new DatabaseDB("C:\\sourceFile.txt");
        this.inventoryUI = new InventoryUI(this.databaseDB);
        this.assetsUI = new AssetsUI(this.databaseDB);

        mainPanel.add(inventoryUI, "Inventory");
        mainPanel.add(assetsUI, "Assets");

        this.add(mainPanel);
    }
    void openInventory(){
        layout.show(mainPanel, "Inventory");
    }
    void openAssets(){
        layout.show(mainPanel, "Assets");
    }
}

class InventoryUI extends JPanel{

    InventoryUI(DatabaseDB db){
        JLabel labelTitle = new JLabel("Inventory");
        this.add(labelTitle);

        JTable inventoryTable = new JTable();
        String[] columns = {"ID","Name","Location","Condition","Comment"};
        Object[][] data = new Object[db.inventory.size()][5];
        for(int i = 0; i < db.inventory.size(); i++){
            data[i] = db.inventory.get(i).getDataTable();
        }
        inventoryTable = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(inventoryTable);
        this.add(scroll, BorderLayout.CENTER);
    }
}
class AssetsUI extends JPanel{

    AssetsUI(DatabaseDB databaseDB){
        JLabel labelTitle = new JLabel("Assets");
        this.add(labelTitle);


    }
}