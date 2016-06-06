/**
 */
package org.eclipse.docker.language.TableModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.docker.language.TableModel.TableModelPackage
 * @generated
 */
public interface TableModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TableModelFactory eINSTANCE = org.eclipse.docker.language.TableModel.impl.TableModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>TModel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TModel</em>'.
	 * @generated
	 */
	TModel createTModel();

	/**
	 * Returns a new object of class '<em>CData</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CData</em>'.
	 * @generated
	 */
	CData createCData();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TableModelPackage getTableModelPackage();

} //TableModelFactory
