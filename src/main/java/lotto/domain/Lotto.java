package lotto.domain;

import lotto.view.ExeptionMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        validateRange(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream().
                filter(winningLotto::containNumber).
                count();
    }

    public boolean containNumber(int number) {

        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExeptionMessage.sizeException();
            throw new IllegalArgumentException();
        }
    }
    private void validateOverlap(List<Integer> numbers){
        Set<Integer> overlapCheck= new HashSet<>();
        for(int i=0;i<numbers.size();i++){
            overlapCheck.add(numbers.get(i));
        }
        if(overlapCheck.size()!=6){
            ExeptionMessage.overlapException();
            throw new IllegalArgumentException();
        }
    }
    private void validateRange(List<Integer> numbers) {
        for(int winningNumber=0;winningNumber<numbers.size();winningNumber++){
            if (numbers.get(winningNumber) < MIN_NUMBER || numbers.get(winningNumber) > MAX_NUMBER) {
                ExeptionMessage.rangeException();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            ExeptionMessage.overlapException();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
