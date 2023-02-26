import java.util.*;

class Container {

    public static void main(String[] args) {
        int[] height = acceptInput();

        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int water = 0;

        while(left < right) {
            water = Math.max(water, Math.min(height[left], height[right]) * (right - left));

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return water;
    }

    private static int[] acceptInput() {
        Scanner sc= new Scanner(System.in);
        String input = sc.nextLine();
        String[] heights = input.split(" ");

        int[] height = new int[heights.length];

        for(int i=0; i<heights.length; i++) {
            height[i] = Integer.parseInt(heights[i]);
        }

        return height;
    }
}