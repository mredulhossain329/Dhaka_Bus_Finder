//
//import javax.swing.*;
//import java.awt.*;
//import java.util.*;
//import java.util.List;
//import java.util.ArrayList;
//public class Main {
//    private static List<Bus> buses;
//
//  //  public static void main(String[] args) {
//        Main(){
//        List<String>city=new ArrayList<>();
//        cites City=new cites();
//        city=City.take_city();
//        int Size=City.take_size();
//        for(int i=0;i<Size;i++)System.out.println(city.get(i));
//        buses = BusDataLoader.loadBuses("data/buses.json");
//
//        JFrame frame = new JFrame("Dhaka Bus Route Finder");
//        frame.setSize(500, 400);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new FlowLayout());
//
//        JLabel srcLabel = new JLabel("From:");
//        JComboBox<String> sourceBox = new JComboBox<>(getAllStops());
//        for(int i=0;i<Size;i++)
//        sourceBox.addItem(city.get(i));
//        JLabel destLabel = new JLabel("To:");
//        JComboBox<String> destBox = new JComboBox<>(getAllStops());
//        for(int i=0;i<Size;i++){
//            System.out.println("adding"+city.get(i));
//        destBox.addItem(city.get(i));}
//
//        JButton findButton = new JButton("Find Bus");
//        JTextArea resultArea = new JTextArea(10, 40);
//        resultArea.setEditable(false);
//
//        findButton.addActionListener(e -> {
//            String source = (String) sourceBox.getSelectedItem();
//            String dest = (String) destBox.getSelectedItem();
//            resultArea.setText(findMatchingBuses(source, dest));
//        });
//
//        frame.add(srcLabel); frame.add(sourceBox);
//        frame.add(destLabel); frame.add(destBox);
//        frame.add(findButton);
//        frame.add(new JScrollPane(resultArea));
//        frame.setVisible(true);
//    }
//
//    private static String[] getAllStops() {
//        Set<String> stops = new TreeSet<>();
//        for (Bus bus : buses) {
//            stops.addAll(bus.route);
//        }
//        return stops.toArray(new String[0]);
//    }
//
//    private static String findMatchingBuses(String src, String dest) {
//        StringBuilder sb = new StringBuilder();
//        for (Bus bus : buses) {
//            List<String> r = bus.route;
//            if (r.contains(src) && r.contains(dest) && r.indexOf(src) < r.indexOf(dest)) {
//                sb.append("Bus: ").append(bus.name).append("\n");
//                sb.append("Route: ").append(String.join(" → ", r)).append("\n");
//                sb.append("Fare: ").append(bus.fare).append(" BDT\n\n");
//            }
//        }
//        return sb.length() > 0 ? sb.toString() : "No matching bus found.";
//    }
//}

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static List<Bus> buses;

    public Main() {
        List<String> city = new ArrayList<>();
        cites City = new cites();  // Make sure 'cites' class exists and is correct
        city = City.take_city();
        int Size = City.take_size();

        buses = BusDataLoader.loadBuses("data/buses.json");

        JFrame frame = new JFrame("Dhaka Bus Route Finder");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel srcLabel = new JLabel("From:");
        JComboBox<String> sourceBox = new JComboBox<>();
        for (int i = 0; i < Size; i++)
            sourceBox.addItem(city.get(i));

        JLabel destLabel = new JLabel("To:");
        JComboBox<String> destBox = new JComboBox<>();
        for (int i = 0; i < Size; i++)
            destBox.addItem(city.get(i));

        JButton findButton = new JButton("Find Bus");
        JTextArea resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);

        findButton.addActionListener(e -> {
            String source = (String) sourceBox.getSelectedItem();
            String dest = (String) destBox.getSelectedItem();
            resultArea.setText(findMatchingBuses(source, dest));
        });

        frame.add(srcLabel); frame.add(sourceBox);
        frame.add(destLabel); frame.add(destBox);
        frame.add(findButton);
        frame.add(new JScrollPane(resultArea));
        frame.setVisible(true);
    }

    private static String findMatchingBuses(String src, String dest) {
        StringBuilder sb = new StringBuilder();
        List<String> buses=new ArrayList<>();
        Bus b=new Bus(src,dest);
        buses=b.find_bus();
        //sb.append("Bus: ").append(buses.get(0)).append("\n");
        for (String busName : buses) {
            sb.append("Bus: ").append(busName).append("\n");
        }

        /*for (Bus bus : buses) {
            List<String> r = bus.route;
            if (r.contains(src) && r.contains(dest) && r.indexOf(src) < r.indexOf(dest)) {
                sb.append("Bus: ").append(bus.name).append("\n");
                sb.append("Route: ").append(String.join(" → ", r)).append("\n");
                sb.append("Fare: ").append(bus.fare).append(" BDT\n\n");
            }
        }*/
        return sb.length() > 0 ? sb.toString() : "No matching bus found.";
    }
}

