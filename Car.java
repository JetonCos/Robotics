public class Car {
    private String model;
    private String brand;
    private int mileage;

    public Car(String model, String brand, int mileage){
    this.model = model;
    this.brand = brand;
    this.mileage = mileage;
    }

    public static void main(String[] args){
        String modelName = args[0];
        String brandName = args [1];
        int mileageAmount = Integer.parseInt(args[2]);
        int distanceToDrive = Integer.parseInt(args[3]);
        Car myCar = new Car(modelName, brandName, mileageAmount);
        myCar.drive(distanceToDrive);
        myCar.informationOnCar();
    }
    
    public void drive(int distance){

        this.mileage += distance;
    }

    public void informationOnCar() {
    System.out.println("Brand: " + this.brand);
    System.out.println("Model: " + this.model);
    System.out.println("Current Mileage: " + this.mileage);

    }
}