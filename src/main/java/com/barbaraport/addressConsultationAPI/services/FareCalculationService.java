package com.barbaraport.addressConsultationAPI.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.barbaraport.addressConsultationAPI.enumerations.Zones;

@Service
public class FareCalculationService {
	
	private final Map<Zones, Collection<String>> zones = this.getZones();
	
	public double calculateFare(String federatedState) throws Exception {
		
		if (federatedState == null)
			throw new Exception("The federated state can not be null");
		
		String treatedFederatedState = federatedState.trim().strip().toUpperCase();
		
		if (treatedFederatedState.equals(""))
			throw new Exception("The federated state can not be empty");
		
		if (zones.get(Zones.SOUTH_EAST).contains(treatedFederatedState)) {
			return 7.85;
		}
		else if (zones.get(Zones.SOUTH).contains(treatedFederatedState)) {
			return 17.30;
		}
		else if (zones.get(Zones.MID_WEST).contains(treatedFederatedState)) {
			return 12.50;
		}
		else if (zones.get(Zones.NORTH_EAST).contains(treatedFederatedState)) {
			return 15.98;
		}
		else if (zones.get(Zones.NORTH).contains(treatedFederatedState)) {
			return 20.83;
		}
		
		throw new Exception("It was not possible to determine which zone the " + federatedState + " belongs to.");
	}
	
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
