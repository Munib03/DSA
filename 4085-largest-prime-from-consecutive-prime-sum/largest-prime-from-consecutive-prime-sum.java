class Solution {
public int largestPrime(int n) {
  var primes = sieve(n);
  var max = 0;
  var sum = 0;

  for (var i=2; i <= n; i++) {
    if (primes[i]) {
      sum += i;

      if (sum > n)
        break;

      if (primes[sum])
        max = Math.max(max, sum);
    }
  }

  return max;
}

public boolean[] sieve(int n) {
  boolean[] isPrime = new boolean[n + 1];

  if (n < 2)
    return isPrime;

  for (int i = 2; i <= n; i++)
    isPrime[i] = true;

  for (int i = 2; i * i <= n; i++) {
    if (isPrime[i]) {
      for (int j = i * i; j <= n; j += i)
        isPrime[j] = false;
    }
  }

  return isPrime;
}

}