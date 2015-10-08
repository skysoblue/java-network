package thread;

public class SingleThread extends Thread{
	public static void main(String[] args) {
		SingleThread st = new SingleThread("첫번째");
		st.start();  // 쓰레드를 runable 상태로 호출
		/**
		 * 주의할 점.
		 * 개발자가 코딩한 아래 run() 메소드를 호출하는 것이 아니라
		 * 상속받은 start() 메소드를 호출하고, 이 start()메소드가
		 * 아래 구현한  run() 메소드를 호출하는 모양을 이해해야 함.
		 */
	}
	private int[] temp ;
	public SingleThread(String threadName) {
		super(threadName);
		temp = new int[3];
		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
	}
	public void run() {
		for (int start : temp) {
			try {
				sleep(10000); // 10초
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.printf("스레드 이름 : %s," , currentThread().getName());
			// printf 는 println 과 다르다. %s 문자열, %d 10진수, %n 숫자 가 그 자리에 와야 함을 뜻함)
			System.out.printf("임시값 : %d %n", start);
		}
	}
}
