import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    MainWindow(){
        this.setTitle("Main Window");
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

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

        JMenuBar mainMenu = new JMenuBar();
        mainMenu.add(menuFile);
        mainMenu.add(menuEdit);

        this.setJMenuBar(mainMenu);
        this.createGUI();
    }
    void createGUI(){
        JPanel panelDatabase = new JPanel();
        JButton buttonDatabase = new JButton("Administrate Database");
        panelDatabase.add(buttonDatabase);
        panelDatabase.setVisible(true);

        JPanel panelEvent = new JPanel();
        JButton buttonEvent = new JButton("Plan Event");
        panelEvent.add(buttonEvent);
        panelEvent.setVisible(true);


        JPanel panelChecklist = new JPanel();
        JButton buttonChecklist = new JButton("Checklist");
        panelChecklist.add(buttonChecklist);
        panelChecklist.setVisible(true);

        this.setLayout(new GridLayout(1,3));

        this.add(panelDatabase);
        this.add(panelEvent);
        this.add(panelChecklist);
    }
}
