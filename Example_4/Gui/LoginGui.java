package spring_boot.spring_boot.Jdbc.Example_4.Gui;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class LoginGui extends VerticalLayout {

    private LoginOverlay login;
    private LoginForm loginForm;


    public LoginGui()
    {
        login = new LoginOverlay();
        login.setDescription("Login");
        login.setTitle("Exercise");
        login.setForgotPasswordButtonVisible(true);
        login.setOpened(true);
        login.setVisible(true);
        login.setEnabled(true);

        loginForm = new LoginForm();



        add(login,loginForm);
    }
}
