int smallestSubarraySum(int arr[], int n) {
  int answer = 0;
  int current = 0;
  for (int i = 0; i < n; i++) {
    current += temp[i];
    if (answer > current) {
      answer = current;
    } else {
      current = 0;
    }
  }
  return answer;
}

