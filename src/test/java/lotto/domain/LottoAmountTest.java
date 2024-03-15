package lotto.domain;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottoAmountTest {
    @Test
    public void 숫자_사용_안함() {
        assertThatThrownBy(() -> new PlayerLottoAmount("1000e"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void 천원_단위_아님() {
        assertThatThrownBy(() -> new PlayerLottoAmount("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void 영보다_작음() {
        assertThatThrownBy(() -> new PlayerLottoAmount("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void 구매_로또수(){
        PlayerLottoAmount playerLottoAmount=new PlayerLottoAmount("1000");
        assertThat(playerLottoAmount.calculateLottoCount()).isEqualTo(1);
    }
}
