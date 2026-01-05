package leetcode.top150.arraystring;

public class Q121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // 매수가격 저장해두고
        int buyPrice = Integer.MAX_VALUE;
        // prices 순회 -> 매수가격보다 작으면 매수, 크다면 매도 최대값 갱신
        int maxProfit = 0;
        for(int price : prices) {
            if(price < buyPrice) {
                buyPrice = price;
            }
            else if(price > buyPrice) {
                maxProfit = Math.max(maxProfit, price - buyPrice);
            }
        }
        // 순회 끝
        // 매도 최대값 반환
        return maxProfit;
    }
}
