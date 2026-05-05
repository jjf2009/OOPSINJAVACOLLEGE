import java.util.Arrays;
import java.util.Scanner;

interface PowerGenerable {
    double generatePower(double inputResource);

    default double transmissionLoss(double generatedKWh, double distanceKm) {
        return generatedKWh * 0.03 * Math.sqrt(distanceKm);
    }

    default double carbonCredit(double renewablePercent, double totalKWh) {
        return (renewablePercent / 100.0) * totalKWh * 0.82;
    }
}

interface RenewableGenerable extends PowerGenerable {
    double capacityFactor(double actualOutput, double ratedCapacity);

    default double solarOutput(double panelAreaM2, double irradiance, double efficiency) {
        return panelAreaM2 * irradiance * efficiency;
    }

    default double windOutput(double bladeRadius, double windSpeed, double efficiency) {
        return 0.5 * 1.225 * Math.PI * bladeRadius * bladeRadius * Math.pow(windSpeed, 3) * efficiency;
    }
}

interface StorageCapable extends RenewableGenerable {
    double chargeBattery(double excessKWh);

    default double batteryEfficiency(double storedKWh, double retrievedKWh) {
        if (storedKWh == 0) {
            return 0.0;
        }
        return (retrievedKWh / storedKWh) * 100.0;
    }

    default double optimalDischargeTime(double storedKWh, double peakDemandKW) {
        if (peakDemandKW == 0) {
            return 0.0;
        }
        return storedKWh / peakDemandKW;
    }
}

interface GridManageable {
    double regulateVoltage(double currentLoad);

    default double gridFrequency(double activePower, double reactivePower) {
        double denominator = Math.sqrt((activePower * activePower) + (reactivePower * reactivePower));
        if (denominator == 0) {
            return 0.0;
        }
        return activePower / denominator;
    }

    default double peakDemandSurcharge(double peakKW, double avgKW) {
        if (peakKW <= 1.3 * avgKW) {
            return 0.0;
        }
        return peakKW - (1.3 * avgKW);
    }
}

interface LoadBalanceable extends GridManageable {
    double redistributeLoad(double[] zoneLoads);

    default double loadVariance(double[] zoneLoads) {
        if (zoneLoads == null || zoneLoads.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (double zoneLoad : zoneLoads) {
            sum += zoneLoad;
        }

        double mean = sum / zoneLoads.length;
        double variance = 0.0;

        for (double zoneLoad : zoneLoads) {
            variance += Math.pow(zoneLoad - mean, 2);
        }

        return variance / zoneLoads.length;
    }

    default double spilloverRisk(double totalSupply, double totalDemand) {
        if (totalSupply == 0) {
            return 0.0;
        }
        return totalDemand / totalSupply;
    }
}

interface SmartMeteringEnabled extends LoadBalanceable {
    double readMeterData(String zoneId);

    default double timeOfUseBilling(double kWh, String timeSlot) {
        String normalizedTimeSlot = timeSlot == null ? "" : timeSlot.trim().toLowerCase();
        double rate = switch (normalizedTimeSlot) {
            case "off-peak", "offpeak" -> 4.2;
            case "peak" -> 11.5;
            default -> 6.8;
        };

        return kWh * rate;
    }

    default double demandResponseIncentive(double reducedKWh) {
        return reducedKWh * 3.5;
    }
}

class Infrastructure {
    private String facilityId;
    private String location;
    private int commissionedYear;
    private double operationalCost;

    Infrastructure() {
        this("", "", 0, 0.0);
    }

