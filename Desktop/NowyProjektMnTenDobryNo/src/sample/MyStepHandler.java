package sample;

import javafx.scene.chart.XYChart;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

public class MyStepHandler implements StepHandler {

    private static XYChart.Series<Double, Double> seriesMU = new XYChart.Series<>();
    private static XYChart.Series<Double, Double> seriesNU = new XYChart.Series<>();
    private static XYChart.Series<Double, Double> seriesHU = new XYChart.Series<>();

    public static XYChart.Series<Double, Double> getSeriesMU() {
        return seriesMU;
    }

    public static XYChart.Series<Double, Double> getSeriesNU() {
        return seriesNU;
    }

    public static XYChart.Series<Double, Double> getSeriesHU() {
        return seriesHU;
    }

    @Override
    public void init(double v, double[] doubles, double v1) { }

    @Override
    public void handleStep(StepInterpolator stepInterpolator, boolean b) throws MaxCountExceededException {
        double t  = stepInterpolator.getCurrentTime();
        double[] x = stepInterpolator.getInterpolatedState();


        seriesHU.getData().addAll(new XYChart.Data<>(x[3], x[2]));
        seriesNU.getData().addAll(new XYChart.Data<>(x[3], x[1]));
        seriesMU.getData().addAll(new XYChart.Data<>(x[3], x[0]));
    }


}
