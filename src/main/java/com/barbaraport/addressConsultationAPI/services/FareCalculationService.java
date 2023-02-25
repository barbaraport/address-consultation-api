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
	
	private Map<Zones, Collection<String>> zones = this.getZones();
	
	public double calculateFare(String federativeUnit) throws Exception {
		
		if (federativeUnit == null)
			throw new Exception("The federative unit can not be null");
		
		if (federativeUnit.trim().strip().equals(""))
			throw new Exception("The federative unit can not be empty"); 
		
		String treatedFederativeUnit = federativeUnit.trim().toUpperCase();
		
		if (zones.get(Zones.SOUTH_EAST).contains(treatedFederativeUnit)) {
			return 7.85;
		}
		else if (zones.get(Zones.SOUTH).contains(treatedFederativeUnit)) {
			return 17.30;
		}
		else if (zones.get(Zones.MID_WEST).contains(treatedFederativeUnit)) {
			return 12.50;
		}
		else if (zones.get(Zones.NORTH_EAST).contains(treatedFederativeUnit)) {
			return 15.98;
		}
		else if (zones.get(Zones.NORTH).contains(treatedFederativeUnit)) {
			return 20.83;
		}
		
		throw new Exception("It was not possible to determine which zone the " + federativeUnit + " belongs to.");
	}
	
	private Map<Zones, Collection<String>> getZones() {
		Map<Zones, Collection<String>> zones = new HashMap<Zones, Collection<String>>();
		
		zones.put(Zones.NORTH, new TreeSet<String>(
				Arrays.asList(new String[]{"AM", "RR", "AP", "PA", "TO", "RO", "AC"})
		));
		
		zones.put(Zones.NORTH_EAST, new TreeSet<String>(
				Arrays.asList(new String[]{"MA", "PI", "CE", "RN", "PE", "PB", "SE", "AL", "BA"})
		));
		
		zones.put(Zones.MID_WEST, new TreeSet<String>(
				Arrays.asList(new String[]{"MT", "MS", "GO", "DF"})
		));
		
		zones.put(Zones.SOUTH_EAST, new TreeSet<String>(
				Arrays.asList(new String[]{"SP", "RJ", "ES", "MG"})
		));
		
		zones.put(Zones.SOUTH, new TreeSet<String>(
				Arrays.asList(new String[]{"PR", "RS", "SC"})
		));
		
		return zones;
	}

}
