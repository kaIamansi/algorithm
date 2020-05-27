public long solution(int N) {
        long[] arr = new long[N];

        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2; i < N; i++) {
		arr[i] = arr[i-1] + arr[i-2];
        }
        
        return (4 * arr[N-1]) + (2 * arr[N-2]);
}
