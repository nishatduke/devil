package com.example.devil;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.image.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.scene.layout.StackPane;

//

public class HelloApplication extends Application {
    public Group root = new Group();

    Button enter = new Button("");

    Image intro = new Image("/Title_Page.png");
    ImageView introView = new ImageView(intro);
    ArrayList<Image> Images = new ArrayList<Image>();
    Image image_block1 = new Image("/1 Block.png");
    Image image_block2 = new Image("/2 Blocks.png");
    Text block_coins1 = new Text();
    Text block_coins2=new Text();
    Text block_coins3= new Text();
    Text block_coins4= new Text();
    Text block_coins5= new Text();

    public int level = 1;
    public boolean reset =false;


    public int chainSize = 0;
    public int d_counter = 0;
    public ArrayList<String> lines = new ArrayList<String>();

    public int numCoins = 0;

    Text coins = new Text();

    Button nextButton = new Button();
    Image textbox = new Image("/Textbox2.png");

    ImageView textBoxView = new ImageView(textbox);
    Image textBoxSatan = new Image("/Satan_Text_Box.png");

    ImageView textBoxSatanView = new ImageView(textBoxSatan);

    Text text = new Text();

    //coin pouch and blockchain here
    Image blockChain = new Image("/no_blocks.png");
    ImageView blockChainView = new ImageView(blockChain);


//    Image featureBox = new Image("");
//    ImageView featureBoxView = new ImageView(featureBox);

    Image happySatan = new Image("/happy_satan.png");
    ImageView defaultSatan = new ImageView(happySatan);
    Button purchaseButton = new Button();

    Image featureBox = new Image("/Placeholder Square.png");
    ImageView featureBoxView = new ImageView(featureBox);


    ImageView newChainView;
    public int d2_counter=0;
    ArrayList<String> lines2 = new ArrayList<String>();

    public boolean Freeze = false;


    public class Shop {
        private String name;
        private ArrayList<Item> Items;
        private String url;

        public Shop(String name, String url, ArrayList<Item> Items) {
            this.name = name;
            this.Items = Items;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String newName) {
            name = newName;
        }

        public ArrayList<Item> getItems() {
            return Items;
        }

        public void setItems(ArrayList<Item> newItems) {
            Items = newItems;
        }

        public void displayShop(int X, int Y, int Height, int Width) {
            Image shopImage = new Image(this.url);
            ImageView imageView = new ImageView(shopImage);
            imageView.setFitHeight(Height);
            imageView.setFitWidth(Width);
            Button button = new Button();
            button.setTranslateX(X);
            button.setTranslateY(Y);
            button.setPrefSize(Width, Height);
            button.setGraphic(imageView);
            button.setStyle("-fx-background-color: #631D23");
            root.getChildren().addAll(imageView, button);
            button.setOnMouseClicked(e -> listItems(this.Items, 530, Y));
        }

    }

    public class Item {
        private String name;
        private int price;

        public Item(String name, int price) {
            this.name = name;
            this.price = price;

        }

        public String getName() {
            return name;
        }

        public void setName(String newName) {
            name = newName;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int newPrice) {
            price = newPrice;
        }

        public void displayItem(int X, int Y) {
            Button button = new Button(this.name + " $" + this.price);
            button.setTranslateX(X);
            button.setTranslateY(Y);
            button.setPrefSize(140, 45);
//            button.fontProperty(Font.font(30));
            root.getChildren().add(button);

           //button.setOnMouseClicked(e -> specialEvent1());
            button.setOnMouseClicked(e -> updateChain(this.name,this.price));
        }

    }

    public class Feature{
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


    public ArrayList<Item> Clothes = new ArrayList<Item>();
    //    Button shoes_button = new Button();
    Item shoes = new Item("Awfully Red Shoes", 5);
    Item dress = new Item("Demonic Dress", 17);
    Item hat = new Item("Fool's Hat", 8);

    public ArrayList<Item> Foods = new ArrayList<Item>();
    Item apple = new Item("Poison Apple",3);
    Item juice = new Item("Skull Juice",4);
    Item banana = new Item("Rotten Banana",2);

    public ArrayList<Item> Habits = new ArrayList<Item>();
    Item book = new Item("Suspicious Book",5);
    Item vhs = new Item("Cursed VHS",10);
    Item dvd = new Item("Lost DVD",7);

    public ArrayList<Item> Pets = new ArrayList<Item>();
    Item pet1 = new Item("Cerberus",25);
    Item pet2 = new Item("Hydra",10);
    Item pet3 = new Item("Hammie Boi",27);

