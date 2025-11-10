module br.senai.sp.jandira.tabuada {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens br.senai.sp.jandira.tabuada to javafx.fxml;
    exports br.senai.sp.jandira.tabuada;
}