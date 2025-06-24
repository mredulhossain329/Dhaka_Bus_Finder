
import org.json.*;
import java.nio.file.*;
import java.util.*;

public class BusDataLoader {
    public static List<Bus> loadBuses(String filepath) {
        List<Bus> busList = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(filepath)));
            JSONObject json = new JSONObject(content);
            JSONArray buses = json.getJSONArray("buses");

            for (int i = 0; i < buses.length(); i++) {
                JSONObject b = buses.getJSONObject(i);
                String name = b.getString("name");
                JSONArray routeArray = b.getJSONArray("route");
                List<String> route = new ArrayList<>();
                for (int j = 0; j < routeArray.length(); j++) {
                    route.add(routeArray.getString(j));
                }
                int fare = b.getInt("fare");
                busList.add(new Bus(name, route, fare));  // ✅ CORRECT


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return busList;
    }
}

//import org.json.*;
//import java.nio.file.*;
//import java.util.*;
////
//public class BusDataLoader {
//
//    // Method to load all buses from JSON file
//    public static List<Bus> loadBuses(String filepath) {
//        List<Bus> busList = new ArrayList<>();
//
//        try {
//            // Read full file content as a String
//            String content = new String(Files.readAllBytes(Paths.get(filepath)));
//
//            // Parse the JSON content
//            JSONObject json = new JSONObject(content);
//            JSONArray buses = json.getJSONArray("buses");
//
//            // Loop through each bus entry
//            for (int i = 0; i < buses.length(); i++) {
//                JSONObject b = buses.getJSONObject(i);
//
//                // Extract bus fields
//                String name = b.getString("name");
//                JSONArray routeArray = b.getJSONArray("route");
//                int fare = b.getInt("fare");
//
//                // Convert JSONArray route to List<String>
//                List<String> route = new ArrayList<>();
//                for (int j = 0; j < routeArray.length(); j++) {
//                    route.add(routeArray.getString(j));
//                }
//
//                // Create Bus object and add to list
//                busList.add(new Bus(name, route, fare));
//            }
//
//        } catch (Exception e) {
//            System.out.println("❌ Failed to load buses: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//        return busList;
//    }
//}
//
