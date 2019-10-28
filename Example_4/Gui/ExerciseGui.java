package spring_boot.spring_boot.Jdbc.Example_4.Gui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.router.Route;


@Route("exercisegui")
public class ExerciseGui extends FormLayout
{
    private Image image;
    private Image image2;
    private Image image3;

    private Button buttonContinue;
    private Button buttonGetFit;
    private Button buttonGetStrong;
    private Button buttonGetWeight;


    private Text textInfo;
    private Text textLogin;
    private Text textGoal;

    private Icon iconMen;

    private Anchor linkLogin;

    public ExerciseGui()
    {
        HorizontalLayout horizontal = new HorizontalLayout();
        VerticalLayout vertical = new VerticalLayout();

        iconMen = new Icon();

        buttonContinue = new Button("CONTINUE");
        buttonContinue.setWidth("60px");
        buttonContinue.setHeight("60px");


        image = new Image("https://as1.ftcdn.net/jpg/00/24/93/92/500_F_24939237_WciKO8yADEG1KeU7b1inynZT8zueERdb.jpg","");
        image.setHeight("50px");
        image.setWidth("50px");

        image2 = new Image("https://previews.123rf.com/images/blankstock/blankstock1605/blankstock160502514/56305490-dumbbell-sign-icon-fitness-symbol-orange-circle-button-with-icon-vector.jpg","");
        image2.setHeight("50px");
        image2.setWidth("50px");

        image3 = new Image("https://thumbs.dreamstime.com/z/icon-button-pictogram-exercise-fitness-icon-button-pictogram-exercise-fitness-symbol-116271566.jpg","");
        image3.setHeight("50px");
        image3.setWidth("50px");


     buttonGetFit = new Button("Get Fit",image);
     buttonGetFit.setWidth("70px");
     buttonGetFit.setHeight("70px");


        buttonGetStrong = new Button("Get Strong",image2);
        buttonGetStrong.setWidth("70px");
        buttonGetStrong.setHeight("70px");

        buttonGetWeight = new Button("Lose Weight",image3);
        buttonGetWeight.setWidth("70px");
        buttonGetWeight.setHeight("70px");

        textInfo = new Text("Hey! Let's make you a workout Plan :)");
        textLogin = new Text("Have an account?");
        textGoal = new Text("What's your goal?");

        //otwiera link
        linkLogin = new Anchor("http://localhost:8090/logingui","Login");

        addComponentAtIndex(0,iconMen);
        addComponentAtIndex(1,textInfo);
        addComponentAtIndex(2,textGoal);
        addComponentAtIndex(3,buttonGetFit);
        addComponentAtIndex(4,buttonGetStrong);
        addComponentAtIndex(5,buttonGetWeight);
        addComponentAtIndex(6,textLogin);
        addComponentAtIndex(7,linkLogin);
        addComponentAtIndex(8,buttonContinue);


        add(iconMen,textInfo,textGoal,buttonGetFit,buttonGetStrong,buttonGetWeight,buttonContinue,textLogin,linkLogin);

    }



}
