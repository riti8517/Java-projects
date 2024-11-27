/*
 * In this program, you will be writing a method called triangleType and
 * calling it from the main program to determine the type of triangle
 * you might be able to form given 3 side-lengths.
 * Details about test cases are provided in the comments at the bottom
 * of this file.
 */
public class TriangleType {

	// Method triangleType
	// parameters: (double a, double b, double c)
	// return type: int
	// Return value
	//	-1 if the values a, b, and c cannot form a triangle
	//		1 if the values a, b, and c form an acute triangle
	//		2 if the values a, b, and c form a right triangle
	//		3 if the values a, b, and c form an obtuse triangle
	// Hint:
	//	#1) Three lengths can form a triangle if the sum of the lengths of the two
	//		shorter sides of a triangle is greater than the length of the longest side.
	//  #2) If the square of the length of the longest side is
	//	* less than the sum of the squares of the lengths of the two shorter sides ==> acute triangle
	//	* equal to the sum of the squares of the lengths of the two shorter sides ==> right triangle
	//  * greater than the sum of the squares of the lengths of the two shorter sides ==> obtuse triangle 
		 

	    public static int triangleType(double a, double b, double c) {
	        if (a + b <= c || a + c <= b || b + c <= a) {
	            return -1; 
	        }
	        double aSquared = Math.pow(a, 2);
	        double bSquared = Math.pow(b, 2);
	        double cSquared = Math.pow(c, 2);

	        if (aSquared + bSquared == cSquared || aSquared + cSquared == bSquared || bSquared + cSquared == aSquared) {
	            return 2;
	        }
	        if (aSquared + bSquared > cSquared && aSquared + cSquared > bSquared && bSquared + cSquared > aSquared) {
	            return 1;
	        } else {
	            return 3; 
	        }
	    }

	/* Student's main program - IGNORE THIS FOR NOW
	 * Instead use the one further below
	 */
	public static void main1(String[] args) {
	}
	
	/*********************************************************/
	/**** MAIN PROGRAM #2 for Ms. Sangam's Automated Testing */
	/*********************************************************/
	
