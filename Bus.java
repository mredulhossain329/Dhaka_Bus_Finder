
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Bus {
    public String name;
    public List<String> route;
    public int fare;
    public List<String> bus;
    public List<String> desti;

    public Bus(String name, List<String> route, int fare) {
        this.name = name;
        this.route = route;
        this.fare = fare;
    }

    public Bus(String source, String dest) {
        bus = new ArrayList<>();
        desti=new ArrayList<>();
        int size = 0;
        try {
            String filename = source+".txt";
            File file = new File("D:\\DhakaBusFinder_With_JSON_Jar\\DhakaBusFinder\\src\\Bus\\" + filename); // Make sure this file exists
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                bus.add(line);
            }
        }catch (FileNotFoundException e) {
            //System.out.println("File not found.");
            e.printStackTrace();
        }
        try {
            String filename = dest+".txt";
            File file = new File("D:\\DhakaBusFinder_With_JSON_Jar\\DhakaBusFinder\\src\\Bus\\" + filename); // Make sure this file exists
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                desti.add(line);
            }
        }catch (FileNotFoundException e) {
            //System.out.println("File not found.");
            e.printStackTrace();
        }
    }
    public List<String> find_bus(){
        List<String> common = new ArrayList<>(bus);
        common.retainAll(desti);
        return common;
    }
}