package com.mintchoco.mapper;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        do {
            System.out.println("=========== 민초레일 운행 사이트 ===========");
            System.out.println("1. 회원");
            System.out.println("2. 기차");
            System.out.println("3. 예매티켓");
            System.out.println("번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: break;
                case 2: break;
                case 3: break;
            }
        } while (true);
    }
}
