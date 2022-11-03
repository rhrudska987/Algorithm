package algorithm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class clock {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		try { 																 //파일을 읽어올 수 없는 경우 예외처리
			File file = new File("C:\\Users\\KoKyungNam\\Desktop\\1.in");    //주어진 파일 읽어옴
			Scanner sc = new Scanner(file); 							     //파일 객체 생성 후 넣어줌
			while(sc.hasNextLine()) { 									     //다음 줄이 있는지 확인
				int temp  = sc.nextInt();								     //해당 줄의 값을 정수로 가져옴
				list.add(temp);											     //읽어온 값을 리스트에 저장
			}
		} catch (Exception e) {											     //예외처리
			e.printStackTrace();										     //에러의 발생근원지를 찾아서 단계별로 에러를 출력
		}
		
		Integer[] arr = list.toArray(Integer[] :: new);					     //리스트를 배열로 바꿈
		
		double start = System.currentTimeMillis();						     //코드 시작시간
		for(int i=0; i<arr.length; i++) {
			if (arr[i] == 2839004)										     //i번째 배열의 값이 찾고자하는 값과 일치하면 반복문 종료
				break;
		}
		
		double stop = System.currentTimeMillis();						     //코드 종료시간
		String result = String.format("%.6f", (double)(stop - start) / 1000);//코드 수행에 소요된 시간을 소수점 6자리까지 계산
		System.out.println("걸린 시간은 " + result + "초입니다.");			     //코드 수행에 소요된 시간 출력
	}
}