package Main.Java.Decorator;

public class UltraHD extends PlanDecorator{

    public UltraHD(Plan plan) {
        super(plan);
    }


    @Override
    public double costo() {
        return plan.costo() + 1000;
    }

    @Override
    public String descripcion() {
        return plan.descripcion() + " + resolución UltraHD";
    }

}
