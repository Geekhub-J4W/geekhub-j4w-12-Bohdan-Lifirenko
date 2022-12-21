package edu.geekhub.homework.domain;

import edu.geekhub.homework.client.LosesStatisticHttpClient;
import java.util.*;

/**
 * This class should contain data received through {@link LosesStatisticHttpClient}
 * via <a href="https://en.wikipedia.org/wiki/JSON">JSON</a> String
 */
public record LosesStatistic(int tanks,
                             int armouredFightingVehicles,
                             int cannons,
                             int multipleRocketLaunchers,
                             int antiAirDefenseDevices,
                             int planes,
                             int helicopters,
                             int drones,
                             int cruiseMissiles,
                             int shipsOrBoats,
                             int carsAndTankers,
                             int specialEquipment,
                             int personnel,
                             int id
                             ) {
    public static final Set<String> statisticItemsNames = new HashSet<String>() {
        {
            add("tanks");
            add("armouredFightingVehicles");
            add("cannons");
            add("multipleRocketLaunchers");
            add("antiAirDefenseDevices");
            add("planes");
            add("helicopters");
            add("drones");
            add("cruiseMissiles");
            add("shipsOrBoats");
            add("carsAndTankers");
            add("specialEquipment");
            add("personnel");
            add("id");
        }};

    public static final int numbersOfStatisticItems = statisticItemsNames.size();
    private static final String errorMassage = "Loses can't be negative";

    public LosesStatistic {
        checkFieldValue(tanks, errorMassage);
        checkFieldValue(armouredFightingVehicles, errorMassage);
        checkFieldValue(multipleRocketLaunchers, errorMassage);
        checkFieldValue(antiAirDefenseDevices, errorMassage);
        checkFieldValue(planes, errorMassage);
        checkFieldValue(helicopters, errorMassage);
        checkFieldValue(drones, errorMassage);
        checkFieldValue(cruiseMissiles, errorMassage);
        checkFieldValue(shipsOrBoats, errorMassage);
        checkFieldValue(carsAndTankers, errorMassage);
        checkFieldValue(specialEquipment, errorMassage);
        checkFieldValue(personnel, errorMassage);
        checkFieldValue(id, "ID can't be negative");

    }

    private void checkFieldValue(int integer, String errorMassage) {
        if (isNotPositiveInteger(integer)) {
            throw new IllegalArgumentException(errorMassage);
        }
    }

    private boolean isNotPositiveInteger(int integer) {
        return integer < 0;
    }

    public int id() {
        return id;
    }

    public List<StatisticItem> getStatisticItems() {
        List<StatisticItem> items = new ArrayList<>();

        items.add(new StatisticItem("tanks", tanks));
        items.add(new StatisticItem("armouredFightingVehicles", armouredFightingVehicles));
        items.add(new StatisticItem("cannons", cannons));
        items.add(new StatisticItem("multipleRocketLaunchers", multipleRocketLaunchers));
        items.add(new StatisticItem("antiAirDefenseDevices", antiAirDefenseDevices));
        items.add(new StatisticItem("planes", planes));
        items.add(new StatisticItem("helicopters", helicopters));
        items.add(new StatisticItem("drones", drones));
        items.add(new StatisticItem("cruiseMissiles", cruiseMissiles));
        items.add(new StatisticItem("shipsOrBoats", shipsOrBoats));
        items.add(new StatisticItem("carsAndTankers", carsAndTankers));
        items.add(new StatisticItem("specialEquipment", specialEquipment));
        items.add(new StatisticItem("personnel", personnel));

        return items;
    }
}
