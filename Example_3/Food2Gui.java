package lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD_2;


import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Route
public class Food2Gui extends FormLayout
{

    @Autowired
    private Food2Repo repo;
    private Food2 food;
    private Food2Dao dao;

    private Text mainText;

    private Button saveDatabaseButton;
    private Button deleteDatabaseButton;

    private Button showIdButton;
    private Button showNamesButton;
    private Button showColorButton;
    private Button showWagesButton;
    private Button showCountryButton;
    private Button showQualityButton;
    private Button showQuantityButton;
    private Button showPriceButton;


    private TextField textFieldId;
    private TextField textFieldname;
    private TextField textFieldColor;
    private TextField textFieldWages;
    private TextField textFieldCountry;
    private TextField textFieldQuality;
    private TextField textFieldQuantity;
    private TextField  textFieldPrice;
    private TextArea  area;


    public Food2Gui(Food2Dao dao)
    {
        this.dao = dao;


        mainText = new Text("DATABASE FOOD");

        textFieldId = new TextField("ID");
        textFieldId.setMaxWidth("130px");
        textFieldId.getStyle().set("padding-right","30px").set("padding-left","30px");
        textFieldId.setPlaceholder("Name");

        textFieldname = new TextField("Name");
        textFieldname.setMaxWidth("130px");
        textFieldname.getStyle().set("padding-right","30px").set("padding-left","30px");
        textFieldname.setPlaceholder("Name");

        textFieldColor = new TextField("Color");
        textFieldColor.setMaxWidth("130px");
        textFieldColor.getStyle().set("padding-right","30px").set("padding-left","30px");
        textFieldColor.setPlaceholder("Color");

        textFieldWages = new TextField("Wages");
        textFieldWages.setMaxWidth("130px");
        textFieldWages.getStyle().set("padding-right","30px").set("padding-left","30px");
        textFieldWages.setPlaceholder("Wages");

        textFieldCountry = new TextField("Country");
        textFieldCountry.setMaxWidth("130px");
        textFieldCountry.getStyle().set("padding-right","30px").set("padding-left","30px");
        textFieldCountry.setPlaceholder("Country");


        textFieldQuality = new TextField("Quality");
        textFieldQuality.setMaxWidth("130px");
        textFieldQuality.getStyle().set("padding-right","30px").set("padding-left","30px");
        textFieldQuality.setPlaceholder("Quality");

        textFieldQuantity = new TextField("Quantity");
        textFieldQuantity.setMaxWidth("130px");
        textFieldQuality.getStyle().set("padding-right","30px").set("padding-left","30px");
        textFieldQuantity.setPlaceholder("Quantity");

        textFieldPrice = new TextField("Price");
        textFieldPrice.setMaxWidth("130px");
        textFieldPrice.getStyle().set("padding-right","30px").set("padding-left","30px");
        textFieldPrice.setPlaceholder("Price");




        saveDatabaseButton = new Button("ADD");
        saveDatabaseButton.setMaxWidth("160px");
        saveDatabaseButton.getStyle().set("padding-right","20px").set("padding-left","30px").set("color-background","green").
                set("font-size","12");


        deleteDatabaseButton = new Button("DELETE");
        deleteDatabaseButton.setMaxWidth("160px");
        deleteDatabaseButton.getStyle().set("padding-right","20px").set("padding-left","30px").
                set("color-background","green").set("font-size","12");


        showIdButton = new Button("Filter by Id");
        showIdButton.setMaxWidth("160px");
        showIdButton.getStyle().set("padding-right","20px").set("padding-left","30px")
                .set("color-background","green").
                set("font-size","12");



        showNamesButton = new Button("Filter by Names");
        showNamesButton.setMaxWidth("160px");
        showNamesButton.getStyle().set("padding-right","20px").set("padding-left","30px")
                .set("color-background","green").
                set("font-size","12");

        showColorButton = new Button("Filter by Color");
        showColorButton.setMaxWidth("160px");
        showColorButton.getStyle().set("padding-right","20px").set("padding-left","30px")
                .set("color-background","green").
                set("font-size","12");


        showWagesButton = new Button("Filter by Wages");
        showWagesButton.setMaxWidth("160px");
        showWagesButton.getStyle().set("padding-right","20px").set("padding-left","30px")
                .set("color-background","green").
                set("font-size","12");

        showCountryButton = new Button("Filter by Country");
        showCountryButton.setMaxWidth("160px");
        showCountryButton.getStyle().set("padding-right","20px").set("padding-left","30px")
                .set("color-background","green").
                set("font-size","12");

        showQualityButton = new Button("Filter by Quality");
        showQualityButton.setMaxWidth("160px");
        showQualityButton.getStyle().set("padding-right","20px").set("padding-left","30px")
                .set("color-background","green").
                set("font-size","12");

        showQuantityButton = new Button("Filter by Quantity");
        showQuantityButton.setMaxWidth("160px");
        showQuantityButton.getStyle().set("padding-right","20px").set("padding-left","30px")
                .set("color-background","green").
                set("font-size","12");

        showPriceButton = new Button("Filter by Price");
        showPriceButton.setMaxWidth("160px");
        showPriceButton.getStyle().set("padding-right","20px").set("padding-left","30px")
                .set("color-background","green").
                set("font-size","12");


//ACTION
        saveDatabaseButton.addClickListener(event ->
        {
            saveDatabaseGui();
        });



        deleteDatabaseButton.addClickListener(e ->
        {
            deletetDatabaseGui();
        });

        showIdButton.addClickListener(e ->
        {
            List<Map<String,Object>> map = this.dao.showById(Long.parseLong(textFieldId.getValue() ));
            area.setValue(map.toString());
        });


        showNamesButton.addClickListener(e ->
        {
            List<Map<String,Object>> map = this.dao.showByName(textFieldname.getValue());
            area.setValue(map.toString());
        });

        showColorButton.addClickListener(e ->
        {
            List<Map<String,Object>> map = this.dao.showByColor(textFieldColor.getValue());
            area.setValue(map.toString());
        });

        showWagesButton.addClickListener(e ->
        {
            List<Map<String,Object>> map = this.dao.showByWages(Integer.parseInt(textFieldWages.getValue()) );
            area.setValue(map.toString());
        });

        showCountryButton.addClickListener(e ->
        {
            List<Map<String,Object>> map = this.dao.showByCountry(textFieldCountry.getValue());
            area.setValue(map.toString());
        });

        showQualityButton.addClickListener(e ->
        {
            List<Map<String,Object>> map = this.dao.showByQuality(textFieldQuality.getValue());
            area.setValue(map.toString());
        });

        showQuantityButton.addClickListener(e ->
        {
            List<Map<String,Object>> map = this.dao.showByQuantity(textFieldQuantity.getValue());
            area.setValue(map.toString());
        });

        showPriceButton.addClickListener(e ->
        {
            List<Map<String,Object>> map = this.dao.showByPrice(Integer.parseInt(textFieldPrice.getValue()) );
            area.setValue(map.toString());
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
        addComponentAtIndex(11,showColorButton);
        addComponentAtIndex(12,showWagesButton);
        addComponentAtIndex(13,showCountryButton);
        addComponentAtIndex(14,showQualityButton);
        addComponentAtIndex(15,showQuantityButton);
        addComponentAtIndex(16,showPriceButton);

    }


    public void saveDatabaseGui()
    {
        food = new Food2(
                Long.parseLong(textFieldId.getValue()),
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
