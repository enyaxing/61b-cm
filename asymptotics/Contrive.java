import java.util.Random;

class Contrive {
    public void contrive(int n) {
        // Super big N input
        int N = 10000000;
        if (n == 0) {
            // Do something Theta (N^3)
            cubic(N);
        } else if (n % 2 == 0) { // n is even
            String coin_flip = flip();
            if (coin_flip.equals("Heads")) {
                // Do something Theta(N)
                logarithmic(N);
            } else if (coin_flip.equals("Tails")) {
                // Do something Theta(N^2)
                linear(N);
            }
        } else if (n % 2 == 1) { // n is odd
            String coin_flip = flip();
            if (coin_flip.equals("Heads")) {
                // Do something Theta(N^4)
                quadratic(N);
            } else if (coin_flip.equals("Tails")) {
                // Do something Theta(a^N), where a is a constant
                System.out.println(exponential(N));
            }
        }
    }

    // Returns heads or tails
    public String flip() {
        Random randomNum = new Random();
        int result = randomNum.nextInt(2);
        if (result == 0) {
            return "Heads";
        } else {
            return "Tails";
        }
    }

    void linear(int n) {
        int m = 0;
        for (int i = 0; i < n; i++) {
            m += i;
        }
        System.out.println(m);
    }

    void quadratic(int n) {
        int m = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m += j;
            }
        }
        System.out.println(m);
    }

    void cubic(int n) {
        int m = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    m = i + j + k;
                }
            }
        }
        System.out.println(m);
    }

    // Function that has logarithmic runtime (this is skip from Fall 2020 Week 5 WS)
    void logarithmic(int n) {
        if (n <= 1) {
            return;
        } else {
            logarithmic(n / n);
            logarithmic(n / 2);
        }
    }

    // Any exponential function, this one is recursive fibonacci
    int exponential(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return exponential(n - 1) + exponential(n - 2);
        }
    }
}