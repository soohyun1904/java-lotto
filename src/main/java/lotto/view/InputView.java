package lotto.view;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView(){};
    private static List<Integer> winningNumberList;
    private static final String INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE="구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBER_MESSAGE="당첨 번호를 입력해 주세요";
    private static final String INPUT_LOTTO_BONUS_NUMBER_MESSAGE="보너스 번호를 입력해 주세요";
    public static String inputPlayerAmount(){
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }
    public static List<Integer> inputWinningNum(){
        System.out.println(INPUT_LOTTO_WINNING_NUMBER_MESSAGE);
        return numberList(Console.readLine());
    }
    public static int inputLottoBonusNum(){
        System.out.println(INPUT_LOTTO_BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
    private static List<Integer> numberList(String Num) {
        String[] result = Num.split(",");
        winningNumberList= new ArrayList();
        for(int i=0;i<result.length;i++){
            winningNumberList.add(ConvertToInt(result[i]));
        }
        return winningNumberList;
    }

    private static int ConvertToInt(String Num) {
        try{
            return Integer.parseInt(Num);
        }catch (NumberFormatException e){
            ExeptionMessage.typeException();
            throw new IllegalStateException();
        }
    }
}
