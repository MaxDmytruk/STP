public class QuickSort {
    public int[] sort(int[] list){
        return this.sort(list, list.length);
    }
    public int[] sort(int[] list, int l){
        if(l == 0) return new int[0];
        if(l == 1) return list;
        int pivot = list[--l];
        int[] left = new int[l];
        int[] right = new int[l];

        int leftLength, rightLength = leftLength = 0;

        for(int i = 0; i < l; i++){
            if(list[i] < pivot) left[leftLength++] = list[i];
            else right[rightLength++] = list[i];
        }

        left = this.sort(left, leftLength);
        right = this.sort(right, rightLength);

        for(int i = 0; i < leftLength; i++) list[i] = left[i];
        list[leftLength] = pivot;
        for(int i = 0; i < rightLength; i++) list[i + leftLength + 1] = right[i];

        return list;
    }
}
