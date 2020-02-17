package br.com.codenation.desafioexe;

import java.util.List;
import java.util.ArrayList;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);

		for (int i = 1; i < 352 ; i = (int) list.get(list.size() - 1)) {
			int nextNum = (int) list.get(list.size() - 1) + (int) list.get(list.size() - 2);
			list.add(nextNum);
		}
		
		return list;
	}

	public static Boolean isFibonacci(Integer a) {
		List listFibonacci = fibonacci();

		return listFibonacci.indexOf(a) != -1;
	}

}