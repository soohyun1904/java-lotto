package lotto.domain;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoNumberTest {
    private static List<Integer> lottoNumberList;

    @Test
    void 로또_랜덤숫자_생성(){
        LottoNumbers lottoNumbers =new LottoNumbers();
        lottoNumberList=lottoNumbers.setRandomNumbers();
        Assertions.assertThat(lottoNumberList.size()).isEqualTo(6);
    }
}
