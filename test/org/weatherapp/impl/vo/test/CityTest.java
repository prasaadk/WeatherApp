package org.weatherapp.impl.vo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.weatherapp.impl.vo.City;

public class CityTest {
	
	@Test
	public void testGetterSetterWiring() throws Exception {
		String name = "Foo";
		assertEquals("should be equal", name, new City(name).getName());		
	}

	@Test
	public void testEqualsAndHashCode() {
		City cityFoo = new City("Foo");
		assertEquals("same instances should be equal", cityFoo, cityFoo);
		assertEquals("same instances should have same hashcode", cityFoo.hashCode(), cityFoo.hashCode());
		
		City cityBar = new City("Bar");
		assertFalse("should not be equal", cityFoo.equals(cityBar));
	}

}
