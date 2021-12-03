module com.hms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires commons.codec;
    requires org.hibernate.orm.testing;

    opens com.tms to javafx.fxml;
    exports com.tms;

    exports com.tms.controller;
    opens com.tms.controller to javafx.fxml;
}