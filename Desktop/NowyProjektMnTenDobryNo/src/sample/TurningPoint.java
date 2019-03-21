package sample;

import org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D;
import org.apache.commons.math3.ode.events.EventHandler;

public class TurningPoint implements EventHandler {

    private double i;

    public TurningPoint(double i) {
        this.i = i;
    }

    @Override
    public void init(double t, double[] x, double dxdt) {

    }

    @Override
    public double g(double t, double[] dxdt) {
        return t-10;
    }

    @Override
    public Action eventOccurred(double t, double[] dxdt, boolean b) {
        return Action.RESET_STATE;
    }

    @Override
    public void resetState(double t, double[] dxdt) {
        NeuronEquation.setI(i);
    }
}
