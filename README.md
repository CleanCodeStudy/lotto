1. 로또 번호를 발급한다 ---> LotteNumberGenerator  - o
- input: 구입금액

2. 지난주 로또 번호와 비교하여 3-6개 사이 일치하는 개수를 반환한다.

3. 총 수익률을 계산한다. 



**view**
- 구입금액을 입력받는다 (1) - o
- 지난주 당첨번호를 입력받는다 (4) - o 
- 보너스 번호를 입력받는다 (5) - o


- 구매 갯수를 출력한다. (2)
- 로또 랜덤을 출력한다(3)
- 3-6개까지 일치하는 개수를 출력한다 (6)
- 수익률을 출한다 (7)



질문)
1. LottoTicket은 AutoLottoNumberGenerator에 의해서만 발행된다.
하지만 생성잔느 public하게 열려있다. 그래서 사이즈 체크 검증을 추가했고 그 결과
private static final int COUNT_OF_LOTTO_NUMBER = 6;

가 중복된다.


2.  this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);

add시 발생하는 UnsupportedOperationException 는 그냥 던지게 남겨두면 되는건가 

3. LottoTicket 일급컬렉션의 검증은 어디까지?
