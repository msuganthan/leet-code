#Maximize Number of Nice Divisors
#
#You are given a positive integer primeFactors. You are asked to construct a positive integer n that satisfies the following conditions:
#
#  The number of prime factors of n (not necessarily distinct) is at most primeFactors.
#  The number of nice divisors of n is maximized.
#
# Return the number of nice divisors of n. Since that number can be too large, return it modulo 109 + 7.
#
# Note that a prime number is a natural number greater than 1 that is not a product of two smaller natural numbers.
# The prime factors of a number n is a list of prime numbers such that their product equals n.
#
def maxNiceDivisors(self, primeFactors):
    MOD = 10**9 + 7
    if primeFactors <= 3: return primeFactors
    if primeFactors % 3 == 0: return pow(3, primeFactors//3, MOD)
    if primeFactors % 3 == 1: return (pow(3, (primeFactors-4)//3, MOD) * 4) % MOD
    return (2*pow(3, primeFactors//3, MOD)) % MOD
