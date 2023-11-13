class Main {
    public static void main(String[] args) {
        Class obj = new Class();

        System.out.println(obj.x);

        Class tt = obj.updateObject();
        System.out.println(tt.x);
        System.out.println(obj.x);

    }
}