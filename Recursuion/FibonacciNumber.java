class Solution {
    public int fib(int n) {
        // if(n <= 1)return n;
        if(n == 0)return 0; //return can be ---> break in loops
        if(n == 1)return 1; //terminating condition of recursive function are called base case
        return fib(n-1) + fib(n-2); //O(2^n)
    }
}