    Infrastructure(String facilityId, String location, int commissionedYear, double operationalCost) {
        this.facilityId = facilityId;
        this.location = location;
        this.commissionedYear = commissionedYear;
        this.operationalCost = operationalCost;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCommissionedYear() {
        return commissionedYear;
    }

    public void setCommissionedYear(int commissionedYear) {
        this.commissionedYear = commissionedYear;
    }

    public double getOperationalCost() {
        return operationalCost;
    }

    public void setOperationalCost(double operationalCost) {
        this.operationalCost = operationalCost;
    }

    public double depreciatedValue(double originalCost, int years) {
        double depreciationRate = 0.05 * Math.max(years, 0);
        double retainedValue = originalCost * (1.0 - depreciationRate);
        return Math.max(0.0, retainedValue);
    }

    public double maintenanceCost(double assetValue) {
        return assetValue * 0.025;
    }

    @Override
    public String toString() {
        return String.format(
            "Infrastructure%nFacility ID      : %s%nLocation         : %s%nCommissioned Year : %d%nOperational Cost : %.2f",
            facilityId, location, commissionedYear, operationalCost);
    }
}

class PowerStation extends Infrastructure implements PowerGenerable, GridManageable {
    private double installedCapacityMW;
    private double currentLoad;
    private double nominalVoltage;
    private double droop;
    private double thermalEfficiency;

    PowerStation() {
        this("", "", 0, 0.0, 0.0, 0.0, 1.0, 0.85, 0.85);
    }

    PowerStation(String facilityId, String location, int commissionedYear, double operationalCost,
                 double installedCapacityMW, double currentLoad,
                 double nominalVoltage, double droop, double thermalEfficiency) {
        super(facilityId, location, commissionedYear, operationalCost);
        this.installedCapacityMW = installedCapacityMW;
        this.currentLoad = currentLoad;
        this.nominalVoltage = nominalVoltage;
        this.droop = droop;
        this.thermalEfficiency = thermalEfficiency;
    }

    public double getInstalledCapacityMW() {
        return installedCapacityMW;
    }

    public void setInstalledCapacityMW(double installedCapacityMW) {
        this.installedCapacityMW = installedCapacityMW;
    }

    public double getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(double currentLoad) {
        this.currentLoad = currentLoad;
    }

    public double getNominalVoltage() {
        return nominalVoltage;
    }

    public void setNominalVoltage(double nominalVoltage) {
        this.nominalVoltage = nominalVoltage;
    }

    public double getDroop() {
        return droop;
    }

    public void setDroop(double droop) {
        this.droop = droop;
    }

    public double getThermalEfficiency() {
        return thermalEfficiency;
    }

    public void setThermalEfficiency(double thermalEfficiency) {
        this.thermalEfficiency = thermalEfficiency;
    }

    @Override
    public double generatePower(double inputResource) {
        return installedCapacityMW * inputResource * thermalEfficiency;
    }

    @Override
    public double regulateVoltage(double currentLoad) {
        if (droop == 0) {
            return nominalVoltage;
        }
        return currentLoad + ((nominalVoltage - currentLoad) / droop);
    }

    public double efficiencyRating() {
        if (installedCapacityMW == 0) {
            return 0.0;
        }
        return (currentLoad / installedCapacityMW) * 100.0;
    }

    @Override
    public String toString() {
        return String.format(
            "%s%nInstalled Capacity : %.2f MW%nCurrent Load       : %.2f%nNominal Voltage    : %.2f%nDroop              : %.2f%nThermal Efficiency : %.2f",
            super.toString(), installedCapacityMW, currentLoad, nominalVoltage, droop, thermalEfficiency);
    }
}

class SmartRenewableGrid extends PowerStation implements StorageCapable, SmartMeteringEnabled {
        private String[] zoneIds;
        private double[][] zoneLoads;
        private double batteryCapacityKWh;
        private double storedBatteryKWh;

    SmartRenewableGrid() {
        this("", "", 0, 0.0, 0.0, 0.0, 1.0, 0.85, 0.85, new String[0], new double[0][0], 0.0, 0.0);
    }

    SmartRenewableGrid(String facilityId, String location, int commissionedYear, double operationalCost,
                   double installedCapacityMW, double currentLoad,
                   double nominalVoltage, double droop, double thermalEfficiency,
                   String[] zoneIds, double[][] zoneLoads, double batteryCapacityKWh, double storedBatteryKWh) {
        super(facilityId, location, commissionedYear, operationalCost, installedCapacityMW,
            currentLoad, nominalVoltage, droop, thermalEfficiency);
        this.zoneIds = zoneIds;
        this.zoneLoads = zoneLoads;
        this.batteryCapacityKWh = batteryCapacityKWh;
        this.storedBatteryKWh = storedBatteryKWh;
    }

