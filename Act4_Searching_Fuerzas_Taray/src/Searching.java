import java.util.Scanner;

public class Searching {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = n / 4; 
        int prev = 0;
    
        while (prev < n && arr[step - 1] < target) {
            prev = step;
            step += n / 4; 
            if (prev >= n)
                return -1;
        }
    
        for (int i = prev; i < step && i < n; i++) { 
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static int exponentialSearch(int[] arr, int target) {
        if (arr[0] == target) return 0;

        int i = 1;
        while (i < arr.length && arr[i] <= target) {
            i *= 2;
        }

        return binarySearch(arr, target);
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a Searching algorithm to perform:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search ");
        System.out.println("3. Jump Search ");
        System.out.println("4. Exponential Search");
        System.out.print("Enter your choice (1-4): ");

        int choice = scanner.nextInt();

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter target element: ");
        int target = scanner.nextInt();

        if (choice == 2 || choice == 3 || choice == 4) {
            bubbleSort(arr);
        }

        int index = -1;
        switch (choice) {
            case 1:
                index = linearSearch(arr, target);
                break;
            case 2:
                index = binarySearch(arr, target);
                break;
            case 3:
                index = jumpSearch(arr, target);
                break;
            case 4:
                index = exponentialSearch(arr, target);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (index >= 0) {
            System.out.println("Search Result: Element is found at index " + index + ".");
        } else {
            System.out.println("Search Result: Element is not found.");
        }

        scanner.close();
    }
}





