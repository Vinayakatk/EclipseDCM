/**
 */
package org.eclipse.docker.language.TableModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TModel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.docker.language.TableModel.TModel#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @see org.eclipse.docker.language.TableModel.TableModelPackage#getTModel()
 * @model
 * @generated
 */
public interface TModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.docker.language.TableModel.CData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' reference list.
	 * @see org.eclipse.docker.language.TableModel.TableModelPackage#getTModel_Entries()
	 * @model
	 * @generated
	 */
	EList<CData> getEntries();

} // TModel
