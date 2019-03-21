package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Tab tabBramkowanieNapiecie;

    @FXML
    private BorderPane r;

    @FXML
    private LineChart<Double, Double> chartBramowanieNapiecie;

    @FXML
    private Tab tabNapiecieCzas;

    @FXML
    private LineChart<?, ?> lineChartTemp;

    @FXML
    private TextField textFieldNapiecieCzas;

    @FXML
    private Label labelTime;

    @FXML
    private Tab tabPradyCzas;

    @FXML
    private TextField textFieldPradyCzas;

    @FXML
    private LineChart<?, ?> chartPradyCzas;

    @FXML
    private Tab tabBramkowanieCzas;

    @FXML
    private LineChart<?, ?> chartBramkowanieCzas;

    @FXML
    private TextField textFieldBramokwanieCzas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chartBramowanieNapiecie.setAnimated(false);
        Integrator integrator = new Integrator();

        integrator.checkIfItIsOk();

        chartBramowanieNapiecie.getData().addAll(MyStepHandler.getSeriesHU(), MyStepHandler.getSeriesMU(), MyStepHandler.getSeriesNU());

    }
}
