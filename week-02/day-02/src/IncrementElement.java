public class IncrementElement {
    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5};

        System.out.println(t[2]);

        for (int i = 1; i < 2; i++){
            t[2] = t[2] + i;
        }

        System.out.println(t[2]);
    }
}


// Create an array variable named `t`
// with the following content: `[1, 2, 3, 4, 5]`
// Increment the third element
// Print the third element