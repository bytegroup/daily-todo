package com.todo.layout;

import com.todo.conf.SecurityUtils;
import com.todo.utils.ExposedViews;
import com.todo.utils.LayoutUtils;
import com.todo.utils.Utils;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;

@CssImport(value = "./styles/shared-styles.css", themeFor = "vaadin-app-layout")
public class HomeLayout extends AppLayout implements BeforeEnterObserver {

    public HomeLayout() {
        createHeader();
    }

    private void createHeader() {
        addToNavbar(LayoutUtils.getHeader());
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (!SecurityUtils.isUserLoggedIn()){
            event.rerouteTo(Utils.getRelativePath(ExposedViews.LOGIN.getUri()));
        }
    }
}
