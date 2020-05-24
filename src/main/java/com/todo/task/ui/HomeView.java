package com.todo.task.ui;

import com.todo.conf.SecurityUtils;
import com.todo.layout.HomeLayout;
import com.todo.task.ui.view.CalenderView;
import com.todo.task.ui.view.TaskListView;
import com.todo.task.ui.view.TaskView;
import com.todo.utils.ExposedViews;
import com.todo.utils.LayoutUtils;
import com.todo.utils.ProfileMenuBar;
import com.todo.utils.Utils;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.shared.communication.PushMode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@PageTitle("TaskBoard | Todo")
@Route(value = "", layout = HomeLayout.class)
public class HomeView extends VerticalLayout implements BeforeEnterObserver{
    private static final Logger logger= LogManager.getLogger(HomeView.class);

    public HomeView(){
        addClassName("taskboard-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        String loggedUser=SecurityUtils.getLoggedUserName();
        logger.debug("loggedUser= "+loggedUser);

        HorizontalLayout layout= new HorizontalLayout();
        layout.add(new CalenderView(),new TaskListView(),new TaskView());

        add(LayoutUtils.getBodyContainer(layout));
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (!SecurityUtils.isUserLoggedIn()){
            event.rerouteTo(Utils.getRelativePath(ExposedViews.LOGIN.getUri()));
        }
    }
}
