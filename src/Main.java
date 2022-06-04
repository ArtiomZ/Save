public class Main {
    public static void main(String[] args) {
        Save save = new Save();

        GameProgress gp1 = new GameProgress(90, 2, 3, 1500.6);
        GameProgress gp2 = new GameProgress(70, 4, 5, 2300.9);
        GameProgress gp3 = new GameProgress(50, 7, 8, 3400.1);
        save.saveGame("C:\\Games\\savegames\\save1.dat", gp1);
        save.saveGame("C:\\Games\\savegames\\save2.dat", gp2);
        save.saveGame("C:\\Games\\savegames\\save3.dat", gp3);

        String[] path = new String[]{
                "C:\\Games\\savegames\\save1.dat",
                "C:\\Games\\savegames\\save2.dat",
                "C:\\Games\\savegames\\save3.dat"
        };

        save.zipFiles("C:\\Games\\savegames\\archive.zip", path);
    }
}
