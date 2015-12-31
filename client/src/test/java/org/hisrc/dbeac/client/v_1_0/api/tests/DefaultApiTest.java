package org.hisrc.dbeac.client.v_1_0.api.tests;

import java.util.Arrays;
import java.util.List;

import org.hisrc.dbeac.client.v_1_0.api.DefaultApi;
import org.hisrc.dbeac.client.v_1_0.invoker.ApiException;
import org.hisrc.dbeac.client.v_1_0.model.Facility;
import org.hisrc.dbeac.client.v_1_0.model.Station;
import org.junit.Assert;
import org.junit.Test;

public class DefaultApiTest {

	@Test
	public void findsAllFacilities() throws ApiException {
		final DefaultApi api = new DefaultApi();
		final List<Facility> allFacilities = api.findFacilities(null, null);
		Assert.assertFalse("List of facilities must not be empty.",
				allFacilities.isEmpty());
	}

	@Test
	public void findsActiveElevatorFacilities() throws ApiException {
		final DefaultApi api = new DefaultApi();
		final List<Facility> findFacilities = api.findFacilities(
				Arrays.asList(Facility.TypeEnum.ELEVATOR.toString()),
				Arrays.asList(Facility.StateEnum.ACTIVE.toString()));
		Assert.assertFalse(
				"List of active elevator facilities must not be empty.",
				findFacilities.isEmpty());
	}

	@Test
	public void getsFacilityByEquipmentNumber() throws ApiException {
		final DefaultApi api = new DefaultApi();
		final Facility facility = api.getFacilityByEquipmentNumber(10110110L);
		Assert.assertNotNull("Facility could not be found.", facility);
		Assert.assertEquals("Wrong facility found.", "Aufzug zu Gleis 7/8",
				facility.getDescription());
	}

	@Test
	public void findsStationByStationNumber() throws ApiException {
		final DefaultApi api = new DefaultApi();
		final Station station = api.findStationByStationNumber(3925L);
		Assert.assertNotNull("Station could not be found.", station);
		Assert.assertEquals("Wrong station found", "Mannheim Hbf",
				station.getName());
	}
}
