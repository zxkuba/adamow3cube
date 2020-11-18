import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {

         ApartmentAphAcg apartmentAphAcg1 = new ApartmentAphAcg(new BigDecimal(656500), new BigDecimal(51660), new BigDecimal(12300),
                 new BigDecimal(1230), new BigDecimal(7));

         ApartamentCp apartmentCp1 = new ApartamentCp(new BigDecimal(712204.45), new BigDecimal(36900));

         //APH_ACG
         BigDecimal step1 = apartmentAphAcg1.calculateValueOfApartmentGrossWithOutEquipment();
         BigDecimal step2 = apartmentAphAcg1.calculateValueOfApartmentGrossWithOutParkingPlaceAndRoad();
         BigDecimal step3 = apartmentAphAcg1.calculateValueOfApartmentNetWithOutParkingAndRoad();
         BigDecimal step4 = apartmentAphAcg1.calculateValueOfParkingNet();
         BigDecimal step5 = apartmentAphAcg1.calculateValueOfRoadNett();
         BigDecimal step6 = apartmentAphAcg1.calculateValueOfEquipmentNet();
         BigDecimal step7 = apartmentAphAcg1.calculateValueOfApartmentAndEquipmentNet();
         BigDecimal step8 = apartmentAphAcg1.calculateValueOfAnnualRentPayment();
         BigDecimal step9 = apartmentAphAcg1.calculateValueOfMonthRentPayment();
         BigDecimal step10 = apartmentAphAcg1.calculateValueOfThreeMonthRentPayment();

         BigDecimal step1Cp = apartmentCp1.calculateValueOfApartmentGrossWithOutEquipment();
         BigDecimal step2Cp = apartmentCp1.calculateValueOfApartmentNetWithOutEquipment();
         BigDecimal step3Cp = apartmentCp1.calculateValueOfEquipmentNet();
         BigDecimal step4CP = apartmentCp1.calculateValueOfApartmentAndEquipmentNet();
         BigDecimal step5Cp = apartmentCp1.calculateValueOfAnnualRentPayment();
         BigDecimal step6Cp = apartmentCp1.calculateValueOfMonthRentPayment();
         BigDecimal step7Cp = apartmentCp1.calculateValueOfThreeMonthRentPayment();

        System.out.println("CP");


        System.out.println("CP_Wartość apartamentu brutto bez wyposażenie -" + step1Cp);
        System.out.println("CP_Wartość apartamentu netto bez wyposażenia -" + step2Cp);
        System.out.println("CP_Wartość wyposażenia netto -" + step3Cp);
        System.out.println("CP_Wartość apartamentu i wyposażenie netto -" + step4CP);
        System.out.println("CP_Wartosć czynnszu w saklai roku (7%) -" + step5Cp);
        System.out.println("CP_Wartość czynnszu miesięczna (7%) -" + step6Cp);
        System.out.println("CP_Wartość czynszu 3xmiesiące (7%) -" + step7Cp);


        System.out.println();
        System.out.println("APH_ACG");

        System.out.println("APH_Wartość apartamentu brutto bez wyposażenie -" + step1);
        System.out.println("APH_Wartość apartamentu brutto bez wyposażenia, parkingu, drogi -" + step2);
        System.out.println("APH_Wartość apartamentu netto bez wyposażenia, parkingu, drogi -" + step3);
        System.out.println("APH_Wartość parkingu netto -" + step4);
        System.out.println("APH_Wartość drogi netto -" + step5);
        System.out.println("APH_Wartość wyposażenia netto -" + step6);
        System.out.println("APH_Wartość apartamentu i wyposażenie netto -" + step7);
        System.out.println("APH_Wartosć czynnszu w saklai roku (7%) -" +step8);
        System.out.println("APH_Wartość czynnszu miesięczna (7%) -" +step9);
        System.out.println("APH_Wartość czynszu 3xmiesiące (7%) -" + step10);





    }
}
