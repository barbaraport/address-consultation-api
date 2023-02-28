package com.barbaraport.addressConsultationAPI.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.barbaraport.addressConsultationAPI.enumerations.Zones;

/**
 * this service is responsible for handling the fare calculations
 *
 * @author Port, B.
 */
@Service
public class FareCalculationService {

    /**
     * map loaded with the brazilian zones and the respective
     * federated states from each one of it
     */
    private final Map<Zones, Collection<String>> zones = this.getZones();

    /**
     * calculates the fare according to the received federated state
     *
     * @param federatedState the acronym from the federated state. examples: SP, RJ, ES.
     * @return the price from the fare to the given federated state
     * @throws Exception in case of an invalid federated state or in case of it could not be determined
     *                   (mistyped, for example)
     * @author Port, B.
     */
    public double calculateFare(String federatedState) throws Exception {

        if (federatedState == null)
            throw new Exception("The federated state cannot be null.");

        String treatedFederatedState = federatedState.trim().strip().toUpperCase();

        if (treatedFederatedState.equals(""))
            throw new Exception("The federated state cannot be empty.");

        if (zones.get(Zones.SOUTH_EAST).contains(treatedFederatedState)) {
            return 7.85;
        } else if (zones.get(Zones.SOUTH).contains(treatedFederatedState)) {
            return 17.30;
        } else if (zones.get(Zones.MID_WEST).contains(treatedFederatedState)) {
            return 12.50;
        } else if (zones.get(Zones.NORTH_EAST).contains(treatedFederatedState)) {
            return 15.98;
        } else if (zones.get(Zones.NORTH).contains(treatedFederatedState)) {
            return 20.83;
        }

        throw new Exception("It was not possible to determine which zone the " + federatedState + " belongs to.");
    }

    /**
     * loads a map with the zones (north, north-east, mid west, south-east and south
     *
     * @return a map to replace the content from the empty map
     * @author Port, B.
     */
    private Map<Zones, Collection<String>> getZones() {
        Map<Zones, Collection<String>> zones = new HashMap<>();

        zones.put(Zones.NORTH, new TreeSet<>(
                Arrays.asList("AM", "RR", "AP", "PA", "TO", "RO", "AC")
        ));

        zones.put(Zones.NORTH_EAST, new TreeSet<>(
                Arrays.asList("MA", "PI", "CE", "RN", "PE", "PB", "SE", "AL", "BA")
        ));

        zones.put(Zones.MID_WEST, new TreeSet<>(
                Arrays.asList("MT", "MS", "GO", "DF")
        ));

        zones.put(Zones.SOUTH_EAST, new TreeSet<>(
                Arrays.asList("SP", "RJ", "ES", "MG")
        ));

        zones.put(Zones.SOUTH, new TreeSet<>(
                Arrays.asList("PR", "RS", "SC")
        ));

        return zones;
    }

}
