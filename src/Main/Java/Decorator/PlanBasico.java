package Main.Java.Decorator;

public class PlanBasico implements Plan {


    @Override
    public double costo() {
        return 1000;
    }

    @Override
    public String descripcion() {
        return "Plan básico";
    }


}
