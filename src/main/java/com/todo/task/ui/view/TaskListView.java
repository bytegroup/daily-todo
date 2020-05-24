package com.todo.task.ui.view;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaskListView extends HorizontalLayout {
    private static final Logger logger= LogManager.getLogger(TaskListView.class);

    public TaskListView(){
        setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        addClassName("form-btn-row");
        setSpacing(false);
        setWidthFull();

        add();
    }
}
