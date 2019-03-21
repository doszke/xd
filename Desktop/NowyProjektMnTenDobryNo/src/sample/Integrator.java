package sample;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.events.EventHandler;
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;

public class Integrator {

    private double i;

    public Integrator(){}

    public Integrator(double i) {
        this.i = i;
    }


    private FirstOrderIntegrator integrator = new ClassicalRungeKuttaIntegrator(0.1);


    public void checkIfItIsOk(){
        NeuronEquation neuronEquation = new NeuronEquation();
        EventHandler turningPoint = new TurningPoint(10);
        integrator.addEventHandler(turningPoint, 0.1, 0.01, 2009);
        double[] xStart = {neuronEquation.M0(), neuronEquation.N0(), neuronEquation.H0(), 0};
        double[] xStop = {1, 1, 1, -150};

        integrator.addStepHandler(new MyStepHandler());

        integrator.integrate(neuronEquation, 0, xStart, 100, xStop);
    }


}
