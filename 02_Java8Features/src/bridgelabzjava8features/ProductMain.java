package bridgelabzjava8features;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductMain {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product(11, 150, 120.0));
        list.add(new Product(12, 15, 320.0));
        list.add(new Product(13, 156, 240.0));
        list.add(new Product(14, 155, 250.0));
        list.add(new Product(15, 105, 420.0));
        list.add(new Product(16, 115, 20.0));
        list.add(new Product(17, 1855, 720.0));
        list.add(new Product(18, 145, 10.0));
        list.add(new Product(19, 165, 1120.0));
        list.add(new Product(20, 175, 2095.0));

        sales(list);

    }

    public static void sales(List<Product> products) {

        //Filter sales where quantity > 10
        List<Product> quntity = products.stream().filter(sales -> sales.getPrice() > 50).collect(Collectors.toList());
        for(Product sales:quntity){
            System.out.println(sales);
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        //Transform into ProductSales objects with productId and totalRevenue

        Map<Integer, Double> totalRevenue = quntity.stream().collect(Collectors.groupingBy(Product::getProductId,
                Collectors.summingDouble(sale -> sale.getPrice() * sale.getQuantity())));
         System.out.println(totalRevenue);

         for (Map.Entry<Integer,Double> entry:totalRevenue.entrySet()){
             Integer key = entry.getKey();
             Double value = entry.getValue();
             System.out.println("Id : "+key + ", TatalRevenue : "+value);
         }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

         // Sort by totalRevenue in descending order and get top 5
        List<Map.Entry<Integer, Double>> topProducts = totalRevenue.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Top 5 Products by Revenue:");
        topProducts.forEach(entry ->
                System.out.println("Product Id: " + entry.getKey() + ", Total Revenue: " + entry.getValue())
        );


    }

}
