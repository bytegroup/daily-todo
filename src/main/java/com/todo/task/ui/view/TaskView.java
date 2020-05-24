package com.todo.task.ui.view;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaskView extends HorizontalLayout {
    private static final Logger logger= LogManager.getLogger(TaskView.class);

    public TaskView(){
        setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        addClassName("task-view");
        setSpacing(false);
        setWidthFull();

        add();
    }
}
