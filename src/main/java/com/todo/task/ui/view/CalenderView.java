package com.todo.task.ui.view;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalenderView extends HorizontalLayout {
    private static final Logger logger= LogManager.getLogger(CalenderView.class);

    public CalenderView(){
        setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        addClassName("calender-view");
        setSpacing(false);
        setWidthFull();

        add();
    }
}
