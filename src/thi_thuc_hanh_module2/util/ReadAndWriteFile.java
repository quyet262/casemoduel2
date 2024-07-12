package thi_thuc_hanh_module2.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public  static List<String> readFile(String fileName) throws IOException {
        List<String> listFromFile = new ArrayList<String>();
        File file = new File(fileName);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    listFromFile.add(line);
                }
            }
        }
        return listFromFile;
    }
    public static void writeFile(String fileName, String line, boolean append) throws IOException {
        File file = new File(fileName);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))) {
            if (!append) {
                bw.write(line);
            } else {
                bw.write(line);
                bw.newLine();
            }
        }
    }

}