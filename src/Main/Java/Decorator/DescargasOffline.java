package Main.Java.Decorator;

public class DescargasOffline extends PlanDecorator{
    public DescargasOffline(Plan plan){
        super(plan);
    }


    @Override
    public double costo() {
        return plan.costo() + 700;
    }


    @Override
    public String descripcion() {
        return plan.descripcion() + " + descargas offline";
    }
}
