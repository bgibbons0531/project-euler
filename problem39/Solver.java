import java.util.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int LIMIT = 1000;
		
		//Get number of triangles
		int a = 0, b = 0, c = 0;
		int[] triangle = new int[4];
		List<int[]> triangleList = new ArrayList<int[]>();
		while (a < 500) {
			a++;
			b=0;
			while (b < a) {
				b++;
				c=0;
				while (c < a+b) {
					c++;
					if (a*a + b*b == c*c && a+b+c<=LIMIT) {
						triangle = new int[4];
						triangle[0] = a;
						triangle[1] = b;
						triangle[2] = c;
						triangle[3] = a+b+c;
						triangleList.add(triangle);
					}
				}
			}
		}
		
		//Find max perimeter
		int max = triangleList.get(0)[3];
		int min = triangleList.get(0)[3];
		for (int i=0;i<triangleList.size();i++) {
			if (triangleList.get(i)[3] > max) {
				max = triangleList.get(i)[3];
			}
			else if (triangleList.get(i)[3] < min) {
				min = triangleList.get(i)[3];
			}
		}
		
		//Find perimeter with max number of solutions
		int maxPerimeter = 0;
		int solutionCount = 0;
		int maxSolutionCount = 0;
		for (int i=min;i<=max;i++) {
			solutionCount = 0;
			//Find how many solution with perimeter of i
			for (int j=0;j<triangleList.size();j++) {
				if (triangleList.get(j)[3] == i) {
					solutionCount++;
				}
			}
			if (solutionCount > maxSolutionCount) {
				maxSolutionCount = solutionCount;
				maxPerimeter = i;
			}
		}
		System.out.print("p= " + maxPerimeter);
	}
}
