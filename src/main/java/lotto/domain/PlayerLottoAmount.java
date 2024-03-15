package lotto.domain;

import lotto.view.ExeptionMessage;

public class PlayerLottoAmount {
    private static final int LOTTO_MIN_AMOUNT = 1000;
    private final int amount;

    public PlayerLottoAmount(String amount) {
        int amountNum = validateNum(amount);
        validateAmount(amountNum);
        this.amount=amountNum;
    }
    public int calculateLottoCount(){
        return amount/LOTTO_MIN_AMOUNT;
    }
    private void validateAmount(int amount){
        validateNatural(amount);
        validateDivisible(amount);
    }
    private static int validateNum(String amount) throws IllegalArgumentException{
        try{
            return Integer.parseInt(amount);
        }
        catch (NumberFormatException e){
            ExeptionMessage.numberException();
            throw new IllegalArgumentException();
        }
    }
    private void validateNatural(int amount){
        if(amount<=0){
            ExeptionMessage.naturalException();
            throw new IllegalArgumentException();
        }
    }

    private void validateDivisible(int amount){
        if (amount%LOTTO_MIN_AMOUNT!=0){
            ExeptionMessage.divisibleException();
            throw new IllegalArgumentException();
        }
    }

}
