public class BinarySearch {
    static int binarySearch(int[] lst,int v){
        int i = 0,j = lst.length;
        while(i<j){
            int mid = (i+j) / 2;
            if(v < lst[mid]){
                j = mid;
            }else if(v > lst[mid]){
                i = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arrays = new int[] {1, 2, 4, 5, 7, 8, 11, 13};
        int[] find = new int[]{5,13,10};
        for(int arr:find){
            System.out.println("BinarySearch : "+ arr);
            if(binarySearch(arrays,arr) == -1){
                System.out.printf("Invalid Number");
            }else{
                System.out.printf("Find Index: %d%n",binarySearch(arrays,arr));
            }
        }
    }
}
