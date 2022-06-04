import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Save {
    public void saveGame(String path, GameProgress gamePr) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gamePr);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void zipFiles(String path, String[] path2) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(path))) {
            for (int i = 0; i < path2.length; i++) {
                String str = Integer.toString(i);
                try (FileInputStream fis = new FileInputStream(path2[i])) {
                    ZipEntry ze = new ZipEntry("save.txt" + str);
                    zos.putNextEntry(ze);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zos.write(buffer);
                    zos.closeEntry();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        File file1 = new File("C:\\Games\\savegames\\save1.dat");
        if (file1.delete()) {
            System.out.println("файл удален");
        } else System.out.println("не обнаружено");
        File file2 = new File("C:\\Games\\savegames\\save2.dat");
        if (file2.delete()) {
            System.out.println("файл удален");
        } else System.out.println("не обнаружено");
        File file3 = new File("C:\\Games\\savegames\\save3.dat");
        if (file3.delete()) {
            System.out.println("файл удален");
        } else System.out.println("не обнаружено");
    }
}
