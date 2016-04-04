public class ATaleOfThreeCities{
    public static double connect(int[] ax,int[] ay, int[] bx, int[] by, int[] cx, int[] cy){
        Coordinate[] A;
        Coordinate[] B;
        Coordinate[] C;
        
        A = createCoordinates(ax, ay);
        B = createCoordinates(bx, by);
        C = createCoordinates(cx, cy);
        
        double smallest_AB = smallestDist(A, B);
        double smallest_AC = smallestDist(A,C);
        double smallest_BC = smallestDist(B,C);
        
     
        double min_dist = smallest_AB + smallest_AC;
        min_dist = Math.min(min_dist, smallest_AB + smallest_BC);
        min_dist = Math.min(min_dist, smallest_AC + smallest_BC);
        return min_dist; 
    }
    
    public static Coordinate[] createCoordinates(int[] x, int[] y){
        Coordinate[] coordinates = new Coordinate[x.length];
    	for(int i = 0; i < x.length; i ++){
            coordinates[i] = new Coordinate(x[i], y[i]);
        }
        return coordinates;
    }
    
    public static double smallestDist(Coordinate[] A, Coordinate[] B)
    {
        double min = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i ++){
        	for(int j = 0; j < B.length; j ++){
                   double distance = calculateDist(A[i], B[j]);
                   min = Math.min(min, distance);
                }
        }
        return min;
    }
    
    public static  double calculateDist(Coordinate a, Coordinate b){
        double x_diff = b.x - a.x;
        double y_diff = b.y - a.y;
        double distance = Math.pow(x_diff,2) + Math.pow(y_diff,2);
        distance = Math.sqrt(distance);
        return distance;
    }
    public static class Coordinate{
        int x;
        int y;
        
        Coordinate(int x1, int y1){
            x = x1;
            y = y1;
        }
    }
}