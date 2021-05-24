private static void printGrid(int[][] x) {
  for (int row = 0; row < x.length; row++) {
      for (int col = 0; col < x[row].length; col++) {
         System.out.print(x[row][col]);
       }
    System.out.println();
  }
}
