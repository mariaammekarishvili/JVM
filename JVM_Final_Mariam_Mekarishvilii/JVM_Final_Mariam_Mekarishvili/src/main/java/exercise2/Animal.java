package exercise2;

public enum Animal {
    TIGER{
        @Override
        String getString() {
            return "Tiger";
        }
    },
    LION {
        @Override
        String getString() {
            return "Lion";
        }
    },
    RABBIT {
        @Override
        String getString() {
            return "Rabbit";
        }
    };

    abstract String getString();
}
