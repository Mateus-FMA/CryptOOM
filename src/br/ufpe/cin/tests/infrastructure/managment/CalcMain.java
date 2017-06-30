package br.ufpe.cin.tests.infrastructure.managment;

/**
 * Created by Guilherme on 29/06/2017.
 */
public class CalcMain {
    public static void main(String[] args) throws Exception {
        CalcProxy c = new CalcProxy(InvokerTest.CALCULATOR_AOR);
        while(true) {
            System.out.println(c.add(1, 2));
//            Thread.sleep(100);
        }
    }
}
