  public static void sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        
        // Initialize all entries as true
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        // Mark non-primes
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                // Mark all multiples of p
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        // Print primes
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    // Recursive implementation
    public static int gcdRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdRecursive(b, a % b);
    }
    
    // Iterative implementation
    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
