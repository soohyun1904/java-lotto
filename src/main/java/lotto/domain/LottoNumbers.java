package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumbers {
    public LottoNumbers(){
    }
    private static final int LOTTO_NUMBER_CNT=6;
    private static final int MIN_LOTTO_NUMBER=1;
    private static final int MAX_LOTTO_NUMBER=45;
    private static List<Integer> lottoNumberList;

    public static List<Integer> setRandomNumbers(){
        lottoNumberList = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_CNT);
        List<Integer> lottoTicketNumberList = new ArrayList<>(lottoNumberList);
        Collections.sort(lottoTicketNumberList);
        return lottoTicketNumberList;

    }

}
