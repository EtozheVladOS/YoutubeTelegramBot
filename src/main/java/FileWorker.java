import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

public class FileWorker {

    public static File fileFind() {
        File root = new File("C:\\Users\\VladOS\\IdeaProjects\\SoundDestroyerBot");
        String fileFormat = ".mp3";
        File resFile = null;
        try {
            boolean recursive = true;

            Collection files = FileUtils.listFiles(root, null, recursive);

            for (Iterator iterator = files.iterator(); iterator.hasNext(); ) {
                File file = (File) iterator.next();
                if (file.getName().contains(fileFormat)) {
                    resFile = file;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resFile;
    }

    public static void fileDelete() {
        File root = new File("C:\\Users\\VladOS\\IdeaProjects\\SoundDestroyerBot");
        String fileFormat = ".mp3";
        try {
            boolean recursive = true;

            Collection files = FileUtils.listFiles(root, null, recursive);

            for (Iterator iterator = files.iterator(); iterator.hasNext(); ) {
                File file = (File) iterator.next();
                if (file.getName().contains(fileFormat)) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

