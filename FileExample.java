import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileExample {

    static List<File> getFiles(File start) throws IOException {
        List<File> result = new ArrayList<>();
        if (start.isFile()) {
            result.add(start);
        } else if (start.isDirectory()) {
            File[] files = start.listFiles();
            if (files != null) {
                for (File file : files) {
                    result.addAll(getFiles(file));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        File start = new File("folder1/");
        List<File> files = FileExample.getFiles(start);

        for (File file : files) {
            System.out.println(file.getPath());
        }
    }
}