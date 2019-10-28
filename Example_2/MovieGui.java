package lukasz.nowogorski.SpringBoot.DATABASE_JDBC_3;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MovieGui {

    private TextField textFieldId;
    private TextField textFieldName;
    private TextField textFieldYear;
    private TextField textFieldLenght;
    private TextField textFieldGrade;
    private TextField textFieldDescription;

    private Button save;
    private Button read;

    private MovieDao dao;

    @Autowired
    public MovieGui(MovieDao dao)
    {
        textFieldId = new TextField("Id");
        textFieldName = new TextField("Name");
        textFieldYear = new TextField("Year");
        textFieldLenght = new TextField("Length");
        textFieldGrade = new TextField("Grade");
        textFieldDescription = new TextField("Description");

        Label label = new Label();

        save.addClickListener(event -> {
                    Movie movie = new Movie();
                    movie.setId(Long.parseLong(textFieldId.getValue()));
                    movie.setName(textFieldName.getValue());
                    movie.setYear(Integer.parseInt(textFieldYear.getValue()));
                    movie.setLenght(Integer.parseInt(textFieldLenght.getValue()));
                    movie.setGrade(Integer.parseInt(textFieldGrade.getValue()));
                    movie.setDescription(textFieldDescription.getValue());

                    dao.save(movie);

                    Notification.show("Movie add", 4000, Notification.Position.TOP_CENTER);
                });


            read.addClickListener(e->
            {
                Movie movie = dao.read(Long.parseLong(textFieldId.getValue()) );
                label.setText(movie.toString());
            });



    }



}
