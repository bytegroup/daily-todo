package com.todo.utils;

import com.todo.auth.RegistrationView;
import com.todo.conf.SecurityUtils;
import com.todo.task.ui.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.shared.Registration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LayoutUtils {

    private static final Logger logger= LogManager.getLogger(Utils.class);
    private LayoutUtils(){}

    public static HorizontalLayout getHeader(){
        Div headContainer= new Div();
        headContainer.setClassName("header-container");
        Div headerContent= new Div();
        headerContent.setClassName("header-content");

        Span logo = new Span("Todo - The Daily Tasks");
        logo.setSizeFull();
        logo.addClassName("logo");
        logo.addClassName("centered-content");
        headerContent.add(logo);

        if (SecurityUtils.isUserLoggedIn()){
            headContainer.add(headerContent, new ProfileMenuBar(SecurityUtils.getLoggedUserName()));
            //headContainer.add(headerContent, profileMenuBar(SecurityUtils.getLoggedUserName()));

        }else {
            headContainer.add(headerContent);
        }

        HorizontalLayout header = new HorizontalLayout(headContainer);
        header.expand(headContainer);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassName("header");

        return header;
    }

    public static HorizontalLayout getHomeHeader(){
        Div headContainer= new Div();
        headContainer.setClassName("header-container");
        Div headerContent= new Div();
        headerContent.setClassName("header-content");

        Span logo = new Span("Todo - The Daily Tasks");
        logo.setSizeFull();
        logo.addClassName("logo");
        logo.addClassName("centered-content");
        headerContent.add(logo);

        MenuBar profileMenuBar= profileMenuBar(SecurityUtils.getLoggedUserName());
        headContainer.add(headerContent, profileMenuBar);
        HorizontalLayout header = new HorizontalLayout(headContainer);
        header.expand(headContainer);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassName("header");

        return header;
    }

    public static Div getBodyContainer(){
        Div body= new Div();
        body.setClassName("body-container");
        return body;
    }

    public static Div getBodyContainer(Component component){
        Div body= new Div(component);
        body.setClassName("body-container");
        return body;
    }

    public static MenuBar profileMenuBar(String profileName){
        MenuBar menuBar = new MenuBar();
        menuBar.addClassName("profile-menu-bar");

        menuBar.setOpenOnHover(true);

        MenuItem profileMenu = menuBar.addItem("Profile :-: "+profileName);
        profileMenu.getElement().getStyle().set("font-size", "var(--lumo-font-size-s)");
        //profileMenu.getElement().getParent().setProperty("style", "background:none");

        SubMenu profileSubMenu = profileMenu.getSubMenu();
        MenuItem userProfile = profileSubMenu.addItem(new RouterLink("Profile", RegistrationView.class));
        userProfile.getElement().getStyle().set("font-size", "var(--lumo-font-size-s)");
        /*userProfile.addClickListener(e ->
                userProfile.getUI().ifPresent(ui ->
                        ui.navigate(Utils.getRelativePath(ExposedViews.REGISTRATION.getUri()))));*/
        MenuItem logOut = profileSubMenu.addItem("Log Out");
        logOut.getElement().getStyle().set("font-size", "var(--lumo-font-size-s)");
        logOut.addClickListener(e ->
                logOut.getUI().ifPresent(ui ->
                        ui.navigate(Utils.getRelativePath(ExposedViews.LOGOUT.getUri()))));

        return menuBar;
    }
}
