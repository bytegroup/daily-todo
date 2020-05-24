package com.todo.utils;

import com.todo.conf.SecurityUtils;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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

        Anchor logInOut=null;
        if (SecurityUtils.isUserLoggedIn()){
            logInOut = new Anchor("logout", "Log out");
            headContainer.add(headerContent, logInOut);
        }else {
            headContainer.add(headerContent);
        }

        headerContent.add(logo);
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
}
