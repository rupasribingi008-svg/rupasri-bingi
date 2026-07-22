lass Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] left = new int[arr.length];
        left[0] = arr[0];
        int[] right = new int[arr.length + 1];
        right[right.length - 1] = arr.length;
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1]);
        }
        int count = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (left[i] <= right[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
