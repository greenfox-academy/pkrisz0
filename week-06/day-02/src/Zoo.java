public class Zoo {
    public static void main(String[] args) {

        Reptile reptile = new Reptile("Crocodile");
        Mammal mammal = new Mammal("Koala");
        Bird bird = new Bird("Parrot");

        System.out.println("Who wants a baby?");
        System.out.println(reptile.getName() + ", " + reptile.wantChild());
        System.out.println(mammal.getName() + ", " + mammal.wantChild());
        System.out.println(bird.getName() + ", " + bird.wantChild());
        System.out.println(bird.greet());
        System.out.println(mammal.greet());
        System.out.println(reptile.greet());

    }
}