    public String[] getZoneIds() {
        return zoneIds;
    }

    public void setZoneIds(String[] zoneIds) {
        this.zoneIds = zoneIds;
    }

    public double[][] getZoneLoads() {
        return zoneLoads;
    }

    public void setZoneLoads(double[][] zoneLoads) {
        this.zoneLoads = zoneLoads;
    }

    public double getBatteryCapacityKWh() {
        return batteryCapacityKWh;
    }

    public void setBatteryCapacityKWh(double batteryCapacityKWh) {
        this.batteryCapacityKWh = batteryCapacityKWh;
    }

    public double getStoredBatteryKWh() {
        return storedBatteryKWh;
    }

    public void setStoredBatteryKWh(double storedBatteryKWh) {
        this.storedBatteryKWh = storedBatteryKWh;
    }

    @Override
    public double transmissionLoss(double generatedKWh, double distanceKm) {
        return super.transmissionLoss(generatedKWh, distanceKm) * 0.85;
    }

    @Override
    public double carbonCredit(double renewablePercent, double totalKWh) {
        return super.carbonCredit(renewablePercent, totalKWh);
    }

    @Override
    public double capacityFactor(double actualOutput, double ratedCapacity) {
        if (ratedCapacity == 0) {
            return 0.0;
        }
        return (actualOutput / ratedCapacity) * 100.0;
    }

    @Override
    public double chargeBattery(double excessKWh) {
        if (excessKWh <= 0 || batteryCapacityKWh <= 0) {
            return storedBatteryKWh;
        }

        storedBatteryKWh = Math.min(batteryCapacityKWh, storedBatteryKWh + excessKWh);
        return storedBatteryKWh;
    }

    @Override
    public double redistributeLoad(double[] zoneLoads) {
        if (zoneLoads == null || zoneLoads.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (double load : zoneLoads) {
            sum += load;
        }

        double fairShare = sum / zoneLoads.length;
        for (int i = 0; i < zoneLoads.length; i++) {
            zoneLoads[i] = fairShare;
        }

        return loadVariance(zoneLoads);
    }

    @Override
    public double readMeterData(String zoneId) {
        if (zoneIds == null || zoneLoads == null || zoneId == null) {
            return 0.0;
        }

        for (int i = 0; i < zoneIds.length; i++) {
            if (zoneId.equalsIgnoreCase(zoneIds[i])) {
                return zoneLoads[i][0] + zoneLoads[i][1] + zoneLoads[i][2];
            }
        }

        return 0.0;
    }

    public double totalZoneDemand() {
        double total = 0.0;
        if (zoneLoads == null) {
            return 0.0;
        }

        for (double[] load : zoneLoads) {
            total += load[0] + load[1] + load[2];
        }

        return total;
    }

    public double totalToUBillingRevenue() {
        double totalRevenue = 0.0;
        if (zoneLoads == null) {
            return 0.0;
        }

        for (double[] load : zoneLoads) {
            totalRevenue += timeOfUseBilling(load[0], "off-peak");
            totalRevenue += timeOfUseBilling(load[1], "shoulder");
            totalRevenue += timeOfUseBilling(load[2], "peak");
        }

        return totalRevenue;
    }

    public double totalDemandResponseSavings(double[] reducedKWhByZone) {
        if (reducedKWhByZone == null) {
            return 0.0;
        }

        double savings = 0.0;
        for (double reducedKWh : reducedKWhByZone) {
            savings += demandResponseIncentive(reducedKWh);
        }
        return savings;
    }

    public double totalDailyRenewableGeneration(double solarBase, double solarIrradianceHours, double solarEfficiency,
                                                double bladeRadius, double windSpeed, double windEfficiency) {
        return solarOutput(solarBase, solarIrradianceHours, solarEfficiency) + windOutput(bladeRadius, windSpeed, windEfficiency);
    }

    public double[] buildBalancedLoadProfile() {
        if (zoneLoads == null || zoneLoads.length == 0) {
            return new double[0];
        }

        double[] loads = new double[zoneLoads.length];
        for (int i = 0; i < zoneLoads.length; i++) {
            loads[i] = zoneLoads[i][0] + zoneLoads[i][1] + zoneLoads[i][2];
        }

        redistributeLoad(loads);
        return loads;
    }

    public double batteryCycles(double chargedKWh, double dischargedKWh) {
        if (batteryCapacityKWh == 0) {
            return 0.0;
        }
        return (chargedKWh + dischargedKWh) / (2.0 * batteryCapacityKWh);
    }

    @Override
    public String toString() {
        return String.format("%s%nBattery Capacity   : %.2f kWh%nStored Battery     : %.2f kWh%nZones              : %s%nLoads              : %s",
                super.toString(), batteryCapacityKWh, storedBatteryKWh, Arrays.toString(zoneIds), Arrays.deepToString(zoneLoads));
    }
}

public class SmartCityEnergyGridManagementSystem {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Smart City Energy Grid Management System ===");

