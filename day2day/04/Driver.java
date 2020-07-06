public class Driver {

	public static void main(String[] args) {
		SuperArray sa = new SuperArray(2);
		sa.add(9);
		sa.add(1);
		sa.grow();
		sa.grow();  // test when there are unused array elements
		sa.add(3);
		sa.add(2,2);
		sa.add(4,4);
		sa.add(25,4);
		System.out.printf("array of %d items: %s\n", sa.size(), sa);
		sa.remove(0);
		sa.remove(8);
		System.out.printf("array of %d items: %s\n", sa.size(), sa);

		// SuperArray sa0 = new SuperArray();
		// System.out.printf("empty array, should be empty, cannot add (f): %s, %s, %b\n",
		// 					sa0, sa0.isEmpty(), sa0.add(1));
		//
		// //System.out.printf("array of %d items, can add: %s, %b\n",
		// //					sa2.size(), sa2, sa2.add(2));
		// System.out.printf("array of %d items: %s\n", sa2.size(), sa2);
		// sa2.add(2);
		// System.out.printf("1st item: %d, 2nd item: %d, 3rd item: %d\n",
		// 					sa2.get(0), sa2.get(1), sa2.get(2));

	}  // end main()

}  // end Driver
