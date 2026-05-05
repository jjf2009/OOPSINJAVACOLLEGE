import java.util.Scanner;

interface SolarPowered {
    default double calculateCostPerUnit() {
        return 2.5;
    }
}

interface GridPowered {
    default double calculateCostPerUnit() {
        return 7.0;
    }
}

abstract class HybridHome implements SolarPowered, GridPowered {
    private double solarUsagePercent;
    private double gridUsagePercent;

    HybridHome(double solarUsagePercent, double gridUsagePercent) {
        this.solarUsagePercent = solarUsagePercent;
        this.gridUsagePercent = gridUsagePercent;
    }


    public double getSolarUsagePercent() {
        return solarUsagePercent;
    }

    public void setSolarUsagePercent(double solarUsagePercent) {
        this.solarUsagePercent = solarUsagePercent;
    }

    public double getGridUsagePercent() {
        return gridUsagePercent;
    }

    public void setGridUsagePercent(double gridUsagePercent) {
        this.gridUsagePercent = gridUsagePercent;
    }

    public double solarBaseRate() {
        return SolarPowered.super.calculateCostPerUnit();
    }

    public double gridBaseRate() {
        return GridPowered.super.calculateCostPerUnit();
    }

    @Override
    public double calculateCostPerUnit() {
        double totalUsage = solarUsagePercent + gridUsagePercent;
        if (totalUsage <= 0) {
            return 0.0;
        }
        double solarShare = solarUsagePercent / totalUsage;
        double gridShare = gridUsagePercent / totalUsage;
        return (solarShare * solarBaseRate()) + (gridShare * gridBaseRate());
    }

    public double calculateSolarUnits(double totalUnits) {
        double totalUsage = solarUsagePercent + gridUsagePercent;
        if (totalUsage <= 0) {
            return 0.0;
        }
        return totalUnits * (solarUsagePercent / totalUsage);
    }

    public double calculateGridUnits(double totalUnits) {
        double totalUsage = solarUsagePercent + gridUsagePercent;
        if (totalUsage <= 0) {
            return 0.0;
        }
        return totalUnits * (gridUsagePercent / totalUsage);
    }

    public double calculateCarbonFootprint(double totalUnits) {
        return calculateGridUnits(totalUnits) * 0.82;
    }

    public abstract double monthlyBill(double units);

    @Override
    public String toString() {
        return String.format(
                "Hybrid Home Details%nSolar Usage (%%)    : %.2f%nGrid Usage (%%)     : %.2f%nSolar Rate (Rs/u)  : %.2f%nGrid Rate (Rs/u)   : %.2f%nWeighted Rate (Rs/u): %.2f",
                solarUsagePercent, gridUsagePercent, solarBaseRate(), gridBaseRate(), calculateCostPerUnit());
    }
}

public class EnergyConsumptionMonitorSystem {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Energy Consumption Monitor ===");

            System.out.print("Enter solar usage percentage: ");
            double solarUsagePercent = sc.nextDouble();

            System.out.print("Enter grid usage percentage: ");
            double gridUsagePercent = sc.nextDouble();

            System.out.print("Enter monthly units consumed: ");
            double units = sc.nextDouble();

            HybridHome home = new HybridHome(solarUsagePercent, gridUsagePercent) {
                @Override
                public double monthlyBill(double unitsConsumed) {
                    return unitsConsumed * calculateCostPerUnit();
                }
            };

            System.out.println();
            System.out.println(home);
            System.out.printf("Monthly Bill         : Rs. %.2f%n", home.monthlyBill(units));
            System.out.printf("Solar Energy Used    : %.2f units%n", home.calculateSolarUnits(units));
            System.out.printf("Grid Energy Used     : %.2f units%n", home.calculateGridUnits(units));
            System.out.printf("Carbon Footprint     : %.2f kg CO2%n", home.calculateCarbonFootprint(units));
        }
    }
}