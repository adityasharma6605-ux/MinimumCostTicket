class Solution {
    private int linearsearch(int index,int[] days,int searchValue){
        while(index<days.length){
            if(days[index]>=searchValue){
                break;
            }
            ++index;
        }
        return index;
    }
    public int helper(int index,int[] days,int[] costs,int[] dp){
        if(index==days.length){
            return 0;
        }
        if(dp[index]!=0){
            return dp[index];
        }
        int onedayPass=costs[0]+helper(index+1,days,costs,dp);
        int searchValue=days[index]+7;
        int searchIndex=linearsearch(index,days,searchValue);
        int seconddayPass=costs[1]+helper(searchIndex,days,costs,dp);

        searchValue=days[index]+30;
        searchIndex=linearsearch(index,days,searchValue);
        int thirddayPass=costs[2]+helper(searchIndex,days,costs,dp);
        int Mincost=Math.min(onedayPass,Math.min(seconddayPass,thirddayPass));
        dp[index]=Mincost;
        return Mincost;        
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[days.length]; 
        return helper(0,days,costs,dp);
    }
}