        int d3_counter=0;
        ArrayList<String> lines3 = new ArrayList<String>();
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        lines.add("Welcome to hell.");
        lines.add("You’re probably thinking, ‘Why the hell am I in hell?’. ");
        lines.add("Well, my records say you have plundered several ships in your time.");
        lines.add("Of course, you need to labor to atone for your sins.");
        lines.add("… Basically, I need you to run me some errands.");
        lines.add("Understood? Too bad if not. Anyways, let’s start your first task.");
        lines.add("I need you to pick up a dress I ordered for a party.");
        lines.add("Here, I’ll give you 20 coins. ");
        lines.add("The dress wasn’t that expensive, so you better bring back some change.");
        lines.add("Well, what are you looking at? Go get me my dress!");
//        lines2.add("");//last minute filler
        lines2.add("");
        lines2.add("That was quick, good job!");
        lines2.add("");
        lines2.add("Where’s my change? What? You don’t have any?");
        lines2.add("");
        lines2.add("You don’t take me to be a fool, don’t you? How should I punish you?");
        lines2.add("");
        lines2.add("… Actually, I think I know what might have happened.");
        lines2.add("");
        lines2.add("Oh, it was probably one of those angel hackers.");
        lines2.add("");
        lines2.add("Try again, but freeze the block this time.");
        lines2.add("");
       // lines2.add(""); // last minute filler
        lines3.add("");
        lines3.add("");

        lines3.add("Ok, great work! Let's move to the next phase.");
        lines3.add("");


        lines3.add("You're going to buy a Hydra for me from the pet shop.");
        lines3.add("");


        lines3.add("But, you'll first need to get its favorite food: Skull Juice.");
        lines3.add("");


        lines3.add("To do that, you just need to add the 'Copy' feature");
        lines3.add("");

        lines3.add("so every shop owner will know what purchases you've already made.");
        lines3.add("");


        lines3.add("...");
        lines3.add("");

        lines3.add("What do you mean there's no Copy Button???");
        lines3.add("");

        lines3.add(".....");
        lines3.add("");

        lines3.add("I don't have time for these excuses. Just get out.");
        lines3.add("");





        Images.add(image_block1);
        Images.add(image_block2);
        newChainView = new ImageView(Images.get(chainSize));
        block_coins1.setX(50);
        block_coins1.setY(240);
        block_coins1.setFont(Font.font(12));
        block_coins1.setWrappingWidth(145);
        block_coins2.setX(75);
        block_coins2.setY(260+84);
        block_coins2.setFont(Font.font(12));
        block_coins2.setWrappingWidth(145);


        //shops and items
        Clothes.add(shoes);
        Clothes.add(dress);
        Clothes.add(hat);
        Shop clothesShop = new Shop("clothes", "/Creepy_Clothing.png", Clothes);
        clothesShop.displayShop(743, 32, 200, 200);

        Foods.add(apple);
        Foods.add(juice);
        Foods.add(banana);
        Shop foodShop = new Shop("food","/Ghoulish_Groceries.png",Foods);
        foodShop.displayShop(975,32,200,200);

        Habits.add(book);
        Habits.add(vhs);
        Habits.add(dvd);
        Shop habitShop = new Shop("habit","/Hellish Habits.png",Habits);
        habitShop.displayShop(745,250,200,200);

        Pets.add(pet1);
        Pets.add(pet2);
        Pets.add(pet3);
        Shop petShop = new Shop("pets","/Perilous Pets.png",Pets);
        petShop.displayShop(975,250,200,200);

        //adding features
//        Image featureBox = new Image("/Placeholder Square.png");
//        ImageView featureBoxView = new ImageView(featureBox);
        featureBoxView.setX(250);
        featureBoxView.setY(45);
        featureBoxView.setFitHeight(395);
        featureBoxView.setFitWidth(200);
//        Feature freeze = new Feature("Freeze");
//        freeze.displayFeature(250,100);

        StackPane group = new StackPane();
//        Scene scene = new Scene(group, 320, 240);
        defaultSatan.setX(250);
        defaultSatan.setY(450);
        defaultSatan.setFitHeight(200);
        defaultSatan.setFitWidth(200);

        blockChainView.setX(20);
        blockChainView.setY(20);
        blockChainView.setFitHeight(637);
        blockChainView.setFitWidth(178);

