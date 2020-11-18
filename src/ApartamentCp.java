import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ApartamentCp {

    private BigDecimal totalValueOfApartmentGross;
    private BigDecimal equipmentValueOfApartmentGross;
    private static final BigDecimal RENTPERCENT7 = new BigDecimal(7);
    private static final BigDecimal VAT23 = new BigDecimal(123);
    private static final BigDecimal VAT8 = new BigDecimal(108);
    private static final BigDecimal MULTI100 = new BigDecimal(100);

    MathContext mc = new MathContext(8);


    public ApartamentCp(BigDecimal totalValueOfApartmentGross, BigDecimal equipmentValueOfApartmentGross) {
        this.totalValueOfApartmentGross = totalValueOfApartmentGross;
        this.equipmentValueOfApartmentGross = equipmentValueOfApartmentGross;
    }

    public BigDecimal calculateValueOfApartmentGrossWithOutEquipment(){
        return totalValueOfApartmentGross.subtract(equipmentValueOfApartmentGross, mc);

    }

    public BigDecimal calculateValueOfApartmentNetWithOutEquipment(){
        return calculateValueOfApartmentGrossWithOutEquipment().multiply(MULTI100).divide(VAT23, 2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal calculateValueOfEquipmentNet(){
        BigDecimal netEquipment;
        netEquipment = (equipmentValueOfApartmentGross.divide(VAT23, RoundingMode.CEILING)).multiply(MULTI100);
        return netEquipment;
    }

    public BigDecimal calculateValueOfApartmentAndEquipmentNet(){
        return calculateValueOfApartmentNetWithOutEquipment().add(calculateValueOfEquipmentNet());
    }

    public BigDecimal calculateValueOfAnnualRentPayment(){
        return (calculateValueOfApartmentAndEquipmentNet().multiply(RENTPERCENT7))
                .divide(MULTI100, 2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal calculateValueOfMonthRentPayment(){
        return calculateValueOfAnnualRentPayment().divide(new BigDecimal(12), 2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal calculateValueOfThreeMonthRentPayment(){
        return calculateValueOfMonthRentPayment().multiply(new BigDecimal(3));
    }

    @Override
    public String toString() {
        return "ApartamentCp{" +
                "totalValueOfApartmentGross=" + totalValueOfApartmentGross +
                ", equipmentValueOfApartmentGross=" + equipmentValueOfApartmentGross +
                '}';
    }
}