            System.out.print("Enter facility ID: ");
            String facilityId = sc.nextLine();

            System.out.print("Enter location: ");
            String location = sc.nextLine();

            System.out.print("Enter commissioned year: ");
            int commissionedYear = sc.nextInt();

            System.out.print("Enter operational cost per day: ");
            double operationalCost = sc.nextDouble();

            System.out.print("Enter installed capacity (MW): ");
            double installedCapacityMW = sc.nextDouble();

            System.out.print("Enter current load: ");
            double currentLoad = sc.nextDouble();

            System.out.print("Enter nominal voltage: ");
            double nominalVoltage = sc.nextDouble();

            System.out.print("Enter droop value: ");
            double droop = sc.nextDouble();

            System.out.print("Enter thermal efficiency (0-1): ");
            double thermalEfficiency = sc.nextDouble();

            System.out.print("Enter battery capacity (kWh): ");
            double batteryCapacityKWh = sc.nextDouble();

            System.out.print("Enter initial stored battery energy (kWh): ");
            double storedBatteryKWh = sc.nextDouble();

            sc.nextLine();

            System.out.print("Enter number of zones for billing input: ");
            int zoneCount = sc.nextInt();
            sc.nextLine();

            String[] zoneIds = new String[zoneCount];
            double[][] zoneLoads = new double[zoneCount][3];
            double[] reducedKWhByZone = new double[zoneCount];

            for (int i = 0; i < zoneCount; i++) {
                System.out.println();
                System.out.print("Enter zone ID for zone " + (i + 1) + ": ");
                zoneIds[i] = sc.nextLine();

                System.out.print("Enter off-peak kWh for " + zoneIds[i] + ": ");
                zoneLoads[i][0] = sc.nextDouble();

                System.out.print("Enter shoulder kWh for " + zoneIds[i] + ": ");
                zoneLoads[i][1] = sc.nextDouble();

                System.out.print("Enter peak kWh for " + zoneIds[i] + ": ");
                zoneLoads[i][2] = sc.nextDouble();

                System.out.print("Enter reduced kWh eligible for demand response in " + zoneIds[i] + ": ");
                reducedKWhByZone[i] = sc.nextDouble();

                sc.nextLine();
            }

            System.out.print("Enter solar base value for daily generation (example 50): ");
            double solarBase = sc.nextDouble();

            System.out.print("Enter solar irradiance hours: ");
            double solarIrradianceHours = sc.nextDouble();

            System.out.print("Enter solar efficiency (example 0.18): ");
            double solarEfficiency = sc.nextDouble();

            System.out.print("Enter blade radius for wind output: ");
            double bladeRadius = sc.nextDouble();

            System.out.print("Enter average wind speed: ");
            double windSpeed = sc.nextDouble();

            System.out.print("Enter wind efficiency / Cp (example 0.42): ");
            double windEfficiency = sc.nextDouble();

            System.out.print("Enter transmission distance in km: ");
            double distanceKm = sc.nextDouble();

            System.out.print("Enter original asset cost: ");
            double originalCost = sc.nextDouble();

