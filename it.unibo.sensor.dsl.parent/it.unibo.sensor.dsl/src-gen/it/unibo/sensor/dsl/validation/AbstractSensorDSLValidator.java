/*
 * generated by Xtext 2.37.0
 */
package it.unibo.sensor.dsl.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractSensorDSLValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(it.unibo.sensor.dsl.sensorDSL.SensorDSLPackage.eINSTANCE);
		return result;
	}
}
