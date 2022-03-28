module databaseFXX {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires transitive org.hibernate.orm.core;
    requires javafx.base;
    requires java.naming;
    requires java.desktop;
    requires transitive javafx.graphics;
    requires java.base;



    exports com.example.databasefxx;
    opens com.example.databasefxx to javafx.fxml, java.base;
    opens DAO to javafx.fxml;
    opens Business to javafx.fxml, org.hibernate.orm.core, javafx.base, java.base;
    opens Database to javafx.fxml;
    exports com.example.databasefxx.CRUD.Create;
    opens com.example.databasefxx.CRUD.Create to java.base, javafx.fxml;
    exports com.example.databasefxx.CRUD.Update;
    opens com.example.databasefxx.CRUD.Update to java.base, javafx.fxml;
    exports com.example.databasefxx.CRUD.Read;
    opens com.example.databasefxx.CRUD.Read to java.base, javafx.fxml;
}