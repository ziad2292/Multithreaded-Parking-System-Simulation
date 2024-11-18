public class Main
{
    public static void main(String[] args) throws InterruptedException {

        Simulation simulation = new Simulation("D:\\Uni\\Year 3\\1st Semester\\OS\\Operating-Systems-Assignment2\\input.txt");
        simulation.run();
        simulation.endSimulation();
    }
}