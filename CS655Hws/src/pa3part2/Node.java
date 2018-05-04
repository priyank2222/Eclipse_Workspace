package pa3part2;

import java.io.*;

/**
 * This is the class that students need to implement. The code skeleton is provided.
 * Students need to implement rtinit(), rtupdate() and linkhandler().
 * printdt() is provided to pretty print a table of the current costs for reaching
 * other nodes in the network.
 */
public class Node {

    public static final int INFINITY = 9999;

    int[] lkcost;		/*The link cost between node 0 and other nodes*/
    int[][] costs;  		/*Define distance table*/
    int nodename;               /*Name of this node*/
    int[] old_costs;
    int[] path;
    /* Class constructor */
    public Node() { }

    /* students to write the following two routines, and maybe some others */
    void rtinit(int nodename, int[] initial_lkcost) 
    {
      
        this.nodename = nodename;
        costs = new int[4][4];
        old_costs = new int[4];  //recording the connectcost
        path = new int[4];   //record the path from this node to all the other nodes
        
        switch(nodename)
        {
          
            case 0:
              
                path[0] = 0;
                path[1] = 1;
                path[2] = 2;
                path[3] = -1;
                break;
                
            case 1:
              
                path[0] = 0;
                path[1] = 1;
                path[2] = 2;
                path[3] = 3;
                break;
                
            case 2:
              
                path[0] = 0;
                path[1] = 1;
                path[2] = 2;
                path[3] = 3;
                break;
                
            case 3:
     
                path[0] = -1;
                path[1] = 1;
                path[2] = 2;
                path[3] = 3;
                break;
                
        }
        
        // Save Values to costs[][]
        
        for(int i = 0 ; i < 4 ; i++)
        {
            if(i == nodename)
            {
                for(int j = 0 ; j < 4 ; j++)
                {
                    costs[i][j] = initial_lkcost[j];
                    old_costs[j] = initial_lkcost[j];
                }
            }
            else
            {
                for(int j = 0 ; j < 4 ; j++){
                    costs[i][j] = INFINITY;
                }
            }
        }
        
        // Creating a packet for every known distance
        
        for(int i = 0 ; i < 4 ; i++)
        {
            if(costs[nodename][i] != INFINITY)
            {
                Packet sendPacket = new Packet(nodename, i, costs[nodename]);
                NetworkSimulator.tolayer2(sendPacket);
            }
        }

    }

    void rtupdate(Packet rcvdpkt) 
    {
        Packet rpacket = rcvdpkt;
        
        int tRoute[];
        int temp;
        
        int previousNode = rpacket.sourceid;
        int currentNode = rpacket.destid;
        
        boolean needLie = false;
        boolean change = false;
        
        int fake[] = new int[4];
        int a = 0;

        for(int i = 0 ; i < 4 ; i++)
        {
          
            if(costs[previousNode][i] != rpacket.mincost[i])  // Value for any link has changed
            {
                change = true;
                costs[previousNode][i] = rpacket.mincost[i];

            }
            
            costs[previousNode][i] = rpacket.mincost[i];
        }
        
        tRoute = new int[4];
        
        for(int i = 0 ; i < 4 ; i++)
        {
            tRoute[i] = -1;
        }
        
        System.out.println("Current Source Node : " + this.nodename);
        System.out.println("Destined Node : " + previousNode);



        for(int i = 0 ; i < 4 ; i++)
        {
            if(this.path[i] == previousNode)   // When this node has a transfer node to node i
            {
                temp = this.old_costs[i];
                
                if (temp > costs[currentNode][previousNode] + costs[previousNode][i]) 
                {
                    temp = costs[currentNode][previousNode] + costs[previousNode][i];
                    tRoute[i] = temp;
                    path[i] = previousNode;
                }
                
                costs[currentNode][i] = temp;
            }
            
            temp = this.old_costs[i];
            tRoute[i] = costs[currentNode][previousNode] + costs[previousNode][i];
            
            if(temp > costs[currentNode][previousNode] + costs[previousNode][i])
            {
                temp = costs[currentNode][previousNode] + costs[previousNode][i];

            }
            
            if(temp > costs[currentNode][i])
            {
                temp = costs[currentNode][i];
            }
            
            if (costs[currentNode][i] != temp)
            {
                costs[currentNode][i] = temp;
                change = true;
            }
            
            if(costs[currentNode][i] == tRoute[i] && i != previousNode)
            {
                needLie = true;
                fake[i] = INFINITY;
                this.path[i] = previousNode;
            }
            
            if(costs[currentNode][i] == this.old_costs[i])
            {
                this.path[i] = i;
            }
        }
        
        for(int i = 0 ; i < 4 ; i++)
        {
            if(fake[i] != INFINITY)
            {
                fake[i] = costs[currentNode][i];
            }
        }
        
        if(change)   //send packet
        {
            for(int i = 0 ; i < 4 ; i++) 
            {
                if(needLie && i == previousNode)
                {
                    Packet routePacket = new Packet(currentNode, previousNode, fake);
                    NetworkSimulator.tolayer2(routePacket);
                }
                else
                {
                    Packet sendPacket = new Packet(currentNode, i, costs[currentNode]);
                    NetworkSimulator.tolayer2(sendPacket);
                }

            }
        }
        
        System.out.println("Costs contains in this Node : " + currentNode);
        
        for(int i = 0 ; i <4 ; i++)
        {
            for(int j = 0 ; j < 4 ; j++)
            {
                System.out.print(costs[i][j] + " ");
            }
            
            System.out.println();
        }
        
        for(int i = 0 ; i < 4 ; i++)
        {
            System.out.print(path[i]);
        }
    }


