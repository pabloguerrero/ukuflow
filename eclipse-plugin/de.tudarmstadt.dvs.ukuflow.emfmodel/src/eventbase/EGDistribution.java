/**
 */
package eventbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EG Distribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eventbase.EGDistribution#getTime <em>Time</em>}</li>
 *   <li>{@link eventbase.EGDistribution#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see eventbase.EventbasePackage#getEGDistribution()
 * @model
 * @generated
 */
public interface EGDistribution extends EGRecurring {
	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(int)
	 * @see eventbase.EventbasePackage#getEGDistribution_Time()
	 * @model
	 * @generated
	 */
	int getTime();

	/**
	 * Sets the value of the '{@link eventbase.EGDistribution#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(int value);

	/**
	 * Returns the value of the '<em><b>Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' attribute.
	 * @see #setFunction(int)
	 * @see eventbase.EventbasePackage#getEGDistribution_Function()
	 * @model
	 * @generated
	 */
	int getFunction();

	/**
	 * Sets the value of the '{@link eventbase.EGDistribution#getFunction <em>Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' attribute.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(int value);

} // EGDistribution
