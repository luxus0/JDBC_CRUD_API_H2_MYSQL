package lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Gui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Entity.Food;
import spring_boot.spring_boot.Jdbc.Example_1.Repo.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class FoodGui extends FormLayout
{

@Autowired
    private FoodRepo repo;
    private Food food;

    private Text mainText;

    private Button saveDatabaseButton;
    private Button deleteDatabaseButton;
    private Button showNamesButton;

    private TextField textFieldId;
    private TextField textFieldname;
    private TextField textFieldColor;
    private TextField textFieldWages;
    private TextField textFieldCountry;
    private TextField textFieldQuality;
    private TextField textFieldQuantity;
    private TextField  textFieldPrice;
    private TextArea  area;

    public FoodGui()
    {

        mainText = new Text("DATABASE FOOD");


        textFieldId = new TextField("ID");
        textFieldId.setMaxWidth("130px");
        textFieldId.getStyle().set("padding-right","30px");
        textFieldId.setPlaceholder("id");

        textFieldname = new TextField("Name");
        textFieldname.setMaxWidth("130px");
        textFieldname.getStyle().set("padding-right","30px");
        textFieldname.setPlaceholder("Name");

        textFieldColor = new TextField("Color");
        textFieldColor.setMaxWidth("130px");
        textFieldColor.getStyle().set("padding-right","30px");
        textFieldColor.setPlaceholder("Color");

        textFieldWages = new TextField("Wages");
        textFieldWages.setMaxWidth("130px");
        textFieldWages.getStyle().set("padding-right","30px");
        textFieldWages.setPlaceholder("Wages");

        textFieldCountry = new TextField("Country");
        textFieldCountry.setMaxWidth("130px");
        textFieldCountry.getStyle().set("padding-right","30px");
        textFieldCountry.setPlaceholder("Country");


        textFieldQuality = new TextField("Quality");
        textFieldQuality.setMaxWidth("130px");
        textFieldQuality.getStyle().set("padding-right","30px");
        textFieldQuality.setPlaceholder("Quality");

        textFieldQuantity = new TextField("Quantity");
        textFieldQuantity.setMaxWidth("130px");
        textFieldQuality.getStyle().set("padding-right","30px");
        textFieldQuantity.setPlaceholder("Quantity");

        textFieldPrice = new TextField("Price");
        textFieldPrice.setMaxWidth("130px");
        textFieldPrice.getStyle().set("padding-right","30px");
        textFieldPrice.setPlaceholder("Price");




        saveDatabaseButton = new Button("ADD");
        saveDatabaseButton.setMaxWidth("160px");
        saveDatabaseButton.getStyle().set("padding-right","20px").set("color-background","green").
                                        set("font-size","12");


        deleteDatabaseButton = new Button("DELETE");
        deleteDatabaseButton.setMaxWidth("160px");
        deleteDatabaseButton.getStyle().set("padding-right","20px").
                set("color-background","green").set("font-size","12");

        showNamesButton = new Button("Filter by Names");
        showNamesButton.setMaxWidth("160px");
        showNamesButton.getStyle().set("padding-right","20px")
                .set("color-background","green").
                set("font-size","12");

        saveDatabaseButton.addClickListener(event ->
        {
            saveDatabaseGui();
        });



        deleteDatabaseButton.addClickListener(e ->
                {
                        deletetDatabaseGui();
                });

        showNamesButton.addClickListener(e ->
        {

        });





        addComponentAtIndex(0,textFieldId);
        addComponentAtIndex(1,textFieldname);
        addComponentAtIndex(2,textFieldColor);
        addComponentAtIndex(3,textFieldWages);
        addComponentAtIndex(4,textFieldCountry);
        addComponentAtIndex(5,textFieldQuality);
        addComponentAtIndex(6,textFieldQuantity);
        addComponentAtIndex(7,textFieldPrice);
        addComponentAtIndex(8,saveDatabaseButton);
        addComponentAtIndex(9,deleteDatabaseButton);
        addComponentAtIndex(10,showNamesButton);
        addComponentAtIndex(11,mainText);

    }


public void saveDatabaseGui()
{
    food = new Food(Long.parseLong(textFieldId.getValue()),
            textFieldname.getValue(),
            textFieldColor.getValue(),
            Integer.parseInt(textFieldWages.getValue()),
            textFieldCountry.getValue(),
            textFieldQuality.getValue(),
            textFieldQuantity.getValue(),
            Integer.parseInt(textFieldPrice.getValue()));

    repo.save(food);

    Notification.show("SAVE DATABASE FOOD",4000, Notification.Position.TOP_CENTER);

}

public void deletetDatabaseGui()
{
    repo.deleteAll();
    if(repo.findAll().isEmpty())
    {
        Notification.show("Database is empty");
    }
}



}
