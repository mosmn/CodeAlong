public class Class {
    int x;

    Class() {
        x = 0;
    }

    Class updateObject() {
        Class obj = new Class();
        x = 900;
        return obj;
    }

    int receiveObject(Class obj) {
        x = 100;
        return x;
    }

    public String toString() {
        return "Answer=" + x;
    }
}
