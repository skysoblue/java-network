package thread;

import java.util.Random;

public class SnailRace2 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("경주 시작");
		System.out.println("달팽이들 출발 준비....");
		Runnable s1 = new Snail2("성한");
		Runnable s2 = new Snail2("순환");
		Runnable s3 = new Snail2("준규");
		Runnable s4 = new Snail2("혜숙");
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		Thread t3 = new Thread(s3);
		Thread t4 = new Thread(s4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		// 달팽이들이 경기를 마치기 전까지는 main() 쓰레드를 
		// 종료시키면 안되기 때문에 블락(걸어잠근다)시켜야 하므로
		// join() 을 호출한다.
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		System.out.println("달팽이 경주 종료");
	}
}
class Snail2 implements Runnable{
	
	public Snail2(String name) {
	}
	
	@Override
	public void run() {
		Random r  = new Random();
		for (int i = 0; i <= 100; i++) {
			int randomNum = r.nextInt(501); // 1부터 500까지 램덤 숫자 발생
			try {
				Thread.sleep(randomNum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"달팽이"+i+" 미터 전진");
		}
		System.out.println(Thread.currentThread().getName()+"달팽이가 결승점을 통과합니다.!!");
	}
}
