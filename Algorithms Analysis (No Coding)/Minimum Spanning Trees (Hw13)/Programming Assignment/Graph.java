import java.util.*;

public class Graph {
	 
    int[][]  LinkBandWidth; // Badnwidth between 2 nodes
    int      num_nodes; // number of nodes 
     
    // constructor takes in a matrix as its input 
    Graph(int[][] mat)
    {
        int i, j;
 
        num_nodes = mat.length;
 
        LinkBandWidth = new int[num_nodes][num_nodes];
 
        // copying the Bandwidth to LinkBandWidth matrix
        for ( i=0; i < num_nodes; i++)
        {
            for ( j=0; j < num_nodes; j++)
            {
                LinkBandWidth[i][j] = mat[i][j];
                
            }
        }
    }
 
    //function to get the nodes that are unreached
    public int unReached(boolean[] r)
    {
        boolean done = true;
 
        for ( int i = 0; i < r.length; i++ )
            if ( r[i] == false )
                return i;
 
        return -1;
    }
 
 
    public void Prim( )
    {
        int i, j, k, x, y;
 
        boolean[] Reached = new boolean[num_nodes]; // array to keep track of the reached nodes
        int[] predNode = new int[num_nodes];        // array to maintain max cost edge
 
// starting vertex
        Reached[0] = true;
        //setting other vertices as unreached
        for ( k = 1; k < num_nodes; k++ )
        {
            Reached[k] = false;
        }
 
        predNode[0] = 0;      // No edge for node 0
 
        printCoveredNodes( Reached );
 
     //we iterate for n-1 nodes that haven't been reached yet
        for (k = 1; k < num_nodes; k++)
        {
            x = y = 0;
 
            for ( i = 0; i < num_nodes; i++ )
                for ( j = 0; j < num_nodes; j++ )
                {
//update the Maximum Spanning Tree with the maximum bandwidth
                    if ( Reached[i] && !Reached[j] &&
                            LinkBandWidth[i][j] > LinkBandWidth[x][y] )
                    {
                        x = i;
                        y = j;
                    }
                }
 
            System.out.println("Next selected edge: (" +
                    + x + "," +
                    + y + ")" +
                    " Bandwidth = " + LinkBandWidth[x][y]);
 
 
            predNode[y] = x;          // add the max bandwidth to predNode
            Reached[y] = true;
 
            printCoveredNodes( Reached );
            System.out.println();
        }
 
        printMaxBandwidthEdges( predNode );
    }
    // function to print the edges of spanning tree
    void printMaxBandwidthEdges( int[] a )
    {
 System.out.println("Edges in Maximum Spanning Tree: ");
        for ( int i = 0; i < num_nodes; i++ )
            System.out.println( a[i] + " --> " + i );
    }
 
    
 void printCoveredNodes(boolean[] Reached )
    {
        System.out.print("Covered Nodes = ");
        for (int i = 0; i < Reached.length; i++ )
            if ( Reached[i] )
                System.out.print( i + " ");
        System.out.println();
    }
	
	public static void main(String[] args) {
		
		int[][] conn = {{0, 4, 0, 0, 5},
                {4, 0, 3, 6, 1},
                {0, 3, 0, 6, 2},
                {0, 6, 6, 0, 7},
                {5, 1, 2, 7, 0},
        };
 
        Graph G = new Graph(conn);
 
        G.Prim();

	}

}
