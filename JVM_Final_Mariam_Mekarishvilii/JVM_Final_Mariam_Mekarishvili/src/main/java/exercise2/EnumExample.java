package exercise2;

public class EnumExample {

    public void method1(Animal animal) {
        String result = "This is a ";
        switch (animal) {
            case LION:
                result += "Lion";
                break;
            case TIGER:
                result += "Tiger";
                break;
            case RABBIT:
                result += "Rabbit";
                break;
            default:
                result += "UNDEFINED";
                break;
        }
        System.out.println(result);
    }
}
