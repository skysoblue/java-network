package synch;
/**
 * @file_name : ATM.java 
 * @author    : coolbeat@naver.com
 * @date      : 2015. 10. 8.
 * @story     : 동기화 관련 예제
 */
public class AtmMain {
	/**
	 * 동기화(synchronized)
	 * - 한개의 공유자원을 여러개의 스레드가 이용할 때
	 * - 해당 스레드만 제외하고, 나머지는 접근하지 못하도록 막는 것.
	 * - 이 것을 락(lock) 이라고 한다
	 * - 자바 동기화는  synchronized 키워드를 사용한다.
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
		Runnable hong = new AtmUser(atm, "홍길동");
		Runnable kim = new AtmUser(atm, "김유신");
		Runnable lee = new AtmUser(atm, "이순신");
		
		Thread t1 = new Thread(hong);
		Thread t2 = new Thread(kim);
		Thread t3 = new Thread(lee);
		t1.start();
		t2.start();
		t3.start();
	}
}
class ATM{
	public synchronized void withdraw(String name) {
		System.out.println(name + "고객이 돈 인출을 요청함");
		for (int i = 0; i < 1000000; i++) {
			if (i==10000) {
				System.out.println(name+" 님이 돈을 인출함");
			}
		}
		System.out.println(name + " 님이 돈을 인출한 후 ATM을 나감");
	}
}
class AtmUser implements Runnable{
	ATM atm;  // 스레드가 특정 객체를 공유하는 모양
	String name;
	public AtmUser(ATM atm, String name) {
		super(); // 부모 기능을 그대로 가져다 사용하겠다.
		this.atm = atm;
		this.name = name;
	}
	@Override
	public void run() {
		atm.withdraw(name);
	}
}