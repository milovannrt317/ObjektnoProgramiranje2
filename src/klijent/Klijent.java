package klijent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import modeli.*;

public class Klijent extends Application{

    private boolean Rpostavljen=true;
    private boolean Epostavljen=true;
    private final String adresa="localhost";
    private final int port=5700;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root=new Group();
        Scene scena=new Scene(root,500,500);
        popuni(root);
        primaryStage.setScene(scena);
        primaryStage.setTitle("Klijent");
        primaryStage.show();
    }
    private void popuni(Group root)
    {
        BorderPane borderPane = new BorderPane();
        TabPane tabPane=new TabPane();
        Tab zad1=new Tab("Zadatak 1");
        Tab zad2=new Tab("Zadatak 2");
        Tab zad3=new Tab("Zadatak 3");
        zad1.setClosable(false);
        zad2.setClosable(false);
        zad3.setClosable(false);
        
        //tab1
        VBox vbz1=new VBox(30);
        zadatak1(vbz1);
        zad1.setContent(vbz1);
        
        //tab2
        VBox vbz2=new VBox(30);
        zadatak2(vbz2);
        zad2.setContent(vbz2);   
        
        //tab3
        VBox vbz3=new VBox(20);
        zadatak3(vbz3);
        zad3.setContent(vbz3);

        vbz1.setStyle("-fx-background-color: lightyellow");
        vbz2.setStyle("-fx-background-color: lightblue");
        vbz3.setStyle("-fx-background-color: lightgreen");
        tabPane.getTabs().addAll(zad1,zad2,zad3);
        borderPane.prefHeightProperty().bind(root.getScene().heightProperty());
        borderPane.prefWidthProperty().bind(root.getScene().widthProperty());
        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
    }
    
    private void zadatak1(VBox vbz1){
        HBox hbz1=new HBox();
        Label lblPal=new Label("Unos za proveru palindroma:");
        lblPal.setFont(Font.font(14));
        hbz1.setAlignment(Pos.CENTER);
        hbz1.getChildren().add(lblPal);
        
        HBox hbtfz1=new HBox();
        TextField tfz1=new TextField();
        tfz1.setPrefColumnCount(30);
        tfz1.setFont(Font.font(14));
        hbtfz1.setAlignment(Pos.CENTER);
        hbtfz1.getChildren().add(tfz1);
        
        HBox hbbtnz1=new HBox();
        Button btnz1=new Button("Ispitaj");
        btnz1.setFont(Font.font(14));
        hbbtnz1.setAlignment(Pos.CENTER);
        hbbtnz1.getChildren().add(btnz1);
        
        BorderPane bpz1=new BorderPane();
        TextArea taz1=new TextArea();
        taz1.setFont(Font.font(14));
        bpz1.setCenter(taz1);
        HBox hblblz1=new HBox();
        hblblz1.setAlignment(Pos.CENTER);
        Label lbl=new Label("Odgovor sa servera:");
        lbl.setFont(Font.font(14));
        hblblz1.getChildren().add(lbl);
        bpz1.setTop(hblblz1);
        
        btnz1.setOnAction((event) -> {
            if(tfz1.getText().trim().isEmpty())
            {
                MessageBox.show("Prazno polje za unos!", "Greska unosa!");
                tfz1.requestFocus();
            }
            else
            {
                Palindrom palindrom=new Palindrom(tfz1.getText());
                
                try{
                Socket sockt = new Socket(adresa, port);
                ObjectOutputStream os=new ObjectOutputStream(sockt.getOutputStream());
                ObjectInputStream is=new ObjectInputStream(sockt.getInputStream());
                os.writeUnshared(palindrom);
                taz1.appendText("Server-> "+(String)is.readUnshared()+"\n");
                tfz1.clear();
                }
                catch(Exception ex){
                    MessageBox.show("Neuspesna konekcija sa serverom!", "Greska!");
                }
            }
        });
        vbz1.getChildren().addAll(hbz1,hbtfz1,hbbtnz1,bpz1);
        vbz1.setAlignment(Pos.CENTER);
    }
    private void zadatak2(VBox vbz2){
        HBox hbz2=new HBox();
        hbz2.setAlignment(Pos.CENTER);
        Label lblbsist=new Label("Sistem linearnih jednacina sa tri nepoznate:");
        lblbsist.setFont(Font.font(14));
        hbz2.getChildren().add(lblbsist);
        
        HBox hbjd1=new HBox(10);
        hbjd1.setAlignment(Pos.CENTER);
        Spinner<Integer> spx1=new Spinner<>(-1000, 1000, 0);
        Label lblx1=new Label("x");
        spx1.setPrefWidth(70);
        Spinner<Integer> spy1=new Spinner<>(-1000, 1000, 0);
        Label lbly1=new Label("y");
        spy1.setPrefWidth(70);
        Spinner<Integer> spz1=new Spinner<>(-1000, 1000, 0);
        Label lblz1=new Label("z");
        spz1.setPrefWidth(70);
        Label lbljdnk1=new Label("=");
        Spinner<Integer> spt1=new Spinner<>(-1000, 1000, 0);
        spt1.setPrefWidth(70);
        lblx1.setFont(Font.font(14));
        lbly1.setFont(Font.font(14));
        lblz1.setFont(Font.font(14));
        lbljdnk1.setFont(Font.font(14));
        hbjd1.getChildren().addAll(spx1,lblx1,spy1,lbly1,spz1,lblz1,lbljdnk1,spt1);
        
        HBox hbjd2=new HBox(10);
        hbjd2.setAlignment(Pos.CENTER);
        Spinner<Integer> spx2=new Spinner<>(-1000, 1000, 0);
        Label lblx2=new Label("x");
        spx2.setPrefWidth(70);
        Spinner<Integer> spy2=new Spinner<>(-1000, 1000, 0);
        Label lbly2=new Label("y");
        spy2.setPrefWidth(70);
        Spinner<Integer> spz2=new Spinner<>(-1000, 1000, 0);
        Label lblz2=new Label("z");
        spz2.setPrefWidth(70);
        Label lbljdnk2=new Label("=");
        Spinner<Integer> spt2=new Spinner<>(-1000, 1000, 0);
        spt2.setPrefWidth(70);
        lblx2.setFont(Font.font(14));
        lbly2.setFont(Font.font(14));
        lblz2.setFont(Font.font(14));
        lbljdnk2.setFont(Font.font(14));
        hbjd2.getChildren().addAll(spx2,lblx2,spy2,lbly2,spz2,lblz2,lbljdnk2,spt2);
        
        
        HBox hbjd3=new HBox(10);
        hbjd3.setAlignment(Pos.CENTER);
        Spinner<Integer> spx3=new Spinner<>(-1000, 1000, 0);
        Label lblx3=new Label("x");
        spx3.setPrefWidth(70);
        Spinner<Integer> spy3=new Spinner<>(-1000, 1000, 0);
        Label lbly3=new Label("y");
        spy3.setPrefWidth(70);
        Spinner<Integer> spz3=new Spinner<>(-1000, 1000, 0);
        Label lblz3=new Label("z");
        spz3.setPrefWidth(70);
        Label lbljdnk3=new Label("=");
        Spinner<Integer> spt3=new Spinner<>(-1000, 1000, 0);
        spt3.setPrefWidth(70);
        lblx3.setFont(Font.font(14));
        lbly3.setFont(Font.font(14));
        lblz3.setFont(Font.font(14));
        lbljdnk3.setFont(Font.font(14));
        hbjd3.getChildren().addAll(spx3,lblx3,spy3,lbly3,spz3,lblz3,lbljdnk3,spt3);
        
        HBox hbbtnz2=new HBox();
        Button btnz2=new Button("Izracunaj");
        btnz2.setFont(Font.font(14));
        hbbtnz2.setAlignment(Pos.CENTER);
        hbbtnz2.getChildren().add(btnz2);
        
        BorderPane bpz2=new BorderPane();
        TextArea taz2=new TextArea();
        taz2.setFont(Font.font(14));
        bpz2.setCenter(taz2);
        HBox hblblz2=new HBox();
        hblblz2.setAlignment(Pos.CENTER);
        Label lblodg=new Label("Odgovor sa servera:");
        lblodg.setFont(Font.font(14));
        hblblz2.getChildren().add(lblodg);
        bpz2.setTop(hblblz2);

        StringConverter<Integer> con=new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return object+"";
            }

            @Override
            public Integer fromString(String string) {
                try{
                    Integer i=Integer.parseInt(string);
                    return i;
                }catch (Exception ex)
                {
                    return 0;
                }
            }
        };
        spx1.setEditable(true);
        spx1.getValueFactory().setConverter(con);
        spy1.setEditable(true);
        spy1.getValueFactory().setConverter(con);
        spz1.setEditable(true);
        spz1.getValueFactory().setConverter(con);
        spt1.setEditable(true);
        spt1.getValueFactory().setConverter(con);
        spx2.setEditable(true);
        spx2.getValueFactory().setConverter(con);
        spy2.setEditable(true);
        spy2.getValueFactory().setConverter(con);
        spz2.setEditable(true);
        spz2.getValueFactory().setConverter(con);
        spt2.setEditable(true);
        spt2.getValueFactory().setConverter(con);
        spx3.setEditable(true);
        spx3.getValueFactory().setConverter(con);
        spy3.setEditable(true);
        spy3.getValueFactory().setConverter(con);
        spz3.setEditable(true);
        spz3.getValueFactory().setConverter(con);
        spt3.setEditable(true);
        spt3.getValueFactory().setConverter(con);

        btnz2.setOnAction((event) -> {
            Sistem sistem=new Sistem(spx1.getValue(), spx2.getValue(), spx3.getValue(),spy1.getValue(), spy2.getValue(), spy3.getValue(), spz1.getValue(), spz2.getValue(), spz3.getValue(), spt1.getValue(), spt2.getValue(), spt3.getValue());

            try{
                Socket sockt = new Socket(adresa, port);
                ObjectOutputStream os=new ObjectOutputStream(sockt.getOutputStream());
                ObjectInputStream is=new ObjectInputStream(sockt.getInputStream());
                os.writeUnshared(sistem);
                taz2.appendText("Server-> "+(String)is.readUnshared()+"\n");
                }
            catch(Exception ex){
                MessageBox.show("Neuspesna konekcija sa serverom!", "Greska!");
                }
        });
        
        vbz2.getChildren().addAll(hbz2,hbjd1,hbjd2,hbjd3,hbbtnz2,bpz2);
        vbz2.setAlignment(Pos.CENTER);
    }
    private void zadatak3(VBox vbz3){
        
        HBox hbz3=new HBox();
        hbz3.setAlignment(Pos.CENTER);
        Label lav=new Label("Lavirint:");
        lav.setFont(Font.font(14));
        hbz3.getChildren().add(lav);
        
        Lavirint lavir=new Lavirint();
        
        Button btn3=new Button("Resenje");
        Button btnR=new Button("Pomeri R");
        Button btnE=new Button("Pomeri E");
        GridPane gpz3=new GridPane();
        gpz3.setVgap(3);
        gpz3.setHgap(3);
        gpz3.setAlignment(Pos.CENTER);
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Label lbl=new Label();
                if(i==0 || j==0 || i==8 || j==8)
                {
                    if(!((i==0 && (j==0||j==8))||(i==8 &&(j==0||j==8))) && (i%2==1||i==0 || i==8))
                        lbl.setUserData("da");
                    else
                        lbl.setUserData("ne");
                }
                else
                    lbl.setUserData("ne");

                lbl.setFont(Font.font(14));
                lbl.setOnMouseClicked((event) -> {
                    premestiR((Label)event.getSource(),btn3,btnE);
                    premestiE((Label)event.getSource(),btn3,btnR);
                });
                lbl.setCursor(Cursor.HAND);
                gpz3.add(lbl, j, i);
            }
        }
        lavir.iscrtaj(gpz3);
        HBox hbbtnz3=new HBox(10);
        hbbtnz3.setAlignment(Pos.CENTER);
        Button btnDflt=new Button("Default raspored");
        Button btnRnd=new Button("Random raspored");
        btn3.setFont(Font.font(14));
        btnDflt.setFont(Font.font(14));
        btnRnd.setFont(Font.font(14));
        btnR.setFont(Font.font(14));
        btnE.setFont(Font.font(14));
        hbbtnz3.getChildren().addAll(btnDflt,btnRnd,btnR,btnE);
        
        HBox hbbtn3=new HBox();
        
        hbbtn3.setAlignment(Pos.CENTER);
        hbbtn3.getChildren().add(btn3);
        
        BorderPane bpz3=new BorderPane();
        TextArea taz3=new TextArea();
        taz3.setFont(Font.font(14));
        bpz3.setCenter(taz3);
        HBox hblblz3=new HBox();
        hblblz3.setAlignment(Pos.CENTER);
        Label res=new Label("Odgovor sa servera:");
        res.setFont(Font.font(14));
        hblblz3.getChildren().add(res);
        bpz3.setTop(hblblz3);
        
        btnDflt.setDisable(true);
        
        btnDflt.setOnAction((event) -> {
            btnDflt.setDisable(true);
            btn3.setDisable(false);
            btnR.setDisable(false);
            btnE.setDisable(false);
            Rpostavljen=true;
            Epostavljen=true;
            lavir.defaultni();
            lavir.iscrtaj(gpz3);
        });
        
        btnRnd.setOnAction((event) -> {
            btnDflt.setDisable(false);
            btn3.setDisable(false);
            btnR.setDisable(false);
            btnE.setDisable(false);
            Rpostavljen=true;
            Epostavljen=true;
            lavir.randomPrepreke();
            lavir.iscrtaj(gpz3);
        });
        
        btnR.setOnAction((event) -> {
            btn3.setDisable(true);
            btnE.setDisable(true);
            Rpostavljen=false;
            isprazniKarakterR(gpz3);
            MessageBox.show("Postavite robota na zeljeno prazno mesto!","Akcija premestanja!");
        });
        
        btnE.setOnAction((event) -> {
            btn3.setDisable(true);
            btnR.setDisable(true);
            Epostavljen=false;
            isprazniKarakterE(gpz3);
            MessageBox.show("Postavite izlaz na zeljeno mesto!\nIzlaz moze da se postavi samo na ivicama zidova, samo na parnim redovima","Akcija premestanja!");
        });
        btn3.setOnAction((event) -> {
            lavir.popuni(gpz3);
            try{
                Socket sockt = new Socket(adresa, port);//izvuci socket gore na vrh ili samo port i adresu
                ObjectOutputStream os=new ObjectOutputStream(sockt.getOutputStream());
                ObjectInputStream is=new ObjectInputStream(sockt.getInputStream());
                os.writeUnshared(lavir);
                taz3.appendText("Server-> "+(String)is.readUnshared()+"\n");
                }
            catch(Exception ex){
                    MessageBox.show("Neuspesna konekcija sa serverom!", "Greska!");
                }
        });
        vbz3.getChildren().addAll(hbz3,gpz3,hbbtnz3,hbbtn3,bpz3);
        vbz3.setAlignment(Pos.CENTER);
    }
    //za premestanje robota
    void premestiR(Label lbl,Button btn,Button btn1)
    {
        if(lbl.getText().trim().isEmpty() && !Rpostavljen)
        {
            lbl.setText("R");
            Rpostavljen=true;
            MessageBox.show("Robot uspesno postavljen!","Uspesna akcija!");
            btn.setDisable(false);
            btn1.setDisable(false);
        }
        else if (!Rpostavljen) {
             MessageBox.show("Robot moze da se stavi samo na prazna polja!","Neuspesna akcija!");
        }  
    }
    void premestiE(Label lbl,Button btn,Button btn1)
    {
        if(lbl.getText().trim().equals("@") && ((String)(lbl.getUserData())).equals("da") && !Epostavljen)
        {
            lbl.setText("E");
            Epostavljen=true;
            MessageBox.show("Izlaz uspesno postavljen!","Uspesna akcija!");
            btn.setDisable(false);
            btn1.setDisable(false);
        }
        else if (!Epostavljen) {
             MessageBox.show("Izlaz moze da se stavi samo na zidovima!","Neuspesna akcija!");
        }  
    }
    private void isprazniKarakterR(GridPane gpz3)
    {
        gpz3.getChildren().forEach((t) -> {
            if(((Label)t).getText().equals("R"))
                ((Label)t).setText("   ");
        });
    }
    private void isprazniKarakterE(GridPane gpz3)
    {
        gpz3.getChildren().forEach((t) -> {
            if(((Label)t).getText().equals("E"))
                ((Label)t).setText("@");
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