        coins.setText(Integer.toString(numCoins) + " coins");
        coins.setFont(Font.font(30));
        coins.setX(60);
        coins.setY(90);
        //Image textbox = new Image("C:\\Users\\kynda\\JavaProjects\\PennApps23\\src\\main\\resources\\Images\\Textbox.png");
        //Setting the image view
        //ImageView textBoxView = new ImageView(textbox);
        //resizing textbox image
        textBoxView.setFitHeight(1500);
        textBoxView.setFitWidth(900);
        //Setting the position of the image
        textBoxView.setX(256);
        textBoxView.setY(470);
        textBoxView.setPreserveRatio(true);

        text.setText("Welcome to Hell.");
        text.setFont(Font.font(30));
//        ("teko", FontWeight.NORMAL, FontPosture.REGULAR), 20)
        text.setX(440);
        text.setY(580);
        text.setWrappingWidth(700);


        //Creating next button
        Image nextBtn = new Image("/Next_Button.png");
        ImageView nextBtnView = new ImageView(nextBtn);
        nextBtnView.setFitHeight(80);
        nextBtnView.setFitWidth(80);
        nextBtnView.setPreserveRatio(true);

        //Setting the location of the button
        nextButton.setTranslateX(1050);
        nextButton.setTranslateY(600);
        //Setting the size of the button
        nextButton.setPrefSize(80, 50);
        //Setting a graphic to the button
        nextButton.setGraphic(nextBtnView);
//        nextButton.setStyle("-fx-background-color: #bfa5a4;");
        // -fx-border-color: #b58482"
        // intro screen

        introView.setFitWidth(1200);
        introView.setFitHeight(700);

        Image introBtn = new Image("/Indulge_Button.png");
        ImageView introBtnView = new ImageView(introBtn);
//        introBtnView.setX(0);
//        introBtnView.setY(0);
        introBtnView.setFitWidth(180);
        introBtnView.setFitHeight(100);
        introBtnView.setPreserveRatio(true);

//        Button enter = new Button();
        enter.setTranslateX(900);
        enter.setTranslateY(600);
//        enter.setPrefSize(140,50);
        enter.setGraphic(introBtnView);
        enter.setStyle("-fx-background-color: #631D23");

        root.getChildren().addAll(introView, enter);
        enter.setOnMouseClicked(e -> gameRoot());
        //Creating a Group object for level 1/empty blockchain

//        private void gameRoot() {
//            root.getChildren().addAll(textBoxView, text, nextButton, defaultSatan, blockChainView, coins, featureBoxView);
//        }

//        freeze.displayFeature(280,100);

        Scene scene = new Scene(root, 1200, 700);
        Color background_red =  Color.web("0x631D23");
        scene.setFill(background_red);

        nextButton.setOnMouseClicked(e -> nextDialgoue());



       // if(level==2){
           // nextButton.setOnMouseClicked(e -> nextDialgoue());
      //  }
        // define price as item price
        purchaseButton.setOnMouseClicked(e -> updateCoins(shoes.price));

        stage.setTitle("Devil's Advocate");
        stage.setScene(scene);
//        stage.setFullScreen(true);
        stage.show();
    }

    private void gameRoot() {
        root.getChildren().removeAll(introView, enter);
        root.getChildren().addAll(textBoxView, text, nextButton, defaultSatan, blockChainView, coins, featureBoxView);
        Feature freeze = new Feature("Freeze");
        freeze.displayFeature(280,100);
    }

    private void nextDialgoue() {
        if(level==1) {
            if (d_counter >= lines.size() - 1) {
                System.out.println("Hi");
                nextButton.setVisible(false);
                textBoxView.setVisible(false);
                text.setVisible(false);
                defaultSatan.setVisible(false);
                //button.setManaged(true);
            } else {
                if(d_counter==7){
                    numCoins+=20;
                    root.getChildren().remove(coins);
                    coins.setText(numCoins+" coins");
                    root.getChildren().addAll(coins);
                }


                d_counter++;
                String current1 = lines.get(d_counter);
                text.setText(current1);
            }

        }

        if(level==2) {
//            root.getChildren().removeAll(newChainView,block_coins1,block_coins2);
            if (d2_counter >= lines2.size()-1) {
                nextButton.setVisible(false);
                textBoxView.setVisible(false);
                text.setVisible(false);
                defaultSatan.setVisible(false);
                reset=true;
                //button.setManaged(true);
            } else {
//                System.out.println("yelloo");
//                System.out.println(d2_counter);
                    if(d2_counter==3){
                        root.getChildren().removeAll(newChainView,block_coins1,block_coins2);
                        numCoins+=20;
                        root.getChildren().remove(coins);
                        coins.setText(numCoins+" coins");
                        root.getChildren().addAll(coins);
                    }
                d2_counter++;

                String current2 = lines2.get(d2_counter);
                text.setText(current2);
            }
        }


        if(level==3) {
            if(d3_counter>=lines3.size()-1){
                nextButton.setVisible(false);
                textBoxView.setVisible(false);
                text.setVisible(false);
                defaultSatan.setVisible(false);
                reset=true;
                Image img = new Image("/Ending.png");
                ImageView finale = new ImageView(img);
                finale.setFitWidth(1200);
                finale.setFitHeight(700);
                root.getChildren().add(finale);
            }
            else{
                d3_counter++;



                String current3 = lines3.get(d3_counter);
                text.setText(current3);
            }

        }





    }

