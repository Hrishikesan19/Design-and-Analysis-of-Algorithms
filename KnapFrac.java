import java.util.*;
public class KnapFrac{
    static class items{
        int weight;
        int profit;
        double ratio;
        public items(int weight, int profit)
        {
            this.weight = weight;
            this.profit = profit;
            this.ratio = (double)profit/weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No.of Items:");
        int n = sc.nextInt();
        System.out.println("Enter Knapsack Size:");
        int bagsize = sc.nextInt();
        System.out.println("Enter the weights:");
        items[] item = new items[n];
        for(int i = 0;i<n;i++)
        {
            int weight = sc.nextInt();
            item[i] = new items(weight, 0);
        }
        System.out.println("enter the profits:");
        for(int i = 0;i<n;i++)
        {
            int profit = sc.nextInt();
            item[i].profit = profit;
           // item[i].ratio = (double) profit / item[i].weight;
        }
        Arrays.sort(item,(a,b)->Double.compare(a.ratio , b.ratio));
        Double totprof = 0.0;
        int i = 0;
        while(bagsize>0 && i<n)
        {
            if(bagsize>=item[i].weight)
            {
                bagsize-=item[i].weight;
                totprof+=item[i].profit;
            }
            else{
                totprof+=item[i].profit*((double)bagsize/item[i].weight);
                bagsize = 0;
            }
            i++;
        }
        System.out.println(totprof);


    }
}