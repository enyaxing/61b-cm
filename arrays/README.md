# Meta

This is an alteration of Kadane's algorithm. As we go through the array, we can ask ourself: what is the minimum sum up until this point? Our first insight is that if we see a positive number, we should immediately know that minimum sum up until that positive number shouldn't include that positive number (since if we ignore, we're automatically creating a subsequence with larger sum than if we simply ignored it for a sum of 0). Thus, the idea is to go through the array and keep on adding the negative numbers until we encounter a positive number. When we encounter a positive number, reset the running sum to 0.

### Example
A: {-5 -6 -2 12 -5 -100}

We can see that we can add the first three numbers to get -13, which is the smallest sum we've encountered so far. We then see 12, so we reset the running sum. Then, our running sum becomes -5 + -100 = -105, which is the smallest consecutive sum. Thus, the answer is -105.

