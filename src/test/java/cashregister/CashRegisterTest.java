package cashregister;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {

        //given
        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);
        Item itemList[]=new Item[1];
        for (int i = 0; i <1 ; i++) {
            itemList[i]=new  Item("apple", 15.5);
        }
        Purchase purchase = new Purchase(itemList);

        //when
        cashRegister.process(purchase);

        //then
        verify(printer).print("apple"+"\t"+15.5+"\n");

    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {

        //given
        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);
        Purchase purchase=mock(Purchase.class);

        //when
        when(purchase.asString()).thenReturn("doing something");
        cashRegister.process(purchase);

        //then
        verify(printer,times(1)).print("doing something");
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);
        Item itemList[]=new Item[1];
        for (int i = 0; i <1 ; i++) {
            itemList[i]=new  Item("apple", 15.5);
        }
        Purchase purchase = new Purchase(itemList);

        //when
        cashRegister.process(purchase);

        //then
        verify(printer).print("apple"+"\t"+15.5+"\n");
    }

}