            SmartRenewableGrid grid = new SmartRenewableGrid(
                    facilityId, location, commissionedYear, operationalCost,
                    installedCapacityMW, currentLoad,
                    nominalVoltage, droop, thermalEfficiency,
                    zoneIds, zoneLoads,
                    batteryCapacityKWh, storedBatteryKWh);

            int yearsInService = Math.max(0, 2026 - commissionedYear);
            double dailyRenewableGeneration = grid.totalDailyRenewableGeneration(
                    solarBase, solarIrradianceHours, solarEfficiency,
                    bladeRadius, windSpeed, windEfficiency);

            double totalDemand = grid.totalZoneDemand();
            double transmissionLoss = grid.transmissionLoss(dailyRenewableGeneration, distanceKm);
            double netRenewableAfterLoss = Math.max(0.0, dailyRenewableGeneration - transmissionLoss);

            double initialBatteryLevel = grid.getStoredBatteryKWh();
            double excessEnergy = Math.max(0.0, netRenewableAfterLoss - totalDemand);
            double deficitEnergy = Math.max(0.0, totalDemand - netRenewableAfterLoss);

            if (dailyRenewableGeneration > totalDemand * 1.10) {
                grid.chargeBattery(excessEnergy);
            }

            double chargedEnergy = Math.max(0.0, grid.getStoredBatteryKWh() - initialBatteryLevel);
            double dischargedEnergy = Math.min(deficitEnergy, grid.getStoredBatteryKWh());
            grid.setStoredBatteryKWh(Math.max(0.0, grid.getStoredBatteryKWh() - dischargedEnergy));

            double[] balancedLoads = grid.buildBalancedLoadProfile();
            double totalBillingRevenue = grid.totalToUBillingRevenue();
            double totalDemandResponseSavings = grid.totalDemandResponseSavings(reducedKWhByZone);
            double carbonCredits = grid.carbonCredit(100.0, dailyRenewableGeneration);
            double depreciatedAssetValue = grid.depreciatedValue(originalCost, yearsInService);
            double dailyMaintenanceCost = grid.maintenanceCost(depreciatedAssetValue) / 365.0;
            double dailyDepreciationCost = (originalCost * 0.05) / 365.0;
            double netOperatingProfit = totalBillingRevenue + totalDemandResponseSavings - dailyMaintenanceCost - dailyDepreciationCost - operationalCost;
            double batteryCycleCount = grid.batteryCycles(chargedEnergy, dischargedEnergy);

            System.out.println();
            System.out.println(grid);
            System.out.printf("Generated Power (thermal model): %.2f MW%n", grid.generatePower(1.0));
            System.out.printf("Voltage After Regulation       : %.2f%n", grid.regulateVoltage(currentLoad));
            System.out.printf("Efficiency Rating              : %.2f%%%n", grid.efficiencyRating());
            System.out.printf("Daily Renewable Generation     : %.2f kWh%n", dailyRenewableGeneration);
            System.out.printf("Transmission Loss              : %.2f kWh%n", transmissionLoss);
            System.out.printf("Net Renewable After Loss       : %.2f kWh%n", netRenewableAfterLoss);
            System.out.printf("Total Demand                   : %.2f kWh%n", totalDemand);
            System.out.printf("Battery Level After Dispatch   : %.2f kWh%n", grid.getStoredBatteryKWh());
            System.out.printf("Battery Cycle Count            : %.2f%n", batteryCycleCount);
            System.out.printf("Total ToU Billing Revenue      : Rs. %.2f%n", totalBillingRevenue);
            System.out.printf("Demand Response Savings        : Rs. %.2f%n", totalDemandResponseSavings);
            System.out.printf("Carbon Credits Earned          : %.2f kg CO2%n", carbonCredits);
            System.out.printf("Depreciated Asset Value        : Rs. %.2f%n", depreciatedAssetValue);
            System.out.printf("Balanced Zone Loads            : %s%n", Arrays.toString(balancedLoads));
            System.out.printf("Net Operating Profit           : Rs. %.2f%n", netOperatingProfit);
        }
    }
}