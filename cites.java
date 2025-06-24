import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cites {
    List<String> city;
    int size;
    cites() {
         city= new ArrayList<>();
         size = 0;
        try {
            File file = new File("D:\\DhakaBusFinder_With_JSON_Jar\\DhakaBusFinder\\src\\city.txt"); // Make sure this file exists
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                city.add(line);
                size++;
            }

            reader.close();

        } catch (FileNotFoundException e) {
            //System.out.println("File not found.");
            e.printStackTrace();
        }
    }
    public List<String> take_city(){
        return city;
    }
    public int take_size(){
        return size;
    }
}