//package repository;
//
//import model.HasID;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//public class InFileRepository<T extends HasID> implements IRepository<T> {
//    private final String filePath;
//
//    public InFileRepository(String filePath) {
//        this.filePath = filePath;
//    }
//
//    @Override
//    public void create(T obj) {
//        List<T> data = readDataFromFile();  // Fetch existing data from file
//        data.add(obj);  // Add the new object
//        writeDataToFile(data);  // Write the updated data back to the file
//    }
//
//    @Override
//    public List<T> readAll() {
//        return List.of();
//    }
//
//    @Override
//    public void delete(Integer id) {
//        List<T> data = readDataFromFile();
//        data.removeIf(item -> item.getId().equals(id));  // Remove the object with the given ID
//        writeDataToFile(data);  // Write the updated data back to the file
//    }
//
//    @Override
//    public T get(Integer id) {
//        return null;
//    }
//
//    @Override
//    public Set<Integer> getKeys() {
//        return Set.of();
//    }
//
//    @Override
//    public void update(T obj) {
//        List<T> data = readDataFromFile();
//        for (int i = 0; i < data.size(); i++) {
//            if (data.get(i).getId().equals(obj.getId())) {
//                data.set(i, obj);  // Update the object
//                break;
//            }
//        }
//        writeDataToFile(data);  // Write the updated data back to the file
//    }
//
//    private void writeDataToFile(List<T> data) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//            for (T item : data) {
//                writer.write(serialize(item));  // Convert the object to a string and write it to the file
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private List<T> readDataFromFile() {
//        List<T> data = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                T obj = deserialize(line);  // Convert the string back to an object
//                data.add(obj);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return data;
//    }
//
//    //toCsv
//    private String serialize(T obj) {
//        // Implement the serialization logic for each model (Store, Customer, Order, etc.)
//        return obj.serialize();  // Simplified for this example, modify according to your model
//    }
//
//    //fromCsv
//    private T deserialize(String line) {
//        // Implement the deserialization logic for each model
//        return null;  // Simplified for this example, modify according to your model
//    }
//}