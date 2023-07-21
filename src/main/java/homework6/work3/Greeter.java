package homework6.work3;

public class Greeter {
    public String greet(FormalityHolder formalityHolder) {
        switch (formalityHolder.getFormality()) {
            case "formal":
                return "Good evening, sir.";
            case "casual":
                return "Sup bro?";
            case "intimate":
                return "Hello Darling!";
            default:
                return "Hello.";
        }
    }
}
