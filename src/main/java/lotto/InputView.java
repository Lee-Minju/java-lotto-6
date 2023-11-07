package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Customer;

public class InputView {
    // 구입금액을 입력받기
    // -> 구입금액을 문자열로 입력받음 -> 이거를 정수로 바꿈 -> 천단위인지 검사 -> 천단위 아니면 예외 -> 맞으면 정수로 저장 -> 이 정수횟수만큼 로또를 발행 -> 이거를 커스토머의 포켓에 저장
    //    Input.buyLottoInput   |                                                               |                                                |

    public Integer buyLottoInput() {
        System.out.println("구입금액을 입력해 주세요");
        Integer money = Integer.parseInt(Console.readLine());

        return money;
    }

    public Integer moneyValidate(Integer money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException() ;
        }
        return (money / 1000);
    }
    // 당첨번호를 입력받기

    public void makingLotto(Customer customer){
        try{
            Integer lottoamount = moneyValidate(buyLottoInput());
            for(int i=0; i<lottoamount; i++){
                List<Integer> tmp = new ArrayList<>(6);
                for(int j=0; j<6; j++){
                    Integer rndnum = Randoms.pickNumberInRange(1,45);
                    tmp.add(rndnum);
                }
                Lotto lotto6 = new Lotto(tmp);
                customer.addPocket(lotto6);
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            makingLotto(customer);
        }
    }


}