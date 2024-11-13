package SerializatinAndDesirialization;

import com.google.gson.Gson;

public class ObjectToJson {
    public static void main(String[] args) {
        Employee emp = new Employee(2, "Goutham", "Banglore");

        Gson gson = new Gson();
        String json = gson.toJson(emp);
        System.out.println("Serializtion data :" + json);

        Employee deserializedEmployee = gson.fromJson(json, Employee.class);
        System.out.println("Deserialized Employee:");
        System.out.println("ID: " + deserializedEmployee.getId());
        System.out.println("Name: " + deserializedEmployee.getName());
        System.out.println("Address: " + deserializedEmployee.getAddress());
    }
}
