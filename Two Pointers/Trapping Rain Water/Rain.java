import java.util.*;

class Rain {
    public static void main(String[] args) {
        int[] height = acceptInput();

        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length-1;

        int leftMax = 0;
        int rightMax = 0;

        int result = 0;

        while(left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax < rightMax) {
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
        }

        return result;
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