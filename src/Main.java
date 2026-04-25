import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
}

class StartDatabase {
    public static void main(String[] args){
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);

        mainWindow.openDatabaseUI();
    }
}

class OpenChecklist {
    public static void main(String[] args){
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);

        mainWindow.openChecklistUI();
    }
}