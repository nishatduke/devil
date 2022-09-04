package com.example.devil;
import javafx.scene.control.Button;

public class Feature extends HelloApplication{
    private String name;

    public Feature(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }
    private void activateFeature(String featureName){
        if(featureName.equals("Freeze")){
            Freeze = true;
        }
    }

    public void displayFeature(int X, int Y) {
        Button button = new Button(this.name);
        button.setTranslateX(X);
        button.setTranslateY(Y);
        button.setPrefSize(140, 45);
//            button.fontProperty(Font.font(30));
        root.getChildren().add(button);

//            button.setOnMouseClicked(e -> specialEvent1(button.getText()));
        button.setOnMouseClicked(e -> activateFeature(this.name));
    }
}


