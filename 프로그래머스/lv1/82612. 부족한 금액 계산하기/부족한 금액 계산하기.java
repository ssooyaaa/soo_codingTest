class Solution {
    public long solution(int price, int money, int count) {
        Long priceLong = new Long(price);
        Long moneyLong = new Long(money);
        Long countLong = new Long(count);
        
        long total = 0L;
        long answer = 0L;
        
        for(int i=1;i<=count;i++){
            Long iLong = new Long(i);
            total += priceLong*iLong;
        }
        
        if(moneyLong < total){
            answer = total - moneyLong;
        }else{
            answer = 0L;
        }
        
        

        return answer;
    }
}