package com.todo.task.ui;

import com.todo.auth.RegistrationForm;
import com.todo.layout.HomeLayout;
import com.todo.task.ui.view.CalenderView;
import com.todo.task.ui.view.TaskListView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@PageTitle("TaskBoard | Todo")
@Route(value = "", layout = HomeLayout.class)
public class HomeView extends VerticalLayout {
    private static final Logger logger= LogManager.getLogger(HomeView.class);

    public HomeView(){
        addClassName("taskboard-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(
                new CalenderView(),
                new TaskListView(),
                new RegistrationForm(null)
        );
    }


}
