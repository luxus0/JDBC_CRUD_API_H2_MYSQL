package spring_boot.spring_boot.Jdbc.Example_1.Service;

import lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Entity.Food;
import spring_boot.spring_boot.Jdbc.Example_1.Repo.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.util.Scanner;


@Service
public class FoodService {

    @Autowired
    private FoodRepo repo;

    @EventListener(ApplicationReadyEvent.class)
    public void saveDatabase() {
        Scanner scan = new Scanner(System.in);
        System.out.println("---FOOD DATABASE----");
        System.out.println("Ile wierszy?");
        int number = scan.nextInt();

        for (int i = 0; i < number; i++) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Name");
            String Name = sc.nextLine();

            System.out.println("Color");
            String color = sc.nextLine();


            System.out.println("Wages");
            int wages = sc.nextInt();

            System.out.println("Country");
            String country = sc.nextLine();


            System.out.println("Quality");
            String quality = sc.nextLine();

            System.out.println("Quantity");
            String quantity = sc.nextLine();


            System.out.println("Price");
            int price = sc.nextInt();



            System.out.println("----------------------------------\n");

            Food food = new Food(i,Name,color,wages,country,quality,quantity,price);
            repo.save(food);


        }
    }

}