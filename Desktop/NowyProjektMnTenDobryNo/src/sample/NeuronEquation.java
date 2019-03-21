package sample;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

public class NeuronEquation implements FirstOrderDifferentialEquations {

    static{
        I = 0.0;
    }

    private static Double I;
    private static double c = 1.0;
    private static double eNa = 115.0;
    private static double eK = -12.0;
    private static double eL = 10.6;
    private static double gNa = 120;
    private static double gK = 36.0;
    private static double gL = 0.3;

    public static Double getI() {
        return I;
    }

    public static void setI(Double i) {
        I = i;
    }


    public double M0(){
        double alphaM = 0.1*(25.0-0)/(Math.exp((25.0-0)/10.0)-1.0);
        double betaM = 4*Math.exp(0/18.0);
        return alphaM/(alphaM + betaM);
    }

    public double N0(){
        double alphaN = 0.01*(10.0 - 0)/(Math.exp((10.0-0)/10.0)-1);
        double betaN = 0.125*Math.exp((-0)/80.0);
        return alphaN/(alphaN + betaN);
    }

    public double H0(){
        double alphaH =0.07*Math.exp(-0/20.0);
        double betaH = 1/(Math.exp((30.0-0)/10.0)+1);
        return alphaH/(alphaH + betaH);
    }


    public NeuronEquation() {
    }

    @Override
    public int getDimension() {
        return 4;
    }

    @Override
    public void computeDerivatives(double t, double[] x, double[] dxdt) throws MaxCountExceededException, DimensionMismatchException {

        Double I = NeuronEquation.I;

        /*
        0- m
        1- n
        2- h
        3- u
         */

        double alphaM, betaM, alphaN, betaN, alphaH, betaH;


        alphaM = 0.1*(25.0-x[3])/(Math.exp((25.0-x[3])/10.0)-1.0);
        betaM = 4*Math.exp(-x[3]/18.0);

        alphaN = 0.01*(10.0 - x[3])/(Math.exp((10.0-x[3])/10.0)-1);
        betaN = 0.125*Math.exp((-x[3])/80.0);

        alphaH =0.07*Math.exp(-x[3]/20.0);
        betaH = 1/(Math.exp((30.0-x[3])/10.0)+1);

        dxdt[0] = alphaM*(1-x[0]) - betaM*x[0];
        dxdt[1] = alphaN*(1-x[1]) - betaN*x[1];
        dxdt[2] = alphaH*(1-x[2]) - betaH*x[2];
        dxdt[3] = -((gNa*Math.pow(x[0], 3)*x[2]*(x[3]-eNa) + gK*Math.pow(x[1], 4)*(x[3]-eK) + gL*(x[3]-eL))+I)/c;

    }
}
