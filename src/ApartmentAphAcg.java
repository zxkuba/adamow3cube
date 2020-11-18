import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ApartmentAphAcg {

    private BigDecimal totalValueOfApartmentGross;
    private BigDecimal equipmentValueOfApartmentGross;
    private BigDecimal parkingValue;
    private BigDecimal roadValue;
    private BigDecimal rentPercent; //7, 6, 5,5
    private static final BigDecimal VAT23 = new BigDecimal(123);
    private static final BigDecimal VAT8 = new BigDecimal(108);
    private static final BigDecimal MULTI100 = new BigDecimal(100);

    MathContext mc = new MathContext(8);


    public ApartmentAphAcg(BigDecimal totalValueOfApartmentGross, BigDecimal equipmentValueOfApartmentGross, BigDecimal parkingValue, BigDecimal roadValue, BigDecimal rentPercent) {
        this.totalValueOfApartmentGross = totalValueOfApartmentGross;
        this.equipmentValueOfApartmentGross = equipmentValueOfApartmentGross;
        this.parkingValue = parkingValue;
        this.roadValue = roadValue;
        this.rentPercent = rentPercent;

    }

    public BigDecimal calculateValueOfApartmentGrossWithOutEquipment(){
        BigDecimal subtract;
        subtract = totalValueOfApartmentGross.subtract(equipmentValueOfApartmentGross, mc);
        return subtract;
    }

    public BigDecimal calculateValueOfApartmentGrossWithOutParkingPlaceAndRoad(){
        BigDecimal grossAfterSubtract;
        grossAfterSubtract = calculateValueOfApartmentGrossWithOutEquipment().subtract(parkingValue, mc).subtract(roadValue, mc);
        return grossAfterSubtract;
    }

    public BigDecimal calculateValueOfApartmentNetWithOutParkingAndRoad(){
        BigDecimal netAfterSubtract;
        netAfterSubtract = calculateValueOfApartmentGrossWithOutParkingPlaceAndRoad().multiply(MULTI100).divide(VAT8, 2, RoundingMode.HALF_EVEN);
        return netAfterSubtract;
    }

    public BigDecimal calculateValueOfParkingNet(){
        BigDecimal parkingNet;
        parkingNet = parkingValue.multiply(MULTI100).divide(VAT23, 2, RoundingMode.HALF_EVEN);
        return parkingNet;
    }

    public BigDecimal calculateValueOfRoadNett(){
        BigDecimal roadNet;
        roadNet = roadValue.multiply(MULTI100).divide(VAT23, RoundingMode.CEILING);
        return roadNet;
    }

    public BigDecimal calculateVatValueOfApartmentWithOutEquipment(){
        return calculateValueOfApartmentGrossWithOutEquipment().subtract(calculateValueOfApartmentNetWithOutParkingAndRoad());
    }

    public BigDecimal calculateVatValueOfParking(){
        return parkingValue.subtract(calculateValueOfParkingNet());
    }

    public BigDecimal calculateVatValueOfRoad(){
        return roadValue.subtract(calculateValueOfParkingNet());
    }

    public BigDecimal calculateValueOfEquipmentNet(){
        BigDecimal netEquipment;
        netEquipment = (equipmentValueOfApartmentGross.divide(VAT23, RoundingMode.CEILING)).multiply(MULTI100);
        return netEquipment;
    }

    public BigDecimal calculateValueOfApartmentAndEquipmentNet(){
        return calculateValueOfApartmentNetWithOutParkingAndRoad().add(calculateValueOfParkingNet())
                .add(calculateValueOfRoadNett()).add(calculateValueOfEquipmentNet());
    }

    public BigDecimal calculateValueOfAnnualRentPayment(){
        return (calculateValueOfApartmentAndEquipmentNet().multiply(rentPercent)).divide(MULTI100, 2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal calculateValueOfMonthRentPayment(){
        return calculateValueOfAnnualRentPayment().divide(new BigDecimal(12), 0, RoundingMode.HALF_EVEN);
    }

    public BigDecimal calculateValueOfThreeMonthRentPayment(){
        return calculateValueOfMonthRentPayment().multiply(new BigDecimal(3));
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "totalValueOfApartmentGross=" + totalValueOfApartmentGross +
                ", equipmentValueOfApartmentGross=" + equipmentValueOfApartmentGross +
                ", parkingValue=" + parkingValue +
                ", roadValue=" + roadValue +
                ", rentPercent=" + rentPercent +
                '}';
    }
}
