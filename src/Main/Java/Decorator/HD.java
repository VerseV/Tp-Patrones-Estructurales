package Main.Java.Decorator;

public class HD extends PlanDecorator {

    public HD(Plan plan) {
        super(plan);
    }


    @Override
    public double costo() {
        return plan.costo() + 500;
    }

    @Override
    public String descripcion() {
        return plan.descripcion() + " + resolución HD";
    }
}
