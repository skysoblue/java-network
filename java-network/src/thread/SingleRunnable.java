package thread;

public class SingleRunnable implements Runnable{
	private int[] temp ;
	public SingleRunnable() {
		temp = new int[3];
		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
	}
	@Override
	public void run() {
		for (int start : temp) {
			try {
				Thread.sleep(3000); // 10초
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.printf("스레드 이름 : %s," , Thread.currentThread().getName());
			// printf 는 println 과 다르다. %s 문자열, %d 10진수, %n 숫자 가 그 자리에 와야 함을 뜻함)
			System.out.printf("임시값 : %d %n", start);
		}
	}
	

}
