package lotto.view;

public class OutputView {
    public OutputView(){
    }
    public static void printTicketCount(int count){
        System.out.println(count+"개를 구입했습니다.");
    }
    public static void printSucessResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    public static void printSuccessMessage(String message, int numberOfMatch){
        System.out.println(message + numberOfMatch +"개");
    }
    public static void printRevenueRate(double EarningRage){
        System.out.println("총 수익률은 " + String.format("%.1f",EarningRage)+"%입니다.");
    }
}