	// If you want to run your own main program, the one below needs to be called "main2"
	// If you want to run this particular main program, make sure it has the name "main"
	public static void main(String[] args) {
		double[][] triSidesArray =
				new double[][] {
						{0,0,0}, {0,1,1}, {1,0,1}, {1,1,0}, // not a triangle
						{3,4,4}, {4,3,4}, {4,4,3}, // acute isosceles
						{3,3,5}, {3,5,3}, {5,3,3}, // obtuse isosceles
						{0.00005,0.00012,0.00013}, // right
						{1,1,1}, // acute equilateral
						{3,4,9}, {3,9,4}, {4,3,9}, {.4,.9,.3}, {.09,.03,.04}, {.009,.004,.003}, // not a triangle
						{4,5,6}, {4,6,5}, {5,4,6}, {.5,.6,.4}, {.06,.04,.05}, {.006,.005,.004}, // acute
						{3,4,5}, {3,5,4}, {4,3,5}, {.4,.5,.3}, {.05,.03,.04}, {.005,.004,.003}, // right
						{2,4,5}, {2,5,4}, {4,2,5}, {.4,.5,.2}, {.05,.02,.04}, {.005,.004,.002} // obtuse
						};
		int[] expectedTriType =
				new int[] {
						-1, -1, -1, -1, 1, 1, 1, 3, 3, 3, 2, 1, -1, -1, -1, -1, -1, -1,
						1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3
						};
		String form = "form";
		int passTotal = 0;
		for (int i=0; i<triSidesArray.length; i++) {
			double a = triSidesArray[i][0];
			double b = triSidesArray[i][1];
			double c = triSidesArray[i][2];
			int tType = triangleType(a, b, c);
			if (tType == -1) {
				form = "do not form a triangle";
			} else if (tType == 1) {
				form = "form an acute triangle";
			} else if (tType == 2) {
				form = "form a right triangle";
			} else if (tType == 3) {
				form = "form an obtuse triangle";
			} else {
				form = "form an unknown thingamajig (triangle type is " + tType + ")";
			}
			System.out.print("Side lengths " + a + ", " + b +
					", and " + c + " " + form + ".");
			
			int expTriType = expectedTriType[i];
			if (expTriType == -1) {
				System.out.print(" EXPECTED: NOT A TRIANGLE.");
			} else if (expTriType == 1) {
				System.out.print(" EXPECTED: ACUTE TRIANGLE.");
			} else if (expTriType == 2) {
				System.out.print(" EXPECTED: RIGHT TRIANGLE.");
			} else if (expTriType == 3) {
				System.out.print(" EXPECTED: OBTUSE TRIANGLE.");
			}
			if (tType == expTriType) {
				System.out.println(" PASS! :-)");
				passTotal++;
			}
			else
				System.out.println(" FAIL! :-(");
		}
		System.out.println(passTotal + " out of " + expectedTriType.length + " test cases passed.");
	} // Ms. Sangam's alternate main2 for automated testing

	
}
/*
++++++++++++++++++++++++++++++
TEST CASE #1 -- NOT A TRIANGLE
Enter a side-length (int or double value): 0
Enter a side-length (int or double value): 0
Enter a side-length (int or double value): 0
Side lengths 0.0, 0.0, and 0.0 do not form a triangle.
++++++++++++++++++++++++++++++
TEST CASE #2 -- RIGHT TRIANGLE
Enter a side-length (int or double value): 3
Enter a side-length (int or double value): 4
Enter a side-length (int or double value): 5
Side lengths 3.0, 4.0, and 5.0 form a right triangle.
++++++++++++++++++++++++++++++
TEST CASE #3 -- ACUTE TRIANGLE
Enter a side-length (int or double value): 3
Enter a side-length (int or double value): 4
Enter a side-length (int or double value): 4
Side lengths 3.0, 4.0, and 4.0 form an acute triangle.
++++++++++++++++++++++++++++++
TEST CASE #4 -- OBTUSE TRIANGLE
Enter a side-length (int or double value): 3
Enter a side-length (int or double value): 4
Enter a side-length (int or double value): 6
Side lengths 3.0, 4.0, and 6.0 form an obtuse triangle.
++++++++++++++++++++++++++++++
TEST CASE #5 -- NOT A TRIANGLE
Enter a side-length (int or double value): 3
Enter a side-length (int or double value): 4
Enter a side-length (int or double value): 9
Side lengths 3.0, 4.0, and 9.0 do not form a triangle.
++++++++++++++++++++++++++++++
ADD AT LEAST 4 MORE TEST CASES OF YOUR OWN CHOICE,
AS INDICATED BELOW
++++++++++++++++++++++++++++++
TEST CASE #6 -- NOT A TRIANGLE
Enter a side-length (int or double value): 0
Enter a side-length (int or double value): 1
Enter a side-length (int or double value): 1
Side lengths 0.0, 1.0, and 1.0 do not form a triangle.
++++++++++++++++++++++++++++++
TEST CASE #7 -- RIGHT TRIANGLE
Enter a side-length (int or double value): 4
Enter a side-length (int or double value): 3
Enter a side-length (int or double value): 5
Side lengths 4.0, 3.0, and 5.0 form a right triangle.
++++++++++++++++++++++++++++++
TEST CASE #8 -- ACUTE TRIANGLE
Enter a side-length (int or double value): 1
Enter a side-length (int or double value): 1
Enter a side-length (int or double value): 1
Side lengths 1.0, 1.0, and 1.0 form an acute triangle.
++++++++++++++++++++++++++++++
TEST CASE #9 -- OBTUSE TRIANGLE
Enter a side-length (int or double value): 3
Enter a side-length (int or double value): 3
Enter a side-length (int or double value): 5
Side lengths 3.0, 3.0, and 5.0 form an obtuse triangle.
++++++++++++++++++++++++++++++
*//////T A TRIANGLE
////Enter a side-length (int or double value): 3
////Enter a side-length (int or double value): 4
////Enter a side-length (int or double value): 9
////Side lengths 3.0, 4.0, and 9.0 do not form a triangle.
////++++++++++++++++++++++++++++++
////ADD AT LEAST 4 MORE TEST CASES OF YOUR OWN CHOICE,
////AS INDICATED BELOW
////++++++++++++++++++++++++++++++
////TEST CASE #6 -- NOT A TRIANGLE
////++++++++++++++++++++++++++++++
////TEST CASE #7 -- RIGHT TRIANGLE
////++++++++++++++++++++++++++++++
////TEST CASE #8 -- ACUTE TRIANGLE
////++++++++++++++++++++++++++++++
////TEST CASE #9 -- OBTUSE TRIANGLE
////++++++++++++++++++++++++++++++
//
//*/