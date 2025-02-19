/*
 * generated by Xtext 2.37.0
 */
package it.unibo.sensor.dsl.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import it.unibo.sensor.dsl.SensorDSLRuntimeModule;
import it.unibo.sensor.dsl.SensorDSLStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class SensorDSLIdeSetup extends SensorDSLStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new SensorDSLRuntimeModule(), new SensorDSLIdeModule()));
	}
	
}
