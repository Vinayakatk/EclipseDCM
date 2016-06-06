/**
 */
package org.eclipse.docker.language.TableModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.docker.language.TableModel.TableModelFactory
 * @model kind="package"
 * @generated
 */
public interface TableModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "TableModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "www.tContainer.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tContainer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TableModelPackage eINSTANCE = org.eclipse.docker.language.TableModel.impl.TableModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.docker.language.TableModel.impl.TModelImpl <em>TModel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.docker.language.TableModel.impl.TModelImpl
	 * @see org.eclipse.docker.language.TableModel.impl.TableModelPackageImpl#getTModel()
	 * @generated
	 */
	int TMODEL = 0;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL__ENTRIES = 0;

	/**
	 * The number of structural features of the '<em>TModel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>TModel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.docker.language.TableModel.impl.CDataImpl <em>CData</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.docker.language.TableModel.impl.CDataImpl
	 * @see org.eclipse.docker.language.TableModel.impl.TableModelPackageImpl#getCData()
	 * @generated
	 */
	int CDATA = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDATA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDATA__STATUS = 1;

	/**
	 * The number of structural features of the '<em>CData</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDATA_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>CData</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDATA_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.docker.language.TableModel.TModel <em>TModel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TModel</em>'.
	 * @see org.eclipse.docker.language.TableModel.TModel
	 * @generated
	 */
	EClass getTModel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.docker.language.TableModel.TModel#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Entries</em>'.
	 * @see org.eclipse.docker.language.TableModel.TModel#getEntries()
	 * @see #getTModel()
	 * @generated
	 */
	EReference getTModel_Entries();

	/**
	 * Returns the meta object for class '{@link org.eclipse.docker.language.TableModel.CData <em>CData</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CData</em>'.
	 * @see org.eclipse.docker.language.TableModel.CData
	 * @generated
	 */
	EClass getCData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.docker.language.TableModel.CData#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.docker.language.TableModel.CData#getName()
	 * @see #getCData()
	 * @generated
	 */
	EAttribute getCData_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.docker.language.TableModel.CData#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.eclipse.docker.language.TableModel.CData#getStatus()
	 * @see #getCData()
	 * @generated
	 */
	EAttribute getCData_Status();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TableModelFactory getTableModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.docker.language.TableModel.impl.TModelImpl <em>TModel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.docker.language.TableModel.impl.TModelImpl
		 * @see org.eclipse.docker.language.TableModel.impl.TableModelPackageImpl#getTModel()
		 * @generated
		 */
		EClass TMODEL = eINSTANCE.getTModel();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODEL__ENTRIES = eINSTANCE.getTModel_Entries();

		/**
		 * The meta object literal for the '{@link org.eclipse.docker.language.TableModel.impl.CDataImpl <em>CData</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.docker.language.TableModel.impl.CDataImpl
		 * @see org.eclipse.docker.language.TableModel.impl.TableModelPackageImpl#getCData()
		 * @generated
		 */
		EClass CDATA = eINSTANCE.getCData();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CDATA__NAME = eINSTANCE.getCData_Name();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CDATA__STATUS = eINSTANCE.getCData_Status();

	}

} //TableModelPackage