    /* called when cost from the node to linkid changes from current value to newcost*/
    
    void linkhandler(int linkid, int newcost) 
    {
        costs[this.nodename][linkid] = newcost;
        this.old_costs[linkid] = newcost;
        
        System.out.println("Cost has been Changed : " + nodename + "-->" + linkid);
        
        for(int i = 0 ; i < 4 ; i++)
        {
            Packet sendPacket = new Packet(nodename, i, costs[nodename]);
            NetworkSimulator.tolayer2(sendPacket);
        }
    }


    /* Prints the current costs to reaching other nodes in the network */
    void printdt() 
    {
        switch(nodename) 
        {

            case 0:
                System.out.printf("                via     \n");
                System.out.printf("   D0 |    1     2 \n");
                System.out.printf("  ----|-----------------\n");
                System.out.printf("     1|  %3d   %3d \n",costs[1][1], costs[1][2]);
                System.out.printf("dest 2|  %3d   %3d \n",costs[2][1], costs[2][2]);
                System.out.printf("     3|  %3d   %3d \n",costs[3][1], costs[3][2]);
                break;
            case 1:
                System.out.printf("                via     \n");
                System.out.printf("   D1 |    0     2    3 \n");
                System.out.printf("  ----|-----------------\n");
                System.out.printf("     0|  %3d   %3d   %3d\n",costs[0][0], costs[0][2],costs[0][3]);
                System.out.printf("dest 2|  %3d   %3d   %3d\n",costs[2][0], costs[2][2],costs[2][3]);
                System.out.printf("     3|  %3d   %3d   %3d\n",costs[3][0], costs[3][2],costs[3][3]);
                break;
            case 2:
                System.out.printf("                via     \n");
                System.out.printf("   D2 |    0     1    3 \n");
                System.out.printf("  ----|-----------------\n");
                System.out.printf("     0|  %3d   %3d   %3d\n",costs[0][0], costs[0][1],costs[0][3]);
                System.out.printf("dest 1|  %3d   %3d   %3d\n",costs[1][0], costs[1][1],costs[1][3]);
                System.out.printf("     3|  %3d   %3d   %3d\n",costs[3][0], costs[3][1],costs[3][3]);
                break;
            case 3:
                System.out.printf("                via     \n");
                System.out.printf("   D3 |    1     2 \n");
                System.out.printf("  ----|-----------------\n");
                System.out.printf("     0|  %3d   %3d\n",costs[0][1],costs[0][2]);
                System.out.printf("dest 1|  %3d   %3d\n",costs[1][1],costs[1][2]);
                System.out.printf("     2|  %3d   %3d\n",costs[2][1],costs[2][2]);
                break;
        }
    }

}