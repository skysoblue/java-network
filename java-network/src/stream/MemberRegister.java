package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

/**
 * @file_name : MemberRegister.java 
 * @author    : coolbeat@naver.com
 * @date      : 2015. 10. 8.
 * @story     : 회원등록 프로그램
 */
public class MemberRegister {
	/**
	 * 신규회원 가입 프로그램입니다.
	 * 저장은 외부에 바탕화면에 member 라는 폴더 밑에
	 * 아이디.txt 로 저장해주시고
	 * 만약, 아이디.txt 가 존재한다면, 이미 등록된 회원입니다 라고 띄워주세요
	 * 존재하지 않다면 해당아이디.txt 파일을 생성합니다.
	 * hong.txt 홍길동 인적정보파일
	 * lee.txt  이순신 인적정보파일
	 * 해당 회원이 회원가입한 날짜시간 2015-10-08 4:18 오후 까지 저장시켜주세요.
	 * [결과]
	 * hong.txt
	 * 아이디 : hong
	 * 비밀번호 : 1234
	 * 이름 : 홍길동
	 * 가입일 : 2015-10-08 4:18 오후
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		String pass = scanner.next();
		String name = scanner.next();
		String fileName = "C:\\Users\\HB02\\Documents\\member\\"+id+".txt", buffer = "";
		BufferedWriter bw;
		BufferedReader br;
		File file = new File(fileName);
		
		// 파일이 존재하는지 여부를 체크해서, 없으면 만들고
		// 있으면 스캐너가 입력받은 정보를  txt 파일에 기재한다.
		if (!file.exists()) {
			// 파일을 생성하고
			try {
				bw = new BufferedWriter(new FileWriter(new File(fileName)));
				bw.write("아이디 :" + id);
				bw.newLine(); // System.out.println();
				bw.write("비밀번호 : "+pass);
				bw.newLine(); 
				bw.write("이름 : "+name);
				bw.newLine(); 
				bw.close(); // 항상 닫아 주어야 저장이 됨..카톡에서 문자를 쓰고 엔터를 누르는 것과 동일
				// System.out.println("홍길동님 회원가입 되었습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				br = new BufferedReader(new FileReader(new File(fileName)));
				while ((buffer = br.readLine()) != null) {  // 읽어들인 내용 끝까지
					System.out.println(buffer);
				}
				br.close(); // 마찬가지로 꼭 닫아야 함
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
class Member implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String pass;
	private String name;
	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public String getName() {
		return name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}