    //blockchain functions call update coin and special event and make the images global
    private void updateChain(String name, int itemprice){
        newChainView = new ImageView(Images.get(chainSize));
        newChainView.setX(20);
        newChainView.setY(20);
        newChainView.setFitHeight(637);
        newChainView.setFitWidth(178);
        updateCoins(itemprice);
        root.getChildren().remove(coins);
        root.getChildren().addAll(newChainView, coins);

        System.out.println(Freeze);


        if(chainSize==0&&!reset){
            block_coins1.setText("You bought: "+name+"\n"+"You paid: "+itemprice);
            root.getChildren().add(block_coins1);
        }
        if(chainSize==1&&!reset){
            block_coins2.setText("You bought: "+name+"\n"+"You paid: "+itemprice);
            root.getChildren().remove(block_coins1);
            root.getChildren().addAll(block_coins1,block_coins2);
        }

        if(itemprice==17 &&name.equals("Demonic Dress")&&level==1){
           if(Freeze==false) {
               specialEvent1(itemprice, name);
           }
        }

    if(itemprice==17 && name.equals("Demonic Dress")&&Freeze==true ){
        specialEvent2(itemprice,name);
    }




        chainSize++;
    }

    private void specialEvent1(int price,String name){

            nextButton.setVisible(true);
            textBoxView.setVisible(true);
            text.setVisible(true);
            text.setText("Hehe L+ratio, I'm editing your block, and yoinking 3 coins from you!");
            nextButton.setOnMousePressed(e-> specialUpdate(price,name));

    }
    private void specialUpdate(int price,String name){
       level++;
        updateCoins(3);
        root.getChildren().remove(coins);
        root.getChildren().remove(newChainView);
        root.getChildren().addAll(newChainView, coins);
        block_coins1.setText("You bought: "+name+"\n"+"You paid: "+(price+3));
        root.getChildren().remove(block_coins1);
        root.getChildren().add(block_coins1);
        defaultSatan.setVisible(true);
        System.out.println(level);


        nextButton.setOnMousePressed(e->nextDialgoue());

    }

    private void specialEvent2(int price,String name){
        level++;
        nextButton.setVisible(true);
        textBoxView.setVisible(true);
        defaultSatan.setVisible(true);
        text.setVisible(true);
        text.setText("What!. The block is immutable, I can't steal your money!");
         block_coins1.setText("You bought: "+name+"\n"+"You paid: "+(price));

        root.getChildren().remove(block_coins1);
        root.getChildren().add(block_coins1);
        nextButton.setOnMousePressed(e-> nextDialgoue());
    }




//    private void nextDialgoue2(){
//    System.out.print("bruh");
//        if (d2_counter >= lines2.size()-1) {
//            nextButton.setVisible(false);
//            textBoxView.setVisible(false);
//            text.setVisible(false);
//            defaultSatan.setVisible(false);
//            reset=true;
//            //button.setManaged(true);
//        } else {
//            d2_counter++;
//            String current = lines2.get(d2_counter);
//            text.setText(current);
//        }
//    }

    //coin functions
    private void updateCoins(int price) {
        numCoins = numCoins - price;
        coins.setText(Integer.toString(numCoins) + " coins");
    }

    private void addCoins(int raise){
        numCoins = numCoins + raise;
        coins.setText(Integer.toString(numCoins) + " coins");
    }

    //item functions
    private void listItems(ArrayList<Item> Items, int X, int Y) {
        for (int i = 0; i < Items.size(); i++) {
            // Print all elements of List
            if (i > 0) {
                Items.get(i).displayItem(X, Y + 80);
                Y = Y +  80;
            }
            else{
                Items.get(i).displayItem(X, Y);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }

}