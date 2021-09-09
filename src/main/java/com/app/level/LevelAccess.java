
package com.app.level;

import com.app.entity.Level;
import com.app.gui.admin.AdminView;
import com.app.gui.user.UserView;
import javafx.scene.layout.Pane;


public enum LevelAccess {
    ADMIN(1, "admin", new AdminView()),
    EMPLOYEE(2, "user", new UserView());
    
    private final int id;
    private final String name;
    private final Pane layoutPane;
    
    private LevelAccess(int id, String name, Pane layoutPane) {
        this.id = id;
        this.name = name;
        this.layoutPane = layoutPane;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public static Pane getLayout(Level level) {

        LevelAccess[] levelsAccess = LevelAccess.values();
        for (LevelAccess levelAccess : levelsAccess) {
            if (levelAccess.id == level.getId()) {
                return levelAccess.layoutPane;
            }
        }
        return new UserView();
    }
}
