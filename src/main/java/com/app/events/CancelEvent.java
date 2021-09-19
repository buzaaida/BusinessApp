
package com.app.events;

import com.app.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class CancelEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Controller.instance().getStage().close();
    }
    
}
